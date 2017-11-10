package com.yundongjia.oa.admin.po;

public class TEnterprise {
    private Integer enterpriseId;

    private Integer regionsid;

    private Integer operationid;

    private String enterprisename;

    private String enterprisescale;

    private String enterpriselogo;

    private String createdate;

    private String enterpriseaddr;

    private String enterprisetel;

    private String contactname;

    private String isdel;

    private Integer isactivity;

    private String comm;

    private Integer status;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Integer getRegionsid() {
        return regionsid;
    }

    public void setRegionsid(Integer regionsid) {
        this.regionsid = regionsid;
    }

    public Integer getOperationid() {
        return operationid;
    }

    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename == null ? null : enterprisename.trim();
    }

    public String getEnterprisescale() {
        return enterprisescale;
    }

    public void setEnterprisescale(String enterprisescale) {
        this.enterprisescale = enterprisescale == null ? null : enterprisescale.trim();
    }

    public String getEnterpriselogo() {
        return enterpriselogo;
    }

    public void setEnterpriselogo(String enterpriselogo) {
        this.enterpriselogo = enterpriselogo == null ? null : enterpriselogo.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getEnterpriseaddr() {
        return enterpriseaddr;
    }

    public void setEnterpriseaddr(String enterpriseaddr) {
        this.enterpriseaddr = enterpriseaddr == null ? null : enterpriseaddr.trim();
    }

    public String getEnterprisetel() {
        return enterprisetel;
    }

    public void setEnterprisetel(String enterprisetel) {
        this.enterprisetel = enterprisetel == null ? null : enterprisetel.trim();
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel == null ? null : isdel.trim();
    }

    public Integer getIsactivity() {
        return isactivity;
    }

    public void setIsactivity(Integer isactivity) {
        this.isactivity = isactivity;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm == null ? null : comm.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}