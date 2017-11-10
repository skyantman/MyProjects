/**
* @author HuangJian
* @date 2017年2月28日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TApply;

public interface ApplyService {

	/**
	* Title: findApplyList
	* Description: 全查或条件
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	List<Map<String, Object>> findApplyList(Map<String, Object> param);
	
	/**
	* Title: selectApplyStatis
	* Description: 统计
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	Map<String, Object> selectApplyStatis();
	
	/**
	* Title: updateApplyById
	* Description: 修改 确定提现
	* @param apply
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	Map<String, Object> updateApplyById(TApply apply);
	
	/**
	* Title: updateApplyStatusById
	* Description: 启用，禁用
	* @param apply
	* @return
	* @author HuangJian
	* @date 2017年3月6日
	*/
	Integer updateApplyStatusById(TApply apply);
}

