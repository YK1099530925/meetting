package com.yk.dao;

import com.yk.pojo.MeettingGroup;
import com.yk.pojo.MeettingGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeettingGroupMapper {
    long countByExample(MeettingGroupExample example);

    int deleteByExample(MeettingGroupExample example);

    int insert(MeettingGroup record);

    int insertSelective(MeettingGroup record);

    List<MeettingGroup> selectByExample(MeettingGroupExample example);

    int updateByExampleSelective(@Param("record") MeettingGroup record, @Param("example") MeettingGroupExample example);

    int updateByExample(@Param("record") MeettingGroup record, @Param("example") MeettingGroupExample example);
}