package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TPrivateLessonTime;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;

public interface PayOrderService {
	/**
	 * @param memberId 会员Id
	 * @return查询会员信息根据Id
	 */
	TMember findMemberById(Integer memberId);

	/**
	 * @param memberId 会员ID
	 * @return查询会员的可用红包余额
	 */
	Double findUsableRedPackage(Integer memberId);

	/**
	 * @param memberId
	 * @param price 
	 * @return查询会员可用优惠券列表
	 */
	List<Map<String , Object>> findCouponByMemberId(Integer memberId, Double price,Integer couponType);

	/**
	 * @param memberId
	 * @return根据MemberId查询用户的手机号
	 */
	String findMemberMobilephoneNo(Integer userId);

	/**
	 * @param tActivityOrder订单信息对象
	 * @return插入活动订单信息
	 */
	Integer insetActivityOrder(TActivityOrder tActivityOrder);

	/**
	 * @param proId主键ID
	 * @return查询活动信息根据主键
	 */
	TActivity finActiveById(Integer proId);

	/**
	 * @param memberId
	 * @return查询个人卡
	 */
	Map<String, Object> findSelfCard(Integer memberId);

	/**
	 * @param memberId
	 * @return查询用户下的企业卡
	 */
	Map<String, Object> findEnterpriseCard(Integer memberId);

	/**
	 * @param enterpriseCardId 企业卡ID
	 * @param activeSubNum 企业卡扣除次数
	 * @return
	 */
	Integer updateEnterpriseCardSportNum(Integer enterpriseCardId, Integer enterpriseSubNum);

	/**
	 * @param memberId 会员ID
	 * @param realPrice订单价格
	 * @return更新会员余额信息
	 */
	Integer updateMemberBlance(Integer memberId, Double realPrice);

	/**
	 * @param proId
	 * @return 查询活动信息根据ID
	 */
	TGoods findGoodsInfoById(Integer proId);

	/**
	 * @param tGoodsOrder
	 * @return插入商品订单信息
	 */
	Integer insetGoodsOrder(TGoodsOrder tGoodsOrder);

	/**
	 * @param proId
	 * @return根据卡类型ID查询类型信息
	 */
	TCardType findMemberTypeById(Integer proId);

	/**
	 * @param tMemberCardOrderRef
	 * @return插入个人卡预付订单
	 */
	Integer insetMemberCardOrder(TMemberCardOrderRef tMemberCardOrderRef);

	/**
	 * @param tOrder
	 * @return插入私课订单
	 */
	Integer insertPrivateOrder(TOrder tOrder);

	/**
	 * @param coachId
	 * @return根据ID查询教练信息
	 */
	TCoach findCoachById(Integer coachId);

	/**
	 * @param tActivity
	 * @return更新活动报名人数
	 */
	Integer updateActiveJoinMan(TActivity tActivity);

	/**
	 * @param goods
	 * @return更新商品库存数量
	 */
	Integer updateGoodsNum(TGoods goods);

	/**
	 * @param time
	 * @param timeSpan 
	 * @return更新私课教练时间
	 */
	Integer updatePrivateOrderDate(TPrivateLessonTime time, String timeSpan);

	/**
	 * @param tCardType
	 * @return更新会员卡类型剩余库存
	 */
	Integer updateCardTypeNum(TCardType tCardType);

	/**
	 * @param orderType
	 * @param orderNum
	 * @return更新订单状态
	 */
	Integer updateCancelOrder(Integer orderType, Integer orderId);

	/**
	 * @param proTableId
	 * @return根据场馆ＩＤ查询场馆信息
	 */
	TStudio findStudioById(Integer proTableId);

	/**
	 * @param classDate
	 * @param timeSpan
	 * @param proTableId 
	 * @return查询教练的可用时间
	 */
	Boolean findCoachTime(String classDate, String timeSpan, Integer proTableId);

	/**
	 * @param orderId
	 * @return根据订单ID查询活动订单信息
	 */
	TActivityOrder finderActiveOrderInfo(Integer orderId);

	/**
	 * @param orderId
	 * @return根据订单ID查询商品订单信息
	 */
	TGoodsOrder finderGoodsOrderInfo(Integer orderId);

	/**
	 * @param orderId
	 * @return根据订单ID查询私课订单信息
	 */
	TOrder findePrivateOrderInfo(Integer orderId);

	/**
	 * @param orderId
	 * @return根据订单ID查询场馆订单信息
	 */
	TStudioConsumeOrderRecord findeStudioOrderInfo(Integer orderId);

	/**
	 * @param orderId
	 * @return根据订单信息查询个人卡订单
	 */
	TMemberCardOrderRef findeCardOrderInfo(Integer orderId);

	/**
	 * @param orderId
	 * @param orderType
	 * @return根据订单ID删除订单信息
	 */
	Integer deleteOrderById(Integer orderId, Integer orderType);

	/**
	 * @param coachid
	 * @param classdate
	 * @return查询教练pai期ID
	 */
	Integer findCoachPrivateTime(Integer coachid, String classdate);

	/**
	 * @param orderId
	 * @param orderType
	 * @return根据订单ID更新订单状态为退订
	 */
	Integer updateOrderStatusById(Integer orderId, Integer orderType);

}
