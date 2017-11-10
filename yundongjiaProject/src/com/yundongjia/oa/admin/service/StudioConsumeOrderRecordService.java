package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

public interface StudioConsumeOrderRecordService {

	/**
	* Title: StudioConsumeOrderRecordService.java
	* Description: 根据用户集合查询订单
	* @param members
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	public List<Map<String, Object>> findStudioOrderByMmebers(List<Integer> members);
	
	/**
	* Title: StudioConsumeOrderRecordService.java
	* Description: 根据手机号码模糊查询用户
	* @param mobilPhoneNum 手机号码
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	public List<Integer> findStudioOrder(String mobilePhoneNum);
	
	/**
	* Title: StudioConsumeOrderRecordService.java
	* Description: 统计会员使用次数
	* @param memebers
	* @return
	* @author HuangJian
	* @date 2017年4月21日
	*/
	public String findStatisUsedNumber(List<Integer> members);
}
