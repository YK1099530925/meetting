package com.yk.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {
	private Integer id;

	private Integer loginid;

	private String password;

	private String username;

	private String sex;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;

	private String tel;

	private String addr;

	private Integer deptid;

	private DepartMent departMent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLoginid() {
		return loginid;
	}

	public void setLoginid(Integer loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr == null ? null : addr.trim();
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public DepartMent getDepartMent() {
		return departMent;
	}

	public void setDepartMent(DepartMent departMent) {
		this.departMent = departMent;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", loginid=" + loginid + ", password=" + password + ", username=" + username
				+ ", sex=" + sex + ", birthday=" + birthday + ", tel=" + tel + ", addr=" + addr + ", deptid=" + deptid
				+ ", departMent=" + departMent + "]";
	}

}