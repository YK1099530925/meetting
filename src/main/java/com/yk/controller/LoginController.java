package com.yk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yk.service.LoginService;

@SessionAttributes(value= {"userName","user"})
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Integer loginId, String password, Map<String,Object> map) {
		//调用service层的登录
		Map<String, Object> login = loginService.login(loginId,password);
		if(login.get("login").equals("true")) {
			map.put("userName", login.get("userName"));
			map.put("user", login);
			System.out.println("login:"+login);
			return "homePage";
		}else {
			return "redirect:/index.jsp";
		}
		
	}
}
