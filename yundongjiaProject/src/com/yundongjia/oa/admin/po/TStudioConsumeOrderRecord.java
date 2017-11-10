package com.yundongjia.oa.admin.po;

public class TStudioConsumeOrderRecord {
	private Integer orderid;

	private String paytype;

	private String createdate;

	private Integer memberid;

	private Integer studioid;

	private String comm;

	private Integer scoreid;

	private Double totalmoney;

	private Integer subcount;

	private Integer source;

	private Integer paystatus;

	private Integer messagestatus;

	private String ordernum;

	private String mobilephonenum;

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

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype == null ? null : paytype.trim();
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate == null ? null : createdate.trim();
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public Integer getStudioid() {
		return studioid;
	}

	public void setStudioid(Integer studioid) {
		this.studioid = studioid;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm == null ? null : comm.trim();
	}

	public Integer getScoreid() {
		return scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}

	public Double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}

	public Integer getSubcount() {
		return subcount;
	}

	public void setSubcount(Integer subcount) {
		this.subcount = subcount;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}

	public Integer getMessagestatus() {
		return messagestatus;
	}

	public void setMessagestatus(Integer messagestatus) {
		this.messagestatus = messagestatus;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum == null ? null : ordernum.trim();
	}

	public String getMobilephonenum() {
		return mobilephonenum;
	}

	public void setMobilephonenum(String mobilephonenum) {
		this.mobilephonenum = mobilephonenum == null ? null : mobilephonenum.trim();
	}
}