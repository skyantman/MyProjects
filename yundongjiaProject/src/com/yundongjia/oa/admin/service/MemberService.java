package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TApplyAccount;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TOpeartion;

public interface MemberService {

	/**
	 * @return查询会员总数 日新增 日活跃
	 */
	Map findMemberSum();

	/**
	 * @return查询用户信息列表
	 */
	List<Map> findMemberList(String info);

	/**
	 * @param status状态
	 * @param userId 用户ID
	 * @param tOpeartion 操作记录对象
	 *  @return 根据ID启用或禁用用户
	 * @author lxy 
	 * @date 2017/2/6 上午
	 */
	Integer stopOrStartMember(Integer status, Integer userId, TOpeartion tOpeartion);

	/**
	 * @param userId 用户ID 
	 * @return 查询会员详情
	 * @author lxy 
	 * @date 2017/2/6 下午
	 */
	Map memberDetail(Integer userId);

	/**
	 * @param verpwd 随机新密码
	 * @param mobilePhone  用户手机号码
	 * @return 重置用户密码
	 * @author lxy 
	 * @date 2017/2/6 下午
	 */
	Integer resetPwd(String verpwd, String mobilePhone);

	/**
	 * @param userId
	 * @return查询红包最近的有效期
	 * @author lxy 
	 * @date 2017/2/6 下午
	 */
	String redPackageValidity(Integer userId);

	/**
	 * @param userId
	 * @return查询用户下的所有优惠券
	 * @author lxy 
	 * @date 2017/2/6 下午
	 */
	List<TMemberCouponRef> couponByUserId(Integer userId);

	/**
	 * @param userId
	 * @return查询用户个人卡列表
	 * @author lxy 
	 * @date 2017/2/7 上午
	 */
	List<Map> findMemberCard(Integer userId);
	/**
	 * @param userId
	 * @return查询用户企业卡列表
	 * @author lxy 
	 * @date 2017/2/7 上午
	 */
	List<Map> findMemberEnterprisCard(Integer userId);

	/**
	 * @param userId
	 * @return查询用户提现记录
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	List<TApply> findUserApply(Integer userId);

	/**
	 * @param userId
	 * @return查询用户天线账号信息列表
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	List<TApplyAccount> findUserAccount(Integer userId);

	/**
	 * @param tApplyAccount
	 * @return更新用户提现账号信息
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	Map updateAccount(TApplyAccount tApplyAccount);
	/**
	 * @param applyStatus 提现进度
	 * @param rowId 主键提现记录表
	 * @return更新提现状态
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	Map updateStatus(String applyStatus, Integer rowId);

	/**
	 * @param userId
	 * @return根据用户ＩＤ查询会员Id
	 */
	Integer findMemberId(Integer userId);

}
