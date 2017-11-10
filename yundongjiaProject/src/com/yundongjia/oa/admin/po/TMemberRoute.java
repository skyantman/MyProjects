package com.yundongjia.oa.admin.po;

public class TMemberRoute {
    private Integer rowid;

    private Integer memberid;

    private Integer routenum;

    private String routedate;

    private String updatedate;

    public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getRoutenum() {
        return routenum;
    }

    public void setRoutenum(Integer routenum) {
        this.routenum = routenum;
    }

    public String getRoutedate() {
        return routedate;
    }

    public void setRoutedate(String routedate) {
        this.routedate = routedate == null ? null : routedate.trim();
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate == null ? null : updatedate.trim();
    }
}