package com.yundongjia.oa.admin.po;

public class TAttach {
    private Integer attachid;

    private String path;

    private Integer imgordernum;

    private String imgwidth;

    private String imgheight;

    private Integer isdel;

    private Integer attachtype;

    private Integer proid;

    public Integer getAttachid() {
        return attachid;
    }

    public void setAttachid(Integer attachid) {
        this.attachid = attachid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getImgordernum() {
        return imgordernum;
    }

    public void setImgordernum(Integer imgordernum) {
        this.imgordernum = imgordernum;
    }

    public String getImgwidth() {
        return imgwidth;
    }

    public void setImgwidth(String imgwidth) {
        this.imgwidth = imgwidth == null ? null : imgwidth.trim();
    }

    public String getImgheight() {
        return imgheight;
    }

    public void setImgheight(String imgheight) {
        this.imgheight = imgheight == null ? null : imgheight.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Integer getAttachtype() {
        return attachtype;
    }

    public void setAttachtype(Integer attachtype) {
        this.attachtype = attachtype;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }
}