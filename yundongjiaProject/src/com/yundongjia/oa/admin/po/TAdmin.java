package com.yundongjia.oa.admin.po;

public class TAdmin {
    private Integer backuserid;

    private String backusername;

    private String backuserpwd;

    private Integer backuserroleid;

    private String backusermobliephone;

    public Integer getBackuserid() {
        return backuserid;
    }

    public void setBackuserid(Integer backuserid) {
        this.backuserid = backuserid;
    }

    public String getBackusername() {
        return backusername;
    }

    public void setBackusername(String backusername) {
        this.backusername = backusername == null ? null : backusername.trim();
    }

    public String getBackuserpwd() {
        return backuserpwd;
    }

    public void setBackuserpwd(String backuserpwd) {
        this.backuserpwd = backuserpwd == null ? null : backuserpwd.trim();
    }

    public Integer getBackuserroleid() {
        return backuserroleid;
    }

    public void setBackuserroleid(Integer backuserroleid) {
        this.backuserroleid = backuserroleid;
    }

    public String getBackusermobliephone() {
        return backusermobliephone;
    }

    public void setBackusermobliephone(String backusermobliephone) {
        this.backusermobliephone = backusermobliephone == null ? null : backusermobliephone.trim();
    }
}