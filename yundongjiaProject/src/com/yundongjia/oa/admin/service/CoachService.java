/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachUser;

public interface CoachService {

	/**
	* Title: findCoachList
	* Description: 查询教练全部
	* @return
	* @author HuangJian
	* @date 2017年1月19日
	*/
	public List<TCoach> findCoachList();
	
	/**
	* Title: findCoachListLMap
	* Description: 全查或条件查询
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	public List<Map<String, Object>> findCoachListLMap(Map<String, Object> param);
	
	/**
	* Title: insertCoach
	* Description: 
	* @param coach
	* @param coachUser
	* @param rewardName
	* @param rewardNum
	* @param skills
	* @param studioId 场馆id
	* @return 
	* @author HuangJian
	* @date 2017年2月6日
	*/
	public Integer insertCoach(TCoach coach,TCoachUser coachUser,String [] rewardName,String [] rewardNum,Integer [] skills,Integer studioId);
	
	/**
	* Title: getCoachById
	* Description: 详情
	* @param coachId
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	public Map<String, Object> getCoachById(Integer coachId);
	
	/**
	* Title: updateCoach
	* Description: 修改教练
	* @param coach
	* @param coachUser
	* @param rewardName
	* @param rewardNum
	* @param skills
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	public Integer updateCoach(TCoach coach,TCoachUser coachUser,String [] rewardName,String [] rewardNum,Integer [] skills,Integer studioid);
	
	/**
	* Title: updateCoachStatusById
	* Description: 修改教练状态
	* @param coach
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	public Integer updateCoachStatusById(TCoach coach);
	
	/**
	* Title: selectStatisByCoach
	* Description: 根据状态统计
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	public Map<String, Object> selectStatisByCoach();
}

