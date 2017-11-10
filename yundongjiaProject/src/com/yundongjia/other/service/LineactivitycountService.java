package com.yundongjia.other.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TLineActivityCount;

public interface LineactivitycountService {

	/**
	 * @param tLineActivityCount
	 * 插入活动报名信息
	 */
	Integer insertSelective(TLineActivityCount tLineActivityCount);

	/**
	 * @param tLineActivityCount
	 * @return更新支付状态
	 */
	int updateByPrimaryKeySelective(TLineActivityCount tLineActivityCount);

	/**
	 * @param type 活动类型
	 * @param status  支付状态
	 * @return查询活动报名信息
	 */
	List<TLineActivityCount> selectSumInfo(int type, int status);

}
