package com.yundongjia.oa.admin.po;

public class TMemberCouponRef {
    private Integer rowid;

    private Integer couponid;

    private Integer memberid;

    private Integer orderid;

    private String status;

    private String createdate;

    private String expirtiondate;

    private Double discountamount;

    private String coupontype;

    private String couponmethod;

    private Double maxmoney;

    private Double startmoney;

    private Integer gainmethod;

    private Double realmoney;
    
    private String usermobilephoneno;
    
    private String couponname;
    
    public String getCouponname() {
		return couponname;
	}

	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}

	public String getUsermobilephoneno() {
		return usermobilephoneno;
	}

	public void setUsermobilephoneno(String usermobilephoneno) {
		this.usermobilephoneno = usermobilephoneno;
	}

	public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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

    public String getExpirtiondate() {
        return expirtiondate;
    }

    public void setExpirtiondate(String expirtiondate) {
        this.expirtiondate = expirtiondate == null ? null : expirtiondate.trim();
    }

    public Double getDiscountamount() {
        return discountamount;
    }

    public void setDiscountamount(Double discountamount) {
        this.discountamount = discountamount;
    }

    public String getCoupontype() {
        return coupontype;
    }

    public void setCoupontype(String coupontype) {
        this.coupontype = coupontype == null ? null : coupontype.trim();
    }

    public String getCouponmethod() {
        return couponmethod;
    }

    public void setCouponmethod(String couponmethod) {
        this.couponmethod = couponmethod == null ? null : couponmethod.trim();
    }

    public Double getMaxmoney() {
        return maxmoney;
    }

    public void setMaxmoney(Double maxmoney) {
        this.maxmoney = maxmoney;
    }

    public Double getStartmoney() {
        return startmoney;
    }

    public void setStartmoney(Double startmoney) {
        this.startmoney = startmoney;
    }

    public Integer getGainmethod() {
        return gainmethod;
    }

    public void setGainmethod(Integer gainmethod) {
        this.gainmethod = gainmethod;
    }

    public Double getRealmoney() {
        return realmoney;
    }

    public void setRealmoney(Double realmoney) {
        this.realmoney = realmoney;
    }
}