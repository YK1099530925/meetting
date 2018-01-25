package com.yk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yk.pojo.AskMessage;

public interface MyAskMessageMapper {

	Integer getManagerId(Integer deptid);

	int setAskMeettingManagerFlag(@Param("managerFlag")Integer managerFlag, @Param("meettingid")Integer meettingid);

	int isHasManagerFlag(Integer loginId);

	List<AskMessage> getAllAskMeettingInfo(Integer loginId);

	void setAskMeettingSign(@Param("askMeettingId")Integer askMeettingId, @Param("agree")Integer agree, @Param("userFlag")Integer userFlag);

	int setManagerFlag(@Param("loginId")Integer loginId, @Param("managerFlag")Integer managerFlag);

	List<AskMessage> getAskMeettingResult(Integer AskUserId);

	int setAskMeettingUserFlag(@Param("userFlag")Integer userFlag, @Param("askUserId")Integer askUserId);

	AskMessage isNotCanDelete(Integer meettingid);
	
	void deleteAskMeetting(Integer meettingid);

	AskMessage getCanNotDeleteMeettingInfo(Integer meettingid);

}
