package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.service.EnterpriseAndSelfCardService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.vo.OrderSearchVo;
import com.yundongjia.oa.utils.UtilPage;

@Controller
public class EnterpriseAndSelfCardController extends BaseController{
	@Resource
	private EnterpriseAndSelfCardService enterpriseAndSelfCardService;
	@Resource
	private OpeartionService opeartionService;
	
	/**
	 * @return
	 * 跳转到新增企业卡类型页面
	 */
	@RequestMapping("/yundongjia/addenterprisecard")
	public String addenterprisecard(WebRequest request){
		List<TRegions> regions = enterpriseAndSelfCardService.findRegions();
		request.setAttribute("city", regions, request.SCOPE_REQUEST);
		return "systemmanage/enterprisecard/addenterprisecard";
	}
	
	/**
	 * @return
	 * 创建企业卡类型
	 */
	@RequestMapping("/yundongjia/insertEnterpriseCardType")
	@ResponseBody
	public String insertEnterpriseCardType(TCardType tCardType , Integer stockNum , Integer[] regions_id){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tCardType.setCreatedate(simpleDateFormat.format(new Date()));
		tCardType.setCardtype("2");
		if(tCardType.getStock() == -1){
			tCardType.setSurplusstock(-1);
		}else if(tCardType.getStock() == 1){
			tCardType.setSurplusstock(stockNum);
			tCardType.setStock(stockNum);
		}
		String regions = "";
		Boolean b = true;
		for (int i = 0; i < regions_id.length; i++) {
			if(regions_id[i] == -1){
				b = false;
			}else{
				regions = regions + regions_id[i] + ",";
			}
		}
		if(b){
			tCardType.setRegionsid(regions);
		}else{
			tCardType.setRegionsid("-1");
		}
		tCardType.setIscashback(0);
		tCardType.setIsdel("0");
		tCardType.setIsstop("0");
		tCardType.setOpeartionadminid(this.getLogUserId());
		TOpeartion opeartion = new TOpeartion();
		opeartion.setOpeartionAdminId(this.getLogUserId());
		opeartion.setOpeartionCreatedate(new Date());
		Integer result = enterpriseAndSelfCardService.insertEnterpriseCardType(tCardType , opeartion);
		Map info = new HashMap();
		if(result != 0){
			info.put("id", result);
			info.put("result", true);
			info.put("message", "企业卡类型创建成功！");
		}else if( result == 0){
			info.put("result", false);
			info.put("message", "企业卡类型创建失败！");
		}else{
			info.put("result", false);
			info.put("message", "系统异常，请联系管理员！");
		}
		return new Gson().toJson(info);
	}
	
	/**
	 * @return
	 * 跳转到企业卡类型列表页
	 */
	@RequestMapping("/yundongjia/enterprisecardlist")
	public String enterprisecardlist(WebRequest request , Integer page){
		if(page == null || page == 0){
    		page = 1;
    	}
		PageHelper.startPage(page, super.PAGE_ROW);
		List<TCardType> tCardTypes = enterpriseAndSelfCardService.findenterprisecardlist();
		PageInfo<TCardType> pi = new PageInfo<TCardType>(tCardTypes);
		request.setAttribute("cardType", pi, request.SCOPE_REQUEST);
		return "systemmanage/enterprisecard/enterprisecardlist";
	}
	
	/**
	 * @return
	 * 启用禁用企业卡类
	 */
	@RequestMapping("/yundongjia/stopOrStart")
	@ResponseBody
	public String stopOrStart(Integer status , Integer cardId , String  comm , Integer type){
		TOpeartion tOpeartion = new TOpeartion();
		tOpeartion.setOpeartionCreatedate(new Date());
		tOpeartion.setOpeartionAdminId(this.getLogUserId());
		tOpeartion.setOpeartionCom(comm);
		tOpeartion.setOpeartionType(type);
		Integer result = enterpriseAndSelfCardService.updateStopOrStart(status , cardId , tOpeartion);
		Map info = new HashMap();
		if(result != 0){
			info.put("result", true);
			info.put("message", "操作成功！");
		}else if( result == 0){
			info.put("result", false);
			info.put("message", "操作失败！");
		}else{
			info.put("result", false);
			info.put("message", "系统异常，请联系管理员！");
		}
		return new Gson().toJson(info);
	}
	
	/**
	 * @return
	 * 跳转到企业卡类型详情页
	 */
	@RequestMapping("/yundongjia/enterpriseCardTypeDetail")
	public String enterpriseCardTypeDetail(WebRequest request , Integer cardid , Integer status , Integer page){
		if(page == null || page == 0){
    		page = 1;
    	}
		PageHelper.startPage(page, super.PAGE_ROW_5);
		TCardType tCardType = enterpriseAndSelfCardService.findById(cardid);
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(3, cardid);
		List<Map> tMemberCardOrderRefs =  enterpriseAndSelfCardService.findListByCardTypeId(cardid);
		PageInfo<Map> pi = new PageInfo<Map>(tMemberCardOrderRefs);
		request.setAttribute("cardDet", pi, request.SCOPE_REQUEST);
		request.setAttribute("cardType", tCardType, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("cardTypyId", cardid, request.SCOPE_REQUEST);
		if(status != null && status==1){
			request.setAttribute("status", 1, request.SCOPE_REQUEST);
		}else{
			request.setAttribute("status", 0, request.SCOPE_REQUEST);
		}
		return "systemmanage/enterprisecard/enterprisecarddetail";
	}
	
	/**
	 * @return
	 * 根据企业名称查询卡类型下的单卡
	 */
	@RequestMapping("/yundongjia/enterpriseDetail")
	public String enterpriseDetail(WebRequest request , Integer cardid , String info , Integer page){
		if(page == null || page == 0){
    		page = 1;
    	}
		PageHelper.startPage(page, super.PAGE_ROW_5);
		TCardType tCardType = enterpriseAndSelfCardService.findById(cardid);
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(3, cardid);
		List<Map> tMemberCardOrderRefs =  enterpriseAndSelfCardService.enterpriseDetail(cardid , info);
		PageInfo<Map> pi = new PageInfo<Map>(tMemberCardOrderRefs);
		request.setAttribute("cardDet", pi, request.SCOPE_REQUEST);
		request.setAttribute("cardType", tCardType, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("status", 2, request.SCOPE_REQUEST);
		return "systemmanage/enterprisecard/enterprisecarddetail";
	}
	
	/**此处与  企业-》企业详情--》企业卡(启用，禁用)公用 
	 * @return
	 * 启用禁用企业卡
	 */
	@RequestMapping("/yundongjia/stopOrStartCard")
	@ResponseBody
	public String stopOrStartCard(Integer status , Integer cardId,String comm , Integer type){
		TOpeartion tOpeartion = new TOpeartion();
		tOpeartion.setOpeartionCreatedate(new Date());
		tOpeartion.setOpeartionAdminId(this.getLogUserId());
		tOpeartion.setOpeartionCom(comm);
		tOpeartion.setOpeartionType(type);
		Integer result = enterpriseAndSelfCardService.updateStopOrStartCard(status , cardId , tOpeartion);
		Map info = new HashMap();
		if(result != 0){
			info.put("result", true);
			info.put("message", "操作成功！");
		}else if( result == 0){
			info.put("result", false);
			info.put("message", "操作失败！");
		}else{
			info.put("result", false);
			info.put("message", "系统异常，请联系管理员！");
		}
		return new Gson().toJson(info);
	}
	
	/** 此处与  企业-》企业详情--》企业卡详情公用 
	 * position:位置  0：从企业类型跳转到这里的   1:从企业跳转到这里的
	 * @return
	 * 跳转到新增企业卡类型页面
	 */
	@RequestMapping("/yundongjia/enterpriseCardDetail")
	public String enterpriseCardDetail(WebRequest request ,Integer cardtypeid, Integer pageNum ,Integer cardid , Integer status,@RequestParam(defaultValue="0") Integer position ,Integer condition , Integer userId){
		if(pageNum == null){
			pageNum = 1;
		}
		Map card = enterpriseAndSelfCardService.enterpriseCardDetail(cardid);
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(4, cardid);
		PageInfo mapPageInfo = new PageInfo<>();
		OrderSearchVo vo = new OrderSearchVo();
		List result =  enterpriseAndSelfCardService.findOrderList(cardid);
		
		List mapPage=new ArrayList();
		
		UtilPage utilPage =new UtilPage(super.PAGE_ROW , result.size(), pageNum);
		if(result.size() >0 && pageNum <= utilPage.getCurrentPage()){
			for(int i=utilPage.getFromIndex();i<utilPage.getToIndex();i++){
				mapPage.add(result.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(result.size());
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setPageSize(super.PAGE_ROW );
		mapPageInfo.setPages(utilPage.getPageCount());
		request.setAttribute("order", mapPageInfo, request.SCOPE_REQUEST); 
		request.setAttribute("card", card, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("status", status, request.SCOPE_REQUEST);
		request.setAttribute("position", position, request.SCOPE_REQUEST);
		request.setAttribute("condition", condition, request.SCOPE_REQUEST);
		request.setAttribute("cardTypyId", cardtypeid, request.SCOPE_REQUEST);
		if(userId != null){
			request.setAttribute("userId", userId, request.SCOPE_REQUEST);
		}
		return "systemmanage/enterprisecard/carddetail";
	}
	
	/**
	 * @return
	 * 跳转到新增企业卡类型页面
	 */
	@RequestMapping("/yundongjia/addselfcard")
	public String addselfcard(WebRequest request){
		List<TRegions> regions = enterpriseAndSelfCardService.findRegions();
		request.setAttribute("city", regions, request.SCOPE_REQUEST);
		return "systemmanage/selfcard/addselfcard";
	}
	
	/**
	 * @return
	 * 创建个人卡类型
	 */
	@RequestMapping("/yundongjia/insertSelfCardType")
	@ResponseBody
	public String insertSelfCardType(TCardType tCardType , Integer stockNum , Integer[] regions_id){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tCardType.setCreatedate(simpleDateFormat.format(new Date()));
		tCardType.setCardtype("1");
		if(tCardType.getStock() == -1){
			tCardType.setSurplusstock(-1);
		}else if(tCardType.getStock() == 1){
			tCardType.setSurplusstock(stockNum);
			tCardType.setStock(stockNum);
		}
		String regions = "";
		Boolean b = true;
		for (int i = 0; i < regions_id.length; i++) {
			if(regions_id[i] == -1){
				b = false;
			}else{
				regions = regions + regions_id[i] + ",";
			}
		}
		if(b){
			tCardType.setRegionsid(regions);
		}else{
			tCardType.setRegionsid("-1");
		}
		if(tCardType.getIscashback() == 1){
			tCardType.setBackmoney(Double.parseDouble(tCardType.getAmount()));
		}
		tCardType.setIsdel("0");
		tCardType.setIsstop("0");
		tCardType.setSportscount(-1);
		tCardType.setOpeartionadminid(this.getLogUserId());
		TOpeartion opeartion = new TOpeartion();
		opeartion.setOpeartionAdminId(this.getLogUserId());
		opeartion.setOpeartionCreatedate(new Date());
		Integer result = enterpriseAndSelfCardService.insertSelfCardType(tCardType , opeartion);
		Map info = new HashMap();
		if(result != 0){
			info.put("id", result);
			info.put("result", true);
			info.put("message", "个人卡类型创建成功！");
		}else if( result == 0){
			info.put("result", false);
			info.put("message", "个人卡类型创建失败！");
		}else{
			info.put("result", false);
			info.put("message", "系统异常，请联系管理员！");
		}
		return new Gson().toJson(info);
	}
	/**
	 * @return
	 * 跳转到企业卡类型列表页
	 */
	@RequestMapping("/yundongjia/selfcardlist")
	public String selfcardlist(WebRequest request , Integer page){
		if(page == null || page == 0){
    		page = 1;
    	}
		PageHelper.startPage(page, super.PAGE_ROW);
		List<TCardType> tCard = enterpriseAndSelfCardService.findselfcardlist();
		PageInfo<TCardType> pi = new PageInfo<TCardType>(tCard);
		request.setAttribute("card", pi, request.SCOPE_REQUEST);
		return "systemmanage/selfcard/selfcardlist";
	}
	
	/**
	 * @return
	 * 跳转到个人卡类型详情页
	 */
	@RequestMapping("/yundongjia/selfCardTypeDetail")
	public String selfCardTypeDetail(WebRequest request , Integer cardid , Integer status , Integer page){
		if(page == null || page == 0){
    		page = 1;
    	}
		PageHelper.startPage(page, super.PAGE_ROW_5);
		TCardType tCardType = enterpriseAndSelfCardService.findSelfById(cardid);
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(1, cardid);
		List<Map> tMemberCardOrderRefs =  enterpriseAndSelfCardService.findListSelfByCardTypeId(cardid);
		PageInfo<Map> pi = new PageInfo<Map>(tMemberCardOrderRefs);
		request.setAttribute("cardDet", pi, request.SCOPE_REQUEST);
		request.setAttribute("cardType", tCardType, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("cardTypyId", cardid, request.SCOPE_REQUEST);
		if(status != null && status==1){
			request.setAttribute("status", 1, request.SCOPE_REQUEST);
		}else{
			request.setAttribute("status", 0, request.SCOPE_REQUEST);
		}
		return "systemmanage/selfcard/selfcarddetail";
	}
	
	/**
	 * @param request
	 * @param cardid 个人卡id
	 * @param condition 标识
	 * @param userId 用户ID 传递使用 不做查询条件
	 * @return跳转到个人卡详情页
	 */
	@RequestMapping("/yundongjia/selfCardDetail")
	public String selfCardDetail(WebRequest request , Integer cardtypeid ,Integer cardid , Integer condition , Integer userId , Integer pageNum){
		if(pageNum == null){
			pageNum = 1;
		}
		Map card = enterpriseAndSelfCardService.selfCardDetail(cardid);
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(2, cardid);
		PageInfo mapPageInfo = new PageInfo<>();
		OrderSearchVo vo = new OrderSearchVo();
		List result =  enterpriseAndSelfCardService.findOrderList(cardid);
		
		List mapPage=new ArrayList();
		
		UtilPage page =new UtilPage(super.PAGE_ROW , result.size(), pageNum);
		if(result.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				mapPage.add(result.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(result.size());
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setPageSize(super.PAGE_ROW );
		mapPageInfo.setPages(page.getPageCount());
		request.setAttribute("card", card, request.SCOPE_REQUEST);
		request.setAttribute("condition", condition, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("order", mapPageInfo, request.SCOPE_REQUEST); 
		request.setAttribute("cardTypyId", cardtypeid, request.SCOPE_REQUEST);
		if(userId != null){
			request.setAttribute("userId", userId, request.SCOPE_REQUEST);
		}
		return "systemmanage/selfcard/carddetail";
	}
	
	
	@RequestMapping("/yundongjia/searchOrder")
	public String selfCardDetail(WebRequest request , Integer cardtypeid ,Integer cardid  , Integer pageNum , String info , Integer status){
		if(pageNum == null){
			pageNum = 1;
		}
		Map card = new HashMap();
		if(status ==1){
			card = enterpriseAndSelfCardService.enterpriseCardDetail(cardid);
		}else{
			card = enterpriseAndSelfCardService.selfCardDetail(cardid);
		}
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(2, cardid);
		PageInfo mapPageInfo = new PageInfo<>();
		OrderSearchVo vo = new OrderSearchVo();
		List result =  enterpriseAndSelfCardService.findOrderList(cardid , info);
		
		List mapPage=new ArrayList();
		
		UtilPage page =new UtilPage(super.PAGE_ROW , result.size(), pageNum);
		if(result.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
					mapPage.add(result.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(result.size());
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setPageSize(super.PAGE_ROW );
		mapPageInfo.setPages(page.getPageCount());
		request.setAttribute("card", card, request.SCOPE_REQUEST);
		request.setAttribute("condition", 9, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("order", mapPageInfo, request.SCOPE_REQUEST); 
		request.setAttribute("cardTypyId", cardtypeid, request.SCOPE_REQUEST);
		return "systemmanage/selfcard/carddetail";
		
	}
}
