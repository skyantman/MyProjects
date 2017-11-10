package com.yundongjia.oa.admin.po;

public class TJpush {
    private Integer id;

    private String title;

    private String content;

    private String time;

    private String url;

    private String remarks;

    private String jpushtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getJpushtype() {
        return jpushtype;
    }

    public void setJpushtype(String jpushtype) {
        this.jpushtype = jpushtype == null ? null : jpushtype.trim();
    }
}