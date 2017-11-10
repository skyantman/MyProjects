package com.yundongjia.other.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TStudio;

public interface EnterpriseTerminalService {

	/**
	 * @return查询场馆列表
	 */
	List<TStudio> findStudioList();

	/**
	 * @param studioId
	 * @return查询登录场馆的手机号
	 */
	String selectStudioPhone(Integer studioId);

	/**
	 * @param studioId
	 * @param startDate
	 * @param endDate
	 * @param mobile
	 * @return查询场馆订单列表
	 */
	List<Map<String, Object>> findStudioOrder(Integer studioId, String startDate, String endDate, String mobile);

}
