package com.yundongjia.oa.admin.po;

public class TRole {
    private Integer roleId;

    private Integer roleStudioId;

    private String roleIsdel;

    private String roleName;

    private String roleRemark;

    private String roleIsclose;

    private Integer roleOperatorid;

    private String roleCreatedate;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleStudioId() {
        return roleStudioId;
    }

    public void setRoleStudioId(Integer roleStudioId) {
        this.roleStudioId = roleStudioId;
    }

    public String getRoleIsdel() {
        return roleIsdel;
    }

    public void setRoleIsdel(String roleIsdel) {
        this.roleIsdel = roleIsdel == null ? null : roleIsdel.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark == null ? null : roleRemark.trim();
    }

    public String getRoleIsclose() {
        return roleIsclose;
    }

    public void setRoleIsclose(String roleIsclose) {
        this.roleIsclose = roleIsclose == null ? null : roleIsclose.trim();
    }

    public Integer getRoleOperatorid() {
        return roleOperatorid;
    }

    public void setRoleOperatorid(Integer roleOperatorid) {
        this.roleOperatorid = roleOperatorid;
    }

    public String getRoleCreatedate() {
        return roleCreatedate;
    }

    public void setRoleCreatedate(String roleCreatedate) {
        this.roleCreatedate = roleCreatedate == null ? null : roleCreatedate.trim();
    }
}