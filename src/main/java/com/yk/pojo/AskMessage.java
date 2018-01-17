package com.yk.pojo;

import java.io.Serializable;

public class AskMessage implements Serializable{
    private Integer deptid;

    private Integer askuserid;

    private Integer managerid;

    private Integer managerflag;

    private Integer userflag;

    private Integer agree;

    private Integer meettingid;

    private String title;

    private String profile;

    private String infomation;

    private String askusername;

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getAskuserid() {
        return askuserid;
    }

    public void setAskuserid(Integer askuserid) {
        this.askuserid = askuserid;
    }

    public Integer getManagerid() {
        return managerid;
    }

    public void setManagerid(Integer managerid) {
        this.managerid = managerid;
    }

    public Integer getManagerflag() {
        return managerflag;
    }

    public void setManagerflag(Integer managerflag) {
        this.managerflag = managerflag;
    }

    public Integer getUserflag() {
        return userflag;
    }

    public void setUserflag(Integer userflag) {
        this.userflag = userflag;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
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

    public String getInfomation() {
        return infomation;
    }

    public void setInfomation(String infomation) {
        this.infomation = infomation == null ? null : infomation.trim();
    }

    public String getAskusername() {
        return askusername;
    }

    public void setAskusername(String askusername) {
        this.askusername = askusername == null ? null : askusername.trim();
    }

	@Override
	public String toString() {
		return "AskMessage [deptid=" + deptid + ", askuserid=" + askuserid + ", managerid=" + managerid
				+ ", managerflag=" + managerflag + ", userflag=" + userflag + ", agree=" + agree + ", meettingid="
				+ meettingid + ", title=" + title + ", profile=" + profile + ", infomation=" + infomation
				+ ", askusername=" + askusername + "]";
	}
}