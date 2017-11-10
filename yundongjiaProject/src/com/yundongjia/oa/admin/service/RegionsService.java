/*
* @author HuangJian
* @date 2017年1月11日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;

import com.yundongjia.oa.admin.po.TRegions;

public interface RegionsService {

	/*
	 * 
	* Title: geTRegionsByProvince
	* Description: 获取省
	* @author HuangJian
	* @date 2017年1月11日
	 */
	public List<TRegions> geTRegionsByProvince();
	/*
	 * 
	* Title: getCityByProvince
	* Description: proCode:省code 根据省获取市
	* @author HuangJian
	* @date 2017年1月11日
	 */
	public List<TRegions> getCityByProvince(Integer proCode);
	
	/*
	 * 
	* Title: getAreaByCity
	* Description: 根据市code获取区
	* @author HuangJian
	* @date 2017年1月11日
	 */
	public List<TRegions> getAreaByCity(Integer cityCode);
}

