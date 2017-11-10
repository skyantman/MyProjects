/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TFacilityMapper;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.po.TFacility;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioExample;
import com.yundongjia.oa.admin.service.StudioService;
@Service
public class StudioServiceImpl implements StudioService {

	@Autowired
	private TStudioMapper studioMapper;
	@Autowired
	private TRegionsMapper regionsMapper;
	@Autowired
	private TFacilityMapper facilityMapper;
	
	@Override
	public List<TStudio> findStudioList() {
		TStudioExample example = new TStudioExample();
		example.createCriteria();
		example.setOrderByClause("studioId desc");
	
		return studioMapper.selectByExample(example);
	}
	
	@Override
	public List<Map<String, Object>> findStudioListMap(TStudio studio) {
		 if(!StringUtils.isEmpty(studio.getStudioname())){
			 studio.setStudioname("%"+studio.getStudioname()+"%");
		 }
	
		return dataFormat(studioMapper.findStudioList(studio));
	}
	
	@Override
	public Integer saveStudio(TStudio studio) {
		Integer res = studioMapper.insertSelective(studio);
		return studio.getStudioid();
	}

	@Override
	public Integer updateStudio(TStudio studio) {
		int result = studioMapper.updateByPrimaryKeySelective(studio);
		return result;
	}

	public List<Map<String, Object>> dataFormat(List<Map<String, Object>> list){
		
		if(list != null &&  list.size() > 0){
			Map<String, Object> temp=null;
			TRegions regions;
			Integer typeId=0;
			String typeName=null;
			Integer statusId=0;
			String statusName=null;
			String limitName=null;
			Integer limitId=0;
			for (int i = 0; i < list.size(); i++) {
				temp=list.get(i);
				if(temp == null){
					continue;
				}
				try {
					// 区id
					int regId = Integer.parseInt(String.valueOf(temp.get("regionsId")));
					//的到区
					regions = regionsMapper.getAreaByArea(regId);
					temp.put("city", regions.getpCode());
					temp.put("areaName", regions.getName());
					// 得到市
					regions = regionsMapper.getCityByArea(regions.getpCode());
					temp.put("cityName", regions.getName());
					// 得到省
					regions = regionsMapper.getProvinceByCity(regions.getpCode());
					
					// 省名称 /  code
					temp.put("ProvinceId", regions.getCode());
					temp.put("provinceName", regions.getName());
				} catch (NumberFormatException e) {
					temp.put("provinceName", "");
				}catch(java.lang.NullPointerException e){
					temp.put("provinceName", "");
				}
			
				//场馆类型
				typeId = Integer.parseInt(String.valueOf(temp.get("type")));
				switch (typeId) {
				case 1:
					typeName="工作室";
					break;
				case 2:
					typeName="健身房";
					break;
				case 3:
					typeName="游泳";
					break;
				case 4:
					typeName="羽毛球";
					break;
				case 5:
					typeName="高尔夫";
					break;
				case 6:
					typeName="篮球";
					break;
				case 7:
					typeName="网球";
					break;
				case 8:
					typeName="足球";
					break;
				case 9:
					typeName="台球";
					break;
				case 10:
					typeName="保龄球";
					break;
				case 11:
					typeName="瑜伽";
					break;
				case 12:
					typeName="舞蹈";
					break;
				case 13:
					typeName="马术";
					break;
				case 14:
					typeName="滑雪";
					break;
				case 15:
					typeName="滑冰";
					break;
				case 16:
					typeName="练习场";
					break;
				case 17:
					typeName="智能场馆";
					break;
				default:
					break;
				}
				temp.put("typeName", typeName);
				
				//状态
				statusId = Integer.parseInt(String.valueOf(temp.get("status")));
				switch (statusId) {
				case 0:
					statusName="生效";
					break;
				case 1:
					statusName="禁用";
					break;
				case 2:
					statusName="未审核";
					break;
				default:
					break;
				}
				temp.put("statusName", statusName);
				
				//限制
				limitId = Integer.parseInt(String.valueOf(temp.get("cancleLimit")));
				switch (limitId) {
				case 0:
					limitName="不限制";
					break;
				case 1:
					limitName="6小时";
					break;
				case 2:
					limitName="12小时";
					break;
				case 3:
					limitName="24小时";
					break;
				case 4:
					limitName="36小时";
					break;
				case 5:
					limitName="72小时";
					break;
				default:
					break;
				}
				temp.put("limitName", limitName);
				String equips="";
				//服务设施
				String fac = String.valueOf(temp.get("studioEquip"));
				if(!"".equals(fac)){
					String [] facs = fac.split(",");
					List<String> facList =new ArrayList<>();
					
					if(facs.length > 0){
						for (int j = 0; j < facs.length; j++) {
							//查询服务设施名称
								TFacility facility =  facilityMapper.selectByPrimaryKey(Integer.parseInt(String.valueOf(facs[j])));
								facList.add(facility.getFacilityname());
							 
						}
						
						if(facList !=null || facList.size() > 0){
							for (int j = 0; j < facList.size()-1; j++) {
								equips+=facList.get(j)+",";
							}
							equips+=facList.get(facList.size()-1);
						}
						
					}
					
					temp.put("equips", equips);
				}else{
					temp.put("equips", "");
				}
				
				
				
				
			}
			
			
			try {
				String times =String.valueOf(temp.get("studioOpentime"));
				if(!"~".equals(times)){
					String [] time = times.split("~");
					temp.put("startTime", time[0]);
					temp.put("endTime", time[1]);
				}
			} catch (Exception e) {
				
			}
			
			
		}
		
		return list;
	}

	@Override
	public Map<String, Object> selectStudioById(Integer studioId) {
		 List<Map<String, Object>> data = studioMapper.selectStudioById(studioId);
		 data =  dataFormat(data);
		 if(data != null){
			 return data.get(0);
		 }
		return null;
	}

	@Override
	public Map<String, Object> selectStatisByStudioStatus() {
		Map<String, Object> statis= new HashMap<>();
		//生效状态
		Integer come =  studioMapper.selectStatisByStudioStatus(0);
		
		Integer dis = studioMapper.selectStatisByStudioStatus(1);
		
		Integer noAudit = studioMapper.selectStatisByStudioStatus(2);
		statis.put("come", come);
		statis.put("dis", dis);
		statis.put("noAudit", noAudit);
		return statis;
	}
	
	
	
}

