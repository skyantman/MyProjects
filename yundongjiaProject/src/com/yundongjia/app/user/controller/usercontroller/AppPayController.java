package com.yundongjia.app.user.controller.usercontroller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;
import com.yundongjia.app.user.service.AppPayService;
import com.yundongjia.app.user.service.AppStudioConsumeOrderRecordService;
import com.yundongjia.app.user.service.PayOrderService;
import com.yundongjia.app.user.service.impl.AliPayPaymentServiceImpl;
import com.yundongjia.app.user.service.impl.WeChatPayServiceImpl;
import com.yundongjia.app.wechatPay.Utils.JdomParseXmlUtils;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.mapper.TWeixinNotifiyResultMapper;
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
import com.yundongjia.oa.admin.po.TWeixinNotifiyResult;
import com.yundongjia.oa.admin.vo.ConstantVo;

@Controller
public class AppPayController extends BaseController{
	 @Autowired
	 private AppPayService appPayService;
	 @Autowired 
	 private TWeixinNotifiyResultMapper tWeixinNotifiyResultMapper;
	 @Autowired
	private AppStudioConsumeOrderRecordService appStudioConsumeOrderRecordService;
	 @Autowired
	private PayOrderService payOrderService; 
	@Autowired
	private AliPayPaymentServiceImpl aliPayPaymentServiceImpl;
	@Autowired
	private WeChatPayServiceImpl weChatPayServiceImpl;
	Map<String, Object> orderMapParam = new HashMap<String, Object>();
	/**
	 * 阿里支付成功后本地再次验证是否支付成功
	 */
	@RequestMapping(value="/ydj/aliPay/alipaynotify.html")
	public void alipaynotify(){
			Logger logger = Logger.getLogger(AliPayPaymentServiceImpl.class);
			Map<String, String> params = new HashMap<String, String>();
			System.out.println("**************************************************"+orderMapParam.toString());
			String phonenum = (String) orderMapParam.get("phonenum");
		    String orderNum = (String) orderMapParam.get("orderNum");
	        Map requestParams = request.getParameterMap();
	        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
	            String name = (String) iter.next();
	            String[] values = (String[]) requestParams.get(name);
	            String valueStr = "";
	            for (int i = 0; i < values.length; i++) {
	                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
	            }
	            System.out.println(">>>>>参数" + name + ":" + valueStr);
	            params.put(name, valueStr);
	        }
	        requestParams.get("trade_status");
	        String tradeNo = request.getParameter("out_trade_no");
	        String tradeStatus = request.getParameter("trade_status");
	        System.out.println("=================支付宝返回的状态码====================="+tradeStatus);
//	        if (AlipayNotify.verify(params)) {//验证成功
	            if (tradeStatus.equals("TRADE_FINISHED") || tradeStatus.equals("TRADE_SUCCESS")) {
	                System.out.println(">>>>>状态要更新了");
	                //-----------------充值成功-------业务逻辑代码-------------------------------------
	                appPayService.paySuccess(orderMapParam);
	                }else{
	                	logger.error("【" +phonenum + "】用支付宝付款失败！ 订单号为【"+ orderNum +"】");
	                }
	                //-----------------充值成功-------业务逻辑代码-------------------------------------
	            } 
	           
//	    }
	
	
	  /**
     * 
    * @Title: weixinotify 
    * @Description: TODO(微信支付完成后，会调用notifyurl告诉服务器支付成功与否) 
    * @param @throws IOException
    * @param @throws JDOMException    设定文件 
    * @return void    返回类型 
    * @throws
     */
	@RequestMapping(value="/ydj/wechatPay/wechatpaynotify.html")
	public void weixinotify() throws IOException, JDOMException{
    	System.out.println("~~~~~~~~开始~~~~~~~");
    	Logger logger = Logger.getLogger(AliPayPaymentServiceImpl.class);
		String phonenum = (String) orderMapParam.get("phonenum");
	    String orderNum = (String) orderMapParam.get("orderNum");
	    InputStream inStream = request.getInputStream();
	    ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
	    Map<String, Object> amap = new HashMap<String, Object>();
	    TWeixinNotifiyResult tWeixinNotifiyResult = new TWeixinNotifiyResult();
    	 String outtradeNo = "";
    	 int wxId = 0;
    	 Map<Object, Object> map = null;
    	 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:MM:SS");
		 String createDate = formatter.format(currentTime);
    	 
		 try {
			 //业务逻辑代码---------------------------------------------------
 	        //-----------------------------------------------------------------------------------
    	    byte[] buffer = new byte[1024];
    	    int len = 0;
    	    while ((len = inStream.read(buffer)) != -1) {
    	        outSteam.write(buffer, 0, len);
    	    }
    	    outSteam.close();
    	    inStream.close();
    	    String result  = new String(outSteam.toByteArray(),"utf-8");//获取微信调用我们notify_url的返回信息
    	    map = JdomParseXmlUtils.doXMLParse(result);
    	    for(Object keyValue : map.keySet()){
    	        System.out.println(keyValue+"="+map.get(keyValue));
    	        if("out_trade_no".equals(keyValue)){
    	        	outtradeNo = (String) map.get(keyValue);
    	        }
    	    }
    	    tWeixinNotifiyResult.setStatus(1);
    	    tWeixinNotifiyResult.setOuttradeno(orderNum);
    	    tWeixinNotifiyResultMapper.insertSelective(tWeixinNotifiyResult);
    	    appPayService.paySuccess(orderMapParam);
    	    System.out.println("=====================！付款成功！========================");
    	    
			}catch (Exception e) {
				System.out.println("===================微信调用通知接口出异常了===========================");
				amap.clear();
				tWeixinNotifiyResult.setStatus(2);
				tWeixinNotifiyResult.setOuttradeno(orderNum);
				tWeixinNotifiyResultMapper.insertSelective(tWeixinNotifiyResult);
				logger.error("【" +phonenum + "】用微信在报名活动时付款失败！ 订单号为【"+ orderNum +"】");
	   			e.printStackTrace();
	   		}finally {
				if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
	    	        //TODO 对数据库的操作
	    	        response.getWriter().write("success");   //告诉微信服务器，我收到信息了，不要在调用回调action了
	    	        System.out.println("-------------success");
	    	    }
				
				
			}
    }
	 @RequestMapping(value="ydj/user/pay")
	 public void pay(String str,WebRequest request) throws Exception{
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type =Integer.parseInt(map.get("type").toString());
		switch (type) {
		case 0: //确认支付调取支付接口
			affirmPay(map);
			break;
		case 1: //检查是否支付成功
			checkedPay(map);
			break;
		case 2: //将订单详情信息并插入数据库
			payOrderDetail(map);
			break;
		case 3: //取消订单
			cancelOrder(map);
			break;
		case 4: //优惠券列表
			couponList(map);
			break;
		case 5: //订单再次支付
			againPay(map);
			break;
		case 6: //订单退订
			refund(map);
			break;
		}
	 }
	
		


			/**
		     * 共用参数
		     * @param payType :支付类型  00支付宝 01微信 02平安银行卡  03企业卡 04余额
		     * @param orderType 订单类型  1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
		     * @param proOrderId   orderType为1是代表 活动订单ID  为2时代表 商品订单Id  为3时代表 私课订单ID  为4时代表 场馆订单ID
		     * @param orderNum：订单号
		     *  @param description：订单描述
		     *  @param selfCardId : 个人卡ID
		     *   @param phonenum : 用户手机号
		     *  @param memberId : 用户ID
		     *  
		     *  除企业卡支付外的参数
		     *  @param rowId：使用的优惠券ID(0为不使用 大于0优惠券ID)
		     *  @param couponDiscountAmount：使用的优惠券优惠金额(无优惠券传0)
		     * @param isUsableRedPackage:是否使用红包(0不使用 大于0为红包金额)
		     * @param usableSelfCardAmount:个人卡优惠金额（无个人卡传0）
		     * @param realPrice:订单实付金额
		     * @param bankPayDiscount:银行卡优惠金额（0无银行卡优惠 大于0为银行卡优惠金额）
		     * 
		     * 企业卡支付参数
		     * @param enterpriseCardId:企业卡ID（null为无企业卡）
		     * @param enterpriseSubNum : 企业卡支付扣除次数
		     * @return支付订单
		     */
	 private void affirmPay(Map<String, Object> param) {
		    	String payType = (String) param.get("payType");
		    	String orderNum = (String) param.get("orderNum");
		    	String description = (String) param.get("description");
		    	Double realPrice = -1d;
		    	if(!"03".equals(payType )){
		    		realPrice = Double.parseDouble(param.get("realPrice").toString());
		    	}
		    	//将更改订单信息数据放入session
		    	orderMapParam = param;
		    	Map<String , Object> aLiparam = new HashMap<String , Object>();
		    	String resultStr = null;
		    	Integer memberId= (Integer)orderMapParam.get("memberId");
		    	TMember tMember = appPayService.findeMemberById(memberId);
		    	Double isUsableRedPackage = 0d;
		    	if(orderMapParam.get("isUsableRedPackage") != null){
		    		isUsableRedPackage = Double.parseDouble(orderMapParam.get("isUsableRedPackage").toString());
		    	}
		    	switch (payType) {
					case "00"://支付宝
							aLiparam.put("description", description);
							aLiparam.put("realPrice", realPrice);
							aLiparam.put("orderNum", orderNum);
							aLiparam.put("payType", param.get("payType"));
							aLiparam.put("request", request);
							aLiparam.put("response", response);
							try {
								if(tMember.getRedamount() -isUsableRedPackage < 0 ){
									aLiparam.put("status", "1");
									aLiparam.put("message", "红包金额不足");
									aLiparam.put("orderNum", param.get("orderNum"));
									aLiparam.put("payType", param.get("payType"));
									aLiparam.put("parameterMap", "");
						    	}else{
						    		resultStr = aliPayPaymentServiceImpl.aliPay(aLiparam);
						    	}
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
								aLiparam.put("status", "1");//预支付订单状态 00支付宝 1失败 001支付宝调取支付信息失败
								aLiparam.put("payType", param.get("payType"));
								aLiparam.put("message", "支付宝调取预支付信息失败！");
								resultStr = new Gson().toJson(aLiparam);
							}
							aLiparam.clear();
							break;
					case "01"://微信
						aLiparam.put("description", description);
						aLiparam.put("realPrice", realPrice);
						aLiparam.put("orderNum", orderNum);
						aLiparam.put("payType", param.get("payType"));
						aLiparam.put("request", request);
						try {
							if(tMember.getRedamount() -isUsableRedPackage < 0 ){
								aLiparam.clear();	
								aLiparam.put("status", "1");
								aLiparam.put("payType", param.get("payType"));
								aLiparam.put("message", "红包金额不足");
								resultStr = new Gson().toJson(aLiparam);
							}else{
								resultStr = weChatPayServiceImpl.weixinPrePay(aLiparam);
							}
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
							aLiparam.clear();	
							aLiparam.put("status", "1");//预支付订单状态 011微信调取支付信息失败
							aLiparam.put("payType", param.get("payType"));
							aLiparam.put("message", "微信调取预支付信息失败！");
							resultStr = new Gson().toJson(aLiparam);
						}
						aLiparam.clear();
						break;
					case "02"://平安信用卡
						break;
					case "03"://企业卡
						Integer enterpriseCardId = (Integer)param.get("enterpriseCardId");
				    	Integer enterpriseSubNum = (Integer)param.get("enterpriseSubNum");
				    	Integer result = payOrderService.updateEnterpriseCardSportNum(enterpriseCardId , enterpriseSubNum);
				    	Map<String , Object> map = new HashMap<String , Object>();
				    	if(result  == 1){
				    		if(tMember.getRedamount() -isUsableRedPackage < 0 ){
				    			map.put("status", "1");
								map.put("orderNum", orderNum);
								map.put("payType", param.get("payType"));
								map.put("message", "红包金额不足");
				    		}else{
				    			appPayService.paySuccess(param);
				    		}
							map.put("status", "0");
							map.put("orderNum", orderNum);
							map.put("payType", param.get("payType"));
							map.put("message", "成功");
						}else if(result  == 2){ 
							map.put("status", "2");
							map.put("orderNum", orderNum);
							map.put("payType", param.get("payType"));
							map.put("message", "企业卡剩余次数不足");
						}else{
							map.put("status", "1");
							map.put("orderNum", orderNum);
							map.put("payType", param.get("payType"));
							map.put("message", "失败");
						}
				    	resultStr = new Gson().toJson(map);
				    	break;
					case "04"://余额
						Integer  resultblance =payOrderService.updateMemberBlance(memberId , realPrice);
						Map<String , Object> mapB = new HashMap<String , Object>();
				    	if(resultblance  == 1){ 
				    		if(tMember.getRedamount() -isUsableRedPackage < 0 ){
				    			mapB.put("status", "1");
				    			mapB.put("orderNum", orderNum);
				    			mapB.put("payType", param.get("payType"));
				    			mapB.put("message", "红包金额不足");
				    		}else{
				    			appPayService.paySuccess(param);
				    		}
				    		mapB.put("status", "0");
				    		mapB.put("orderNum", orderNum);
				    		mapB.put("payType", param.get("payType"));
				    		mapB.put("message", "成功");
						}else if(resultblance  == 2){ 
							mapB.put("status", "1");
							mapB.put("orderNum", orderNum);
							mapB.put("payType", param.get("payType"));
							mapB.put("message", "会员余额不足");
						}else{
							mapB.put("status", "1");
							mapB.put("orderNum", orderNum);
							mapB.put("payType", param.get("payType"));
							mapB.put("message", "失败");
						}
				    	resultStr = new Gson().toJson(mapB);
				    	break;
		    	}
			this.RSAprivateencode(resultStr);
		}
	 
		/**
		 * @param orderNum 订单号
		 * @param orderType订单类型  1活动订单 2商品订单 3私课订单 4场馆订单 (加入订单类型)
		 * @return 查询订单支付状态
		 */
		private void checkedPay(Map<String, Object> param) {
			Integer orderType = (Integer) param.get("orderType");
	    	String orderNum = (String) param .get("orderNum");
	    	Integer result = appPayService.checkedPayStatus(orderType ,orderNum);
	    	Map<String , Object> mapB = new HashMap<String,Object>();
	    	if(result  == 1){ 
	    		mapB.put("status", "0");
	    		mapB.put("orderNum", orderNum);
	    		mapB.put("payType", param.get("payType"));
	    		mapB.put("message", "支付成功");
			}else{
				mapB.put("status", "1");
				mapB.put("orderNum", orderNum);
				mapB.put("payType", param.get("payType"));
				mapB.put("message", "支付失败");
			}
			this.RSAprivateencode(new Gson().toJson(mapB));
		}
		
	
	/**
	 * 必传公用参数
	 * @param memberId 会员ID
	 * @param orderType 订单类型 1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
	 * @param proTableId 	orderType为1是代表 活动ID 为2时代表 商品Id 为3时代表 私课ID 为4时代表 场馆ID 为5时代表 个人卡
	 * @param totalMoney 订单总价
	 * @param couponType  优惠券类型（(覆盖商品) 1 场馆 2 教练 4 充值卡 5活动优惠券 6 私课 7商城）
	 * 
	 * 
	 * 活动订单专属参数
	 * @param num 	  活动报名人数 
	 * 
	 * 商品订单专属参数
	 * @param shipperName	收货人姓名
	 * @param shipperPhone	收货人电话
	 * @param addr					收货地址
	 * @param buyNum			购买数量
	 * @param goodsStandards			商品规格 多个规格用逗号分隔          
	 *            
	 *  私教订单专属参数
	 * @param rowId	私教时间排期ID
	 * @param hour		购买时长
	 * @param timeSpan			购买时段              
	 * @param classDate			上课日期            
	 * @param studioId			场馆ID            
	 * 
	 * 场馆订单专属参数
	 * @param studioName 	  场馆名称
	 *       
	 * 个人卡订单无专属参数
	 *       
	 * @return查询支付订单详情信息并插入数据库
	 */
	private void payOrderDetail(Map<String, Object> param) {
		Integer orderType = Integer.parseInt(param.get("orderType").toString());
		Integer oldOrderId = (Integer)param.get("oldOrderId");
		if(oldOrderId != null && oldOrderId != 0){
			Integer cancelOrder = payOrderService.updateCancelOrder(orderType ,oldOrderId);
			Integer delResult = payOrderService.deleteOrderById(oldOrderId , orderType);
		}
		Integer memberId = Integer.parseInt(param.get("memberId").toString());
		
		Integer proTableId = Integer.parseInt(param.get("proTableId").toString());
		Double totalMoney = Double.parseDouble(param.get("totalMoney").toString());
		Integer couponType = Integer.parseInt(param.get("couponType").toString());
		// 查询会员信息
		TMember member = payOrderService.findMemberById(memberId);
		//根据userID 查询会员手机号
    	String mobilePhoneNo = payOrderService.findMemberMobilephoneNo(member.getUserid());
    	//统计会员的可用红包余额
    	Double usableRedPackage = member.getRedamount();
    	//查询会员个人卡（返回个人卡Id cardId 与个人卡折扣 discount）
    	Map<String , Object> selfCard = payOrderService.findSelfCard(memberId);
    	//是否有个人卡(1 无个人卡   0 有个人卡)
    	Integer isSelfCard = 1;
    	Double selfCardAmount = 0d;//个人卡会员价
    	String usableSelfCardAmount = "0";
    	Integer selfCardId = 0;
    	Map<String, Object> result = new HashMap<String, Object>();
    	if(selfCard != null){
    		isSelfCard = 0;
    		selfCardId = (Integer) selfCard.get("cardId");
    		//个人卡会员价
    		selfCardAmount = (totalMoney/10 - usableRedPackage) * Double.parseDouble(selfCard.get("discount").toString());
    		//个人卡优惠金额保留两位小数
        	usableSelfCardAmount = String .format("%.2f" ,totalMoney-selfCardAmount);
    	}
    	//查询用户企业卡(surplusSportsCount 剩余次数 cardId 企业卡ID)
    	Map<String , Object> enterpriseCard = payOrderService.findEnterpriseCard(memberId);
    	//是否有企业卡(1 无企业卡   0 有企业卡)
    	Integer isEnterpriseCard = 1;
    	if(enterpriseCard != null){
    		isEnterpriseCard = 0;
    	}else{
    		result.put("surplusSportsCount", 0);
    		result.put("enterpriseCardId", 0);
    	}
    	Map<String, Object> checkCoupon = new HashMap<String, Object>();
    	//根据价格、会员ID、优惠券类型查询用户的可用优惠券
		List<Map<String , Object>> coupons  = new ArrayList<Map<String , Object>>();
		if(orderType == 3){
			Integer hour = (Integer) param.get("hour");
			totalMoney = totalMoney * hour;
			coupons = payOrderService.findCouponByMemberId(memberId ,(totalMoney -usableRedPackage - selfCardAmount) *hour , couponType);
		}else{
			coupons = payOrderService.findCouponByMemberId(memberId ,totalMoney -usableRedPackage - selfCardAmount  , couponType);
		}
    	if(usableRedPackage < totalMoney){
    		for (Map<String, Object> map : coupons) {
    			if ((int) map.get("isChecked") == 1) {
    				checkCoupon.putAll(map);
    			}
    		}
    	}
		result.put("totalMoney", Double.parseDouble(String .format("%.2f" ,totalMoney)));//原价
		result.put("memberBlance", member.getBalance());//可使用余额
		result.put("usableRedPackage", usableRedPackage);//可使用红包金额
		result.put("memberName", member.getNickname());//会员名称
		//result.put("coupons", coupons);//可用优惠券列表
		if(totalMoney <= member.getRedamount()){
			checkCoupon.clear();
			result.put("checkCoupon", checkCoupon);//默认选中优惠券
		}else{
			result.put("checkCoupon", checkCoupon);//默认选中优惠券
		}
		result.put("isSelfCard", isSelfCard);//是否有个人卡
		result.put("phonenum", mobilePhoneNo);//会员手机号
		result.put("memberId", memberId);//会员ID
		result.put("orderType", orderType);//订单类型
		if(enterpriseCard == null ){
			result.put("surplusSportsCount", 0);//企业卡剩余运动次数
		}else{
			result.put("surplusSportsCount", (Integer)enterpriseCard.get("surplusSportsCount"));//企业卡剩余运动次数
		}
		if(totalMoney <= member.getRedamount()){
			result.put("usableSelfCardAmount", 0d);//个人卡优惠金额
		}else{
			result.put("usableSelfCardAmount", Double.parseDouble(usableSelfCardAmount));//个人卡优惠金额
		}
		if(isSelfCard == 0){
			result.put("selfCardId", selfCard.get("cardId"));//个人卡ID
		}else{
			result.put("selfCardId", 0);//个人卡ID
		}
		result.put("isEnterpriseCard", isEnterpriseCard);// 是否有企业卡 0有 1没有
		// 判断是否有企业卡 0:有企业卡
		if (isEnterpriseCard == 0) {
			// 如果有企业 surplusSportsCount:企业卡剩余次数
			result.put("surplusSportsCount", Integer.parseInt(enterpriseCard.get("surplusSportsCount").toString()));
			result.put("enterpriseCardId", enterpriseCard.get("cardId"));// 企业卡id
		}else{
			result.put("surplusSportsCount", 0);
			result.put("enterpriseCardId", 0);// 企业卡id
		}
		switch (orderType) {
		case 1:// 活动订单 proTableId代表活动ID
			TActivity tActivity = payOrderService.finActiveById(proTableId);
			Integer num = Integer.parseInt(param.get("num").toString());
			TActivityOrder tActivityOrder = new TActivityOrder();
			tActivityOrder.setActivityid(proTableId);	
			tActivityOrder.setAname(member.getNickname());
			tActivityOrder.setGender(member.getGender());
			tActivityOrder.setMobilephonenum(mobilePhoneNo);
			tActivityOrder.setCreatedate(format.format(new Date()));
			tActivityOrder.setMemberid(memberId);
			tActivityOrder.setTotalmoney(totalMoney);
			tActivityOrder.setOrdernum(System.currentTimeMillis() + "");
			tActivityOrder.setJoinman(num);
			tActivityOrder.setSource("0");
			tActivityOrder.setPaystatus("0");
			tActivityOrder.setMessagestatus("0");
			tActivityOrder.setComm(tActivity.getActivename());
			Integer activeOrderId = null;
			if(tActivity.getAlreadyman() + num <= tActivity.getActivenum()){
				activeOrderId = payOrderService.insetActivityOrder(tActivityOrder);
			}
			result.put("orderNum", tActivityOrder.getOrdernum());
			result.put("enterpriseSubNum", tActivity.getActivesubnum());//企业卡活动扣除次数
			result.put("proId", activeOrderId);
			//更新已报名人数
			if(tActivity.getAlreadyman() + num <= tActivity.getActivenum() && activeOrderId != null){
				tActivity.setAlreadyman(tActivity.getAlreadyman() + num);
				Integer resultActive = payOrderService.updateActiveJoinMan(tActivity);
				if(resultActive == 0){
					result.put("status", "1");
					result.put("message", "更新活动报名人数失败");
				}else{
					result.put("status", "0");
					result.put("message", "成功");
				}
			}else{
				result.put("status", "1");
				result.put("message", "活动报名人数已满！");
			}
			break;
		case 2:// 商品订单 proTableId商品ID
			String shipperName = (String) param.get("shipperName");
			String shipperPhone = (String) param.get("shipperPhone");
			String addr = (String) param.get("addr");
			Integer buyNum = (Integer) param.get("buyNum");
			String goodsStandards = (String) param.get("goodsStandards");
			
			TGoods goods = payOrderService.findGoodsInfoById(proTableId);
			TGoodsOrder tGoodsOrder = new TGoodsOrder();
			tGoodsOrder.setGid(proTableId);
			tGoodsOrder.setMemberid(memberId);
			tGoodsOrder.setCreatedate(format.format(new Date()));
			tGoodsOrder.setMobilephonenum(mobilePhoneNo);
			tGoodsOrder.setMembername(member.getNickname());
			tGoodsOrder.setShippername(shipperName);
			tGoodsOrder.setShipperphone(shipperPhone);
			tGoodsOrder.setMessagestatus(0);
			tGoodsOrder.setAddr(addr);
			tGoodsOrder.setBuynum(buyNum);
			tGoodsOrder.setPrice(goods.getGprice());
			tGoodsOrder.setTotalmoney(totalMoney);
			tGoodsOrder.setPaystatus(0);
			tGoodsOrder.setOrdernum(System.currentTimeMillis()+"");
			tGoodsOrder.setFreight(goods.getFreight());
			tGoodsOrder.setComm(goods.getGname()+ " " + buyNum + " " + goodsStandards);
			tGoodsOrder.setSource("0");
			Integer goodsOrderId = null;
			if(goods.getGcount() > 0){
				goodsOrderId = payOrderService.insetGoodsOrder(tGoodsOrder);
			}
			result.put("enterpriseSubNum", -1);
			result.put("proId", goodsOrderId);
			result.put("orderNum", tGoodsOrder.getOrdernum());
			
			if(goodsOrderId == null || goods.getGcount() - buyNum < 0){
				result.put("status", "1");
				result.put("message", "商品库存不足！");
			}else{
				goods.setGcount(goods.getGcount() - buyNum);
				Integer resultGoods = payOrderService.updateGoodsNum(goods);
				if(resultGoods == 0){
					result.put("status", "1");
					result.put("message", "更新商品库存失败");
				}else{
					result.put("status", "0");
					result.put("message", "成功");
				}
			}
			break;
		case 3:// 私课订单 proTableId 代表教练Id
			Integer  rowId= (Integer) param.get("rowId");
			Integer hour = (Integer) param.get("hour");
			String  timeSpan= (String) param.get("timeSpan");
			String  classDate= (String) param.get("classDate");
			Integer studioId = Integer.parseInt( param.get("studioId").toString());
			totalMoney = Double.parseDouble(String.format("%.2f", totalMoney));
			TCoach tCoach = payOrderService.findCoachById(proTableId);
			TOrder tOrder = new TOrder();
			tOrder.setOrdernum(System.currentTimeMillis()+"");
			tOrder.setCoachid(proTableId);
			tOrder.setHour(hour);
			tOrder.setTotalmoney(totalMoney);
			tOrder.setSource("0");
			tOrder.setCreatedate(format.format(new Date()));
			tOrder.setTimespan(timeSpan);
			tOrder.setClassdate(classDate);
			tOrder.setPaystatus(0);
			tOrder.setMessagestatus(0);
			tOrder.setMemberid(memberId);
			tOrder.setStudioid(studioId);
			tOrder.setClassstatus("0");
			tOrder.setMobilephonenum(mobilePhoneNo);
			tOrder.setComm(tCoach.getNickname() + " " + classDate + " " + timeSpan + " " + hour + "小时");
			Boolean bo = payOrderService.findCoachTime(classDate,timeSpan,proTableId);
			Integer privateOrderId =-2;
			if(bo){
				privateOrderId = payOrderService.insertPrivateOrder(tOrder);
				result.put("totalMoney", totalMoney);
				if(selfCard != null){
		    		//个人卡会员价
		    		selfCardAmount = (totalMoney/10 * Double.parseDouble(selfCard.get("discount").toString()));
		    		//个人卡优惠金额保留两位小数
		        	usableSelfCardAmount = String .format("%.2f" ,(totalMoney-selfCardAmount));
		    	}
				result.put("proId", privateOrderId);
				if(totalMoney <= member.getRedamount()){
					result.put("usableSelfCardAmount", 0d);//个人卡优惠金额
				}else{
					result.put("usableSelfCardAmount", Double.parseDouble(usableSelfCardAmount));//个人卡优惠金额
				}
				result.put("orderNum", tOrder.getOrdernum());
				DecimalFormat    df   = new DecimalFormat("######0");
				result.put("enterpriseSubNum",Integer.parseInt(df.format(tCoach.getSingleprice())));
				
				if(privateOrderId == null){
					result.put("status", "1");
					result.put("message", "订单创建失败");
				}else{
					TPrivateLessonTime time = new TPrivateLessonTime();
					time.setRowid(rowId);
					Integer resultPriDate = payOrderService.updatePrivateOrderDate(time , timeSpan);
					if(resultPriDate == 0){
						result.put("status", "1");
						result.put("message", "更新教练时间失败");
					}else{
						result.put("status", "0");
						result.put("message", "成功");
					}
				}
			}else if(privateOrderId == -2){
				result.put("status", "1");
				result.put("message", "该时段已被预订");
			}
			break;
		case 4:// 场馆订单 proTableId代表场馆ID

			TStudio studio = payOrderService.findStudioById(proTableId);
			TStudioConsumeOrderRecord record = new TStudioConsumeOrderRecord();
			record.setCreatedate(format.format(new Date()));
			record.setMemberid(memberId);
			record.setStudioid(proTableId);
			record.setComm(studio.getStudioname() + "~" + record.getCreatedate());
			record.setMobilephonenum(mobilePhoneNo);
			// 是否有个人卡 0有个人卡是会员价，1没有个人卡原价
			if (isSelfCard == 0) {
				record.setTotalmoney(selfCardAmount);// 会员价,场馆原价*卡折扣
			} else {
				record.setTotalmoney(totalMoney);
			}
			result.put("totalMoney", String .format("%.2f" ,totalMoney));// 会员价或原价

			record.setSource(4);
			record.setMessagestatus(ConstantVo.MESSAGE_STATUS_NO);
			record.setPaystatus(ConstantVo.ORDER_PAY_STATUS_NO_PAY);
			record.setOrdernum(String.valueOf(System.currentTimeMillis()));

			Integer studioOrderId = appStudioConsumeOrderRecordService.saveAppStudioConsumeOrderRecord(record);
			result.put("proId", studioOrderId);// 场馆订单id
			result.put("orderNum", record.getOrdernum());// 订单号
			result.put("enterpriseSubNum", studio.getEnterprisesubnum());// 企业卡扣除次数
			if (studioOrderId > 0) {
				result.put("status", "0");
				result.put("message", "成功");
			} else {
				result.put("status", "1");
				result.put("message", "订单创建失败");
			}
			break;
		case 5:// 个人卡订单 proTableId代表个人卡类型ID
			TCardType tCardType  = payOrderService.findMemberTypeById(proTableId);
			TMemberCardOrderRef tMemberCardOrderRef = new TMemberCardOrderRef();
			tMemberCardOrderRef.setCardtypeid(tCardType.getCardid());
			tMemberCardOrderRef.setMemberid(memberId);
			tMemberCardOrderRef.setDiscount(tCardType.getCarddiscount());
			tMemberCardOrderRef.setTotalmoney(Double.parseDouble(tCardType.getAmount()));
			tMemberCardOrderRef.setRealmoney(Double.parseDouble(tCardType.getAmount()));;
			if(tCardType.getIscashback() == 0){
				tMemberCardOrderRef.setCashback(0d);
			}else{
				tMemberCardOrderRef.setCashback(tCardType.getBackmoney());
			}
			
			tMemberCardOrderRef.setValidday(tCardType.getValiddate());
			tMemberCardOrderRef.setStatus(1);
			tMemberCardOrderRef.setIsdel(0);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(new Date());
			calendar.add(Calendar.DATE, tCardType.getValiddate());
			tMemberCardOrderRef.setExpiredate(format.format(calendar.getTime()));
			tMemberCardOrderRef.setCreatedate(format.format(new Date()));
			tMemberCardOrderRef.setEnterpriseid(-1);
			tMemberCardOrderRef.setSportscount(-1);
			tMemberCardOrderRef.setSurplussportscount(-1);
			tMemberCardOrderRef.setOrdernum(System.currentTimeMillis()+"");
			tMemberCardOrderRef.setSource("2");
			tMemberCardOrderRef.setPaystatus("0");
			tMemberCardOrderRef.setMessagestatus("0");
			tMemberCardOrderRef.setComm(tCardType.getCardtypename() + " " + tCardType.getCarddiscount());
			tMemberCardOrderRef.setMobilephonenum(mobilePhoneNo);
			Integer resultCardOrder= payOrderService.insetMemberCardOrder(tMemberCardOrderRef);
			result.put("proId", resultCardOrder);
			result.put("orderNum", tMemberCardOrderRef.getOrdernum());
			result.put("enterpriseSubNum", -1);// 企业卡扣除次数
			if(resultCardOrder == null){
				result.put("status", "1");
				result.put("message", "订单创建失败");
			}else{
				if(tCardType.getSurplusstock() != -1 && tCardType.getSurplusstock()-1 >=0){
					Integer resultType = payOrderService.updateCardTypeNum(tCardType);
					if(resultType == 0){
						result.put("status", "1");
						result.put("message", "更新个人卡库存失败");
					}
				}
				result.put("status", "0");
				result.put("message", "成功");
			}
			break;
		default:
			result.put("proId", 0);// 场馆订单id
			result.put("orderNum", "");// 订单号
			result.put("enterpriseSubNum", 0);// 企业卡扣除次数
			result.put("status", "1");
			result.put("message", "失败");
			break;
		}
		this.RSAprivateencode(new Gson().toJson(result));
    }
	
	
	/**
	 * @param orderNum 订单号
	 * @param orderType 订单类型  1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
	 */
	private void cancelOrder(Map<String, Object> param) {
		Integer orderType = Integer.parseInt(param.get("orderType").toString());
		Integer orderId = Integer.parseInt(param.get("orderId").toString());
		Integer activeResult = payOrderService.updateCancelOrder(orderType ,orderId);
		Map<String, Object> result = new HashMap<String , Object>();
		if(activeResult == 1){
			result.put("status", "0");
			result.put("message", "订单取消成功");
		}else{
			result.put("status", "1");
			result.put("message", "订单取消失败");
		}
		this.RSAprivateencode(new Gson().toJson(result));
	}
	
	
	/**
	 * @param map
	 *  @param realMoney
	 *  @param memberId
	 *  @param couponType
	 * 查询优惠券列表
	 */
	private void couponList(Map<String, Object> map) {
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		Double totalMoney = Double.parseDouble(map.get("totalMoney").toString());
		Integer couponType = Integer.parseInt(map.get("couponType").toString());
		Map<String, Object> result = new HashMap<String , Object>();
		try {
			List<Map<String , Object>> coupons = payOrderService.findCouponByMemberId(memberId ,totalMoney , couponType);
			result.put("coupons", coupons);
			result.put("status", "0");
			result.put("message", "请求成功");
		} catch (Exception e) {
			result.put("status", "1");
			result.put("message", "加载优惠券列表失败");
		}
		
		this.RSAprivateencode(new Gson().toJson(result));
		
	}
	
	/**
	 * @param orderId 订单ID
	 * @param orderType 订单类型
	 * 			orderType 订单类型 1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
	 * 再次支付 -- 查询再次支付订单详情信息
	 */
	private void againPay(Map<String, Object> map) {
		Integer orderId = Integer.parseInt(map.get("orderId").toString());
		Integer orderType = Integer.parseInt(map.get("orderType").toString());
		Map<String, Object> result = new HashMap<String , Object>();
		result.put("oldOrderId", orderId);
		try {
			switch (orderType) {
			case 1://活动
				TActivityOrder tActivityOrder = payOrderService.finderActiveOrderInfo(orderId );
				result.put("proTableId", tActivityOrder.getActivityid());
				result.put("num", tActivityOrder.getJoinman());
				result.put("couponType", "5");
				break;
			case 2://商品
				TGoodsOrder tGoodsOrder = payOrderService.finderGoodsOrderInfo(orderId );
				result.put("proTableId", tGoodsOrder.getGid());
				result.put("shipperName", tGoodsOrder.getShippername());
				result.put("shipperPhone", tGoodsOrder.getShipperphone());
				result.put("addr", tGoodsOrder.getAddr());
				result.put("buyNum", tGoodsOrder.getBuynum());
				try {
					result.put("goodsStandards", tGoodsOrder.getComm().split(" ")[2]);
				} catch (Exception e) {
					result.put("goodsStandards", "");				
				}
				result.put("couponType", "7");
				break;
			case 3://私课
				TOrder tOrder = payOrderService.findePrivateOrderInfo(orderId);
				Integer rowId = payOrderService.findCoachPrivateTime(tOrder.getCoachid() , tOrder.getClassdate());
				if(rowId == 0){
					throw new RuntimeException();  
				}
				result.put("rowId", rowId);
				result.put("hour", tOrder.getHour());
				result.put("timeSpan", tOrder.getTimespan());
				result.put("classDate", tOrder.getClassdate());
				result.put("studioId", tOrder.getStudioid());
				result.put("proTableId", tOrder.getCoachid());
				result.put("couponType", "6");
				break;
			case 4://场馆
				TStudioConsumeOrderRecord tStudioConsumeOrderRecord = payOrderService.findeStudioOrderInfo(orderId);
				result.put("proTableId", tStudioConsumeOrderRecord.getStudioid());
				result.put("couponType", "1");
				break;
			case 5://个人卡
				TMemberCardOrderRef tMemberCardOrderRef = payOrderService.findeCardOrderInfo(orderId);
				result.put("proTableId", tMemberCardOrderRef.getCardtypeid());
				result.put("couponType", "4");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "1");
			result.put("message", "再次支付订单失败");
		}finally {
			this.RSAprivateencode(new Gson().toJson(result));
		}
	}
	
	/**
	 * @param orderId 订单ID
	 * @param orderType 订单类型
	 * 			orderType 订单类型 1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
	 * 订单退订
	 */
	private void refund(Map<String, Object> map) {
		Integer orderId = Integer.parseInt(map.get("orderId").toString());
		Integer orderType = Integer.parseInt(map.get("orderType").toString());
		Map<String, Object> result = new HashMap<String , Object>();
		Integer resultPay = payOrderService.updateOrderStatusById(orderId , orderType);
		if(resultPay== 0){
			result.put("status", "1");
			result.put("message", "订单退订失败");
		}else if(resultPay== -1){
			result.put("status", "1");
			result.put("message", "订单已超过可退订时段");
		}else{
			result.put("status", "0");
			result.put("message", "请求成功");
		}
		this.RSAprivateencode(new Gson().toJson(result));
	}
}
