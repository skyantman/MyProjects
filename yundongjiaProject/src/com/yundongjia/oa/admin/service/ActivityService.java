/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TActivity;

public interface ActivityService {

	
	/**
	* Title: insertActivity
	* Description: 保存活动返回主键
	* @param activity
	* @return
	* @author HuangJian
	* @date 2017年1月19日
	*/
	public Integer insertActivity(TActivity activity);
	
	/**
	* Title: geTActivityById
	* Description: 根据id查询详情
	* @param activityId
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	public Map<String, Object> getActivityById(Integer activityId);
	
	/**
	* Title: findActivityList
	* Description: 全查
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	public List<Map<String, Object>> findActivityList(TActivity activity);
	
	/**
	* Title: updateActivityById
	* Description: 根据id修改
	* @param activity
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	public Integer updateActivityById(TActivity activity);
	
	
	/**
	* Title: selectByActivity
	* Description: 条件查询
	* @param activity
	* @return
	* @author HuangJian
	* @date 2017年2月3日
	*/
	public List<Map<String, Object>> selectByActivity(TActivity activity);
	
	/**
	* Title: updateActivityStatusById
	* Description: 修改活动状态
	* @param status
	* @param activityId
	* @return
	* @author HuangJian
	* @date 2017年2月3日
	*/
	public Integer updateActivityStatusById(Integer status,Integer activityId);
	
	/**
	* Title: activityListStatis
	* Description: 活动列表的统计
	* @return
	* @author HuangJian
	* @date 2017年2月3日
	*/
	public Map<String, Object> selectActivityListStatis();
}

