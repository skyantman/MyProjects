package com.yundongjia.oa.admin.po;

import java.util.Date;

public class TMenuAdminRef {
    private Integer menuAdminId;

    private Integer menuAdminMenuId;

    private Integer menuAdminAdminId;

    private String menuAdminRoleId;

    private Byte menuAdminType;

    private Date menuAdminCreateDate;

    private Integer menuAdminOperatorid;

    public Integer getMenuAdminId() {
        return menuAdminId;
    }

    public void setMenuAdminId(Integer menuAdminId) {
        this.menuAdminId = menuAdminId;
    }

    public Integer getMenuAdminMenuId() {
        return menuAdminMenuId;
    }

    public void setMenuAdminMenuId(Integer menuAdminMenuId) {
        this.menuAdminMenuId = menuAdminMenuId;
    }

    public Integer getMenuAdminAdminId() {
        return menuAdminAdminId;
    }

    public void setMenuAdminAdminId(Integer menuAdminAdminId) {
        this.menuAdminAdminId = menuAdminAdminId;
    }

    public String getMenuAdminRoleId() {
        return menuAdminRoleId;
    }

    public void setMenuAdminRoleId(String menuAdminRoleId) {
        this.menuAdminRoleId = menuAdminRoleId == null ? null : menuAdminRoleId.trim();
    }

    public Byte getMenuAdminType() {
        return menuAdminType;
    }

    public void setMenuAdminType(Byte menuAdminType) {
        this.menuAdminType = menuAdminType;
    }

    public Date getMenuAdminCreateDate() {
        return menuAdminCreateDate;
    }

    public void setMenuAdminCreateDate(Date menuAdminCreateDate) {
        this.menuAdminCreateDate = menuAdminCreateDate;
    }

    public Integer getMenuAdminOperatorid() {
        return menuAdminOperatorid;
    }

    public void setMenuAdminOperatorid(Integer menuAdminOperatorid) {
        this.menuAdminOperatorid = menuAdminOperatorid;
    }
}