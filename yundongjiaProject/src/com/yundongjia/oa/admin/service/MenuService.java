package com.yundongjia.oa.admin.service;


import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TMenu;
import com.yundongjia.oa.admin.vo.MenuVo;

/**
 * Created by ltlxy on 2016/9/20.
 */
public interface MenuService {

	/*
	 * 
	* Title: getList
	* Description: 查询没有删除的菜单
	* @author HuangJian
	* @date 2017年1月6日
	 */
    List<TMenu> getList();


    List<TMenu> getGYMAdminList();

    List<MenuVo> selectGYMTree();

    /**
     * 
    * Title: 
    * Description:得到总控的菜单    userType=2 健身房菜单，1:总控菜单
    * @author HuangJian
    * @date 2016年11月7日
     */
    List<MenuVo> selectTCTree(Map<String, Object> map);
    
    /**
     * 
    * Title: 
    * Description:得到菜单集合之后 组装树  mt 1总控 2.健身房
    * @author HuangJian
    * @date 2016年10月22日
     */
    List<MenuVo> findTreeBulider(Map<String, Object> map);
    
    /**
     * 
    * Title: 
    * Description:删除菜单  首先查询这个id是不是根节点  1:删除所有的子节点  0:删除当前节点
    * @author HuangJian
    * @date 2016年10月22日
     */
    int deleteBaseMenuById(Integer id);
    
    /**
     * 
    * Title: 
    * Description:添加菜单   isRoot:true 是父节点，把pid默认为主键
    * @author HuangJian
    * @date 2016年10月22日
     */
    int saveBaseMenu(TMenu menu,boolean isRoot);
    /**
     * 
    * Title: 
    * Description:修改菜单信息
    * @author HuangJian
    * @date 2016年10月22日
     */
    int updateBaseMenu(TMenu menu);
    /**
     * 
    * Title: 
    * Description:根据id查询对象
    * @author HuangJian
    * @date 2016年10月24日
     */
    TMenu selectBaseMenuById(Integer mId);
    /**
     * 
    * Title: 
    * Description:根据某个子节点查根节点
    * @author HuangJian
    * @date 2016年10月24日
     */
    TMenu selectBaseMenuByPid(Integer pId);
    
    
    /**
     * 
    * Title: 
    * Description:查询此权限标识是否存在
    * @author HuangJian
    * @date 2016年11月10日
     */
    List<TMenu> selectBaseMenuByPowerid(String pwoerid);
}
