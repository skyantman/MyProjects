/**
* @author HuangJian
* @date 2017年2月11日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TGoodsStandardMapper;
import com.yundongjia.oa.admin.po.TGoodsStandard;
import com.yundongjia.oa.admin.po.TGoodsStandardExample;
import com.yundongjia.oa.admin.service.GoodsStandardService;

@Service
public class GoodsStandardImpl implements GoodsStandardService{

	@Autowired
	private TGoodsStandardMapper goodsStandardMapper;
	@Override
	public List<Map<String, Object>> findGoodsStandard() {
		List<Map<String, Object>> maps = goodsStandardMapper.findGoodsStandard();
		Map<String, Object> temp=new HashMap<>();
		if(maps != null && maps.size()>0){
			for (int i = 0; i < maps.size(); i++) {
				temp = maps.get(i);
				String names = String.valueOf(temp.get("standard"));
				String [] name = names.split(",");
				temp.put("stans", name);
			}
		}
		return maps;
	}
	@Override
	public Integer insertGoodsStandard(TGoodsStandard gs) {
		
		return goodsStandardMapper.insertSelective(gs);
	}
	@Override
	public Integer deleteGoodsStandardByGoodsId(Integer goodsId) {
		TGoodsStandardExample example = new TGoodsStandardExample();
		example.createCriteria().andGoodsidEqualTo(goodsId);
		return goodsStandardMapper.deleteByExample(example);
	}


}

