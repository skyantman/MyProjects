package com.yundongjia.oa.admin.po;

public class TPrivateLessonTime {
    private Integer rowid;

    private Integer coachid;

    private String lessondate;

    private String availabletimespan;

    private String unavailabletimespan;

    private String createdate;

    private String closeweek;

    public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public String getLessondate() {
        return lessondate;
    }

    public void setLessondate(String lessondate) {
        this.lessondate = lessondate == null ? null : lessondate.trim();
    }

    public String getAvailabletimespan() {
        return availabletimespan;
    }

    public void setAvailabletimespan(String availabletimespan) {
        this.availabletimespan = availabletimespan == null ? null : availabletimespan.trim();
    }

    public String getUnavailabletimespan() {
        return unavailabletimespan;
    }

    public void setUnavailabletimespan(String unavailabletimespan) {
        this.unavailabletimespan = unavailabletimespan == null ? null : unavailabletimespan.trim();
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }

    public String getCloseweek() {
        return closeweek;
    }

    public void setCloseweek(String closeweek) {
        this.closeweek = closeweek == null ? null : closeweek.trim();
    }
}