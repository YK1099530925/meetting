package com.yk.md5;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Password {
	
	public static String initPassword(Integer loginid) {
		String algorithmName = "MD5";
		Object source = "123456";
		Object salt = ByteSource.Util.bytes(loginid.toString());
		int hashIterations = 1;//加密次数
		//通过MD5，盐：loginId，密码：123456，三项加密
		Object password = new SimpleHash(algorithmName, source, salt, hashIterations);
		return password.toString();
	}
	
	public static String md5Password(Integer loginid,String password) {
		String algorithmName = "MD5";
		Object salt = ByteSource.Util.bytes(loginid.toString());
		int hashIterations = 1;//加密次数
		Object md5Password = new SimpleHash(algorithmName, password, salt, hashIterations);
		return md5Password.toString();
	}

}
