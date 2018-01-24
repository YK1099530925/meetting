package com.yk.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.dao.UserMapper;
import com.yk.pojo.User;
import com.yk.service.MyPersonalInfoService;

import net.sf.json.JSONObject;

@Controller
public class MyPersonalInfoController {

	@Autowired
	MyPersonalInfoService myPersonalInfoService;
	@Autowired
	UserMapper userMapper;

	/**
	 * 获取个人信息
	 * @param loginId
	 * @return
	 */
	@RequestMapping(value = "/getMyPersonalInfoController", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getMyPersonalInfoController(Integer loginId) {
		User user = myPersonalInfoService.getMyPersonalInfoService(loginId);
		System.out.println("用户的个人信息：" + user);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user", user);
		return jsonObject.toString();
	}
	
	/**
	 * 修改我的信息，根据loginid修改
	 * 如果前台需要传入id之类的，但没有显示在表单中，或者有disabled属性，
	 * 那么可以通过url后面带参传入，同样会封装到user对象中
	 * @param user
	 * @param reqest
	 * @return
	 */
	@RequestMapping(value="/updateMyInfo/{loginid}",method=RequestMethod.PUT)
	@ResponseBody
	public String updateMyInfo(User user, HttpServletRequest reqest){
		System.out.println("user:" + user);
		myPersonalInfoService.updateMyInfo(user);
		return "";
	}
}
