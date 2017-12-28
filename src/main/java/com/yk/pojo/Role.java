package com.yk.pojo;

public class Role {
	/**
	 * 角色id
	 */
    private Integer id;

    /**
	 * 角色
	 */
    private String rolename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolename=" + rolename + "]";
	}
    
}