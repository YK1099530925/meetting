package com.yk.pojo;

public class DepartMent {
	/**
	 * 部门id
	 */
    private Integer id;
    
    /**
	 * 部门名
	 */
    private String deptname;
    
    /**
	 * 部门电话
	 */
    private String depttel;

    public DepartMent() {
		super();
	}

	public DepartMent(Integer id, String deptname, String depttel) {
		super();
		this.id = id;
		this.deptname = deptname;
		this.depttel = depttel;
	}

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
}