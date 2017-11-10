/**
* @author HuangJian
* @date 2017年2月7日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TGoodsMapper;
import com.yundongjia.oa.admin.mapper.TGoodsStandardMapper;
import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private TGoodsMapper goodsMapper;
	@Autowired
	private TGoodsStandardMapper goodsStandardMapper;
	@Override
	public Integer saveGoods(TGoods goods) {
		Integer result = goodsMapper.insertSelective(goods);
		return goods.getGoodsid();
	}
	@Override
	public List<Map<String, Object>> findGoodsList(TGoods goods) {
	
		return dataForamt(goodsMapper.findGoodsList(goods));
	}

	public List<Map<String, Object>> dataForamt(List<Map<String, Object>> list){
		
		if(list != null && list.size() >0){
			Map<String, Object> temp;
			String statusName="";
			String limitName="";
			for (int i = 0; i < list.size(); i++) {
				temp=list.get(i);
				Integer status = Integer.parseInt(String.valueOf(temp.get("status")));
				switch (status) {
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
				
				Integer limitId=Integer.parseInt(String.valueOf(temp.get("goodsLimit")));
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
				
				Integer goodsId = Integer.parseInt(String.valueOf(temp.get("goodsId")));
				if(goodsId != 0){
					Map<String, Object> param=new HashMap<>();
					param.put("goodsId", goodsId);
					List<Map<String, Object>> stands  =  goodsStandardMapper.selectGoodsStandardByGoodsId(param);
					
					if(stands !=null && stands.size() > 0){
						temp.put("strColor", stands.get(0).get("standard")); 
						
					}else{
						temp.put("strColor", null); 
					}
					
					if(stands != null && stands.size() > 1){
						temp.put("strSize", stands.get(1).get("standard"));
					}else{
						temp.put("strSize", null);
					}
					
					
				}
				
			}
		}
		
		return list;
	}
	@Override
	public Map<String, Object> selectGoodsById(Integer goodsId) {
		
		List<Map<String, Object>> list = goodsMapper.selectGoodsById(goodsId);
		list = dataForamt(list);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public Integer updateGoods(TGoods goods) {
		
		return goodsMapper.updateByPrimaryKeySelective(goods);
	}
	@Override
	public Map<String, Object> selectGoodsStatus() {
		Integer statusOk =  goodsMapper.selectStatusCount(0);//生效状态
		Integer statusDis =  goodsMapper.selectStatusCount(1);//禁用状态
		Integer statusAudit =  goodsMapper.selectStatusCount(2);//未审核状态
		
		Map<String, Object> result = new HashMap<>();
		result.put("statusOk", statusOk);
		result.put("statusDis", statusDis);
		result.put("statusAudit", statusAudit);
		return result;
	}
}

