/*
* @author HuangJian
* @date 2017年1月11日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.service.RegionsService;
@Service
public class RegionsServiceImpl implements RegionsService {

	@Autowired
	private TRegionsMapper regionsMapper;
	@Override
	public List<TRegions> geTRegionsByProvince() {
		
		return regionsMapper.geTRegionsByProvince();
	}
	@Override
	public List<TRegions> getCityByProvince(Integer proCode) {
		
		return regionsMapper.getCityByProvince(proCode);
	}
	@Override
	public List<TRegions> getAreaByCity(Integer cityCode) {

		return regionsMapper.getAreaByCity(cityCode);
	}

}

