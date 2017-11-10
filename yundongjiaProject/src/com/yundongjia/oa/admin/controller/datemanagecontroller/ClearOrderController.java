/**
* @author HuangJian
* @date 2017年2月28日
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.ClearOrderService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.vo.ClearOrderSearchVo;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.UtilPage;

@Controller
public class ClearOrderController extends BaseController{

	@Autowired
	private ClearOrderService clearOrderService;
	@Autowired
	private OpeartionService opeartionService;
	public PageInfo<Map<String, Object>> pageInfo;
	List<Map<String, Object>> result;
	List<Map<String, Object>> pageList;
	Map<String, Object> param;
	/**
	* Title: clearOrderList
	* Description: 结算列表
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	@RequestMapping("/yundongjia/clearorderlist")
	public String clearOrderList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize){
		pageInfo=new PageInfo<>();
		pageList=new ArrayList<>();
		ClearOrderSearchVo vo=new ClearOrderSearchVo();
		
		result =  clearOrderService.findClearOrderList(vo);
		
		
		UtilPage page =new UtilPage(pageSize, result.size(), pageNum);
		if(result.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				pageList.add(result.get(i));
			}
		}
		pageInfo.setList(pageList);
		pageInfo.setTotal(result.size());
		pageInfo.setPageNum(pageNum);
		pageInfo.setPageSize(pageSize);
		pageInfo.setPages(page.getPageCount());
		
		
		Map<String, Object> statis =  clearOrderService.selectClearOrderStatis();
		
		
		model.addAttribute("os", pageInfo);
		model.addAttribute("statis", statis);
		return "/systemmanage/finance/clearinglist";
	}
	
	/**
	* Title: clearOrderDetail
	* Description: 结算订单详情
	* @param orderId  订单ID
	* @param orderType  0商城 1场馆 2私课 3课程 4活动
	* @param studioId 场馆ID
	* @param supplierId 供应商ID
	* @return
	* @author HuangJian
	* @date 2017年3月1日
	*/
	@RequestMapping("/yundongjia/clearorderdetail")
	public String clearOrderDetail(Model model,Integer orderId,Integer orderType,Integer studioId,Integer supplierId){
		
		param=new HashMap<>();
		param.put("orderId", orderId);
		param.put("orderType", orderType);
		param.put("studioId", studioId);
		param.put("supplierId", supplierId);
		
		model.addAttribute("c", clearOrderService.getClearOrderByOrderId(param));
		
		List<Map<String, Object>> ops = opeartionService.findOpeartion(ConstantVo.TYPE_CLEAR, orderId);
		
		model.addAttribute("ops", ops);
		return "/systemmanage/finance/clearingdetail";
	}
	
	
	  
	/**
	* Title: clearOrderSearch
	* Description: 多条件查询
	* @param model
	* @param pageNum
	* @param pageSize
	* @param vo 查询对象
	* @return
	* @author HuangJian
	* @date 2017年3月1日
	*/
	@RequestMapping("/yundongjia/selectclearorderby")
	@ResponseBody
	public String clearOrderSearch(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize,ClearOrderSearchVo vo){
		pageList = new ArrayList<>();
		pageInfo=new PageInfo<>();
		if(null != vo.getSupplierName() && !"".equals(vo.getSupplierName())){
			vo.setSupplierName("%"+vo.getSupplierName()+"%");
		}
		if(null != vo.getContextName() && !"".equals(vo.getContextName())){
			vo.setContextName("%"+vo.getContextName()+"%");
		}
		
		if(!"".equals(vo.getStartTime()) && null != vo.getStartTime()){
			vo.setStartTime(vo.getEndTime()+" 00:00:00");
		}
		if(!"".equals(vo.getEndTime()) && null != vo.getEndTime()){
			vo.setEndTime(vo.getEndTime()+" 59:59:59");
		}
		result = clearOrderService.findClearOrderList(vo);
		UtilPage page=new UtilPage(pageSize, result.size(), pageNum);
		if(result.size() > 0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				pageList.add(result.get(i));
			}
		}
		 
		pageInfo.setList(pageList);
		pageInfo.setPageSize(pageSize);
		pageInfo.setPageNum(pageNum);
		pageInfo.setTotal(result.size());
		pageInfo.setPages(page.getPageCount());
		return new Gson().toJson(pageInfo);
	}
	
	/**
	* Title: updateClearOrderAccout
	* Description: 确定计算
	* @param orderId  订单ID  orderTypeId:0 商城ID  orderTypeId:1场馆ID orderTypeId:2私教（教练）ID
	* @param supplierId  供应商ID
	* @param orderTypeId 订单类型 0商城 1场馆 2私课 3课程 4活动(供应商只涉及到 场馆，私课，商城)
	* @return
	* @author HuangJian
	* @date 2017年3月3日
	*/
	@RequestMapping("/yundongjia/upaccount")
	@ResponseBody
	public String updateClearOrderAccout(Integer orderId,Integer supplierId,Integer orderTypeId,Integer status){
		param=new HashMap<>();
		param.put("supplierId", supplierId);
		param.put("orderId", orderId);
		param.put("orderTypeId", orderTypeId);
		param.put("status", status);
		Map<String, Object> map = clearOrderService.updateUpAccount(param);
		
		TOpeartion op=new TOpeartion();
		op.setOpeartionAdminId(this.getLogUserId());
		op.setOpeartionById(orderId);
		if(7 == status){
			op.setOpeartionInfo("确定结算");
			op.setOpeartionCom("供应商:"+map.get("supplierName")+" 结算 "+map.get("orderTypeName")+"订单 "+map.get("eoffFormat")+"元  结算结果:"+map.get("message"));
		}
		op.setOpeartionType(ConstantVo.TYPE_CLEAR);
		
		opeartionService.saveOpeartion(op);
		return new Gson().toJson(map);
	}
	
}

