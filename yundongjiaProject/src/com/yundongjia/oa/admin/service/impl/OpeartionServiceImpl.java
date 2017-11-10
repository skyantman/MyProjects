/*
* @author HuangJian
* @date 2017年1月9日
*/
package com.yundongjia.oa.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TOpeartionMapper;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.OpeartionService;
@Service
public class OpeartionServiceImpl implements OpeartionService{

	@Autowired
	private TOpeartionMapper opeartionMapper;
	
	@Override
	public int saveOpeartion(TOpeartion opeartion) {
		opeartion.setOpeartionCreatedate(new Date());
		int result = opeartionMapper.insertSelective(opeartion);
		return result;
	}

	@Override
	public List<Map<String, Object>> findOpeartion(Integer opeartionType, Integer dataId) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> param=new HashMap<>();
		param.put("opeartionType", opeartionType);
		param.put("dataId", dataId);
		List<Map<String, Object>> list =  opeartionMapper.findOpeartionByDataAndType(param);
		for (Map<String, Object> map : list) {
			map.put("opeartion_createdate", simpleDateFormat.format(map.get("opeartion_createdate")));
		}
		return list;
	}

	public TOpeartionMapper getOpeartionMapper() {
		return opeartionMapper;
	}

	public void setOpeartionMapper(TOpeartionMapper opeartionMapper) {
		this.opeartionMapper = opeartionMapper;
	}

	@Override
	public List<Map<String, Object>> findOpeartionByOpearType(Integer opeartionType) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Map<String, Object>> list = opeartionMapper.findOpeartionByOpearType(opeartionType);
		for (Map<String, Object> map : list) {
			map.put("opeartion_createdate", simpleDateFormat.format(map.get("opeartion_createdate")));
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findOrderOpeartionById(Integer orderId, String orderType,Integer opearType) {
		Map<String, Object> param=new HashMap<>();
		param.put("orderId", orderId);
		param.put("orderType", "%-"+orderType+"%");
		param.put("opearType", opearType);
		
		
		return opeartionMapper.findOrderOpeartionById(param);
	}

}

