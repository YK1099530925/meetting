package com.yk.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.controller.WebSocketController;
import com.yk.dao.MyMapper;

@Service
public class WebsocketService {

	@Autowired
	MyMapper myMapper;

	public void sendOnlineUser(List<Integer> userIds, Integer loginId) throws IOException {
		// 获取在线用户
		Map<String, Session> onlineUsers = WebSocketController.userWebsocket;
		// 判断userIds中那些用户正在登录，如果登录了，向他推送消息，并设置数据库flag标志位0
		for (int id = 0; id < userIds.size(); id++) {
			if (onlineUsers.containsKey(String.valueOf(userIds.get(id)))) {
				//向在线用户推送消息(但是不给自己提示)
				if(userIds.get(id) != (int)loginId) {
					onlineUsers.get(String.valueOf(userIds.get(id))).getBasicRemote().sendText("你有消息来了");
				}
			} else {
				// 将没有推送的用户id删除，之后将推送了的用户flag标志设置为0
				userIds.remove(id);
				id--;
			}
		}
		// 将推送了的用户和自己的flag设置为0
		for (int id = 0; id < userIds.size(); id++) {
			myMapper.updateMeettingGroupFlag(userIds.get(id));
		}

	}
}
