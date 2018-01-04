package com.yk.pojo;

import java.io.Serializable;

public class DepartMent implements Serializable{
    private Integer id;

    private String deptname;

    private String depttel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getDepttel() {
        return depttel;
    }

    public void setDepttel(String depttel) {
        this.depttel = depttel == null ? null : depttel.trim();
    }

	@Override
	public String toString() {
		return "DepartMent [id=" + id + ", deptname=" + deptname + ", depttel=" + depttel + "]";
	}
}