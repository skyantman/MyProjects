package com.yundongjia.oa.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Sides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.service.StudioConsumeOrderRecordService;
@Service
public class StudioConsumeOrderRecordServiceImpl implements StudioConsumeOrderRecordService{

	@Autowired
	private TStudioConsumeOrderRecordMapper studioConsumeOrderRecordMapper;
	
	@Override
	public List<Map<String, Object>> findStudioOrderByMmebers(List<Integer> members) {
		List<Map<String, Object>> datas =  studioConsumeOrderRecordMapper.findStudioOrderByMembers(members);
		//List<Map<String, Object>> type=new ArrayList<>();
		if(datas !=  null){
			if(datas.size() > 0){
				Map<String, Object> temp;
				for (int i = 0; i <datas.size(); i++) {
					temp=datas.get(i);
					temp.put("typeName", "健身房");
				}
			}
		}
		return datas;
	}

	@Override
	public List<Integer> findStudioOrder(String mobilePhoneNum) {
		List<Integer> members = new ArrayList<>();
		List<Map<String, Object>> studioOrders = studioConsumeOrderRecordMapper.findStudioOrderByMobilePhoneNum("%"+mobilePhoneNum+"%");
		if(studioOrders != null){
			if( studioOrders.size() > 0){
				Map<String, Object> temp;
				for (int i = 0; i <  studioOrders.size(); i++) {
					temp=studioOrders.get(i);
					members.add(Integer.parseInt(String.valueOf(temp.get("memberId"))));
				}
			}
		}
		return members;
	}

	@Override
	public String findStatisUsedNumber(List<Integer> members) {
		String sum = studioConsumeOrderRecordMapper.findStatisUsedNumber(members);
		if(!StringUtil.isEmpty(sum)){
			return sum;
		}else{
			return "0";
		}
	}

}
