package com.yundongjia.oa.admin.po;

public class TLeagueOrder {
    private Integer orderid;

    private Integer studioid;

    private Integer memberid;

    private Integer leagueid;

    private Double totalmoney;

    private String createdate;

    private String ordernum;

    private String paystatus;

    private String classstatus;

    private String comm;

    private String messagestatus;

    private String source;

    private String mobilephonenum;

    private String paytype;

    private Integer scoreid;
    
    private String type;

    private Double selfCardCoupon;
    
    public Double getSelfCardCoupon() {
		return selfCardCoupon;
	}

	public void setSelfCardCoupon(Double selfCardCoupon) {
		this.selfCardCoupon = selfCardCoupon;
	}
    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getStudioid() {
        return studioid;
    }

    public void setStudioid(Integer studioid) {
        this.studioid = studioid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(Integer leagueid) {
        this.leagueid = leagueid;
    }

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus == null ? null : paystatus.trim();
    }

    public String getClassstatus() {
        return classstatus;
    }

    public void setClassstatus(String classstatus) {
        this.classstatus = classstatus == null ? null : classstatus.trim();
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getMobilephonenum() {
        return mobilephonenum;
    }

    public void setMobilephonenum(String mobilephonenum) {
        this.mobilephonenum = mobilephonenum == null ? null : mobilephonenum.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }
}