/**
* @author HuangJian
* @date 2017年2月16日
*/
package com.yundongjia.app.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppStudioConsumeOrderRecordService;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
@Service
public class AppStudioConsumeOrderRecordServiceImpl implements AppStudioConsumeOrderRecordService{

	@Autowired
	private TStudioConsumeOrderRecordMapper studioConsumeOrderRecordMapper;
	@Override
	public Integer saveAppStudioConsumeOrderRecord(TStudioConsumeOrderRecord record) {
		Integer result = studioConsumeOrderRecordMapper.insertSelective(record);
		return record.getOrderid();
	}

}

