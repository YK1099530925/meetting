package com.yk.dao;

import com.yk.pojo.AskMessage;
import com.yk.pojo.AskMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AskMessageMapper {
    long countByExample(AskMessageExample example);

    int deleteByExample(AskMessageExample example);

    int insert(AskMessage record);

    int insertSelective(AskMessage record);

    List<AskMessage> selectByExample(AskMessageExample example);

    int updateByExampleSelective(@Param("record") AskMessage record, @Param("example") AskMessageExample example);

    int updateByExample(@Param("record") AskMessage record, @Param("example") AskMessageExample example);
}