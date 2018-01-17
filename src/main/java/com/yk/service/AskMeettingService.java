package com.yk.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.controller.WebSocketController;
import com.yk.dao.AskMessageMapper;
import com.yk.dao.MyAskMessageMapper;
import com.yk.pojo.AskMessage;

import net.sf.json.JSONObject;

@Service
public class AskMeettingService {
	
	@Autowired
	MyAskMessageMapper myAskMessageMapper;
	
	@Autowired
	AskMessageMapper askMessageMapper;

	/**
	 * 保存请求会议的信息
	 * @param messageJson
	 * @param deptid
	 * @param managerid
	 */
	public String saveAskMeetting(JSONObject messageJson, Integer userid, Integer deptid, Integer managerid) {
		AskMessage askMessage = new AskMessage();
		askMessage.setDeptid(deptid);
		askMessage.setAskuserid(userid);
		askMessage.setManagerid(managerid);
		askMessage.setMeettingid(messageJson.getInt("meettingid"));
		askMessage.setTitle(messageJson.getString("title"));
		askMessage.setProfile("开会");
		askMessage.setInfomation(messageJson.getString("meettingInfo"));
		askMessage.setAskusername(messageJson.getString("releaseUser"));
		//设置标志信息
		//userflag=2表示还未通知用户，当变为1的时候表示推送给用户的时候用户不在线，当为0的时候，表示用户已经接受到通知
		askMessage.setUserflag(2);
		//agree=2表示还没有处理，1表示为同一，0表示不同意
		askMessage.setAgree(2);
		
		//保存请求信息
		askMessageMapper.insert(askMessage);
		
		return "success";
	}

	/**
	 * 获取本部门经理的id
	 * @return
	 */
	public Integer getManagerId(Integer deptid) {
		Integer managerid = myAskMessageMapper.getManagerId(deptid);
		return managerid;
	}

	/**
	 * 申请的会议保存成功后，通知经理有会议请求来了
	 * @throws IOException 
	 */
	public String notifyManager(Integer managerid, Integer meettingid) throws IOException {
		//获取在线用户
		Map<String, Session> onlineUsers = WebSocketController.userWebsocket;
		//判断经理是否在线即经理的id是否在在线用户中
		if(onlineUsers.containsKey(managerid.toString())) {
			//给经理发送提示信息
			onlineUsers.get(managerid.toString()).getBasicRemote().sendText("有一条会议发布请求信息");
			//设置flag为0，表示已经提示
			//通过meettingid查找申请发布的消息然后设置其flag
			myAskMessageMapper.setAskMeettingFlag(0,meettingid);
			return "0";
		}
		//设置flag为1，表示为提示
		myAskMessageMapper.setAskMeettingFlag(1, meettingid);
		
		return "1";		
	}

	public int isHasManagerFlag(Integer loginId) {
		int count = myAskMessageMapper.isHasManagerFlag(loginId);
		return count;
	}

	/**
	 * 查询申请的会议信息
	 * @param loginId
	 * @return
	 */
	public List<AskMessage> getAllAskMeettingInfo(Integer loginId) {
		return myAskMessageMapper.getAllAskMeettingInfo(loginId);
	}
	
	
}
