package com.yk.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yk.dao.MyMapper;
import com.yk.pojo.File;
import com.yk.pojo.MeettingGroup;
import com.yk.pojo.MeettingInfo;
import com.yk.pojo.MeettingRoom;
import com.yk.service.FileService;
import com.yk.service.MeettingService;
import com.yk.service.WebsocketService;
import net.sf.json.JSONObject;

@Controller
public class MeetingController {
	
	@Autowired
	FileService fileService;

	@Autowired
	MeettingService meettingService;

	@Autowired
	MyMapper myMapper;

	@Autowired
	WebsocketService websocketService;
	
	/**
	 * 1:发布会议 1：保存会议 2：给在线员工提示 3：给消息表中设置标志
	 * 2:申请会议成功，然后也通过此方法发送
	 * 
	 * @param message
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/messageInfo")
	@ResponseBody
	public String messageInfo(String message,Integer loginId) throws IOException {
		System.out.println("message:" + message);
		// 将字符串解析为json
		JSONObject messageJson = JSONObject.fromObject(message);
		System.out.println("开始保存会议信息");
		// 保存会议信息
		meettingService.saveMeettingInfo(messageJson);
		System.out.println("将上传的文件保存在文件表中");
		// 将上传的文件保存在文件表中
		fileService.uploadFile(messageJson);
		// 通过deptId从user表中拿到对应部们人的loginid
		List<Integer> userIds = myMapper.getOneDeptAllUserId(messageJson.getInt("deptId"));
		// 将刚刚添加的信息放到消息表中（消息表：员工登录的时候需要查询是否存在未提示信息）
		meettingService.insertMeettingGrup(Integer.parseInt(messageJson.getString("meettingid")), 1, userIds);
		// 将会议消息推送到在线用户，并设置已推送用户的flag标志为0
		websocketService.sendOnlineUser(userIds,loginId);

		return "success";
	}
	
	/**
	 * 保存用户所选的会议室的位置
	 * @param loginid
	 * @param seat
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@RequestMapping(value="/chooseSeat")
	@ResponseBody
	public String chooseSeat(Integer meettingid, Integer loginid, String seat) throws IllegalArgumentException, IllegalAccessException {
		//首先判断开始是否选择其他位置，如果选择其他位置，则删去那个位置
		MeettingRoom meettingRoom = meettingService.getMeettingRoomInfo(meettingid);
		//获得实体类的所有属性，返回field数组
		Field[] fields = meettingRoom.getClass().getDeclaredFields();
		int count = 0;
		//遍历整个数组，判断是否存在此用户的loginid
		for(int i = 1; i < fields.length; i++) {
			fields[i].setAccessible(true);
			//fields[i].get(meettingRoom)得到的是一个对象，loginid也是integer类型，因此比较的不是值而是地址，又如果将fields[i].get(meettingRoom)转换为int，需要不为null才能转换成功，否则会出现空指针异常（null.toString()：空指针异常）
			//因此第一层：判断fields[i].get(meettingRoom)不能为空
			if(fields[i].get(meettingRoom) != null) {
				//第二层在将其转换为int类型比较
				if((int)Integer.parseInt(fields[i].get(meettingRoom).toString()) == (int)loginid && fields[i].getName().equals(seat)) {
					//记录i，为上次位置选择的信息
					count = i;
				}
			}
		}
		System.out.println("seat:" + seat);
		System.out.println("count:" + count);
		//将上次位置置零
		switch (count) {
		case 0:
			break;
		case 1:meettingRoom.setSeat0(null);
			break;
		case 2:meettingRoom.setSeat1(null);
			break;
		case 3:meettingRoom.setSeat2(null);
			break;
		case 4:meettingRoom.setSeat3(null);
			break;
		case 5:meettingRoom.setSeat4(null);
			break;
		case 6:meettingRoom.setSeat5(null);
			break;
		case 7:meettingRoom.setSeat6(null);
			break;
		case 8:meettingRoom.setSeat7(null);
			break;
		case 9:meettingRoom.setSeat8(null);
			break;
		case 10:meettingRoom.setSeat9(null);
			break;
		default:
			break;
		}
		
		//保存当前选择的位置
		char seatx = seat.charAt(seat.length() - 1);
		switch (seatx) {
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
		System.out.println("meettingRoom:" + meettingRoom);
		meettingService.chooseSeat(meettingRoom);
		return "success";
	}
	
	/**
	 * 通过meettingid查找对应的会议室信息
	 * @param meettingid
	 * @return
	 */
	@RequestMapping(value="/getMeettingRoomInfo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getMeettingRoomInfo(Integer meettingid) {
		MeettingRoom meettingRoom = meettingService.getMeettingRoomInfo(meettingid);
		JSONObject jsonObject = JSONObject.fromObject(meettingRoom);
		return jsonObject.toString();
	}
	
	/**
	 * 获取文件的信息
	 * @param meettingId
	 * @return
	 */
	@RequestMapping(value="/getFileInfo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getFileInfo(Integer meettingId) {
		File file = fileService.getFileInfo(meettingId);
		if(file == null) {
			return "-1";
		}
		JSONObject jsonObject = JSONObject.fromObject(file);
		System.out.println("file:" + jsonObject);
		return jsonObject.toString();
	}

	/**
	 * 当会议发布成功后，发送Ajax请求获取发布的会议，并将发布者的unread设置为0
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getOneMeettingInfo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getOneMeettingInfo(Integer meettingId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 获取当前用户（即发布会议的用户的id，然后获取其发布的会议）
		Integer loginId = (Integer) session.getAttribute("loginId");
		// 通过数据库查询自己所发布的会议
		MeettingInfo oneMeettingInfo = meettingService.getOneMeettingInfo(meettingId);
		// 获取当前设置的会议id，并将发布会议人的unread设置为0
		meettingService.setUnRead(meettingId, loginId);
		JSONObject jsonObject = JSONObject.fromObject(oneMeettingInfo);
		System.out.println("我发布的会议:" + jsonObject);
		return jsonObject.toString();
	}

	/**
	 * 获取个人的所有会议信息
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value="/getMyMessage",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getMyMessage(Integer loginId, Integer pageNum) {
		System.out.println("pageNum:" + pageNum);
		//设置每页显示5条记录
		PageHelper.startPage(pageNum, 5);
		//startPage后紧跟的查询就是一个分页查询
		List<MeettingGroup> myMessage = meettingService.getMyMessage(loginId);
		PageInfo pageInfo = new PageInfo(myMessage, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		System.out.println("我的会议信息:" + jsonObject);
		return jsonObject.toString();
	}
	
	/**
	 * 将unread设置为0，已读状态
	 * @param meettingid
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value="/setUnread")
	@ResponseBody
	public String setUnread(Integer meettingid,Integer loginId) {
		meettingService.setUnRead(meettingid, loginId);
		return "";
	}
	
	/**
	 * 删除个人会议信息
	 * @param meettingIds
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/deleteMeetting/{meettingIds}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteMeetting(@PathVariable("meettingIds")String meettingIds,HttpServletRequest request) {
		Integer loginId = (Integer) request.getSession().getAttribute("loginId");
		List<Integer> meettingIdList = new ArrayList<Integer>();
		if(meettingIds.contains("-")) {
			String[] meettingIdStrArray = meettingIds.split("-");
			for (String mIdString : meettingIdStrArray) {
				meettingIdList.add(Integer.parseInt(mIdString));
			}
		}else {
			meettingIdList.add(Integer.parseInt(meettingIds));
		}
		meettingService.deleteMeetting(meettingIdList,loginId);
		return "success";
	}

	@RequestMapping(value = "/test")
	@ResponseBody
	public String test(String message) {
		return "success";
	}
}
