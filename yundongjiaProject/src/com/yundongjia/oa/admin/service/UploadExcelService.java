/**
* @author HuangJian
* @date 2017年2月14日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UploadExcelService {
	 
	 
	
	/**
	* Title: exportExcelAll
	* Description: 导出EXCEL
	* @param list  List<Map<String,Object>> 类型的数据
	* @param type  0：活动，1：场馆，2：教练，3：商品，4：订单，5：退订订单
	* @param response
	* @param request
	* @author HuangJian
	* @date 2017年3月8日
	*/
	public void exportExcelAll(List<Map<String, Object>> list,Integer type,HttpServletResponse response,HttpServletRequest request);
}

