package com.yundongjia.app.user.controller.usercontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.yundongjia.app.user.service.AppStudioService;
import com.yundongjia.app.user.service.MyOrderService;

@Controller
public class ShareController {
	@Autowired
	private MyOrderService myOrderService;
	@Autowired
	private AppStudioService appStudioService;
	/**
	 * @param orderType 订单类型     1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
	 * @param proId 订单ID
	 * 订单详情
	 */
	@RequestMapping("/ydj/share/OrderDetail")
	public String myorderDetail(Integer orderType , Integer proId , WebRequest request) {
		Map<String, Object> result = new HashMap<String , Object>();
		Map<String, Object> order = new HashMap<String , Object>();
		try {
			order = myOrderService.findOrderById(orderType , proId);
			String phone = order.get("phone").toString();
			phone = phone.substring(0, 3) + "****" + phone.substring(7, 11);
			order.put("createDate", order.get("createDate").toString().split(" ")[0]);
			order.put("phone", phone);
			result.put("order", order);
			result.put("status", "0");
			result.put("message", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("order", order);
			result.put("status", "1");
			result.put("message", "查询失败");
		}
		request.setAttribute("orderDetail", result, request.SCOPE_REQUEST);
		request.setAttribute("orderType", orderType, request.SCOPE_REQUEST);
		return "/share/orderDetail";
	}
	
	@RequestMapping("/ydj/share/overSportShare")
	public String overSportShare(Integer orderType , Integer memberId , WebRequest request){
		Map<String , Object> result = new HashMap<String , Object>();
		try {
			result =  appStudioService.findOverSportShareInfo(orderType , memberId);
			result.put("status", "0");
			result.put("message", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "1");
			result.put("message", "请求失败");
		}
		request.setAttribute("info", result, request.SCOPE_REQUEST);
		return "/share/overSportShare";
	}
	
}
