package com.yundongjia.app.user.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.MyOrderService;
import com.yundongjia.oa.admin.mapper.TActivityMapper;
import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TCardTypeMapper;
import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TCoachStudioRefMapper;
import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.mapper.TGoodsMapper;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TLeagueOrderMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TOrderDiscountMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachStudioRef;
import com.yundongjia.oa.admin.po.TCoachStudioRefExample;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderDiscount;
import com.yundongjia.oa.admin.po.TOrderDiscountExample;
import com.yundongjia.oa.admin.po.TOrderDiscountExample.Criteria;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** * @author  作者WangLi: * @date 创建时间：2017年2月8日 上午11:14:10 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class MyOrderServiceImpl implements MyOrderService {

	@Autowired
	private TOrderMapper orderMapper;
	@Autowired
	private TLeagueOrderMapper leagueOrderMapper;
	@Autowired
	private TActivityOrderMapper activityOrderMapper;
	@Autowired
	private TGoodsOrderMapper goodsOrderMapper;
	@Autowired
	private TStudioConsumeOrderRecordMapper studioConsumeOrderRecordMapper;
	@Autowired
	private TStudioMapper studioMapper;
	@Autowired
	private TCoachStudioRefMapper tStudioRefMapper;
	@Autowired
	private TActivityMapper activityMapper;
	@Autowired
	private TGoodsMapper goodsMapper;
	@Autowired
	private TMemberCardOrderRefMapper tMemberCardOrderRefMapper;
	@Autowired
	private TCardTypeMapper tcardTypeMapper;
	@Autowired
	private TCoachMapper tCoachMapper;
	@Autowired
	private TOrderDiscountMapper tOrderDiscountMapper;
	@Autowired
	private TMemberMapper tMemberMapper;
	@Autowired
	private TConfigMapper tConfigMapper;
	
	private TOrderExample orderExample = new TOrderExample();
	private TActivityOrderExample activityOrderExample = new TActivityOrderExample();
	private TGoodsOrderExample goodsOrderExample = new TGoodsOrderExample();
	private TStudioConsumeOrderRecordExample studioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
	private TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
	private JSONObject jsonObject = new JSONObject();
	private JSONArray jsonArray = new JSONArray();
	
	@Override
	public JSONArray myOrder(Integer memberId, String orderStatus) {
		/**
		 * orderStatus:0查询所有订单  1待上课的所有订单 2 待支付的所有订单  3 待评价的所有订单 
		 * 4 单独查询私课 5 单独查询团课 6 单独查询活动订单
		 * 7 单独查询健身房 8 单独查询商城订单(目前就写到了3，其他的以后有需求了在写)
		 */
		orderExample.clear();
		activityOrderExample.clear();
		goodsOrderExample.clear();
		studioConsumeOrderRecordExample.clear();
		List<Integer> paystatus = new ArrayList<Integer>();
		paystatus.add(7);
		paystatus.add(8);
		List<String> paystatusStr = new ArrayList<String>();
		paystatusStr.add("7");
		paystatusStr.add("8");
		switch (orderStatus) {
		case "0":
			jsonClear();
			orderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusNotIn(paystatus);
			orderExample.setOrderByClause("classDate desc;");
			activityOrderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusNotIn(paystatusStr);
			activityOrderExample.setOrderByClause("createDate desc;");
			goodsOrderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusNotIn(paystatus);
			goodsOrderExample.setOrderByClause("createDate desc;");
			studioConsumeOrderRecordExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusNotIn(paystatus);
			studioConsumeOrderRecordExample.setOrderByClause("createDate desc;");
			tMemberCardOrderRefExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusNotIn(paystatusStr);
			tMemberCardOrderRefExample.setOrderByClause("createDate desc;");
		    jsonArray = OrderList();
			break;
		case "1":
			jsonClear();
			orderExample.createCriteria().andMemberidEqualTo(memberId).andClassstatusEqualTo("0").andPaystatusEqualTo(2);
			orderExample.setOrderByClause("classDate desc;");
			activityOrderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo("2");
			activityOrderExample.setOrderByClause("createDate desc;");
			goodsOrderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo(2);
			goodsOrderExample.setOrderByClause("createDate desc;");
			studioConsumeOrderRecordExample.createCriteria().andMemberidEqualTo(0);//不存在带上课的情况，让条件东西查不出来就ok
			studioConsumeOrderRecordExample.setOrderByClause("createDate desc;");
			tMemberCardOrderRefExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo("2");
			tMemberCardOrderRefExample.setOrderByClause("createDate desc;");
			jsonArray = OrderList(); 
			break;
		case "2":
			jsonClear();
			orderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo(0);
			orderExample.setOrderByClause("classDate desc;");
			activityOrderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo("0");
			activityOrderExample.setOrderByClause("createDate desc;");
			goodsOrderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo(0);
			goodsOrderExample.setOrderByClause("createDate desc;");
			tMemberCardOrderRefExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo("0");
			tMemberCardOrderRefExample.setOrderByClause("createDate desc;");
			studioConsumeOrderRecordExample.createCriteria().andMemberidEqualTo(0).andPaystatusEqualTo(0);//不存在待上课的情况，让条件东西查不出来就ok
			studioConsumeOrderRecordExample.setOrderByClause("createDate desc;");
			jsonArray = OrderList();
			break;
		case "3":
			jsonClear();
			orderExample.createCriteria().andMemberidEqualTo(memberId).andScoreidIsNotNull().andPaystatusNotIn(paystatus);
			orderExample.setOrderByClause("classDate desc;");
			activityOrderExample.createCriteria().andMemberidEqualTo(memberId).andScoreidIsNotNull().andPaystatusNotIn(paystatusStr);
			activityOrderExample.setOrderByClause("createDate desc;");
			goodsOrderExample.createCriteria().andMemberidEqualTo(memberId).andScoreidIsNotNull().andPaystatusNotIn(paystatus);
			goodsOrderExample.setOrderByClause("createDate desc;");
			studioConsumeOrderRecordExample.createCriteria().andMemberidEqualTo(memberId).andScoreidIsNotNull().andPaystatusNotIn(paystatus);
			studioConsumeOrderRecordExample.setOrderByClause("createDate desc;");
			tMemberCardOrderRefExample.createCriteria().andMemberidEqualTo(0).andPaystatusNotIn(paystatusStr);
			tMemberCardOrderRefExample.setOrderByClause("createDate desc;");
			jsonArray = OrderList();
			break;
		default:
			break;
		}
		
		
		
		return jsonArray;
	}
	/**
	 * 
	* @Title: OrderList 
	* @Description: TODO(订单列表     订单状态0待支付 1已取消  2已支付  3退订中 4已退订  5已完成) 
	* @param @return    设定文件 
	* @return JSONArray    返回类型 
	* @throws
	 */
	   public JSONArray OrderList(){
			List<TOrder> list_order = this.orderMapper.selectByExample(orderExample);
		    List<TActivityOrder> list_activity = this.activityOrderMapper.selectByExample(activityOrderExample);
		    List<TGoodsOrder> list_goods = this.goodsOrderMapper.selectByExample(goodsOrderExample);
		    List<TStudioConsumeOrderRecord> list_studio = this.studioConsumeOrderRecordMapper.selectByExample(studioConsumeOrderRecordExample);
		    List<TMemberCardOrderRef> list_card = this.tMemberCardOrderRefMapper.selectByExample(tMemberCardOrderRefExample);
	/***私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课私课**/	   
		    for(TOrder order:list_order){
			    	 TStudio studio = studioMapper.selectByPrimaryKey(order.getStudioid());
			    	 TCoach coach = tCoachMapper.selectByPrimaryKey(order.getCoachid());
			     if(studio != null && coach != null){
			    	 jsonObject.put("name", coach.getNickname());//私课订单name表示场馆地址
			    	 jsonObject.put("addr", studio.getStudioaddr());//私课订单addr表示健身房地址
			    	 jsonObject.put("likeDate", order.getClassdate());//私课订单likeDate表示上课日期
			    	 jsonObject.put("price", order.getTotalmoney());//私课订单price表示订单总价
			    	 jsonObject.put("payStatus", order.getPaystatus());//私课订单是payStatus表示订单状态
			    	 jsonObject.put("orderId", order.getOrderid());//订单Id
			    	 jsonObject.put("timeSpan", order.getTimespan());//上课时间段
			    	 jsonObject.put("hour", order.getHour());//上课时长
			    	 jsonObject.put("expireDate", "");//个人卡到期日期
			    	 jsonObject.put("discount", "");//个人卡折扣
			    	 jsonObject.put("orderType", "3");
			    	 if(order.getScoreid() == null || "".equals(order.getScoreid())){//表示该条订单还没有被评价
			    		 jsonObject.put("isAssess", "0");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 }else{//已经被评价
			    		 jsonObject.put("isAssess", "1");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 }
			    	 jsonArray.add(jsonObject);
		    	}
		     }
	/*****活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动活动*****/
		    for(TActivityOrder order:list_activity){
		    		TActivity activity = this.activityMapper.selectByPrimaryKey(order.getActivityid());
		    	if(activity != null){
			    	 jsonObject.put("name", activity.getActivename());//活动订单name表示活动名称
			    	 jsonObject.put("addr", activity.getActiveaddres());//活动订单addr表示活动地址
			    	 jsonObject.put("likeDate", activity.getActivestarttime());//活动订单likeDate表示活动开始日期
			    	 jsonObject.put("price", order.getTotalmoney());//活动订单price表示订单总价
			    	 jsonObject.put("payStatus", order.getPaystatus());//活动订单是payStatus表示订单状态
			    	 jsonObject.put("orderId", order.getOrderid());//订单Id
			    	 jsonObject.put("timeSpan", activity.getActivestarttime() + "-" + activity.getActiveendtime());//上课时间段
			    	 jsonObject.put("hour", "");//上课时长
			    	 jsonObject.put("expireDate", "");//个人卡到期日期
			    	 jsonObject.put("discount", "");//个人卡折扣
			    	 jsonObject.put("orderType", "1");
			    	 if(order.getScoreid() == null || "".equals(order.getScoreid())){//表示该条订单还没有被评价
			    		 jsonObject.put("isAssess", "0");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 }else{//已经被评价
			    		 jsonObject.put("isAssess", "1");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 }
			    	 jsonArray.add(jsonObject);
		    	}
		     }
		    /*****商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品商品*****/
		    for(TGoodsOrder order:list_goods){
			    	 TGoods goods = this.goodsMapper.selectByPrimaryKey(order.getGid());
			   if(goods != null){
			    	 jsonObject.put("name", goods.getGname());//商品订单name表示商品名称
			    	 jsonObject.put("addr", order.getAddr());//商品订单addr表示收获地址
			    	 jsonObject.put("likeDate", order.getCreatedate());//商品订单likeDate表示商品下单日期日期
			    	 jsonObject.put("price", order.getTotalmoney());//商品订单price表示订单总价
			    	 jsonObject.put("payStatus", order.getPaystatus());//商品订单是payStatus表示订单状态
			    	 jsonObject.put("orderId", order.getOrderid());//订单Id
			    	 jsonObject.put("timeSpan", "");//上课时间段
			    	 jsonObject.put("hour", "");//上课时长
			    	 jsonObject.put("expireDate", "");//个人卡到期日期
			    	 jsonObject.put("discount", "");//个人卡折扣
			    	 jsonObject.put("orderType", "2");
			    	 if(order.getScoreid() == null || "".equals(order.getScoreid())){//表示该条订单还没有被评价
			    		 jsonObject.put("isAssess", "0");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 }else{//已经被评价
			    		 jsonObject.put("isAssess", "1");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 }
			    	 jsonArray.add(jsonObject);
		    	}
		     }
		    /*****健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费健身房消费****/
		    for(TStudioConsumeOrderRecord order:list_studio){
			    	 TStudio studio = studioMapper.selectByPrimaryKey(order.getStudioid());
			    if(studio != null){
			    	 jsonObject.put("name", studio.getStudioname());//健身房消费订单name表示场馆地址
			    	 jsonObject.put("addr", studio.getStudioaddr());//健身房消费订单addr表示健身房地址
			    	 jsonObject.put("likeDate", order.getCreatedate());//健身房消费订单likeDate表示消费日期
			    	 jsonObject.put("price", order.getTotalmoney());//团课订单price表示订单总价
			    	 jsonObject.put("payStatus", order.getPaystatus());//团课订单是payStatus表示订单状态
			    	 jsonObject.put("orderId", order.getOrderid());//订单Id
			    	 jsonObject.put("timeSpan", "");//上课时间段
			    	 jsonObject.put("hour", "");//上课时长
			    	 jsonObject.put("expireDate", "");//个人卡到期日期
			    	 jsonObject.put("discount", "");//个人卡折扣
			    	 jsonObject.put("orderType", "4");
			    	 if(order.getScoreid() == null || "".equals(order.getScoreid())){//表示该条订单还没有被评价
			    		 jsonObject.put("isAssess", "0");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 }else{//已经被评价
			    		 jsonObject.put("isAssess", "1");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 }
			    	 jsonArray.add(jsonObject);
		    	}
		     }
		    /*****个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡个人卡****/
		   for(TMemberCardOrderRef order:list_card){
				   TCardType cardType = tcardTypeMapper.selectByPrimaryKey(order.getCardtypeid());
			if(cardType != null){
			    	 jsonObject.put("name", cardType.getCardtypename());//健身房消费订单name表示场馆地址
			    	 jsonObject.put("addr", "");//健身房消费订单addr表示健身房地址
			    	 jsonObject.put("likeDate", order.getCreatedate());//健身房消费订单likeDate表示消费日期
			    	 jsonObject.put("price", order.getTotalmoney());//团课订单price表示订单总价
			    	 jsonObject.put("payStatus", order.getPaystatus());//团课订单是payStatus表示订单状态
			    	 jsonObject.put("orderId", order.getOrderid());//订单Id
			    	 jsonObject.put("timeSpan", "");//上课时间段
			    	 jsonObject.put("hour", "");//上课时长
			    	 jsonObject.put("expireDate", order.getExpiredate().split(" ")[0]);//个人卡到期日期
			    	 jsonObject.put("discount", order.getDiscount());//个人卡折扣
			    	 jsonObject.put("orderType", "5");
			    	 jsonObject.put("isAssess", "1");//订单是否被评价  0:没有被评价   1:已经被评价
			    	 jsonArray.add(jsonObject);
			   }
		     }
		   return jsonArray;
	   }
	   public void jsonClear(){
		   jsonArray.clear();
		   jsonObject.clear();
			orderExample.clear();
			activityOrderExample.clear();
			goodsOrderExample.clear();
			tMemberCardOrderRefExample.clear();
			studioConsumeOrderRecordExample.clear();
	   }
	@Override
	public TStudio selectStudioInfo(Integer id) {
		TStudio studio = studioMapper.selectByPrimaryKey(id);
		return studio;
	}
	@Override
	public List<TActivityOrder> myActivityOrdersList(TActivityOrderExample example) {
		List<TActivityOrder> list = this.activityOrderMapper.selectByExample(example);
		return list;
	}
	@Override
	public TActivity myactivityList(Integer id) {
		TActivity league = activityMapper.selectByPrimaryKey(id);
		return league;
	}
	
	/**
	 * @param orderType
	 * @param proId
	 * @return根据ID查询订单详情
	 */
	@Override
	public Map<String, Object> findOrderById(Integer orderType, Integer proId) {
		Map<String, Object> logistics= new HashMap<String, Object>();
		Map<String, Object> result= new HashMap<String, Object>();
		TOrderDiscountExample tOrderDiscountExample = new TOrderDiscountExample();
		Criteria orderDiscountC = tOrderDiscountExample.createCriteria();
		orderDiscountC.andOrderidEqualTo(proId);
		Boolean isEnCard = false;
		switch (orderType) {
		case 1://活动订单
			orderDiscountC.andStatusEqualTo(4);
			TActivityOrder activityOrder = activityOrderMapper.selectByPrimaryKey(proId);
			TActivity activity = activityMapper.selectByPrimaryKey(activityOrder.getActivityid());
			result.put("orderName", activity.getActivename());
			result.put("tableId", activity.getActiveid());
			result.put("payStatus", formatePayStatus(Integer.parseInt(activityOrder.getPaystatus())));
			result.put("timeSpan", activity.getActivestarttime() + "-" + activity.getActiveendtime().split(" ")[1]);
			result.put("addr", activity.getActiveaddres());
			result.put("num", activityOrder.getJoinman().toString());
			result.put("phone", activityOrder.getMobilephonenum());
			result.put("memberName", tMemberMapper.selectByPrimaryKey(activityOrder.getMemberid()).getNickname());
			result.put("logistics", logistics);
			result.put("orderNumber", activityOrder.getOrdernum());
			result.put("createDate", activityOrder.getCreatedate());
			result.put("realMoney", formateMoney(activityOrder.getTotalmoney()));
			result.put("totalMoney", formateMoney(activityOrder.getTotalmoney()));
			if("03".equals(activityOrder.getPaytype())){
				isEnCard = true;
			}
			break;
		case 2://商品订单
			orderDiscountC.andStatusEqualTo(0);
			TGoodsOrder goodsOrder = goodsOrderMapper.selectByPrimaryKey(proId);
			TGoods goods = goodsMapper.selectByPrimaryKey(goodsOrder.getGid());
			result.put("orderName", goods.getGname());
			result.put("tableId", goods.getGoodsid());
			result.put("payStatus", formatePayStatus(goodsOrder.getPaystatus()));
			result.put("timeSpan", "");
			String[] comm = goodsOrder.getComm().split(" ");
			if(comm.length < 3){
				result.put("addr", "");
			}else{
				result.put("addr", comm[2]);
			}
			result.put("num", goodsOrder.getBuynum().toString());
			result.put("phone", goodsOrder.getMobilephonenum());
			result.put("memberName", tMemberMapper.selectByPrimaryKey(goodsOrder.getMemberid()).getNickname());
			logistics.put("name", goodsOrder.getShippername());
			logistics.put("phone", goodsOrder.getShipperphone());
			String addr = "";
			if(goodsOrder.getAddr().startsWith("收货地址:")){
				addr = goodsOrder.getAddr().split(":")[1];
			}else{
				addr = goodsOrder.getAddr();
			}
			logistics.put("addr", addr);
			if(goodsOrder.getExpressnum() == null || "".equals(goodsOrder.getExpressnum())){
				logistics.put("status", "未发货");
			}else{
				logistics.put("status", "已发货");
			}
			result.put("logistics", logistics);
			result.put("orderNumber", goodsOrder.getOrdernum());
			result.put("createDate", goodsOrder.getCreatedate());
			result.put("realMoney", formateMoney(goodsOrder.getTotalmoney()));
			result.put("totalMoney", formateMoney(goodsOrder.getTotalmoney()));
			if("03".equals(goodsOrder.getPaytype())){
				isEnCard = true;
			}
			break;
		case 3://私课订单
			orderDiscountC.andStatusEqualTo(2);
			TOrder order = orderMapper.selectByPrimaryKey(proId);
			TCoach coach = tCoachMapper.selectByPrimaryKey(order.getCoachid());
			TCoachStudioRefExample tCoachStudioRefExample = new TCoachStudioRefExample();
			tCoachStudioRefExample.createCriteria().andCoachidEqualTo(coach.getCoachid());
			List<TCoachStudioRef> coachStudioRefs = tStudioRefMapper.selectByExample(tCoachStudioRefExample);
			String studioName = "";
			if(coachStudioRefs.size() != 0){
				studioName = studioMapper.selectByPrimaryKey(coachStudioRefs.get(0).getStudioid()).getStudioname();
			}
			result.put("orderName", coach.getNickname());
			result.put("tableId", coach.getCoachid());
			result.put("payStatus", formatePayStatus(order.getPaystatus()));
			result.put("timeSpan", order.getClassdate()+" "+order.getTimespan());
			result.put("addr", studioName);
			result.put("num", "");
			result.put("phone", order.getMobilephonenum());
			result.put("memberName", tMemberMapper.selectByPrimaryKey(order.getMemberid()).getNickname());
			result.put("logistics", logistics);
			result.put("orderNumber", order.getOrdernum());
			result.put("createDate", order.getCreatedate());
			result.put("realMoney", formateMoney(order.getTotalmoney()));
			result.put("totalMoney", formateMoney(order.getTotalmoney()));
			if("03".equals(order.getPaytype())){
				isEnCard = true;
			}
			break;
		case 4://场馆订单
			orderDiscountC.andStatusEqualTo(1);
			TStudioConsumeOrderRecord studioOrder = studioConsumeOrderRecordMapper.selectByPrimaryKey(proId);
			TStudio studio = studioMapper.selectByPrimaryKey(studioOrder.getStudioid());
			result.put("orderName", studio.getStudioname());
			result.put("tableId", studio.getStudioid());
			result.put("payStatus", formatePayStatus(studioOrder.getPaystatus()));
			result.put("timeSpan", studioOrder.getCreatedate());
			result.put("addr", studio.getStudioaddr());
			result.put("num", "");
			result.put("phone", studioOrder.getMobilephonenum());
			result.put("memberName", tMemberMapper.selectByPrimaryKey(studioOrder.getMemberid()).getNickname());
			result.put("logistics", logistics);
			result.put("orderNumber", studioOrder.getOrdernum());
			result.put("createDate", studioOrder.getCreatedate());
			result.put("realMoney", formateMoney(studioOrder.getTotalmoney()));
			result.put("totalMoney", formateMoney(studioOrder.getTotalmoney()));
			if("03".equals(studioOrder.getPaytype())){
				isEnCard = true;
			}
			break;
		case 5://个人卡订单
			orderDiscountC.andStatusEqualTo(5);
			TMemberCardOrderRef cardOrder = tMemberCardOrderRefMapper.selectByPrimaryKey(proId);
			TCardType cardType = tcardTypeMapper.selectByPrimaryKey(cardOrder.getCardtypeid());
			TMember member = tMemberMapper.selectByPrimaryKey(cardOrder.getMemberid());
			result.put("orderName", cardType.getCardtypename());
			result.put("tableId", member.getMemberid());
			result.put("payStatus", formatePayStatus(Integer.parseInt(cardOrder.getPaystatus())));
			result.put("timeSpan", cardOrder.getExpiredate());
			result.put("addr", cardType.getAmount());
			result.put("num", cardOrder.getDiscount());
			result.put("phone", cardOrder.getMobilephonenum());
			result.put("memberName", tMemberMapper.selectByPrimaryKey(cardOrder.getMemberid()).getNickname());
			result.put("logistics", logistics);
			result.put("orderNumber", cardOrder.getOrdernum());
			result.put("createDate", cardOrder.getCreatedate());
			result.put("realMoney", formateMoney(cardOrder.getTotalmoney()));
			result.put("totalMoney", formateMoney(cardOrder.getTotalmoney()));
			if("03".equals(cardOrder.getPaytype())){
				isEnCard = true;
			}
			break;
		}
		//查询订单优惠信息
		List<TOrderDiscount> discountInfo = tOrderDiscountMapper.selectByExample(tOrderDiscountExample);
		if(discountInfo.size() != 0){
			TOrderDiscount discount = discountInfo.get(0);
			Double realMoney = discount.getOrderrealmoney();
			if(isEnCard && discount.getEnterprisecardsubnum()!= -1){
				//是否是企业卡支付 
				result.put("isEnterpriseCard", true);
				//实付金额
				result.put("realMoney", discount.getEnterprisecardsubnum().toString());
				//优惠金额
				result.put("discountMoney", "0");
				//总金额
				result.put("totalMoney", discount.getEnterprisecardsubnum().toString());
			}else{
				Double discountMoney = discount.getRedpackage() + discount.getSelfcard() + discount.getCoupon() + discount.getPayditch();
				result.put("isEnterpriseCard", false);
				result.put("realMoney", formateMoney(realMoney));
				result.put("discountMoney", formateMoney(discountMoney));
				result.put("totalMoney", formateMoney(realMoney + discountMoney));
			}
		}else{
			result.put("isEnterpriseCard", false);
			result.put("discountMoney", "0");
		}
		
		return result;
	}

	private static String formateMoney(Double Money){
		DecimalFormat  df   = new DecimalFormat("######0.00");
		return df.format(Money);
	}
	
	private String formatePayStatus(Integer payStatus){
		switch (payStatus) {
		case 0:
			return "待支付";
		case 1:
			return "已取消";
		case 2:
			return "已支付";
		case 3:
			return "退订中";
		case 4:
			return "已退订";
		case 5:
			return "已参加";
		case 6:
			return "未参加";
		default:
			return "";
		}
	}
	
	/*public static void main(String[] args) {
		System.out.println(formatePayStatus(3));
	}*/
}
