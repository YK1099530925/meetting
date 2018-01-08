package com.yk.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yk.service.LoginService;

@SessionAttributes(value= {"userName","user","loginId"})
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
			map.put("loginId", loginId);
			System.out.println("login:"+login);
			return "head";
		}else {
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping(value="/getUserName")
	@ResponseBody
	public String gethttpsession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("userName");
		System.out.println("userName:" + username);
		return "yes";
	}
	
}
