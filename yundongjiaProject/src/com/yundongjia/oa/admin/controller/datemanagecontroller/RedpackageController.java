package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TRedpackage;
import com.yundongjia.oa.admin.service.RedpackageService;
import com.yundongjia.oa.admin.vo.OrderSearchVo;
import com.yundongjia.oa.utils.UtilPage;

@Controller
public class RedpackageController extends BaseController{
	@Resource
	private RedpackageService redpackageService;
	
	/**
	 * @param request
	 * @return跳转到红包列表页面
	 */
	@RequestMapping("/yundongjia/redpackagelist")
	public String redpackagelist(WebRequest request , Integer page ,  Integer status){
		Map moneyCount = redpackageService.redpackageMoneyCount();
		if(page==null || page == 0){
    		page = 1;
    	}
		if(status == null || status == 0){
			PageHelper.startPage(page, super.PAGE_ROW);
		}else{
			PageHelper.startPage(1, super.PAGE_ROW);
		}
		List<TRedpackage> sendRedpackage = redpackageService.sendRedpackage();
		PageInfo<TRedpackage> pi1 = new PageInfo<TRedpackage>(sendRedpackage);
		request.setAttribute("sendRedpackage", pi1, request.SCOPE_REQUEST);
		if( status==null || status == 2){
			PageHelper.startPage(page, super.PAGE_ROW);
		}else{
			PageHelper.startPage(1, super.PAGE_ROW);
		}
		List<Map> pastRedpackage = redpackageService.pastRedpackage();
		PageInfo<Map> pi2 = new PageInfo<Map>(pastRedpackage);
		request.setAttribute("pastRedpackage", pi2, request.SCOPE_REQUEST);
		if( status==null || status == 3){
			page = 1;
		}
		PageInfo mapPageInfo = new PageInfo<>();
		OrderSearchVo vo = new OrderSearchVo();
		Map map =   redpackageService.findOrderList();
		List result =(List) map.get("list");
		List mapPage=new ArrayList();
		
		UtilPage utilPage =new UtilPage(super.PAGE_ROW , result.size(), page);
		if(result.size() >0 && page <= utilPage.getCurrentPage()){
			for(int i=utilPage.getFromIndex();i<utilPage.getToIndex();i++){
				mapPage.add(result.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(result.size());
		mapPageInfo.setPageNum(page);
		mapPageInfo.setPageSize(super.PAGE_ROW );
		mapPageInfo.setPages(utilPage.getPageCount());
		request.setAttribute("order", mapPageInfo, request.SCOPE_REQUEST); 
		request.setAttribute("orderMoney", map.get("orderMoney"), request.SCOPE_REQUEST); 
		if(status == null){
			status = 0;
		}
		request.setAttribute("status", status, request.SCOPE_REQUEST);
		request.setAttribute("moneyCount", moneyCount, request.SCOPE_REQUEST);
		return "systemmanage/redpackage/redpackage";
	}
	
	/**
	 * @param request
	 * @return根据日期查询红包发放金额 使用金额 过期金额
	 */
	@RequestMapping("/yundongjia/searchRedPackage")
	@ResponseBody
	public String searchRedPackage(String startTime , String endTime){
		Map moneyCount = redpackageService.redpackageMoneyCount(startTime , endTime);
		return new Gson().toJson(moneyCount);
	}
	
	/**
	 * @param request
	 * @return根据手机号查询红包发放金额 使用金额 过期金额
	 */
	@RequestMapping("/yundongjia/searchPast")
	public String searchPast(WebRequest request , Integer page ,String info){
		Map moneyCount = redpackageService.redpackageMoneyCount(null , null);
		if(page==null || page == 0){
    		page = 1;
    	}
		PageHelper.startPage(1, super.PAGE_ROW);
		List<TRedpackage> sendRedpackage = redpackageService.sendRedpackage();
		PageInfo<TRedpackage> pi1 = new PageInfo<TRedpackage>(sendRedpackage);
		request.setAttribute("sendRedpackage", pi1, request.SCOPE_REQUEST);
		PageHelper.startPage(page, super.PAGE_ROW);
		List<Map> pastRedpackage = redpackageService.pastRedpackage(info);
		PageInfo<Map> pi2 = new PageInfo<Map>(pastRedpackage);
		page = 1;
		PageInfo mapPageInfo = new PageInfo<>();
		OrderSearchVo vo = new OrderSearchVo();
		Map map =   redpackageService.findOrderList();
		List result =(List) map.get("list");
		List mapPage=new ArrayList();
		
		UtilPage utilPage =new UtilPage(super.PAGE_ROW , result.size(), page);
		if(result.size() >0 && page <= utilPage.getCurrentPage()){
			for(int i=utilPage.getFromIndex();i<utilPage.getToIndex();i++){
				mapPage.add(result.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(result.size());
		mapPageInfo.setPageNum(page);
		mapPageInfo.setPageSize(super.PAGE_ROW );
		mapPageInfo.setPages(utilPage.getPageCount());
		request.setAttribute("order", mapPageInfo, request.SCOPE_REQUEST); 
		request.setAttribute("orderMoney", map.get("orderMoney"), request.SCOPE_REQUEST); 
		request.setAttribute("pastRedpackage", pi2, request.SCOPE_REQUEST);
		request.setAttribute("status", 4, request.SCOPE_REQUEST);
		request.setAttribute("info", info, request.SCOPE_REQUEST);
		request.setAttribute("moneyCount", moneyCount, request.SCOPE_REQUEST);
		return "systemmanage/redpackage/redpackage";
	}
	
	/**
	 * @param request
	 * @return根据手机号查询订单
	 */
	@RequestMapping("/yundongjia/searchRedOrder")
	public String searchRedOrder(WebRequest request , Integer page ,String info){
		Map moneyCount = redpackageService.redpackageMoneyCount(null , null);
		if(page==null || page == 0){
    		page = 1;
    	}
		PageHelper.startPage(1, super.PAGE_ROW);
		List<TRedpackage> sendRedpackage = redpackageService.sendRedpackage();
		PageInfo<TRedpackage> pi1 = new PageInfo<TRedpackage>(sendRedpackage);
		request.setAttribute("sendRedpackage", pi1, request.SCOPE_REQUEST);
		PageHelper.startPage(1, super.PAGE_ROW);
		List<Map> pastRedpackage = redpackageService.pastRedpackage(info);
		PageInfo<Map> pi2 = new PageInfo<Map>(pastRedpackage);
		
		PageInfo mapPageInfo = new PageInfo<>();
		OrderSearchVo vo = new OrderSearchVo();
		Map map =   redpackageService.findOrderList(info);
		List result =(List) map.get("list");
		List mapPage=new ArrayList();
		
		UtilPage utilPage =new UtilPage(super.PAGE_ROW , result.size(), page);
		if(result.size() >0 && page <= utilPage.getCurrentPage()){
			for(int i=utilPage.getFromIndex();i<utilPage.getToIndex();i++){
				mapPage.add(result.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(result.size());
		mapPageInfo.setPageNum(page);
		mapPageInfo.setPageSize(super.PAGE_ROW );
		mapPageInfo.setPages(utilPage.getPageCount());
		request.setAttribute("order", mapPageInfo, request.SCOPE_REQUEST); 
		request.setAttribute("orderMoney", map.get("orderMoney"), request.SCOPE_REQUEST); 
		request.setAttribute("pastRedpackage", pi2, request.SCOPE_REQUEST);
		request.setAttribute("status", 3, request.SCOPE_REQUEST);
		request.setAttribute("info", info, request.SCOPE_REQUEST);
		request.setAttribute("moneyCount", moneyCount, request.SCOPE_REQUEST);
		return "systemmanage/redpackage/redpackage";
	}
}
