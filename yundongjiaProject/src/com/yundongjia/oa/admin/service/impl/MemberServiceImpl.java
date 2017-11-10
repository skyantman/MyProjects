package com.yundongjia.oa.admin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TApplyAccountMapper;
import com.yundongjia.oa.admin.mapper.TApplyMapper;
import com.yundongjia.oa.admin.mapper.TConsigneeAddressMapper;
import com.yundongjia.oa.admin.mapper.TCouponMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TLeagueOrderMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardEnterpriseRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberCouponRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TOpeartionMapper;
import com.yundongjia.oa.admin.mapper.TOrderDiscountMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TRedpackageMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TUserMapper;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TApplyAccount;
import com.yundongjia.oa.admin.po.TApplyAccountExample;
import com.yundongjia.oa.admin.po.TApplyExample;
import com.yundongjia.oa.admin.po.TConsigneeAddress;
import com.yundongjia.oa.admin.po.TConsigneeAddressExample;
import com.yundongjia.oa.admin.po.TCoupon;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TLeagueOrder;
import com.yundongjia.oa.admin.po.TLeagueOrderExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRef;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRefExample;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TMemberCouponRefExample;
import com.yundongjia.oa.admin.po.TMemberExample;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderDiscount;
import com.yundongjia.oa.admin.po.TOrderDiscountExample;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TRedpackage;
import com.yundongjia.oa.admin.po.TRedpackageExample;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.po.TUserExample;
import com.yundongjia.oa.admin.service.MemberService;
import com.yundongjia.oa.utils.UtilMD5;

@Service
public class MemberServiceImpl implements MemberService{
	@Resource
	private TMemberMapper tMemberMapper;
	@Resource
	private TUserMapper tUserMapper;
	@Resource
	private TOrderMapper tOrderMapper;
	@Resource
	private TOpeartionMapper tOpeartionMapper;
	@Resource
	private TConsigneeAddressMapper tConsigneeAddressMapper;
	@Resource
	private TRedpackageMapper tRedpackageMapper;
	@Resource
	private TMemberCouponRefMapper tMemberCouponRefMapper;
	@Resource
	private TCouponMapper tCouponMapper;
	@Resource
	private TMemberCardOrderRefMapper tMemberCardOrderRefMapper;
	@Resource
	private TMemberCardEnterpriseRefMapper tMemberCardEnterpriseRefMapper;
	@Resource
	private TApplyMapper tApplyMapper;
	@Resource
	private TApplyAccountMapper tApplyAccountMapper;
	@Resource
	private TActivityOrderMapper tActivityOrderMapper;
	@Resource
	private TGoodsOrderMapper tGoodsOrderMapper;
	@Resource
	private TOrderDiscountMapper tOrderDiscountMapper;
	@Resource
	private TLeagueOrderMapper tLeagueOrderMapper;
	@Resource
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	
	/**
	 * @return查询会员总数 日新增 日活跃
	 */
	@Override
	public Map findMemberSum() {
		Map memberSum = new HashMap();
		TUserExample tUserExample = new TUserExample();
		int allSum = tUserMapper.countByExample(tUserExample);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		String sDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + " 00:00:00";
		String eDate =calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + (calendar.get(Calendar.DAY_OF_MONTH)+1) + " 00:00:00";
		tUserExample.createCriteria().andCreatedateBetween(sDate, eDate);
		int regsionSum = tUserMapper.countByExample(tUserExample);
		Map param = new HashMap();
		param.put("sDate", sDate);
		param.put("eDate", eDate);
		Integer activeSum = 0;
		//查询活动订单列表
		TActivityOrderExample tActivityOrder = new TActivityOrderExample();
		tActivityOrder.createCriteria().andCreatedateBetween(sDate, sDate);
		activeSum = activeSum +  tActivityOrderMapper.countByExample(tActivityOrder);
		//查询商品订单列表
		TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
		tGoodsOrderExample.createCriteria().andCreatedateBetween(sDate, sDate);
		activeSum = activeSum +  tGoodsOrderMapper.countByExample(tGoodsOrderExample);
		//查询团课订单列表
		TLeagueOrderExample tLeagueOrderExample = new TLeagueOrderExample();
		tLeagueOrderExample.createCriteria().andCreatedateBetween(sDate, sDate);
		activeSum = activeSum +  tLeagueOrderMapper.countByExample(tLeagueOrderExample);
		//查询私课订单列表
		TOrderExample tOrderExample = new TOrderExample();
		tOrderExample.createCriteria().andCreatedateBetween(sDate, sDate);
		activeSum = activeSum +  tOrderMapper.countByExample(tOrderExample);
		//查询场馆订单列表
		TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
		tStudioConsumeOrderRecordExample.createCriteria().andCreatedateBetween(sDate, sDate);
		activeSum = activeSum +  tStudioConsumeOrderRecordMapper.countByExample(tStudioConsumeOrderRecordExample);
		memberSum.put("allSum", allSum);
		memberSum.put("regsionSum", regsionSum);
		memberSum.put("activeSum", activeSum);
		return memberSum;
	}
	
	/**
	 * @return查询用户信息列表
	 */
	@Override
	public List<Map> findMemberList(String info) {
		Map param = new HashMap();
		if(info!=null){
			param.put("info", "%"+info+"%");
		}else{
			param.put("info", null);
		}
		return tUserMapper.findMemberList(param);
	}
	
	/**
	 * @param status状态
	 * @param userId 用户ID
	 * @param tOpeartion 操作记录对象
	 *  @return 根据ID启用或禁用用户
	 * @author lxy 
	 * @date 2017/2/6 上午
	 */
	@Override
	public Integer stopOrStartMember(Integer status, Integer userId, TOpeartion tOpeartion) {
		try {
			TUser tUser = new TUser();
			tUser.setIsvalid(status.toString());
			tUser.setUserid(userId);
			int result = tUserMapper.updateByPrimaryKeySelective(tUser);
			tOpeartion.setOpeartionById(userId);
			if(status == 1){
				tOpeartion.setOpeartionInfo("禁用用户");
			}else if(status == 0){
				tOpeartion.setOpeartionInfo("启用用户");
			}
			tOpeartionMapper.insertSelective(tOpeartion);
			if(result == 0){
				return 0;
			}else{
				return 1;
			}
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * @param userId 用户ID 
	 * @return 查询会员详情
	 * @author lxy 
	 * @date 2017/2/6 下午
	 */
	@Override
	public Map memberDetail(Integer userId) {
		Map param = new HashMap();
		param.put("info", null);
		param.put("userId", userId);
		Map map = tUserMapper.findMemberList(param).get(0);
		Integer memberId = (Integer) map.get("memberId");
		TConsigneeAddressExample tConsigneeAddressExample = new TConsigneeAddressExample();
		tConsigneeAddressExample.createCriteria().andMemberidEqualTo(memberId);
		List<TConsigneeAddress> addr = tConsigneeAddressMapper.selectByExample(tConsigneeAddressExample);
		map.put("addr",addr);
		return map;
	}
	
	/**
	 * @param verpwd 随机新密码
	 * @param mobilePhone 
	 * @return 重置用户密码
	 * @author lxy 
	 * @date 2017/2/6 下午
	 */
	@Override
	public Integer resetPwd(String verpwd, String mobilePhone) {
		TUserExample tUserExample = new TUserExample();
		tUserExample.createCriteria().andMobilephonenoEqualTo(mobilePhone);
		TUser record = new TUser();
		record.setPassword(UtilMD5.md5(verpwd));
		return tUserMapper.updateByExampleSelective(record, tUserExample);
	}
	
	/**
	 * @param userId
	 * @return查询红包最近的有效期
	 * @author lxy 
	 * @date 2017/2/6 下午
	 */
	@Override
	public String redPackageValidity(Integer userId) {
		TMemberExample tMemberExample = new TMemberExample();
		tMemberExample.createCriteria().andUseridEqualTo(userId);
		List<TMember> member = tMemberMapper.selectByExample(tMemberExample);
		TRedpackageExample tRedpackageExample = new TRedpackageExample();
		tRedpackageExample.createCriteria().andMemberidEqualTo(member.get(0).getMemberid());
		List<TRedpackage> selectByExample = tRedpackageMapper.selectByExample(tRedpackageExample);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long date = 0l;
		long minDate = 0l;
		for (TRedpackage r : selectByExample) {
			try {
				if(r.getExpiredate()!=null && !"".equals(r.getExpiredate())){
					date = simpleDateFormat.parse(r.getExpiredate()).getTime();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(minDate > date){
				minDate = date;
			}
		}
		return simpleDateFormat.format(new Date(minDate));
	}

	/**
	 * @param userId
	 * @return查询用户下的所有优惠券
	 * @author lxy 
	 * @date 2017/2/6 下午
	 */
	@Override
	public List<TMemberCouponRef> couponByUserId(Integer userId) {
		TMemberExample tMemberExample = new TMemberExample();
		tMemberExample.createCriteria().andUseridEqualTo(userId);
		List<TMember> memberList = tMemberMapper.selectByExample(tMemberExample);
		TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
		tMemberCouponRefExample.createCriteria().andMemberidEqualTo(memberList.get(0).getMemberid());
		tMemberCouponRefExample.setOrderByClause("rowId desc");
		List<TMemberCouponRef> list = tMemberCouponRefMapper.selectByExample(tMemberCouponRefExample);
		for (TMemberCouponRef tm : list) {
			TMember member = tMemberMapper.selectByPrimaryKey(tm.getMemberid());
			TUser user = tUserMapper.selectByPrimaryKey(member.getUserid());
			if(user != null){
				tm.setUsermobilephoneno(user.getMobilephoneno());
			}
			TCoupon coupon = tCouponMapper.selectByPrimaryKey(tm.getCouponid());
			tm.setCouponname(coupon.getCouponname());
		}
		return list;
	}
	
	/**
	 * @param userId
	 * @return查询用户个人卡列表
	 * @author lxy 
	 * @date 2017/2/7 上午
	 */
	@Override
	public List<Map> findMemberCard(Integer userId) {
		Map param = new HashMap();
		param.put("userId", userId);
		return tMemberCardOrderRefMapper.findListSelfByCardTypeId(param);
	}
	
	/**
	 * @param userId
	 * @return查询用户企业卡列表
	 * @author lxy 
	 * @date 2017/2/7 上午
	 */
	@Override
	public List<Map> findMemberEnterprisCard(Integer userId) {
		Map param = new HashMap();
		List<Map> list = tMemberCardOrderRefMapper.findListByCardTypeId(param);
		//查询MemberId
		 TMemberExample tMemberExample = new TMemberExample();
		 tMemberExample.createCriteria().andUseridEqualTo(userId);
		 List<TMember> selectByExample = tMemberMapper.selectByExample(tMemberExample);
		 //使用MemberID 查询绑定的企业卡Id
		TMemberCardEnterpriseRefExample tMemberCardEnterpriseRefExample = new TMemberCardEnterpriseRefExample();
		tMemberCardEnterpriseRefExample.createCriteria().andMemberidEqualTo(selectByExample.get(0).getMemberid());
		List<TMemberCardEnterpriseRef> enterpriseCard = tMemberCardEnterpriseRefMapper.selectByExample(tMemberCardEnterpriseRefExample);
		//从所有企页卡中筛选出用户的企业卡并存入新的集合
		List<Map> newlist = new ArrayList<Map>();
		for (Map l : list) {
			for (TMemberCardEnterpriseRef t : enterpriseCard) {
				if(l.get("orderId").toString().equals(t.getCardid().toString())){
					newlist.add(l);
				}
			}
		}
		return newlist;
	}

	/**
	 * @param userId
	 * @return查询用户提现记录
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	@Override
	public List<TApply> findUserApply(Integer userId) {
		//查询MemberId
		TMemberExample tMemberExample = new TMemberExample();
		tMemberExample.createCriteria().andUseridEqualTo(userId);
		List<TMember> selectByExample = tMemberMapper.selectByExample(tMemberExample);
		TApplyAccountExample tApplyAccountExample = new TApplyAccountExample();
		tApplyAccountExample.createCriteria().andLikeidEqualTo(selectByExample.get(0).getMemberid()).andStatusEqualTo("1");
		List<TApplyAccount> applyAccounts = tApplyAccountMapper.selectByExample(tApplyAccountExample);
		List<TApply> resultList = new ArrayList<TApply>();
		for (TApplyAccount tApplyAccount : applyAccounts) {
			Integer rowdid = tApplyAccount.getRowdid();
			TApplyExample tApplyExample = new TApplyExample();
			tApplyExample.createCriteria().andAppaccountidEqualTo(rowdid);
			resultList.addAll(tApplyMapper.selectByExample(tApplyExample));
		}
		return resultList;
	}

	/**
	 * @param userId
	 * @return查询用户天线账号信息列表
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	@Override
	public List<TApplyAccount> findUserAccount(Integer userId) {
		//查询MemberId
		TMemberExample tMemberExample = new TMemberExample();
		tMemberExample.createCriteria().andUseridEqualTo(userId);
		List<TMember> selectByExample = tMemberMapper.selectByExample(tMemberExample);
		TApplyAccountExample tApplyAccountExample = new TApplyAccountExample();
		tApplyAccountExample.createCriteria().andLikeidEqualTo(selectByExample.get(0).getMemberid()).andStatusEqualTo("1");
		return tApplyAccountMapper.selectByExample(tApplyAccountExample);
	}
	
	/**
	 * @param tApplyAccount
	 * @return更新用户提现账号信息
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	@Override
	public Map updateAccount(TApplyAccount tApplyAccount) {
		int result = tApplyAccountMapper.updateByPrimaryKeySelective(tApplyAccount);
		Map info = new HashMap();
		if(result == 1){
			info.put("result", true);
			TApplyAccount account = tApplyAccountMapper.selectByPrimaryKey(tApplyAccount.getRowdid());
			info.put("account", account);
			info.put("message", "账号信息更新成功！");
		}else {
			info.put("result", false);
			info.put("message", "账号信息更新失败！");
		}
		return info;
	}
	/**
	 * @param applyStatus 提现进度
	 * @param rowId 主键提现记录表
	 * @return更新提现状态
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	@Override
	public Map updateStatus(String applyStatus, Integer rowId) {
		TApply tApply = new TApply();
		tApply.setRowid(rowId);
		tApply.setApplystatus(applyStatus);
		int result = tApplyMapper.updateByPrimaryKeySelective(tApply);
		Map info = new HashMap();
		if(result == 1){
			info.put("result", true);
			TApply apply = tApplyMapper.selectByPrimaryKey(tApply.getRowid());
			info.put("apply", apply);
			info.put("message", "提现状态更新成功！");
		}else {
			info.put("result", false);
			info.put("message", "提现状态更新失败！");
		}
		return info;
	}
	/**
	 * @param userId
	 * @return根据用户ＩＤ查询会员Id
	 */
	@Override
	public Integer findMemberId(Integer userId) {
		TMemberExample tMemberExample = new TMemberExample();
		tMemberExample.createCriteria().andUseridEqualTo(userId);
		List<TMember> member = tMemberMapper.selectByExample(tMemberExample);
		return member.get(0).getMemberid();
	}
}

