package com.yk.pojo;

import java.util.Date;

public class MeettingInfo {
    private Integer id;

    private Integer meettingid;

    private String title;

    private String profile;

    private Date meettingtime;

    private String addr;

    private String infomation;

    private Integer deptid;

    private String releaseuser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeettingid() {
        return meettingid;
    }

    public void setMeettingid(Integer meettingid) {
        this.meettingid = meettingid;
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

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getReleaseuser() {
        return releaseuser;
    }

    public void setReleaseuser(String releaseuser) {
        this.releaseuser = releaseuser == null ? null : releaseuser.trim();
	}

	@Override
	public String toString() {
		return "MeettingInfo [id=" + id + ", meettingid=" + meettingid + ", title=" + title + ", profile=" + profile
				+ ", meettingtime=" + meettingtime + ", addr=" + addr + ", infomation=" + infomation + ", deptid="
				+ deptid + ", releaseuser=" + releaseuser + "]";
	}
}