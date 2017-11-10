package com.yundongjia.app.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppPayService;
import com.yundongjia.oa.admin.mapper.TActivityMapper;
import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TCardTypeMapper;
import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TCoachUserMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberCouponRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TMemberShowtimeMapper;
import com.yundongjia.oa.admin.mapper.TMsgMapper;
import com.yundongjia.oa.admin.mapper.TOrderDiscountMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TRedpackageMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachUser;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TMemberShowtime;
import com.yundongjia.oa.admin.po.TMsg;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderDiscount;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TRedpackage;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.IdentifyCodeUtil;
import com.yundongjia.oa.utils.SendMessage;

@Service
public class AppPayServiceImpl implements AppPayService{
	@Autowired
	private TCardTypeMapper tCardTypeMapper;
	@Autowired
	private TRedpackageMapper tRedpackageMapper;
	@Autowired
	private TActivityOrderMapper tActivityOrderMapper;
	@Autowired
	private TActivityMapper tActivityrMapper;
	@Autowired
	private TStudioMapper tStudioMapper;
	@Autowired
	private TCoachMapper tCoachMapper;
	@Autowired
	private TGoodsOrderMapper tGoodsOrderMapper;
	@Autowired
	private TOrderMapper tOrderMapper;
	@Autowired
	private TCoachUserMapper tCoachUserMapper;
	@Autowired
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	@Autowired
	private TOrderDiscountMapper tOrderDiscountMapper;
	@Autowired
	private TMsgMapper tMsgMapper;
	@Autowired
	private TMemberCouponRefMapper tMemberCouponRefMapper;
	 @Autowired
	 private TMemberMapper tMemberMapper;
	 @Autowired
	 private TMemberShowtimeMapper tMemberShowtimeMapper;
	 @Autowired
	 private TMemberCardOrderRefMapper tMemberCardOrderRefMapper;
	/**
	 * @param orderMapParam
	 * 支付成功后更新数据库状态，并在数据库订单折扣表中插入折扣信息记录
	 * 
	 */
	@Override
	public void paySuccess(Map<String, Object> orderMapParam){
		System.out.println("++++++++++++++++++++++++++++++++++++++++"+orderMapParam.toString());
		Logger logger = Logger.getLogger(AliPayPaymentServiceImpl.class);
		Integer selfCardId = (Integer) orderMapParam.get("selfCardId");
		String phonenum = (String) orderMapParam.get("phonenum");
    	String payType = (String) orderMapParam.get("payType");
    	Double realPrice = 0d;
    	if(orderMapParam.get("realPrice") != null){
    		realPrice = Double.parseDouble(orderMapParam.get("realPrice").toString());
    	}
    	String orderNum = (String) orderMapParam.get("orderNum");
    	Integer orderType = (Integer)orderMapParam.get("orderType");
    	Integer proOrderId = (Integer)orderMapParam.get("proOrderId");
    	Integer memberId= (Integer)orderMapParam.get("memberId");
    	Integer rowId = (Integer)orderMapParam.get("rowId");
    	Double isUsableRedPackage =  0d;
    	Double couponDiscountAmount =  0d;
    	if(orderMapParam.get("isUsableRedPackage") != null){
    		isUsableRedPackage = Double.parseDouble(orderMapParam.get("isUsableRedPackage").toString());
    	}
    	if(orderMapParam.get("couponDiscountAmount") != null){
    		couponDiscountAmount = Double.parseDouble(orderMapParam.get("couponDiscountAmount").toString());
    	}
    	/*-------------------------------------发送验证码---------------------------------------------------*/
    	System.out.println("/*-------------------------------------发送验证码---------------------------------------------------*/");
    	String authCode = IdentifyCodeUtil.createIndentifyCode(true, 6);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TMsg baseMsg = new TMsg();
		baseMsg.setIp(null);
		baseMsg.setFromid(0);
		baseMsg.setStatus("1");
    	baseMsg.setCodetype(0);
    	baseMsg.setCreatedate(dateFormat.format(new Date()).toString());
    	baseMsg.setMobilephoneno(phonenum);
    	baseMsg.setVerifycode(authCode);
    	int result  = tMsgMapper.insertSelective(baseMsg);
		
		/*-------------------------------------发送验证码---------------------------------------------------*/
		//订单优惠下的订单ID类型
		Integer status = -1;
		Integer isSendMessage = 1;
		String data = "";
		String aa ="";
		String[] am = {};
		String a0 = "";
    	switch (orderType) {
    	//1活动订单 2商品订单 3私课订单 4场馆订单 5 个人卡订单
		case 1:
			status = 4;
			TActivityOrder activeOrder = tActivityOrderMapper.selectByPrimaryKey(proOrderId);
			TActivity active = tActivityrMapper.selectByPrimaryKey(activeOrder.getActivityid());
			TStudio studio = tStudioMapper.selectByPrimaryKey(active.getStudioid());
			String[] classStartDate = active.getActivestarttime().split(" ");
			String[] classEndDate = active.getActiveendtime().split(" ");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			if(activeOrder.getMessagestatus().equals("0")){
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				data = SendMessage.sendAppointmentMessage(phonenum, "【"+ active.getActivename() +"】预约成功！请【"+ classStartDate[0] +"】【"+classStartDate[1]+"-"+ classEndDate[1] +"】准时至【"+ studio.getStudioname() +"】上课，如有问题，请致电客服："+ConstantVo.YDJ_TELEPHONE);
		    	//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + orderNum + "】在报名活动时成功付款，短信因服务商问题未发送至用户！");
					 isSendMessage=0;
				}else if(result == 0){
					logger.error("订单号【" + orderNum + "】在报名活动时成功付款，短信后台保存验证码时出现异常，并未发送至用户！");
					isSendMessage=0;
				}
			}
			TActivityOrder tActivityOrder = new TActivityOrder();
			if(realPrice == null){
				tActivityOrder.setTotalmoney(-1d);
			}
			tActivityOrder.setOrderid(proOrderId);
			tActivityOrder.setOrdernum(orderNum);
			tActivityOrder.setPaytype(payType);
			tActivityOrder.setPaystatus("2");
			tActivityOrder.setMessagestatus(isSendMessage.toString());
			int resultActive = tActivityOrderMapper.updateByPrimaryKeySelective(tActivityOrder);
			if(resultActive == 0){
				logger.error("【" + phonenum + "】在报名活动（t_activity_order表）时成功付款，因后台异常更改订单状态失败！ 订单号为【"+ orderNum +"】");
			}
			break;
		case 2:
			status = 0;
			TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
			tGoodsOrderExample.createCriteria().andOrdernumEqualTo(orderNum);
			TGoodsOrder tGoodsOrder = new TGoodsOrder();
			if(realPrice == null){
				tGoodsOrder.setTotalmoney(-1d);
			}
			tGoodsOrder.setOrdernum(orderNum);
			tGoodsOrder.setOrderid(proOrderId);
			tGoodsOrder.setPaytype(payType);
			tGoodsOrder.setPaystatus(2);
			tGoodsOrder.setMessagestatus(isSendMessage);
			int resultGoods = tGoodsOrderMapper.updateByPrimaryKeySelective(tGoodsOrder);
			if(resultGoods == 0){
				logger.error("【" + phonenum + "】在购买商品时（t_goods_order表）成功付款，因后台异常更改订单状态失败！ 订单号为【"+ orderNum +"】");
			}
			break;
		case 3:
			status = 2;
			TOrder torder = tOrderMapper.selectByPrimaryKey(proOrderId);
			TCoach coach = tCoachMapper.selectByPrimaryKey(torder.getCoachid());
			TCoachUser coachUser = tCoachUserMapper.selectByPrimaryKey(coach.getUserid());
			studio = tStudioMapper.selectByPrimaryKey(torder.getStudioid());
			if(torder.getMessagestatus().equals("0")){
				data = SendMessage.sendAppointmentMessage(phonenum, "【"+coach.getNickname()+"】预约成功！请【"+torder.getClassdate()+"】【"+torder.getTimespan()+"】准时至【"+ studio.getStudioname() +"】上课，如有问题，请致电客服："+ConstantVo.YDJ_TELEPHONE);
				//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + orderNum + "】在预约团课时成功付款，短信因服务商问题未发送至用户！");
					 isSendMessage=0;
				}else if(result == 0){
					logger.error("订单号【" + orderNum + "】在预约团课时成功付款，短信后台保存验证码时出现异常，并未发送至用户！");
					isSendMessage=0;
				}
			
				data = SendMessage.sendAppointmentMessage(coachUser.getMobilephoneno(), "用户【"+phonenum.substring(phonenum.length() - 4, phonenum.length())+"】预约成功！请【"+torder.getClassdate()+"】【"+torder.getTimespan()+"】准时至【"+ studio.getStudioname() +"】上课，如有问题，请致电客服："+ConstantVo.YDJ_TELEPHONE);
				//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + orderNum + "】在预约团课时成功付款，短信因服务商问题未发送至教练！");
					 isSendMessage=0;
				}else if(result == 0){
					logger.error("订单号【" + orderNum + "】在预约团课时成功付款，短信后台保存验证码时出现异常，并未发送至教练！");
					isSendMessage=0;
				}
			}
			TOrder tOrder = new TOrder();
			if(realPrice == null){
				tOrder.setTotalmoney(-1d);
			}
			tOrder.setOrderid(proOrderId);
			tOrder.setOrdernum(orderNum);
			tOrder.setPaytype(payType);
			tOrder.setPaystatus(2);
			tOrder.setMessagestatus(isSendMessage);
			int resultOrder = tOrderMapper.updateByPrimaryKeySelective(tOrder);
			if(resultOrder == 0){
				logger.error("【" + phonenum + "】在报名私课时（t_order表）成功付款，因后台异常更改订单状态失败！ 订单号为【"+ orderNum +"】");
			}
			break;
		case 4:
			status = 1;
			TStudioConsumeOrderRecord studioOrder = tStudioConsumeOrderRecordMapper.selectByPrimaryKey(proOrderId);
			studio = tStudioMapper.selectByPrimaryKey(studioOrder.getStudioid());
			data = SendMessage.sendAppointmentMessage(phonenum,"【"+ studio.getStudioname() +"】下单成功！请至前台报您手机后四位入场运动。");
			//验证是否发送成功
	    	aa = data;
			am = aa.split(",");
			a0 = am[0];
			//是否发送短信
			if (!"03".equals(a0)) {
				logger.error("订单号【" + orderNum + "】在扫码支付场馆订单时成功付款，短信因服务商问题未发送至用户！");
				 isSendMessage=0;
			}else if(result == 0){
				logger.error("订单号【" + orderNum + "】在扫码支付场馆订单时成功付款，短信后台保存验证码时出现异常，并未发送至用户！");
				isSendMessage=0;
			}
			if(studioOrder.getMessagestatus().equals("0")){
				data = SendMessage.sendAppointmentMessage(studio.getSupertel(),"用户【"+ phonenum.substring(phonenum.length() - 4, phonenum.length()) +"】下单成功！请核对并接待，谢谢！");
				//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + orderNum + "】在扫码支付场馆订单时成功付款，短信因服务商问题未发送至场馆负责人！");
					 isSendMessage=0;
				}else if(result == 0){
					logger.error("订单号【" + orderNum + "】在扫码支付场馆订单时成功付款，短信后台保存验证码时出现异常，并未发送至场馆负责人！");
					isSendMessage=0;
				}
			}
			TStudioConsumeOrderRecord tStudioConsumeOrderRecord = new TStudioConsumeOrderRecord();
			if(realPrice == null){
				tStudioConsumeOrderRecord.setTotalmoney(-1d);
			}
			tStudioConsumeOrderRecord.setOrderid(proOrderId);
			tStudioConsumeOrderRecord.setOrdernum(orderNum);
			tStudioConsumeOrderRecord.setPaytype(payType);
			tStudioConsumeOrderRecord.setPaystatus(2);
			tStudioConsumeOrderRecord.setMessagestatus(isSendMessage);
			int resultStudio = tStudioConsumeOrderRecordMapper.updateByPrimaryKeySelective(tStudioConsumeOrderRecord);
			if(resultStudio == 0){
				logger.error("【" + phonenum + "】在进入场馆付费时（t_studio_consume_order_record表）成功付款，因后台异常更改订单状态失败！ 订单号为【"+ orderNum +"】");
			}
			 String showstarttime = dateFormat.format(new Date());
			 TMemberShowtime showtime = new TMemberShowtime();
			  showtime.setShowstarttime(showstarttime);
			  showtime.setShowendtime(showstarttime); 
			  showtime.setMemberid(memberId);
			  showtime.setStudioid(studio.getStudioid());
			  showtime.setTimespan("00:00:00");
			  showtime.setIsshowover("1");
			  this.tMemberShowtimeMapper.insertSelective(showtime);
			
			
			
			
			
			
			
			break;
		case 5:
			status = 5;
			TMemberCardOrderRef memberCardOrder = tMemberCardOrderRefMapper.selectByPrimaryKey(proOrderId);
			TCardType cardType = tCardTypeMapper.selectByPrimaryKey(memberCardOrder.getCardtypeid());
			if(memberCardOrder.getMessagestatus().equals("0")){
				data = SendMessage.sendAppointmentMessage(phonenum,"已成功购买【"+ cardType.getCardtypename() +"】【1】张，可在预约【场馆、教练、团课、商城】享受【"+ cardType.getCarddiscount() +"】折优惠，感谢您加入运动+智慧运动大家庭。");
				//验证是否发送成功
		    	aa = data;
				am = aa.split(",");
				a0 = am[0];
				//是否发送短信
				if (!"03".equals(a0)) {
					logger.error("订单号【" + orderNum + "】在购买个人卡订单时成功付款，短信因服务商问题未发送至场馆负责人！");
					 isSendMessage=0;
				}else if(result == 0){
					logger.error("订单号【" + orderNum + "】在购买个人卡订单时成功付款，短信后台保存验证码时出现异常，并未发送至场馆负责人！");
					isSendMessage=0;
				}
			}
			TMemberCardOrderRef tmCardOrderRef = new TMemberCardOrderRef();
			tmCardOrderRef.setOrderid(proOrderId);
			tmCardOrderRef.setOrdernum(orderNum);
			tmCardOrderRef.setPaytype(payType);
			tmCardOrderRef.setPaystatus("2");
			tmCardOrderRef.setRealmoney(realPrice);
			tmCardOrderRef.setMessagestatus(isSendMessage.toString());
			tmCardOrderRef.setStatus(0);
			int resultMember = tMemberCardOrderRefMapper.updateByPrimaryKeySelective(tmCardOrderRef);
			if(resultMember == 0){
				logger.error("【" + phonenum + "】在进入购买个人卡付费时（t_member_card_order_ref表）成功付款，因后台异常更改订单状态失败！ 订单号为【"+ orderNum +"】");
			}else{
				Double cashback = 0d;
				if(cardType.getIscashback() == 1){
					cashback = Double.parseDouble(cardType.getAmount());
				}
				TMember member = tMemberMapper.selectByPrimaryKey(memberId);
				member.setRedamount(member.getRedamount() + cashback);
				tMemberMapper.updateByPrimaryKeySelective(member);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String now = simpleDateFormat.format(new Date());
				TRedpackage tRedpackage = new TRedpackage();
				tRedpackage.setCreatedate(now);
				tRedpackage.setType(4);
				tRedpackage.setAmount(cashback);
				tRedpackage.setMemberid(memberId);
				tRedpackage.setExpiredate(now.split("-")[0] + "-01-01 00:00:00");
				int redResult = tRedpackageMapper.insertSelective(tRedpackage);
				if(redResult == 0){
					logger.error("订单号【"+ orderNum +"】，返现红包保存到【t_redpackage表】失败！");
				}
				if(memberCardOrder.getMessagestatus().equals("0") && memberCardOrder.getCashback() != 0){
					data = SendMessage.sendAppointmentMessage(phonenum,"您购买个人卡返现红包【"+ cashback +"】元已到帐，有效期至【"+ now.split("-")[0] + "-01-01 00:00:00" +"】，可在APP我的-红包查看。");
					//验证是否发送成功
			    	aa = data;
					am = aa.split(",");
					a0 = am[0];
					//是否发送短信
					if (!"03".equals(a0)) {
						logger.error("订单号【" + orderNum + "】在购买个人卡返现至红包成功，短信因服务商问题未发送至场馆负责人！");
						 isSendMessage=0;
					}else if(result == 0){
						logger.error("订单号【" + orderNum + "】在购买个人卡返现至红包成功，短信后台保存验证码时出现异常，并未发送至场馆负责人！");
						isSendMessage=0;
					}
				}
			}
			break;
		}
    	TOrderDiscount tOrderDiscount = new TOrderDiscount();
		tOrderDiscount.setOrderid(proOrderId);
		tOrderDiscount.setPayditch(0d);
    	tOrderDiscount.setStatus(status);
    	if(payType.equals("03")){
    		Integer enterpriseCardId = (Integer)orderMapParam.get("enterpriseCardId");
	    	Integer enterpriseSubNum = (Integer)orderMapParam.get("enterpriseSubNum");
	    	tOrderDiscount.setEnterprisecardid(enterpriseCardId);
	    	tOrderDiscount.setEnterprisecardsubnum(enterpriseSubNum);
    	}else{
    		tOrderDiscount.setEnterprisecardid(-1);
	    	tOrderDiscount.setEnterprisecardsubnum(-1);
    	}
    	if(realPrice == null){
    		tOrderDiscount.setOrderrealmoney(-1d);
    	}else{
    		tOrderDiscount.setOrderrealmoney(realPrice);
    	}
    	//是否使用个人卡优惠
		 if( selfCardId == null || selfCardId == 0 ){
			 tOrderDiscount.setCardid(0);
			 tOrderDiscount.setSelfcard(0d);
		 }else{
			 Double usableSelfCardAmount =Double.parseDouble( orderMapParam.get("usableSelfCardAmount").toString());
			 tOrderDiscount.setCardid(selfCardId);
			 tOrderDiscount.setSelfcard(usableSelfCardAmount);
		 }
		 //是否使用优惠券
		 if( rowId == null || rowId == 0){
			 tOrderDiscount.setCouponid(0);
			 tOrderDiscount.setCoupon(0d);
		 }else{
			 TMemberCouponRef coupon = tMemberCouponRefMapper.selectByPrimaryKey(rowId);
			 tOrderDiscount.setCouponid(rowId);
			 tOrderDiscount.setCoupon(couponDiscountAmount);
			 //更新优惠券状态
			 coupon.setStatus("2");
			 coupon.setRealmoney(couponDiscountAmount);
			 coupon.setOrderid(proOrderId);
			 tMemberCouponRefMapper.updateByPrimaryKeySelective(coupon);
		 }
		
		 if(isUsableRedPackage == null || isUsableRedPackage == 0){
			 tOrderDiscount.setRedpackage(0d);
		 }else{
			 //是否使用红包
			 tOrderDiscount.setRedpackage(isUsableRedPackage);
			 TMember member = tMemberMapper.selectByPrimaryKey(memberId);
			 member.setRedamount(member.getRedamount() - isUsableRedPackage);
			 tMemberMapper.updateByPrimaryKeySelective(member);
		 }
		 int  discount = tOrderDiscountMapper.insertSelective(tOrderDiscount);
		 if(discount == 0 ){
			 logger.error("【" + phonenum + "】成功付款，因后台异常插入订单折扣信息时失败！ 订单号为【"+ orderNum +"】 --------------------------折扣信息为 ："+ tOrderDiscount.toString());
		 }
	}

	/**
	 * @param orderType 订单类型  1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
	 * @param orderNum 订单编号 
	 * @param payType支付类型
	 * @return 查询订单的支付状态
	 */
	@Override
	public Integer checkedPayStatus(Integer orderType, String orderNum) {
		//1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
		switch (orderType) {
		case 1:
				TActivityOrderExample ta = new TActivityOrderExample();
				ta.createCriteria().andOrdernumEqualTo(orderNum);
				List<TActivityOrder> active = tActivityOrderMapper.selectByExample(ta);
				if(active.size() == 1){
					return 1;
				}else{
					return 0;
				}
		case 2:
			TGoodsOrderExample  tg = new TGoodsOrderExample();
			tg.createCriteria().andOrdernumEqualTo(orderNum);
			List<TGoodsOrder> goods = tGoodsOrderMapper.selectByExample(tg);
			if(goods.size() == 1){
				return 1;
			}else{
				return 0;
			}
		case 3:
			TOrderExample  to = new TOrderExample();
			to.createCriteria().andOrdernumEqualTo(orderNum);
			List<TOrder> order = tOrderMapper.selectByExample(to);
			if(order.size() == 1){
				return 1;
			}else{
				return 0;
			}
		case 4:
			TStudioConsumeOrderRecordExample  ts = new TStudioConsumeOrderRecordExample();
			ts.createCriteria().andOrdernumEqualTo(orderNum);
			List<TStudioConsumeOrderRecord> studio = tStudioConsumeOrderRecordMapper.selectByExample(ts);
			if(studio.size() == 1){
				return 1;
			}else{
				return 0;
			}
		case 5:
			TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
			tMemberCardOrderRefExample.createCriteria().andOrdernumEqualTo(orderNum);
			List<TMemberCardOrderRef> memberCardOrder = tMemberCardOrderRefMapper.selectByExample(tMemberCardOrderRefExample);
			if(memberCardOrder.size() == 1){
				return 1;
			}else{
				return 0;
			}
		}
			
		return 0;
	}

	@Override
	public TMember findeMemberById(Integer memberId) {
		return  tMemberMapper.selectByPrimaryKey(memberId);
	}
	
}
