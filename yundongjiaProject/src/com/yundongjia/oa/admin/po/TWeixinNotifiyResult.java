package com.yundongjia.oa.admin.po;

public class TWeixinNotifiyResult {
    private Integer wxid;

    private String outtradeno;

    private Integer status;

    public Integer getWxid() {
        return wxid;
    }

    public void setWxid(Integer wxid) {
        this.wxid = wxid;
    }

    public String getOuttradeno() {
        return outtradeno;
    }

    public void setOuttradeno(String outtradeno) {
        this.outtradeno = outtradeno == null ? null : outtradeno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}