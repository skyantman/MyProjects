package com.yundongjia.oa.admin.po;

public class TActivityOrder {
    private Integer orderid;

    private Integer activityid;

    private String aname;

    private String gender;

    private String mobilephonenum;

    private String beinvitername;

    private Integer scoreid;

    private String beinviterphone;

    private String createdate;

    private Integer memberid;

    private Double totalmoney;

    private String ordernum;

    private String goodname;

    private Integer joinman;

    private String paytype;

    private String source;

    private String paystatus;

    private String comm;

    private String messagestatus;

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

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getMobilephonenum() {
        return mobilephonenum;
    }

    public void setMobilephonenum(String mobilephonenum) {
        this.mobilephonenum = mobilephonenum == null ? null : mobilephonenum.trim();
    }

    public String getBeinvitername() {
        return beinvitername;
    }

    public void setBeinvitername(String beinvitername) {
        this.beinvitername = beinvitername == null ? null : beinvitername.trim();
    }

    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public String getBeinviterphone() {
        return beinviterphone;
    }

    public void setBeinviterphone(String beinviterphone) {
        this.beinviterphone = beinviterphone == null ? null : beinviterphone.trim();
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

    public Double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }

    public Integer getJoinman() {
        return joinman;
    }

    public void setJoinman(Integer joinman) {
        this.joinman = joinman;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
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
}