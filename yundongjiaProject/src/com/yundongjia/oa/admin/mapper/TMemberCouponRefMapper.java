package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TMemberCouponRefExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMemberCouponRefMapper {
    int countByExample(TMemberCouponRefExample example);

    int deleteByExample(TMemberCouponRefExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TMemberCouponRef record);

    int insertSelective(TMemberCouponRef record);

    List<TMemberCouponRef> selectByExample(TMemberCouponRefExample example);

    TMemberCouponRef selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TMemberCouponRef record, @Param("example") TMemberCouponRefExample example);

    int updateByExample(@Param("record") TMemberCouponRef record, @Param("example") TMemberCouponRefExample example);

    int updateByPrimaryKeySelective(TMemberCouponRef record);

    int updateByPrimaryKey(TMemberCouponRef record);

	/**
	 * @param  优惠单券ID
	 * @return 查询优惠单券信息
	 */
	Map couponDetail(Map param);
	
	/**
	* Title: findCouponListByMember
	* Description: 用户下的卷
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月14日
	*/
	List<Map<String, Object>> findCouponListByMember(@Param("param") Map<String, Object> param);
	/**
	 * @param memberId 会员ID
	 * @param price 订单价格
	 * @param couponType 优惠券类型（(覆盖商品)   0 通用   1 场馆 2 教练   3团课  4 充值卡   5活动优惠券 6 私课）
	 * @return查询会员可用优惠券列表
	 */
	List<Map<String, Object>> findUsableCoupon(Map<String, Object> param);
}