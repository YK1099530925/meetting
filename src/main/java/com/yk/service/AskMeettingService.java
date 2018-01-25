package com.yk.service;

import java.io.IOException;
import java.util.ArrayList;
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
			onlineUsers.get(managerid.toString()).getBasicRemote().sendText("经理您好：您有一条会议需要处理");
			//设置flag为0，表示已经提示
			//通过meettingid查找申请发布的消息然后设置其flag=0，表示已经提示
			myAskMessageMapper.setAskMeettingManagerFlag(0,meettingid);
			return "0";
		}
		//设置flag为1，表示未提示
		myAskMessageMapper.setAskMeettingManagerFlag(1, meettingid);
		
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

	/**
	 * 设置申请的会议的各个标志，根据是否同意申请与是否在线设置不同标志
	 * @param askMeettingId
	 * @param agree
	 * @param userFlag
	 */
	public void setAskMeettingSign(Integer askMeettingId, Integer agree, Integer userFlag) {
		myAskMessageMapper.setAskMeettingSign(askMeettingId,agree,userFlag);
	}

	/**
	 * 设置askMeetting的managerFlag
	 * @param loginId
	 * @param i
	 */
	public void setManagerFlag(Integer loginId, Integer managerFlag) {
		myAskMessageMapper.setManagerFlag(loginId,managerFlag);
	}

	/**
	 * 获取申请会议的结果，如果有未通知的，将消息通知用户，并设置其userFlag=0
	 * @param loginId
	 * @return
	 */
	public String getAskMeettingResult(Integer loginId) {
		String meettingResult = "";
		List<AskMessage> meettingResultList = myAskMessageMapper.getAskMeettingResult(loginId);
		if(meettingResultList.size() != 0) {
			//有未通知的申请消息
			for(int i = 0; i < meettingResultList.size(); i++) {
				if(meettingResultList.get(i).getAgree() == 1) {
					meettingResult += "标题：" + meettingResultList.get(i).getTitle() + "  申请结果：已同意-";
				}else {
					meettingResult += "标题：" + meettingResultList.get(i).getTitle() + "  申请结果：被反对-";
				}
			}
			meettingResult = meettingResult.substring(0, meettingResult.length()-1);
			//以上已经拿到会议处理结果，并给员工通知，因此将userFlag设置为0
			myAskMessageMapper.setAskMeettingUserFlag(0,loginId);
			return meettingResult;
		}
		return meettingResult;
	}

	public String deleteAskMeetting(List<Integer> meettingIdList) {
		//统计不能被删除的会议id
		List<Integer> canNotDeleteMeettingIds = new ArrayList<Integer>();
		//不能被删除会议的信息
		String canNotDeleteMeetting = "";
		//删除申请的会议，判断是否已经处理和通知员工：agree！=2 and userFlag = 0
		//通过会议id查询是否可以被删除
		for(int i = 0; i < meettingIdList.size(); i++) {
			//查询userFlag=0 and agree！=2，如果存在，则可以删除，否则不能删除
			AskMessage askMessage = myAskMessageMapper.isNotCanDelete(meettingIdList.get(i));
			if(askMessage != null) {
				myAskMessageMapper.deleteAskMeetting(meettingIdList.get(i));
			}else {
				canNotDeleteMeettingIds.add(meettingIdList.get(i));
			}
		}
		if(canNotDeleteMeettingIds.size() != 0) {
			canNotDeleteMeetting = "DELETESOME";
		}else {
			canNotDeleteMeetting = "DELETEALL";
		}
		return canNotDeleteMeetting;
	}
	
	
}
