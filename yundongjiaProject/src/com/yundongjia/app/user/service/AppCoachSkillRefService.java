/**
* @author HuangJian
* @date 2017年6月7日
*/
package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

/**
* Title: com.yundongjia.app.user.service 
* Description: 教练与场馆引用表
* @author HuangJian
* @date 2017年6月7日
*/
public interface AppCoachSkillRefService {

	/**
	* Title: getCoachByStudioId
	* Description: 根据场馆ID查询教练
	* @param studioId
	* @return
	* @author HuangJian
	* @date 2017年6月7日
	*/
	List<Map<String, Object>> getCoachByStudioId(Integer studioId);
}

