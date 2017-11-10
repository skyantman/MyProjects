/*
* @author HuangJian
* @date 2017年1月11日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TEnterpriseMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.po.TEnterprise;
import com.yundongjia.oa.admin.po.TEnterpriseExample;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.service.EnterpriseService;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

	@Autowired
	private TEnterpriseMapper enterpriseMapper;
	@Autowired
	private TMemberCardOrderRefMapper memberCardOrderRefMapper;

	@Autowired
	private TRegionsMapper regionsMapper;

	List<Map<String, Object>> list = null;
	
	public Map<String, Object> param;
	@Override
	public int saveEnterprise(TEnterprise enterprise) {

		int res = enterpriseMapper.insertSelective(enterprise);

		return enterprise.getEnterpriseId();
	}

	/*
	 * @Override public List<TEnterprise> findEnterprise() { TEnterpriseExample
	 * example = new TEnterpriseExample();
	 * example.createCriteria().andIsdelEqualTo("0"); return
	 * enterpriseMapper.selectByExample(example); }
	 */


	@Override
	public Map<String, Object> getEnterpriseById(Integer id) {
		TRegions regions = null;
		List<Map<String, Object>> data=null;
		data = enterpriseMapper.getEnterpriseById(id);
		//Map<String, Object> enterprise = data.get(0);
		/*enterprise.put("area", enterprise.get("regionsId"));// 区
		int reg = Integer.parseInt(String.valueOf(enterprise.get("regionsId")));
		// 根据区查询区
		regions = regionsMapper.getAreaByArea(reg);
		enterprise.put("city", regions.getpCode());
		enterprise.put("areaName", regions.getName());
		// 得到城市
		regions = regionsMapper.getCityByArea(regions.getpCode());
		enterprise.put("cityName", regions.getName());
		// 得到省
		regions = regionsMapper.getProvinceByCity(regions.getpCode());
		enterprise.put("Province", regions.getName());

		enterprise.put("ProvinceName", regions.getName());
		enterprise.put("ProvinceId", regions.getCode());*/
		Map<String, Object> enterprise = null;
		data = resultFormart(data);
		if(data.size() > 0){
			enterprise = data.get(0);
		}
		
		return enterprise;
	}

	@Override
	public int updateEnterprise(TEnterprise enterprise) {

		int res = enterpriseMapper.updateByPrimaryKeySelective(enterprise);
		return res;
	}

	@Override
	public List<Map<String, Object>> findEnterpriseAndCard() {

		
		list = enterpriseMapper.findEnterpriseAndCard();
		list = resultFormart(list);
		
		return list;
	}

	@Override
	public List<Map<String, Object>> getEnterpriseByName(String name) {
		list = enterpriseMapper.getEnterpriseByName(name);
		list = resultFormart(list);
		return list;
	}

	/*
	 * 
	 * Title: resultFormart Description: 格式化数据
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月12日
	 */
	private  List<Map<String, Object>> resultFormart(List<Map<String, Object>> list) {
		
		TRegions regions = null;
		Map<String, Object> param;
		Map<String, Object> teMap;
		Integer statusId;
		String statusName="";
		try {
			// 根据企业id统计企业卡次数
			if (list != null || list.size() > 0) {

				for (int i = 0; i < list.size(); i++) {
					param = list.get(i);
					
					statusId = Integer.parseInt(String.valueOf(param.get("status")));
					if(0 == statusId){
						statusName="生效";
					}else if(1 == statusId){
						statusName="禁用";
					}
					param.put("statusName", statusName);
					
					int id = Integer.parseInt(String.valueOf(param.get("enterprise_id")));
					//统计卡次数
					teMap = memberCardOrderRefMapper.getCardOrderStatisByEnterpriseId(id);
					// 区id
					int regId = Integer.parseInt(String.valueOf(param.get("regionsId")));
					//的到区
					regions = regionsMapper.getAreaByArea(regId);
					param.put("city", regions.getpCode());
					param.put("areaName", regions.getName());
					// 得到市
					regions = regionsMapper.getCityByArea(regions.getpCode());
					param.put("cityName", regions.getName());
					// 得到省
					regions = regionsMapper.getProvinceByCity(regions.getpCode());
					
					// 省名称 /  code
					param.put("ProvinceId", regions.getCode());
					param.put("provinceName", regions.getName());
					if(teMap != null){
						param.put("moveCount", teMap.get("moveCount"));//已经运动次数
						param.put("moveSum", teMap.get("moveSum"));//总运动次数
						param.put("remaCount", teMap.get("remaCount"));//剩余运动次数
					}else{
						param.put("moveCount", 0);
						param.put("moveSum", 0);
						param.put("remaCount", 0);
					}
					
				}
			}
		} catch (NumberFormatException e) {
			 
		}

		return list;
	}

	@Override
	public int updateEnterpriseByStatus(Integer status, Integer enterpriseId) {
		param=new HashMap<>();
		param.put("status", status);
		param.put("enterId", enterpriseId);
		int result = enterpriseMapper.updateEnterpriseStatusById(param);
		return result;
	}

	@Override
	public Map<String, Object> getEnterpriseByStatisMessage() {
		
		Map<String, Object> result = enterpriseMapper.getEnterpriseByStatisMessage();
		return result;
	}
}
