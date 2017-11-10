package com.yundongjia.other.service;

public interface ShareRecCouponService {

	/**
	 * @param phone
	 * @return 查询会员是否注册
	 */
	boolean findIsRegister(String phone);

	/**
	 * @param phone
	 * @return查询会员你是否领取优惠券
	 */
	String findIsRecCoupon(String phone , Integer CouponTypeId);

	/**
	 * @param phone
	 * @return查询用户拥有多少张优惠券
	 */
	Integer findCouponCount(String phone);

}
