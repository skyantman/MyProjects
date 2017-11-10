/**
* @author HuangJian
* @date 2017年2月28日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.vo.ClearOrderSearchVo;

public interface ClearOrderService {

	/**
	* Title: findClearOrderList
	* Description: 全部订单
	* @param vo
	* @return
	* @author HuangJian
	* @date 2017年3月1日
	*/
	public List<Map<String, Object>> findClearOrderList(ClearOrderSearchVo vo);
	
	/**
	* Title: getClearOrderByOrderId
	* Description: 结算详情
	* @param orderId  订单id
	* @param orderType  订单类型 0商城 1场馆 2私课 3课程 4活动
	* @param studioId 场馆ID
	* @return
	* @author HuangJian
	* @date 2017年3月1日
	*/
	public Map<String, Object> getClearOrderByOrderId(Map<String, Object> param);
	
	/**
	* Title: selectClearOrderStatis
	* Description: 结算列表统计
	* @return
	* @author HuangJian
	* @date 2017年3月2日
	*/
	public Map<String, Object> selectClearOrderStatis();
	
	/**
	* Title: updateUpAccount
	* Description: 确定结算
	* @param map
	* @return
	* @author HuangJian
	* @date 2017年3月3日
	*/
	public Map<String, Object> updateUpAccount(Map<String, Object> map);
}

