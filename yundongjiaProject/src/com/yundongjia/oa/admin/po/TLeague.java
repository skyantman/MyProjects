package com.yundongjia.oa.admin.po;

public class TLeague {
    private Integer leagueid;

    private String leanguename;

    private Integer studioid;

    private String datetime;

    private String workweekspan;

    private String worktimespan;

    private String resttimespan;

    private Integer hour;

    private Double totalprice;

    private String leaguedesc;

    private Integer maxman;

    private Integer alreadyman;

    private Integer appointmentman;

    public Integer getLeagueid() {
        return leagueid;
    }

    public void setLeagueid(Integer leagueid) {
        this.leagueid = leagueid;
    }

    public String getLeanguename() {
        return leanguename;
    }

    public void setLeanguename(String leanguename) {
        this.leanguename = leanguename == null ? null : leanguename.trim();
    }

    public Integer getStudioid() {
        return studioid;
    }

    public void setStudioid(Integer studioid) {
        this.studioid = studioid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime == null ? null : datetime.trim();
    }

    public String getWorkweekspan() {
        return workweekspan;
    }

    public void setWorkweekspan(String workweekspan) {
        this.workweekspan = workweekspan == null ? null : workweekspan.trim();
    }

    public String getWorktimespan() {
        return worktimespan;
    }

    public void setWorktimespan(String worktimespan) {
        this.worktimespan = worktimespan == null ? null : worktimespan.trim();
    }

    public String getResttimespan() {
        return resttimespan;
    }

    public void setResttimespan(String resttimespan) {
        this.resttimespan = resttimespan == null ? null : resttimespan.trim();
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getLeaguedesc() {
        return leaguedesc;
    }

    public void setLeaguedesc(String leaguedesc) {
        this.leaguedesc = leaguedesc == null ? null : leaguedesc.trim();
    }

    public Integer getMaxman() {
        return maxman;
    }

    public void setMaxman(Integer maxman) {
        this.maxman = maxman;
    }

    public Integer getAlreadyman() {
        return alreadyman;
    }

    public void setAlreadyman(Integer alreadyman) {
        this.alreadyman = alreadyman;
    }

    public Integer getAppointmentman() {
        return appointmentman;
    }

    public void setAppointmentman(Integer appointmentman) {
        this.appointmentman = appointmentman;
    }
}