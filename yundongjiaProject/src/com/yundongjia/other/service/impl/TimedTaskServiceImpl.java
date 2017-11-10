package com.yundongjia.other.service.impl;

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
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.other.service.TimedTaskService;

@Service
public class TimedTaskServiceImpl implements TimedTaskService{
	@Autowired
	private TActivityOrderMapper tActivityOrderMapper;
	@Autowired
	private TGoodsOrderMapper tGoodsOrderMapper;
	@Autowired
	private TOrderMapper tOrderMapper;
	@Autowired
	private TMemberCardOrderRefMapper tMemberCardOrderRefMapper;
	@Autowired
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	private SimpleDateFormat sim;
	
	//查询超过十五分钟未支付的订单
	@Override
	public List<Map<String, Object>> selectOverTimeOrder() {
		sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//orderType 订单类型  1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
		List<Map<String, Object>> list = new ArrayList<Map<String , Object>>();
		//查询可取消的活动订单 1
		TActivityOrderExample tActivityOrderExample = new TActivityOrderExample();
		tActivityOrderExample.createCriteria().andPaystatusEqualTo("0");
		List<TActivityOrder> activeList = tActivityOrderMapper.selectByExample(tActivityOrderExample);
		for (TActivityOrder order : activeList) {
			Map<String, Object> map = new HashMap<String , Object>();
			try {
				if(order.getCreatedate()!=null && judgeIsTimeover(order.getCreatedate(), 15)){
					map.put("orderType", 1);
					map.put("orderId", order.getOrderid());
					list.add(map);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//查询可取消的商品订单2
		TGoodsOrderExample tGoodsOrderExample = new TGoodsOrderExample();
		tGoodsOrderExample.createCriteria().andPaystatusEqualTo(0);
		List<TGoodsOrder> goods = tGoodsOrderMapper.selectByExample(tGoodsOrderExample);
		for (TGoodsOrder order : goods) {
			Map<String, Object> map = new HashMap<String , Object>();
			try {
				if(order.getCreatedate()!=null && judgeIsTimeover(order.getCreatedate(), 15)){
					map.put("orderType", 2);
					map.put("orderId", order.getOrderid());
					list.add(map);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		//查询可取消的私课订单3
		TOrderExample tOrderExample = new TOrderExample();
		tOrderExample.createCriteria().andPaystatusEqualTo(0);
		List<TOrder> privateOrder = tOrderMapper.selectByExample(tOrderExample);
		for (TOrder order : privateOrder) {
			Map<String, Object> map = new HashMap<String , Object>();
			try {
				if(order.getCreatedate()!=null && judgeIsTimeover(order.getCreatedate(), 15)){
					map.put("orderType", 3);
					map.put("orderId", order.getOrderid());
					list.add(map);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		//查询可取消的场馆订单4
		TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
		tStudioConsumeOrderRecordExample.createCriteria().andPaystatusEqualTo(0);
		List<TStudioConsumeOrderRecord> studio = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
		for (TStudioConsumeOrderRecord order : studio) {
			Map<String, Object> map = new HashMap<String , Object>();
			try {
				if(order.getCreatedate()!=null && judgeIsTimeover(order.getCreatedate(), 15)){
					map.put("orderType", 4);
					map.put("orderId", order.getOrderid());
					list.add(map);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//查询可取消的场馆订单5
		TMemberCardOrderRefExample tMemberCardOrderRefExample = new TMemberCardOrderRefExample();
		tMemberCardOrderRefExample.createCriteria().andPaystatusEqualTo("0");
		List<TMemberCardOrderRef> memberCard = tMemberCardOrderRefMapper.selectByExample(tMemberCardOrderRefExample);
		for (TMemberCardOrderRef order : memberCard) {
			Map<String, Object> map = new HashMap<String , Object>();
			try {
				if(order.getCreatedate()!=null && judgeIsTimeover(order.getCreatedate(), 15)){
					map.put("orderType", 5);
					map.put("orderId", order.getOrderid());
					list.add(map);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	/**
	 * @return判断订单是否超时
	 */
	private Boolean judgeIsTimeover(String createDate , Integer minute) throws ParseException{
		Long timeoverDate = sim.parse(createDate).getTime() + (minute * 60000);
		Long nowDate = new Date().getTime();
		if(timeoverDate <=nowDate){
			return  true;
		}else{
			return false;
		}
	}
	
}
