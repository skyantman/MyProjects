/**
* @author HuangJian
* @date 2017年2月7日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TGoods;

public interface GoodsService {

	/**
	* Title: saveGoods
	* Description: 保存商品
	* @param goods
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	public Integer saveGoods(TGoods goods);
	
	/**
	* Title: findGoodsList
	* Description: 全查，或条件查询
	* @param goods
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	public List<Map<String, Object>> findGoodsList(TGoods goods);
	
	/**
	* Title: selectGoodsById
	* Description: 
	* @param goodsId
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	public Map<String, Object> selectGoodsById(Integer goodsId);
	
	/**
	* Title: updateGoods
	* Description: 修改商品
	* @param goods
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	public Integer updateGoods(TGoods goods);
	
	/**
	* Title: selectGoodsStatus
	* Description: 商品首页统计
	* @return
	* @author HuangJian
	* @date 2017年2月10日
	*/
	public Map<String, Object> selectGoodsStatus();
}

