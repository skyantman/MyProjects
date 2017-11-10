package com.yundongjia.app.user.controller.usercontroller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yundongjia.app.user.service.CoachInfoService;
import com.yundongjia.app.user.service.MemberCardInfoService;
import com.yundongjia.app.user.service.MemberInfoService;
import com.yundongjia.app.user.service.MyOrderService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.service.ConfigService;

/** * @author  作者WangLi: * @date 创建时间：2017年1月16日 上午10:57:26 * @version 1.0 * @parameter  * @since  * @return  */

/**
 * 
* @ClassName: MyOrderController 
* @Description: TODO(关于订单的控制类) 
* @author Wangli
* @date 2017年2月7日 下午4:00:39 
*
 */
@Controller
public class MyOrderController extends BaseController{
    
	@Autowired
	private CoachInfoService coachInfoService;
	@Autowired
	private MemberInfoService memberService;
	@Autowired
	private MemberCardInfoService memberCardInfoService;
	@Autowired
	private MyOrderService myOrderService;
	@Autowired
	private ConfigService configService;
	
	@RequestMapping(value="ydj/user/myorder")
	 public void myPage(String str) throws Exception{
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type = Integer.parseInt(map.get("type").toString());
		switch (type) {
		case 0://我的团课->团课列表(目前团课以单节为单位，如果后期还是之前一节团课要上好几节课的话，还得重新考虑子菜单)
			myLeagueList(map);
			break;
		case 1://我的订单->订单列表
			myorderList(map);
			break;
		case 2://我的订单->订单列表 -> 订单详情
			myorderDetail(map);
			break;
		default:
			break;
		}
	 }

	/**
	 * 
	* @Title: myorderList 
	* @Description: TODO(我的订单) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void myorderList(Map<String, Object> map){
		jsonclear();
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		/**
		 * orderStatus:0查询所有订单  1待上课的所有订单 2 待支付的所有订单  3 待评价的所有订单 
		 * 4 单独查询私课 5 单独查询团课 6 单独查询活动订单
		 * 7 单独查询健身房 8 单独查询商城订单
		 */
		String orderStatus =  map.get("orderStatus").toString();
		jsonArray = this.myOrderService.myOrder(memberId, orderStatus);
		try{
			jsonObject.put("Info", jsonArray);
			jsonObject.put("status", "0");
			jsonObject.put("message", "用户信息查询成功");
			
			 
			
		}catch(Exception e){
			jsonObject.put("status", "1");
			jsonObject.put("message", "用户信息查询失败");
		}
		this.RSAprivateencode(jsonObject.toString());
    }
	
	/**
	 * 
	* @Title: myLeagueList 
	* @Description: TODO(我的里面我的团课) 
	* @param @param map    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public void myLeagueList(Map<String, Object> map){
		jsonclear();
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		TActivityOrderExample example = new TActivityOrderExample();
		example.createCriteria().andMemberidEqualTo(memberId);
		try {
			List<TActivityOrder> list_leagueorder = this.myOrderService.myActivityOrdersList(example);
			for(TActivityOrder activityOrder:list_leagueorder){
				TActivity activity = this.myOrderService.myactivityList(activityOrder.getActivityid());
				TStudio studio = this.myOrderService.selectStudioInfo(activity.getStudioid());
				jsonObject.put("name", activity.getActivename());
				jsonObject.put("addr", studio.getStudioaddr());
				jsonObject.put("alreadyMan", activity.getAlreadyman());//已报名人数
				jsonObject.put("totalMoney", activityOrder.getTotalmoney());
				jsonObject.put("createDate", activity.getActivestarttime().replace("2017-", "").replace("-", "月"));
				TCoach coach = this.coachInfoService.selectCoachInfobyId(Integer.parseInt(activity.getCoachids()));
				jsonObject.put("coachName", coach.getNickname());
				jsonArray.add(jsonObject);
			 }
			    jsonObject2.put("Info", jsonArray);
			    jsonObject2.put("message", "查询成功");
			    jsonObject2.put("status", "0");
		} catch (Exception e) {
			    jsonObject2.put("message", "查询失败");
			    jsonObject2.put("status", "1");
		}finally {
			this.RSAprivateencode(jsonObject2.toString());
		}
	}
	
	

	/**
	 * @param orderType 订单类型     1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单
	 * @param proId 订单ID
	 * 订单详情
	 */
	private void myorderDetail(Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String , Object>();
		Map<String, Object> order = new HashMap<String , Object>();
		try {
			Integer orderType = Integer.parseInt(map.get("orderType").toString());
			Integer proId = Integer.parseInt(map.get("proId").toString());
			order = myOrderService.findOrderById(orderType , proId);
			Map<String , Object> shareInfo = new HashMap<String , Object>();
			shareInfo.put("url", configService.getConfigValueByName("SHARE_LINK_ORDER") + "?orderType="+ orderType +"&proId=" + proId);
			shareInfo.put("titel", configService.getConfigValueByName("SHARE_TITLE_ORDER"));
			shareInfo.put("content", configService.getConfigValueByName("SHARE_CONTENT_ORDER"));
			result.put("shareInfo", shareInfo);
			result.put("order", order);
			result.put("status", "0");
			result.put("message", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("order", order);
			result.put("status", "1");
			result.put("message", "查询失败");
		}
		this.RSAprivateencode(new Gson().toJson(result));
	}
	
}
