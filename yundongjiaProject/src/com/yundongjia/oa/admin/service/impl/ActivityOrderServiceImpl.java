/**
* @author HuangJian
* @date 2017年2月8日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.service.ActivityOrderService;
@Service
public class ActivityOrderServiceImpl implements ActivityOrderService{

	@Autowired
	private TActivityOrderMapper activityOrderMapper;
	
	public Map<String, Object> temp;
	@Override
	public List<Map<String, Object>> findActivityOrders(Map<String, Object> param) {
		
		 
		
		
		return  dataFormat(activityOrderMapper.findActivityOrders(param));
	}

	public List<Map<String, Object>> dataFormat(List<Map<String, Object>> list){
		
		if(list != null){
			for (int i = 0; i < list.size(); i++) {
				temp=list.get(i);
				
				Integer genderId = Integer.parseInt(String.valueOf(temp.get("gender")));
				String genderName="男";
				if(genderId == 1){
					genderName="女";
				}
				temp.put("genderName", genderName);
				
				Integer sourceId =Integer.parseInt(String.valueOf(temp.get("source")));
				String sourceName = "App";
				if(1 == sourceId){
					sourceName="微信 ";
				}
				temp.put("sourceName", sourceName);
				
				String payTypeName ="";
				String payTypeId = String.valueOf(temp.get("payType"));
				switch (payTypeId) {
				case "00":
					payTypeName="支付宝";
					break;
				case "01":
					payTypeName="微信";
					break;
				case "02":
					payTypeName="银行卡";
					break;
				case "03":
					payTypeName="企业卡";
					break;

				default:
					break;
				}
				temp.put("payTypeName", payTypeName);
				
				String payStatusName="";
				Integer payStatusId = Integer.parseInt(String.valueOf(temp.get("payStatus")));
				switch (payStatusId) {
				case 0:
					payStatusName="待支付";
					break;
				case 1:
					payStatusName="已取消";
					break;
				case 2:
					payStatusName="已支付";
					break;
				case 3:
					payStatusName="退订中";
					break;
				case 4:
					payStatusName="已退订";
					break;
				case 5:
					payStatusName="已完成";
					break;

				default:
					break;
				}
				temp.put("payStatusName", payStatusName);
			}
		}
		
		return list;
	}

	@Override
	public Map<String, Object> selectActivityOrderStatisByPayStatus() {
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("status", 2);
		pMap.put("dateTime", null);
		pMap.put("activityId", null);
		//已支付状态 /报名人数
		Integer yzfStatus =  activityOrderMapper.selectActivityOrderStatisByPayStatus(pMap);
		
		
		
		result.put("yzfStatus", yzfStatus);
		return result;
	}

	@Override
	public Integer updateActivityOrderById(TActivityOrder activityOrder) {
		
		return activityOrderMapper.updateByPrimaryKeySelective(activityOrder);
	}
	
	
}

