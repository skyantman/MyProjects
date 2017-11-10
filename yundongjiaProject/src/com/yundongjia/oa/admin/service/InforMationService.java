/**
* @author HuangJian
* @date 2017年2月20日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TInforMation;

public interface InforMationService {

	/**
	* Title: saveInforMaction
	* Description: 保存资讯
	* @param inforMation
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	public Integer saveInforMation(TInforMation inforMation);
	
	/**
	* Title: findInforMation
	* Description: 全查或条件查询
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	public List<Map<String, Object>> findInforMation(Map<String, Object> param);
	
	/**
	* Title: updateInfoMation
	* Description: 修改资讯
	* @param inforMation
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	public Integer updateInfoMation(TInforMation inforMation);
}

