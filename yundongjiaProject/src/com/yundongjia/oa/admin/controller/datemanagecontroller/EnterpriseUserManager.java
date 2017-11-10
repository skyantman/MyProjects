package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Arrays;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.service.EnterpriseService;
import com.yundongjia.oa.admin.service.MemberCardOrderRefService;
import com.yundongjia.oa.admin.service.UserService;
import com.yundongjia.oa.admin.vo.ConstantVo;
/**
* Title: EnterpriseUserManager
* Description: 企业端    用户管理
* @author HuangJian
* @date 2017年4月18日
*
*/
@RequestMapping("/enterprise")
@Controller
public class EnterpriseUserManager extends BaseController{

	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private MemberCardOrderRefService memberCardOrderRefService;
	@Autowired
	private UserService userService;
	
	public List<Map<String, Object>> cards;
	public PageInfo<Map<String, Object>> pageInfoList;
	public List<Map<String, Object>> userList;
	public List<Integer> cIds;
	@RequestMapping("/epusermanager/list")
	public String enterPriseUserList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE_10) Integer pageSize){
		cIds = new ArrayList<>();
		//查询企业下的所有卡
		try {
			cards = memberCardOrderRefService.getCardOrderByEnterId(this.getEnterPriseId());
			if(cards != null && cards.size() > 0){
				Map<String, Object> temp;
				for (int i = 0; i < cards.size(); i++) {
					temp=cards.get(i);
					cIds.add(Integer.parseInt(String.valueOf(temp.get("orderId"))));
				}
				
			}
			PageHelper.startPage(pageNum, pageSize);
			userList = userService.findUserByMobilePhoneCards(null, cIds);
			pageInfoList=new PageInfo<>(userList);
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
	    model.addAttribute("users", pageInfoList);
		model.addAttribute("cards", cards);
		return "/enterprise/userManager/list";
	}
	
	/**
	* Title: EnterpriseUserManager.java
	* Description: 根据手机号码查询
	* @param mobilePhone
	* @return
	* @author HuangJian
	* @date 2017年4月18日
	*/
	@RequestMapping("/epusermanager/searchMobilePhone")
	@ResponseBody
	public String searchMobilePhone(String mobilePhone,
			@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE_10) Integer pageSize){
		cIds = new ArrayList<>();
		cards = memberCardOrderRefService.getCardOrderByEnterId(this.getEnterPriseId());
		if(cards != null && cards.size() > 0){
			Map<String, Object> temp;
			for (int i = 0; i < cards.size(); i++) {
				temp=cards.get(i);
				cIds.add(Integer.parseInt(String.valueOf(temp.get("orderId"))));
			}
		}
		
		PageHelper.startPage(pageNum, pageSize);
		userList =userService.findUserByMobilePhoneCards("%"+mobilePhone+"%",cIds);
		pageInfoList = new PageInfo<>(userList);
		
		return new Gson().toJson(pageInfoList);
	}
	/**
	* Title: EnterpriseUserManager.java
	* Description: 根据企业卡查询用户
	* @param cardId 企业卡ID
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年4月19日
	*/
	@RequestMapping("/epusermanager/searchcard")
	@ResponseBody
	public String searchEnterPriseByCard(Integer cardId,
			@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE_10) Integer pageSize){
		cIds=new ArrayList<>();
		// -1企业卡全查用户
		if(cardId == -1){
			cards = memberCardOrderRefService.getCardOrderByEnterId(this.getEnterPriseId());
			if(cards != null && cards.size() > 0){
				Map<String, Object> temp;
				for (int i = 0; i < cards.size(); i++) {
					temp=cards.get(i);
					cIds.add(Integer.parseInt(String.valueOf(temp.get("orderId"))));
				}
			}
		}else{
			cIds.add(cardId);
		}
		PageHelper.startPage(pageNum, pageSize);
		userList = userService.findUserByMobilePhoneCards(null, cIds);
		pageInfoList=new PageInfo<>(userList);
		
		return new Gson().toJson(pageInfoList);
	}
	/**
	* Title: EnterpriseUserManager.java
	* Description: 修改用户状态
	* @param userId 用户ID
	* @param status 状态
	* @param comm  禁用理由
	* @return
	* @author HuangJian
	* @date 2017年4月19日
	*/
	@RequestMapping("/epusermanager/updatestatus")
	@ResponseBody
	public String updateUser(Integer userId,Integer status,
			@RequestParam(defaultValue="-1",required=true) String comm){
		Integer result = 0;
		TUser user=new TUser();
		user.setUserid(userId);
		user.setIsvalid(String.valueOf(status));
		if(!"-1".equals(comm)){
			user.setIsvalidremark(comm);
		}
		result = userService.updateTuserById(user);
		return new Gson().toJson(result);
	}
	/**
	* Title: EnterpriseUserManager.java
	* Description: 增加企业用户   用户与卡绑定
	* @param mobilePhoneNum 用户手机号
	* @param cardId  企业卡ID
	* @return
	* @author HuangJian
	* @date 2017年4月19日
	*/
	@RequestMapping("/epusermanager/saveuser")
	@ResponseBody
	public String saveEnterPriseUser(String mobilePhoneNum,Integer cardId){
		TUser user = new TUser();
		user.setMobilephoneno(mobilePhoneNum.trim());
		
		Map<String, Object> result =  userService.insertTuser(user, cardId);
		return new Gson().toJson(result);
	}
}
