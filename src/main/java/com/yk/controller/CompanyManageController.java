package com.yk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yk.md5.Password;
import com.yk.pojo.DepartMent;
import com.yk.pojo.Permission;
import com.yk.pojo.Role;
import com.yk.pojo.User;
import com.yk.service.CompanyManageService;
import com.yk.service.LoginService;
import com.yk.service.MyPersonalInfoService;

import net.sf.json.JSONObject;

@Controller
public class CompanyManageController {
	
	@Autowired
	CompanyManageService companyManageService;
	
	//用于获取用户信息，进行密码的比对（不用再重复写）
	@Autowired
	LoginService loginService;
	
	//用于修改用户的信息
	@Autowired
	MyPersonalInfoService myPersonalInfoService;
	
	/**
	 * 修改密码
	 * @param loginid
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value="/updatePassword",method=RequestMethod.POST)
	@ResponseBody
	public String updatePassword(String loginid,String oldPassword,String newPassword) {
		//对原始密码进行加密
		String oldPasswordMd5 = Password.md5Password(Integer.parseInt(loginid), oldPassword);
		//判断原密码是否正确
		//获取用户信息
		User userInfo = loginService.getUserInfo(Integer.parseInt(loginid));
		String userPassword = userInfo.getPassword();
		//如果原始密码正确
		if(oldPasswordMd5.equals(userPassword)) {
			//修改密码
			//对新密码加密
			String newPasswordMd5 = Password.md5Password(Integer.parseInt(loginid), newPassword);
			userInfo.setPassword(newPasswordMd5);
			myPersonalInfoService.updateMyInfo(userInfo);
			return "success";
		}else {
			return "oldPassword error";
		}
	}
	
	/**
	 * 密码重置（管理员的操作）
	 * @param loginid
	 * @return
	 */
	@RequestMapping(value="/rePassword",method=RequestMethod.POST)
	@ResponseBody
	public String rePassword(String loginid) {
		String password = Password.initPassword(Integer.parseInt(loginid));
		companyManageService.rePassword(Integer.parseInt(loginid),password);
		return "success";
	}
	
	/**
	 * 删除用户
	 * 删除用户需要注意一些问题：由于用户有可能和其他表有关联，因此先得删除用户与其他表的关联，然后在删除此用户，
	 * 因此可以抛出异常，然后提示此用户暂不能被删除，或者其他处理
	 * @param loginids
	 * @return
	 */
	@RequestMapping(value="/deleteUser/{loginids}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable("loginids") String loginids) {
		//存放Integer loginid的list
		List<Integer> loginidList = new ArrayList<Integer>();
		//判断是否有“-”，没有就表示只删除一个
		if(loginids.contains("-")) {
			//用“-”截取loginids
			String[] loginidStrings = loginids.split("-");
			for(String loginidString : loginidStrings) {
				loginidList.add(Integer.parseInt(loginidString));
			}
		}else {
			loginidList.add(Integer.parseInt(loginids));
		}
		companyManageService.deleteUser(loginidList);
		return "success";
	}
	
	/**
	 * 修改员工的信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/updateUserInfo/{loginid}",method=RequestMethod.PUT)
	@ResponseBody
	public String updateUserInfo(User user) {
		//路径下的loginid将直接放入user中（一定要字段一样）
		System.out.println("修改的user：" + user);
		companyManageService.updateUserInfo(user);
		return "success";
	}
	
	/**
	 * 获取一个员工的信息，用于修改
	 * @param loginid
	 * @return
	 */
	@RequestMapping(value="/getUserInfo/{loginid}",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getUserInfo(@PathVariable("loginid") Integer loginid) {
		User user = companyManageService.getUserInfo(loginid);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userInfo", user);
		return jsonObject.toString();
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/saveUserInfo",method=RequestMethod.POST)
	@ResponseBody
	public String saveUserInfo(User user) {
		//设置密码，初始密码为123456，并将密码进行MD5加密
		String password = Password.initPassword(user.getLoginid());
		user.setPassword(password);
		companyManageService.saveUserInfo(user);
		return "success";
	}
	
	/**
	 * 获取部门的信息
	 * @return
	 */
	@RequestMapping(value="/getDepts",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getDepts() {
		List<DepartMent> departMents = companyManageService.getDepts();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("depts", departMents);
		return jsonObject.toString();
	}
	
	/**
	 * 显示所有员工信息
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value="/usermanage",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getAllUserInfo(Integer pageNum) {
		PageHelper.startPage(pageNum,5);
		List<User> userList = companyManageService.getAllUserInfo();
		PageInfo pageInfo = new PageInfo(userList, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		System.out.println("员工信息：" + jsonObject);
		return jsonObject.toString();
	}
	
	/**************************************************************************************/
	
	/**
	 * 获取部门的信息
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value="/deptmanage",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getAllDeptInfo(Integer pageNum) {
		PageHelper.startPage(pageNum,5);
		List<DepartMent> deptList = companyManageService.getAllDeptInfo();
		PageInfo pageInfo = new PageInfo(deptList,5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		//查询每个部门的人数
		Map<String, Integer> deptUserNum = new HashMap<String, Integer>();
		for(DepartMent dept : deptList) {
			Integer id = dept.getId();
			Integer num = companyManageService.getDeptUserNum(id);
			deptUserNum.put(id.toString(), num);
		}
		System.out.println("deptUserNum:" + deptUserNum);
		jsonObject.put("deptUserNum", deptUserNum);
		System.out.println("所有部门信息：" + jsonObject);
		return jsonObject.toString();
	}
	
	/**
	 * 查询角色
	 * @param pageNum
	 * @return
	 */
	@RequestMapping(value="/rolepermissionmanage",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getRoleInfo(Integer pageNum) {
		PageHelper.startPage(pageNum,5);
		//查询角色的情况
		List<Role> roles = companyManageService.getAllRoleInfo();
		PageInfo pageInfo = new PageInfo(roles, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		System.out.println("角色信息：" + jsonObject);
		return jsonObject.toString();
	}
	
	/**
	 * 获取用户信息，用于向角色中添加用户(待做：如果有此角色的用户，则不需要查询出来)
	 * @return
	 */
	@RequestMapping(value="/getUserRoleInfo",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getUserRoleInfo(Integer pageNum) {
		PageHelper.startPage(pageNum,16);
		List<User> users = companyManageService.getAllUserInfo();
		PageInfo pageInfo = new PageInfo(users, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		System.out.println("用户信息：" + jsonObject);
		return jsonObject.toString();
	}
	
	/**
	 * 向角色中添加用户
	 * @return
	 */
	@RequestMapping(value="/addUserRole",method=RequestMethod.POST)
	@ResponseBody
	public String addUserRole(String loginids, String roleid) {
		System.out.println("loginids = " + loginids + " :: roleid = " + roleid );
		String loginidString[] = loginids.split("-");
		List<Integer> loginidList = new ArrayList<Integer>();
		for (String loginid : loginidString) {
			loginidList.add(Integer.parseInt(loginid));
		}
		//循环将用户添加到角色中
		for(Integer loginid : loginidList) {
			companyManageService.addUserRole(loginid,Integer.parseInt(roleid));
		}
		return "success";
	}
	
	/**
	 * 查询roleid对应的用户信息
	 * @param roleid
	 * @return
	 */
	@RequestMapping(value="/getHasRoleUser",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getHasRoleUser(Integer pageNum ,Integer roleid) {
		PageHelper.startPage(pageNum,16);
		List<User> users = companyManageService.getHasRoleUser(roleid);
		PageInfo pageInfo = new PageInfo(users, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		System.out.println("用户信息：" + jsonObject);
		return jsonObject.toString();
	}
	
	@RequestMapping(value="/deleteUserRole/{loginids}/{roleid}",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteUserRole(@PathVariable("loginids")String loginids, @PathVariable("roleid")String roleid) {
		System.out.println("loginids = " + loginids + " :: roleid = " + roleid );
		String loginidString[] = loginids.split("-");
		List<Integer> loginidList = new ArrayList<Integer>();
		for (String loginid : loginidString) {
			loginidList.add(Integer.parseInt(loginid));
		}
		//循环将用户从角色中删除
		for(Integer loginid : loginidList) {
			companyManageService.deleteUserRole(loginid,Integer.parseInt(roleid));
		}
		return "success";
	}
	
	/**
	 * 获取用户信息，用于向角色中添加用户(待做：如果有此角色的用户，则不需要查询出来)
	 * @return
	 */
	@RequestMapping(value="/getPermissionRole",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	@ResponseBody
	public String getPermissionRole(Integer pageNum) {
		PageHelper.startPage(pageNum,16);
		List<Permission> permissions = companyManageService.getPermissionRole();
		PageInfo pageInfo = new PageInfo(permissions, 5);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		System.out.println("权限信息：" + jsonObject);
		return jsonObject.toString();
	}
	
	/**
	 * 向角色中添加权限
	 * @return
	 */
	@RequestMapping(value="/addPermissionRole",method=RequestMethod.POST)
	@ResponseBody
	public String addPermissionRole(String permissionids, String roleid) {
		System.out.println("loginids = " + permissionids + " :: roleid = " + roleid );
		String permissionidString[] = permissionids.split("-");
		List<Integer> permissionidList = new ArrayList<Integer>();
		for (String permissionid : permissionidString) {
			permissionidList.add(Integer.parseInt(permissionid));
		}
		//循环将用户添加到角色中
		for(Integer permissionid : permissionidList) {
			companyManageService.addPermissionRole(permissionid,Integer.parseInt(roleid));
		}
		return "success";
	}

}
