package com.yk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yk.pojo.MeettingGroup;
import com.yk.pojo.MeettingInfo;
import com.yk.pojo.User;

public interface MyMapper {
	List<Integer> getOneDeptAllUserId(Integer deptId);
	
	int updateMeettingGroupFlag(Integer userId);
	
	MeettingInfo getOneMeettingInfo(Integer meettingId);

	int setUnRead(@Param("meettingid")Integer meettingid, @Param("loginId")Integer loginId);
	
	List<MeettingGroup> getMyMessage(Integer loginId);
	
	int getMyFlagCount(Integer loginId);
	
	int setMyFlagCount(Integer loginId);

	int deleteMeetting(@Param("meettingId")Integer meettingId, @Param("loginId")Integer loginId);

	List<String> getPermissionListByLoginId(Integer loginid);
}
