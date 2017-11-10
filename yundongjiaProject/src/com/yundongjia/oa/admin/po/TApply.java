package com.yundongjia.oa.admin.po;

public class TApply {
    private Integer rowid;

    private String ordernum;

    private Double amount;

    private String createdate;

    private String paystatus;

    private String messagestatus;

    private String ordermemo;

    private String applystatus;

    private String status;

    private Integer appaccountid;

    public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public String getMessagestatus() {
        return messagestatus;
    }

    public void setMessagestatus(String messagestatus) {
        this.messagestatus = messagestatus == null ? null : messagestatus.trim();
    }

    public String getOrdermemo() {
        return ordermemo;
    }

    public void setOrdermemo(String ordermemo) {
        this.ordermemo = ordermemo == null ? null : ordermemo.trim();
    }

    public String getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(String applystatus) {
        this.applystatus = applystatus == null ? null : applystatus.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getAppaccountid() {
        return appaccountid;
    }

    public void setAppaccountid(Integer appaccountid) {
        this.appaccountid = appaccountid;
    }
}