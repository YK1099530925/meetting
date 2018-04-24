package com.yk.dao;

import com.yk.pojo.MeettingRoom;
import com.yk.pojo.MeettingRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeettingRoomMapper {
    long countByExample(MeettingRoomExample example);

    int deleteByExample(MeettingRoomExample example);

    int insert(MeettingRoom record);

    int insertSelective(MeettingRoom record);

    List<MeettingRoom> selectByExample(MeettingRoomExample example);

    int updateByExampleSelective(@Param("record") MeettingRoom record, @Param("example") MeettingRoomExample example);

    int updateByExample(@Param("record") MeettingRoom record, @Param("example") MeettingRoomExample example);
}