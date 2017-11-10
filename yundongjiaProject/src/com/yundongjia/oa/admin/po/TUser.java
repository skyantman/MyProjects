package com.yundongjia.oa.admin.po;

public class TUser {
    private Integer userid;

    private String unionid;

    private String mobilephoneno;

    private String password;

    private String usertype;

    private String createdate;

    private String isvalid;

    private String isvalidremark;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
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

    public String getIsvalidremark() {
        return isvalidremark;
    }

    public void setIsvalidremark(String isvalidremark) {
        this.isvalidremark = isvalidremark == null ? null : isvalidremark.trim();
    }
}