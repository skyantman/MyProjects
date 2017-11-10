/**
* @author HuangJian
* @date 2017年2月15日
*/
package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

public interface AppCoachService {

	/**
	* Title: findAppCoachList
	* Description: 教练列表  -- 或模糊查询教练名称
	* @return
	* @author HuangJian
	* @date 2017年2月15日
	*/
	public List<Map<String, Object>> findAppCoachList(Map<String, Object> param);
	
	/**
	* Title: selectAppCoachById
	* Description: 教练详情
	* @param coachId
	* @return
	* @author HuangJian
	* @date 2017年2月15日
	*/
	public Map<String, Object> selectAppCoachById(Integer coachId);
	
	
}

