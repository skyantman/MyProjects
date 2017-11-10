package com.yundongjia.oa.admin.service;

import com.yundongjia.oa.admin.po.TRole;

/**
 * 
* Title:com.yundongjia.oa.admin.service.impl 
* Description:角色层
* @author HuangJian
* @date 2016年11月8日
 */
public interface RoleService {

	/**
	 * 
	* Title: 
	* Description:根据用户查询角色
	* @author HuangJian
	* @date 2016年11月8日
	 */
	TRole getRoleById(Integer roleId);
}
