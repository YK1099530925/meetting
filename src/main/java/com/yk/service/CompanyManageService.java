package com.yk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dao.CompanyManageMapper;
import com.yk.dao.UserMapper;
import com.yk.pojo.DepartMent;
import com.yk.pojo.Permission;
import com.yk.pojo.Role;
import com.yk.pojo.User;

@Service
public class CompanyManageService {
	
	@Autowired
	CompanyManageMapper companyManageMapper;
	@Autowired
	UserMapper userMapper;
	
	public List<User> getAllUserInfo(){
		return companyManageMapper.getAllUserInfo();
	}

	public List<DepartMent> getDepts() {
		return companyManageMapper.getDepts();
	}

	public void saveUserInfo(User user) {
		userMapper.insertSelective(user);
	}

	public User getUserInfo(Integer loginid) {
		return companyManageMapper.getUserInfo(loginid);
	}

	public void updateUserInfo(User user) {
		companyManageMapper.updateUserInfo(user);
	}

	public void deleteUser(List<Integer> loginidList) {
		for(Integer loginid : loginidList) {
			companyManageMapper.deleteUser(loginid);
		}
	}

	public List<DepartMent> getAllDeptInfo() {
		return companyManageMapper.getDepts();
	}

	public Integer getDeptUserNum(Integer id) {
		return companyManageMapper.getDeptUserNum(id);
	}

	public List<Role> getAllRoleInfo() {
		return companyManageMapper.getAllRoleInfo();
	}

	public void addUserRole(Integer loginid, Integer roleid) {
		companyManageMapper.addUserRole(loginid,roleid);
	}

	public List<User> getHasRoleUser(Integer roleid) {
		return companyManageMapper.getHasRoleUser(roleid);
	}

	public void deleteUserRole(Integer loginid, Integer roleid) {
		companyManageMapper.deleteUserRole(loginid,roleid);
	}

	public List<Permission> getPermissionRole() {
		return companyManageMapper.getPermissionRole();
	}

	public void addPermissionRole(Integer permissionid, Integer roleid) {
		companyManageMapper.addPermissionRole(permissionid,roleid);
	}

	public void rePassword(Integer loginid, String password) {
		companyManageMapper.rePassword(loginid,password);
	}
}
