package com.yundongjia.oa.admin.po;

public class TActivation {
    private Integer activationid;

    private Double amount;

    private String expirationdate;

    private String activationtype;

    private String createdate;

    private String cardnum;

    private Integer valid;

    private Integer memberid;

    private String comm;

    public Integer getActivationid() {
        return activationid;
    }

    public void setActivationid(Integer activationid) {
        this.activationid = activationid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate == null ? null : expirationdate.trim();
    }

    public String getActivationtype() {
        return activationtype;
    }

    public void setActivationtype(String activationtype) {
        this.activationtype = activationtype == null ? null : activationtype.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum == null ? null : cardnum.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm == null ? null : comm.trim();
    }
}