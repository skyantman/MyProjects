/**
* @author HuangJian
* @date 2017年2月3日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TFacilityMapper;
import com.yundongjia.oa.admin.po.TFacility;
import com.yundongjia.oa.admin.po.TFacilityExample;
import com.yundongjia.oa.admin.service.FacilityService;
@Service
public class FacilityServiceImpl implements FacilityService{

	@Autowired
	private TFacilityMapper facilityMapper;
	
	@Override
	public List<TFacility> findFacility() {
		TFacilityExample example = new TFacilityExample();
		example.createCriteria();
		
		return facilityMapper.selectByExample(example);
	}

	@Override
	public TFacility selectFacilityById(Integer id) {
		 
		
		return facilityMapper.selectByPrimaryKey(id);
	}

}

