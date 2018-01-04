package com.yk.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

@WebListener
public class GetHttpSessionConfigurator extends Configurator {

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		// TODO Auto-generated method stub
		HttpSession httpSession = (HttpSession) request.getHttpSession();
		/*ServerEndpointConfig接口继承了EndpointConfig接口，在EndpointConfig接口中
		 * 有一个Map<String, Object> getUserProperties();方法，
		 * 所以我们可以通过此方法将用户的一些属性放在map中，即：将上面的httpsession放入
		 * HttpSession.class.getName()中，则在java后台就可以拿到httpsession了
		 * 注意：此类不能直接使用，因为这是websocket协议，没法从此协议中获取httpsession，
		 * 所以我们需要将httpsession的值设置进去，故需要一个监听器；如果不做强行使用此类，
		 * 将会报空指针异常*/
		sec.getUserProperties().put(HttpSession.class.getName(), httpSession);
	}

}
