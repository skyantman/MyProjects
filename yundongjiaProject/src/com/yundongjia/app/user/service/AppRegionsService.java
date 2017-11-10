/**
* @author HuangJian
* @date 2017年6月13日
*/
package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

public interface AppRegionsService {

	/**
	* Title: findCityByCityName
	* Description: 根据城市名称模糊查询
	* @param cityName
	* @return
	* @author HuangJian
	* @date 2017年6月13日
	*/
	List<Map<String, Object>> findCityByCityName(String cityName);
}

