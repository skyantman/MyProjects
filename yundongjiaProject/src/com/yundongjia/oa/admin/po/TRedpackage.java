package com.yundongjia.oa.admin.po;

public class TRedpackage {
    private Integer redid;

    private Double amount;

    private String createdate;

    private Integer type;

    private Integer memberid;

    private String expiredate;
    
    private String mobilephoneno;
    

	public String getMobilephoneno() {
		return mobilephoneno;
	}

	public void setMobilephoneno(String mobilephoneno) {
		this.mobilephoneno = mobilephoneno;
	}

	public Integer getRedid() {
        return redid;
    }

    public void setRedid(Integer redid) {
        this.redid = redid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate == null ? null : expiredate.trim();
    }
}