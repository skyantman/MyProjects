package com.yundongjia.app.user.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.PayOrderService;
import com.yundongjia.oa.admin.mapper.TActivityMapper;
import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TCardTypeMapper;
import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TGoodsMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardEnterpriseRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberCouponRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TPrivateLessonTimeMapper;
import com.yundongjia.oa.admin.mapper.TRedpackageMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.mapper.TUserMapper;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRef;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRefExample;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TPrivateLessonTime;
import com.yundongjia.oa.admin.po.TPrivateLessonTimeExample;
import com.yundongjia.oa.admin.po.TRedpackage;
import com.yundongjia.oa.admin.po.TRedpackageExample;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.SendMessage;
@Service
public class PayOrderServiceImp implements PayOrderService {
	@Autowired
	private TMemberMapper tMemberMapper;
	@Autowired
	private TRedpackageMapper tRedpackageMapper;
	@Autowired
	private TMemberCouponRefMapper tMemberCouponRefMapper ;
	@Autowired
	private TUserMapper tUserMapper; 
	@Autowired
	private TActivityOrderMapper tActivityOrderMapper;
	@Autowired
	private TActivityMapper tActivityMapper;
	@Autowired
	private TMemberCardOrderRefMapper tMemberCardOrderRefMapper;
	@Autowired
	private TMemberCardEnterpriseRefMapper tMemberCardEnterpriseRefMapper;
	@Autowired
	private TGoodsMapper tGoodsMapper;
	@Autowired
	private TGoodsOrderMapper tGoodsOrderMapper;
	@Autowired
	private TCardTypeMapper tCardTypeMapper;
	@Autowired
	private TOrderMapper tOrderMapper;
	@Autowired
	private TCoachMapper tCoachMapper;
	 @Autowired
	 private TPrivateLessonTimeMapper tPrivateLessonTimeMapper;
	@Autowired
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	@Autowired
	private TStudioMapper tStudioMapper;
	
	/**
	 * @param memberId 会员Id
	 * @return查询会员信息根据Id
	 */
	@Override
	public TMember findMemberById(Integer memberId) {
		return tMemberMapper.selectByPrimaryKey(memberId);
	}
	/**
	 * @param memberId 会员ID
	 * @return查询会员的可用红包余额
	 */
	@Override
	public Double findUsableRedPackage(Integer memberId) {
		TRedpackageExample tRedpackageExample = new TRedpackageExample();
		tRedpackageExample.createCriteria().andExpiredateGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).andMemberidEqualTo(memberId);
		List<TRedpackage> redpackage = tRedpackageMapper.selectByExample(tRedpackageExample);
		Double amount = 0d;
		for (TRedpackage te : redpackage) {
			amount = amount +  te.getAmount();
		}
		return amount;
	}
	/**
	 * @param memberId 会员ID
	 * @param price 订单价格
	 * @param couponType 优惠券类型（(覆盖商品)   0 通用   1 场馆 2 教练   3团课  4 充值卡   5活动优惠券 6 私课）
	 * @return查询会员可用优惠券列表
	 */
	@Override
	public List<Map<String , Object>> findCouponByMemberId(Integer memberId , Double price ,Integer couponType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("price", price);
		param.put("couponType", "%"+couponType+ "%");
		List<Map<String, Object>> list = tMemberCouponRefMapper.findUsableCoupon(param);
		int i = 0;
		double discount = 10d;
		double maxDiscount = 0d;
		int disId = 0;
		double amount = 0d;
		int amoId = 0;
		if(list.size() == 1){
			list.get(0).put("isChecked", 1);
			list.get(0).put("status", 0);
			list.get(0).put("expirtionDate", list.get(0).get("expirtionDate").toString().split(" ")[0]);
			String[] couType = String.valueOf(list.get(0).get("couponType")).split(",");
			if (couType != null && couType.length > 0) {
				if (0 == Integer.parseInt(String.valueOf(couType[0]))) {
					list.get(0).put("couponTypeName", "通用");
				} else {
					String couTypesStr = "限";

					for (int j = 0; j < couType.length - 1; j++) {
						couTypesStr += getCouponTypeName(couType[j])+ ",";
					}
					couTypesStr += getCouponTypeName(couType[couType.length - 1] ) + "使用";

					list.get(0).put("couponTypeName", couTypesStr);
				}
			}
			//金额券
			if("1".equals(list.get(0).get("couponMethod"))){
				list.get(0).put("selCouponMoney", Double.parseDouble(list.get(0).get("discountAmount").toString()));
			//折扣券
			}else if("0".equals(list.get(0).get("couponMethod"))){
				Double couponPrice = ((10d-Double.parseDouble(list.get(0).get("discountAmount").toString()))/10)*price;
				if(couponPrice >= Double.parseDouble(list.get(0).get("maxMoney").toString())){
					list.get(0).put("selCouponMoney",Double.parseDouble(list.get(0).get("maxMoney").toString()));
				}else{
					list.get(0).put("selCouponMoney", couponPrice);
				}
			}
			list.get(0).put("status", 0);
		}else{
			for (Map<String, Object> map : list) {
				if(Integer.parseInt(map.get("couponMethod").toString()) == 0){
					if(discount>(double)map.get("discountAmount")){
						discount = (double)map.get("discountAmount");
						maxDiscount = (double)map.get("maxMoney");
						disId = i;
					}
				}else if(Integer.parseInt(map.get("couponMethod").toString())  == 1){
					if(amount<(double)map.get("discountAmount")){
						amount = (double)map.get("discountAmount");
						amoId = i;
					}
				}
				map.put("isChecked", 0);
				map.put("expirtionDate", map.get("expirtionDate").toString().split(" ")[0]);
				String[] couType = String.valueOf(map.get("couponType")).split(",");
				if (couType != null && couType.length > 0) {
					if (0 == Integer.parseInt(String.valueOf(couType[0]))) {
						map.put("couponTypeName", "通用");
					} else {
						String couTypesStr = "限";

						for (int j = 0; j < couType.length - 1; j++) {
							couTypesStr += getCouponTypeName(couType[j])+ ",";
						}
						couTypesStr += getCouponTypeName(couType[couType.length - 1] ) + "使用";

						map.put("couponTypeName", couTypesStr);
					}
				}
				map.put("status", 0);
				//金额券
				if("1".equals(map.get("couponMethod"))){
					map.put("selCouponMoney", Double.parseDouble(map.get("discountAmount").toString()));
				//折扣券
				}else if("0".equals(map.get("couponMethod"))){
					Double couponPrice = ((10d-Double.parseDouble(map.get("discountAmount").toString()))/10)*price;
					if(couponPrice >= Double.parseDouble(map.get("maxMoney").toString())){
						map.put("selCouponMoney", Double.parseDouble(map.get("maxMoney").toString()));
					}else{
						map.put("selCouponMoney", couponPrice);
					}
				}
				i++;
			}
		}
     if((10 - price)/ 10  * discount > amount && maxDiscount > amount && list.size() != 0){
    	 list.get(disId).put("isChecked", 1);
     }else if((10 - price) / 10  * discount <= amount && list.size() != 0){
    	 list.get(amoId).put("isChecked", 1);
     }else{
    	 if(list.size() != 0){
    		 list.get(0).put("isChecked", 1);
    	 }
     }
		return  list;
	}
	
	
	public String getCouponTypeName(String coutType) {
		String tempStr="";
		switch (coutType) {
		case "1":
			tempStr="场馆";
			break;
		case "2":
			tempStr="教练";
			break;
		case "3":
			tempStr="团课";
			break;
		case "4":
			tempStr="充值卡";
			break;
		case "5":
			tempStr="活动";
			break;
		case "6":
			tempStr="私课";
			break;
		}
		
		return tempStr;
	}
	
	/**
	 * @param memberId
	 * @return根据MemberId查询用户的手机号
	 */
	@Override
	public String findMemberMobilephoneNo(Integer userId) {
		return tUserMapper.selectByPrimaryKey(userId).getMobilephoneno();
	}
	/**
	 * @param tActivityOrder订单信息对象
	 * @return插入活动订单信息
	 */
	@Override
	public Integer insetActivityOrder(TActivityOrder tActivityOrder) {
		int result = tActivityOrderMapper.insertSelective(tActivityOrder);
		if(result == 0){
			return null;
		}else{
			return tActivityOrder.getOrderid();
		}
		
	}
	/**
	 * @param proId主键ID
	 * @return查询活动信息根据主键
	 */
	@Override
	public TActivity finActiveById(Integer proId) {
		return tActivityMapper.selectByPrimaryKey(proId);
	}
	
	/**
	 * @param memberId
	 * @return查询个人卡
	 */
	@Override
	public Map<String, Object> findSelfCard(Integer memberId) {
		Map<String, Object> result= new HashMap<String , Object>();
		TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
		tMemberCardOrderRefExample.createCriteria().andMemberidEqualTo(memberId).andStatusEqualTo(0).andIsdelEqualTo(0).andPaystatusEqualTo("2");
		List<TMemberCardOrderRef> list = tMemberCardOrderRefMapper.selectByExample(tMemberCardOrderRefExample);
		if(list.size() != 0){
			result.put("cardId", list.get(0).getOrderid());
			result.put("discount", list.get(0).getDiscount());
			return result;
		}else{
			return null;
		}
	}
	/**
	 * @param memberId
	 * @return查询用户下的企业卡
	 */
	@Override
	public Map<String, Object> findEnterpriseCard(Integer memberId) {
		Map<String, Object> result= new HashMap<String , Object>();
		TMemberCardEnterpriseRefExample te = new TMemberCardEnterpriseRefExample();
		te.createCriteria().andMemberidEqualTo(memberId);
		List<TMemberCardEnterpriseRef> list = tMemberCardEnterpriseRefMapper.selectByExample(te);
		if(list.size() == 0){
			return null;
		}
		Integer i = 0;
		Integer index = -1;
		TMemberCardOrderRef enterpriseCard =  null;
		Integer supcount = 0;
		for (TMemberCardEnterpriseRef tm : list) {
			Integer cardId = tm.getCardid();
			TMemberCardOrderRef enterprise = tMemberCardOrderRefMapper.selectByPrimaryKey(cardId);
			if(enterprise != null && enterprise.getIsdel() == 0 &&  enterprise.getStatus() == 0 && enterprise.getMemberid() == -1){
				result.put("cardId", enterprise.getOrderid());
				result.put("surplusSportsCount", enterprise.getSurplussportscount());
				if(supcount < enterprise.getSurplussportscount()){
					enterpriseCard = enterprise;
					index = i;
				}
			}
			i++;
		}
		if(index == -1){
			return null;
		}else{
			result.put("cardId", enterpriseCard.getOrderid());
			result.put("surplusSportsCount", enterpriseCard.getSurplussportscount());
			return result;
		}
		
	}
	/**
	 * @param enterpriseCardId 企业卡ID
	 * @param activeSubNum 企业卡扣除次数
	 * @return
	 */
	@Override
	public Integer updateEnterpriseCardSportNum(Integer enterpriseCardId, Integer enterpriseSubNum) {
		TMemberCardOrderRef tMemberCardOrderRef = tMemberCardOrderRefMapper.selectByPrimaryKey(enterpriseCardId);
		Integer result = null;
		if(tMemberCardOrderRef.getSurplussportscount() >= enterpriseSubNum){
			tMemberCardOrderRef.setOrderid(enterpriseCardId);
			tMemberCardOrderRef.setSurplussportscount(tMemberCardOrderRef.getSurplussportscount() - enterpriseSubNum );
			result = tMemberCardOrderRefMapper.updateByPrimaryKeySelective(tMemberCardOrderRef);
		}else{
			return 2;
		}
		return result;
	}
	/**
	 * @param memberId 会员ID
	 * @param realPrice订单价格
	 * @return更新会员余额信息
	 */
	@Override
	public Integer updateMemberBlance(Integer memberId, Double realPrice) {
		TMember member = tMemberMapper.selectByPrimaryKey(memberId);
		Integer result = null;
		if(member.getBalance() >= realPrice){
			member.setMemberid(memberId);
			member.setBalance(member.getBalance() - realPrice);
			result = tMemberMapper.updateByPrimaryKeySelective(member);
		}else{
			return 2;
		}
		return result;
	}
	/**
	 * @param proId
	 * @return 查询活动信息根据ID
	 */
	@Override
	public TGoods findGoodsInfoById(Integer proId) {
		return tGoodsMapper.selectByPrimaryKey(proId);
	}
	/**
	 * @param tGoodsOrder
	 * @return插入商品订单信息
	 */
	@Override
	public Integer insetGoodsOrder(TGoodsOrder tGoodsOrder) {
		int result = tGoodsOrderMapper.insertSelective(tGoodsOrder);
		if(result == 1){
			return tGoodsOrder.getOrderid();
		}else{
			return null;
		}
	}
	/**
	 * @param proId
	 * @return根据卡类型ID查询类型信息
	 */
	@Override
	public TCardType findMemberTypeById(Integer proId) {
		return tCardTypeMapper.selectByPrimaryKey(proId);		
	}
	
	/**
	 * @param tMemberCardOrderRef
	 * @return插入个人卡预付订单
	 */
	@Override
	public Integer insetMemberCardOrder(TMemberCardOrderRef tMemberCardOrderRef) {
		int result = tMemberCardOrderRefMapper.insertSelective(tMemberCardOrderRef);
		if(result == 1){
			return tMemberCardOrderRef.getOrderid();
		}else{
			return null;
		}
	}
	/**
	 * @param tOrder
	 * @return插入私课订单
	 */
	@Override
	public Integer insertPrivateOrder(TOrder tOrder) {
		int result = tOrderMapper.insertSelective(tOrder);
		if(result == 1){
			return tOrder.getOrderid();
		}else{
			return null;
		}
	}
	/**
	 * @param coachId
	 * @return根据ID查询教练信息
	 */
	@Override
	public TCoach findCoachById(Integer coachId) {
		return tCoachMapper.selectByPrimaryKey(coachId);
	}
	/**
	 * @param tActivity
	 * @return更新活动报名人数
	 */
	@Override
	public Integer updateActiveJoinMan(TActivity tActivity) {
		return tActivityMapper.updateByPrimaryKeySelective(tActivity);
	}
	/**
	 * @param goods
	 * @return更新商品库存数量
	 */
	@Override
	public Integer updateGoodsNum(TGoods goods) {
		return tGoodsMapper.updateByPrimaryKeySelective(goods);
	}
	/**
	 * @param time
	 * @return更新私课教练时间
	 */
	@Override
	public Integer updatePrivateOrderDate(TPrivateLessonTime time, String timeSpan) {
		TPrivateLessonTime tPrivateLessonTime = tPrivateLessonTimeMapper.selectByPrimaryKey(time.getRowid());
		String[] span = timeSpan.replaceAll(":00", "").split("-");
		String orderSpan = "";
		if(span.length == 1){
			orderSpan = span[0];
		}else{
			for (int i = Integer.parseInt(span[0]); i < Integer.parseInt(span[1]); i++) {
				if(i == Integer.parseInt(span[1]) -1){
					orderSpan = orderSpan + i;
				}else{
					orderSpan = orderSpan + i +",";
				}
				
			}
		}
			String[] unavailabletime = (tPrivateLessonTime.getUnavailabletimespan() + ","+orderSpan).split(",");
			List<Integer> intAvailable = new ArrayList<Integer>();
			for (int i = 0; i < unavailabletime.length; i++) {
				if(!"".equals(unavailabletime[i])){
					intAvailable.add(Integer.parseInt(unavailabletime[i]));
				}
				
			}
			Collections.sort(intAvailable);
			String unavailabletimespan = "";
			for (int i = 0; i < intAvailable.size(); i++) {
				if(i == intAvailable.size() -1){
					unavailabletimespan =unavailabletimespan + intAvailable.get(i);
				}else{
					unavailabletimespan =unavailabletimespan + intAvailable.get(i) + ",";
				}
			}
			String availableSpan = tPrivateLessonTime.getAvailabletimespan().replace(orderSpan, "");
			tPrivateLessonTime.setUnavailabletimespan(unavailabletimespan);
			tPrivateLessonTime.setAvailabletimespan(availableSpan);
		return tPrivateLessonTimeMapper.updateByPrimaryKeySelective(tPrivateLessonTime);
	}
	/**
	 * @param tCardType
	 * @return更新会员卡类型剩余库存
	 */
	@Override
	public Integer updateCardTypeNum(TCardType tCardType) {
		return tCardTypeMapper.updateByPrimaryKeySelective(tCardType);
	}
	/**
	 * @param orderType 
	 * @param orderNum
	 * @return更新订单状态
	 */
	@Override
	public Integer updateCancelOrder(Integer orderType, Integer orderId) {
		Logger logger = Logger.getLogger(PayOrderServiceImp.class);
		String data = "";
		String aa ="";
		String[] am = {};
		String a0 = "";
		switch (orderType) {
		case 1://活动订单
			//查询活动订单
			TActivityOrder  activeOrder = tActivityOrderMapper.selectByPrimaryKey(orderId);
			if(activeOrder == null){
				return 0;
			}
			activeOrder.setPaystatus("1");
			//更新活动订单状态
			int updateRe = tActivityOrderMapper.updateByPrimaryKeySelective(activeOrder);
			
			if(updateRe != 0){
				Integer activityid = activeOrder.getActivityid();
				int resultA = 0;
				if(activityid != null && activityid != 0){
					TActivity activity = tActivityMapper.selectByPrimaryKey(activityid);
					activity.setAlreadyman(activity.getAlreadyman() - activeOrder.getJoinman());
					resultA = tActivityMapper.updateByPrimaryKeySelective(activity);
				}
				/*data = SendMessage.sendAppointmentMessage(activeOrder.getMobilephonenum(),"您的订单【"+ activeOrder.getOrdernum() +"】【"+ activeOrder.getComm() +"】已取消，如有问题，请致电客服：");
				//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + activeOrder.getOrdernum() + "】在取消活动订单时，短信因服务商问题未发送至用户！");
				}else if(resultA == 0){
					logger.error("订单号【" + activeOrder.getOrdernum()  + "】在取消活动订单时，短信后台保存验证码时出现异常，并未发送至用户！");
				}*/
				return resultA;
			}else{
				return 0;
			}
		case 2://商品订单
			TGoodsOrder goodsOrder = tGoodsOrderMapper.selectByPrimaryKey(orderId);
			if(goodsOrder == null){
				return 0;
			}
			goodsOrder.setPaystatus(1);
			int goodsOrderResult = tGoodsOrderMapper.updateByPrimaryKeySelective(goodsOrder);
			if(goodsOrderResult != 0){
				Integer goodsId = goodsOrder.getGid();
				Integer  resultG = 0;
				if(goodsId != 0 && goodsId != null){
					TGoods goods = tGoodsMapper.selectByPrimaryKey(goodsId);
					goods.setGcount(goods.getGcount() + goodsOrder.getBuynum());
					resultG =  tGoodsMapper.updateByPrimaryKeySelective(goods);
				}
				/*data = SendMessage.sendAppointmentMessage(goodsOrder.getMobilephonenum(),"您的订单【"+ goodsOrder.getOrdernum() +"】【"+ goodsOrder.getComm().split(" ")[0] +"】已取消，如有问题，请致电客服：");
				//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + goodsOrder.getOrdernum() + "】在取消商品订单时，短信因服务商问题未发送至用户！");
				}else if(resultG == 0){
					logger.error("订单号【" + goodsOrder.getOrdernum()  + "】在取消商品订单时，短信后台保存验证码时出现异常，并未发送至用户！");
				}*/
				return resultG;
			}else{
				return 0;
			}
		case 3://私课订单
			TOrder tOrder = tOrderMapper.selectByPrimaryKey(orderId);
			if(tOrder == null){
				return 0;
			}
			tOrder.setPaystatus(1);
			int orderResult = tOrderMapper.updateByPrimaryKeySelective(tOrder);
			if(orderResult != 0){
				TPrivateLessonTimeExample timeExample = new TPrivateLessonTimeExample();
				timeExample.createCriteria().andLessondateEqualTo(tOrder.getClassdate().replace("-", "")).andCoachidEqualTo(tOrder.getCoachid());
				 List<TPrivateLessonTime> selectByExample = tPrivateLessonTimeMapper.selectByExample(timeExample);
				 if(selectByExample.size() == 0){
					 return 0;
				 }
				TPrivateLessonTime tPrivateLessonTime =selectByExample.get(0);
				String[] span = tOrder.getTimespan().replaceAll(":00", "").split("-");
				String orderSpan = "";
 				for (int i = Integer.parseInt(span[0]); i < Integer.parseInt(span[1]); i++) {
 					if(i == Integer.parseInt(span[1]) -1){
 						orderSpan = orderSpan + i;
 					}else{
 						orderSpan = orderSpan + i +",";
 					}
				}
 				String[] available = (tPrivateLessonTime.getAvailabletimespan()+","+orderSpan).split(",");
 				List<Integer> intAvailable = new ArrayList<Integer>();
 				for (int i = 0; i < available.length; i++) {
 					if(!"".equals(available[i])){
 						intAvailable.add(Integer.parseInt(available[i]));
 					}
				}
 				Collections.sort(intAvailable);
 				String availableSpan = "";
 				for (int i = 0; i < intAvailable.size(); i++) {
 					if(i == intAvailable.size() -1){
 						availableSpan =availableSpan + intAvailable.get(i);
 					}else{
 						availableSpan =availableSpan + intAvailable.get(i) + ",";
 					}
 				}
 				String unavailabletimespan = tPrivateLessonTime.getUnavailabletimespan().replace(orderSpan, "");
 				tPrivateLessonTime.setUnavailabletimespan(unavailabletimespan);
 				tPrivateLessonTime.setAvailabletimespan(availableSpan);
 				Integer resultP =  tPrivateLessonTimeMapper.updateByPrimaryKeySelective(tPrivateLessonTime);
 				/*data = SendMessage.sendAppointmentMessage(tOrder.getMobilephonenum(),"您的订单【"+ tOrder.getOrdernum() +"】【"+ tOrder.getComm() +"】已取消，如有问题，请致电客服：");
				//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + tOrder.getOrdernum() + "】在取消私课订单时，短信因服务商问题未发送至用户！");
				}else if(resultP == 0){
					logger.error("订单号【" + tOrder.getOrdernum()  + "】在取消私课订单时，短信后台保存验证码时出现异常，并未发送至用户！");
				}*/
 			    return resultP;
			}else{
				return 0;
			}
		case 4://场馆订单 
			TStudioConsumeOrderRecord t = new TStudioConsumeOrderRecord();
			t.setOrderid(orderId);
			t.setPaystatus(1);
			Integer resultS =  tStudioConsumeOrderRecordMapper.updateByPrimaryKeySelective(t);
			/*data = SendMessage.sendAppointmentMessage(t.getMobilephonenum(),"您的订单【"+ t.getOrdernum() +"】【"+ t.getComm() +"】已取消，如有问题，请致电客服：");
			//验证是否发送成功
	    	aa = data;
			am = aa.split(",");
			a0 = am[0];
			//是否发送短信
			if (!"03".equals(a0)) {
				logger.error("订单号【" + t.getOrdernum() + "】在取消场馆订单时，短信因服务商问题未发送至用户！");
			}else if(resultS == 0){
				logger.error("订单号【" + t.getOrdernum()  + "】在取消场馆订单时，短信后台保存验证码时出现异常，并未发送至用户！");
			}*/
			return resultS;
		case 5://个人卡订单
			TMemberCardOrderRef cardOrder = tMemberCardOrderRefMapper.selectByPrimaryKey(orderId);
			if(cardOrder == null){
				return 0;
			}
			cardOrder.setPaystatus("1");
			int memberCardResult = tMemberCardOrderRefMapper.updateByPrimaryKeySelective(cardOrder);
			Integer resultM =  0;
			if(memberCardResult != 0){
				TCardType cardType = tCardTypeMapper.selectByPrimaryKey(cardOrder.getCardtypeid());
				if( cardType != null && cardType.getSurplusstock() != -1){
					cardType.setSurplusstock(cardType.getSurplusstock() + 1);
					resultM =  tCardTypeMapper.updateByPrimaryKeySelective(cardType);
					 if(resultM == 0){
						logger.error("订单号【" + cardOrder.getOrdernum()  + "】在取消个人卡订单时，短信后台保存验证码时出现异常，并未发送至用户！");
					}
				}
				/*data = SendMessage.sendAppointmentMessage(cardOrder.getMobilephonenum(),"您的订单【"+ cardOrder.getOrdernum() +"】【"+ cardOrder.getComm() +"】已取消，如有问题，请致电客服：");
				//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + cardOrder.getOrdernum() + "】在取消个人卡订单时，短信因服务商问题未发送至用户！");
				}*/
				return resultM;
			}else {
				return 0;
			}
		}
		return 0;
	}
	
	/**
	 * @param proTableId
	 * @return根据场馆ＩＤ查询场馆信息
	 */
	@Override
	public TStudio findStudioById(Integer proTableId) {
		return tStudioMapper.selectByPrimaryKey(proTableId);
	}
	
	/**
	 * @param classDate
	 * @param timeSpan
	 * @return查询教练的可用时间
	 */
	@Override
	public Boolean findCoachTime(String classDate, String timeSpan, Integer proTableId) {
		TPrivateLessonTimeExample timeExample = new TPrivateLessonTimeExample();
		timeExample.createCriteria().andCoachidEqualTo(proTableId).andLessondateEqualTo(classDate.replaceAll("-", ""));
		List<TPrivateLessonTime> coachTime = tPrivateLessonTimeMapper.selectByExample(timeExample);
		String[] span = timeSpan.replaceAll(":00", "").split("-");
		for (TPrivateLessonTime ct : coachTime) {
			for (int i = Integer.parseInt(span[0]); i < Integer.parseInt(span[1]); i++) {
				if(ct.getAvailabletimespan().indexOf(i+"") == -1){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * @param orderId
	 * @param orderType
	 * @return根据订单ID查询订单信息
	 */
	@Override
	public TActivityOrder finderActiveOrderInfo(Integer orderId) {
		return  tActivityOrderMapper.selectByPrimaryKey(orderId);
	}
	/**
	 * @param orderId
	 * @return根据订单ID查询商品订单信息
	 */
	@Override
	public TGoodsOrder finderGoodsOrderInfo(Integer orderId) {
		return tGoodsOrderMapper.selectByPrimaryKey(orderId);
	}
	/**
	 * @param orderId
	 * @return根据订单ID查询私课订单信息
	 */
	@Override
	public TOrder findePrivateOrderInfo(Integer orderId) {
		return tOrderMapper.selectByPrimaryKey(orderId);
	}
	/**
	 * @param orderId
	 * @return根据订单ID查询场馆订单信息
	 */
	@Override
	public TStudioConsumeOrderRecord findeStudioOrderInfo(Integer orderId) {
		return tStudioConsumeOrderRecordMapper.selectByPrimaryKey(orderId);
	}
	/**
	 * @param orderId
	 * @return根据订单信息查询个人卡订单
	 */
	@Override
	public TMemberCardOrderRef findeCardOrderInfo(Integer orderId) {
		return tMemberCardOrderRefMapper.selectByPrimaryKey(orderId);
	}
	/**
	 * @param orderId
	 * @param orderType
	 * @return根据订单ID删除订单信息
	 */
	@Override
	public Integer deleteOrderById(Integer orderId, Integer orderType) {
		Integer result = 0;
		switch (orderType) {
		case 1://活动
			result = tActivityOrderMapper.deleteByPrimaryKey(orderId);
			break;
		case 2://商品
			result = tGoodsOrderMapper.deleteByPrimaryKey(orderId);
			break;
		case 3://私课
			result = tOrderMapper.deleteByPrimaryKey(orderId);
			break;
		case 4://场馆
			result = tStudioConsumeOrderRecordMapper.deleteByPrimaryKey(orderId);
			break;
		case 5://个人卡
			result = tMemberCardOrderRefMapper.deleteByPrimaryKey(orderId);
			break;
		}
		return result;
	}
	/**
	 * @param coachid
	 * @param classdate
	 * @return查询教练pai期ID
	 */
	@Override
	public Integer findCoachPrivateTime(Integer coachid, String classdate) {
		TPrivateLessonTimeExample t = new TPrivateLessonTimeExample();
		t.createCriteria().andCoachidEqualTo(coachid).andLessondateEqualTo(classdate.replaceAll("-", ""));
		List<TPrivateLessonTime> selectByExample = tPrivateLessonTimeMapper.selectByExample(t);
		if(selectByExample.size() == 0){
			return 0;
		}else{
			return  selectByExample.get(0).getRowid();
		}
	}
	/**
	 * @param orderId
	 * @param orderType
	 * @return根据订单ID更新订单状态为退订
	 */
	@Override
	public Integer updateOrderStatusById(Integer orderId, Integer orderType) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String mobilephonenum = "";
		String comm = "";
		String ordernum = "";
		Integer result = 0;
		long nowLong = new Date().getTime();
		long startLong = 0;
		switch (orderType) {
		case 1://活动
			TActivityOrder tActivityOrder = tActivityOrderMapper.selectByPrimaryKey(orderId);
			tActivityOrder.setPaystatus("3");
			TActivity activity = tActivityMapper.selectByPrimaryKey(tActivityOrder.getActivityid());
			Long activiteMil = formateHoursInfo(activity.getActivitylimit());
			try {
				startLong = simpleDateFormat.parse(activity.getActivestarttime()).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if( activity.getActivitylimit() != 0){
				if((startLong - nowLong) < activiteMil || "5".equals(tActivityOrder.getPaystatus())){
					return -1;
				}
			}
			result = tActivityOrderMapper.updateByPrimaryKeySelective(tActivityOrder);
			ordernum = tActivityOrder.getOrdernum();
			mobilephonenum = tActivityOrder.getMobilephonenum();
			comm = tActivityOrder.getComm();
			break;
		case 2://商品
			TGoodsOrder tGoodsOrder   = tGoodsOrderMapper.selectByPrimaryKey(orderId);
			tGoodsOrder.setPaystatus(3);
			if(tGoodsOrder.getPaystatus() == 5){
				return -1;
			}
			result = tGoodsOrderMapper.updateByPrimaryKeySelective(tGoodsOrder);
			ordernum = tGoodsOrder.getOrdernum();
			mobilephonenum = tGoodsOrder.getMobilephonenum();
			comm = tGoodsOrder.getComm();
			break;
		case 3://私课
			TOrder tOrder   = tOrderMapper.selectByPrimaryKey(orderId);
			tOrder.setPaystatus(3);
			TCoach coach = tCoachMapper.selectByPrimaryKey(tOrder.getCoachid());
			Long coachMil = formateHoursInfo(coach.getCanclelimit());
			try {
				startLong = simpleDateFormat.parse(tOrder.getClassdate() + " " + tOrder.getTimespan().split("-")[0]).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(coach.getCanclelimit() != 0){
				if((startLong - nowLong) < coachMil || tOrder.getPaystatus() == 5){
					return -1;
				}
			}
			result = tOrderMapper.updateByPrimaryKeySelective(tOrder);
			ordernum = tOrder.getOrdernum();
			mobilephonenum = tOrder.getMobilephonenum();
			comm = tOrder.getComm();
			break;
		case 4://场馆
			TStudioConsumeOrderRecord tStudioConsumeOrderRecord = tStudioConsumeOrderRecordMapper.selectByPrimaryKey(orderId);
			tStudioConsumeOrderRecord.setPaystatus(3);
			if(tStudioConsumeOrderRecord.getPaystatus() == 5){
				return -1;
			}
			result = tStudioConsumeOrderRecordMapper.updateByPrimaryKeySelective(tStudioConsumeOrderRecord);
			ordernum = tStudioConsumeOrderRecord.getOrdernum();
			mobilephonenum = tStudioConsumeOrderRecord.getMobilephonenum();
			comm = tStudioConsumeOrderRecord.getComm();
			break;
		case 5://个人卡
			TMemberCardOrderRef tMemberCardOrderRef = tMemberCardOrderRefMapper.selectByPrimaryKey(orderId);
			tMemberCardOrderRef.setPaystatus("3");
			result = tMemberCardOrderRefMapper.updateByPrimaryKeySelective(tMemberCardOrderRef);
			ordernum = tMemberCardOrderRef.getOrdernum();
			mobilephonenum = tMemberCardOrderRef.getMobilephonenum();
			comm = tMemberCardOrderRef.getComm();
			break;
		}
		if(result != 0){
			Logger logger = Logger.getLogger(PayOrderServiceImp.class);
			String data = SendMessage.sendAppointmentMessage(mobilephonenum,"您的订单【"+ ordernum +"】【"+ comm +"】退订申请已受理，如有问题，请致电客服："+ConstantVo.YDJ_TELEPHONE);
			//验证是否发送成功
	    	String aa = data;
			String[] am = aa.split(",");
			String a0 = am[0];
			//是否发送短信
			if (!"03".equals(a0)) {
				logger.error("订单号【" + ordernum + "】在取消商品订单时，短信因服务商问题未发送至用户！");
			}
		}
		return result;
	}
	
	private Long formateHoursInfo(Integer num){
		switch (num) {
			case 1:
				return 6 * 3600000L; 
			case 2:
				return 24 * 3600000L;			
			case 3:
				return 36 * 3600000L;
			case 4:
				return 48 * 3600000L;
			case 5:	
				return 72 * 3600000L;
		}
		return 12 * 3600000L;
	}
}
