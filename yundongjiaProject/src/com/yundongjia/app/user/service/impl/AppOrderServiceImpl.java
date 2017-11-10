/**
* @author HuangJian
* @date 2017年2月16日
*/
package com.yundongjia.app.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppOrderService;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
@Service
public class AppOrderServiceImpl implements AppOrderService{

	@Autowired
	private TOrderMapper orderMapper;
	
	Map<String, Object> map;
	@Override
	public Map<String, Object> getOrderById(Map<String, Object> param) {
		map = orderMapper.getAppOrderById(param);
		return map;
	}

}

