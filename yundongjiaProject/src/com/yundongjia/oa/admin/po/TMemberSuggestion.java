package com.yundongjia.oa.admin.po;

public class TMemberSuggestion {
    private Integer suggestionid;

    private String mobilephoneno;

    private String suggestioninfo;

    private Integer likerid;

    private Integer status;

    private String createdate;

    public Integer getSuggestionid() {
        return suggestionid;
    }

    public void setSuggestionid(Integer suggestionid) {
        this.suggestionid = suggestionid;
    }

    public String getMobilephoneno() {
        return mobilephoneno;
    }

    public void setMobilephoneno(String mobilephoneno) {
        this.mobilephoneno = mobilephoneno == null ? null : mobilephoneno.trim();
    }

    public String getSuggestioninfo() {
        return suggestioninfo;
    }

    public void setSuggestioninfo(String suggestioninfo) {
        this.suggestioninfo = suggestioninfo == null ? null : suggestioninfo.trim();
    }

    public Integer getLikerid() {
        return likerid;
    }

    public void setLikerid(Integer likerid) {
        this.likerid = likerid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate == null ? null : createdate.trim();
    }
}