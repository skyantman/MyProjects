package com.yundongjia.oa.admin.po;

import java.util.Map;

public class TSupplier {
    private Integer rowid;

    private Integer supplierloginid;

    private String suppliername;

    private String mobilephonenum;

    private String linkmanname;

    private Integer regionsid;

    private String address;

    private Integer clearingtype;

    private Integer periodclearing;

    private Integer stratus;

    private String linkstudioid;

    private String likestudiocostprice;

    private String linkcoachid;

    private String likecoachcostprice;

    private String linkgoodsid;

    private String likegoodscostprice;

    private Double balance;

    private Integer status;

    private Double savemoney;

    private Double supersavemoney;

    private String savemoneyexpiredate;
    
    private String city;
    
    private Map<String , Object> info;
    
    
    public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public Integer getSupplierloginid() {
        return supplierloginid;
    }

    public void setSupplierloginid(Integer supplierloginid) {
        this.supplierloginid = supplierloginid;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername == null ? null : suppliername.trim();
    }

    public String getMobilephonenum() {
        return mobilephonenum;
    }

    public void setMobilephonenum(String mobilephonenum) {
        this.mobilephonenum = mobilephonenum == null ? null : mobilephonenum.trim();
    }

    public String getLinkmanname() {
        return linkmanname;
    }

    public void setLinkmanname(String linkmanname) {
        this.linkmanname = linkmanname == null ? null : linkmanname.trim();
    }

    public Integer getRegionsid() {
        return regionsid;
    }

    public void setRegionsid(Integer regionsid) {
        this.regionsid = regionsid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getClearingtype() {
        return clearingtype;
    }

    public void setClearingtype(Integer clearingtype) {
        this.clearingtype = clearingtype;
    }

    public Integer getPeriodclearing() {
        return periodclearing;
    }

    public void setPeriodclearing(Integer periodclearing) {
        this.periodclearing = periodclearing;
    }

    public Integer getStratus() {
        return stratus;
    }

    public void setStratus(Integer stratus) {
        this.stratus = stratus;
    }

    public String getLinkstudioid() {
        return linkstudioid;
    }

    public void setLinkstudioid(String linkstudioid) {
        this.linkstudioid = linkstudioid == null ? null : linkstudioid.trim();
    }

    public String getLikestudiocostprice() {
        return likestudiocostprice;
    }

    public void setLikestudiocostprice(String likestudiocostprice) {
        this.likestudiocostprice = likestudiocostprice == null ? null : likestudiocostprice.trim();
    }

    public String getLinkcoachid() {
        return linkcoachid;
    }

    public void setLinkcoachid(String linkcoachid) {
        this.linkcoachid = linkcoachid == null ? null : linkcoachid.trim();
    }

    public String getLikecoachcostprice() {
        return likecoachcostprice;
    }

    public void setLikecoachcostprice(String likecoachcostprice) {
        this.likecoachcostprice = likecoachcostprice == null ? null : likecoachcostprice.trim();
    }

    public String getLinkgoodsid() {
        return linkgoodsid;
    }

    public void setLinkgoodsid(String linkgoodsid) {
        this.linkgoodsid = linkgoodsid == null ? null : linkgoodsid.trim();
    }

    public String getLikegoodscostprice() {
        return likegoodscostprice;
    }

    public void setLikegoodscostprice(String likegoodscostprice) {
        this.likegoodscostprice = likegoodscostprice == null ? null : likegoodscostprice.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getSavemoney() {
        return savemoney;
    }

    public void setSavemoney(Double savemoney) {
        this.savemoney = savemoney;
    }

    public Double getSupersavemoney() {
        return supersavemoney;
    }

    public void setSupersavemoney(Double supersavemoney) {
        this.supersavemoney = supersavemoney;
    }

    public String getSavemoneyexpiredate() {
        return savemoneyexpiredate;
    }

    public void setSavemoneyexpiredate(String savemoneyexpiredate) {
        this.savemoneyexpiredate = savemoneyexpiredate == null ? null : savemoneyexpiredate.trim();
    }
}