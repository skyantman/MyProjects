/**
* @author HuangJian
* @date 2017年2月11日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TGoodsStandard;

public interface GoodsStandardService {

	/**
	* Title: findGoodsStandard
	* Description: 查询颜色，规格
	* @return
	* @author HuangJian
	* @date 2017年2月11日
	*/
	public List<Map<String, Object>> findGoodsStandard();
	
	/**
	* Title: insertGoodsStandard
	* Description: 保存，规格
	* @param gs
	* @return
	* @author HuangJian
	* @date 2017年2月11日
	*/
	public Integer insertGoodsStandard(TGoodsStandard gs);
	
	/**
	* Title: deleteGoodsStandardByGoodsId
	* Description: 根据商品ID删除规格
	* @param goodsId
	* @return
	* @author HuangJian
	* @date 2017年2月11日
	*/
	public Integer deleteGoodsStandardByGoodsId(Integer goodsId);
}

