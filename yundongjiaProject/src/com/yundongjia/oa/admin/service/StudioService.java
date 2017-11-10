/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TStudio;

public interface StudioService {

	
	
	
	/**
	* Title: findStudioList
	* Description: 全查  返回对象类型
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	List<TStudio> findStudioList();
	
	
	
	
	/**
	* Title: findStudioList
	* Description: 场馆全查  返回map类型
	* @return
	* @author HuangJian
	* @date 2017年1月19日
	*/
	List<Map<String, Object>> findStudioListMap(TStudio studio);
	
	/**
	* Title: saveStudio
	* Description: 保存场馆
	* @param studio
	* @return
	* @author HuangJian
	* @date 2017年2月3日
	*/
	Integer saveStudio(TStudio studio);
	
	/**
	* Title: updateStudio
	* Description: 修改场馆
	* @param studio
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	Integer updateStudio(TStudio studio);
	
	/**
	* Title: selectStudioById
	* Description: 详情
	* @param studioId
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	Map<String, Object> selectStudioById(Integer studioId);
	
	/**
	* Title: selectStatisByStudioStatus
	* Description: 根据不同的状态统计
	* @param status
	* @return
	* @author HuangJian
	* @date 2017年2月4日
	*/
	Map<String, Object> selectStatisByStudioStatus();
}

