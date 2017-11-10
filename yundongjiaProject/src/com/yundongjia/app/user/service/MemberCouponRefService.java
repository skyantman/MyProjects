/**
* @author HuangJian
* @date 2017年2月14日
*/
package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

public interface MemberCouponRefService {

	/**
	* Title: findCouponListByMember
	* Description: 根据会员查询卷
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月14日
	*/
	List<Map<String, Object>> findCouponListByMember(Map<String, Object> param);
}

