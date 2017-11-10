/**
* @author HuangJian
* @date 2017年2月3日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.vo.OrderSearchVo;

public interface OrderService {

	/**
	* Title: findOrderList
	* Description: 订单列表
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	public List<Map<String, Object>> findOrderList(OrderSearchVo orderSearchVo);
	
	/**
	* Title: selectOrdersByOrder
	* Description: 条件查询订单
	* @param orderSearchVo
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	public List<Map<String, Object>> selectOrdersByOrder(OrderSearchVo orderSearchVo);
	
	/**
	* Title: selectOrdersByOrderId
	* Description: 
	* @param orderId
	* @param orderType 订单类型
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	public Map<String, Object> selectOrdersByOrderId(Integer orderId,Integer orderType);
	
	/**
	* Title: updateOrderStatus
	* Description: 修改订单状态
	* @param orderId
	* @param typeName
	* @param status
	* @return
	* @author HuangJian
	* @date 2017年2月9日
	*/
	public Integer updateOrderStatus(Integer orderId,String typeName,Integer status);
	
	
	/**
	* Title: selectStatisOrder
	* Description: 订单首页统计
	* @return
	* @author HuangJian
	* @date 2017年2月9日
	*/
	public Map<String, Object> selectStatisOrder();
	
	
	/**
	* Title: sendMessageByType
	* Description: 订单手动发送短信
	* @param type 订单类型  订单类型  0商城 1场馆 2私课 3课程 4活动 5 个人卡
	* @param orderId 订单ID
	* @return
	* @author HuangJian
	* @date 2017年3月21日
	*/
	public Map<String, Object> sendMessageByType(Integer type,Integer orderId);
	
	
}

