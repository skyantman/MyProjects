package com.yundongjia.oa.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yundongjia.oa.admin.mapper.TAdminMapper;
import com.yundongjia.oa.admin.mapper.TCouponMapper;
import com.yundongjia.oa.admin.mapper.TMemberCouponRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TOpeartionMapper;
import com.yundongjia.oa.admin.mapper.TUserMapper;
import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.po.TCoupon;
import com.yundongjia.oa.admin.po.TCouponExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TMemberCouponRefExample;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService{
	@Resource
	private TCouponMapper tCouponMapper;
	@Resource
	private TOpeartionMapper tOpeartionMapper;
	@Resource
	private TMemberCouponRefMapper tMemberCouponRefMapper;	
	@Resource
	private TAdminMapper tAdminMapper;	
	@Resource
	private TMemberMapper tMemberMapper;
	@Resource 
	private TUserMapper tUserMapper;
	/**
	 * @param tCoupon
	 * @param opeartion
	 * @return插入优惠券类
	 */
	@Override
	public Integer insertCouponType(TCoupon tCoupon, TOpeartion opeartion){
		try {
			int reult = tCouponMapper.insertSelective(tCoupon);
			opeartion.setOpeartionInfo("创建优惠券类型----类型名为" + tCoupon.getCouponname());
			opeartion.setOpeartionById(tCoupon.getCouponid());
			opeartion.setOpeartionType(5);
			//插入操作记录信息
			tOpeartionMapper.insertSelective(opeartion);
			if(reult == 0){
				return 0;
			}else{
				return tCoupon.getCouponid();
			}
		} catch (Exception e) {
			return -1;	
		}
	}
	/**
	 * @return查询金额券列表 或 查询折扣券列表
	 */
	@Override
	public PageInfo<TCoupon> coupontypelist(String status , Integer page , Integer rows) {
		if(page == null || page == 0){
    		page = 1;
    	}
		PageHelper.startPage(page, rows);
		TCouponExample tCouponExample = new TCouponExample();
		tCouponExample.createCriteria().andCouponmethodEqualTo(status);
		tCouponExample.setOrderByClause("couponId desc");
		List<TCoupon> list = tCouponMapper.selectByExample(tCouponExample);
		for (TCoupon tc : list) {
			TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
			tMemberCouponRefExample.createCriteria().andCouponidEqualTo(tc.getCouponid()).andStatusEqualTo("1");
			int count = tMemberCouponRefMapper.countByExample(tMemberCouponRefExample);
			tc.setUsestock(count);
			String[] split = tc.getCoupontype().split(",");
			String type = "";
			Boolean b = false ;
			for (int i = 0; i < split.length; i++) {
				switch (split[i]) {
				case "0":b = true;
					break;
				case "1":type = type + " 场馆";
					break;
				case "2":type = type + " 教练";
					break;
				case "3":type = type + " 团课";
					break;
				case "4":type = type + " 充值卡";
					break;
				case "5":type = type + " 活动";
					break;
				case "6":type = type + " 私课";
					break;
				}
			}
			if(b){
				tc.setCoupontype("通用");
			}else{
				tc.setCoupontype(type);
			}
		}
		return new PageInfo<TCoupon>(list);
	}
	/**
	 * @return
	 * 启用禁用优惠券
	 */
	@Override
	public Integer updateStopOrStart(Integer status, Integer couponId, TOpeartion tOpeartion) {
		try {
			TCoupon tCoupon = new TCoupon();
			tCoupon.setStatus(status);
			tCoupon.setCouponid(couponId);
			int result = tCouponMapper.updateByPrimaryKeySelective(tCoupon);
			TMemberCouponRef tMemberCardOrderRef = new TMemberCouponRef();
			tMemberCardOrderRef.setStatus(status.toString());
			TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
			List<String> values = new ArrayList<String>();
			values.add("0");
			values.add("1");
			tMemberCouponRefExample.createCriteria().andCouponidEqualTo(couponId).andStatusIn(values);
			tMemberCouponRefMapper.updateByExampleSelective(tMemberCardOrderRef, tMemberCouponRefExample);
			tOpeartion.setOpeartionById(couponId);
			if(status == 1){
				tOpeartion.setOpeartionInfo("禁用优惠券类型以及下属未使用单券");
			}else if(status == 0){
				tOpeartion.setOpeartionInfo("启用优惠券类型以及下属禁用单券");
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
	 * @param couponId 优惠券类型ID
	 * @return根据ID查询优惠券类型
	 */
	@Override
	public TCoupon couponTypeById(Integer couponId) {
		TCoupon tc = tCouponMapper.selectByPrimaryKey(couponId);
		TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
		tMemberCouponRefExample.createCriteria().andCouponidEqualTo(tc.getCouponid()).andStatusEqualTo("1");
		int count = tMemberCouponRefMapper.countByExample(tMemberCouponRefExample);
		tc.setUsestock(count);
		String[] split = tc.getCoupontype().split(",");
		String type = "";
		Boolean b = false ;
		for (int i = 0; i < split.length; i++) {
			switch (split[i]) {
			case "0":b = true;
				break;
			case "1":type = type + " 场馆";
				break;
			case "2":type = type + " 教练";
				break;
			case "3":type = type + " 团课";
				break;
			case "4":type = type + " 充值卡";
				break;
			case "5":type = type + " 活动";
				break;
			case "6":type = type + " 私课";
				break;
			}
		}
		if(b){
			tc.setCoupontype("通用");
		}else{
			tc.setCoupontype(type);
		}
		TAdmin admin = tAdminMapper.selectByPrimaryKey(tc.getOpeartionadminid());
		tc.setOpeartionadminname(admin.getBackusername());
		return tc;
	}
	/**
	 * @param couponId
	 * @return查询优惠券类下的所有单券
	 */
	@Override
	public List<TMemberCouponRef> memberCouponlist(Integer couponId) {
		TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
		tMemberCouponRefExample.createCriteria().andCouponidEqualTo(couponId);
		tMemberCouponRefExample.setOrderByClause("rowId desc");
		List<TMemberCouponRef> list = tMemberCouponRefMapper.selectByExample(tMemberCouponRefExample);
		TCoupon coupon = tCouponMapper.selectByPrimaryKey(couponId);
		for (TMemberCouponRef tm : list) {
			TMember member = tMemberMapper.selectByPrimaryKey(tm.getMemberid());
			TUser user = tUserMapper.selectByPrimaryKey(member.getUserid());
			if(user != null){
				tm.setUsermobilephoneno(user.getMobilephoneno());
			}
			tm.setCouponname(coupon.getCouponname());
		}
		return list;
	}
	/**
	 * @return
	 * 启用禁用优惠券单券
	 */
	@Override
	public Integer stopOrStartMemberCoupon(Integer status, Integer rowId, TOpeartion tOpeartion) {
		try {
			TMemberCouponRef tMemberCardOrderRef = new TMemberCouponRef();
			tMemberCardOrderRef.setStatus(status.toString());
			TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
			List<String> values = new ArrayList<String>();
			values.add("0");
			values.add("1");
			tMemberCouponRefExample.createCriteria().andRowidEqualTo(rowId).andStatusIn(values);
			int result = tMemberCouponRefMapper.updateByExampleSelective(tMemberCardOrderRef, tMemberCouponRefExample);
			tOpeartion.setOpeartionById(rowId);
			if(status == 1){
				tOpeartion.setOpeartionInfo("禁用未使用优惠券单券");
			}else if(status == 0){
				tOpeartion.setOpeartionInfo("启用已禁用优惠券单券");
			}
			tOpeartionMapper.insertSelective(tOpeartion);
			if(result == 0){
				return 0;
			}else{
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * @param rowId 优惠单券ID
	 * @return 查询优惠单券信息
	 */
	@Override
	public Map couponDetail(Integer rowId) {
		Map param = new HashMap();
		param.put("rowId", rowId);
		return tMemberCouponRefMapper.couponDetail(param);
	}
	
	/**
	 * @param couponId
	 * @param info
	 * @return 根据用户手机号查询优惠单券
	 */
	@Override
	public List<TMemberCouponRef> searchMemberCouponByPhone(Integer couponId, String info) {
		TMemberCouponRefExample tMemberCouponRefExample = new TMemberCouponRefExample();
		tMemberCouponRefExample.createCriteria().andCouponidEqualTo(couponId);
		tMemberCouponRefExample.setOrderByClause("rowId desc");
		List<TMemberCouponRef> list = tMemberCouponRefMapper.selectByExample(tMemberCouponRefExample);
		List<TMemberCouponRef> retList = new ArrayList<TMemberCouponRef>();
		TCoupon coupon = tCouponMapper.selectByPrimaryKey(couponId);
		for (TMemberCouponRef tm : list) {
			TMember member = tMemberMapper.selectByPrimaryKey(tm.getMemberid());
			TUser user = tUserMapper.selectByPrimaryKey(member.getUserid());
			tm.setUsermobilephoneno(user.getMobilephoneno());
			tm.setCouponname(coupon.getCouponname());
			if(user.getMobilephoneno().toString().contains(info)){
				retList.add(tm);
			}
		}
		return retList;
	}
}
