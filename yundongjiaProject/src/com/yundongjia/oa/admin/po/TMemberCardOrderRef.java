package com.yundongjia.oa.admin.po;

public class TMemberCardOrderRef {
    private Integer orderid;

    private Integer cardtypeid;

    private Integer memberid;

    private Float discount;

    private Double totalmoney;

    private Double realmoney;

    private Double cashback;

    private String cardorder;

    private String paytype;

    private Integer validday;

    private Integer status;

    private Integer isdel;

    private String expiredate;

    private String createdate;

    private Integer enterpriseid;

    private Integer sportscount;

    private Integer surplussportscount;

    private String self;

    private String ordernum;

    private String source;

    private String paystatus;

    private String comm;

    private String messagestatus;

    private String mobilephonenum;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getCardtypeid() {
        return cardtypeid;
    }

    public void setCardtypeid(Integer cardtypeid) {
        this.cardtypeid = cardtypeid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Double getRealmoney() {
        return realmoney;
    }

    public void setRealmoney(Double realmoney) {
        this.realmoney = realmoney;
    }

    public Double getCashback() {
        return cashback;
    }

    public void setCashback(Double cashback) {
        this.cashback = cashback;
    }

    public String getCardorder() {
        return cardorder;
    }

    public void setCardorder(String cardorder) {
        this.cardorder = cardorder == null ? null : cardorder.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Integer getValidday() {
        return validday;
    }

    public void setValidday(Integer validday) {
        this.validday = validday;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate == null ? null : expiredate.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    public Integer getSportscount() {
        return sportscount;
    }

    public void setSportscount(Integer sportscount) {
        this.sportscount = sportscount;
    }

    public Integer getSurplussportscount() {
        return surplussportscount;
    }

    public void setSurplussportscount(Integer surplussportscount) {
        this.surplussportscount = surplussportscount;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self == null ? null : self.trim();
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm == null ? null : comm.trim();
    }

    public String getMessagestatus() {
        return messagestatus;
    }

    public void setMessagestatus(String messagestatus) {
        this.messagestatus = messagestatus == null ? null : messagestatus.trim();
    }

    public String getMobilephonenum() {
        return mobilephonenum;
    }

    public void setMobilephonenum(String mobilephonenum) {
        this.mobilephonenum = mobilephonenum == null ? null : mobilephonenum.trim();
    }
}