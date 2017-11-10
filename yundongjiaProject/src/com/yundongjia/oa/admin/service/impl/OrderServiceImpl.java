/**
* @author HuangJian
* @date 2017年2月3日
*/
package com.yundongjia.oa.admin.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TLeagueOrderMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TOrderDiscountMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TSupplierMapper;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderDiscount;
import com.yundongjia.oa.admin.po.TOrderDiscountExample;
import com.yundongjia.oa.admin.po.TSupplier;
import com.yundongjia.oa.admin.service.OrderService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.vo.OrderSearchVo;
import com.yundongjia.oa.utils.SendMessage;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TGoodsOrderMapper goodsOrderMapper;// 商品订单
	@Autowired
	private TStudioConsumeOrderRecordMapper studioConsumeOrderRecordMapper; // 场馆-健身房订单
	@Autowired
	private TOrderMapper orderMapper;// 私课订单
	@Autowired
	private TActivityOrderMapper activityOrderMapper;// 场馆订单
	@Autowired
	private TLeagueOrderMapper leagueOrderMapper;// 课程订单
	@Autowired
	private TMemberCardOrderRefMapper memberCardOrderRefMapper; //个人卡订单
	@Autowired
	private TOrderDiscountMapper orderDiscountMapper;
	@Autowired
	private TSupplierMapper supplierMapper;
	
	public Map<String, Object> temp;

	public Map<String, Object> param;
	// 短信状态
	Integer messId = 0;
	String messName = "";

	Integer orderStatusId = 0;
	String orderStatusName = "";

	public Map<String, Object> orderTypeMap;
	DecimalFormat    df   = new DecimalFormat("######0.00");
	@Override
	public List<Map<String, Object>> findOrderList(OrderSearchVo orderSearchVo) {
		List<Map<String, Object>> all = new ArrayList<>();

		// 商城订单
		orderTypeMap = new HashMap<>();
		orderTypeMap.put("orderTypeName", "商城");
		orderTypeMap.put("orderTypeId", 0);
		List<Map<String, Object>> goodsOrders = dataFormat(goodsOrderMapper.findGoodsOrderList(orderSearchVo),
				orderTypeMap);

		// 场馆订单
		orderTypeMap = new HashMap<>();
		orderTypeMap.put("orderTypeName", "场馆");
		orderTypeMap.put("orderTypeId", 1);
		List<Map<String, Object>> studiosOrders = dataFormat(
				studioConsumeOrderRecordMapper.findStudioOrder(orderSearchVo), orderTypeMap);
	
		// 2私课 订单
		orderTypeMap = new HashMap<>();
		orderTypeMap.put("orderTypeName", "私课");
		orderTypeMap.put("orderTypeId", 2);
		List<Map<String, Object>> orderOrders = dataFormat(orderMapper.findOrderList(orderSearchVo), orderTypeMap);

		// 3,团课，课程
		orderTypeMap = new HashMap<>();
		orderTypeMap.put("orderTypeName", "课程");
		orderTypeMap.put("orderTypeId", 3);
		List<Map<String, Object>> leagueOrders = dataFormat(leagueOrderMapper.findLeagueOrders(orderSearchVo),
				orderTypeMap);

		// 4活动订单
		orderTypeMap = new HashMap<>();
		orderTypeMap.put("orderTypeName", "活动");
		orderTypeMap.put("orderTypeId", 4);
		List<Map<String, Object>> activityOrders = dataFormat(activityOrderMapper.findActivityOrds(orderSearchVo),
				orderTypeMap);

		
		//5个人卡订单
		orderTypeMap=new HashMap<>();
		orderTypeMap.put("orderTypeName", "个人卡");
		orderTypeMap.put("orderTypeId", 5);
		List<Map<String, Object>> memberCardOrders=dataFormat(memberCardOrderRefMapper.findMemberCardOrderList(orderSearchVo), orderTypeMap);
		
		if(memberCardOrders != null && memberCardOrders.size()>0){
			for(Map<String, Object> mo:memberCardOrders){
				all.add(mo);
			}
		}
		
		if (goodsOrders != null && goodsOrders.size() > 0) {
			for (int i = 0; i < goodsOrders.size(); i++) {
				all.add(goodsOrders.get(i));
			}
		}
		if (studiosOrders != null && studiosOrders.size() > 0) {
			for (int i = 0; i < studiosOrders.size(); i++) {
				all.add(studiosOrders.get(i));
			}
		}

		if (orderOrders != null && orderOrders.size() > 0) {
			for (int i = 0; i < orderOrders.size(); i++) {
				all.add(orderOrders.get(i));
			}
		}

		if (leagueOrders != null && leagueOrders.size() > 0) {
			for (int i = 0; i < leagueOrders.size(); i++) {
				all.add(leagueOrders.get(i));
			}
		}

		if (activityOrders != null && activityOrders.size() > 0) {
			for (int i = 0; i < activityOrders.size(); i++) {
				all.add(activityOrders.get(i));
			}
		}
		return all;
	}

	/**
	 * Title: goodsFormat Description: 商城数据格式化
	 * 
	 * @param list
	 * @return
	 * @author HuangJian
	 * @date 2017年2月7日
	 */
	public List<Map<String, Object>> dataFormat(List<Map<String, Object>> goodsOrders, Map<String, Object> typeMap) {

		if (goodsOrders != null && goodsOrders.size() > 0) {
			for (int i = 0; i < goodsOrders.size(); i++) {
				temp = goodsOrders.get(i);

				temp.putAll(typeMap);

				// 短信状态 
				messId = Integer.parseInt(String.valueOf(temp.get("messageStatus")));
				switch (messId) {
				case 0:
					messName = "未发送";
					break;
				case 1:
					messName = "已发送";
					break;
				default:
					messName="--";
					break;
				}

				temp.put("messName", messName);

				try {
					// 订单状态
					orderStatusId = Integer.parseInt(String.valueOf(temp.get("payStatus")));
					switch (orderStatusId) {
					case 0:
						orderStatusName = "待支付";
						break;
					case 1:
						orderStatusName = "已取消";
						break;
					case 2:
						orderStatusName = "已支付";
						break;
					case 3:
						orderStatusName = "退订中";
						break;
					case 4:
						orderStatusName = "已退订";
						break;
					case 5:
						orderStatusName = "已完成";
						break;
					case 7:
						orderStatusName="已结算";
						break;
					case 8:
						orderStatusName="取消结算";
						break;
					case 9:
						orderStatusName="禁用";
						break;
					default:
						orderStatusName="--";
						break;
					}
					temp.put("orderStatusName", orderStatusName);
				} catch (NumberFormatException e) {
					temp.put("orderStatusName", "--");
				}

				// 来源
				Integer sourceId = Integer.parseInt(String.valueOf(temp.get("source")));
				String sourceName = "";
				switch (sourceId) {
				case 0:
					sourceName = "App";
					break;
				case 1:
					sourceName = "微信";
					break;
				case 2:
					sourceName = "APP";
					break;
				case 3:
					sourceName="实体卡";
					break;
				case 4:
					sourceName="场馆扫码";
					break;
				default:
					sourceName="--";
					break;
				}
				temp.put("sourceName", sourceName);
				
				String payTypeId = String.valueOf(temp.get("payType"));
				String payTypeName="";
				switch (payTypeId) {
				case "00":
					payTypeName="支付宝";
					break;
				case "01":
					payTypeName="微信";
					break;
				case "02":
					payTypeName="银行卡";
					break;
				case "03":
					payTypeName="企业卡";
					break;
				case "04":
					payTypeName="余额";
					break;
				default:
					payTypeName="--";
					break;
				}
				temp.put("payTypeName", payTypeName);
			}
		}

		return goodsOrders;
	}

	@Override
	public List<Map<String, Object>> selectOrdersByOrder(OrderSearchVo orderSearchVo) {
		String start = orderSearchVo.getStartTime();
		String end = orderSearchVo.getEndTime();
		if (start != null && !"".equals(start)) {
			orderSearchVo.setStartTime(start + " 00:00:00");
		}
		if (end != null && !"".equals(end)) {
			orderSearchVo.setEndTime(start + " 59:59:59");
		}
		List<Map<String, Object>> mapMes = new ArrayList<>();

		switch (orderSearchVo.getOrderType()) {
		case -1:// 查询所有条件
			mapMes = findOrderList(orderSearchVo);
			break;
		case 0:// 查询条件 和 商城订单表
				// 商城订单
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "商城");
			orderTypeMap.put("orderTypeId", 0);
			mapMes = dataFormat(goodsOrderMapper.findGoodsOrderList(orderSearchVo), orderTypeMap);

			break;
		case 1:
			// 场馆订单
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "场馆");
			orderTypeMap.put("orderTypeId", 1);

			mapMes = dataFormat(studioConsumeOrderRecordMapper.findStudioOrder(orderSearchVo), orderTypeMap);

			break;
		case 2:
			// 2私课 订单
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "私课");
			orderTypeMap.put("orderTypeId", 2);
			mapMes = dataFormat(orderMapper.findOrderList(orderSearchVo), orderTypeMap);

			break;
		case 3:
			// 3,团课，课程
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "课程");
			orderTypeMap.put("orderTypeId", 3);
			mapMes = dataFormat(leagueOrderMapper.findLeagueOrders(orderSearchVo), orderTypeMap);

			break;
		case 4:
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "活动");
			orderTypeMap.put("orderTypeId", 4);
			mapMes = dataFormat(activityOrderMapper.findActivityOrds(orderSearchVo), orderTypeMap);

			break;
		case 5:
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "个人卡");
			orderTypeMap.put("orderTypeId", 5);
			mapMes = dataFormat(memberCardOrderRefMapper.findMemberCardOrderList(orderSearchVo), orderTypeMap);
			
			break;
		default:
			break;
		}

		return mapMes;
	}
	
	public static String getClearPriceBySupppli(Map<String, Object> sulipper,Integer orderId,Integer column,Map<String, Object> res){
		String cPrice="0.0";
		String idsStr="";
		String moneyStr="";
		String id="";
		//有绑定供应商的可能订单
		if (column > -1) {
			switch (column) {
			case 0:
				id = String.valueOf(res.get("gId"));
				idsStr = String.valueOf(sulipper.get("linkGoodsId"));
				moneyStr = String.valueOf(sulipper.get("likeGoodsCostPrice"));
				break;
			case 1:
				id=String.valueOf(res.get("studioId"));
				idsStr = String.valueOf(sulipper.get("linkStudioId"));// 场馆ID
				moneyStr = String.valueOf(sulipper.get("likeStudioCostPrice"));// 场馆成本价

				break;
			case 2:
				id = String.valueOf(res.get("coachId"));
				idsStr = String.valueOf(sulipper.get("linkCoachId"));
				moneyStr = String.valueOf(sulipper.get("likeCoachCostPrice"));
				break;

			default:
				break;
			}

		}else{
			
		}
			
			

		if(!"".equals(idsStr) && !"".equals(moneyStr) && !"".equals(id)){
			String [] ids = idsStr.split(",");
			String [] money = moneyStr.split(",");
			
			if(ids != null && ids.length > 0){
				for(int i=0;i<ids.length;i++){
					if(id.equals(ids[i])){
						//找到了供应商中的绑定
						cPrice = money[i];
					}else{
						
					}
				}
			}else{
				
			}
			
			
		}else{
			
		}
		
		
		
		
		
		
		return cPrice;
	}
	
	@Override
	public Map<String, Object> selectOrdersByOrderId(Integer orderId, Integer orderType) {

		param = new HashMap<>();
		param.put("orderType", orderType);
		param.put("orderId", orderId);
		Map<String, Object> orderTypeMap = new HashMap<>();
		List<Map<String, Object>> results = orderMapper.getOrdersByOrderIdType(param);
		Integer column=-1;
		Integer id=-1;
		switch (orderType) {
		case 0:// 查询条件 和 商城订单表
				// 商城订单
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "商城");
			orderTypeMap.put("orderTypeId", 0);
			//根据订单
			column=0;
			break;
		case 1:
			// 场馆订单
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "场馆");
			orderTypeMap.put("orderTypeId", 1);
			
			column=1;
			
			break;
		case 2:
			// 2私课(教练) 订单
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "私课");
			orderTypeMap.put("orderTypeId", 2);
			
			column=2;
			
			break;
		case 3:
			// 3,团课，课程
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "课程");
			orderTypeMap.put("orderTypeId", 3);

			break;
		case 4://活动订单
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "活动");
			orderTypeMap.put("orderTypeId", 4);
			
			break;
		case 5:
			orderTypeMap = new HashMap<>();
			orderTypeMap.put("orderTypeName", "个人卡");
			orderTypeMap.put("orderTypeId", 5);
			
			break;
		default:
			break;
		}
		
		results = dataFormat(results, orderTypeMap);
		if (results != null && results.size() > 0) {
			
			Map<String, Object> res =  results.get(0);
			//订单中的资源ID
			switch (column) {
			case 0://商品
				id = Integer.parseInt(String.valueOf(res.get("gId")));
				break;
			case 1://场馆
				id = Integer.parseInt(String.valueOf(res.get("studioId")));
				break;
			case 2://私教、教练
				id = Integer.parseInt(String.valueOf(res.get("coachId")));
				break;

			default:
				break;
			}
			
			
			param.put("column", column);
			param.put("id", id);
			if(column != -1 && id != -1){
				//结算的信息
				List<Map<String, Object>> suliers =  supplierMapper.findColumnByOrderId(param);
				if(suliers.size() > 0){//找到了订单对应的供应商
					Map<String, Object> sulipper = suliers.get(0);
					
					//供应商名称
					res.put("supplierName", sulipper.get("supplierName"));
					//结算价
					String cPrice =  getClearPriceBySupppli(sulipper, orderId, column, res);
					
					res.put("clearPrice", cPrice);
				}else{//没有绑定供应商
					
				}
			}else{
				
			}
			
			
			
			
			
			
			double sum=0.0;//优惠总金额
			double red=0.0;
			double selfCard=0.0;
			double coupon=0.0;
			try {
				red = Double.parseDouble(String.valueOf(res.get("redPackage")));
				selfCard = Double.parseDouble(String.valueOf(res.get("selfCard")));
				coupon = Double.parseDouble(String.valueOf(res.get("coupon")));
			} catch (NumberFormatException e1) {
				 
			}
			sum=(red+selfCard+coupon);
			res.put("disSum",df.format(sum));//优惠总金额
			
			double invoiceMoney=0.0;
			try {
				invoiceMoney = Double.parseDouble(String.valueOf(res.get("invoiceMoney")));//发票税费
			} catch (NumberFormatException e) {
				 
			}
			double totalMoney=0.0;
			try {
				totalMoney = Double.parseDouble(String.valueOf(res.get("totalMoney")));
			} catch (NumberFormatException e) {
				 
			}
			double account = 0.0;//结算价：调取成本价，活动订单分别显示场馆+教练的结算价
			double shMoney=0.0; //订单金额-优惠减免+发票税费
			switch (orderType) {
			case 0:// 查询条件 和 商城订单表
				 

				break;
			case 1:
				// 场馆订单
				 

				break;
			case 2:
				// 2私课 订单
				 

				break;
			case 3:
				// 3,团课，课程
				 

				break;
			case 4://活动订单
				
				double studioCost=0.0;
				double coachCosts=0.0;
				try {
					studioCost = Double.parseDouble(String.valueOf(res.get("studioCost")));
					coachCosts = Double.parseDouble(String.valueOf(res.get("coachCosts")));
				} catch (NumberFormatException e) {
					
				}
				account = studioCost+coachCosts;
				res.put("account", account);//结算价
				break;
			case 5:
				
				break;
			default:
				break;
			}
			
			//shMoney = 
			res.put("shMoney", df.format(((totalMoney-sum)+invoiceMoney)));//实收金额
			
			
			return res;
		}
		return null;
	}

	@Override
	public Integer updateOrderStatus(Integer orderId, String typeName, Integer status) {
		Map<String, Object> param=new HashMap<>();
		param.put("oId", orderId);
		param.put("typeName", typeName);
		param.put("status", status);
		
		//修改订单状态时间     订单什么状态  retreatDate 就代表状态更新日期
		TOrderDiscountExample example = new TOrderDiscountExample();
		Integer typeId=0;
		switch(typeName){
		case "商城":
			typeId=0;
			break;
		case "场馆":
			typeId=1;
			break;
		case "私课":
			typeId=2;
			break;
		case "课程":
			typeId=3;
			break;
		case "活动":
			typeId=4;
			break;
		case "个人卡":
			typeId=5;
			break;
		default:
				break;
		}
		
		
		
		example.createCriteria().andOrderidEqualTo(orderId).andStatusEqualTo(typeId);
		List<TOrderDiscount> ods =  orderDiscountMapper.selectByExample(example);

		
		if(ods !=null && ods.size() > 0){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TOrderDiscount tDiscount = ods.get(0);
			
			tDiscount.setRetreatdate(sdf.format(new Date()));
//			修改订单状态日期
			orderDiscountMapper.updateByPrimaryKey(tDiscount);
			
		}
		
		
		return orderMapper.updateOrderStatus(param);
	}

	@Override
	public Map<String, Object> selectStatisOrder() {
		Map<String, Object> param=new HashMap<>();
		 
		
		
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		Double sum=0.0;//订单总金额
		Integer undoSum=0;//取消订单总数
		Integer daysOrders=0;//今日订单总数
		
		String strTemp;
		for(int i=0;i<6;i++){
			param.put("orderTypeId", i);
			
			param.put("statusId", null);//全部状态总金额
			strTemp = orderMapper.selectStatisOrderTotalMoney(param);
			if(strTemp !=null && !"".equals(strTemp)){
				sum += Double.parseDouble(String.valueOf(strTemp));
			}
			param.put("statusId", 1);//已取消状态总数
			undoSum += orderMapper.selectStatisOrderByStatus(param);//根据订单状态统计总数
			
			daysOrders += orderMapper.selectStatisOrderDay(param);//今日订单数
			
			
		}
		
		
		param.clear();
		param.put("sumMoney", df.format(sum));
		param.put("undoSum", undoSum);//取消订单数
		param.put("daysOrders", daysOrders);//今日新增订单
		
		//------财务
		double totalRefunded=0.0;//已退款总额
		double unTotalRefunded=0.0;//未退款总额
		for(int i=0;i<6;i++){
			param.put("orderTypeId", i);
			
			
			//退款总金额   已退订状态
			param.put("statusId", 3);
			strTemp = orderMapper.selectStatisOrderTotalMoney(param);
			if(strTemp !=null && !"".equals(strTemp)){
				totalRefunded += Double.parseDouble(String.valueOf(strTemp));
			}
			//未退款总金额   退订中状态
			param.put("statusId", 4);
			strTemp = orderMapper.selectStatisOrderTotalMoney(param);
			if(strTemp !=null && !"".equals(strTemp)){
				unTotalRefunded += Double.parseDouble(String.valueOf(strTemp));
			}
		}
		
		
		//退款总金额   已退订状态
		param.put("totalRefunded", df.format(totalRefunded));
		//未退款总金额 退订中的状态
		param.put("unTotalRefunded", df.format(unTotalRefunded));
		return param;
	}
	////1活动订单 2商品订单 3私课订单 4场馆订单 5 个人卡订单
	
	//订单类型  订单类型  0商城 1场馆 2私课 3课程 4活动 5 个人卡
	@Override
	public Map<String, Object> sendMessageByType(Integer type, Integer orderId) {
	 
		Map<String, Object> result=new HashMap<>();
		Map<String, Object> param=new HashMap<>();
		param.put("orderTypeId", type);
		param.put("oId", orderId);
		try{
		Map<String, Object> map =  orderMapper.selectOrderById(param);
		if(null != map && map.size() > 0){
			String mobilePhoneNo=String.valueOf(map.get("mobilePhoneNum"));
			String data="";
			String message="";
			Integer messStatus=-1;
			switch (type) {
			case 0:
				
				break;
			case 1://场馆
				message="【"+ map.get("studioName") +"】下单成功！请至前台报您手机后四位入场运动。";
				break;
			case 2://私课
				message="【"+map.get("nickName")+"】预约成功！请【"+map.get("classDate")+"】【"+map.get("timeSpan")+"】准时至【"+ map.get("studioName") +"】上课，如有问题，请致电客服："+ConstantVo.YDJ_TELEPHONE;
				
				break;
			case 3://课程
				
				break;
			case 4://活动
				String [] classStartDate =  String.valueOf(map.get("activeStartTime")).split(" ");
				String [] classEndDate=String.valueOf(map.get("activeEndTime")).split(" ");
				message="【"+ map.get("activeName") +"】预约成功！请【"+ classStartDate[0] +"】【"+classStartDate[1]+"-"+ classEndDate[1] +"】准时至【"+ map.get("studioName") +"】上课，如有问题，请致电客服："+ConstantVo.YDJ_TELEPHONE;
				break;
			case 5:
				message="已成功购买【"+ map.get("cardTypeName") +"】【1】张，可在预约【场馆、教练、团课、商城】享受【"+ map.get("cardDiscount") +"】折优惠，感谢您加入运动+智慧运动大家庭。";
				data = SendMessage.sendAppointmentMessage(mobilePhoneNo, message);
				//返现金额发送短信
				if(!"0".equals(map.get("cashBack"))){
					String msg="您购买个人卡返现红包【"+ map.get("cashBack") +"】元已到帐，有效期至【"+map.get("expireDate")+"】，可在APP我的-红包查看。";
					SendMessage.sendAppointmentMessage(mobilePhoneNo, msg);
				}
				
				break;

			default:
				break;
			}
			
			if("03".equals(data)){
				result.put("status", 1);
				messStatus = orderMapper.updateOrderMessageStatusByOrderId(param);
				result.put("message", "发送短信成功");
			}else{
				result.put("status", 0);
				result.put("message", "短信因服务商问题未发送成功");
				
			}
			
			  
			result.put("messStatus", messStatus);
		}
		}catch(Exception e){
			result.put("status", 0);
			result.put("message", "后台发生错误异常");
		}
		return result;
	}

}
