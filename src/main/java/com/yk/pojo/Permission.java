package com.yk.pojo;

public class Permission {
	/**
	 * 权限id
	 */
    private Integer id;
    
    /**
	 * 权限
	 */
    private String permissionname;

    /**
	 * 角色
	 */
    private Integer roleid;

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

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionname=" + permissionname + ", roleid=" + roleid + "]";
	}
    
}