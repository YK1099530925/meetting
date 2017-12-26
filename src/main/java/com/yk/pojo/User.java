package com.yk.pojo;

import java.util.Date;

public class User {
	/**
	 * 用户id
	 */
    private Integer id;

    /**
	 * 用户登录id
	 */
    private Integer loginid;

    /**
	 * 用户密码
	 */
    private String password;

    /**
	 * 用户名
	 */
    private String username;

    /**
	 * 性别
	 */
    private String sex;

    /**
	 * 生日
	 */
    private Date birthday;

    /**
	 * 电话
	 */
    private String tel;

    /**
	 * 地址
	 */
    private String addr;

    /**
	 * 部门id
	 */
    private Integer deptid;

    /**
	 * 角色
	 */
    private Integer roleid;

    public User() {
		super();
	}

	public User(Integer id, Integer loginid, String password, String username, String sex, Date birthday, String tel,
			String addr, Integer deptid, Integer roleid) {
		super();
		this.id = id;
		this.loginid = loginid;
		this.password = password;
		this.username = username;
		this.sex = sex;
		this.birthday = birthday;
		this.tel = tel;
		this.addr = addr;
		this.deptid = deptid;
		this.roleid = roleid;
	}

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

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}