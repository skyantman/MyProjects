package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TCoupon;
import com.yundongjia.oa.admin.po.TMember;

/**
 * 
* @ClassName: ActivityServiceImpl 
* @Description: TODO(运动+活动（团课）服务器) 
* @author LiXiaoYang
* @date 2017年2月14日 17:21:26 
*
 */
public interface AppActivityService {

	/**
	 * @param format
	 * @return根据日期查询活动列表
	 */
	List<Map<String, Object>> findListByDate(String date);

	/**
	 * @param activeId 活动Id
	 * @return根据活动ID查询活动信息
	 */
	Map<String, Object> finListById(Integer activeId);

	/**
	* Title: getActivityCountBySutdioId
	* Description: 根据场馆ID计数活动数量
	* @param studioId
	* @return
	* @author HuangJian
	* @date 2017年6月7日
	*/
	int getActivityCountBySutdioId(Integer studioId);
}
