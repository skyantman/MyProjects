package com.yundongjia.oa.admin.po;

public class TMenu {
    private Integer menuId;

    private String menuStatus;

    private String menuPid;

    private String menuName;

    private Integer menuOrdernum;

    private Byte menuIsshow;

    private String menuPathname;

    private Byte menuIsroot;

    private Byte menuIsdel;

    private String menuPowerid;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus == null ? null : menuStatus.trim();
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid == null ? null : menuPid.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuOrdernum() {
        return menuOrdernum;
    }

    public void setMenuOrdernum(Integer menuOrdernum) {
        this.menuOrdernum = menuOrdernum;
    }

    public Byte getMenuIsshow() {
        return menuIsshow;
    }

    public void setMenuIsshow(Byte menuIsshow) {
        this.menuIsshow = menuIsshow;
    }

    public String getMenuPathname() {
        return menuPathname;
    }

    public void setMenuPathname(String menuPathname) {
        this.menuPathname = menuPathname == null ? null : menuPathname.trim();
    }

    public Byte getMenuIsroot() {
        return menuIsroot;
    }

    public void setMenuIsroot(Byte menuIsroot) {
        this.menuIsroot = menuIsroot;
    }

    public Byte getMenuIsdel() {
        return menuIsdel;
    }

    public void setMenuIsdel(Byte menuIsdel) {
        this.menuIsdel = menuIsdel;
    }

    public String getMenuPowerid() {
        return menuPowerid;
    }

    public void setMenuPowerid(String menuPowerid) {
        this.menuPowerid = menuPowerid == null ? null : menuPowerid.trim();
    }
}