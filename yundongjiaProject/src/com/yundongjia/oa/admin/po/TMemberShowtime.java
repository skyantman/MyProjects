package com.yundongjia.oa.admin.po;

public class TMemberShowtime {
    private Integer timeid;

    private String showstarttime;

    private String showendtime;

    private String timespan;

    private Integer memberid;

    private Integer studioid;

    private String isshowover;

    private String millisecond;

    public Integer getTimeid() {
        return timeid;
    }

    public void setTimeid(Integer timeid) {
        this.timeid = timeid;
    }

    public String getShowstarttime() {
        return showstarttime;
    }

    public void setShowstarttime(String showstarttime) {
        this.showstarttime = showstarttime == null ? null : showstarttime.trim();
    }

    public String getShowendtime() {
        return showendtime;
    }

    public void setShowendtime(String showendtime) {
        this.showendtime = showendtime == null ? null : showendtime.trim();
    }

    public String getTimespan() {
        return timespan;
    }

    public void setTimespan(String timespan) {
        this.timespan = timespan == null ? null : timespan.trim();
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

    public String getIsshowover() {
        return isshowover;
    }

    public void setIsshowover(String isshowover) {
        this.isshowover = isshowover == null ? null : isshowover.trim();
    }

    public String getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(String millisecond) {
        this.millisecond = millisecond == null ? null : millisecond.trim();
    }
}