package com.yundongjia.oa.admin.po;

public class TConfig {
    private Integer id;

    private String cname;

    private String cvalue;

    private Integer stat;

    private String ccom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCvalue() {
        return cvalue;
    }

    public void setCvalue(String cvalue) {
        this.cvalue = cvalue == null ? null : cvalue.trim();
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public String getCcom() {
        return ccom;
    }

    public void setCcom(String ccom) {
        this.ccom = ccom == null ? null : ccom.trim();
    }
}