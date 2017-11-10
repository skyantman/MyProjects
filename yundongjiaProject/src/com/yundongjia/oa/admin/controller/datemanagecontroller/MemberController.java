package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TApplyAccount;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.MemberService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.service.OrderService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.vo.OrderSearchVo;
import com.yundongjia.oa.utils.IdentifyCodeUtil;
import com.yundongjia.oa.utils.SendMessage;
import com.yundongjia.oa.utils.UtilPage;

/**
 * @author LXY
 *用户控制器
 */
@Controller
public class MemberController extends BaseController{
	@Resource
	private MemberService memberService;
	@Resource
	private OpeartionService opeartionService;
	@Resource
	private OrderService orderService;
	
	/**
	 * @param request
	 * @param page
	 * @return跳转到用户列表页
	 */
	@RequestMapping("/yundongjia/memberList")
	public String memberList(WebRequest request ,Integer page , String info , Integer status){
		if(page == null || page == 0){
			page = 1;
		}
		if(status == null){
			status =0;
		}
		Map memberSum =  memberService.findMemberSum();
		PageHelper.startPage(page, super.PAGE_ROW);
		List<Map> memberList =  memberService.findMemberList(info);
		PageInfo<Map> pi = new PageInfo(memberList);
		request.setAttribute("memberSum", memberSum, request.SCOPE_REQUEST);
		request.setAttribute("memberList", pi , request.SCOPE_REQUEST);
		request.setAttribute("status", status , request.SCOPE_REQUEST);
		request.setAttribute("info", info , request.SCOPE_REQUEST);
		return "systemmanage/member/memberList";
	}
	
	/**
	 * @param comm 启用禁用理由
	 * @param status 是否药效指代符
	 * @param userId 用户Id
	 * @param type 操作表中类型 指代用户
	 * @return 根据ID启用或禁用用户
	 * @author lxy 
	 * @date 2017/2/6 上午
	 */
	@RequestMapping("/yundongjia/stopOrStartMember")
	@ResponseBody
	public String stopOrStartMember(String comm , Integer status , Integer userId ,Integer type){
		TOpeartion tOpeartion = new TOpeartion();
		tOpeartion.setOpeartionCreatedate(new Date());
		tOpeartion.setOpeartionAdminId(this.getLogUserId());
		tOpeartion.setOpeartionCom(comm);
		tOpeartion.setOpeartionType(type);
		Integer result = memberService.stopOrStartMember(status , userId , tOpeartion);
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
	 * @param request
	 * @param userId 用户ID
	 * @param nav 导航位置
	 * @param enterId 企业ID
	 * @param enterCardId 企业卡ID
	 * @return 跳转到用户详情页面
	 * @author lxy
	 * @Date 2017/2/6 下午
	 */
	@RequestMapping("/yundongjia/memberDetail")
	public String memberDetail(WebRequest request , Integer userId, @RequestParam(defaultValue="0") Integer status ,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
						@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize , @RequestParam(defaultValue="0",required=true) Integer nav
						,@RequestParam(defaultValue="-1",required=true) Integer enterId,@RequestParam(defaultValue="-1",required=true) Integer enterCardId){
		Map member = memberService.memberDetail(userId);
		List<Map<String, Object>> findOpeartion = opeartionService.findOpeartion(11, userId);
		String validity = memberService.redPackageValidity(userId);
		List<TMemberCouponRef> memberCoupon = memberService.couponByUserId(userId);
		List<Map> cardDet =  memberService.findMemberCard(userId);
		List<Map> cardDetEnterprise = memberService.findMemberEnterprisCard(userId);
		List<TApply> apply = memberService.findUserApply(userId);
		List<TApplyAccount> account = memberService.findUserAccount(userId);
		PageInfo mapPageInfo = new PageInfo<>();
		Integer memberId= memberService.findMemberId(userId);
		OrderSearchVo vo = new OrderSearchVo();
		vo.setMemberId(memberId);
		List<Map<String, Object>> result =  orderService.findOrderList(vo);
		
		List<Map<String, Object>> mapPage=new ArrayList<>();
		
		UtilPage page =new UtilPage(pageSize, result.size(), pageNum);
		if(result.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				mapPage.add(result.get(i));
			}
		}
		
		mapPageInfo.setList(mapPage);
		mapPageInfo.setTotal(result.size());
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setPageSize(pageSize);
		mapPageInfo.setPages(page.getPageCount());
		
		request.setAttribute("nav", nav,request.SCOPE_REQUEST);
		request.setAttribute("orders", mapPageInfo,request.SCOPE_REQUEST);
		request.setAttribute("member", member , request.SCOPE_REQUEST);
		request.setAttribute("opeartion", findOpeartion, request.SCOPE_REQUEST);
		request.setAttribute("validity", validity, request.SCOPE_REQUEST);
		request.setAttribute("memberCoupon", memberCoupon , request.SCOPE_REQUEST);
		request.setAttribute("cardDet", cardDet, request.SCOPE_REQUEST);
		request.setAttribute("cardDetEnterprise", cardDetEnterprise, request.SCOPE_REQUEST);
		request.setAttribute("apply", apply, request.SCOPE_REQUEST);
		request.setAttribute("account", account, request.SCOPE_REQUEST);
		
		request.setAttribute("enterId", enterId, request.SCOPE_REQUEST);
		request.setAttribute("enterCardId", enterCardId, request.SCOPE_REQUEST);
		return "systemmanage/member/memberDetail";
	}
	
	/**
	 * @param mobilePhone 重置密码的手机号码
	 * @return 重置手机号码
	 * @author lxy
	 * @Date 2017/2/6 下午
	 */
	@RequestMapping("/yundongjia/resetpwd")
	@ResponseBody
	public String resetpwd(String mobilePhone){
		String  verpwd = IdentifyCodeUtil.createIndentifyCode(false, 6);
		Integer result = memberService.resetPwd(verpwd , mobilePhone);
		String data = SendMessage.sendAppointmentMessage(mobilePhone, "尊敬的用户,您的密码重置为【"+verpwd+"】, 请尽快登录账号修改密码 , 感谢您的使用");
    	//验证是否发送成功
    	String aa = data;
		String[] am = aa.split(",");
		String a0 = am[0];
		Map info = new HashMap();
		if(result == 0){
			info.put("result", false);
			info.put("message", "用户【"+ mobilePhone +"】密码重置失败！");
		}else if(result == 1){
			if (!"03".equals(a0)) {
				info.put("result", false);
				info.put("message", "短信息发送失败！");
			}else{
				info.put("result", true);
				info.put("message", "用户【"+ mobilePhone +"】密码重置成功！");
			}
		}else{
			info.put("result", false);
			info.put("message", "系统内部错误！");
		}
		return new Gson().toJson(info);
	}
	
	/**
	 * @param tApplyAccount
	 * @return更新用户提现账号信息
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	@RequestMapping("/yundongjia/updateAccount")
	@ResponseBody
	public String updateAccount(TApplyAccount tApplyAccount){
		Map info =  memberService.updateAccount(tApplyAccount);
		return new Gson().toJson(info);
	}
	/**
	 * @param applyStatus 提现进度
	 * @param rowId 主键提现记录表
	 * @return更新提现状态
	 * @author lxy 
	 * @date 2017/2/7 下午
	 */
	@RequestMapping("/yundongjia/updateStatus")
	@ResponseBody
	public String updateStatus(String  applyStatus ,Integer rowId){
		Map info =  memberService.updateStatus(applyStatus , rowId);
		return new Gson().toJson(info);
	}
	
	/**
	* Title: selectOrdersBy
	* Description: 订单多条件查询
	* @param orderSearch
	* @param pageNum
	* @param pageSize
	* @param userId
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	@RequestMapping("/yundongjia/selectOrderByMember")
	@ResponseBody
	public String selectOrderByMember(OrderSearchVo orderSearch,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize , Integer userId){
		PageHelper.startPage(pageNum, pageSize);
		orderSearch.setMemberId(memberService.findMemberId(userId));
		List<Map<String, Object>> mapList = orderService.selectOrdersByOrder(orderSearch);
		PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(mapList);
		
		return new Gson().toJson(mapPageInfo);
	}
}
