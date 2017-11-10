/**
* @author HuangJian
* @date 2017年3月22日
*/
package com.yundongjia.oa.admin.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.po.TConfig;
import com.yundongjia.oa.admin.po.TConfigExample;
import com.yundongjia.oa.admin.service.ConfigService;
@Service
public class ConfigServiceImpl implements ConfigService{

	@Autowired
	private TConfigMapper configMapper;
	@Override
	public String getConfigValueByName(String name) {
		TConfigExample example = new TConfigExample();
		example.createCriteria().andCnameEqualTo(name).andStatEqualTo(1);
		List<TConfig> list =  configMapper.selectByExample(example);
		return list.get(0).getCvalue();
	}

	 
	
	 

}

