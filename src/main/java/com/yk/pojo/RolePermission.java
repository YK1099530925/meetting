package com.yk.pojo;

import java.io.Serializable;

public class RolePermission implements Serializable{
    private Integer roleid;

    private Integer permissionid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }
}