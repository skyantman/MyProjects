package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.yundongjia.oa.admin.po.TCoupon;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TOpeartion;

public interface CouponService {

	/**
	 * @param tCoupon
	 * @param opeartion
	 * @return插入优惠券类
	 */
	Integer insertCouponType(TCoupon tCoupon, TOpeartion opeartion);
	/**
	 * @param pageRow 
	 * @param page 
	 * @return查询金额券列表 或 查询折扣券列表
	 */
	PageInfo<TCoupon> coupontypelist(String string, Integer page, Integer pageRow);
	
	/**
	 * @param status 1禁用  0启用
	 * @param couponId 优惠券类型ID
	 * @param tOpeartion 操作记录
	 * @return禁用或启用优惠券
	 */
	Integer updateStopOrStart(Integer status, Integer couponId, TOpeartion tOpeartion);
	/**
	 * @param couponId 优惠券类型ID
	 * @return根据ID查询优惠券类型
	 */
	TCoupon couponTypeById(Integer couponId);
	/**
	 * @param couponId
	 * @return查询优惠券类下的所有单券
	 */
	List<TMemberCouponRef> memberCouponlist(Integer couponId);
	/**
	 * @return
	 * 启用禁用优惠券单券
	 */
	Integer stopOrStartMemberCoupon(Integer status, Integer rowId, TOpeartion tOpeartion);
	/**
	 * @param rowId 优惠单券ID
	 * @return 查询优惠单券信息
	 */
	Map couponDetail(Integer rowId);
	/**
	 * @param couponId
	 * @param info
	 * @return根据用户手机号查询优惠单券
	 */
	List<TMemberCouponRef> searchMemberCouponByPhone(Integer couponId, String info);

}
