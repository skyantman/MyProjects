package com.yundongjia.oa.admin.po;

public class TCoachUser {
    private Integer userid;

    private String mobilephoneno;

    private String password;

    private String createdate;

    private String isvalid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMobilephoneno() {
        return mobilephoneno;
    }

    public void setMobilephoneno(String mobilephoneno) {
        this.mobilephoneno = mobilephoneno == null ? null : mobilephoneno.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid == null ? null : isvalid.trim();
    }
}