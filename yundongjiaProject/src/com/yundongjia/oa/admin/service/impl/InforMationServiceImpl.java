/**
* @author HuangJian
* @date 2017年2月20日
*/
package com.yundongjia.oa.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.TempFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TInforMationMapper;
import com.yundongjia.oa.admin.po.TInforMation;
import com.yundongjia.oa.admin.service.InforMationService;
@Service
public class InforMationServiceImpl implements InforMationService{

	@Autowired
	private TInforMationMapper inforMationMapper;
	
	@Override
	public Integer saveInforMation(TInforMation inforMation) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		inforMation.setCreatedate(sdf.format(new Date()));
		
		Integer result = inforMationMapper.insertSelective(inforMation);
		return inforMation.getRowid();
	}

	@Override
	public List<Map<String, Object>> findInforMation(Map<String, Object> param) {
		List<Map<String, Object>> list =  inforMationMapper.findInforMationList(param);
		if(list !=null && list.size() > 0){
			Integer status;
			String statusName="";
			
			Integer type;
			String typeName="";
			for(Map<String, Object> temp:list){
				status=Integer.parseInt(String.valueOf(temp.get("status")));
				if(status == 0){
					statusName="生效";
				}else{
					statusName="禁用";
				}
				temp.put("statusName", statusName);
				
				
				type = Integer.parseInt(String.valueOf(temp.get("infoType")));
				switch (type) {
				case 0:
					typeName="体重";
					break;
				case 1:
					typeName="体脂率";
					break;
				case 2:
					typeName="肌肉量";
					break;

				default:
					break;
				}
				
				temp.put("infoTypeName", typeName);
				
				
			} 
			
		}
		return list;
	}

	@Override
	public Integer updateInfoMation(TInforMation inforMation) {
		 
		 
		return inforMationMapper.updateByPrimaryKeySelective(inforMation);
	}

}

