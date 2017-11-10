/**
* @author HuangJian
* @date 2017年2月15日
*/
package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TCoachReward;

public interface AppCoachRewardService {

	 
	
	/**
	* Title: getCoachRewardByCoachId
	* Description: 根据教练查询奖项
	* @param coachId
	* @return
	* @author HuangJian
	* @date 2017年2月15日
	*/
	public List<TCoachReward> getCoachRewardByCoachId(Integer coachId);
}

