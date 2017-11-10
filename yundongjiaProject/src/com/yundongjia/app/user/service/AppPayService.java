package com.yundongjia.app.user.service;

import java.util.Map;

import com.yundongjia.oa.admin.po.TMember;

public interface AppPayService {

	void paySuccess(Map<String, Object> orderMapParam);

	/**
	 * @param orderType 订单类型
	 * @param orderNum 订单编号
	 * @param payType支付类型
	 * @return 查询订单的支付状态
	 */
	Integer checkedPayStatus(Integer orderType, String orderNum);

	TMember findeMemberById(Integer memberId);

}
