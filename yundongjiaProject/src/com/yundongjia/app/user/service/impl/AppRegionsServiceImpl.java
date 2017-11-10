/**
* @author HuangJian
* @date 2017年6月13日
*/
package com.yundongjia.app.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppRegionsService;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
@Service
public class AppRegionsServiceImpl implements AppRegionsService{
	@Autowired
	private TRegionsMapper tRegionsMapper;
	@Override
	public List<Map<String, Object>> findCityByCityName(String cityName) {
		
		return tRegionsMapper.findCityByCityName(cityName);
	}

}

