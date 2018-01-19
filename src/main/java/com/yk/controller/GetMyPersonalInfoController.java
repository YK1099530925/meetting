package com.yk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yk.pojo.User;
import com.yk.service.GetMyPersonalInfoService;

import net.sf.json.JSONObject;

@Controller
public class GetMyPersonalInfoController {

	@Autowired
	GetMyPersonalInfoService getMyPersonalInfoService;

	@RequestMapping(value = "/getMyPersonalInfoController", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getMyPersonalInfoController(Integer loginId) {
		System.out.println("loginId:" + loginId);
		User user = getMyPersonalInfoService.getMyPersonalInfoService(loginId);
		System.out.println("用户的个人信息：" + user);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("user", user);
		return jsonObject.toString();
	}
}
