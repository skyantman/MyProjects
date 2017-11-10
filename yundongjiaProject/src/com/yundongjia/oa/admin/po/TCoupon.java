package com.yundongjia.oa.admin.po;

public class TCoupon {
    private Integer couponid;

    private String couponname;

    private Double amount;

    private String discount;

    private String coupontype;

    private String couponmethod;

    private Double maxmoney;

    private String createdate;

    private Integer stock;

    private Integer surplusstock;

    private Double startmoney;

    private Integer validday;

    private String comm;

    private Integer isdel;

    private Integer status;

    private Integer opeartionadminid;

    private Integer usestock;
    
    private String opeartionadminname;

    
	public String getOpeartionadminname() {
		return opeartionadminname;
	}

	public void setOpeartionadminname(String opeartionadminname) {
		this.opeartionadminname = opeartionadminname;
	}

	public Integer getUsestock() {
		return usestock;
	}

	public void setUsestock(Integer usestock) {
		this.usestock = usestock;
	}

	public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public String getCouponname() {
        return couponname;
    }

    public void setCouponname(String couponname) {
        this.couponname = couponname == null ? null : couponname.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
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

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSurplusstock() {
        return surplusstock;
    }

    public void setSurplusstock(Integer surplusstock) {
        this.surplusstock = surplusstock;
    }

    public Double getStartmoney() {
        return startmoney;
    }

    public void setStartmoney(Double startmoney) {
        this.startmoney = startmoney;
    }

    public Integer getValidday() {
        return validday;
    }

    public void setValidday(Integer validday) {
        this.validday = validday;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm == null ? null : comm.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOpeartionadminid() {
        return opeartionadminid;
    }

    public void setOpeartionadminid(Integer opeartionadminid) {
        this.opeartionadminid = opeartionadminid;
    }
}