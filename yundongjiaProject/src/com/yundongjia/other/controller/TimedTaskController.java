package com.yundongjia.other.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yundongjia.app.user.service.PayOrderService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.other.service.TimedTaskService;


@Controller
public class TimedTaskController extends BaseController{
	@Autowired
	private TimedTaskService timedTaskService;
	@Autowired
	private PayOrderService payOrderService;
	
	/**
	 * @param orderId 订ID
	 * @param orderType 订单类型  1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
	 * 
	 * 每5分钟执行一次
	 */
	public void insertSignDeduction(){
		List<Map<String, Object>> order = timedTaskService.selectOverTimeOrder();
		for (Map<String, Object> or : order) {
			payOrderService.updateCancelOrder((Integer)or.get("orderType") ,(Integer)or.get("orderId"));
		}
		
	}
	
	

	/**
	 * 每天凌晨十二點時查詢請假結束日期 ， 會員卡到期日期， 會員卡規格是否到期并更新狀態
	 * LI XiaoYang 2016.12.07
	 */
	public void updateEndDate(){
		
	}
	
	
}
