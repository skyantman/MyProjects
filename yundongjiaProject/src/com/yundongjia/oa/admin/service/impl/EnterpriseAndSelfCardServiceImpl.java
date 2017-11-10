package com.yundongjia.oa.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TAdminMapper;
import com.yundongjia.oa.admin.mapper.TCardTypeMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TLeagueOrderMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TOpeartionMapper;
import com.yundongjia.oa.admin.mapper.TOrderDiscountMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCardTypeExample;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TLeagueOrder;
import com.yundongjia.oa.admin.po.TLeagueOrderExample;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderDiscount;
import com.yundongjia.oa.admin.po.TOrderDiscountExample;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TRegionsExample;
import com.yundongjia.oa.admin.po.TRegionsExample.Criteria;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.admin.service.EnterpriseAndSelfCardService;

@Service
public class EnterpriseAndSelfCardServiceImpl implements EnterpriseAndSelfCardService{
	@Resource
	private TRegionsMapper tRegionsMapper;
	@Resource
	private TCardTypeMapper tCardTypeMapper;
	@Resource
	private TMemberCardOrderRefMapper tMemberCardOrderRefMapper;
	@Resource
	private TOpeartionMapper tOpeartionMapper;
	@Resource
	private TAdminMapper tAdminMapper;
	@Resource
	private TActivityOrderMapper tActivityOrderMapper;
	@Resource
	private TGoodsOrderMapper tGoodsOrderMapper;
	@Resource
	private TOrderDiscountMapper tOrderDiscountMapper;
	@Resource
	private TLeagueOrderMapper tLeagueOrderMapper;
	@Resource
	private TOrderMapper tOrderMapper;
	@Resource
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	
	/**
	 * 查询开通的城市信息
	 * @return
	 * @author LXY
	 * @time 2017/1/10
	 */
	@Override
	public List<TRegions> findRegions() {
		TRegionsExample tr1 = new TRegionsExample();
		Criteria createCriteria1 = tr1.createCriteria();
		createCriteria1.andIsshowEqualTo(1).andLevelEqualTo(0);
		TRegionsExample tr2 = new TRegionsExample();
		Criteria createCriteria2 = tr1.createCriteria();
		createCriteria2.andIsshowEqualTo(1).andLevelEqualTo(1);
		TRegionsExample tr = new TRegionsExample();
		tr.or(createCriteria1);
		tr.or(createCriteria2);
		List<TRegions> list = new ArrayList<TRegions>();
		List<TRegions> tRegions = tRegionsMapper.selectByExample(tr);
		for (int i = 0; i < tRegions.size(); i++) {
			if(	tRegions.get(i).getpCode() != 0 && !"市辖区".equals(tRegions.get(i).getName()) && !"县".equals(tRegions.get(i).getName())){
				list.add(tRegions.get(i));
			}
			if(tRegions.get(i).getpCode() == 0 && ("北京市".equals(tRegions.get(i).getName()) || "天津市".equals(tRegions.get(i).getName()) || "上海市".equals(tRegions.get(i).getName()))){
				list.add(tRegions.get(i));
			}
		}
		return list;
	}
	
	/**
	 * @return
	 * 创建企业卡类型
	 */
	@Override
	public Integer insertEnterpriseCardType(TCardType tCardType , TOpeartion opeartion) {
		try {
			int reult = tCardTypeMapper.insertSelective(tCardType);
			opeartion.setOpeartionInfo("创建企业卡类型----类型名为" + tCardType.getCardtypename());
			opeartion.setOpeartionById(tCardType.getCardid());
			opeartion.setOpeartionType(3);
			//插入操作记录信息
			tOpeartionMapper.insertSelective(opeartion);
			if(reult == 0){
				return 0;
			}else{
				return tCardType.getCardid();
			}
		} catch (Exception e) {
			return -1;	
		}
	}
	
	/**
	 * @return
	 * 跳转到企业卡类型列表页
	 */
	@Override
	public List<TCardType> findenterprisecardlist() {
		TCardTypeExample tCardTypeExample = new TCardTypeExample();
		tCardTypeExample.createCriteria().andIsdelEqualTo("0").andCardtypeEqualTo("2");
		tCardTypeExample.setOrderByClause("cardId desc");
		List<TCardType> list = tCardTypeMapper.selectByExample(tCardTypeExample);
		for (TCardType t : list) {
			TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
			tMemberCardOrderRefExample.createCriteria().andCardtypeidEqualTo(t.getCardid()).andIsdelEqualTo(0);
			int count = tMemberCardOrderRefMapper.countByExample(tMemberCardOrderRefExample);
			t.setSurplusstock(count);
			if("-1".equals(t.getRegionsid())){
				t.setRegionsid("全覆盖");
			}else{
				String[] split = t.getRegionsid().split(",");
				String cityName = "";
				for (int i = 0; i < split.length; i++) {
					TRegions regions = tRegionsMapper.selectByPrimaryKey(Integer.parseInt(split[i]));
					if(i == split.length - 1){
						cityName = cityName + regions.getName();
					}else{
						cityName = cityName + regions.getName() + ",";
					}
				}
				t.setRegionsid(cityName);
			}
		}
		return list;
	}
	
	/**
	 * @return
	 * 启用禁用企业卡类
	 */
	@Override
	public Integer updateStopOrStart(Integer status, Integer cardId, TOpeartion tOpeartion) {
		try {
			TCardType tCardType = new TCardType();
			tCardType.setIsstop(status.toString());
			tCardType.setCardid(cardId);
			int result = tCardTypeMapper.updateByPrimaryKeySelective(tCardType);
			TMemberCardOrderRef tMemberCardOrderRef = new TMemberCardOrderRef();
			tMemberCardOrderRef.setStatus(status);
			TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
			tMemberCardOrderRefExample.createCriteria().andCardtypeidEqualTo(cardId);
			tMemberCardOrderRefMapper.updateByExampleSelective(tMemberCardOrderRef, tMemberCardOrderRefExample);
			tOpeartion.setOpeartionById(cardId);
			if(status == 1){
				tOpeartion.setOpeartionInfo("禁用卡类以及下属单卡");
			}else if(status == 0){
				tOpeartion.setOpeartionInfo("启用卡类以及下属卡");
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
	 * @return
	 * 根据ID查询企业卡类
	 */
	@Override
	public TCardType findById(Integer cardid) {
		TCardType t = tCardTypeMapper.selectByPrimaryKey(cardid);
		TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
		tMemberCardOrderRefExample.createCriteria().andOrderidEqualTo(t.getCardid()).andIsdelEqualTo(0);
		int count = tMemberCardOrderRefMapper.countByExample(tMemberCardOrderRefExample);
		t.setSurplusstock(count);
		if("-1".equals(t.getRegionsid())){
			t.setRegionsid("全覆盖");
		}else{
			String[] split = t.getRegionsid().split(",");
			String cityName = "";
			for (int i = 0; i < split.length; i++) {
				TRegions regions = tRegionsMapper.selectByPrimaryKey(Integer.parseInt(split[i]));
				if(i == split.length - 1){
					cityName = cityName + regions.getName();
				}else{
					cityName = cityName + regions.getName() + ",";
				}
			}
			t.setRegionsid(cityName);
		}
		TAdmin tadmin = tAdminMapper.selectByPrimaryKey(t.getOpeartionadminid());
		t.setIsdel(tadmin.getBackusername());
		return t;
	}
	/**
	 * @param cardid
	 * @return查询会员卡订单信息根据会员卡类型ID
	 */
	@Override
	public List<Map> findListByCardTypeId(Integer cardid) {
		Map param = new HashMap();
		param.put("cardid", cardid);					
		return tMemberCardOrderRefMapper.findListByCardTypeId(param);
	}
	/**
	 * @return
	 * 根据企业名称查询卡类型下的单卡
	 */
	@Override
	public List<Map> enterpriseDetail(Integer cardid ,  String info) {
		info = "%" + info + "%";
		Map param = new HashMap();
		param.put("cardid", cardid);
		param.put("info", info);
		return tMemberCardOrderRefMapper.findListByCardTypeId(param);
	}
	/**
	 * @return
	 * 启用禁用企业卡
	 */
	@Override
	public Integer updateStopOrStartCard(Integer status, Integer cardId, TOpeartion tOpeartion) {
		try {
			TMemberCardOrderRef tMemberCardOrderRef = new TMemberCardOrderRef();
			tMemberCardOrderRef.setStatus(status);
			tMemberCardOrderRef.setOrderid(cardId);
			Integer result = tMemberCardOrderRefMapper.updateByPrimaryKeySelective(tMemberCardOrderRef);
			tOpeartion.setOpeartionById(cardId);
			if(status == 1){
				tOpeartion.setOpeartionInfo("禁用企业单卡");
			}else if(status == 0){
				tOpeartion.setOpeartionInfo("启用企业单卡");
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
	 * @param cardid
	 * @return查询企业单卡信息根据主键
	 */
	@Override
	public Map enterpriseCardDetail(Integer cardid) {
		Map param = new HashMap();
		param.put("cid", cardid);
		return tMemberCardOrderRefMapper.findListByCardTypeId(param).get(0);
	}
	
	/**
	 * @return
	 * 创建个人卡类型
	 */
	@Override
	public Integer insertSelfCardType(TCardType tCardType, TOpeartion opeartion) {
		try {
			int reult = tCardTypeMapper.insertSelective(tCardType);
			opeartion.setOpeartionInfo("创建个人卡类型----类型名为" + tCardType.getCardtypename());
			opeartion.setOpeartionById(tCardType.getCardid());
			opeartion.setOpeartionType(1);
			//插入操作记录信息
			tOpeartionMapper.insertSelective(opeartion);
			if(reult == 0){
				return 0;
			}else{
				return tCardType.getCardid();
			}
		} catch (Exception e) {
			return -1;	
		}
	}
	/**
	 * @return查询个人卡类型列表
	 */
	@Override
	public List<TCardType> findselfcardlist() {
		TCardTypeExample tCardTypeExample = new TCardTypeExample();
		tCardTypeExample.createCriteria().andIsdelEqualTo("0").andCardtypeEqualTo("1");
		tCardTypeExample.setOrderByClause("cardId desc");
		List<TCardType> list = tCardTypeMapper.selectByExample(tCardTypeExample);
		for (TCardType t : list) {
			TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
			tMemberCardOrderRefExample.createCriteria().andOrderidEqualTo(t.getCardid()).andIsdelEqualTo(0);
			int count = tMemberCardOrderRefMapper.countByExample(tMemberCardOrderRefExample);
			t.setSurplusstock(count);
			if("-1".equals(t.getRegionsid())){
				t.setRegionsid("全覆盖");
			}else{
				String[] split = t.getRegionsid().split(",");
				String cityName = "";
				for (int i = 0; i < split.length; i++) {
					TRegions regions = tRegionsMapper.selectByPrimaryKey(Integer.parseInt(split[i]));
					if(i == split.length - 1){
						cityName = cityName + regions.getName();
					}else{
						cityName = cityName + regions.getName() + ",";
					}
				}
				t.setRegionsid(cityName);
			}
		}
		return list;
	}
	/**
	 * @param cardid
	 * @return根据卡类ID查询个人卡类
	 */
	@Override
	public TCardType findSelfById(Integer cardid) {
		TCardType t = tCardTypeMapper.selectByPrimaryKey(cardid);
		TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
		tMemberCardOrderRefExample.createCriteria().andOrderidEqualTo(t.getCardid()).andIsdelEqualTo(0);
		int count = tMemberCardOrderRefMapper.countByExample(tMemberCardOrderRefExample);
		t.setSurplusstock(count);
		if("-1".equals(t.getRegionsid())){
			t.setRegionsid("全覆盖");
		}else{
			String[] split = t.getRegionsid().split(",");
			String cityName = "";
			for (int i = 0; i < split.length; i++) {
				TRegions regions = tRegionsMapper.selectByPrimaryKey(Integer.parseInt(split[i]));
				if(i == split.length - 1){
					cityName = cityName + regions.getName();
				}else{
					cityName = cityName + regions.getName() + ",";
				}
			}
			t.setRegionsid(cityName);
		}
		TAdmin tadmin = tAdminMapper.selectByPrimaryKey(t.getOpeartionadminid());
		t.setIsdel(tadmin.getBackusername());
		return t;
	}
	/**
	 * @param cardid 卡类型ID
	 * @return查询个人卡列表详情
	 */
	@Override
	public List<Map> findListSelfByCardTypeId(Integer cardid) {
		Map param = new HashMap();
		param.put("cardid", cardid);
		return tMemberCardOrderRefMapper.findListSelfByCardTypeId(param);
	}

	@Override
	public Map selfCardDetail(Integer cardid) {
		Map param = new HashMap();
		param.put("cid", cardid);
		return tMemberCardOrderRefMapper.findListSelfByCardTypeId(param).get(0);
	}

	@Override
	public List<TCardType> findCardTypeByEnterType(Integer cardTypeId) {
		List<TCardType> list = tCardTypeMapper.findCardTypeByEnterType(cardTypeId);
		
		for (TCardType t : list) {
			if("-1".equals(t.getRegionsid())){
				t.setRegionsid("全覆盖");
			}else{
				String[] split = t.getRegionsid().split(",");
				String cityName = "";
				for (int i = 0; i < split.length; i++) {
					TRegions regions = tRegionsMapper.selectByPrimaryKey(Integer.parseInt(split[i]));
					if(i == split.length - 1){
						cityName = cityName + regions.getName();
					}else{
						cityName = cityName + regions.getName() + ",";
					}
				}
				t.setRegionsid(cityName);
			}
		}
		return list;
	}

	@Override
	public int updateCardTypeById(TCardType type) {
		return tCardTypeMapper.updateByPrimaryKeySelective(type);
	}
	
	/**
	 * @param cardid
	 * @return查询个人单卡的订单信息
	 * @author LXY
	* @date 2017年2月8日
	 */
	@Override
	public List findOrderList(Integer cardid) {
		List order = new ArrayList();
		//查询订单优惠列表信息
		TOrderDiscountExample tOrderDiscountExample = new TOrderDiscountExample();
		List<TOrderDiscount> orderDiscounts  = tOrderDiscountMapper.selectByExample(tOrderDiscountExample);
		//查询活动订单列表
		TActivityOrderExample tActivityOrder = new TActivityOrderExample();
		List<TActivityOrder> activityOrders = tActivityOrderMapper.selectByExample(tActivityOrder);
		for (TActivityOrder ao : activityOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(4) && ao.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					ao.setType("活动");
					ao.setSelfCardCoupon(od.getSelfcard());
					order.add(ao);
				}
			}
		}
		//查询商品订单列表
		TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
		List<TGoodsOrder> tGoodsOrders = tGoodsOrderMapper.selectByExample(tGoodsOrderExample);
		for (TGoodsOrder tg : tGoodsOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(0) && tg.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					tg.setType("商城");
					tg.setSelfCardCoupon(od.getSelfcard());
					order.add(tg);
				}
			}
		}
		//查询团课订单列表
		TLeagueOrderExample tLeagueOrderExample = new TLeagueOrderExample();
		List<TLeagueOrder> tLeagueOrders = tLeagueOrderMapper.selectByExample(tLeagueOrderExample);
		for (TLeagueOrder tl : tLeagueOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(3) && tl.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					tl.setType("课程");
					tl.setSelfCardCoupon(od.getSelfcard());
					order.add(tl);
				}
			}
		}
		//查询私课订单列表
		TOrderExample tOrderExample = new TOrderExample();
		List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
		for (TOrder to : tOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(2) && to.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					to.setType("私课");
					to.setSelfCardCoupon(od.getSelfcard());
					order.add(to);
				}
			}
		}
		//查询场馆订单列表
		TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
		List<TStudioConsumeOrderRecord> tStudioConsumeOrderRecords = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
		for (TStudioConsumeOrderRecord ts : tStudioConsumeOrderRecords) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(1) && ts.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					ts.setType("场馆");
					ts.setSelfCardCoupon(od.getSelfcard());
					order.add(ts);
				}
			}
		}
		return order;
	}
	/**
	 * @param cardid
	 * @param info 手机号搜索条件
	 * @return查询个人单卡的订单信息 根据手机号筛选
	 * @author LXY
	* @date 2017年2月8日
	 */
	@Override
	public List findOrderList(Integer cardid, String info) {
		List order = new ArrayList();
		//查询订单优惠列表信息
		TOrderDiscountExample tOrderDiscountExample = new TOrderDiscountExample();
		List<TOrderDiscount> orderDiscounts  = tOrderDiscountMapper.selectByExample(tOrderDiscountExample);
		//查询活动订单列表
		TActivityOrderExample tActivityOrder = new TActivityOrderExample();
		List<TActivityOrder> activityOrders = tActivityOrderMapper.selectByExample(tActivityOrder);
		for (TActivityOrder ao : activityOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(4) && ao.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					ao.setType("活动");
					ao.setSelfCardCoupon(od.getSelfcard());
					if(ao.getMobilephonenum()!=null && ao.getMobilephonenum().contains(info)){
						order.add(ao);
					}
				}
			}
		}
		//查询商品订单列表
		TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
		List<TGoodsOrder> tGoodsOrders = tGoodsOrderMapper.selectByExample(tGoodsOrderExample);
		for (TGoodsOrder tg : tGoodsOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(0) && tg.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					tg.setType("商城");
					tg.setSelfCardCoupon(od.getSelfcard());
					if(tg.getMobilephonenum()!=null && tg.getMobilephonenum().contains(info)){
						order.add(tg);
					}
				}
			}
		}
		//查询团课订单列表
		TLeagueOrderExample tLeagueOrderExample = new TLeagueOrderExample();
		List<TLeagueOrder> tLeagueOrders = tLeagueOrderMapper.selectByExample(tLeagueOrderExample);
		for (TLeagueOrder tl : tLeagueOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(3) && tl.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					tl.setType("课程");
					tl.setSelfCardCoupon(od.getSelfcard());
					if(tl.getMobilephonenum()!=null && tl.getMobilephonenum().contains(info)){
						order.add(tl);
					}
				}
			}
		}
		//查询私课订单列表
		TOrderExample tOrderExample = new TOrderExample();
		List<TOrder> tOrders = tOrderMapper.selectByExample(tOrderExample);
		for (TOrder to : tOrders) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(2) && to.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					to.setType("私课");
					to.setSelfCardCoupon(od.getSelfcard());
					if(to.getMobilephonenum()!=null && to.getMobilephonenum().contains(info)){
						order.add(to);
					}
				}
			}
		}
		//查询场馆订单列表
		TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
		List<TStudioConsumeOrderRecord> tStudioConsumeOrderRecords = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
		for (TStudioConsumeOrderRecord ts : tStudioConsumeOrderRecords) {
			for (TOrderDiscount od : orderDiscounts) {
				if(od.getStatus().equals(1) && ts.getOrderid().equals(od.getOrderid()) && od.getCardid().equals(cardid)){
					ts.setType("场馆");
					ts.setSelfCardCoupon(od.getSelfcard());
					if(ts.getMobilephonenum()!=null && ts.getMobilephonenum().contains(info)){
						order.add(ts);
					}
				}
			}
		}
		return order;
	}
}
