package com.yk.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dao.LoginMapper;
import com.yk.dao.MyMapper;
import com.yk.pojo.Permission;
import com.yk.pojo.User;

@Service
public class LoginService {
	
	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	MyMapper myMapper;
	
	/**
	 * 普通登录调用，查询数据库
	 * @param loginId
	 * @param password
	 * @return
	 */
	public Map<String, Object> login(Integer loginId, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = loginMapper.loginByLoginId(loginId);
		if(user.getPassword().equals(password)) {
			//如果用户存在
			map.put("user", user);
			map.put("login", "true");
			map.put("userName", user.getUsername());
			
			return map;
		}else {
			map.put("login", "false");
			return map;
		}
	}
	
	/**
	 * 从库中寻找是否存在flag=1的信息，如果有统计条数，并通知用户
	 * @param loginId
	 * @throws IOException 
	 */
	public int isHasFlag(Integer loginId){
		//获取flag为1的条数，并设置该用户的flag标志为0
		int flagCount = myMapper.getMyFlagCount(loginId);
		//设置flag标志位0
		myMapper.setMyFlagCount(loginId);
		return flagCount;
	}
	
	
	/**
	 * 通过shiroRealm从数据库中查询用户信息
	 */
	public User getUserInfo(Integer loginId) {
		User user = loginMapper.loginByLoginId(loginId);
		return user;
	}

	/**
	 * 从数据库中获取权限信息
	 * @param loginid
	 * @return
	 */
	public List<String> getPermissionListByLoginId(Integer loginid) {
		return myMapper.getPermissionListByLoginId(loginid);
	}

	/**
	 * 从数据库中获取角色信息
	 * @param loginid
	 * @return
	 */
	public List<String> getRoleListByLoginId(Integer loginid) {
		return myMapper.getRoleListByLoginId(loginid);
	}

	public Integer getMaxloginid() {
		return myMapper.getMaxloginid();
	}
}
