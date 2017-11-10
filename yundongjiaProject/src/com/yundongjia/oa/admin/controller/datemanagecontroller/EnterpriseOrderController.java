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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.service.MemberCardOrderRefService;
import com.yundongjia.oa.admin.service.StudioConsumeOrderRecordService;
import com.yundongjia.oa.admin.service.UserService;
import com.yundongjia.oa.admin.vo.ConstantVo;
/**
* Title: EnterpriseOrderController
* Description: 企业端    健身房订单
* @author HuangJian
* @date 2017年4月19日
*
*/
@Controller
public class EnterpriseOrderController extends BaseController{
	
	@Autowired
	private MemberCardOrderRefService memberCardOrderRefService;
	@Autowired
	private StudioConsumeOrderRecordService studioConsumeOrderRecordService;
	@Autowired
	private UserService userService;
	public List<Integer> cardList;//企业卡集合
	public List<Integer> userList;//所有的用户集合
	public List<Map<String, Object>> cardResult;
	public List<Map<String, Object>> userResult;
	public List<Map<String, Object>> studioOrders;
	public PageInfo<Map<String, Object>> pageInfoList;
	/**
	* Title: EnterpriseOrderController.java
	* Description: 企业订单列表
	* @param model
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	@RequestMapping("/enterpriseorder/list")
	public String enterOrderList(Model model,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE_10) Integer pageSize){
		userList=new ArrayList<>();
		userList = getEnterPriseUserIds();
		//统计已使用次数
		String statisResult="0"; 
		//根据用户查询所有订单
		if(userList.size() > 0){
			PageHelper.startPage(pageNum, pageSize);
			studioOrders = studioConsumeOrderRecordService.findStudioOrderByMmebers(userList);
			pageInfoList=new PageInfo<>(studioOrders);
			
			statisResult = studioConsumeOrderRecordService.findStatisUsedNumber(userList);
		}else{
			pageInfoList = new PageInfo<>();
			
		}
		
		
		model.addAttribute("sum", statisResult);
		model.addAttribute("orders", pageInfoList);
		return "/enterprise/orderEnterprise/list";
	}
	
	/**
	* Title: EnterpriseOrderController.java
	* Description: 根据手机号码查询场馆订单
	* @param model
	* @param mobilePhone 用户手机号码
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	@RequestMapping("/enterpriseorder/findOrderByMobilePhoneNum")
	@ResponseBody
	public String selectEnterOrderByMobilePhoneNum(Model model,String mobilePhone,@RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE_10) Integer pageSize){
		//全部用户
		userList = new ArrayList<>();
		userList = getEnterPriseUserIds();
		
		if(userList.size() > 0){
			
			if(!"".equals(mobilePhone)){
				List<Integer> searchUser = studioConsumeOrderRecordService.findStudioOrder(mobilePhone);
				//所有的用户与手机号码查询出来的用户id进行交集
				userList.retainAll(searchUser);
			}else{
				// userList 所有的用户
			}
		
			if(userList.size() > 0){
				PageHelper.startPage(pageNum, pageSize);
				studioOrders = studioConsumeOrderRecordService.findStudioOrderByMmebers(userList);
				pageInfoList = new PageInfo<>(studioOrders);
			}else{
				pageInfoList=new PageInfo<>();
			}
		}else{
			pageInfoList=new PageInfo<>();
		}
		//根据手机号码模糊查询健身房订单
		return new Gson().toJson(pageInfoList);
	}
	
	/**
	* Title: EnterpriseOrderController.java
	* Description: 
	* @param pageNum
	* @param pageSize
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	public List<Integer> getEnterPriseUserIds(){
		
		cardList=new ArrayList<>();
		userList=new ArrayList<>();
		
		//查询当前企业的所有卡
		cardResult =  memberCardOrderRefService.getCardOrderByEnterId(this.getEnterPriseId());
		if(cardResult.size()  > 0){
			Map<String, Object> temp;
			for (int i = 0; i < cardResult.size(); i++) {
				temp=cardResult.get(i);
				if(null != temp){
					cardList.add(Integer.parseInt(String.valueOf(temp.get("orderId"))));
				}
			}
		}
		//根据企业的所有卡查询所有的用户
		if(cardList.size() > 0){
			userResult = userService.findUserByCards(cardList);
			if(userResult.size() > 0){
				Map<String, Object> userTemp;
				for (int i = 0; i < userResult.size(); i++) {
					userTemp = userResult.get(i);
					if(userTemp != null){
						userList.add(Integer.parseInt(String.valueOf(userTemp.get("memberId"))));
					}
					
				}
			}
		}
		
		
		
		return userList;
	}
	
	public static void main(String[] args) {
		//交集
		List<Integer> a=new ArrayList<>();
		a.add(1);
		a.add(2);
		
		List<Integer> b=new ArrayList<>();
		b.add(5);
		b.add(3);
		a.retainAll(b);
		System.out.println(a);
		System.out.println(b);
		System.out.println("ok");
	}
}
