package com.yk.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yk.pojo.User;
import com.yk.service.AskMeettingService;
import com.yk.service.LoginService;
import com.yk.service.WebsocketService;

@SessionAttributes(value= {"userName","user","loginId"})
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	WebsocketService websocketService;
	@Autowired
	AskMeettingService askMeettingService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Integer loginId, String password, Map<String,Object> map) {
		System.out.println("进行身份验证");
		UsernamePasswordToken token = new UsernamePasswordToken(loginId.toString(), password);
		Subject subject = SecurityUtils.getSubject();
		System.out.println("subject:" + subject);
		try {
			subject.login(token);
			token.setRememberMe(true);
			System.out.println("认证成功");
			//从shiro的session中获得用户的信息
			User user = (User) subject.getPrincipal();
			//如果用户存在，获取其未通知的消息
			int flagCount = loginService.isHasFlag(loginId);
			//设置request域
			map.put("flagCount", flagCount);
			//设置session域
			map.put("userName", user.getUsername());
			map.put("user", user);
			map.put("loginId", loginId);
			
			//判断是否是经理，如果是经理就从数据库中看有无申请消息
			if(subject.hasRole("manager")) {
				//查看是否有未读的会议申请信息
				int askMeettingCount = askMeettingService.isHasManagerFlag(loginId);
				System.out.println("有"+askMeettingCount+"条未读消息");
			}
			return "head";
		} catch (AuthenticationException e) {
			System.out.println("认证失败");
			e.printStackTrace();
		}
		return "redirect:/index.jsp";
		
		//调用service层的登录
		/*Map<String, Object> login = loginService.login(loginId,password);
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
		}*/
	}
}
