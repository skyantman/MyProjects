/**
* @author HuangJian
* @date 2017年2月27日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TSavemoneyMapper;
import com.yundongjia.oa.admin.mapper.TSupplierMapper;
import com.yundongjia.oa.admin.service.SaveMoneyService;
@Service
public class SaveMoneyServiceImpl implements SaveMoneyService{

	@Autowired
	private TSavemoneyMapper savemoneyMapper;
	@Autowired
	private TSupplierMapper supplierMapper;//供应商
	
	@Override
	public List<Map<String, Object>> findSaveMoneyList() {
		List<Map<String, Object>> list = savemoneyMapper.findSaveMoneyList();
		
		if(list !=null && list.size()>0){
			String typeName="";
			for(Map<String, Object> temp:list){
				
				String typeId=String.valueOf(temp.get("type"));
				
				switch(typeId){
				case "00":
					typeName="支付宝";
					break;
				case "01":
					typeName="微信";
					break;
				case "02":
					typeName="银行转账";
					break;
				case "03":
					typeName="现金";
					break;
				default:
					typeName="";
					break;
				}
				
				temp.put("typeName", typeName);
			}
		}
		
		return list;
	}

	@Override
	public Map<String, Object> selectMoneyStatis() {
		Map<String, Object> map=new HashMap<>();
		//总金额
		String sumMoney = supplierMapper.selectMoneySumByType(1);
		
		//总剩余储值额度  
		String surplusMoney =  supplierMapper.selectMoneySumByType(2);
		//月度过期额
		
		//年度过期额度
		
		map.put("sumMoney", sumMoney);
		map.put("surplusMoney", surplusMoney);
		return map;
	}

}

