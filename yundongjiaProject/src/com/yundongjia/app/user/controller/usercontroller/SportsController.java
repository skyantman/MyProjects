package com.yundongjia.app.user.controller.usercontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yundongjia.app.user.service.AppAttachService;
import com.yundongjia.app.user.service.AppCoachRewardService;
import com.yundongjia.app.user.service.AppCoachService;
import com.yundongjia.app.user.service.AppCoachSkillRefService;
import com.yundongjia.app.user.service.AppCommentService;
import com.yundongjia.app.user.service.AppConfigService;
import com.yundongjia.app.user.service.AppFacilityService;
import com.yundongjia.app.user.service.AppOrderService;
import com.yundongjia.app.user.service.AppSkillService;
import com.yundongjia.app.user.service.AppStudioService;
import com.yundongjia.app.user.service.CoachInfoService;
import com.yundongjia.app.user.service.MemberCouponRefService;
import com.yundongjia.app.user.service.MemberShowTimeService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachReward;
import com.yundongjia.oa.admin.po.TCoachStudioRef;
import com.yundongjia.oa.admin.po.TCoachStudioRefExample;
import com.yundongjia.oa.admin.po.TComment;
import com.yundongjia.oa.admin.po.TFacility;
import com.yundongjia.oa.admin.po.TMemberShowtime;
import com.yundongjia.oa.admin.po.TMemberShowtimeExample;
import com.yundongjia.oa.admin.po.TPrivateLessonTime;
import com.yundongjia.oa.admin.po.TPrivateLessonTimeExample;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.DateUtil;
import com.yundongjia.oa.utils.JSONSort;
import com.yundongjia.oa.utils.UtilPage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** * @author  作者WangLi: * @date 创建时间：2017年2月7日 上午10:57:26 * @version 1.0 * @parameter  * @since  * @return  */

/**
 * 
 * @ClassName: SportsController
 * @Description: TODO(用户端首页运动页面接口)
 * @author Wangli
 * @date 2017年2月7日 下午4:01:40
 *
 */
@Controller
public class SportsController extends BaseController {
	@Autowired
	private MemberCouponRefService memberCouponRefService;
	@Autowired
	private AppStudioService appStudioService;
	@Autowired
	private AppCoachService appCoachService;
	@Autowired
	private AppAttachService attachService;
	@Autowired
	private AppSkillService skillService;
	@Autowired
	private AppCoachRewardService appCoachRewardService;
	@Autowired
	private MemberShowTimeService memberShowTimeService;
	@Autowired
	private AppOrderService appOrderService;
	@Autowired
	private AppFacilityService appFacilityService;
	@Autowired
	private CoachInfoService coachInfoService;
	@Autowired
	private AppConfigService appConfigService;
	@Autowired
	private AppCoachSkillRefService appCoachSkillRefService;
	@Autowired
	private AppCommentService appCommentService;
	
	List<Map<String, Object>> mapList;
	Map<String, Object> mapResult;
	Map<String, Object> param;

	List<Map<String, Object>> pageResultMap;

	@RequestMapping(value = "ydj/user/sports")
	public void myPage(String str) throws Exception {
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type = Integer.parseInt(map.get("type").toString());

		switch (type) {
		case 0: // 运动首页接口(加载场馆列表)
			map.put("searchName", null);
			studioList(map);
			break;
		case 1: // 首页搜索接口
			indexSearch(map);
			break;
		case 2: // 我的代金券-代金券列表接口
			myCouponList(map);
			break;
		case 3: //点击首页场馆展示场馆详细信息-接口 
			studioById(map);
			break;
		case 5:// 展示所有教练列表的接口
			map.put("searchName", null);
			coachList(map);
			break; 
		case 6:// 私教订单订单详情(查看订单)
			privateOrderDetail(map);
			break;
		case 7:// 点击教练展示教练详细信息
			getCoachById(map);
			break;
		case 8:// 点击教练详细信息下的立即预约展示教练可被预约的时间段的接口
			getCoachAvailableAndUnAvailableTimeSpan(map);
			break;
		case 9:// 检测是否有未停止健身行为
			findisshowover(map);
			break;
		case 10:// 停止健身
			stopshowtime(map);
			break;
		case 11://首页轮播图
			pageImgs(map);
			break;
		case 12:// 结束运动分享页面
			overSportShare(map);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 根据日期获得星期
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		String[] weekDaysCode = { "0", "1", "2", "3", "4", "5", "6" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysName[intWeek];
	}

	/**
	 * Title: privateOrderDetail Description: 私教订单详情
	 * 
	 * @param map
	 * @author HuangJian
	 * @date 2017年2月16日
	 */
	public void privateOrderDetail(Map<String, Object> map) {
		jsonclear();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			mapResult = appOrderService.getOrderById(map);
			if (mapResult != null) {
				jsonObject.put("orderId", mapResult.get("orderId"));
				jsonObject.put("totalMoney", mapResult.get("totalMoney"));
				jsonObject.put("nickName", mapResult.get("nickName"));
				jsonObject.put("hour", mapResult.get("hour"));// 课时
				jsonObject.put("timeSpan", mapResult.get("timeSpan"));// 时段
				jsonObject.put("classDate", mapResult.get("classDate"));// 上课日期
				jsonObject.put("weekNum", getWeekOfDate(sdf.parse(mapResult.get("classDate").toString())));
			}
			jsonObject.put("status", "0");
			jsonObject.put("message", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("status", "1");
			jsonObject.put("message", "查询失败");
		} finally {

			this.RSAprivateencode(jsonObject.toString());
		}

	}

	/**
	 * Title: indexSearch Description: 模糊查询 教练名称，场馆名称
	 * 
	 * @param map
	 * @author HuangJian
	 * @date 2017年2月16日
	 */
	public void indexSearch(Map<String, Object> map) {
		jsonclear();
		String sName = String.valueOf(map.get("searchName"));
		//Integer pageNum = Integer.parseInt(String.valueOf(map.get("pageNum")));
		sName = sName.trim();
		try {
			if (sName != null || !"".equals(sName)) {
				
				map.put("searchName", "%" + sName + "%");

				// 教练查询结果
				// -------------------------------------------------------
				List<Map<String, Object>> coachMap = appCoachService.findAppCoachList(map);
				//pageResultMap=new ArrayList<>();
				/*UtilPage page =new UtilPage(ConstantVo.APP_PAGE_SIZE, coachMap.size(), pageNum);
				if(coachMap.size() >0 && pageNum <= page.getCurrentPage()){
					for(int i=page.getFromIndex();i<page.getToIndex();i++){
						pageResultMap.add(coachMap.get(i));
					}
				}*/
				
				JSONObject coachObj = new JSONObject();
				JSONArray coachArr = new JSONArray();
				for (Map<String, Object> coachTempMap : coachMap) {
					coachObj.put("coachId", coachTempMap.get("coachId"));
					coachObj.put("imgpath", coachTempMap.get("imgpath") == null ? "" : coachTempMap.get("imgpath"));
					coachObj.put("nickName", coachTempMap.get("nickName"));
					coachArr.add(coachObj);
				}

				jsonObject.put("coachInfo", coachArr);
				// -------------------------------------------------------

				// 场馆查询结果
				// -------------------------------------------------------
				List<Map<String, Object>> studioMap = appStudioService.findStudioList(map);
				/*pageResultMap = new ArrayList<>();
				page =new UtilPage(ConstantVo.APP_PAGE_SIZE,studioMap.size(), pageNum);
				if(studioMap.size() >0 && pageNum <= page.getCurrentPage()){
					for(int i=page.getFromIndex();i<page.getToIndex();i++){
						pageResultMap.add(studioMap.get(i));
					}
				}*/
				
				JSONObject studioObj = new JSONObject();
				JSONArray studioArr = new JSONArray();
				JSONObject jsonObject3 = new JSONObject();
				for (Map<String, Object> studioMapTemp : studioMap) {
					jsonArray2.clear();
					studioObj.put("studioId", studioMapTemp.get("studioId"));
					studioObj.put("studioName", studioMapTemp.get("studioName"));
					studioObj.put("sellCount",studioMapTemp.get("sellCount") == null ? 0 : studioMapTemp.get("sellCount"));// 销售人数
					studioObj.put("areaName", studioMapTemp.get("areaName"));
					studioObj.put("path", studioMapTemp.get("path"));
					studioObj.put("consumeMoney", studioMapTemp.get("consumeMoney"));// 非会员价
					studioObj.put("memPrice", studioMapTemp.get("memPrice"));// 会员价
					studioObj.put("distance", studioMapTemp.get("distance"));
					
					
					studioObj.put("activityCount", studioMapTemp.get("activityCount"));//场馆活动总数
					studioObj.put("memberDiscount", studioMapTemp.get("memberDiscount"));//会员折扣
					studioObj.put("gradeScore", studioMapTemp.get("gradeScore"));//评分
					studioObj.put("lng", studioMapTemp.get("lng"));
					studioObj.put("lat", studioMapTemp.get("lat"));
					studioObj.put("isVip", studioMapTemp.get("isVip"));
					studioObj.put("type", studioMapTemp.get("type"));
					
					jsonObject3.put("iconPath", "/images/studioIcon/v@3x.png");
					jsonObject3.put("iconValue", "会员卡"+studioMapTemp.get("memberDiscount")+"折");
					jsonArray2.add(jsonObject3);
					
					studioObj.put("icon", jsonArray2);
					
					studioArr.add(studioObj);
				}
				jsonObject.put("studioInfo", studioArr);
				// -------------------------------------------------------
			} else {

			}

			jsonObject.put("status", "0");
			jsonObject.put("message", "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("status", "1");
			jsonObject.put("message", "查询失败");
		} finally {

			this.RSAprivateencode(jsonObject.toString());
		}

	}

	/**
	 * Title: getCoachById Description: 教练详情
	 * 
	 * @param map
	 * @author HuangJian
	 * @date 2017年2月15日
	 */
	public void getCoachById(Map<String, Object> map) {
		jsonclear();
		Integer coachId = Integer.parseInt(String.valueOf(map.get("coachId")));

		try {
			Map<String, Object> coach = appCoachService.selectAppCoachById(coachId);
			if (coach != null) {
				jsonObject.put("coachId", coach.get("coachId"));
				jsonObject.put("nickName", coach.get("nickName"));
				jsonObject.put("imgpath", coach.get("imgpath")==null?"":coach.get("imgpath"));
				jsonObject.put("introduce", coach.get("introduce"));
				jsonObject.put("studioAddr", coach.get("studioAddr"));
				jsonObject.put("coursePrice", coach.get("coursePrice"));
				jsonObject.put("workAge", coach.get("workAge"));
				jsonObject.put("studioName", coach.get("studioName"));
				jsonObject.put("memPrice", coach.get("memPrice"));
				jsonObject.put("lat", coach.get("lat"));
				jsonObject.put("lng", coach.get("lng"));
				// jsonObject.put("keywords", coach.get("keywords"));//个性标签
				// ----------------------------------------
				//JSONObject imgsObj = new JSONObject();
				JSONArray imgsArr = new JSONArray();
				// 教练轮播图
				List<TAttach> attachs = attachService.getAttachByActivityId(coachId, ConstantVo.ATTACH_TYPE_COACH);
				if (attachs != null && attachs.size() > 0) {
					for(TAttach attach : attachs){
						imgsArr.add(attach.getPath() == null?"":attach.getPath());
					}
					/*for (int i = 0; i < attachs.size()-1; i++) {
						TAttach att = attachs.get(i);
						//imgsObj.put("height", att.getImgheight());
						//imgsObj.put("width", att.getImgwidth());
						//imgsObj.put("position", att.getImgordernum());
						//imgsObj.put("path", att.getPath());
						System.out.println(att.getPath());
						imgsArr.add(att.getPath() == null?"":att.getPath());
					}
					imgsArr.add(attachs.get(attachs.size()-1).getPath());*/
				}
				jsonObject.put("imgs", imgsArr);// 轮播图
				// ----------------------------------------

				// ------- 个性标签
				String keys = String.valueOf(coach.get("keywords"));
				
				JSONArray keysArr = new JSONArray();
				if (!"null".equals(keys) && keys != null && !"".equals(keys)) {
					String[] keyName = keys.split(",");
					//JSONObject keysObj = new JSONObject();
					if(keyName != null || keyName.length>0){
						for (int i = 0; i < keyName.length; i++) {
							//keysObj.put("keyName", keyName[i]);
							keysArr.add(keyName[i]==null?"":keyName[i]);
						}

						jsonObject.put("keywords", keysArr);
					}
					
				}else{
					jsonObject.put("keywords",keysArr);
				}
				// ----------------------------

				// ----------------擅长课程
				List<Map<String, Object>> skillds = skillService.getSkillByCoachId(coachId);
				JSONArray sksArr = new JSONArray();
				if (skillds != null && skillds.size() > 0) {
					JSONObject sksObj = new JSONObject();
					for (Map<String, Object> t : skillds) {
						//sksObj.put("skillId", t.get("skillId"));
						//sksObj.put("skillName", t.get("skillName"));
						sksArr.add(t.get("skillName")==null?"":t.get("skillName"));
					}
					
				}
				jsonObject.put("skills", sksArr);
				// -------------------------------

				// -------------------荣获奖励
				List<TCoachReward> coachRewards = appCoachRewardService.getCoachRewardByCoachId(coachId);
				JSONArray crArr = new JSONArray();
				if (coachRewards != null && coachRewards.size() > 0) {
					JSONObject crObj = new JSONObject();
					for (TCoachReward cr : coachRewards) {
						//crObj.put("rewName", cr.getReward());
						//crObj.put("rewOrder", cr.getOrdernum());
						crArr.add(cr.getReward()==null?"":cr.getReward());
					}
					
				}
				jsonObject.put("rewards", crArr);
				// --------------------------
			}
			jsonObject.put("status", "0");
			jsonObject.put("message", "查询成功");

		} catch (Exception e) {
			jsonObject.put("status", "1");
			jsonObject.put("message", "查询失败");
		} finally {

			this.RSAprivateencode(jsonObject.toString());
		}

	}

	/**
	 * Title: coachList Description: 教练列表
	 * 
	 * @param map
	 * @author HuangJian
	 * @date 2017年2月15日
	 */
	public void coachList(Map<String, Object> map) {
		jsonclear();
		try {
			Integer pageNum = Integer.parseInt(String.valueOf(map.get("pageNum")));
			mapList = appCoachService.findAppCoachList(map);
			//排序根据距离从近到远
			if(mapList != null || mapList.size() > 0){
				Collections.sort(mapList, new Comparator<Map<String, Object>>(){  
					  
		            public int compare(Map<String, Object> o1, Map<String, Object> o2) {  
		            	
		                if(Long.parseLong(o1.get("distance").toString()) > Long.parseLong(o2.get("distance").toString())){  
		                    return 1;  
		                }  
		                if(Long.parseLong(o1.get("distance").toString()) == Long.parseLong(o2.get("distance").toString())){  
		                    return 0;  
		                }  
		                return -1;  
		            }  
		        }); 
			}
			
			
			pageResultMap=new ArrayList<>();
			UtilPage page =new UtilPage(ConstantVo.APP_PAGE_SIZE, mapList.size(), pageNum);
			if(mapList.size() >0 && pageNum <= page.getCurrentPage()){
				for(int i=page.getFromIndex();i<page.getToIndex();i++){
					pageResultMap.add(mapList.get(i));
				}
			}
			
			for (Map<String, Object> temp : pageResultMap) {

				jsonObject.put("coachId", temp.get("coachId"));
				jsonObject.put("nickName", temp.get("nickName"));
				jsonObject.put("workAge", temp.get("workAge"));
				jsonObject.put("studioName", temp.get("studioName"));
				jsonObject.put("coursePrice", temp.get("coursePrice"));
				jsonObject.put("imgpath", temp.get("imgpath")==null?"":temp.get("imgpath"));
				jsonObject.put("memPrice", temp.get("memPrice"));
				jsonObject.put("distance", temp.get("distance"));// 距离
				jsonObject.put("lng", temp.get("lng"));
				jsonObject.put("lat", temp.get("lat"));

				jsonArray.add(jsonObject);
			}
			jsonObject2.put("status", "0");
			jsonObject2.put("message", "查询成功");
			jsonObject2.put("Info", jsonArray);
		} catch (NumberFormatException e) {
			jsonObject2.put("status", "1");
			jsonObject2.put("message", "查询失败");
		} finally {

			this.RSAprivateencode(jsonObject2.toString());
		}

	}

	/**
	 * Title: myCouponList Description: 卷
	 * 
	 * @param map
	 * @author HuangJian
	 * @date 2017年2月14日
	 */
	public void myCouponList(Map<String, Object> map) {
		param = new HashMap<>();
		jsonclear();
		try {
			Integer memberId = Integer.parseInt(String.valueOf(map.get("memberId")));

			param.put("memberId", memberId);

			mapList = memberCouponRefService.findCouponListByMember(param);
			if (mapList != null) {
				for (Map<String, Object> temp : mapList) {
					jsonObject.put("rowId", temp.get("rowId"));
					jsonObject.put("memberId", temp.get("memberId"));
					jsonObject.put("couponMethod", temp.get("couponMethod"));
					jsonObject.put("discountAmount", temp.get("discountAmount"));
					jsonObject.put("status", temp.get("status"));
					jsonObject.put("expirtionDate",temp.get("expirtionDate"));
					jsonObject.put("couponTypeName", temp.get("couponTypeName"));
					jsonObject.put("maxMoney", temp.get("maxMoney"));
					jsonObject.put("startMoney", temp.get("startMoney"));
					jsonArray.add(jsonObject);
				}
			}
			jsonObject2.put("Info", jsonArray);
			jsonObject2.put("status", "0");
			jsonObject2.put("message", "查询成功");
		} catch (NumberFormatException e) {
			jsonObject2.put("status", "1");
			jsonObject2.put("message", "查询失败");

		} finally {

			this.RSAprivateencode(jsonObject2.toString());
		}

	}

	/**
	 * Title: studioList Description: 场馆列表  离我最近
	 * 
	 * @param param
	 * @author HuangJian
	 * @date 2017年2月14日
	 */
	public void studioList(Map<String, Object> param) {
		jsonclear();
		Integer pageNum = Integer.parseInt(String.valueOf(param.get("pageNum")));
		try {
			pageResultMap = new ArrayList<>();
			mapList = appStudioService.findStudioList(param);
			//排序根据距离从近到远
			if(mapList != null && mapList.size() > 0){
				Collections.sort(mapList, new Comparator<Map<String, Object>>(){  
					  
		            public int compare(Map<String, Object> o1, Map<String, Object> o2) {  
		            	
		                if(Long.parseLong(o1.get("distance").toString()) > Long.parseLong(o2.get("distance").toString())){  
		                    return 1;  
		                }  
		                if(Long.parseLong(o1.get("distance").toString()) == Long.parseLong(o2.get("distance").toString())){  
		                    return 0;  
		                }  
		                return -1;  
		            }  
		        }); 
			}
			
			
			UtilPage page =new UtilPage(ConstantVo.APP_PAGE_SIZE, mapList.size(), pageNum);
			if(mapList.size() >0 && pageNum <= page.getCurrentPage()){
				for(int i=page.getFromIndex();i<page.getToIndex();i++){
					pageResultMap.add(mapList.get(i));
				}
			}
			if(pageResultMap != null && pageResultMap.size() > 0){
				JSONObject jsonObject3 = new JSONObject();
				for (Map<String, Object> temp : pageResultMap) {
					jsonObject3.clear();
					jsonArray2.clear();
					jsonObject.put("studioId", temp.get("studioId"));
					jsonObject.put("studioName", temp.get("studioName"));
					jsonObject.put("sellCount", temp.get("sellCount")==null?0:temp.get("sellCount"));// 销售人数
					jsonObject.put("areaName", temp.get("areaName"));
					jsonObject.put("path", temp.get("path"));
					jsonObject.put("consumeMoney", temp.get("consumeMoney"));// 非会员价
					jsonObject.put("memPrice", temp.get("memPrice"));// 会员价
					jsonObject.put("distance", temp.get("distance"));
					jsonObject.put("activityCount", temp.get("activityCount"));//场馆活动总数
					jsonObject.put("memberDiscount", temp.get("memberDiscount"));//会员折扣
					jsonObject.put("gradeScore", temp.get("gradeScore"));//评分
					jsonObject.put("lng", temp.get("lng"));
					jsonObject.put("lat", temp.get("lat"));
					jsonObject.put("isVip", temp.get("isVip"));
					jsonObject.put("type", temp.get("type"));
					jsonObject3.put("iconPath", "/images/studioIcon/v@3x.png");
					jsonObject3.put("iconValue", "会员卡"+temp.get("memberDiscount")+"折");
					jsonArray2.add(jsonObject3);
					jsonObject.put("icon", jsonArray2);
					
					
					jsonArray.add(jsonObject);
				}
			}
			
			
			jsonObject2.put("status", "0");
			jsonObject2.put("message", "查询成功");
			jsonObject2.put("Info", jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject2.put("status", "1");
			jsonObject2.put("message", "查询失败");
		} finally {

			this.RSAprivateencode(jsonObject2.toString()); 
		}
	}

	/**
	 * Title: studioById Description: 根据场馆ID查询场馆
	 * 
	 * @param map
	 * @author HuangJian
	 * @date 2017年2月15日
	 */
	public void studioById(Map<String, Object> map) {
		jsonclear();
		JSONArray iconArray=new JSONArray();
		JSONObject iconObject=new JSONObject();
		try {
			Integer studioId = Integer.parseInt(String.valueOf(map.get("studioId")));
			mapResult = appStudioService.selectStudioById(map);
			if (mapResult.size() > 0) {
				//场馆图片
				List<TAttach> attachs = attachService.getAttachByActivityId(studioId, ConstantVo.ATTACH_TYPE_STUDIO);
				if (attachs != null && attachs.size()>0) {
					TAttach att;
					//Map<String, Object> imgMap = new HashMap<>();
					for (int i = 0; i < attachs.size()-1; i++) {
						att = attachs.get(i);
						//imgMap.put("height", att.getImgheight()==null?"":att.getImgheight());
						//imgMap.put("width", att.getImgwidth()==null?"":att.getImgwidth());
						//imgMap.put("path", );
						//imgMap.put("position", att.getImgordernum());
						jsonArray.add(att.getPath()==null?"":att.getPath());
					}
					
					jsonArray.add(attachs.get(attachs.size()-1).getPath());
				}
				
				//服务设施
				String strSE = String.valueOf(mapResult.get("studioEquip"));
				JSONArray studioEquipJson=new JSONArray();
				if(strSE != null && !"".equals(strSE)){
					JSONObject studioEquipJsonObj=new JSONObject(); 
					String [] strSeArray=strSE.split(",");
					TFacility facility;
					for(int i=0;i<strSeArray.length;i++){
						facility = appFacilityService.getFacilityById(Integer.parseInt(strSeArray[i]));
						studioEquipJsonObj.put("id", facility.getFacilityid());
						studioEquipJsonObj.put("name", facility.getFacilityname());
						studioEquipJsonObj.put("path", facility.getImgpath()==null?"":facility.getImgpath());
						studioEquipJson.add(studioEquipJsonObj);
						
					}
				}
				
				iconArray.clear();
				jsonObject.put("studioEquips", studioEquipJson);
				jsonObject.put("imgs", jsonArray);
				jsonObject.put("studioId", mapResult.get("studioId"));
				jsonObject.put("studioName", mapResult.get("studioName"));
				jsonObject.put("studioTel", mapResult.get("studioTel"));
				jsonObject.put("studioEquipName", mapResult.get("studioEquipName"));// 多个服务设施名称
				jsonObject.put("studioOpentime", mapResult.get("studioOpentime"));
				jsonObject.put("consumeMoney", mapResult.get("consumeMoney"));
				jsonObject.put("memPrice", mapResult.get("memPrice"));
				jsonObject.put("studioIntroduce", mapResult.get("studioIntroduce"));
				jsonObject.put("studioAddr", mapResult.get("studioAddr"));
				jsonObject.put("status", mapResult.get("status"));
				jsonObject.put("lng", mapResult.get("lng"));
				jsonObject.put("lat", mapResult.get("lat"));
				jsonObject.put("gradeScore", mapResult.get("gradeScore"));
				jsonObject.put("isVip", mapResult.get("isVip"));//是否是会员价
				jsonObject.put("type", mapResult.get("type"));//场馆类型
				jsonObject.put("isReserve", mapResult.get("isReserve"));
				iconObject.put("iconPath", "/images/studioIcon/v@3x.png");
				iconObject.put("iconValue", "会员卡"+mapResult.get("memberDiscount")+"折");
				iconArray.add(iconObject);
				jsonObject.put("icon", iconArray);
				
				//当前场馆的所有教练
				List<Map<String, Object>> coachs =  appCoachSkillRefService.getCoachByStudioId(studioId);
				JSONArray coachJson = new JSONArray();
				List<Map<String, Object>> skills = null;
				JSONArray skillsArr = new JSONArray();
				JSONObject skillObj = new JSONObject();
				for (Map<String, Object> cMap : coachs) {
					skillObj.clear();
					skillsArr.clear();
					JSONObject coachObj = new JSONObject();
					coachObj.put("coachId", cMap.get("coachId"));
					coachObj.put("imgpath", cMap.get("imgpath"));
					coachObj.put("nickName", cMap.get("nickName"));
					coachObj.put("coachGrade", cMap.get("gradeScore"));//等级
					//擅长课程
					skills =  (List<Map<String, Object>>) cMap.get("coachSkill");
					for (Map<String, Object> sks : skills) {
						//skillObj.put("skillName",sks.get("skillName")==null?"":sks.get("skillName"));
						skillsArr.add(sks.get("skillName")==null?"":sks.get("skillName"));
					}
					coachObj.put("skills", skillsArr);//擅长课程
					coachJson.add(coachObj);
				}
				jsonObject.put("coachCount", coachs.size());//教练总计
				jsonObject.put("coachs", coachJson);//教练列表
				
				
				Map<String, Object> commParam= new HashMap<>();
				commParam.put("dataId", studioId);
				commParam.put("typeId", 0);
				
				SimpleDateFormat full = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				SimpleDateFormat sdf = new SimpleDateFormat("M月dd日");
				//场馆评论
				List<TComment> comments =  appCommentService.findCommentByTypeId(commParam);
				JSONObject comsJson = new JSONObject();
				JSONArray comsArray = new JSONArray();
				for (TComment t : comments) {
					comsJson.put("nickName", t.getNickname());
					comsJson.put("imgPath", t.getImgpath());
					comsJson.put("gradeScore", t.getGradescore());
					comsJson.put("content", t.getContent());
					comsJson.put("cDate",sdf.format(full.parse(t.getCreatedate())));
					comsArray.add(comsJson);
				}
				jsonObject.put("studioGradeScore", comsArray);
			}
			jsonObject.put("status", "0");
			jsonObject.put("message", "查询成功");

			
			
			
			
		} catch (NumberFormatException e) {
			jsonObject.put("status", "1");
			jsonObject.put("message", "查询失败");
		} catch (ParseException e) {
			jsonObject.put("status", "1");
			jsonObject.put("message", "查询失败");
		} finally {

			this.RSAprivateencode(jsonObject.toString());
		}
	}

	/**
	 * 
	 * @Title: stopshowtime @Description: TODO(停止健身) @param 设定文件 @return void
	 * 返回类型 @throws
	 */
	public void stopshowtime(Map<String, Object> map) {
		JSONObject jsonObject = new JSONObject();
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		String showendtime = map.get("showendtime").toString();
		String timespan = map.get("timespan").toString();
		TMemberShowtime showtime = new TMemberShowtime();
		TMemberShowtimeExample example = new TMemberShowtimeExample();
		example.createCriteria().andMemberidEqualTo(memberId).andIsshowoverEqualTo("1");
		example.setOrderByClause("timeId desc;");
		List<TMemberShowtime> list = this.memberShowTimeService.selectByExample(example);
		showtime.setShowendtime(showendtime);
		showtime.setTimespan(timespan);
		showtime.setIsshowover("0");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(0);
		String[] split = timespan.split(":");
		calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(split[0]));
		calendar.add(Calendar.MINUTE, Integer.parseInt(split[1]));
		calendar.add(Calendar.SECOND, Integer.parseInt(split[2]));
		showtime.setMillisecond(calendar.getTimeInMillis()+"");
		try {
			if(list.size() == 0){
			
			}else{
				showtime.setTimeid(list.get(0).getTimeid());
				this.memberShowTimeService.updateByPrimaryKeySelective(showtime);
			}
			jsonObject.put("status", "0");
			jsonObject.put("message", "结束健身成功");
		} catch (Exception e) {
			jsonObject.put("status", "1");
			jsonObject.put("message", "结束健身失败");
			
		} finally {
			this.RSAprivateencode(jsonObject.toString());
		}

	}

	/**
	 * 
	 * @Title: findisshowover @Description: TODO(检测是否有未停止的健身行为) @param
	 * 设定文件 @return void 返回类型 @throws
	 */
	public void findisshowover(Map<String, Object> param) {
		JSONObject jsonObject = new JSONObject();
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer memberId = Integer.parseInt(param.get("memberId").toString());
		TMemberShowtimeExample example = new TMemberShowtimeExample();
		example.createCriteria().andMemberidEqualTo(memberId).andIsshowoverEqualTo("1");
		List<TMemberShowtime> list = memberShowTimeService.selectByExample(example);
		if (list.size() > 0) {
			jsonObject.put("showstarttime", list.get(0).getShowstarttime());
			jsonObject.put("currenttime", dFormat.format(new Date()));
			jsonObject.put("timeId", list.get(0).getTimeid());
			jsonObject.put("status", "0");
			jsonObject.put("message", "查询成功");
		} else {
			jsonObject.put("status", "1");
			jsonObject.put("message", "没有未停止的健身行为");
		}
		this.RSAprivateencode(jsonObject.toString());
	}
	
	
	
	
	
	/**
	 * @throws ParseException 
	 * 
	* @Title: getCoachAvailableAndUnAvailableTimeSpan 
	* @Description: TODO(查询今天和后六天的教练的可用时间) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
		public void getCoachAvailableAndUnAvailableTimeSpan(Map<String, Object> map) throws ParseException {
			jsonclear();
		    SimpleDateFormat sdf=new SimpleDateFormat("E");
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2=new SimpleDateFormat("MM.dd");
			Integer coachId = Integer.parseInt(map.get("coachId").toString());
            TCoach coach = this.coachInfoService.selectCoachInfobyId(coachId);
			if (null == coach) {
				jsonObject2.put("status", "1");
				jsonObject2.put("messaage", "该教练不存在,请核实");
				return;
			}
			TCoachStudioRefExample example = new TCoachStudioRefExample();
			example.createCriteria().andCoachidEqualTo(coachId);
			List<TCoachStudioRef> list_coach_studio_ref = this.coachInfoService.selectCoachStudioRefInfo(example);
			TStudio studio = this.appStudioService.selectStudioInfo(list_coach_studio_ref.get(0).getStudioid());
			jsonObject2.put("coachId", coach.getCoachid());
			jsonObject2.put("studioId", list_coach_studio_ref.get(0).getStudioid());
			jsonObject2.put("nickName", coach.getNickname());
			jsonObject2.put("studioAddr", studio.getStudioaddr());
			jsonObject2.put("studioName", studio.getStudioname());
			jsonObject2.put("coursePrice", coach.getCourseprice());
			// 1.根据教练id 查询所属场馆开放时间
			// 2.获取当前日期以及当前时间的后6天的日期
			String date0 = DateUtil.getDateByDay(new Date(), 0);
			String date1 = DateUtil.getDateByDay(new Date(), 1);
			String date2 = DateUtil.getDateByDay(new Date(), 2);
			String date3 = DateUtil.getDateByDay(new Date(), 3);
			String date4 = DateUtil.getDateByDay(new Date(), 4);
			String date5 = DateUtil.getDateByDay(new Date(), 5);
			String date6 = DateUtil.getDateByDay(new Date(), 6);
			StringBuffer sbstr = new StringBuffer();
			String dateTime0 = date0.replaceAll("-", "");
			String dateTime1 = date1.replaceAll("-", "");
			String dateTime2 = date2.replaceAll("-", "");
			String dateTime3 = date3.replaceAll("-", "");
			String dateTime4 = date4.replaceAll("-", "");
			String dateTime5 = date5.replaceAll("-", "");
			String dateTime6 = date6.replaceAll("-", "");
			List<String> aList = new ArrayList<String>();
			aList.add(dateTime0);
			aList.add(dateTime1);
			aList.add(dateTime2);
			aList.add(dateTime3);
			aList.add(dateTime4);
			aList.add(dateTime5);
			aList.add(dateTime6);
			sbstr.append(dateTime0);
			sbstr.append(",");
			sbstr.append(dateTime1);
			sbstr.append(",");
			sbstr.append(dateTime2);
			sbstr.append(",");
			sbstr.append(dateTime3);
			sbstr.append(",");
			sbstr.append(dateTime4); 
			sbstr.append(",");
			sbstr.append(dateTime5);
			sbstr.append(",");
			sbstr.append(dateTime6);
			Map<String, String> amapSort = new HashMap<String, String>();
			TPrivateLessonTimeExample timeExample = new TPrivateLessonTimeExample();
			timeExample.createCriteria().andLessondateIn(aList).andCoachidEqualTo(coachId);
			List<TPrivateLessonTime> classList = this.coachInfoService.selectCoachworktime(timeExample);
			String opentime = studio.getStudioopentime();
			String coachNoSeetingAvailableTime = getCoachNoSeetingAvailableTime(opentime);
			String coachNoSeetingUnavailableTime = getCoachNoSeetingUnavailableTime(coachNoSeetingAvailableTime);
			String avaliAble="";
			String unAvaiAble="";
			String nowDate=DateUtil.getDate();
			if (classList.size() > 0) {
				for (int k = 0; k < aList.size(); k++) {
					for (TPrivateLessonTime vo : classList) {
						if (vo.getLessondate().equals(aList.get(k).toString())) {
							amapSort.put(aList.get(k).toString(), aList.get(k).toString());
							if (nowDate.equals(aList.get(k).toString())) {
								jsonObject.put("lessonDate", sdf2.format(sdf1.parse((vo.getLessondate()))));
								jsonObject.put("week", weeks(sdf.format(sdf1.parse(aList.get(k)))));
								jsonObject.put("rowId",vo.getRowid());
								if ("".equals(vo.getAvailabletimespan())
										|| null == vo.getAvailabletimespan()) {
									jsonObject.put("availableTimeSpan", "-1");
								} else {
									avaliAble = getCoachLessonTime(vo
											.getAvailabletimespan());
									unAvaiAble = getCoacchUnlessonTime(getCoachLessonTime(vo.getAvailabletimespan()));
									jsonObject.put("availableTimeSpan",getCoachLessonTime(vo.getAvailabletimespan()));
								}
								if(vo.getAvailabletimespan() == null){
									jsonObject.put("unAvailableTimeSpan","-1");
								}else{
									jsonObject.put("unAvailableTimeSpan",
											getCoacchUnlessonTime(getCoachLessonTime(vo.getAvailabletimespan())));
								}
								
								jsonArray.add(jsonObject);
							} else {

								jsonObject.put("lessonDate", sdf2.format(sdf1.parse((vo.getLessondate()))));
								jsonObject.put("week", weeks(sdf.format(sdf1.parse(aList.get(k)))));
								jsonObject.put("rowId",vo.getRowid());
								String availableTimeSpan = "";
								if ("".equals(vo.getAvailabletimespan()) || null == vo.getAvailabletimespan()) {
									availableTimeSpan = "-1";
									jsonObject.put("availableTimeSpan", availableTimeSpan);
									jsonObject.put("unAvailableTimeSpan",vo.getUnavailabletimespan());
								} else {
									availableTimeSpan = coachNoSeetingAvailableTime;
									jsonObject.put("availableTimeSpan",vo.getAvailabletimespan());

								}
								String unAvaiableTime =vo.getUnavailabletimespan();
								jsonObject.put("unAvailableTimeSpan", unAvaiableTime);

								jsonArray.add(jsonObject);

							}

						}
							
					}
	           
				}

				for (String string : amapSort.keySet()) {
					for (int m = 0; m < aList.size(); m++) {
						if (aList.get(m).equals(string)) {
							aList.remove(string);
						}
					}
				}

				for (int k = 0; k < aList.size(); k++) {
					jsonObject.clear();
					jsonObject.put("lessonDate", sdf2.format(sdf1.parse((aList.get(k)))));
					jsonObject.put("week", weeks(sdf.format(sdf1.parse(aList.get(k)))));
					
					
					if(nowDate.equals(aList.get(k).toString())){
						avaliAble=getCoachLessonTime(coachNoSeetingAvailableTime);
						unAvaiAble= getCoacchUnlessonTime(coachNoSeetingAvailableTime);
						jsonObject.put("availableTimeSpan", avaliAble);
						jsonObject.put("unAvailableTimeSpan", unAvaiAble);
						coachNoSeetingAvailableTime=avaliAble;
						coachNoSeetingUnavailableTime=unAvaiAble;
					}else{
						coachNoSeetingAvailableTime=getCoachNoSeetingAvailableTime(opentime);
						coachNoSeetingUnavailableTime = getCoachNoSeetingUnavailableTime(coachNoSeetingAvailableTime);
						jsonObject.put("availableTimeSpan", coachNoSeetingAvailableTime);
						jsonObject.put("unAvailableTimeSpan", coachNoSeetingUnavailableTime);
						
					}

					jsonArray.add(jsonObject);
					// 向数据库插入教练时间，然后再
				
					Integer rowId = createAvailabeRecore(coachId,aList.get(k),coachNoSeetingAvailableTime,coachNoSeetingUnavailableTime);
					jsonObject.put("rowId",rowId);
				}
				jsonObject2.put("status", "0");
				jsonObject2.put("message", "教练开放课时时间查询成功");
				jsonObject2.put("Info",jsonArray);
			} else {

				String[] dateTime = sbstr.toString().split(",");
				jsonObject.clear();
				for (int j = 0; j < dateTime.length; j++) {
					jsonObject.clear();
					Integer rowId = 0;
					if(nowDate.equals(dateTime[j])){
						avaliAble=getCoachLessonTime(coachNoSeetingAvailableTime);
						unAvaiAble=getCoacchUnlessonTime(avaliAble);
						jsonObject.put("availableTimeSpan", getCoachLessonTime(coachNoSeetingAvailableTime));
						jsonObject.put("unAvailableTimeSpan",
								getCoacchUnlessonTime(avaliAble));
						rowId = createAvailabeRecore(coachId,dateTime[j],avaliAble,unAvaiAble);
					}else{
						jsonObject.put("availableTimeSpan", coachNoSeetingAvailableTime);
						jsonObject.put("unAvailableTimeSpan",
								coachNoSeetingUnavailableTime);
						
						 rowId = createAvailabeRecore(coachId,dateTime[j],coachNoSeetingAvailableTime,coachNoSeetingUnavailableTime);
					}
					jsonObject.put("lessonDate", sdf2.format(sdf1.parse((dateTime[j]))));
					jsonObject.put("week", weeks(sdf.format(sdf1.parse(dateTime[j]))));
					jsonObject.put("rowId",rowId);
					
					jsonArray.add(jsonObject);
				
				}
				jsonObject2.put("status", "0");
				jsonObject2.put("message", "教练开放课时时间查询成功");
				jsonObject2.put("Info", jsonArray);
			}

			// 3 排序
			JSONSort jsonSort = new JSONSort("lessonDate");
			Collections.sort(jsonArray, jsonSort);
			this.RSAprivateencode(jsonObject2.toString());

		}
	
	
		private String getCoachNoSeetingAvailableTime(String openTime) {
			String[] openTimeArray = openTime.split("~");

			Map<Integer, Integer> amap = new HashMap<Integer, Integer>();
			List<Integer> aList = new ArrayList<Integer>();
			Date d = new Date();
			@SuppressWarnings("deprecation")
			int hours = d.getHours();
				String t0 = openTimeArray[0].replace(":00", "");

				String t1 = openTimeArray[1].replace(":00", "");
				int intTemp0 = Integer.parseInt(t0);
				int intTemp1 = Integer.parseInt(t1);
				for (int j = 0; j < intTemp1 - intTemp0+1; j++) {
					amap.put(intTemp0 + j, intTemp0 + j);
				}
			for (Integer a : amap.keySet()) {
					aList.add(a);
			}
			Collections.sort(aList);
			StringBuffer sbstr = new StringBuffer();
			for (Integer at : aList) {
				sbstr.append(at);
				sbstr.append(",");
			}
			String result = sbstr.substring(0, sbstr.length() - 1).toString();

			return result;
		}
	
		
		private String getCoachNoSeetingUnavailableTime(String avaiableTime) {
			String[] avaiableTimeArray = avaiableTime.split(",");
			Map<Integer, Integer> amap = new HashMap<Integer, Integer>();
			for (int i = 0; i < avaiableTimeArray.length; i++) {
				if(!"".equals(avaiableTimeArray[i])){
					Integer tempInt = Integer.parseInt(avaiableTimeArray[i]);
					amap.put(tempInt, tempInt);
				}
			}
			List<Integer> aList = new ArrayList<Integer>();
			for (int j = 0; j < 24; j++) {

				aList.add(j);
			}

			for (Integer at : amap.keySet()) {
				for (int k = 0; k < aList.size(); k++) {
					Integer tempInt = aList.get(k);
					if (amap.keySet().contains(tempInt)) {

						aList.remove(k);
					}
				}
			}

			Collections.sort(aList);
			StringBuffer sbstr = new StringBuffer();
			for (Integer at : aList) {
				sbstr.append(at);
				sbstr.append(",");
			}
			String result = sbstr.toString();
			if(sbstr.toString().length()>0){
				result = sbstr.toString().substring(0, sbstr.length() - 1);
			}else{
				result="-1";
			}
			return result;
		}
		
		
		private String getCoachLessonTime(String temp){
			
			String[] openTimeArray = temp.split(",");

			Map<Integer, Integer> amap = new HashMap<Integer, Integer>();
			List<Integer> aList = new ArrayList<Integer>();
			Date d = new Date();
			@SuppressWarnings("deprecation")
			int hours = d.getHours();
			for (int i = 0; i < openTimeArray.length; i++) {
				String t0 = openTimeArray[i];
				if(!"".equals(t0)){
					int intTemp0 = Integer.parseInt(t0);

					amap.put(intTemp0 , intTemp0);
				}
			}
			for (Integer a : amap.keySet()) {
				if (a > hours) {
					aList.add(a);
				}
			}
			Collections.sort(aList);
			StringBuffer sbstr = new StringBuffer();
			for (Integer at : aList) {
				sbstr.append(at);
				sbstr.append(",");
			}
			amap.clear();
			String result="";
			if(sbstr.toString().length()>0){
				result = sbstr.toString().substring(0, sbstr.length() - 1);
			}else{
				result="-1";
			}
			
			return result;

		}
		
		private String getCoacchUnlessonTime(String avaiableTime){
			String[] avaiableTimeArray = avaiableTime.split(",");
			Map<Integer, Integer> amap = new HashMap<Integer, Integer>();
			for (int i = 0; i < avaiableTimeArray.length; i++) {
				if(!"".equals(avaiableTimeArray[i])){
					Integer tempInt = Integer.parseInt(avaiableTimeArray[i]);
					amap.put(tempInt, tempInt);
				}

			}
			List<Integer> aList = new ArrayList<Integer>();
			for (int j = 0; j < 24; j++) {

				aList.add(j);
			}

			for (Integer at : amap.keySet()) {
				for (int k = 0; k < aList.size(); k++) {
					Integer tempInt = aList.get(k);
					if (amap.keySet().contains(tempInt)) {

						aList.remove(k);
					}
				}
			}

			Collections.sort(aList);
			StringBuffer sbstr = new StringBuffer();
			for (Integer at : aList) {
				sbstr.append(at);
				sbstr.append(",");
			}
			String result="";
			if(sbstr.toString().length()>0){
				result = sbstr.toString().substring(0, sbstr.length() - 1);
			}else{
				result="-1";
			}

			return result;

		}
		
		private  Integer createAvailabeRecore(int coachId,String lessonDate,String availableTimeSpan,String unAvailableTimeSpan){
			TPrivateLessonTime lessonTime = new TPrivateLessonTime();
			lessonTime.setCoachid(coachId);
			lessonTime.setAvailabletimespan(availableTimeSpan);
			lessonTime.setCloseweek("-1");
			lessonTime.setCreatedate(DateUtil.getDate());
			lessonTime.setUnavailabletimespan(unAvailableTimeSpan);
			lessonTime.setLessondate(lessonDate);
			this.coachInfoService.insertCoachworktime(lessonTime);
			return lessonTime.getRowid();
		}
		
		private Integer weeks(String str){
			Integer week = 0;
			switch (str) {
			case "星期一":
				week = 1;
				break;
			case "星期二":
				week = 2;
				break;
			case "星期三":
				week = 3;
				break;
			case "星期四":
				week = 4;
				break;
			case "星期五":
				week = 5;
				break;
			case "星期六":
				week = 6;
				break;
			case "星期日":
				week = 7;
				break;
			}
			return week;
		}
		
		/**
		 * @param map 无参数
		 * 查询登录首页轮播图
		 */
		private void pageImgs(Map<String, Object> map) {
			List<String> imgs =  appConfigService.getConfigValueByName("HOMEPAGE_LIST_IMGS");
			List<String> hotKey =  appConfigService.getConfigValueByName("hot_search_keys");
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("hotKey", hotKey.get(0));
			result.put("imgs", imgs);
			if(imgs.size() == 0){
				result.put("status", 1);
				result.put("message", "首页轮播图加载失败");
			}else{
				result.put("status", 0);
				result.put("message", "成功");
			}
			this.RSAprivateencode(new Gson().toJson(result));
		}
		
		/**
		 * @param orderType 订单类型  1活动订单 2商品订单 3私课订单 4场馆订单  5个人卡订单 
		 * @param memberId 用户ID
		 * 结束运动分享接口
		 */
		private void overSportShare(Map<String, Object> map) {
			Map<String , Object> result = new HashMap<String , Object>();
			try {
				Integer orderType = Integer.parseInt(map.get("orderType").toString());
				Integer memberId = Integer.parseInt(map.get("memberId").toString());
				result =  appStudioService.findOverSportShareInfo(orderType , memberId);
				result.put("status", "0");
				result.put("message", "成功");
			} catch (Exception e) {
				e.printStackTrace();
				result.put("status", "1");
				result.put("message", "请求失败");
			}
			this.RSAprivateencode(new Gson().toJson(result));
		}
}
