package com.yundongjia.app.user.controller.usercontroller;



import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yundongjia.app.user.service.AppInforMationService;
import com.yundongjia.app.user.service.AppStudioService;
import com.yundongjia.app.user.service.AttachInFoService;
import com.yundongjia.app.user.service.BodyFatService;
import com.yundongjia.app.user.service.CardActivationService;
import com.yundongjia.app.user.service.MemberCardInfoService;
import com.yundongjia.app.user.service.MemberInfoService;
import com.yundongjia.app.user.service.PayOrderService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TActivation;
import com.yundongjia.oa.admin.po.TActivationExample;
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TAttachExample;
import com.yundongjia.oa.admin.po.TBodyfat;
import com.yundongjia.oa.admin.po.TBodyfatExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberShowtime;
import com.yundongjia.oa.utils.BodyfatUtil;
import com.yundongjia.oa.utils.ClassUtil;
import com.yundongjia.oa.utils.RedeemCodeUtils;
import com.yundongjia.oa.utils.RelativeDateFormatUtil;
import com.yundongjia.oa.utils.UtilPage;
import com.yundongjia.oa.utils.WeatherUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** * @author  作者WangLi: * @date 创建时间：2017年1月16日 上午10:57:26 * @version 1.0 * @parameter  * @since  * @return  */

/**
 * 
* @ClassName: MyOtherController 
* @Description: TODO() 
* @author Wangli
* @date 2017年2月20日 上午9:57:45 
*
 */
@Controller
public class MyOtherController extends BaseController{
    
	@Autowired
	private CardActivationService cardActivationService;
	@Autowired
	private MemberInfoService memberService;
	@Autowired
	private MemberCardInfoService memberCardInfoService;
	@Autowired
	private BodyFatService bodyFatService;
	@Autowired
	private AppInforMationService appInforMationService;
	@Autowired
	private AttachInFoService attachInFoService;
	@Autowired
	private PayOrderService payOrderService;
	@Autowired
	private AppStudioService appStudioService;
	
	@RequestMapping(value="ydj/user/myorther")
	 public void myPage(String str) throws Exception{
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type = Integer.parseInt(map.get("type").toString());
		switch (type) {
		case 0:// 保存体脂称数据
			saveBodyfatInfo(map);
			break;
		case 1:// 个人卡激活
			selfCardActivation(map);    
			break;
		case 2://体脂称资讯-根据类型查询
			selectInforMationByType(map);
			break;
		case 3://根据userId获取个人测量信息列表
			getBodyfatInfoByUserId(map);
			break;
		case 4://体脂称资讯-增加浏览次数
			addInforMationLookNum(map);
			break;
		case 5://根据userId获取个人所有测量信息列表
			getAllBodyfatInfoByUserId(map);
			break;
		case 6://获取行程信息
			getRoute(map);
			break;
		case 7://保存步数
			saveRouteNum(map);
			break;
		case 8://排行榜列表
			rankingList(map);
			break;
		default:
			break;
		}
	 }
	

	/**
	* Title: selectInforMationByType
	* Description: 根据类型查询资讯
	* @author HuangJian
	* @date 2017年2月20日
	*/
	public void selectInforMationByType(Map<String, Object> map){
		jsonclear();
		Integer infoType = Integer.parseInt(String.valueOf(map.get("infoType")));//类型  0:体重 1:体脂率 2:肌肉量
		
		Map<String, Object> param=new HashMap<>();
		param.put("infoType", infoType);
		try {
			List<Map<String, Object>> resultMap =  appInforMationService.findInforMationList(param);
		 	
			for(Map<String, Object> temp:resultMap){
				TAttachExample example = new TAttachExample();
				example.createCriteria().andAttachtypeEqualTo(5).andProidEqualTo(Integer.parseInt(temp.get("rowId").toString()));
				List<TAttach> list = this.attachInFoService.selecAttach(example);
				jsonArray.clear();
				for(TAttach i:list){
                      jsonArray.add(i.getPath());					
				}
				jsonObject.put("imgInfo", jsonArray);
				jsonObject.put("rowId", temp.get("rowId"));
				jsonObject.put("infoTitle", temp.get("infoTitle"));
				jsonObject.put("path", temp.get("path"));
				String beforeDate = RelativeDateFormatUtil.format(format.parse(temp.get("createDate").toString()));
				jsonObject.put("beforeDate", beforeDate);
				jsonObject.put("lookNum", temp.get("lookNum"));
				jsonArray2.add(jsonObject);
			}
			jsonObject2.put("status", "0");
			jsonObject2.put("message","查询成功");
			jsonObject2.put("Info", jsonArray2);
		} catch (Exception e) {
			 jsonObject2.put("status", "1");
			 jsonObject2.put("message", "查询失败");
		}finally {
			this.RSAprivateencode(jsonObject2.toString());
		}
		
	}
	
	 /**
     * 添加个人体脂称测量信息
     */
    public void saveBodyfatInfo(Map<String, Object> map){
    	jsonclear();
    	TBodyfat bodyfat = new TBodyfat();
    	
    	try {
    		bodyfat.setUserid(Integer.parseInt(map.get("userId").toString()));
        	bodyfat.setMeasuretime((String)map.get("measureTime"));
        	bodyfat.setWeight((String)map.get("weight"));
        	bodyfat.setBmi((String)map.get("bmi"));
        	bodyfat.setBodyfat((String)map.get("bodyfat"));
        	bodyfat.setSubfat((String)map.get("subfat"));
        	bodyfat.setVisfat((String)map.get("visfat"));
        	bodyfat.setWater((String)map.get("water"));
        	bodyfat.setBmr((String)map.get("bmr"));
        	bodyfat.setMuscle((String)map.get("muscle"));
        	bodyfat.setBone((String)map.get("bone"));
        	bodyfat.setProtein((String)map.get("protein"));
        	bodyfat.setGender((String)map.get("gender"));
        	bodyfat.setHeight((String)map.get("height"));
        	bodyfat.setBirthday((String)map.get("birthday"));
            bodyfat.setMm(BodyfatUtil.calculateMm((String)map.get("weight"),(String)map.get("bodyfat"),(String)map.get("bone")));
            bodyfat.setOnlynum((String)map.get("onlynum"));
            this.bodyFatService.insertBodyFatInfo(bodyfat);
            jsonObject.put("message", "添加成功");
			jsonObject.put("status", "0");
		} catch (Exception e) {
			jsonObject.put("message", "添加失败");
			jsonObject.put("status", "1");
		}finally {
			this.RSAprivateencode(jsonObject.toString());
		}
    }
	
    
    /**
     * 
    * @Title: selfCardActivation 
    * @Description: TODO(个人卡激活接口) 
    * @param @param map    设定文件 
    * @return void    返回类型 
    * @throws
     */
    public void selfCardActivation(Map<String, Object> map){ 
		String ativationCode = (String) map.get("ativationCode");
		Integer memberId = Integer.parseInt(map.get("memberId").toString());
		// 查询会员信息
		TMember member = payOrderService.findMemberById(memberId);
		//根据userID 查询会员手机号
    	String mobilePhoneNo = payOrderService.findMemberMobilephoneNo(member.getUserid());
		String status = "";
		String message = "";
		if(ativationCode != null){
			TActivationExample example = new TActivationExample();
			example.createCriteria().andActivationtypeEqualTo("5").andCardnumEqualTo(ativationCode).andValidEqualTo(0);
		    List<TActivation> list = this.cardActivationService.selectActivationCode(example);
		   TMemberCardOrderRef card = new TMemberCardOrderRef();
		    if(list.size() == 1){
		    	card.setSource("3");
		    	card.setCardtypeid(10012);
		    	card.setMemberid(memberId);
		    	card.setDiscount(9f);
		    	card.setTotalmoney(3000.00);
		    	card.setRealmoney(0.00);
		    	card.setCashback(-1d);
		    	card.setMobilephonenum(mobilePhoneNo);
		    	card.setOrdernum(System.currentTimeMillis()+RedeemCodeUtils.createSmallStrOrNumberRadom(4)+"");
		    	card.setPaytype("03");
		    	card.setValidday(300);
		    	card.setStatus(0);
		    	card.setIsdel(0);
		    	card.setCreatedate(format.format(new Date()));
		    	Calendar calendar = new GregorianCalendar();
		    	calendar.setTime(new Date());
		    	calendar.add(Calendar.DATE, 300);
		    	Date date = calendar.getTime();
		    	card.setExpiredate(format.format(date));
		    	card.setEnterpriseid(-1);
		    	card.setSportscount(-1);
		    	card.setSurplussportscount(-1);
		    	this.memberCardInfoService.insertMemberCardInfo(card);
		    	//激活成功修改邀请码状态为已使用
		    	TActivation activation = new TActivation();
		    	activation.setValid(1);
		    	activation.setActivationid(list.get(0).getActivationid());
		    	activation.setMemberid(memberId);
		    	this.cardActivationService.updateActivationInfobyId(activation);
		    	status = "0";
		    	message = "激活成功";
		    	
		    	
		    }else{
		    	status = "1";
		    	message = "激活码存在问题，激活失败！";
		    }
		}else{
			status = "1";
	    	message = "请输入激活码";
		}
		jsonObject.put("status", status);
		jsonObject.put("message", message);
		this.RSAprivateencode(jsonObject.toString());
    }
    
    
    /**
     * 根据userId获取个人测量信息列表
     */
    public void getBodyfatInfoByUserId(Map<String, Object> map) {

        JSONObject json = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject info = new JSONObject();
        JSONArray fields = new JSONArray();
        JSONArray times = new JSONArray();
         Integer userId = Integer.parseInt(map.get("userId").toString());
         Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
         Integer pageNo = Integer.parseInt(map.get("pageNo").toString());
         String fieldName = (String)map.get("fieldName");
        TBodyfatExample example = new TBodyfatExample();
        example.createCriteria().andUseridEqualTo(userId);
        example.setOrderByClause("measureTime DESC");
        List<TBodyfat> list = this.bodyFatService.selectUserBodyFatInfo(example);
        TBodyfat b = null;
        UtilPage page = new UtilPage(pageSize, list.size(), pageNo);
        DecimalFormat df = new DecimalFormat("0.0");
        if (list.size() > 0 && pageNo <= page.getCurrentPage() && fieldName != null) {
            String str = null;
            for (int i = page.getFromIndex(); i < page.getToIndex(); i++) {
                b = list.get(i);
                if (fieldName.equals("mm") && (b.getMm() == null ||(b.getMm()!=null && b.getMm().equals("")))) {

                    str = BodyfatUtil.calculateMm(b.getWeight(),b.getBodyfat(),b.getBone());
                } else {
                    str = ClassUtil.getFieldValue(b, fieldName);
                }
                times.add(b.getMeasuretime());
                fields.add(str);
            }
        }
        info.put("fields", fields);
        info.put("times", times);
        result.put("status", "0");
        result.put("message", "查询成功");
        json.put("result", result);
        json.put("Info", info);
        this.RSAprivateencode(json.toString());

    }
    
    
    
    public void getAllBodyfatInfoByUserId(Map<String, Object> map) {
    	JSONObject json = new JSONObject();
        JSONObject result = new JSONObject();
        JSONObject info = new JSONObject();
        JSONArray bodyfats = new JSONArray();
        
    	 Integer userId = Integer.parseInt(map.get("userId").toString());
         Integer pageSize = Integer.parseInt(map.get("pageSize").toString());
         Integer pageNo = Integer.parseInt(map.get("pageNo").toString());

        TBodyfatExample example = new TBodyfatExample();
        example.createCriteria().andUseridEqualTo(userId);
        example.setOrderByClause("measureTime DESC");
        List<TBodyfat> list = this.bodyFatService.selectUserBodyFatInfo(example);
        TBodyfat b = null;
        UtilPage page = new UtilPage(pageSize, list.size(), pageNo);
        DecimalFormat df = new DecimalFormat("0.0");
        if (list.size() > 0 && pageNo <= page.getCurrentPage() ) {
            for (int i = page.getFromIndex(); i < page.getToIndex(); i++) {
                b = list.get(i);
                if (  b.getMm() == null ||(b.getMm()!=null && b.getMm().equals(""))) {
                    b.setMm(BodyfatUtil.calculateMm(b.getWeight(),b.getBodyfat(),b.getBone()));
                }
                bodyfats.add(b);
            }
        }
        info.put("bodyfats", bodyfats);
        result.put("status", "0");
        result.put("message", "查询成功");
        result.put("info", info);
        this.RSAprivateencode(result.toString());

    }
    
    
    
    
    
    /**
	* Title: addInforMationLookNum
	* Description: 增加资讯浏览人数
	* @param map
	* @author HuangJian
	* @date 2017年2月21日
	*/
	public void addInforMationLookNum(Map<String, Object> map) {
		jsonclear();
		Integer rowId = Integer.parseInt(String.valueOf(map.get("rowId")));
		try {
			Integer res = appInforMationService.updateInorMationById(rowId);
			jsonObject.put("status", "0");
			jsonObject.put("message", "修改成功");
		} catch (Exception e) {
			jsonObject.put("status", "1");
			jsonObject.put("message", "修改失败");
		}finally{
			this.RSAprivateencode(jsonObject.toString());
		}
	}
    
	/**
	 * @param city 城市名称
	 * @param memberId 用户ID
	 * @param routeNum 步数
	 * 查询会员行程信息
	 */
	private void getRoute(Map<String, Object> map) {
		Map<String ,Object> result = new HashMap<String ,Object>();
		Integer memberId = 0;
		try {
		SimpleDateFormat  sim = new SimpleDateFormat("HH:mm:ss");
		String city = String.valueOf(map.get("city"));
		memberId = Integer.parseInt(String.valueOf(map.get("memberId")));
		if(map.get("routeNum") != null){
			Integer routeNum = Integer.parseInt(String.valueOf(map.get("routeNum")));
			//存储行程信息
			appInforMationService.saveRoute(memberId , routeNum);
		}
		Map<String, String> weatherInfo = WeatherUtil.getWeather(city);
		List<TMemberShowtime> showTime = appInforMationService.findSportTime(memberId);
		//获取本周所有日期
		List<String> printWeekdays = printWeekdays();
		Long longTime = 0l;
		Long weekTime = 0l;
		for (TMemberShowtime st : showTime) {
			for (String pw : printWeekdays) {
				if(pw.equals(st.getShowendtime().split(" ")[0])){
					Calendar calendar = Calendar.getInstance();
					calendar.setTimeInMillis(0);
					String[] split = st.getTimespan().split(":");
					calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(split[0]));
					calendar.add(Calendar.MINUTE, Integer.parseInt(split[1]));
					calendar.add(Calendar.SECOND, Integer.parseInt(split[2]));
					weekTime = weekTime +calendar.getTimeInMillis();
				}
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(0);
			String[] split = st.getTimespan().split(":");
			calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(split[0]));
			calendar.add(Calendar.MINUTE, Integer.parseInt(split[1]));
			calendar.add(Calendar.SECOND, Integer.parseInt(split[2]));
			longTime = longTime + calendar.getTimeInMillis();
		}
		Integer weekSportTime = (int) (weekTime / 60000);
		Integer sportTime = (int) (longTime / 60000);
		List<Map<String, Object>> rank = appInforMationService.findTimeRank();
		result.put("ranking", rank.size());
		for (int i = 0; i < rank.size(); i++) {
			if(rank.get(i).get("memberId").equals(memberId)){
				result.put("ranking", i + 1);
			}
		}
		List<Map<String, Object>> routeInfo =  appInforMationService.findRouteInfo(memberId);
		List<Map<String, Object>> testRoute = new ArrayList<>();
		for (Map<String, Object> route : routeInfo) {
			if(Integer.parseInt(route.get("isToday").toString()) == 0){
				testRoute.add(route);
			}
		}
		//如果行程信息为空查询推荐场馆
		if(testRoute.size() == 1 && Integer.parseInt(testRoute.get(0).get("routeType").toString()) == 0){
			Map<String, Object> param = new HashMap<>();
			param.put("lng", map.get("lng"));
			param.put("lat", map.get("lat"));
			List<Map<String, Object>> mapList = appStudioService.findStudioList(param);
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
			Map<String, Object> map1 = new HashMap<String , Object>();
			map1.put("isToday", 0);
			map1.put("titleDate", "");
			map1.put("timeSpan", "0");
			map1.put("lon", mapList.get(0).get("lng"));
			map1.put("lat", mapList.get(0).get("lat"));
			map1.put("isattend", 2);
			map1.put("name", "推荐场馆："+mapList.get(0).get("studioName"));
			map1.put("createDate", "");
			map1.put("timeBefore", "");
			map1.put("routeType", 4);
			map1.put("proId", mapList.get(0).get("studioId"));
			routeInfo.add(1, map1);
		}
		result.put("weatherInfo", weatherInfo);
		result.put("weekSportTime", weekSportTime);
		result.put("sportTime", sportTime);
		result.put("routeInfo", routeInfo);
		result.put("status", "0");
		result.put("message", "请求成功");
	} catch (Exception e) {
		e.printStackTrace();
		result.put("status", "1");
		if(memberId == 0){
			result.put("message", "未登录");
		}else{
			result.put("message", "请求失败");
		}
		
	}finally{
		this.RSAprivateencode(new Gson().toJson(result));
	}
		
	}
	
	/**
	 * @param memberId 用户ID
	 *  @param routeNum 当天总步数
	 */
	private void saveRouteNum(Map<String, Object> map) {
		Integer memberId = Integer.parseInt(String.valueOf(map.get("memberId")));
		Integer routeNum = Integer.parseInt(String.valueOf(map.get("routeNum")));
		//存储行程信息
		Integer saveRoute = appInforMationService.saveRoute(memberId , routeNum);
		Map<String ,Object> result = new HashMap<String ,Object>();
		if(saveRoute != 0){
			result.put("status", "0");
			result.put("message", "保存成功");
		}else{
			result.put("status", "1");
			result.put("message", "保存失败");
		}
		this.RSAprivateencode(new Gson().toJson(result));
	}
	
	
	/**
	 * 排行榜列表
	 */
	private void rankingList(Map<String, Object> map) {
		Map<String ,Object> result = new HashMap<String ,Object>();
		try{
			List<Map<String, Object>> rank = appInforMationService.findTimeRank();
			List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
			int i = 0;
			for (Map<String, Object> m : rank) {
				Map<String, Object> resultMap = appInforMationService.findMemberRouteInfo((Integer)m.get("memberId") , (Double)m.get("sportsMillisecond"));
				resultList.add(resultMap);
				i++;
				if(i == 10){
					break;
				}
			}
			result.put("Info",resultList);
			result.put("status", "0");
			result.put("message", "请求成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.put("status", "1");
			result.put("message", "请求失败");
		}finally{
			this.RSAprivateencode(new Gson().toJson(result));
		}
	}
	
	
	
	private static final int FIRST_DAY = Calendar.MONDAY;
	
	private static List<String> printWeekdays() {
        Calendar calendar = Calendar.getInstance();
        setToFirstDay(calendar);
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	result.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        return result;
    }
	
	private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }
 
}
