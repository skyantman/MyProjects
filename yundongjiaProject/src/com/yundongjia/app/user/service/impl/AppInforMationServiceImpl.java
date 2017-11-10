/**
* @author HuangJian
* @date 2017年2月20日
*/
package com.yundongjia.app.user.service.impl;

import java.text.DecimalFormat;
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
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppInforMationService;
import com.yundongjia.oa.admin.mapper.TActivityMapper;
import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TCoachStudioRefMapper;
import com.yundongjia.oa.admin.mapper.TInforMationMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TMemberRouteMapper;
import com.yundongjia.oa.admin.mapper.TMemberShowtimeMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachStudioRef;
import com.yundongjia.oa.admin.po.TCoachStudioRefExample;
import com.yundongjia.oa.admin.po.TInforMation;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberRoute;
import com.yundongjia.oa.admin.po.TMemberRouteExample;
import com.yundongjia.oa.admin.po.TMemberShowtime;
import com.yundongjia.oa.admin.po.TMemberShowtimeExample;
import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.utils.DateFormatUtil;

@Service
public class AppInforMationServiceImpl implements AppInforMationService{

	@Autowired
	private TInforMationMapper inforMationMapper;
	@Autowired
	private TMemberShowtimeMapper tMemberShowtimeMapper ;
	@Autowired
	private TActivityOrderMapper tActivityOrderMapper;
	@Autowired
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	@Autowired
	private TOrderMapper tOrderMapper;
	@Autowired
	private TMemberRouteMapper tMemberRouteMapper;
	@Autowired
	private TStudioMapper tStudioMapper;
	@Autowired
	private TCoachMapper tCoachMapper;
	@Autowired
	private TActivityMapper tActivityMapper;
	@Autowired
	private TCoachStudioRefMapper tCoachStudioRefMapper;
	@Autowired
	private TMemberMapper tMemberMapper;
	
	@Override
	public List<Map<String, Object>> findInforMationList(Map<String, Object> param) {
		List<Map<String, Object>> list =  inforMationMapper.findInforMationList(param);
		return list;
	}

	@Override
	public Integer updateInorMationById(Integer rowId) {
		TInforMation inforMation =  inforMationMapper.selectByPrimaryKey(rowId);
		
		inforMation.setLooknum((inforMation.getLooknum()+1));
		
		return inforMationMapper.updateByPrimaryKeySelective(inforMation);
	}
	
	/**
	 * @param memberId
	 * @return查询会员总运动时间
	 */
	@Override
	public List<TMemberShowtime> findSportTime(Integer memberId) {
		TMemberShowtimeExample tMemberShowtimeExample = new TMemberShowtimeExample();
		tMemberShowtimeExample.createCriteria().andMemberidEqualTo(memberId).andIsshowoverEqualTo("0");
		return  tMemberShowtimeMapper.selectByExample(tMemberShowtimeExample);
	}
	
	/**
	 * @param memberId
	 * @return查询运动时间排名
	 */
	@Override
	public List<Map<String, Object>> findTimeRank() {
		List<Map<String, Object>> showTime = tMemberShowtimeMapper.findRank();
		return showTime;
	}
	/**
	 * @param memberId
	 * @return查询行程信息展示列表
	 * tActivityOrderMapper		tOrderMapper    tStudioConsumeOrderRecordMapper	tMemberRouteMapper
	 */
	@Override
	public List<Map<String, Object>> findRouteInfo(Integer memberId) {
		SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar calendar = Calendar.getInstance();
		 List<String> result = new ArrayList<String>();
		 for (int i = 0; i < 15; i++) {
	        	result.add(dateFormat.format(calendar.getTime()));
	            calendar.add(Calendar.DATE, -1);
	        }
		String titleDate = "";
		int i = 0;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		//查询场馆订单信息
		TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
		tStudioConsumeOrderRecordExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo(2);
		List<TStudioConsumeOrderRecord> order_studio = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
		//查询私课订单信息根据ID
		TOrderExample tOrderExample = new TOrderExample();
		tOrderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo(2);
		List<TOrder> order_private = tOrderMapper.selectByExample(tOrderExample);
		//查询团课订单信息根据ID
		TActivityOrderExample tActivityOrderExample = new TActivityOrderExample();
		tActivityOrderExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo("2");
		List<TActivityOrder> order_active = tActivityOrderMapper.selectByExample(tActivityOrderExample);
		
		for (String date : result) {
			//场馆
			for (TStudioConsumeOrderRecord tStudioConsumeOrderRecord : order_studio) {
				if(date.equals(tStudioConsumeOrderRecord.getCreatedate().split(" ")[0])){
					Map<String, Object> studioMap = new HashMap<String , Object>();
					if(tStudioConsumeOrderRecord != null){
						if(order_studio.size() != 0 && "".equals(titleDate) && i==0){
							titleDate = "今天";
							studioMap.put("isToday", 0);
							studioMap.put("titleDate", titleDate);
						}else if(order_studio.size() != 0 && "".equals(titleDate) && i==1){
							titleDate = "昨天";
							studioMap.put("isToday", 1);
							studioMap.put("titleDate", titleDate);
						}else if(order_studio.size() != 0 && "".equals(titleDate) && i > 1){
							titleDate = date.split("-")[1] + "-" + date.split("-")[2];
							studioMap.put("isToday", 1);
							studioMap.put("titleDate", titleDate);
						}else if(order_studio.size() != 0 && "今天".equals(titleDate) && i==0){
							studioMap.put("isToday", 0);
							studioMap.put("titleDate", "");
						}else{
							studioMap.put("isToday", 1);
							studioMap.put("titleDate", "");
						}
						TStudio studio = tStudioMapper.selectByPrimaryKey(tStudioConsumeOrderRecord.getStudioid());
						Long createDateLong = 0L;
						try {
							createDateLong = dateTime.parse(tStudioConsumeOrderRecord.getCreatedate()).getTime();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String timeBefore = DateFormatUtil.formateDate(new Date().getTime() - createDateLong);
						TMemberShowtimeExample tMemberShowtimeExample = new TMemberShowtimeExample();
						tMemberShowtimeExample.createCriteria().andMemberidEqualTo(memberId).andStudioidEqualTo(studio.getStudioid());
						List<TMemberShowtime> sportTime = tMemberShowtimeMapper.selectByExample(tMemberShowtimeExample);
						studioMap.put("timeSpan", "0");
						for (TMemberShowtime st : sportTime) {
							if(date.equals(st.getShowendtime().split(" ")[0])){
									calendar.clear();
									calendar.setTimeInMillis(0);
									String[] split = st.getTimespan().split(":");
									calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(split[0]));
									calendar.add(Calendar.MINUTE, Integer.parseInt(split[1]));
									calendar.add(Calendar.SECOND, Integer.parseInt(split[2]));
									studioMap.put("timeSpan", (calendar.getTimeInMillis() / 60000)+"");
							}
						}
						studioMap.put("lon", "");
						studioMap.put("lat", "");
						studioMap.put("isattend", 1);
						studioMap.put("name", studio.getStudioname().toString());
						studioMap.put("createDate", tStudioConsumeOrderRecord.getCreatedate());
						studioMap.put("timeBefore", timeBefore);
						studioMap.put("routeType", 4);
						studioMap.put("proId", tStudioConsumeOrderRecord.getOrderid());
						list.add(studioMap);
					}
				}
			}
			//私课
			for (TOrder tOrder : order_private) {
				if(date.equals(tOrder.getCreatedate().split(" ")[0])){
					Map<String, Object> orderMap = new HashMap<String , Object>();
					if(tOrder != null){
						if(order_private.size() != 0 && "".equals(titleDate) && i==0){
							titleDate = "今天";
							orderMap.put("isToday", 0);
							orderMap.put("titleDate", titleDate);
						}else if(order_private.size() != 0 && "".equals(titleDate) && i==1){
							titleDate = "昨天";
							orderMap.put("isToday", 1);
							orderMap.put("titleDate", titleDate);
						}else if(order_private.size() != 0 && "".equals(titleDate) && i > 1){
							titleDate = date.split("-")[1] + "-" + date.split("-")[2];
							orderMap.put("isToday", 1);
							orderMap.put("titleDate", titleDate);
						}else if(order_studio.size() != 0 && "今天".equals(titleDate) && i==0){
							orderMap.put("isToday", 0);
							orderMap.put("titleDate", "");
						}else{
							orderMap.put("isToday", 1);
							orderMap.put("titleDate", "");
						}
						TCoach coach = tCoachMapper.selectByPrimaryKey(tOrder.getCoachid());
						TCoachStudioRefExample tCoachStudioRefExample = new TCoachStudioRefExample();
						tCoachStudioRefExample.createCriteria().andCoachidEqualTo(coach.getCoachid());
						List<TCoachStudioRef> SCREF = tCoachStudioRefMapper.selectByExample(tCoachStudioRefExample);
						if(SCREF.size()>0){
							
							TStudio studio = tStudioMapper.selectByPrimaryKey(SCREF.get(0).getStudioid());
							orderMap.put("lon", studio.getLng());
							orderMap.put("lat", studio.getLat());
						}else{
							orderMap.put("lon", "");
							 orderMap.put("lat", "");
						}
						
						Long createDateLong = 0L;
						try {
							createDateLong = dateTime.parse(tOrder.getClassdate()+" " + tOrder.getTimespan().split("-")[0] + ":00").getTime();
						} catch (ParseException e) {
							e.printStackTrace();
						}
						 String timeBefore = "";
						 if(new Date().getTime() - createDateLong <= 0){
							 timeBefore = formateDatePrivate(createDateLong - new Date().getTime());
							 //未上课
							 orderMap.put("isattend", 0);
						 }else{
							 try {
									timeBefore = DateFormatUtil.formateDate(new Date().getTime() - dateTime.parse(tOrder.getCreatedate()).getTime());
								} catch (ParseException e) {
									e.printStackTrace();
								}
							 //已经上课
							 orderMap.put("isattend", 1);
							
						 }
						orderMap.put("timeSpan", tOrder.getTimespan());
						orderMap.put("name", coach.getNickname());
						orderMap.put("createDate", tOrder.getCreatedate());
						orderMap.put("timeBefore", timeBefore);
						orderMap.put("routeType", 3);
						orderMap.put("proId", tOrder.getOrderid());
						list.add(orderMap);
					}
				}
			}
			//活动
			for (TActivityOrder activeOrder : order_active) {
				TActivity active = tActivityMapper.selectByPrimaryKey(activeOrder.getActivityid());
				if(date.equals(activeOrder.getCreatedate().split(" ")[0])){
					Map<String, Object> activeMap = new HashMap<String , Object>();
					if(activeOrder != null){
						if(order_active.size() != 0 && "".equals(titleDate) && i==0){
							titleDate = "今天";
							activeMap.put("isToday", 0);
							activeMap.put("titleDate", titleDate);
						}else if(order_active.size() != 0 && "".equals(titleDate) && i==1){
							titleDate = "昨天";
							activeMap.put("isToday", 1);
							activeMap.put("titleDate", titleDate);
						}else if(order_active.size() != 0 && "".equals(titleDate) && i > 1){
							titleDate = date.split("-")[1] + "-" + date.split("-")[2];
							activeMap.put("isToday", 1);
							activeMap.put("titleDate", titleDate);
						}else if(order_studio.size() != 0 && "今天".equals(titleDate) && i==0){
							activeMap.put("isToday", 0);
							activeMap.put("titleDate", "");
						}else{
							activeMap.put("isToday", 1);
							activeMap.put("titleDate", "");
						}
						Long createDateLong = 0L;
						try {
							createDateLong = dateTime.parse(active.getActivestarttime()+":00").getTime();
						} catch (ParseException e) {
							e.printStackTrace();
						}
						 String timeBefore = "";
						 if(new Date().getTime() - createDateLong <= 0){
							 timeBefore = formateDatePrivate(createDateLong - new Date().getTime());
							 activeMap.put("isattend", 0);
						 }else{
							 try {
									timeBefore = DateFormatUtil.formateDate(new Date().getTime() - dateTime.parse(activeOrder.getCreatedate()).getTime());
								} catch (ParseException e) {
									e.printStackTrace();
								}
							 activeMap.put("isattend", 1);
						 }
						 TStudio studio = tStudioMapper.selectByPrimaryKey(active.getStudioid());
						 activeMap.put("lon", studio.getLng());
						 activeMap.put("lat", studio.getLat());
						activeMap.put("timeSpan", active.getActivestarttime().split(" ")[1]+ "-" + active.getActiveendtime().split(" ")[1]);
						activeMap.put("name", active.getActivename());
						activeMap.put("createDate", activeOrder.getCreatedate());
						activeMap.put("timeBefore", timeBefore);
						activeMap.put("routeType", 1);
						activeMap.put("proId", activeOrder.getOrderid());
						
						list.add(activeMap);
					}
				}
			}
			
			//查询当天的步数
			TMemberRouteExample tMemberRouteExample = new TMemberRouteExample();
			tMemberRouteExample.createCriteria().andMemberidEqualTo(memberId).andRoutedateEqualTo(date);
			List<TMemberRoute> routeList = tMemberRouteMapper.selectByExample(tMemberRouteExample);
			if(routeList.size()!=0 && date.equals( routeList.get(0).getRoutedate())){
				Map<String, Object> routeMap = new HashMap<String , Object>();
				if(routeList.size() != 0 && "".equals(titleDate) && i==0){
					titleDate = "今天";
					routeMap.put("isToday", 0);
					routeMap.put("titleDate", titleDate);
				}else if(routeList.size() != 0 && "".equals(titleDate) && i==1){
					titleDate = "昨天";
					routeMap.put("isToday", 1);
					routeMap.put("titleDate", titleDate);
				}else if(routeList.size() != 0 && "".equals(titleDate) && i > 1){
					titleDate = date.split("-")[1] + "-" + date.split("-")[2];
					routeMap.put("isToday", 1);
					routeMap.put("titleDate", titleDate);
				}else if(order_studio.size() != 0 && "今天".equals(titleDate) && i==0){
					routeMap.put("isToday", 0);
					routeMap.put("titleDate", "");
				}else{
					routeMap.put("isToday", 1);
					routeMap.put("titleDate", "");
				}
				TMemberRoute route = routeList.get(0);
				routeMap.put("lon", "");
				routeMap.put("lat", "");
				routeMap.put("isattend", 0);
				routeMap.put("timeSpan", "");
				routeMap.put("name", route.getRoutenum().toString());
				routeMap.put("createDate", "");
				routeMap.put("timeBefore", "");
				routeMap.put("routeType", 0);
				routeMap.put("proId", 0);
				list.add(routeMap);
			}
			titleDate = "";
			i++;
		}
		return list;
	}
	
	
	public  String formateDatePrivate(Long leadTime){
		Calendar calendar = Calendar.getInstance();
		 calendar.setTime(new Date(leadTime));
			 if(calendar.get(Calendar.HOUR_OF_DAY)> 8 && calendar.get(Calendar.DAY_OF_MONTH) == 1){
				 return "距上课时间约"+(calendar.get(Calendar.HOUR_OF_DAY) - 8) + "小时";
			 }else if(calendar.get(Calendar.DAY_OF_MONTH)>1){
				 return "距上课时间约"+(calendar.get(Calendar.DAY_OF_MONTH)- 1) + "天";
			 }else if(calendar.get(Calendar.DAY_OF_MONTH) == 1 && calendar.get(Calendar.HOUR_OF_DAY) == 8 ){
				 return "距上课时间约"+calendar.get(Calendar.MINUTE) + "分钟";
			 }
			 return "";
		 
	}
	
	/**
	 * 保存行程信息
	 */
	@Override
	public Integer saveRoute(Integer memberId, Integer routeNum) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TMemberRouteExample tMemberRouteExample = new TMemberRouteExample();
		tMemberRouteExample.createCriteria().andMemberidEqualTo(memberId).andRoutedateEqualTo(simpleDateFormat.format(new Date()).split(" ")[0]);
		List<TMemberRoute> route = tMemberRouteMapper.selectByExample(tMemberRouteExample);
		Integer result = 0;
		if(route.size() == 1){
			route.get(0).setRoutenum(routeNum);
			route.get(0).setUpdatedate(simpleDateFormat.format(new Date()));
			result = tMemberRouteMapper.updateByPrimaryKeySelective(route.get(0));
		}else if(route.size() > 1){
			for (int i = 1; i < route.size(); i++) {
				tMemberRouteMapper.deleteByPrimaryKey(route.get(i).getRowid());
			}
			route.get(0).setRoutenum(routeNum);
			route.get(0).setUpdatedate(simpleDateFormat.format(new Date()));
			result = tMemberRouteMapper.updateByPrimaryKeySelective(route.get(0));
		}else{
			TMemberRoute tMemberRoute = new TMemberRoute();
			tMemberRoute.setMemberid(memberId);
			tMemberRoute.setUpdatedate(simpleDateFormat.format(new Date()));
			tMemberRoute.setRoutenum(routeNum);
			tMemberRoute.setRoutedate(simpleDateFormat.format(new Date()).split(" ")[0]);
			result  = tMemberRouteMapper.insertSelective(tMemberRoute);
		}
		return  result;
	}

	/**
	 * @param memberId  用户ID
	 * @param sportsMillisecond   运动毫秒数
	 * @return查询会员行程信息
	 */
	@Override
	public Map<String, Object> findMemberRouteInfo(Integer memberId, Double sportsMillisecond) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		Map<String ,Object> result = new HashMap<String ,Object>();
		result.put("memberId", memberId);
		DecimalFormat df = new DecimalFormat("0");  
		String format = df.format(sportsMillisecond/60000);
		result.put("sportMinute",format);
		TMember member = tMemberMapper.selectByPrimaryKey(memberId);
		if(member != null){
			result.put("memberName", member.getNickname());
			result.put("imgPath", member.getImgpath());
		}else{
			result.put("memberName", "");
			result.put("imgPath", "");
		}
		TMemberRouteExample t = new TMemberRouteExample();
		t.createCriteria().andMemberidEqualTo(memberId).andRoutedateEqualTo(sim.format(new Date()));
		List<TMemberRoute> routeInfo = tMemberRouteMapper.selectByExample(t);
		if(routeInfo.size() > 0){
			result.put("routeNum", routeInfo.get(0).getRoutenum());
		}else{
			result.put("routeNum", 0);
		}
		return result;
	}
	
	
	 /*public static void main(String[] args) {
		 List<Map<String, Object>>result= new ArrayList<Map<String, Object>>();
		 Map map = new HashMap(); 
		 Map map1 = new HashMap(); 
		 Map map2= new HashMap(); 
		 Map map3 = new HashMap(); 
		 map.put("memberId",0);  
		 	map.put("memberTime",995);  
		 	map1.put("memberId",1); 
		 	map1.put("memberTime",673); 
		 	 map2.put("memberId",2);  
	        map2.put("memberTime",674);  
	        map3.put("memberId",3);  
	        map3.put("memberTime",674);  
	        result.add(map);
	        result.add(map1);
	        result.add(map2);
	        result.add(map3);
	        System.out.println(result.toString());
	        Collections.sort(result, new Comparator<Map<String, Object>>(){  
				  
	              
	            
	               
	            public int compare(Map<String, Object> o1, Map<String, Object> o2) {  
	              
	                //按照学生的年龄进行升序排列  
	                if(Long.parseLong(o1.get("memberTime").toString()) > Long.parseLong(o2.get("memberTime").toString())){  
	                    return 1;  
	                }  
	                if(Long.parseLong(o1.get("memberTime").toString()) == Long.parseLong(o2.get("memberTime").toString())){  
	                    return 0;  
	                }  
	                return -1;  
	            }  
	        }); 
	        System.out.println(result.toString());
	}*/

}

