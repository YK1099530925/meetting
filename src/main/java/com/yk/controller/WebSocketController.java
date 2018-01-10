package com.yk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yk.config.GetHttpSessionConfigurator;
import com.yk.service.WebsocketService;

import net.sf.json.JSONObject;

/**
 * websocket连接，通过@ServerEndpoint注解，将刚才继承Configurator的类配置到其中
 * @author phy
 *
 */
@Component
@ServerEndpoint(value="/websocket/{loginId}",configurator=GetHttpSessionConfigurator.class)
public class WebSocketController {
	
	@Autowired
	WebsocketService websocketService;

	// 记录当前在线人数
	private static int onlineCount = 0;
	
	//与某个客户端连接的会话，需要通过他给客户端发数据
	private Session session;
	
	//当前发消息人的编号
	private String loginId = "";
	
	//存放每个客户端的信息
	public static Map<String, Session> userWebsocket = new HashMap<String, Session>();
	
	private HttpSession httpSession;

	/**
	 * 收到客户端消息后调用的方法
	 * 当处理的消息过大的时候，将生成错误关闭连接
	 * @param message
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws Exception {

	}

	/**
	 * 建立成功调用的方法
	 * 在此方法中，我们可以拿到EndpointConfig对象，并且通过此对象拿到之前设置进去
	 * 的map（此map中就是我们放进去的httpsession）
	 * @throws IOException 
	 */
	@OnOpen
	public void onOpen(@PathParam(value="loginId") String loginId, Session session, EndpointConfig config) throws IOException {
		//判断此map中是否含有此人，有此人，则更新他的session，但当前人数不变
		if(userWebsocket.containsKey(loginId)) {
			userWebsocket.put(loginId, session);
			return;
		}
		System.out.println("webSocektController:" + loginId + "进来了");
		this.loginId = loginId;
		this.session = session;
		userWebsocket.put(loginId, session);
		onlineCount++;
		System.out.println("当前在线人数:" + onlineCount);
		
		//当一个用户登录的时候，向每个用户发送登录提示
		for(String key : userWebsocket.keySet()) {
			if(!key.equals(loginId)) {
				userWebsocket.get(key).getBasicRemote().sendText(loginId+"上线了");
			}
		}
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		System.out.println("服务端连接关闭");
	}

	/**
	 * 出现异常调用的方法
	 * 
	 * @param session
	 * @param throwable
	 */
	@OnError
	public void onError(Session session, Throwable throwable) {

	}

}
