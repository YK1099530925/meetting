package com.yk.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yk.pojo.AskMessage;
import com.yk.pojo.User;
import com.yk.service.AskMeettingService;

import net.sf.json.JSONObject;

@Controller
public class AskMeettingController {

	@Autowired
	AskMeettingService askMeettingService;

	/**
	 * 会议发布请求
	 * 
	 * @param message
	 * @param loginId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/askMeetting")
	@ResponseBody
	public String askMeetting(String message, Integer loginId, HttpServletRequest request) throws IOException {
		// 从session中获取用户的信息
		User user = (User) request.getSession().getAttribute("user");
		Integer userid = user.getLoginid();
		// 获取用户的deptid
		Integer deptid = user.getDeptid();
		// 获取本部门经理的id
		Integer managerid = askMeettingService.getManagerId(deptid);
		// 将请求发布的会议保存在askmessage表中
		JSONObject messageJson = JSONObject.fromObject(message);
		String saveAskMeetting = askMeettingService.saveAskMeetting(messageJson, userid, deptid, managerid);
		// 如果保存成功
		if (saveAskMeetting.equals("success")) {
			// 通知经理有会议请求来临
			String notifyManager = askMeettingService.notifyManager(managerid, messageJson.getInt("meettingid"));
			//下面只是打印经理是否在线
			if (notifyManager.equals("0")) {
				System.out.println("经理在线");
			} else {
				System.out.println("经理不在线");
			}
		}
		return "success";
	}

	/**
	 * 获取所有会议请求信息
	 * 
	 * @param loginId
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value = "/getAllAskMeettingInfo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getAllAskMeettingInfo(Integer loginId, Integer pageNum) {
		// 每页显示5条记录
		PageHelper.startPage(pageNum, 5);
		// 其后跟的查询为一个分页查询
		List<AskMessage> askMessages = askMeettingService.getAllAskMeettingInfo(loginId);
		PageInfo pageInfo = new PageInfo(askMessages, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		System.out.println("申请的会议信息:" + jsonObject);
		return jsonObject.toString();
	}

	@RequestMapping(value = "/isOrAgreeAskMeetting")
	@ResponseBody
	public String isOrAgreeAskMeetting(Integer agree, Integer askMeettingId, Integer askUserId) throws IOException {
		Integer userFlag = 2;
		//agree:1：表示同意；0：表示反对
		//判断此申请人是否在线，在线则通知
		Map<String, Session> onlineUsers = WebSocketController.userWebsocket;
		if(onlineUsers.containsKey(askUserId.toString())) {
			//在线的情况，用户标志为0，表示已通知
			userFlag = 0;
			Session askUser = onlineUsers.get(askUserId.toString());
			if(agree == 1) {
				askUser.getBasicRemote().sendText("你申请的会议已成功被发布");
			}else {
				askUser.getBasicRemote().sendText("你申请的会议已被拒绝");
			}
		}else {
			//不在线的情况，用户标志为1，表示未通知
			userFlag = 1;
		}
		//设置申请会议的标志
		askMeettingService.setAskMeettingSign(askMeettingId,agree,userFlag);
		return "";
	}
}
