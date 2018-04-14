package com.yk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yk.pojo.DepartMent;
import com.yk.pojo.Permission;
import com.yk.pojo.Role;
import com.yk.pojo.User;

public interface CompanyManageMapper {
	List<User> getAllUserInfo();

	List<DepartMent> getDepts();

	User getUserInfo(Integer loginid);

	void updateUserInfo(User user);

	void deleteUser(Integer loginid);

	Integer getDeptUserNum(Integer id);

	List<Role> getAllRoleInfo();

	void addUserRole(@Param("loginid")Integer loginid, @Param("roleid")Integer roleid);

	List<User> getHasRoleUser(Integer roleid);

	void deleteUserRole(@Param("loginid")Integer loginid, @Param("roleid")Integer roleid);

	List<Permission> getPermissionRole();

	void addPermissionRole(@Param("permissionid")Integer permissionid, @Param("roleid")Integer roleid);

	void rePassword(@Param("loginid")Integer loginid, @Param("password")String password);

}
