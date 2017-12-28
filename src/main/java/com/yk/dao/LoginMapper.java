package com.yk.dao;

import com.yk.pojo.User;

public interface LoginMapper {
	public User loginByLoginId(Integer loginId);
}
