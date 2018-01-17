package com.yk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yk.dao.MeettingGroupMapper;
import com.yk.dao.MeettingInfoMapper;
import com.yk.dao.MyMapper;
import com.yk.pojo.MeettingGroup;
import com.yk.pojo.MeettingGroupExample;
import com.yk.pojo.MeettingGroupExample.Criteria;
import com.yk.pojo.MeettingInfo;
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
		meettingInfo.setAddr("会议室1");
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
	
	//通过消息组表，查询刚刚所发布的会议
	public MeettingInfo getOneMeettingInfo(Integer meettingId){
		//正确的做法：直接从前端传送会议id过来，查询出这一条消息，然后将自己的unread设置为0
		MeettingInfo oneMeettingInfo=myMapper.getOneMeettingInfo(meettingId);
		return oneMeettingInfo;
	}

	//设置会议信息为已读
	public void setUnRead(Integer meettingid, Integer loginId) {
		myMapper.setUnRead(meettingid, loginId);
	}

	//得到我的会议信息
	public List<MeettingGroup> getMyMessage(Integer loginId) {
		List<MeettingGroup> myMessage = myMapper.getMyMessage(loginId);
		return myMessage;
	}
	
	//批量删除会议
	public void deleteMeetting(List<Integer> meettingIdList, Integer loginId) {
		 /*//问题：这样删除会遇见外键约束，如何解决？
		  * //创造条件
		MeettingGroupExample example = new MeettingGroupExample();
		//条件的准则
		Criteria criteria = example.createCriteria();
		//添加准则，以meettingids为准则删除
		criteria.andMeettingidIn(meettingIdList);
		//根据条件删除
		meettingGroupMapper.deleteByExample(example);*/
		for (Integer meettingId : meettingIdList) {
			myMapper.deleteMeetting(meettingId,loginId);
		}
	}
}
