/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.oa.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TActivityMapper;
import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TAttachMapper;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.service.ActivityService;
@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private TActivityMapper activityMapper;
	@Autowired
	private TRegionsMapper regionsMapper;
	@Autowired
	private TActivityOrderMapper activityOrderMapper;//活动订单
	
	public List<Map<String, Object>> data;
	@Override
	public Integer insertActivity(TActivity activity) {
		int result = activityMapper.insertSelective(activity);
		return activity.getActiveid();
	}
	@Override
	public Map<String, Object> getActivityById(Integer activityId) {
		data =  activityMapper.getActivityById(activityId);
		data = dataFormats(data);
		Map<String, Object> result = null;
		if(data !=null){
			result=data.get(0);
			
		}
		if(null != result){
			//活动成本  教练成本+场馆成本
			double coachCosts = Double.parseDouble(String.valueOf(result.get("coachCosts")));
			double studioCost = Double.parseDouble(String.valueOf(result.get("studioCost")));
			result.put("costPrice", (coachCosts+studioCost));
		}
		
		
		return result;
	}
	@Override
	public List<Map<String, Object>> findActivityList(TActivity activity) {
		
		return dataFormats(activityMapper.findActivityList(activity));
	}

	/**
	* Title: dataFormats
	* Description: 处理数据
	* @param list
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	public List<Map<String, Object>> dataFormats(List<Map<String, Object>> list){
		if(list !=null){
			Map<String, Object> temp;
			
			String activeTypeName="";
			Integer activityTypeId=0;
			
			String statusName="";
			Integer statusId=0;
			TRegions regions;
			
			String activeLimName="";
			Integer activeLimId=0;
			for(int i=0;i<list.size();i++){
				temp = list.get(i);
				//活动类型
				activityTypeId = Integer.parseInt(String.valueOf(temp.get("activeType")));
				switch(activityTypeId){
				case 0:
					activeTypeName="健身";
					break;
				case 1:
					activeTypeName="夜跑";
					break;
				case 2:
					activeTypeName="动感操";
					break;
				}
				temp.put("activeTypeName", activeTypeName);
				
				
				// 区id
				int regId = Integer.parseInt(String.valueOf(temp.get("regionsId")));
				//的到区
				regions = regionsMapper.getAreaByArea(regId);
				temp.put("city", regions.getpCode());
				temp.put("areaName", regions.getName());
				// 得到市
				regions = regionsMapper.getCityByArea(regions.getpCode());
				temp.put("cityName", regions.getName());
				// 得到省
				regions = regionsMapper.getProvinceByCity(regions.getpCode());
				
				// 省名称 /  code
				temp.put("ProvinceId", regions.getCode());
				temp.put("provinceName", regions.getName());
				
				
				statusId = Integer.parseInt(String.valueOf(temp.get("status")));
				switch (statusId) {
				case 0:
					statusName="生效";
					break;
				case 1:
					statusName="禁用";
					break;
				 
				case 3:
					statusName="未审核";
					break;
				default:
					break;
				}
				temp.put("statusName", statusName);
				
				//活动限制
				activeLimId = Integer.parseInt(String.valueOf(temp.get("activityLimit")));
				switch (activeLimId) {
				case 0:
					activeLimName="不限制";
					break;
				case 1:
					activeLimName="12小时";
					break;
				case 2:
					activeLimName="24小时";
					break;
				case 3:
					activeLimName="36小时";
					break;
				case 4:
					activeLimName="48小时";
					break;
				case 5:
					activeLimName="72小时";
					break;
				default:
					break;
				}
				temp.put("activeLimName", activeLimName);
				
				Integer activityId = Integer.parseInt(String.valueOf(temp.get("activeId")));
				//统计报名活动人数
				Map<String, Object> mapParam= new HashMap<>();
				mapParam.put("status", 2);
				mapParam.put("dateTime", null);
				mapParam.put("activityId", activityId);
				Integer bmNumber = activityOrderMapper.selectActivityOrderStatisByPayStatus(mapParam);
				
				temp.put("bmNumber", bmNumber==null?0:bmNumber);
				
				//活动收入
				mapParam.clear();
				mapParam.put("activityId", activityId);
				String totalMoney =  activityOrderMapper.selectActivityOrderTotalMoney(mapParam);
				temp.put("totalMoney", totalMoney==null?0:totalMoney);
			}
		}
		
		return list;
	}
	@Override
	public Integer updateActivityById(TActivity activity) {
		
		return activityMapper.updateByPrimaryKeySelective(activity);
	}
	@Override
	public List<Map<String, Object>> selectByActivity(TActivity activity) {
		String start = activity.getActivestarttime();
		String end = activity.getActiveendtime();
		if(start != null && !"".equals(start)){
			activity.setActivestarttime(start+" 00:00:00");
		}
		if(end !=null && !"".equals(end)){
			activity.setActiveendtime(end+" 59:59:59");
		}
		return dataFormats(activityMapper.selectByActivity(activity));
	}
	@Override
	public Integer updateActivityStatusById(Integer status, Integer activityId) {
		Map<String, Object> param=new HashMap<>();
		param.put("status", status);
		param.put("activityId", activityId);
		return activityMapper.updateActivityStatusById(param);
	}
	@Override
	public Map<String, Object> selectActivityListStatis() {
		Map<String, Object> resMap=new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		//报名人数
		Map<String, Object> mapParam= new HashMap<>();
		mapParam.put("status", 2);
		mapParam.put("dateTime", null);
		mapParam.put("activityId", null);
		Integer enrollNum = activityOrderMapper.selectActivityOrderStatisByPayStatus(mapParam);
		//活动总收入
		mapParam.clear();
		mapParam.put("activityId", null);
		String totalSumMoney =  activityOrderMapper.selectActivityOrderTotalMoney(mapParam);
		//待审核活动
		Integer noAuditNum =  activityMapper.selectActivityStatisByStatus(3);
		//今日活动数
		Integer todayNum =  activityMapper.selectTodayActivityStatis();
		//今日报名数
		mapParam.clear();
		mapParam.put("status", 2);
		mapParam.put("dateTime", sdf.format(new Date()));
		Integer todayEnrollNum = activityOrderMapper.selectActivityOrderStatisByPayStatus(mapParam);
	
		//禁用活动数
		Integer disableNum =  activityMapper.selectActivityStatisByStatus(1);
		resMap.put("totalSumMoney", totalSumMoney==null?0:totalSumMoney);
		resMap.put("enrollNum", enrollNum);
		resMap.put("todayEnrollNum", todayEnrollNum==null?0:todayEnrollNum);
		resMap.put("noAuditNum", noAuditNum);
		resMap.put("disableNum", disableNum);
		resMap.put("todayNum", todayNum);
		return resMap;
	}
}

