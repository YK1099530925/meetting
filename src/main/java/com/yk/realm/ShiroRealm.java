package com.yk.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.yk.pojo.User;
import com.yk.service.LoginService;

public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	LoginService loginService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("shiroRealm:AuthenticationInfo:认证");
		return null;
	}
	
	//角色授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		System.out.println("shiroRealm:AuthorizationInfo:角色授权");
		
		//通过principal获取用户主体信息
		User user = (User) principal.getPrimaryPrincipal();
		//从数据库中获取角色信息
		List<String> roleList = null;
		try {
			roleList = loginService.getRoleListByLoginId(user.getLoginid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(roleList != null) {
			//将查询到的角色添加到SimpleAuthorizationInfo中
			System.out.println("此人的角色：" + roleList);
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addRoles(roleList);
			return info;
		}
		return null;
	}
	
	
	
	
	//计算盐值加密后的密码
	public static void main(String[] args) {
		String algorithmName = "MD5";
		Object source = "123456";
		Object salt = ByteSource.Util.bytes("10001");
		int hashIterations = 1;
		//通过MD5，盐：loginId，密码：***，三项加密
		Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(result);
	}
}
