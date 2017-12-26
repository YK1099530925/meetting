package com.yk.dao;

import com.yk.pojo.MeettingInfo;
import com.yk.pojo.MeettingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeettingInfoMapper {
    long countByExample(MeettingInfoExample example);

    int deleteByExample(MeettingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MeettingInfo record);

    int insertSelective(MeettingInfo record);

    List<MeettingInfo> selectByExample(MeettingInfoExample example);

    MeettingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MeettingInfo record, @Param("example") MeettingInfoExample example);

    int updateByExample(@Param("record") MeettingInfo record, @Param("example") MeettingInfoExample example);

    int updateByPrimaryKeySelective(MeettingInfo record);

    int updateByPrimaryKey(MeettingInfo record);
}