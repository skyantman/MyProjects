/**
* @author HuangJian
* @date 2017年2月21日
*/
package com.yundongjia.app.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppFacilityService;
import com.yundongjia.oa.admin.mapper.TFacilityMapper;
import com.yundongjia.oa.admin.po.TFacility;
@Service
public class AppFacilityServiceImpl implements AppFacilityService{

	@Autowired
	private TFacilityMapper facilityMapper;
	@Override
	public TFacility getFacilityById(Integer id) {
		
		return facilityMapper.selectByPrimaryKey(id);
	}

}

