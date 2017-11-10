/**
* @author HuangJian
* @date 2017年2月20日
*/
package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TMemberShowtime;


public interface AppInforMationService {

	/**
	* Title: findInforMationList
	* Description: 根据类型全查
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月20日
	*/
	List<Map<String, Object>> findInforMationList(Map<String, Object> param);
	
	/**
	* Title: updateInorMationById
	* Description: 根据资讯主键修改
	* @param infoId
	* @return
	* @author HuangJian
	* @date 2017年2月21日
	*/
	Integer updateInorMationById(Integer rowId);

	/**
	 * @param memberId
	 * @return查询会员总运动时间
	 */
	List<TMemberShowtime> findSportTime(Integer memberId);
	/**
	 * @param memberId
	 * @return查询时间排名
	 */
	List<Map<String, Object>> findTimeRank();

	/**
	 * @param memberId
	 * @return查询行程信息展示列表
	 */
	List<Map<String, Object>> findRouteInfo(Integer memberId);

	/**
	 * 保存行程信息
	 * @param routeNum 
	 * @param memberId 
	 */
	Integer saveRoute(Integer memberId, Integer routeNum);

	/**
	 * @param memberId  用户ID
	 * @param sportsMillisecond   运动毫秒数
	 * @return查询会员行程信息
	 */
	Map<String, Object> findMemberRouteInfo(Integer memberId, Double sportsMillisecond);

}

