package com.yk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dao.MyMapper;
import com.yk.pojo.User;

@Service
public class GetMyPersonalInfoService {
	
	@Autowired
	MyMapper mapper;

	public User getMyPersonalInfoService(Integer loginId) {
		System.out.println("loginId:" + loginId);
		User user = mapper.getMyPersonalInfo(loginId);
		return user;
	}

	
}
