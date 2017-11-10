package com.yundongjia.oa.admin.po;

public class TMember {
    private Integer memberid;

    private Integer userid;

    private String nickname;

    private String borndate;

    private String gender;

    private Double height;

    private String waist;

    private String imgpath;

    private String autograph;

    private String firstlogdate;

    private Double redamount;

    private String department;

    private String email;

    private Integer regionsid;

    private Double balance;

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate == null ? null : borndate.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist == null ? null : waist.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph == null ? null : autograph.trim();
    }

    public String getFirstlogdate() {
        return firstlogdate;
    }

    public void setFirstlogdate(String firstlogdate) {
        this.firstlogdate = firstlogdate == null ? null : firstlogdate.trim();
    }

    public Double getRedamount() {
        return redamount;
    }

    public void setRedamount(Double redamount) {
        this.redamount = redamount;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getRegionsid() {
        return regionsid;
    }

    public void setRegionsid(Integer regionsid) {
        this.regionsid = regionsid;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}