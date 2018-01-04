package com.yk.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub

	}
	public RequestListener() {}  

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		// 将所有的request请求都带上httpsession
		/**
		 * 所有的请求，包括websocket协议的请求也都带上httpsession，因此在通过websocket协议连接的 
		 * java后台就能获取到httpsession
		 */
		((HttpServletRequest) sre.getServletRequest()).getSession();
	}

}
