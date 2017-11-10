package com.yundongjia.oa.admin.po;

public class TCardType {
    private Integer cardid;

    private String createdate;

    private Integer validdate;

    private String cardtype;

    private Integer sportscount;

    private String cardtypename;

    private Float carddiscount;

    private Integer stock;

    private Integer surplusstock;

    private Integer iscashback;

    private Double backmoney;

    private String amount;

    private String isdel;

    private String isstop;

    private String regionsid;

    private Integer opeartionadminid;

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public Integer getValiddate() {
        return validdate;
    }

    public void setValiddate(Integer validdate) {
        this.validdate = validdate;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public Integer getSportscount() {
        return sportscount;
    }

    public void setSportscount(Integer sportscount) {
        this.sportscount = sportscount;
    }

    public String getCardtypename() {
        return cardtypename;
    }

    public void setCardtypename(String cardtypename) {
        this.cardtypename = cardtypename == null ? null : cardtypename.trim();
    }

    public Float getCarddiscount() {
        return carddiscount;
    }

    public void setCarddiscount(Float carddiscount) {
        this.carddiscount = carddiscount;
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

    public Integer getIscashback() {
        return iscashback;
    }

    public void setIscashback(Integer iscashback) {
        this.iscashback = iscashback;
    }

    public Double getBackmoney() {
        return backmoney;
    }

    public void setBackmoney(Double backmoney) {
        this.backmoney = backmoney;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    public String getIsstop() {
        return isstop;
    }

    public void setIsstop(String isstop) {
        this.isstop = isstop == null ? null : isstop.trim();
    }

    public String getRegionsid() {
        return regionsid;
    }

    public void setRegionsid(String regionsid) {
        this.regionsid = regionsid == null ? null : regionsid.trim();
    }

    public Integer getOpeartionadminid() {
        return opeartionadminid;
    }

    public void setOpeartionadminid(Integer opeartionadminid) {
        this.opeartionadminid = opeartionadminid;
    }
}