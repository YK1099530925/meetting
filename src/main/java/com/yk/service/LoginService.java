package com.yk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dao.LoginMapper;
import com.yk.pojo.User;

@Service
public class LoginService {
	
	@Autowired
	LoginMapper loginMapper;
	
	public Map<String, Object> login(Integer loginId, String password) {
		//User user = userMapper.selectByPrimaryKey(loginId);
		Map<String, Object> map = new HashMap<String, Object>();;
		User user = loginMapper.loginByLoginId(loginId);
		if(user.getPassword().equals(password)) {
			map.put("user", user);
			map.put("login", "true");
			map.put("userName", user.getUsername());
			return map;
		}else {
			map.put("login", "false");
			return map;
		}
	}
}
