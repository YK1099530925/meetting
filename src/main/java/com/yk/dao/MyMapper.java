package com.yk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yk.pojo.MeettingGroup;
import com.yk.pojo.MeettingInfo;

public interface MyMapper {
	List<Integer> getOneDeptAllUserId(Integer deptId);
	
	int updateMeettingGroupFlag(Integer userId);
	
	MeettingInfo getOneMeettingInfo(Integer loginId);

	int setUnRead(@Param("meettingid")Integer meettingid, @Param("loginId")Integer loginId);
	
	List<MeettingGroup> getMyMessage(Integer loginId);
}
