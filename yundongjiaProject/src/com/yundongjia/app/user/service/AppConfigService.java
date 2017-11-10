/**
* @author HuangJian
* @date 2017年2月17日
*/
package com.yundongjia.app.user.service;

import java.util.List;

import com.yundongjia.oa.admin.po.TConfig;

public interface AppConfigService {

	/**
	* Title: getConfigValueByName
	* Description: 根据名称查询value
	* @param name
	* @return
	* @author HuangJian
	* @date 2017年2月17日
	*/
	public List<String> getConfigValueByName(String name);
	
	/**
	* Title: getConfigList
	* Description: 全查
	* @return
	* @author HuangJian
	* @date 2017年2月23日
	*/
	public List<TConfig> getConfigList();
}

