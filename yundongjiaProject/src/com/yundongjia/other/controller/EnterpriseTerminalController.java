package com.yundongjia.other.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yundongjia.app.user.service.LoginUserService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TMsg;
import com.yundongjia.oa.admin.po.TMsgExample;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.utils.IdentifyCodeUtil;
import com.yundongjia.oa.utils.SendMessage;
import com.yundongjia.other.service.EnterpriseTerminalService;

@Controller
public class EnterpriseTerminalController extends BaseController{
	@Autowired
	private EnterpriseTerminalService enterpriseTerminalService;
	@Autowired
	private LoginUserService loginUserService;
	
	
	/**
	 * @return
	 * 查询可登陆场馆信息列表
	 */
	@RequestMapping("ydj/other/enterpriseTerminalStudioList")
	@ResponseBody
	public void enterpriseTerminalStudioList(){
		Map<String , Object> result = new HashMap<String , Object>();
		try {
			List<TStudio> studiods = enterpriseTerminalService.findStudioList();
			result.put("info", studiods);
			result.put("status", "0");
		} catch (Exception e) {
			result.put("status", "1");
			result.put("message", "场馆列表查询失败");
		}
		this.writeJSONPStr(new Gson().toJson(result), "callback");
	}
	
	/**
	 * @param studioId
	 * @return获取验证码
	 */
	@RequestMapping("ydj/other/enterpriseTerminalGetAuthCode")
	@ResponseBody
	public void enterpriseTerminalGetAuthCode(Integer studioId){
		Map<String , Object> result = new HashMap<String , Object>();
		String phone = enterpriseTerminalService.selectStudioPhone(studioId);
		if("".equals(phone)){
			result.put("status", "1");
			result.put("message", "发送验证码失败");
			this.writeJSONPStr(new Gson().toJson(result), "callback");
			return ;
		}
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
			String data = SendMessage.sendMessage(phone, code , 2);
	
			String aa = data;
			String[] am = aa.split(",");
			String a0 = am[0];
			if("03".equals(a0)){
				result.put("status", "0");
				result.put("verifyCode", code);
				result.put("message", "发送验证码成功");
			} else {
				System.out.println("a0======================================="+a0);
				result.put("status", "1");
				result.put("message", "发送验证码失败");
			}
		}
		this.writeJSONPStr(new Gson().toJson(result), "callback");
	}
	
	/**
	 * @return登录验证
	 */
	@RequestMapping("ydj/other/enterpriseTerminalLogin")
	@ResponseBody
	public void enterpriseTerminalLogin(Integer studioId , String authCode){
		Map<String , Object> result = new HashMap<String , Object>();
		String phone = enterpriseTerminalService.selectStudioPhone(studioId);
		TMsgExample msgExample = new TMsgExample();
		msgExample.createCriteria().andMobilephonenoEqualTo(phone).andVerifycodeEqualTo(authCode).andStatusEqualTo("1");
    	List<TMsg> list_msg = this.loginUserService.selectVerifyCode(msgExample);	
        if(list_msg.size() > 0 ){
        	TMsg msg = list_msg.get(0);
        	msg.setStatus("0");
        	this.loginUserService.updateVerifyCodeStatus(msg);
        	result.put("status", "0");
        }else{
        	result.put("status", "1");
			result.put("message", "验证码与场馆不匹配");
        }
        this.writeJSONPStr(new Gson().toJson(result), "callback");
	}
	
	
	/**
	 * @param studioId
	 * @param startDate
	 * @param endDate
	 * @param mobile
	 * @return查询场馆订单列表
	 */
	@RequestMapping("ydj/other/enterpriseTerminalFindStudioOrder")
	@ResponseBody
	public void enterpriseTerminalFindStudioOrder(Integer studioId , String startDate , String endDate, String mobile){
		Map<String , Object> result = new HashMap<String , Object>();
		try {
			List<Map<String , Object>> info = enterpriseTerminalService.findStudioOrder(studioId , startDate , endDate , mobile);
			result.put("info", info);
			result.put("status", "0");
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "1");
			result.put("message", "场馆订单列表查询失败");
		}
		this.writeJSONPStr(new Gson().toJson(result), "callback");
	}
	
}
