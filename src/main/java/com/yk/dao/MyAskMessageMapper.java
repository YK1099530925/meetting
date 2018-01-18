package com.yk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yk.pojo.AskMessage;

public interface MyAskMessageMapper {

	Integer getManagerId(Integer deptid);

	int setAskMeettingFlag(@Param("flag")Integer flag, @Param("meettingid")Integer meettingid);

	int isHasManagerFlag(Integer loginId);

	List<AskMessage> getAllAskMeettingInfo(Integer loginId);

	void setAskMeettingSign(@Param("askMeettingId")Integer askMeettingId, @Param("agree")Integer agree, @Param("userFlag")Integer userFlag);

}
