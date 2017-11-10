package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TApplyAccount;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TSavemoney;
import com.yundongjia.oa.admin.po.TSupplier;

public interface SupplierService {

	/**
	 * @param pageRow5 
	 * @param pageNum 
	 * @param searchInfo 
	 * @return查询为绑定供应商的场馆列表
	 */
	PageInfo<Map<String, Object>> findNoBandStudioList(Integer pageRow5, Integer pageNum, String searchInfo);

	/**
	 * @param pageRow5
	 * @param pageNum
	 * @param searchInfo
	 * @return查询未绑定供应商的教练列表
	 */
	PageInfo<Map<String, Object>> findNoBandCoach(Integer pageRow5, Integer pageNum, String searchInfo);

	/**
	 * @param pageRow5
	 * @param pageNum
	 * @param searchInfo
	 * @return查询未绑定供应商的商品
	 */
	PageInfo<Map<String, Object>> findNoBandGoods(Integer pageRow5, Integer pageNum, String searchInfo);

	/**
	 * @param tSupplier
	 * @return插入供应商信息到数据库
	 */
	Integer insertSupplier(TSupplier tSupplier);

	/**
	 * @param mobilephonenum
	 * @return保存供应商登录表
	 */
	Integer insertSupplierLogin(String mobilephonenum);

	/**
	 * @return查询供应商统计数据
	 */
	Map<String, Object> findStatistics();

	/**
	 * @param page 页数 
	 * @param rows 行数 
	 * @return查询供应商列表
	 */
	PageInfo<TSupplier> findSupplierList(Integer status, String supplierName, Integer page, Integer integer);

	/**
	 * @param status
	 * @param rowId
	 * @param comm
	 * @return更新供应商状态
	 */
	Map<String, Object> supplierStatus(Integer status, Integer rowId, String comm);

	/**
	 * @param id
	 * @return查询供应商详情
	 */
	TSupplier findSupplierDetail(Integer id);

	/**
	 * @param regionsid
	 * @return查询城市根据区
	 */
	TRegions findCityByArea(Integer regionsid);

	/**
	 * @param regionsid
	 * @return查询区信息
	 */
	TRegions findArea(Integer regionsid);

	/**
	 * @param tSupplier
	 * @return更新供应商该信息
	 */
	Integer updateSupplier(TSupplier tSupplier);

	/**
	 * @param id
	 * @return查询供应商结算订单
	 */
	List<Map<String, Object>> findClearingOrderInfo(Integer id);

	/**
	 * @param supplierId 
	 * @return查询储值表信息根据供应商ID
	 */
	List<Map<String, Object>> findSavemoneyInfo(Integer supplierId);

	/**
	 * @param rowid
	 * @return查询提现表信息
	 */
	List<TApply> findApplyInfo(Integer rowid);

	/**
	 * @param rowid
	 * @return查询供供应商绑定的提现账号列表
	 */
	List<TApplyAccount> finAccount(Integer rowid);

	/**
	 * @param tApplyAccount
	 * @return插入收款人信息
	 */
	Integer insertAccount(TApplyAccount tApplyAccount);

	/**
	 * @param tApplyAccount
	 * @return更新那收款人信息
	 */
	Integer updateAccount(TApplyAccount tApplyAccount);

	/**
	 * @param tSavemoney
	 * @return保存供应商储值记录
	 */
	Integer insertsavemoney(TSavemoney tSavemoney);

	/**
	 * @param type
	 * @param status
	 * @param rowId
	 * @param comm
	 * @return修改订单状态
	 */
	Map<String, Object> orderStatus(Integer type, Integer status, Integer rowId, String comm);

	/**
	 * @param accountInfo
	 * @param comeMoney
	 * @return插入提现信息
	 */
	Integer insertApply(String accountInfo, Double comeMoney);

	/**
	 * @param tApply
	 * @return更新供应商提现状态
	 */
	Integer updateApplyStatus(TApply tApply);

	
	
	
	
	
	
	
}
