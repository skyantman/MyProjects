package com.yundongjia.oa.admin.po;

public class TCoach {
    private Integer coachid;

    private Integer userid;

    private String gender;

    private Integer regionsid;

    private Double weight;

    private Double height;

    private Double courseprice;

    private Double singleprice;

    private String nickname;

    private String ischecked;

    private String workage;

    private String introduce;

    private String imgpath;

    private Integer imgstat;

    private String autograph;

    private String keywords;

    private Integer canclelimit;

    private Integer status;

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getRegionsid() {
        return regionsid;
    }

    public void setRegionsid(Integer regionsid) {
        this.regionsid = regionsid;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getCourseprice() {
        return courseprice;
    }

    public void setCourseprice(Double courseprice) {
        this.courseprice = courseprice;
    }

    public Double getSingleprice() {
        return singleprice;
    }

    public void setSingleprice(Double singleprice) {
        this.singleprice = singleprice;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getIschecked() {
        return ischecked;
    }

    public void setIschecked(String ischecked) {
        this.ischecked = ischecked == null ? null : ischecked.trim();
    }

    public String getWorkage() {
        return workage;
    }

    public void setWorkage(String workage) {
        this.workage = workage == null ? null : workage.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public Integer getImgstat() {
        return imgstat;
    }

    public void setImgstat(Integer imgstat) {
        this.imgstat = imgstat;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph == null ? null : autograph.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public Integer getCanclelimit() {
        return canclelimit;
    }

    public void setCanclelimit(Integer canclelimit) {
        this.canclelimit = canclelimit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}