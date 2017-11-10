package com.yundongjia.oa.admin.po;

public class TApplyAccount {
    private Integer rowdid;

    private String accountno;

    private String accountname;

    private Integer likeid;

    private Integer liketype;

    private String status;

    private String createdate;

    private String type;

    public Integer getRowdid() {
        return rowdid;
    }

    public void setRowdid(Integer rowdid) {
        this.rowdid = rowdid;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno == null ? null : accountno.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public Integer getLikeid() {
        return likeid;
    }

    public void setLikeid(Integer likeid) {
        this.likeid = likeid;
    }

    public Integer getLiketype() {
        return liketype;
    }

    public void setLiketype(Integer liketype) {
        this.liketype = liketype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}