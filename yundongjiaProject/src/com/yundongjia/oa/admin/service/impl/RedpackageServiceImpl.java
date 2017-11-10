package com.yundongjia.oa.admin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TLeagueOrderMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TOrderDiscountMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TRedpackageMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TUserMapper;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TLeagueOrder;
import com.yundongjia.oa.admin.po.TLeagueOrderExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderDiscount;
import com.yundongjia.oa.admin.po.TOrderDiscountExample;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TRedpackage;
import com.yundongjia.oa.admin.po.TRedpackageExample;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.service.RedpackageService;
@Service
public class RedpackageServiceImpl implements RedpackageService{
	@Resource
	private TRedpackageMapper tRedpackageMapper;
	@Resource
	private TOrderDiscountMapper tOrderDiscountMapper;
	@Resource
	private TMemberMapper tMemberMapper;
	@Resource
	private TUserMapper tUserMapper;
	@Resource
	private TActivityOrderMapper tActivityOrderMapper;
	@Resource
	private TGoodsOrderMapper tGoodsOrderMapper;
	@Resource
	private TLeagueOrderMapper tLeagueOrderMapper;
	@Resource
	private TOrderMapper tOrderMapper;
	@Resource
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	
	/**
	 * @return统计红包金额 使用红包金额 过期红包金额
	 */
	@Override
	public Map redpackageMoneyCount() {
		Map param = new HashMap();
		param.put("status", 0);
		Double allSum = tRedpackageMapper.allSum(param);
		param.put("status", 1);
		Double pastSum = tRedpackageMapper.allSum(param);
		Double employSum = tOrderDiscountMapper.employSum(param);
		if(employSum == null){
			employSum = 0d;
		}
		if(pastSum == null){
			pastSum = 0d;
		}
		if(allSum == null){
			allSum = 0d;
		}
		param.put("allSum", allSum);
		param.put("pastSum", pastSum);
		param.put("employSum", employSum);
		return param;
	}
	
	/**
	 * @return统计红包金额 使用红包金额 过期红包金额 根据日期筛选
	 */
	@Override
	public Map redpackageMoneyCount(String startTime , String endTime) {
		Map param = new HashMap();
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		param.put("status", 0);
		Double allSum = tRedpackageMapper.allSum(param);
		param.put("status", 1);
		Double pastSum = tRedpackageMapper.allSum(param);
		Double active = tActivityOrderMapper.employSum(param) == null ? 0d : tActivityOrderMapper.employSum(param);
		Double goods = tGoodsOrderMapper.employSum(param) == null ? 0d : tGoodsOrderMapper.employSum(param);
		Double league = tLeagueOrderMapper.employSum(param) == null ? 0d : tLeagueOrderMapper.employSum(param);
		Double order = tOrderMapper.employSum(param) == null ? 0d : tOrderMapper.employSum(param);
		Double studio = tStudioConsumeOrderRecordMapper.employSum(param) == null ? 0d : tStudioConsumeOrderRecordMapper.employSum(param);
		Double employSum = active + goods + league + order + studio;
		if(pastSum == null){
			pastSum = 0d;
		}
		if(allSum == null){
			allSum = 0d;
		}
		param.put("allSum", allSum);
		param.put("pastSum", pastSum);
		param.put("employSum", employSum);
		return param;
	}
	
	/**
	 * @return查询已发放红包列表
	 */
	@Override
	public List<TRedpackage> sendRedpackage() {
		TRedpackageExample tRedpackageExample = new TRedpackageExample();
		tRedpackageExample.setOrderByClause("createDate desc");
		List<TRedpackage> list = tRedpackageMapper.selectByExample(tRedpackageExample);
		for (TRedpackage t : list) {
			TMember member = tMemberMapper.selectByPrimaryKey(t.getMemberid());
			if(member != null){
				TUser user = tUserMapper.selectByPrimaryKey(member.getUserid());
				if(user != null){
					t.setMobilephoneno(user.getMobilephoneno());
				}
			}
		}
		return list;
	}

	@Override
	public List<Map> pastRedpackage() {
		Map param = new HashMap();
		param.put("info", null);
		List<Map> pastList = tRedpackageMapper.pastList(param);
		for (int i = 0; i < pastList.size(); i++) {
			TRedpackageExample tRedpackageExample = new TRedpackageExample();
			tRedpackageExample.createCriteria().andMemberidEqualTo((Integer)pastList.get(i).get("memberId"));
			int redCount = tRedpackageMapper.countByExample(tRedpackageExample);
			pastList.get(i).put("redCount", redCount);
			List<TRedpackage> md = tRedpackageMapper.selectByExample(tRedpackageExample);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Long maxDate = 0l;
			Long date = 0l;
			for (TRedpackage t : md) {
				try {
					date = simpleDateFormat.parse(t.getExpiredate()).getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(date > maxDate){
					maxDate = date;
				}
			}
			if(maxDate != 0){
				pastList.get(i).put("expireDate" , simpleDateFormat.format(new Date(maxDate)));
			}
		}
		return pastList;
	}

	@Override
	public List<Map> pastRedpackage(String info) {
		Map param = new HashMap();
		param.put("info", "%"+info+"%");
		List<Map> pastList = tRedpackageMapper.pastList(param);
		for (int i = 0; i < pastList.size(); i++) {
			TRedpackageExample tRedpackageExample = new TRedpackageExample();
			tRedpackageExample.createCriteria().andMemberidEqualTo((Integer)pastList.get(i).get("memberId"));
			int redCount = tRedpackageMapper.countByExample(tRedpackageExample);
			pastList.get(i).put("redCount", redCount);
			List<TRedpackage> md = tRedpackageMapper.selectByExample(tRedpackageExample);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Long maxDate = 0l;
			Long date = 0l;
			for (TRedpackage t : md) {
				try {
					date = simpleDateFormat.parse(t.getExpiredate()).getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(date > maxDate){
					maxDate = date;
				}
			}
			pastList.get(i).put("expireDate" , simpleDateFormat.format(new Date(maxDate)));
		}
		return pastList;
	}
	/**
	 * @return查询使用过红包的所有订单列表
	 */
	@Override
	public Map findOrderList() {
		Map map = new HashMap();
		List order = new ArrayList();
		Double orderMoney = 0d;
		//查询订单优惠列表信息
		TOrderDiscountExample tOrderDiscountExample = new TOrderDiscountExample();
		List<TOrderDiscount> orderDiscounts  = tOrderDiscountMapper.selectByExample(tOrderDiscountExample);
		//查询活动订单列表
		TActivityOrderExample tActivityOrder = new TActivityOrderExample();
		List<TActivityOrder> activityOrders = tActivityOrderMapper.selectByExample(tActivityOrder);
		for (TActivityOrder ao : activityOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(4) && od.getOrderid().equals(ao.getOrderid()) && !od.getRedpackage().equals(0d)){
					ao.setType("活动");
					//本方法selfCardCoupon代表红包优惠金额
					ao.setSelfCardCoupon(od.getRedpackage());
					order.add(ao);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		//查询商品订单列表
		TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
		List<TGoodsOrder> tGoodsOrders = tGoodsOrderMapper.selectByExample(tGoodsOrderExample);
		for (TGoodsOrder tg : tGoodsOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(0) && tg.getOrderid().equals(od.getOrderid()) && !od.getRedpackage().equals(0d)){
					tg.setType("商城");
					//本方法selfCardCoupon代表红包优惠金额
					tg.setSelfCardCoupon(od.getRedpackage());
					order.add(tg);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		//查询团课订单列表
		TLeagueOrderExample tLeagueOrderExample = new TLeagueOrderExample();
		List<TLeagueOrder> tLeagueOrders = tLeagueOrderMapper.selectByExample(tLeagueOrderExample);
		for (TLeagueOrder tl : tLeagueOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(3) && tl.getOrderid().equals(od.getOrderid()) && !od.getRedpackage().equals(0d)){
					tl.setType("课程");
					//本方法selfCardCoupon代表红包优惠金额
					tl.setSelfCardCoupon(od.getRedpackage());
					order.add(tl);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		//查询私课订单列表
		TOrderExample tOrderExample = new TOrderExample();
		List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
		for (TOrder to : tOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(2) && to.getOrderid().equals(od.getOrderid()) && !od.getRedpackage().equals(0d)){
					to.setType("私课");
					//本方法selfCardCoupon代表红包优惠金额
					to.setSelfCardCoupon(od.getRedpackage());
					order.add(to);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		//查询场馆订单列表
		TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
		List<TStudioConsumeOrderRecord> tStudioConsumeOrderRecords = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
		for (TStudioConsumeOrderRecord ts : tStudioConsumeOrderRecords) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(1) && ts.getOrderid().equals(od.getOrderid()) && !od.getRedpackage().equals(0d)){
					ts.setType("场馆");
					//本方法selfCardCoupon代表红包优惠金额
					ts.setSelfCardCoupon(od.getRedpackage());
					order.add(ts);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		map.put("list", order);
		map.put("orderMoney", orderMoney);
		return map;
	}
	/**
	 * @return查询使用过红包的所有订单列表 根据手机号筛选
	 */
	@Override
	public Map findOrderList(String info) {
		Map map = new HashMap();
		List order = new ArrayList();
		Double orderMoney = 0d;
		//查询订单优惠列表信息
		TOrderDiscountExample tOrderDiscountExample = new TOrderDiscountExample();
		List<TOrderDiscount> orderDiscounts  = tOrderDiscountMapper.selectByExample(tOrderDiscountExample);
		//查询活动订单列表
		TActivityOrderExample tActivityOrder = new TActivityOrderExample();
		List<TActivityOrder> activityOrders = tActivityOrderMapper.selectByExample(tActivityOrder);
		for (TActivityOrder ao : activityOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(4) && od.getOrderid().equals(ao.getOrderid()) && !od.getRedpackage().equals(0d) && ao.getMobilephonenum()!=null && ao.getMobilephonenum().contains(info)){
					ao.setType("活动");
					//本方法selfCardCoupon代表红包优惠金额
					ao.setSelfCardCoupon(od.getRedpackage());
					order.add(ao);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		//查询商品订单列表
		TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
		List<TGoodsOrder> tGoodsOrders = tGoodsOrderMapper.selectByExample(tGoodsOrderExample);
		for (TGoodsOrder tg : tGoodsOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(0) && tg.getOrderid().equals(od.getOrderid()) && !od.getRedpackage().equals(0d) && tg.getMobilephonenum()!=null && tg.getMobilephonenum().contains(info)){
					tg.setType("商城");
					//本方法selfCardCoupon代表红包优惠金额
					tg.setSelfCardCoupon(od.getRedpackage());
					order.add(tg);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		//查询团课订单列表
		TLeagueOrderExample tLeagueOrderExample = new TLeagueOrderExample();
		List<TLeagueOrder> tLeagueOrders = tLeagueOrderMapper.selectByExample(tLeagueOrderExample);
		for (TLeagueOrder tl : tLeagueOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(3) && tl.getOrderid().equals(od.getOrderid()) && !od.getRedpackage().equals(0d) &&tl.getMobilephonenum()!=null && tl.getMobilephonenum().contains(info)){
					tl.setType("课程");
					//本方法selfCardCoupon代表红包优惠金额
					tl.setSelfCardCoupon(od.getRedpackage());
					order.add(tl);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		//查询私课订单列表
		TOrderExample tOrderExample = new TOrderExample();
		List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
		for (TOrder to : tOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(2) && to.getOrderid().equals(od.getOrderid()) && !od.getRedpackage().equals(0d)&&to.getMobilephonenum()!=null && to.getMobilephonenum().contains(info)){
					to.setType("私课");
					//本方法selfCardCoupon代表红包优惠金额
					to.setSelfCardCoupon(od.getRedpackage());
					order.add(to);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		//查询场馆订单列表
		TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
		List<TStudioConsumeOrderRecord> tStudioConsumeOrderRecords = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
		for (TStudioConsumeOrderRecord ts : tStudioConsumeOrderRecords) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(1) && ts.getOrderid().equals(od.getOrderid()) && !od.getRedpackage().equals(0d) && ts.getMobilephonenum()!=null && ts.getMobilephonenum().contains(info)){
					ts.setType("场馆");
					//本方法selfCardCoupon代表红包优惠金额
					ts.setSelfCardCoupon(od.getRedpackage());
					order.add(ts);
					orderMoney = orderMoney + od.getRedpackage();
				}
			}
		}
		map.put("list", order);
		map.put("orderMoney", orderMoney);
		return map;
	}

}
