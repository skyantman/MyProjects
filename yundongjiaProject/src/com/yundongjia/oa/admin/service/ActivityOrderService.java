/**
* @author HuangJian
* @date 2017年2月8日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.yundongjia.oa.admin.po.TActivityOrder;


public interface ActivityOrderService {

	/**
	* Title: findActivityOrders
	* Description: 全查订单 或手机号查询
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	public List<Map<String, Object>> findActivityOrders(Map<String, Object> param);
	
	/**
	* Title: selectActivityOrderStatisByPayStatus
	* Description: 根据支付状态统计
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	public Map<String, Object> selectActivityOrderStatisByPayStatus();
	
	/**
	* Title: updateActivityOrderById
	* Description: 修改订单
	* @param activityOrder
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	public Integer updateActivityOrderById(TActivityOrder activityOrder); 
}

