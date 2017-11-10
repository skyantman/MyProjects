/**
* @author HuangJian
* @date 2017年2月17日
*/
package com.yundongjia.app.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppConfigService;
import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.po.TConfig;
import com.yundongjia.oa.admin.po.TConfigExample;
@Service
public class AppConfigServiceImpl implements AppConfigService{

	@Autowired
	private TConfigMapper tConfigMapper;
	
	@Override
	public List<String> getConfigValueByName(String name) {
		TConfigExample example = new TConfigExample();
		example.createCriteria().andStatEqualTo(1).andCnameEqualTo(name);
		List<TConfig> list =  tConfigMapper.selectByExample(example);
		
		List<String> temp=new ArrayList<>();
		
		if(list !=null && list.size() > 0){
			for(TConfig t:list){
				temp.add(t.getCvalue());
			}
		}
		return temp;
	}

	@Override
	public List<TConfig> getConfigList() {
		TConfigExample example = new TConfigExample();
		example.createCriteria().andStatEqualTo(1);
		return tConfigMapper.selectByExample(example);
	}

	
}

