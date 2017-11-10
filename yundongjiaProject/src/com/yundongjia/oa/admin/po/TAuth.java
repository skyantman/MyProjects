package com.yundongjia.oa.admin.po;

import java.util.Date;

public class TAuth {
    private Integer authId;

    private String authName;

    private String authMark;

    private String authComm;

    private Date authCreateDate;

    private Integer authOperatorid;

    private Integer authOrdernum;

    private Integer authMenuId;

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }

    public String getAuthMark() {
        return authMark;
    }

    public void setAuthMark(String authMark) {
        this.authMark = authMark == null ? null : authMark.trim();
    }

    public String getAuthComm() {
        return authComm;
    }

    public void setAuthComm(String authComm) {
        this.authComm = authComm == null ? null : authComm.trim();
    }

    public Date getAuthCreateDate() {
        return authCreateDate;
    }

    public void setAuthCreateDate(Date authCreateDate) {
        this.authCreateDate = authCreateDate;
    }

    public Integer getAuthOperatorid() {
        return authOperatorid;
    }

    public void setAuthOperatorid(Integer authOperatorid) {
        this.authOperatorid = authOperatorid;
    }

    public Integer getAuthOrdernum() {
        return authOrdernum;
    }

    public void setAuthOrdernum(Integer authOrdernum) {
        this.authOrdernum = authOrdernum;
    }

    public Integer getAuthMenuId() {
        return authMenuId;
    }

    public void setAuthMenuId(Integer authMenuId) {
        this.authMenuId = authMenuId;
    }
}