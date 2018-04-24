package com.yk.dao;

import com.yk.pojo.MeettingRoom;

public interface MyMeettingRoomMapper {

	MeettingRoom getMeettingRoomInfo(Integer meettingid);

	void updateSeat(MeettingRoom meettingRoom);

}
