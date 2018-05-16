package com.yk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dao.MeettingRoomMapper;
import com.yk.dao.MyMeettingRoomMapper;
import com.yk.pojo.MeettingRoom;

@Service
public class SeatService {

	@Autowired
	MeettingRoomMapper meettingRoomMapper;
	
	@Autowired
	MyMeettingRoomMapper myMeettingRoomMapper;
	
	public void setSeat(Integer meettingid, int seat, Integer loginId) {
		MeettingRoom meettingRoom = new MeettingRoom();
		meettingRoom.setMeettingid(meettingid);
		meettingRoom.setSeat0(loginId);
		meettingRoomMapper.insert(meettingRoom);
	}

	public void updateChooseSeat(MeettingRoom meettingRoom, String oldSeat, String newSeat, Integer loginid) {
		//将oldSeat和newSeat末尾数字提取判断应该修改哪一个
		char oldSeatNumber = oldSeat.charAt(oldSeat.length() - 1);
		char newSeatNumber = newSeat.charAt(newSeat.length() - 1);
		//将原位置删除
		switch (oldSeatNumber) {
		case '0':meettingRoom.setSeat0(0);
			break;
		case '1':meettingRoom.setSeat1(0);
			break;
		case '2':meettingRoom.setSeat2(0);
			break;
		case '3':meettingRoom.setSeat3(0);
			break;
		case '4':meettingRoom.setSeat4(0);
			break;
		case '5':meettingRoom.setSeat5(0);
			break;
		case '6':meettingRoom.setSeat6(0);
			break;
		case '7':meettingRoom.setSeat7(0);
			break;
		case '8':meettingRoom.setSeat8(0);
			break;
		case '9':meettingRoom.setSeat9(0);
			break;
		default:
			break;
		}
		//设置新位置
		switch (newSeatNumber) {
		case '0':meettingRoom.setSeat0(loginid);
			break;
		case '1':meettingRoom.setSeat1(loginid);
			break;
		case '2':meettingRoom.setSeat2(loginid);
			break;
		case '3':meettingRoom.setSeat3(loginid);
			break;
		case '4':meettingRoom.setSeat4(loginid);
			break;
		case '5':meettingRoom.setSeat5(loginid);
			break;
		case '6':meettingRoom.setSeat6(loginid);
			break;
		case '7':meettingRoom.setSeat7(loginid);
			break;
		case '8':meettingRoom.setSeat8(loginid);
			break;
		case '9':meettingRoom.setSeat9(loginid);
			break;
		default:
			break;
		}
		//修改位置
		myMeettingRoomMapper.updateSeat(meettingRoom);
	}


}
