/**
* @author HuangJian
* @date 2017年2月14日
*/
package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TStudio;

public interface AppStudioService {

	/**
	* Title: findStudioList
	* Description: 场馆列表
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月14日
	*/
	public List<Map<String, Object>> findStudioList(Map<String, Object> param);
	
	/**
	* Title: selectStudioById
	* Description: 场馆详情
	* @param studioId
	* @return
	* @author HuangJian
	* @date 2017年2月15日
	*/
	public Map<String, Object> selectStudioById(Map<String, Object> param);
	
	public TStudio selectStudioInfo(Integer id);

	/**
	 * @param orderType
	 * @param memberId
	 * @return查询结束运动分享信息
	 */
	public Map<String, Object> findOverSportShareInfo(Integer orderType, Integer memberId);
	
	
	
	/**
	* Title: getStudioTypeCount
	* Description: 列出所有场馆类型和总数
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年6月9日
	*/
	public List<Map<String, Object>> getStudioTypeCount(Map<String, Object> map);
	
	/**
	* Title: getStudeioByAreaCount
	* Description: 根据区统计类型
	* @return
	* @author HuangJian
	* @date 2017年6月8日
	*/
	public List<Map<String, Object>> getStudeioByAreaCount();
	
	/**
	* Title: getStudioByType
	* Description: 根据场馆类型查询场馆
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年6月8日
	*/
	public List<Map<String, Object>> getStudioByTypeList(Map<String, Object> param);
	
	/**
	* Title: getStudioByAreaTypeList
	* Description: 根据地区和类型查询场馆
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年6月8日
	*/
	public List<Map<String, Object>> getStudioByAreaTypeList(Map<String, Object> param);
	
	/**
	* Title: findStudioByConsumeMoneyOrder
	* Description: 根据场馆原价高或低排序
	* @param param: asc desc   ，页码
	* @return
	* @author HuangJian
	* @date 2017年6月9日
	*/
	public List<Map<String, Object>> findStudioByConsumeMoneyOrder(Map<String, Object> param);
	
	/**
	* Title: findStdioByMapModel
	* Description: 地图模式加载场馆
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年6月12日
	*/
	public List<Map<String, Object>> findStdioByMapModel(Map<String, Object> param);
	
	
	/**
	* Title: findStudioNearbyData
	* Description: 搜索条件 附近，返回每个区的类型统计
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年6月12日
	*/
	public List<Map<String, Object>> findStudioNearbyData(Map<String, Object> param);
	
	/**
	* Title: findStudioByPlatList
	* Description: 场馆地图模式
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年6月26日
	*/
	public List<Map<String, Object>> findStudioByPlatList(Map<String, Object> param);
}

