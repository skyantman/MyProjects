package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TRegions;

public interface EnterpriseAndSelfCardService {
	/**
	 * 查询开通的城市信息
	 * @return
	 * @author LXY
	 * @time 2017/1/10
	 */
	List<TRegions> findRegions();
	/**
	 * @param opeartion 
	 * @return
	 * 创建企业卡类型
	 */
	Integer insertEnterpriseCardType(TCardType tCardType, TOpeartion opeartion);
	/**
	 * @return
	 * 跳转到企业卡类型列表页
	 */
	List<TCardType> findenterprisecardlist();
	/**
	 * @param tOpeartion 
	 * @return
	 * 启用禁用企业卡类
	 */
	Integer updateStopOrStart(Integer status, Integer cardId, TOpeartion tOpeartion);
	/**
	 * @return
	 * 跳转到企业卡类型详情页
	 */
	TCardType findById(Integer cardid);
	/**
	 * @param cardid
	 * @return查询会员卡订单信息根据会员卡类型ID
	 */
	List<Map> findListByCardTypeId(Integer cardid);
	/**
	 * @param info 
	 * @return
	 * 根据企业名称查询卡类型下的单卡
	 */
	List<Map> enterpriseDetail(Integer cardid, String info);
	/**
	 * @return
	 * 启用禁用企业卡
	 */
	Integer updateStopOrStartCard(Integer status, Integer cardId, TOpeartion tOpeartion);
	
	/**
	 * @param cardid
	 * @return查询企业单卡信息根据主键
	 */
	Map enterpriseCardDetail(Integer cardid);
	/**
	 * @return
	 * 创建个人卡类型
	 */
	Integer insertSelfCardType(TCardType tCardType, TOpeartion opeartion);
	/**
	 * @return查询个人卡类型列表
	 */
	List<TCardType> findselfcardlist();
	/**
	 * @param cardid
	 * @return根据卡类ID查询个人卡类
	 */
	TCardType findSelfById(Integer cardid);
	/**
	 * @param cardid
	 * @return查询个人卡列表详情
	 */
	List<Map> findListSelfByCardTypeId(Integer cardid);
	/**
	* Title: findCardTypeByEnterType
	* Description: 查询 未删除 和 未停用  库存>0 或 系统库存  或cardId查询
	* @return
	* @author HuangJian
	* @date 2017年1月17日
	*/
	List<TCardType> findCardTypeByEnterType(Integer cardTypeId);
	
	/**
	* Title: updateCardTypeById
	* Description: 修改卡类型 
	* @param type
	* @return
	* @author HuangJian
	* @date 2017年1月17日
	*/
	int updateCardTypeById(TCardType type);
	Map selfCardDetail(Integer cardid);
	/**
	 * @param cardid
	 * @return查询个人单卡的订单信息
	 * @author LXY
	* @date 2017年2月8日
	 */
	List findOrderList(Integer cardid);
	/**
	 * @param cardid
	 * @param info 手机号搜索条件
	 * @return查询个人单卡的订单信息 根据手机号筛选
	 * @author LXY
	* @date 2017年2月8日
	 */
	List findOrderList(Integer cardid, String info);
	
	
	

}
