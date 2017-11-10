package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.InsertElementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TApplyAccount;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TSavemoney;
import com.yundongjia.oa.admin.po.TSupplier;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.service.RegionsService;
import com.yundongjia.oa.admin.service.SupplierService;

@Controller
public class SupplierController extends BaseController {
	@Autowired
	private RegionsService regionsService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private OpeartionService opeartionService;
	
	@RequestMapping("/yundongjia/linkedAddSupplier")
	public String linkedAddSupplier(Model model){
		// 加载省
		List<TRegions> listPro = regionsService.geTRegionsByProvince();
		model.addAttribute("pros", listPro);
		return "/systemmanage/supplier/addSupplier";
	}
	
	@RequestMapping("/yundongjia/findNoBandStudioList")
	@ResponseBody
	public String findNoBandStudioList(Integer pageNum , String searchInfo){
		if(pageNum == null || pageNum == 0){
			pageNum = 1;
		}
		 Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			PageInfo<Map<String,Object>> pi = supplierService.findNoBandStudioList(PAGE_ROW_5 , pageNum , searchInfo);
			resultMap.put("pi", pi);
			resultMap.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", false);
			resultMap.put("message", "请求场馆列表失败！");
		}
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping("/yundongjia/findNoBandCoach")
	@ResponseBody
	public String findNoBandCoach(Integer pageNum , String searchInfo){
		if(pageNum == null || pageNum == 0){
			pageNum = 1;
		}
		 Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			PageInfo<Map<String,Object>> pi = supplierService.findNoBandCoach(PAGE_ROW_5 , pageNum , searchInfo);
			resultMap.put("pi", pi);
			resultMap.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", false);
			resultMap.put("message", "请求教练列表失败！");
		}
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping("/yundongjia/findNoBandGoods")
	@ResponseBody
	public String findNoBandGoods(Integer pageNum , String searchInfo){
		if(pageNum == null || pageNum == 0){
			pageNum = 1;
		}
		 Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			PageInfo<Map<String,Object>> pi = supplierService.findNoBandGoods(PAGE_ROW_5 , pageNum , searchInfo);
			resultMap.put("pi", pi);
			resultMap.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("result", false);
			resultMap.put("message", "请求商品列表失败！");
		}
		
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping("/yundongjia/insertSupplier")
	@ResponseBody
	public String insertSupplier(TSupplier tSupplier , Integer[] studioId , Double[] studioPrice ,Integer[] coachId , Double[] coachPrice, Integer[] goodsId , Double[] goodsPrice){
		tSupplier.setSupersavemoney(tSupplier.getSavemoney());
		if(tSupplier.getClearingtype() == 1){
			tSupplier.setSavemoney(0d);
			tSupplier.setSupersavemoney(0d);
			tSupplier.setSavemoneyexpiredate(null);
		}
		
		tSupplier.setStatus(3);
		if(studioId == null || studioId.length == 0){
			tSupplier.setLinkstudioid("0");
			tSupplier.setLikestudiocostprice("0");
		}else{
			String studioIdstr =""; 
			String studioPricestr ="";
			for (int i = 0; i < studioId.length; i++) {
				if(i == studioId.length -1){
					studioIdstr = studioIdstr + studioId[i];
					studioPricestr = studioPricestr + studioPrice[i];
				}else {
					studioIdstr = studioIdstr + studioId[i] + ",";
					studioPricestr = studioPricestr + studioPrice[i] + ",";
				}
			}
			tSupplier.setLinkstudioid(studioIdstr);
			tSupplier.setLikestudiocostprice(studioPricestr);
		}
		
		if(goodsId == null || goodsId.length == 0){
			tSupplier.setLinkgoodsid("0");
			tSupplier.setLikegoodscostprice("0");
		}else{
			String goodsIdstr =""; 
			String goodsPricestr ="";
			for (int i = 0; i < goodsId.length; i++) {
				if(i == goodsId.length -1){
					goodsIdstr = goodsIdstr + goodsId[i];
					goodsPricestr = goodsPricestr + goodsPrice[i];
				}else {
					goodsIdstr = goodsIdstr + coachId[i] + ",";
					goodsPricestr = goodsPricestr + goodsPrice[i] + ",";
				}
			}
			tSupplier.setLinkgoodsid(goodsIdstr);
			tSupplier.setLikegoodscostprice(goodsPricestr);
		}
		
		if(coachId == null || coachId.length == 0){
			tSupplier.setLinkcoachid("0");
			tSupplier.setLikecoachcostprice("0");
		}else{
			String coachIdstr =""; 
			String coachPricestr ="";
			for (int i = 0; i < coachId.length; i++) {
				if(i == coachId.length -1){
					coachIdstr = coachIdstr + coachId[i];
					coachPricestr = coachPricestr + coachPrice[i];
				}else {
					coachIdstr = coachIdstr + coachId[i] + ",";
					coachPricestr = coachPricestr + coachPrice[i] + ",";
				}
			}
			tSupplier.setLinkcoachid(coachIdstr);
			tSupplier.setLikecoachcostprice(coachPricestr);
		}
		Integer supplierLoginId = supplierService.insertSupplierLogin(tSupplier.getMobilephonenum());
		 Map<String,Object> resultMap = new HashMap<String,Object>();
		if(supplierLoginId > 0){
			tSupplier.setSupplierloginid(supplierLoginId);
			Integer result = 0;
			if(tSupplier.getRowid() != null && tSupplier.getRowid() !=  0){
				result = supplierService.updateSupplier(tSupplier);
				resultMap.put("message", "供应商信息更新成功,请使用输入的手机号登陆供应商端");
			}else{
				result = supplierService.insertSupplier(tSupplier);
				resultMap.put("message", "供应商信息保存成功,请使用输入的手机号登陆供应商端");
			}
			
			if(result > 0){
				TOpeartion o = new TOpeartion();
				o.setOpeartionAdminId(this.getLogUserId());
				o.setOpeartionById(result);
				o.setOpeartionType(20);
				o.setOpeartionInfo("创建供应商");
				opeartionService.saveOpeartion(o);
				resultMap.put("rowId", result);
				resultMap.put("result", true);
				
			}else if(result == -1 ){
				resultMap.put("result", false);
				resultMap.put("message", "系统异常，请联系管理员");
			}else{
				resultMap.put("result", false);
				resultMap.put("message", "供应商信息保存失败");
				if(tSupplier.getRowid() != null && tSupplier.getRowid() !=  0){
					resultMap.put("message", "供应商信息更新失败");
				}
			}
		}else{
			resultMap.put("result", false);
			resultMap.put("message", "供应商信息保存失败");
			if(tSupplier.getRowid() != null && tSupplier.getRowid() !=  0){
				resultMap.put("message", "供应商信息更新失败");
			}
		}
		return new Gson().toJson(resultMap);
	}
	
	@RequestMapping("/yundongjia/linkedSupplierList")
	public String linkedSupplierList(Integer nav , Integer page , Integer status , String supplierName , WebRequest request){
		if(page == null || page == 0){
			page = 1;
		}
		PageInfo<TSupplier> pi =  supplierService.findSupplierList(status , supplierName , page , super.PAGE_ROW);
		Map<String , Object> supplierStatus = supplierService.findStatistics();
		if(nav != null){
			request.setAttribute("nav", 1, request.SCOPE_REQUEST);
		}else{
			request.setAttribute("nav", 0, request.SCOPE_REQUEST);
		}
		request.setAttribute("status", status, request.SCOPE_REQUEST);
		request.setAttribute("supplierName", supplierName, request.SCOPE_REQUEST);
		request.setAttribute("info", pi, request.SCOPE_REQUEST);
		request.setAttribute("supplierStatus", supplierStatus, request.SCOPE_REQUEST);
		return "/systemmanage/supplier/supplierList";
	}
	
	
	@RequestMapping("/yundongjia/supplierStatus")
	@ResponseBody
	public String supplierStatus(Integer status , Integer rowId , String comm){
		Map<String , Object> result = supplierService.supplierStatus(status , rowId , comm);
		if((boolean) result.get("result")){
			TOpeartion o = new TOpeartion();
			o.setOpeartionAdminId(this.getLogUserId());
			o.setOpeartionById(rowId);
			o.setOpeartionType(20);
			switch (status) {
			case 1:
				o.setOpeartionInfo("更新供应商状态---禁用      理由："+comm);
				break;
			case 0:
				o.setOpeartionInfo("更新供应商状态---启用      理由："+comm);
				break;
			}
			opeartionService.saveOpeartion(o);
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/yundongjia/supplierDetail")
	public String supplierDetail(Integer tab , Integer id , WebRequest request){
		TSupplier tSupplier = supplierService.findSupplierDetail(id);
		request.setAttribute("supplier", tSupplier , request.SCOPE_REQUEST);
		request.setAttribute("tab", tab, request.SCOPE_REQUEST);
		//更新供应商
		if(tab == -1){
			// 加载省
			List<TRegions> listPro = regionsService.geTRegionsByProvince();
			request.setAttribute("pros", listPro , request.SCOPE_REQUEST);
			TRegions city = supplierService.findCityByArea(tSupplier.getRegionsid());
			request.setAttribute("city", city , request.SCOPE_REQUEST);
			TRegions area = supplierService.findArea(tSupplier.getRegionsid());
			request.setAttribute("area", area , request.SCOPE_REQUEST);
			tSupplier.setRegionsid(city.getpCode());
			return  "/systemmanage/supplier/addSupplier";
		}
		//预付
		if(tSupplier.getClearingtype() == 0){
			List<Map<String , Object>> savemoney =   supplierService.findSavemoneyInfo(tSupplier.getRowid());
			request.setAttribute("savemoney", savemoney , request.SCOPE_REQUEST);
		//周期结算
		}else{
			List<TApply> apply = supplierService.findApplyInfo(tSupplier.getRowid());
			request.setAttribute("apply", apply , request.SCOPE_REQUEST);
		}
		List<TApplyAccount> accounts = supplierService.finAccount(tSupplier.getRowid());
		request.setAttribute("accounts", accounts , request.SCOPE_REQUEST);
		List<Map<String, Object>> clearingOrder = supplierService.findClearingOrderInfo(id);
		request.setAttribute("order", clearingOrder , request.SCOPE_REQUEST);
		List<Map<String, Object>> opears =  opeartionService.findOpeartion(20, id);
		request.setAttribute("enterOpears", opears , request.SCOPE_REQUEST);
		return  "/systemmanage/supplier/supplierDetail";
	}
	
	@RequestMapping("/yundongjia/accountInsertOrUpdate")
	@ResponseBody
	public String accountInsertOrUpdate(TApplyAccount tApplyAccount){
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String , Object> reMap = new HashMap<String , Object>();
		if(tApplyAccount.getRowdid() == 0){
			tApplyAccount.setCreatedate(simpleDateFormat.format(new Date()));
			tApplyAccount.setLiketype(4);
			Integer  result  = supplierService.insertAccount(tApplyAccount);
			if(result == 0){
				reMap.put("result", false);
				reMap.put("message", "收款人信息保存失败");
			}else{
				reMap.put("result", true);
				reMap.put("message", "收款人信息保存成功");
			}
		}else{
			Integer  result  = supplierService.updateAccount(tApplyAccount);
			if(result == 0){
				reMap.put("result", false);
				reMap.put("message", "收款人信息更新失败");
			}else{
				reMap.put("result", true);
				reMap.put("message", "收款人信息更新成功");
			}
		}
		return new Gson().toJson(reMap);
	}
	
	@RequestMapping("/yundongjia/insertsavemoney")
	@ResponseBody
	public String insertsavemoney(TSavemoney tSavemoney){
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String , Object> reMap = new HashMap<String , Object>();
		tSavemoney.setCreatedate(simpleDateFormat.format(new Date()));
		tSavemoney.setOpeartionid(super.getLogUserId());
		Integer  result  = supplierService.insertsavemoney(tSavemoney);
		if(result == 0){
			reMap.put("result", false);
			reMap.put("message", "储值信息保存失败");
		}else{
			TOpeartion o = new TOpeartion();
			o.setOpeartionAdminId(this.getLogUserId());
			o.setOpeartionById(result);
			o.setOpeartionType(20);
			o.setOpeartionInfo("插入供应商储值信息");
			opeartionService.saveOpeartion(o);
			reMap.put("result", true);
			reMap.put("message", "储值信息保存成功");
		}
		return new Gson().toJson(reMap);
	}
	
	@RequestMapping("/yundongjia/orderStatus")
	@ResponseBody
	public String orderStatus(Integer type,Integer status , Integer rowId , String comm){
		Map<String , Object> result = supplierService.orderStatus(type , status , rowId , comm);
		if((boolean) result.get("result")){
			TOpeartion o = new TOpeartion();
			o.setOpeartionAdminId(this.getLogUserId());
			o.setOpeartionById(rowId);
			o.setOpeartionType(8);
			switch (status) {
			case 7:
				o.setOpeartionInfo("更新订单状态为---已结算      理由："+comm);
				break;
			case 8:
				o.setOpeartionInfo("更新订单状态为---取消结算      理由："+comm);
				break;
			}
			opeartionService.saveOpeartion(o);
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/yundongjia/insertApply")
	@ResponseBody
	public String insertApply(String  accountInfo , Double comeMoney){
		Map<String , Object> result = new HashMap<String , Object>();
		Integer resultInfo = supplierService.insertApply(accountInfo , comeMoney);
		if(resultInfo == 0){
			result.put("result", false);
			result.put("message", "提现信息保存失败");
		}else{
			TOpeartion o = new TOpeartion();
			o.setOpeartionAdminId(this.getLogUserId());
			o.setOpeartionById(resultInfo);
			o.setOpeartionType(19);
			o.setOpeartionInfo("插入供应商提现信息");
			opeartionService.saveOpeartion(o);
			result.put("result", true);
			result.put("message", "提现信息保存成功");
		}
		return new Gson().toJson(result);
	}
	
	@RequestMapping("/yundongjia/updateApplyStatus")
	@ResponseBody
	public String updateApplyStatus(TApply tApply){
		Map<String , Object> result = new HashMap<String , Object>();
		Integer resultInfo = supplierService.updateApplyStatus(tApply);
		if(resultInfo == 0){
			result.put("result", false);
			result.put("message", "提现状态更新失败");
		}else{
			TOpeartion o = new TOpeartion();
			o.setOpeartionAdminId(this.getLogUserId());
			o.setOpeartionById(tApply.getRowid());
			o.setOpeartionType(19);
			if("1".equals(tApply.getApplystatus())){
				o.setOpeartionInfo("供应商提现状态更改 --- 已提现");
			}else{
				o.setOpeartionInfo("供应商提现状态更改 --- 取消提现");
			}
			opeartionService.saveOpeartion(o);
			result.put("result", true);
			result.put("message", "提现状态更新成功");
		}
		return new Gson().toJson(result);
	}
}
