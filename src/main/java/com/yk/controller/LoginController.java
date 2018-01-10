package com.yk.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yk.service.LoginService;
import com.yk.service.WebsocketService;

@SessionAttributes(value= {"userName","user","loginId"})
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	WebsocketService websocketService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Integer loginId, String password, Map<String,Object> map) {
		//调用service层的登录
		Map<String, Object> login = loginService.login(loginId,password);
		if(login.get("login").equals("true")) {
			//如果用户存在，获取其未通知的消息
			int flagCount = loginService.isHasFlag(loginId);
			//设置request域
			map.put("flagCount", flagCount);
			//设置session域
			map.put("userName", login.get("userName"));
			map.put("user", login);
			map.put("loginId", loginId);
			System.out.println("login:"+login);
			return "head";
		}else {
			return "redirect:/index.jsp";
		}
	}
}
