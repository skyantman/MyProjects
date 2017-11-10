/*卡
* @author HuangJian
* @date 2017年1月11日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TMemberCardOrderRef;

public interface MemberCardOrderRefService {

	/*
	 * 
	* Title: saveMemberCardOrderRef
	* Description: 保存卡信息
	* @author HuangJian
	* @date 2017年1月11日
	 */
	public int saveMemberCardOrderRef(TMemberCardOrderRef cardOrder);
	
	/*
	 * 
	* Title: getCardOrderByList
	* Description: 根据cardid查询信息      
	* @author HuangJian
	* @date 2017年1月11日
	 */
	public Map<String, Object> getCardOrderById(Integer cardId);
	
	
 
	/**
	* Title: getCardOrderByEnterId
	* Description: 根据企业id查询所有的卡
	* @param enterId :企业id
	* @return
	* @author HuangJian
	* @date 2017年1月16日
	*/
	public List<Map<String, Object>> getCardOrderByEnterId(Integer enterId);
}

