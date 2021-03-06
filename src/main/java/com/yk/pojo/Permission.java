package com.yk.pojo;

import java.io.Serializable;

public class Permission implements Serializable{
    private Integer id;

    private String permissionname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionname=" + permissionname + "]";
	}
}