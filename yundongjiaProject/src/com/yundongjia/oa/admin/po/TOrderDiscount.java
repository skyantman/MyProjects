package com.yundongjia.oa.admin.po;

public class TOrderDiscount {
    private Integer rowid;

    private Integer orderid;

    private Integer status;

    private Double redpackage;

    private Double selfcard;

    private Double coupon;

    private Double payditch;

    private Integer cardid;

    private Integer couponid;

    private Double orderrealmoney;

    private String retreatdate;

    private Integer enterprisecardid;

    private Integer enterprisecardsubnum;

    public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getRedpackage() {
        return redpackage;
    }

    public void setRedpackage(Double redpackage) {
        this.redpackage = redpackage;
    }

    public Double getSelfcard() {
        return selfcard;
    }

    public void setSelfcard(Double selfcard) {
        this.selfcard = selfcard;
    }

    public Double getCoupon() {
        return coupon;
    }

    public void setCoupon(Double coupon) {
        this.coupon = coupon;
    }

    public Double getPayditch() {
        return payditch;
    }

    public void setPayditch(Double payditch) {
        this.payditch = payditch;
    }

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public Double getOrderrealmoney() {
        return orderrealmoney;
    }

    public void setOrderrealmoney(Double orderrealmoney) {
        this.orderrealmoney = orderrealmoney;
    }

    public String getRetreatdate() {
        return retreatdate;
    }

    public void setRetreatdate(String retreatdate) {
        this.retreatdate = retreatdate == null ? null : retreatdate.trim();
    }

    public Integer getEnterprisecardid() {
        return enterprisecardid;
    }

    public void setEnterprisecardid(Integer enterprisecardid) {
        this.enterprisecardid = enterprisecardid;
    }

    public Integer getEnterprisecardsubnum() {
        return enterprisecardsubnum;
    }

    public void setEnterprisecardsubnum(Integer enterprisecardsubnum) {
        this.enterprisecardsubnum = enterprisecardsubnum;
    }
}