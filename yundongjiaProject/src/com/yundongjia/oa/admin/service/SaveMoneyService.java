/**
* @author HuangJian
* @date 2017年2月27日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

public interface SaveMoneyService {

	/**
	* Title: findSaveMoneyList
	* Description: 全查
	* @return
	* @author HuangJian
	* @date 2017年2月27日
	*/
	public List<Map<String, Object>> findSaveMoneyList();
	
	/**
	* Title: selectMoneyStatis
	* Description: 统计
	* @return
	* @author HuangJian
	* @date 2017年2月27日
	*/
	public Map<String, Object> selectMoneyStatis();
}

