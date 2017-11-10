/**
* @author HuangJian
* @date 2017年2月6日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TSkill;

public interface SkillService {

	/**
	* Title: findSkill
	* Description: 查询全部擅长课程
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	public List<TSkill> findSkill();
	
	/**
	* Title: getSkillByCoachId
	* Description: 根据教练获取擅长课程
	* @param coachId
	* @return
	* @author HuangJian
	* @date 2017年2月15日
	*/
	public List<Map<String, Object>> getSkillByCoachId(Integer coachId);
}

