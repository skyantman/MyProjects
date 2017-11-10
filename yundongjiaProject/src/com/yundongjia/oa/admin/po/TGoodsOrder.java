package com.yundongjia.oa.admin.po;

public class TGoodsOrder {
	private Integer orderid;

	private Integer gid;

	private Integer memberid;

	private String createdate;

	private String mobilephonenum;

	private String membername;

	private String shippername;

	private String shipperphone;

	private String paytype;

	private Integer messagestatus;

	private String addr;

	private Integer buynum;

	private Double price;

	private Double totalmoney;

	private String expresstype;

	private String expressnum;

	private Integer paystatus;

	private String ordernum;

	private Double freight;

	private String comm;

	private String source;

	private Integer opeartionid;

	private Integer scoreid;

    private String type;

    private Double selfCardCoupon;
    
    
    public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

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
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate == null ? null : createdate.trim();
	}

	public String getMobilephonenum() {
		return mobilephonenum;
	}

	public void setMobilephonenum(String mobilephonenum) {
		this.mobilephonenum = mobilephonenum == null ? null : mobilephonenum.trim();
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername == null ? null : membername.trim();
	}

	public String getShippername() {
		return shippername;
	}

	public void setShippername(String shippername) {
		this.shippername = shippername == null ? null : shippername.trim();
	}

	public String getShipperphone() {
		return shipperphone;
	}

	public void setShipperphone(String shipperphone) {
		this.shipperphone = shipperphone == null ? null : shipperphone.trim();
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype == null ? null : paytype.trim();
	}

	public Integer getMessagestatus() {
		return messagestatus;
	}

	public void setMessagestatus(Integer messagestatus) {
		this.messagestatus = messagestatus;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr == null ? null : addr.trim();
	}

	public Integer getBuynum() {
		return buynum;
	}

	public void setBuynum(Integer buynum) {
		this.buynum = buynum;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}

	public String getExpresstype() {
		return expresstype;
	}

	public void setExpresstype(String expresstype) {
		this.expresstype = expresstype == null ? null : expresstype.trim();
	}

	public String getExpressnum() {
		return expressnum;
	}

	public void setExpressnum(String expressnum) {
		this.expressnum = expressnum == null ? null : expressnum.trim();
	}

	public Integer getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum == null ? null : ordernum.trim();
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm == null ? null : comm.trim();
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public Integer getOpeartionid() {
		return opeartionid;
	}

	public void setOpeartionid(Integer opeartionid) {
		this.opeartionid = opeartionid;
	}

	public Integer getScoreid() {
		return scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}
}