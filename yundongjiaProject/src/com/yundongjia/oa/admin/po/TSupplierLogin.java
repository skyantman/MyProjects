package com.yundongjia.oa.admin.po;

public class TSupplierLogin {
    private Integer supplierloginid;

    private String loginmobilephone;

    private String loginpwd;

    private String logindate;

    public Integer getSupplierloginid() {
        return supplierloginid;
    }

    public void setSupplierloginid(Integer supplierloginid) {
        this.supplierloginid = supplierloginid;
    }

    public String getLoginmobilephone() {
        return loginmobilephone;
    }

    public void setLoginmobilephone(String loginmobilephone) {
        this.loginmobilephone = loginmobilephone == null ? null : loginmobilephone.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate == null ? null : logindate.trim();
    }
}