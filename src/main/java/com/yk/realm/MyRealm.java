package com.yk.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.yk.pojo.User;
import com.yk.service.LoginService;

public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	LoginService loginService;

	/**
	 * 权限授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		System.out.println("MyRealm:AuthorizationInfo:权限授权");
		//通过principal获取主身份信息，并转化为真实身份类型（user）
		//此principle是下面认证通过之后填充到simpleAuthenticatoinInfo中的
		User user = (User) principal.getPrimaryPrincipal();
		//从数据库中获取权限信息
		List<String> permissionList = null;
		try {
			permissionList = loginService.getPermissionListByLoginId(user.getLoginid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(permissionList != null) {
			//将查询到的权限信息添加到simpleAuthorizationInfo中
			SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			System.out.println("此人的权限：" + permissionList);
			simpleAuthorizationInfo.addStringPermissions(permissionList);
			return simpleAuthorizationInfo;
		}
		return null;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("MyRealm:AuthenticationInfo:认证");
		//1、吧AuthenticationToken转换成UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2、从token中获取username
		String loginId = upToken.getUsername();
		//3、调用数据库的方法，从数据库中查询username对应的用户记录
		User userInfo = loginService.getUserInfo(Integer.parseInt(loginId));
		//4、若用户不存在，则可以跑出异常
		if (userInfo == null) {
			throw new UnknownAccountException("用户不存在");
		}
		//5、根据用户信息的情况，决定是否需要抛出其他的异常
		
		//6、根据用户的情况，来构建AuthenticationInfo对象并返回
		//以下是从数据库中获取的
		//1)principal:认证的实体信息，可以是username，也可以是数据表对应的实体信息
		Object principal = userInfo;
		//2)credentials:密码
		Object credentials = userInfo.getPassword();
		//3)realmName:当前realm对象的name，调用父类的getName()方法即可
		String realmName = getName();
		//4)盐值加密
		ByteSource credentialsSalt = ByteSource.Util.bytes(loginId);
		SimpleAuthenticationInfo info = null;//new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		
		return info;
	}
	

}
