/**
* @author HuangJian
* @date 2017年1月18日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.service.OrderService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.vo.OrderSearchVo;
import com.yundongjia.oa.utils.UtilPage;
@Controller
public class OrderController extends BaseController{

	@Autowired
	private OrderService orderService;
	@Autowired
	private OpeartionService opeartionService;
	
	public PageInfo<Map<String, Object>> mapPageInfo;//返回结果
	
	public List<Map<String, Object>> mapList;//全部结果
	/**
	* Title: findOrderList
	* Description: 订单列表
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年1月19日
	*/
	@RequestMapping("/yundongjia/listorder")
	public String findOrderList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		mapPageInfo = new PageInfo<>();
		OrderSearchVo vo = new OrderSearchVo();
		vo.setOrderMenuType(ConstantVo.ORDER_MENU_TYPE_NUM0);
		mapList =  orderService.findOrderList(vo);
		
		List<Map<String, Object>> mapPage=new ArrayList<>();
		
		UtilPage page =new UtilPage(pageSize, mapList.size(), pageNum);
		if(mapList.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				mapPage.add(mapList.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(mapList.size());
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setPageSize(pageSize);
		mapPageInfo.setPages(page.getPageCount());
		
		Map<String, Object> statis = orderService.selectStatisOrder();
		model.addAttribute("orders", mapPageInfo);
		model.addAttribute("statis", statis);
		return "/systemmanage/order/orderlist";
	}
	
	 
	/**
	* Title: getOrderById
	* Description: 去订单详情页
	* @param orderId  订单ID
	* @param orderType  订单类型  0商城 1场馆 2私课 3课程 4活动 5 个人卡
	* @param nav  导航区别
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	@RequestMapping("/yundongjia/getorderbyid")
	public String getOrderById(Model model,Integer orderId,Integer orderType,@RequestParam(defaultValue="0") Integer nav , Integer cardtypeid , Integer cardid , Integer userId){
		
		Map<String, Object> mess =  orderService.selectOrdersByOrderId(orderId, orderType);
		
		String typeName="";
		switch (orderType) {
		case 0:
			typeName="商城";
			break;
		case 1:
			
			typeName="场馆";
			break;
		case 2:
			typeName="私课";
			break;
		case 3:
			typeName="团课";
			break;
		case 4:
			typeName="活动";
			break;
		case 5:
			typeName="个人卡";
			break;
		default:
			break;
		}
		
		List<Map<String, Object>> ops =  opeartionService.findOrderOpeartionById(orderId, typeName, ConstantVo.TYPE_ORDER);
		if(orderType != 4){
			if(mess !=null){
				mess.put("activityId", -1);
			}
		}
		model.addAttribute("o", mess);
		model.addAttribute("ops", ops);
		model.addAttribute("nav", nav);
		
		Map<String , Object> param = new HashMap<String , Object>();
		if(cardtypeid != null){
			param.put("cardtypeid", cardtypeid);
		}
		if(cardid != null){
			param.put("cardid", cardid);
		}
		if(userId != null){
			param.put("userId", userId);
		}
		model.addAttribute("param", param);
		return "/systemmanage/order/detail";
	}
	
	/**
	* Title: selectOrdersBy
	* Description: 订单多条件查询
	* @param orderSearch
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	@RequestMapping("/yundongjia/selectOrderByOrder")
	@ResponseBody
	public String selectOrdersBy(OrderSearchVo orderSearch,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		orderSearch.setOrderMenuType(ConstantVo.ORDER_MENU_TYPE_NUM0);
		mapList = orderService.selectOrdersByOrder(orderSearch);
		
		List<Map<String, Object>> mapPage=new ArrayList<>();
		
		UtilPage page =new UtilPage(pageSize, mapList.size(), pageNum);
		if(mapList.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				mapPage.add(mapList.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(mapList.size());
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setPageSize(pageSize);
		mapPageInfo.setPages(page.getPageCount());
		
		
		return new Gson().toJson(mapPageInfo);
	}
	
	/**
	* Title: updateOrderStatus
	* Description: 修改订单状态-----orderId时间戳
	* @param orderId 订单ID
	* @param typeName 订单类型   商城，场馆，私课，课程，活动，个人卡
	* @param status 订单状态
	* @param comm  理由
	* @return
	* @author HuangJian
	* @date 2017年2月9日
	*/
	@RequestMapping("/yundongjia/updateorderstatus")
	@ResponseBody
	public String updateOrderStatus(Integer orderId,String typeName,Integer status,@RequestParam(defaultValue="",required=true) String comm){
		
		Integer result = orderService.updateOrderStatus(orderId, typeName, status);
		
		TOpeartion op =new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(orderId);
		op.setOpeartionType(ConstantVo.TYPE_ORDER);
		switch (status) {
		case 0:
			op.setOpeartionInfo("待支付");
			break;
		case 1:
			op.setOpeartionInfo("取消");
			
			break;
		case 2://取消退订---》删除退订日期
			op.setOpeartionInfo("支付");
			
			break;
		case 3://退订---》修改退订日期
			op.setOpeartionInfo("退订");
			break;
		case 4:
			op.setOpeartionInfo("退订完成");
			break;
		case 5:
			op.setOpeartionInfo("已完成");
			break;

		default:
			break;
		}
		
		
		
		op.setOpeartionCom(comm+"-"+typeName);
		opeartionService.saveOpeartion(op);
		
		return new Gson().toJson(result);
	}
	
	
	/**
	 * -------------------财务-退订列表
	 */
	
	@RequestMapping("/yundongjia/unsuborderlist")
	public String unSubOrderList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		mapPageInfo = new PageInfo<>();
		OrderSearchVo vo = new OrderSearchVo();
		vo.setOrderMenuType(ConstantVo.ORDER_MENU_TYPE_UNSUB);
		mapList =  orderService.findOrderList(vo);
		
		List<Map<String, Object>> mapPage=new ArrayList<>();
		
		UtilPage page =new UtilPage(pageSize, mapList.size(), pageNum);
		if(mapList.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				mapPage.add(mapList.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(mapList.size());
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setPageSize(pageSize);
		mapPageInfo.setPages(page.getPageCount());
		
		Map<String, Object> statis = orderService.selectStatisOrder();
		model.addAttribute("orders", mapPageInfo);
		model.addAttribute("statis", statis);
		return "/systemmanage/finance/unsuborderlist";
	}
	
	/**
	* Title: selectUnSubOrder
	* Description: 退订 订单多条件查询
	* @param orderSearchVo
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月11日
	*/
	@RequestMapping("/yundongjia/selectUnsubOrderByOrder")
	@ResponseBody
	public String selectUnSubOrder(OrderSearchVo orderSearchVo,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		
		
		orderSearchVo.setOrderMenuType(ConstantVo.ORDER_MENU_TYPE_UNSUB);
		mapList = orderService.selectOrdersByOrder(orderSearchVo);
		
		List<Map<String, Object>> mapPage=new ArrayList<>();
		
		UtilPage page =new UtilPage(pageSize, mapList.size(), pageNum);
		if(mapList.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				mapPage.add(mapList.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(mapList.size());
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setPageSize(pageSize);
		mapPageInfo.setPages(page.getPageCount());
		
		return new Gson().toJson(mapPageInfo);
	}
	
	/**
	* Title: sendOrderMessage
	* Description: 手动发送短信
	* @param orderType 订单类型
	* @param orderId 订单ID
	* @return
	* @author HuangJian
	* @date 2017年3月21日
	*/
	@RequestMapping(value="/yundongjia/sendordermessage",method=RequestMethod.POST)
	@ResponseBody
	public String sendOrderMessage(Integer orderType,Integer orderId){
		Map<String, Object> map=new HashMap<>();
		 
		map=orderService.sendMessageByType(orderType, orderId);
		
		return new Gson().toJson(map);
	}
}

