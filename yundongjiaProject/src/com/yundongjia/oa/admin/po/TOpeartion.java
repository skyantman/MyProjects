package com.yundongjia.oa.admin.po;

import java.util.Date;

public class TOpeartion {
    private Integer opeartionId;

    private Integer opeartionAdminId;

    private Date opeartionCreatedate;

    private String opeartionInfo;

    private Integer opeartionType;

    private Integer opeartionById;

    private String opeartionCom;

    public Integer getOpeartionId() {
        return opeartionId;
    }

    public void setOpeartionId(Integer opeartionId) {
        this.opeartionId = opeartionId;
    }

    public Integer getOpeartionAdminId() {
        return opeartionAdminId;
    }

    public void setOpeartionAdminId(Integer opeartionAdminId) {
        this.opeartionAdminId = opeartionAdminId;
    }

    public Date getOpeartionCreatedate() {
        return opeartionCreatedate;
    }

    public void setOpeartionCreatedate(Date opeartionCreatedate) {
        this.opeartionCreatedate = opeartionCreatedate;
    }

    public String getOpeartionInfo() {
        return opeartionInfo;
    }

    public void setOpeartionInfo(String opeartionInfo) {
        this.opeartionInfo = opeartionInfo == null ? null : opeartionInfo.trim();
    }

    public Integer getOpeartionType() {
        return opeartionType;
    }

    public void setOpeartionType(Integer opeartionType) {
        this.opeartionType = opeartionType;
    }

    public Integer getOpeartionById() {
        return opeartionById;
    }

    public void setOpeartionById(Integer opeartionById) {
        this.opeartionById = opeartionById;
    }

    public String getOpeartionCom() {
        return opeartionCom;
    }

    public void setOpeartionCom(String opeartionCom) {
        this.opeartionCom = opeartionCom == null ? null : opeartionCom.trim();
    }
}