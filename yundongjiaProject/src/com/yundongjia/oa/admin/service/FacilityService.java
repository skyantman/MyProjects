/**
* @author HuangJian
* @date 2017年2月3日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;

import com.yundongjia.oa.admin.po.TFacility;

public interface FacilityService {

	/**
	* Title: findFacility
	* Description: 全查服务设施
	* @return
	* @author HuangJian
	* @date 2017年2月3日
	*/
	public List<TFacility> findFacility();
	
	/**
	* Title: selectFacilityById
	* Description: 根据服务设施id查询
	* @param id
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	public TFacility selectFacilityById(Integer id);
}

