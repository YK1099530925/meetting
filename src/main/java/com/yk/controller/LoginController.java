package com.yk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yk.md5.Password;
import com.yk.pojo.User;
import com.yk.service.AskMeettingService;
import com.yk.service.CompanyManageService;
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
	
	//用于保存注册用户（保存用户的信息）
	@Autowired
	CompanyManageService companyManageService;
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/registerUserInfo")
	@ResponseBody
	public String registerUserInfo(User user) {
		//此处出现的小bug，因为session中存储了loginid，因此注册的时候，前台的session中的loginid自动放入user中了
		//注册
		//首先查询出最大的loginid，将其+1
		Integer loginid = loginService.getMaxloginid() + 1;
		user.setLoginid(loginid);
		//对密码进行加密
		String password = Password.md5Password(loginid, user.getPassword());
		user.setPassword(password);
		//保存注册的用户信息
		companyManageService.saveUserInfo(user);
		return loginid.toString();
	}
	
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
			System.out.println("Session:user:" + user);
			//如果用户存在，获取其未通知的消息（某人发布会议，确没有通知到未在线用户）
			int flagCount = loginService.isHasFlag(loginId);
			System.out.println("未提示的会议消息:" + flagCount);
			//设置request域
			map.put("flagCount", flagCount);
			//设置session域
			map.put("userName", user.getUsername());
			map.put("user", user);
			map.put("loginId", loginId);
			
			//经理有无消息的标志
			int askMeettingCount = 0;
			
			//员工有无会议申请提示的标志
			String meettingResult = "";
			
			//判断是否是经理，如果是经理就从数据库中查看是否有未通知的申请的会议消息
			if(subject.hasRole("manager")) {
				//查看是否有未通知的申请的会议消息
				askMeettingCount = askMeettingService.isHasManagerFlag(loginId);
				//如果有未通知的则设置askMeettingCount的条数，并将库中managerFlag标志为0，然后前台通知
				if(askMeettingCount > 0){
					askMeettingService.setManagerFlag(loginId,0);
				}
			}else{
				//否则是员工，什么消息被同意，什么消息被拒绝
				meettingResult = askMeettingService.getAskMeettingResult(loginId);
			}
			map.put("meettingResult",meettingResult);
			map.put("askMeettingCount", askMeettingCount);
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
