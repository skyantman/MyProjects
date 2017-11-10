package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCoupon;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.CouponService;
import com.yundongjia.oa.admin.service.OpeartionService;

@Controller
public class CouponController extends BaseController{
	@Resource
	private CouponService couponService;
	@Resource
	private  OpeartionService opeartionService; 
	/**
	 * @param request
	 * @return跳转到新增优惠券页面
	 */
	@RequestMapping("/yundongjia/addcoupontype")
	public String addcoupontype(WebRequest request){
		return "systemmanage/coupon/addcoupontype";
	}
	
	/**
	 * 
	 * @return插入优惠券类
	 */
	@RequestMapping("/yundongjia/insertCouponType")
	@ResponseBody
	public String insertCouponType(WebRequest request , TCoupon tCoupon , Integer stockNum , Integer[] coupon_type){
		boolean b = false;
		String couponType = "";
		for (int i = 0; i < coupon_type.length; i++) {
			if(coupon_type[i] == 0){
				b = true;
			}
			couponType = couponType + coupon_type[i] + ",";
		}
		if(b){
			tCoupon.setCoupontype("0");
		}else{
			tCoupon.setCoupontype(couponType);
		}
		if(tCoupon.getStock() == 1){
			tCoupon.setStock(stockNum);	
			tCoupon.setSurplusstock(stockNum);
		}else if(tCoupon.getStock() == -1){
			tCoupon.setSurplusstock(-1);
		}
		if("0".equals(tCoupon.getCouponmethod())){
			tCoupon.setAmount(0d);
		}else if("1".equals(tCoupon.getCouponmethod())){
			tCoupon.setDiscount("0");
			tCoupon.setMaxmoney(-1d);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tCoupon.setCreatedate(simpleDateFormat.format(new Date()));
		tCoupon.setOpeartionadminid(this.getLogUserId());
		tCoupon.setIsdel(0);
		TOpeartion opeartion = new TOpeartion();
		opeartion.setOpeartionAdminId(this.getLogUserId());
		opeartion.setOpeartionCreatedate(new Date());
		Integer result = couponService.insertCouponType(tCoupon , opeartion);
		Map info = new HashMap();
		if(result != 0){
			info.put("id", result);
			info.put("result", true);
			info.put("message", "优惠券类型创建成功！");
		}else if( result == 0){
			info.put("result", false);
			info.put("message", "优惠券类型创建失败！");
		}else{
			info.put("result", false);
			info.put("message", "系统异常，请联系管理员！");
		}
		return new Gson().toJson(info);
	}
	
	/**
	 * @param request
	 * @return跳转优惠券类型详情页
	 */
	@RequestMapping("/yundongjia/coupontypelist")
	public String coupontypelist(WebRequest request , Integer page , Integer status){
		if(status == null){
			PageInfo<TCoupon> couponMoney = couponService.coupontypelist("1" , page , super.PAGE_ROW);
			PageInfo<TCoupon> couponDiscount = couponService.coupontypelist("0" ,page , super.PAGE_ROW);
			request.setAttribute("couponMoney", couponMoney  , request.SCOPE_REQUEST);
			request.setAttribute("couponDiscount", couponDiscount  , request.SCOPE_REQUEST);
			request.setAttribute("status", 0 , request.SCOPE_REQUEST);
		}else if(status == 0){
			PageInfo<TCoupon> couponMoney = couponService.coupontypelist("1" , page , super.PAGE_ROW);
			PageInfo<TCoupon> couponDiscount = couponService.coupontypelist("0" ,1 , super.PAGE_ROW);
			request.setAttribute("couponMoney", couponMoney  , request.SCOPE_REQUEST);
			request.setAttribute("couponDiscount", couponDiscount  , request.SCOPE_REQUEST);
			request.setAttribute("status", 0 , request.SCOPE_REQUEST);
		}else if(status == 1){
			PageInfo<TCoupon> couponMoney = couponService.coupontypelist("1" , 1 , super.PAGE_ROW);
			PageInfo<TCoupon> couponDiscount = couponService.coupontypelist("0" ,page , super.PAGE_ROW);
			request.setAttribute("couponMoney", couponMoney  , request.SCOPE_REQUEST);
			request.setAttribute("couponDiscount", couponDiscount  , request.SCOPE_REQUEST);
			request.setAttribute("status", 1  , request.SCOPE_REQUEST);
		}
		return "systemmanage/coupon/coupontypelist";
	}
	
	/**
	 * @return
	 * 启用禁用优惠券类型
	 */
	@RequestMapping("/yundongjia/stopOrStartCoupon")
	@ResponseBody
	public String stopOrStartCoupon(Integer status , Integer couponId , String  comm , Integer type){
		TOpeartion tOpeartion = new TOpeartion();
		tOpeartion.setOpeartionCreatedate(new Date());
		tOpeartion.setOpeartionAdminId(this.getLogUserId());
		tOpeartion.setOpeartionCom(comm);
		tOpeartion.setOpeartionType(type);
		Integer result = couponService.updateStopOrStart(status , couponId , tOpeartion);
		Map info = new HashMap();
		if(result > 0){
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
	 * 启用禁用优惠券单券
	 */
	@RequestMapping("/yundongjia/stopOrStartMemberCoupon")
	@ResponseBody
	public String stopOrStartMemberCoupon(Integer status , Integer rowId , String  comm , Integer type){
		TOpeartion tOpeartion = new TOpeartion();
		tOpeartion.setOpeartionCreatedate(new Date());
		tOpeartion.setOpeartionAdminId(this.getLogUserId());
		tOpeartion.setOpeartionCom(comm);
		tOpeartion.setOpeartionType(type);
		Integer result = couponService.stopOrStartMemberCoupon(status , rowId , tOpeartion);
		Map info = new HashMap();
		if(result > 0){
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
	 * 优惠券类型详情页
	 */
	@RequestMapping("/yundongjia/couponList")
	public String couponList( WebRequest request , Integer status , Integer couponId , Integer page){
		if(status == null){
			status = 0;
		}
		if(page == null || page == 0){
    		page = 1;
    	}
		TCoupon coupon =  couponService.couponTypeById(couponId);
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(5, couponId);
		PageHelper.startPage(page, super.PAGE_ROW);
		List<TMemberCouponRef>  memberCoupon = couponService.memberCouponlist(couponId);
		PageInfo<TMemberCouponRef> pi = new PageInfo<TMemberCouponRef>(memberCoupon);
		request.setAttribute("status", status, request.SCOPE_REQUEST);
		request.setAttribute("coupon", coupon, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("memberCoupon", pi, request.SCOPE_REQUEST);
		return "systemmanage/coupon/coupontypedetail";
	}
	/**
	 * @return
	 * 优惠券类型详情页
	 */
	@RequestMapping("/yundongjia/couponDetail")
	public String couponDetail( WebRequest request , Integer rowId , Integer couponId , Integer status , Integer userId){
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(6, rowId);
		Map memberCoupon =  couponService.couponDetail(rowId);
		request.setAttribute("coupon", memberCoupon, request.SCOPE_REQUEST);
		request.setAttribute("couponId", couponId, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("status", status, request.SCOPE_REQUEST);
		if(userId != null){
			request.setAttribute("userId", userId, request.SCOPE_REQUEST);
		}
		return "systemmanage/coupon/couponDetail";
	}
	/**
	 * @param request
	 * @param page 当前页数
	 * @param couponId 优惠券类型iD
	 * @param info 搜索手机号
	 * @return根据用户手机号查询优惠单券
	 */
	@RequestMapping("/yundongjia/searchMemberCouponByPhone")
	public String searchMemberCouponByPhone( WebRequest request , Integer page , Integer couponId , String info){
		if(page == null || page == 0){
    		page = 1;
    	}
		TCoupon coupon =  couponService.couponTypeById(couponId);
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(5, couponId);
		List<TMemberCouponRef>  memberCoupon =  couponService.searchMemberCouponByPhone(couponId , info);
		PageInfo<TMemberCouponRef> pi = new PageInfo<TMemberCouponRef>(memberCoupon);
		request.setAttribute("coupon", coupon, request.SCOPE_REQUEST);
		request.setAttribute("memberCoupon", pi, request.SCOPE_REQUEST);
		request.setAttribute("status", 2, request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		return "systemmanage/coupon/coupontypedetail";
	}
}
