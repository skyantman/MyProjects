package com.yundongjia.oa.admin.service;


import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TRole;

/**
 * Created by ltlxy on 2016/9/29.
 */
public interface AuthService {


    int insertRole(TRole role,String[] authStr,String[] menuStr)throws Exception;

    List<TRole> selectRolesByStudioId(Integer studioId);

    int delectRoleById(Map<String, Object> param);

    List<Integer> selectMenuIdsByRoleId(Integer roleId);

    List<Integer> selectAutoIdsByRoleId(Integer roleId);

    int updateRole(TRole role,String[] authStr,String[] menuStr,Integer operatorId)throws Exception;
    /**
     * 
    * Title: 
    * Description:根据角色名称查询角色
    * @author HuangJian
    * @date 2016年11月11日
     */
    List<TRole> selectRoleByName(String roleName);
    /**
     * 
    * Title: 
    * Description:排重角色名称
    * @author Li XiaoYang
    * @date 2016年11月28日
     */
    Integer selectRoleName(String roleName);

	Integer updateAuthRole(String oldUserId, String newUserId, Integer roleId);
	
	List<TRole> selectRoleByStudioId();
	/**
     * 
    * Title: 
    * Description:查询工作人员根据场馆ID
     */
	List<Map> searchBUByType();
	
	List<Map> searchBUByTypeARole(Integer roleId);
}
