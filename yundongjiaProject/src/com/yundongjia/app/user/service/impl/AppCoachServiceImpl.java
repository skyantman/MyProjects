/**
* @author HuangJian
* @date 2017年2月15日
*/
package com.yundongjia.app.user.service.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppCoachService;
import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.po.TConfig;
import com.yundongjia.oa.admin.po.TConfigExample;
import com.yundongjia.oa.utils.MapDistance;
@Service
public class AppCoachServiceImpl implements AppCoachService{

	@Autowired
	private TCoachMapper coachMapper;
	@Autowired
	private TConfigMapper configMapper;
	@Autowired
	private TRegionsMapper regionsMapper;
	List<Map<String, Object>> result;
	
	@Override
	public List<Map<String, Object>> findAppCoachList(Map<String, Object> param) {
		List<Integer> areas = null; 
		if(param.containsKey("city")){
			areas = regionsMapper.getAreaCodeByCityCode(param.get("city").toString()); 
			if(areas != null && areas.size() == 0){
				areas = null;
			}
		}else{
			
		}
		param.put("areas", areas);
		result =  coachMapper.findAppCoachList(param);
		
		if(result != null || result.size() > 0){
			String userLat=String.valueOf(param.get("lat"));
			String userLng=String.valueOf(param.get("lng"));
			
			
			
			for(Map<String, Object> temp:result){
				//会员价
				 
				temp.put("memPrice", getMemberPrice(temp.get("coursePrice")));
				
				try {
					//距离
					String stuLat=String.valueOf(temp.get("lat"));
					String stuLng=String.valueOf(temp.get("lng"));
					if(!"null".equals(userLat) || null != userLat || !"".equals(userLat) && !"null".equals(userLng) || null != userLng || !"".equals(userLng)){
						temp.put("distance", MapDistance.getDistance(userLat, userLng, stuLat, stuLng));
					}else{
						temp.put("distance","0");
					}
				} catch (Exception e) {
					temp.put("distance","0");
				}
			}
		}
		
		return result;
	}

	@Override
	public Map<String, Object> selectAppCoachById(Integer coachId) {
		Map<String, Object> data =coachMapper.selectAppCoachById(coachId);
		//会员价
		data.put("memPrice",getMemberPrice(data.get("coursePrice")));
		return data;
	}

	
	/**
	* Title: getMemberPrice
	* Description: 获取会员价   coursePrice*折扣
	* @param coursePrice
	* @return
	* @author HuangJian
	* @date 2017年2月16日
	*/
	public String getMemberPrice(Object coursePrice){
		double memPrice=0.0;
		DecimalFormat    df   = new DecimalFormat("######0.00");
		//教练会员折扣
		TConfigExample example = new TConfigExample();
		example.createCriteria().andCnameEqualTo("COACH_MEMBER_PRICE");
		List<TConfig> configs =  configMapper.selectByExample(example);
		if(configs !=null && configs.size()>0){
			memPrice = Double.parseDouble(String.valueOf(configs.get(0).getCvalue()));
		}else{
			
		}
		//会员价
		Double coursePri= Double.parseDouble(String.valueOf(coursePrice));
		String pro= df.format(coursePri*memPrice);
		
		
		return pro;
	}
	
}

