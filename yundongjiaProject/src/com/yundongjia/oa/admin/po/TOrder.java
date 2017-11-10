package com.yundongjia.oa.admin.po;

public class TOrder {
	private Integer orderid;

	private String ordernum;

	private Integer coachid;

	private Integer hour;

	private Double totalmoney;

	private String source;

	private String createdate;

	private String timespan;

	private String classdate;

	private Integer paystatus;

	private Integer messagestatus;

	private String comm;

	private Integer memberid;

	private Integer studioid;

	private String classstatus;

	private String paytype;

	private Integer opeartionid;

	private String mobilephonenum;

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

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum == null ? null : ordernum.trim();
	}

	public Integer getCoachid() {
		return coachid;
	}

	public void setCoachid(Integer coachid) {
		this.coachid = coachid;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	public Double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate == null ? null : createdate.trim();
	}

	public String getTimespan() {
		return timespan;
	}

	public void setTimespan(String timespan) {
		this.timespan = timespan == null ? null : timespan.trim();
	}

	public String getClassdate() {
		return classdate;
	}

	public void setClassdate(String classdate) {
		this.classdate = classdate == null ? null : classdate.trim();
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

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm == null ? null : comm.trim();
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

	public String getClassstatus() {
		return classstatus;
	}

	public void setClassstatus(String classstatus) {
		this.classstatus = classstatus == null ? null : classstatus.trim();
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype == null ? null : paytype.trim();
	}

	public Integer getOpeartionid() {
		return opeartionid;
	}

	public void setOpeartionid(Integer opeartionid) {
		this.opeartionid = opeartionid;
	}

	public String getMobilephonenum() {
		return mobilephonenum;
	}

	public void setMobilephonenum(String mobilephonenum) {
		this.mobilephonenum = mobilephonenum == null ? null : mobilephonenum.trim();
	}

	public Integer getScoreid() {
		return scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}
}