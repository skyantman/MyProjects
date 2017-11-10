package com.yundongjia.oa.admin.po;

public class TBodyfat {
    private Integer rowid;

    private Integer userid;

    private String measuretime;

    private String weight;

    private String bmi;

    private String bodyfat;

    private String subfat;

    private String visfat;

    private String water;

    private String bmr;

    private String muscle;

    private String bone;

    private String protein;

    private String gender;

    private String height;

    private String birthday;

    private String mm;

    private String onlynum;

    public Integer getRowid() {
        return rowid;
    }

    public void setRowid(Integer rowid) {
        this.rowid = rowid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMeasuretime() {
        return measuretime;
    }

    public void setMeasuretime(String measuretime) {
        this.measuretime = measuretime == null ? null : measuretime.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi == null ? null : bmi.trim();
    }

    public String getBodyfat() {
        return bodyfat;
    }

    public void setBodyfat(String bodyfat) {
        this.bodyfat = bodyfat == null ? null : bodyfat.trim();
    }

    public String getSubfat() {
        return subfat;
    }

    public void setSubfat(String subfat) {
        this.subfat = subfat == null ? null : subfat.trim();
    }

    public String getVisfat() {
        return visfat;
    }

    public void setVisfat(String visfat) {
        this.visfat = visfat == null ? null : visfat.trim();
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water == null ? null : water.trim();
    }

    public String getBmr() {
        return bmr;
    }

    public void setBmr(String bmr) {
        this.bmr = bmr == null ? null : bmr.trim();
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle == null ? null : muscle.trim();
    }

    public String getBone() {
        return bone;
    }

    public void setBone(String bone) {
        this.bone = bone == null ? null : bone.trim();
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein == null ? null : protein.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm == null ? null : mm.trim();
    }

    public String getOnlynum() {
        return onlynum;
    }

    public void setOnlynum(String onlynum) {
        this.onlynum = onlynum == null ? null : onlynum.trim();
    }
}