package com.yundongjia.other.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TActivityOrder;

public interface TimedTaskService {

	/**
	 * @return
	 * 查询超过十五分钟未支付的订单
	 */
	List<Map<String, Object>> selectOverTimeOrder();

}
