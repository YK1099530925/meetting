package com.yk.pojo;

import java.util.Date;

public class MeettingInfo {
	/**
	 * 会议信息id
	 */
    private Integer id;

    /**
	 * 会议标题
	 */
    private String title;

    /**
	 * 会议简介
	 */
    private String profile;

    /**
	 * 会议时间
	 */
    private Date meettingtime;

    /**
	 * 会议地点
	 */
    private String addr;

    /**
	 * 会议内容
	 */
    private String infomation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    public Date getMeettingtime() {
        return meettingtime;
    }

    public void setMeettingtime(Date meettingtime) {
        this.meettingtime = meettingtime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getInfomation() {
        return infomation;
    }

    public void setInfomation(String infomation) {
        this.infomation = infomation == null ? null : infomation.trim();
    }
}