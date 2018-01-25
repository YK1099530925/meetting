package com.yk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yk.dao.MyMapper;
import com.yk.pojo.MeettingGroup;
import com.yk.pojo.MeettingInfo;
import com.yk.service.MeettingService;
import com.yk.service.WebsocketService;
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
	 * 1:发布会议 1：保存会议 2：给在线员工提示 3：给消息表中设置标志
	 * 2:申请会议成功，然后也通过此方法发送
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/messageInfo")
	@ResponseBody
	public String messageInfo(String message,Integer loginId) throws IOException {
		// 将字符串解析为json
		JSONObject messageJson = JSONObject.fromObject(message);
		// 保存会议信息
		meettingService.saveMeettingInfo(messageJson);
		// 从user表中拿到对应部们人的loginid(先固定deptid=1)
		List<Integer> userIds = myMapper.getOneDeptAllUserId(messageJson.getInt("deptId"));
		// 将刚刚添加的信息放到消息表中（消息表：员工登录的时候需要查询是否存在未提示信息）
		meettingService.insertMeettingGrup(Integer.parseInt(messageJson.getString("meettingid")), 1, userIds);
		// 将会议消息推送到在线用户，并设置已推送用户的flag标志为0
		websocketService.sendOnlineUser(userIds,loginId);

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
	public String getOneMeettingInfo(Integer meettingId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 获取当前用户（即发布会议的用户的id，然后获取其发布的会议）
		Integer loginId = (Integer) session.getAttribute("loginId");
		// 通过数据库查询自己所发布的会议
		MeettingInfo oneMeettingInfo = meettingService.getOneMeettingInfo(meettingId);
		// 获取当前设置的会议id，并将发布会议人的unread设置为0
		meettingService.setUnRead(meettingId, loginId);
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
	public String getMyMessage(Integer loginId, Integer pageNum) {
		System.out.println("pageNum:" + pageNum);
		//设置每页显示5条记录
		PageHelper.startPage(pageNum, 5);
		//startPage后紧跟的查询就是一个分页查询
		List<MeettingGroup> myMessage = meettingService.getMyMessage(loginId);
		PageInfo pageInfo = new PageInfo(myMessage, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		System.out.println("我的会议信息:" + jsonObject);
		return jsonObject.toString();
	}
	
	/**
	 * 将unread设置为0，已读状态
	 * @param meettingid
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value="/setUnread")
	@ResponseBody
	public String setUnread(Integer meettingid,Integer loginId) {
		meettingService.setUnRead(meettingid, loginId);
		return "";
	}
	
	/**
	 * 删除个人会议信息
	 * @param meettingIds
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleteMeetting/{meettingIds}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteMeetting(@PathVariable("meettingIds")String meettingIds,HttpServletRequest request) {
		Integer loginId = (Integer) request.getSession().getAttribute("loginId");
		List<Integer> meettingIdList = new ArrayList<Integer>();
		if(meettingIds.contains("-")) {
			String[] meettingIdStrArray = meettingIds.split("-");
			for (String mIdString : meettingIdStrArray) {
				meettingIdList.add(Integer.parseInt(mIdString));
			}
		}else {
			meettingIdList.add(Integer.parseInt(meettingIds));
		}
		meettingService.deleteMeetting(meettingIdList,loginId);
		return "success";
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String test(String message) {
		return "success";
	}
}
