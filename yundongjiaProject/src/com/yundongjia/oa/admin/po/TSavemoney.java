package com.yundongjia.oa.admin.po;

public class TSavemoney {
    private Integer rowid;

    private Double savemoney;

    private Integer supplierid;

    private Integer opeartionid;

    private String createdate;

    private String expirydate;

    private String type;

    public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public Double getSavemoney() {
        return savemoney;
    }

    public void setSavemoney(Double savemoney) {
        this.savemoney = savemoney;
    }

    public Integer getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(Integer supplierid) {
        this.supplierid = supplierid;
    }

    public Integer getOpeartionid() {
        return opeartionid;
    }

    public void setOpeartionid(Integer opeartionid) {
        this.opeartionid = opeartionid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(String expirydate) {
        this.expirydate = expirydate == null ? null : expirydate.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}