package com.yundongjia.oa.admin.vo;


import java.util.ArrayList;
import java.util.List;

import com.yundongjia.oa.admin.po.TAuth;
import com.yundongjia.oa.admin.po.TMenu;

/**
 * Created by ltlxy on 2016/9/28.
 */
public class MenuVo extends TMenu{

    private TAuth auth;

    private List<MenuVo> menuVoList = new ArrayList<MenuVo>();

    private List<TAuth> authList = new ArrayList<TAuth>();

    public List<MenuVo> getMenuVoList() {
        return menuVoList;
    }

    public void setMenuVoList(List<MenuVo> menuVoList) {
        this.menuVoList = menuVoList;
    }

    public TAuth getAuth() {
        return auth;
    }

    public void setAuth(TAuth auth) {
        this.auth = auth;
    }

    public List<TAuth> getAuthList() {
        return authList;
    }

    public void setAuthList(List<TAuth> authList) {
        this.authList = authList;
    }
}
