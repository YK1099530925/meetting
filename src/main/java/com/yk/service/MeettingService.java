package com.yk.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.controller.WebSocketController;
import com.yk.dao.MeettingGroupMapper;
import com.yk.dao.MeettingInfoMapper;
import com.yk.dao.MyMapper;
import com.yk.pojo.MeettingGroup;
import com.yk.pojo.MeettingInfo;
import com.yk.utils.ToJson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class MeettingService {
	
	@Autowired
	MeettingInfoMapper meettingInfoMapper;
	
	@Autowired
	MeettingGroupMapper meettingGroupMapper;
	
	@Autowired
	MyMapper myMapper;
	

	public void saveMeettingInfo(JSONObject messageJson) {
		MeettingInfo meettingInfo = new MeettingInfo();
		Integer meettingid = Integer.parseInt(messageJson.getString("meettingid"));
		meettingInfo.setTitle(messageJson.getString("title"));
		meettingInfo.setInfomation(messageJson.getString("meettingInfo"));
		meettingInfo.setMeettingid(meettingid);
		meettingInfo.setAddr("四川");
		meettingInfo.setDeptid(1);
		meettingInfo.setMeettingtime(new Date());
		meettingInfo.setProfile("开会");
		meettingInfo.setReleaseuser(messageJson.getString("releaseUser"));
		//保存会议信息
		meettingInfoMapper.insert(meettingInfo);
	}

	//给消息表添加数据，先设置表中flag标志和read标志为1，如果已经推送过的设置其flag=0，如果在前端已读的用户设置read=0
	public void insertMeettingGrup(Integer meettingid, Integer deptid, List<Integer> userIds) {
		MeettingGroup meettingGroup = new MeettingGroup();
		for(int i = 0; i < userIds.size(); i++) {
			meettingGroup.setMeettingid(meettingid);
			meettingGroup.setDeptid(deptid);
			meettingGroup.setUserid(userIds.get(i));
			meettingGroup.setFlag(1);
			meettingGroup.setUnread(1);
			meettingGroupMapper.insert(meettingGroup);
		}
	}
	
	//通过消息组表，查询刚刚所发布的会议（因为自己发的，所以标志为0，但未读消息标志unread为1，查询完之后，设置unread为0）
	public MeettingInfo getOneMeettingInfo(Integer loginId){
		//通过loginId，flag，unread唯一定位一条消息id，就能查到自己刚刚所发会议
		MeettingInfo oneMeettingInfo = myMapper.getOneMeettingInfo(loginId);
		return oneMeettingInfo;
	}

	//设置会议信息为已读
	public void setUnRead(Integer meettingid, Integer loginId) {
		myMapper.setUnRead(meettingid, loginId);
	}

	//得到我的会议信息
	public JSONArray getMyMessage(Integer loginId) {
		List<MeettingGroup> myMessage = myMapper.getMyMessage(loginId);
		JSONArray jsonArray = new JSONArray();
		for (MeettingGroup meettingGroup : myMessage) {
			jsonArray.add(meettingGroup);
		}
		return jsonArray;
	}
}
