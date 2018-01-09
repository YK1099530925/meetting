package com.yk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.dao.MyMapper;
import com.yk.pojo.MeettingGroup;
import com.yk.pojo.MeettingInfo;
import com.yk.service.MeettingService;
import com.yk.service.WebsocketService;
import com.yk.utils.ToJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class MeetingController {

	@Autowired
	MeettingService meettingService;

	@Autowired
	MyMapper myMapper;

	@Autowired
	WebsocketService websocketService;

	/**
	 * 发布会议 1：保存会议 2：给线上员工提示 3：给消息表中设置标志
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/messageInfo")
	@ResponseBody
	public String messageInfo(String message) throws IOException {
		// 将字符串解析为json
		JSONObject messageJson = JSONObject.fromObject(message);
		// 保存会议信息
		meettingService.saveMeettingInfo(messageJson);
		// 从user表中拿到对应部们人的id(先固定deptid=1)
		List<Integer> userIds = myMapper.getOneDeptAllUserId(1);
		// 将刚刚添加的信息放到消息表中（消息表：员工登录的时候需要查询是否存在未读信息）
		meettingService.insertMeettingGrup(Integer.parseInt(messageJson.getString("meettingid")), 1, userIds);
		// 将会议消息推送到在线用户，并设置已推送用户的flag标志为0
		websocketService.sendOnlineUser(userIds);

		return "success";
	}

	/**
	 * 当会议发布成功后，发送Ajax请求获取发布的会议，并将发布者的unread设置为0
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getOneMeettingInfo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getOneMeettingInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 获取当前用户（即发布会议的用户的id，然后获取其发布的会议）
		Integer loginId = (Integer) session.getAttribute("loginId");
		// 通过数据库查询自己所发布的会议
		MeettingInfo oneMeettingInfo = meettingService.getOneMeettingInfo(loginId);
		// 获取当前设置的会议id，并将发布会议人的unread设置为0
		meettingService.setUnRead(oneMeettingInfo.getMeettingid(), loginId);
		JSONObject jsonObject = JSONObject.fromObject(oneMeettingInfo);
		System.out.println("我发布的会议:" + jsonObject);
		return jsonObject.toString();
	}

	/**
	 * 获取个人的所有会议信息
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value="/getMyMessage",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getMyMessage(Integer loginId) {
		System.out.println("查看"+loginId+"此人是否存在unread=1的会议");
		JSONArray myMessage = meettingService.getMyMessage(loginId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", myMessage.toString());
		System.out.println("jsonobject:" + jsonObject);
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/setUnread")
	@ResponseBody
	public String setUnread(Integer meettingid,Integer loginId) {
		meettingService.setUnRead(meettingid, loginId);
		return "";
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String test(String message) {
		return "success";
	}
}
