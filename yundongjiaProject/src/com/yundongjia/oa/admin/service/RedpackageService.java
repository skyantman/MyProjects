package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TRedpackage;

public interface RedpackageService {

	/**
	 * @return统计红包金额 使用红包金额 过期红包金额
	 */
	Map redpackageMoneyCount();
	/**
	 * @return统计红包金额 根据日期筛选
	 */
	Map redpackageMoneyCount(String startTime , String endTime);
	/**
	 * @return查询已发放红包列表
	 */
	List<TRedpackage> sendRedpackage();
	/**
	 * @param info 
	 * @return查询已过期的红包列表
	 */
	List<Map> pastRedpackage();
	/**
	 * @param info 
	 * @return查询已过期的红包列表 根据手机号模糊查询
	 */
	List<Map> pastRedpackage(String info);
	/**
	 * @return查询使用过红包的所有订单列表
	 */
	Map findOrderList();
	/**
	 * @return查询使用过红包的所有订单列表 根据手机号筛选
	 */
	Map findOrderList(String info);

}
