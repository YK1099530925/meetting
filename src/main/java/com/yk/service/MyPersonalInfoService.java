package com.yk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dao.MyMapper;
import com.yk.dao.UserMapper;
import com.yk.pojo.User;

@Service
public class MyPersonalInfoService {
	
	@Autowired
	MyMapper mapper;
	
	@Autowired
	UserMapper userMapper;

	/**
	 * 获取个人信息
	 * @param loginId
	 * @return
	 */
	public User getMyPersonalInfoService(Integer loginId) {
		User user = mapper.getMyPersonalInfo(loginId);
		return user;
	}

	/**
	 * 修改个人信息
	 * 通过选择性的修改，如果某个字段被修改，才修改其中的参数
	 * @param user
	 */
	public void updateMyInfo(User user) {
		mapper.updateByLoginIdSelective(user);
	}

	
}
