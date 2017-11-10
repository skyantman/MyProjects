package com.yundongjia.oa.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.po.TConfig;
import com.yundongjia.oa.admin.po.TConfigExample;
import com.yundongjia.oa.admin.service.BaseConfigService;


/**
 * Created by ltlxy on 2016/9/29.
 */
@Service
public class BaseConfigServiceImpl implements BaseConfigService{
	@Autowired
	private  TConfigMapper baseConfigMapper;
	
	@Override
	public String findmemberInfo(String cname) {
		TConfigExample example = new TConfigExample();
	    example.createCriteria().andCnameEqualTo(cname).andStatEqualTo(1);
	    List<TConfig> list = this.baseConfigMapper.selectByExample(example);
	    if(list.size()>0){
	    	return list.get(0).getCvalue();
	    	}
		return null;
	}

   
}