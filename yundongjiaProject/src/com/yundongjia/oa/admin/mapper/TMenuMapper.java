package com.yundongjia.oa.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundongjia.oa.admin.po.TMenu;
import com.yundongjia.oa.admin.po.TMenuExample;
import com.yundongjia.oa.admin.vo.MenuVo;

public interface TMenuMapper {
    int countByExample(TMenuExample example);

    int deleteByExample(TMenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    List<TMenu> selectByExample(TMenuExample example);

    TMenu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") TMenu record, @Param("example") TMenuExample example);

    int updateByExample(@Param("record") TMenu record, @Param("example") TMenuExample example);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
    
    List<TMenu> selectUserMenuByUserId(Map map);
    
    List<MenuVo> selectGYMTree();
    /**
     * 
    * Title: 
    * Description:查询健身房菜单  
    *    菜单管理：展示时需要去重
   		权限管理：展示时不需要去重
     */
    List<MenuVo> findBaseMenuTree(@Param("param") Map<String, Object> param);
    /**
     * 
    * Title: 
    * Description:删除根节点 修改操作
     */
    int updateBaseMenuByPid(Integer pId);
    /**
     * 
    * Title: 
    * Description:删除子节点 修改操作
     */
    int updateBaseMenuById(Integer id);
}