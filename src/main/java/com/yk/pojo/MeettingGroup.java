package com.yk.pojo;

import java.io.Serializable;

public class MeettingGroup implements Serializable {
	private Integer meettingid;

	private Integer deptid;

	private Integer userid;

	private Integer flag;

	private Integer unread;

	private MeettingInfo meettingInfo;

	public Integer getMeettingid() {
		return meettingid;
	}

	public void setMeettingid(Integer meettingid) {
		this.meettingid = meettingid;
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getUnread() {
		return unread;
	}

	public void setUnread(Integer unread) {
		this.unread = unread;
	}

	public MeettingInfo getMeettingInfo() {
		return meettingInfo;
	}

	public void setMeettingInfo(MeettingInfo meettingInfo) {
		this.meettingInfo = meettingInfo;
	}

	@Override
	public String toString() {
		return "MeettingGroup [meettingid=" + meettingid + ", deptid=" + deptid + ", userid=" + userid + ", flag="
				+ flag + ", unread=" + unread + ", meettingInfo=" + meettingInfo + "]";
	}
}