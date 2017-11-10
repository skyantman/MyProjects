/*
* @author HuangJian
* @date 2017年1月9日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TOpeartion;

public interface OpeartionService {

	/*
	 * 
	* Title: saveOpeartion
	* Description: 保存操作记录
	* @author HuangJian
	* @date 2017年1月9日
	 */
	public int saveOpeartion(TOpeartion op);
	/*
	 * 
	* Title: findOpeartion
	* Description: 获得操作记录   opeartionType:标识  dataId:数据id
	* @author HuangJian
	* @date 2017年1月9日
	 */
	public List<Map<String, Object>> findOpeartion(Integer opeartionType,Integer dataId);
	
	
	/**
	* Title: findOpeartionByOpearType
	* Description: 根据类型查询，不用根据数据查询
	* @param opeartionType:菜单类型
	* @return 
	* @author HuangJian
	* @date 2017年1月16日
	*/
	public List<Map<String, Object>> findOpeartionByOpearType(Integer opeartionType);
	
	/**
	* Title: findOrderOpeartionById
	* Description: 查询订单操作记录
	* @param orderId
	* @param orderType
	* @return
	* @author HuangJian
	* @date 2017年2月9日
	*/
	public List<Map<String, Object>> findOrderOpeartionById(Integer orderId,String orderType,Integer opearType);
}

