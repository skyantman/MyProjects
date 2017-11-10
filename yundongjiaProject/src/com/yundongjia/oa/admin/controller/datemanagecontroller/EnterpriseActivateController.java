package com.yundongjia.oa.admin.controller.datemanagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;

/**
* Title: EnterpriseActivateController
* Description: 激活企业卡
* @author HuangJian
* @date 2017年4月19日
*
*/
@Controller
public class EnterpriseActivateController extends BaseController{

	
	/**
	* Title: EnterpriseActivateController.java
	* Description: 去激活页面
	* @param model
	* @return
	* @author HuangJian
	* @date 2017年4月19日
	*/
	@RequestMapping("/activate/activatepage")
	public String enterPriseActivate(Model model){
		
		return "/enterprise/activateEnterprise/activatepage";
	}
	/**
	* Title: EnterpriseActivateController.java
	* Description: 确定激活
	* @param cardNum 卡号
	* @param activeNum 激活码
	* @return
	* @author HuangJian
	* @date 2017年4月19日
	*/
	@RequestMapping("/activate/confirmActive")
	@ResponseBody
	public String confirmActive(String cardNum,String activeNum){
		
		return new Gson().toJson(null);
	}
	
	/**
	* Title: EnterpriseActivateController.java
	* Description: 激活后详情
	* @param orderNum 卡号（订单号）
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	@RequestMapping("/activate/activatedetail")
	public String activeDetail(String orderNum){
		
		return "/enterprise/activateEnterprise/detail";
	}
}
