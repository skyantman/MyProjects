package com.yundongjia.other.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yundongjia.app.user.service.LoginUserService;
import com.yundongjia.app.user.service.MemberInfoService;
import com.yundongjia.app.user.service.UserInfoService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMsg;
import com.yundongjia.oa.admin.po.TMsgExample;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.po.TUserExample;
import com.yundongjia.oa.utils.IdentifyCodeUtil;
import com.yundongjia.oa.utils.SendMessage;
import com.yundongjia.oa.utils.UtilMD5;
import com.yundongjia.other.service.ShareRecCouponService;

@Controller
public class ShareRecCouponController extends BaseController{
	@Resource
	private ShareRecCouponService shareRecCouponService;
	@Resource
	private LoginUserService loginUserService;
	@Resource
	private UserInfoService userInfoService;
	@Resource
	private MemberInfoService memberInfoService;
	
	/**
	 * @param phone
	 * @param CouponTypeId
	 * return status 0 成功 1 未注册 2 已领取 3无库存 4优惠券插入数据失败 -1后台代码异常
	 */
	@RequestMapping("ydj/other/selectShareCoupon")
	public void selectShareCoupon(String phone, Integer CouponTypeId){
		Map<String , Object> result = new HashMap<String , Object>();
		//查询会员是否注册
		if(!shareRecCouponService.findIsRegister(phone)){
			result.put("status", "1");
		//查询会员是否领取优惠券
		}else{
			String  status = shareRecCouponService.findIsRecCoupon(phone ,CouponTypeId);
			if("3".equals(status)){
				result.put("message", "优惠券已经领空了！登录<font style='color:red;'>运动+</font>APP领取其他优惠券吧！");
			}else if("4".equals(status)){
				result.put("message", "优惠券领取失败 , 请联系管理员！");
			}else if("-1".equals(status)){
				result.put("message", "系统异常，请联系管理员！");
			}else if("0".equals(status)){
				Integer couponNum = shareRecCouponService.findCouponCount(phone);
				result.put("couponNum", couponNum);
				result.put("couponPhone", phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4, phone.length()));
			}else if("2".equals(status)){
				result.put("couponPhone", phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4, phone.length()));
			}
			result.put("status", status);
		}
		
		this.writeJSONPStr(new Gson().toJson(result), "callback");
	}
	
	
	/**
	 * @param authCode
	 * @param phone
	 * return status 0 成功 1 注册失败 2 已领取 3无库存 4优惠券插入数据失败 5验证码过期 6已注册 -1后台代码异常 
	 */
	@RequestMapping("ydj/other/registerAndCoupon")
	public void registerAndCoupon(String authCode , String phone , String password , Integer CouponTypeId){
		Map<String , Object> result = new HashMap<String , Object>();
		//先验证用户是否为会员
		TUserExample userExample = new TUserExample();
		userExample.createCriteria().andMobilephonenoEqualTo(phone);
		List<TUser> list_user = this.userInfoService.selectUserLoginInfo(userExample);
		if(list_user.size() == 0){
			TMsgExample msgExample = new TMsgExample();
			msgExample.createCriteria().andMobilephonenoEqualTo(phone).andVerifycodeEqualTo(authCode).andStatusEqualTo("1");
	    	List<TMsg> list_msg = this.loginUserService.selectVerifyCode(msgExample);	
	            if(list_msg.size() > 0 ){
					//验证码存在进行注册
					String nickName = "尾号"+phone.substring(7, 11);
					String createDate = format.format(new Date());
					String imgpath="";
					TUser user = new TUser();
					user.setCreatedate(createDate);
					user.setMobilephoneno(phone);
					user.setIsvalid("0");
					user.setUsertype("app");
					user.setPassword(UtilMD5.md5(password));
					int userId = this.userInfoService.insertUser(user);
					if (userId > 0) {
						TMember member = new TMember();
						member.setUserid(user.getUserid());
						member.setNickname(nickName);
						member.setImgpath(imgpath);
						Integer resultInfo = memberInfoService.insertMemberInfo(member);
                        //给一个随机金额 方法: createRegRPAndSave(goheng项目有样例 appuserAction)
						if(resultInfo != 1){
							result.put("status", "1");
	                        result.put("message", "注册失败!");
						}else{
							String  status = shareRecCouponService.findIsRecCoupon(phone ,CouponTypeId);
							if("3".equals(status)){
								result.put("message", "优惠券已经领空了！登录<font style='color:red;'>运动+</font>APP领取其他优惠券吧！");
							}else if("4".equals(status)){
								result.put("message", "优惠券领取失败 , 请联系管理员！");
							}else if("-1".equals(status)){
								result.put("message", "系统异常，请联系管理员！");
							}else if("0".equals(status)){
								Integer couponNum = shareRecCouponService.findCouponCount(phone);
								result.put("couponNum", couponNum);
								result.put("couponPhone", phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4, phone.length()));
							}else if("2".equals(status)){
								result.put("couponPhone", phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4, phone.length()));
							}
							result.put("status", status);
						}
                        TMsg msg = new TMsg();
    	            	msg.setStatus("0");
    					msg.setVerifyid(list_msg.get(0).getVerifyid());
    					this.loginUserService.updateVerifyCodeStatus(msg);//修改验证码状态使其不可用
                    }
			}else{
				//验证码过期或者不存在
				result.put("status", "5");
				result.put("message", "验证码过期或者不存在,请重新申请");
			}
			
		}else{
			//是会员
			result.put("status", "6");
			result.put("message", "您已经是会员,请前往登录");
		}
		
		this.writeJSONPStr(new Gson().toJson(result), "callback");
	}
	
	
	@RequestMapping("ydj/other/getShareRegisterAuth")
	public void getShareRegisterAuth(String phone){
		Map<String , Object> result = new HashMap<String , Object>();
		 //生成随机6位数验证码
		String code = IdentifyCodeUtil.createIndentifyCode(true, 6);
		TMsg msg = new TMsg();
		msg.setVerifycode(code);
		msg.setMobilephoneno(phone);
		msg.setStatus("1");
		msg.setCreatedate(format.format(new Date()));
		msg.setCodetype(0);
		msg.setFromid(0);
		msg.setIp("");
		int sid = this.loginUserService.insertVerifyCode(msg);
		if (sid > 0) {
			String data = SendMessage.sendMessage(phone, code , 1);
	
			String aa = data;
			String[] am = aa.split(",");
			String a0 = am[0];
			if ("03".equals(a0)) {
				result.put("status", "0");
				result.put("message", "请求验证码成功!");
				result.put("verifyCode", code);
			} else {
				System.out.println("a0======================================="+a0);
				result.put("status", "1");
				result.put("message", "请求验证码失败！");
			}
		}else{
			result.put("status", "1");
			result.put("message", "验证码生成失败！");
		}
		
		this.writeJSONPStr(new Gson().toJson(result), "callback");
	}
	
}
