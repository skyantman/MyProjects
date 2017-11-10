/**
* @author HuangJian
* @date 2017年2月28日
*/
package com.yundongjia.oa.admin.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.TempFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.yundongjia.oa.admin.mapper.TGoodsOrderMapper;
import com.yundongjia.oa.admin.mapper.TOrderDiscountMapper;
import com.yundongjia.oa.admin.mapper.TOrderMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TSupplierMapper;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.po.TOrderDiscount;
import com.yundongjia.oa.admin.po.TOrderDiscountExample;
import com.yundongjia.oa.admin.po.TSupplier;
import com.yundongjia.oa.admin.po.TSupplierExample;
import com.yundongjia.oa.admin.po.TSupplierExample.Criteria;
import com.yundongjia.oa.admin.service.ClearOrderService;
import com.yundongjia.oa.admin.vo.ClearOrderSearchVo;
@Service
public class ClearOrderServiceImpl implements ClearOrderService{

	@Autowired
	private TStudioConsumeOrderRecordMapper studioConsumeOrderRecordMapper;//场馆
	@Autowired
	private TSupplierMapper supplierMapper;//供应商
	@Autowired
	private TOrderMapper orderMapper;//私教
	@Autowired
	private TGoodsOrderMapper goodsOrderMapper;//商品
	@Autowired
	private TOrderDiscountMapper orderDiscountMapper;
	
	public List<Map<String, Object>> dataList;
	
	@Override
	public List<Map<String, Object>> findClearOrderList(ClearOrderSearchVo vo) {
		
		List<Map<String, Object>> all=new ArrayList<>();
		
		TSupplierExample example = new TSupplierExample();
		Criteria createCriteria = example.createCriteria();
		
		/**
		 * 1.先把供应商名称筛选出来
		 * 2.如果有条件供应商，先把供应商筛选出来，否则，就直接查询所有供应商
		 */
		if(!"".equals(vo.getSupplierName()) && vo.getSupplierName() != null){
			
			createCriteria.andSuppliernameLike(vo.getSupplierName());
		}else{
			
		}

		List<TSupplier> suppliers =  supplierMapper.selectByExample(example);
		
		//场馆处理之后的数据
		List<Map<String, Object>> studios =  disPostStudio(suppliers, vo);
		//教练处理之后的数据
		List<Map<String, Object>> coachs = disPostCoachs(suppliers,vo);
		
		List<Map<String, Object>> goods=disPostGoods(suppliers, vo);
		//拼接场馆
		if(null != studios && studios.size() > 0){
			
			for(Map<String, Object> temp:studios){
				all.add(temp);
			}
		}
		//追加教练
		if(coachs !=null && coachs.size()>0){
			for(Map<String, Object> temp:coachs){
				all.add(temp);
			}
		}
		
		//追加商品
		if(goods!=null && goods.size()>0){
			for(Map<String, Object> temp:goods){
				all.add(temp);
			}
			
		}
		return all;
		
	}

	
	
	/**
	* Title: disPostStudio
	* Description: 处理场馆数据
	* @param suppliers
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	public List<Map<String, Object>> disPostStudio(List<TSupplier> suppliers,ClearOrderSearchVo vo){
		
		String [] array;
		String [] moneyArray;
		String studioStr;
		String moneyStr;
		Map<String, Object> tempResultMap;
		Map<String, Object> fixDataMap;
		List<Map<String, Object>> resultList=new ArrayList<>();
		//判断供应商
		if(null != suppliers && suppliers.size() > 0){
			
			//循环供应商
			for(TSupplier s:suppliers){
				//------------------------------场馆数据开始
				studioStr = s.getLinkstudioid();//字符串场馆ID
				moneyStr = s.getLikestudiocostprice();//字符串场馆价格ID
				if(studioStr != null || !"".equals(studioStr)){
					array = studioStr.split(",");//场馆ID数组
					moneyArray = moneyStr.split(",");//场馆价格数组
					if(array !=null && array.length > 0){
						for(int i=0;i<array.length;i++){
							vo.setId(Integer.parseInt(array[i]));
							dataList = studioConsumeOrderRecordMapper.findClearOrderList(vo);
							//----------------------------固定显示数据
							fixDataMap = new HashMap<>();
							fixDataMap.put("id", array[i]);//场馆id
							fixDataMap.put("price", moneyArray[i]);//场馆对应价格
							fixDataMap.put("orderTypeName", "场馆");
							fixDataMap.put("orderTypeId", "1");
							fixDataMap.put("supplierName", s.getSuppliername());//供应商名称
							fixDataMap.put("supplierId", s.getRowid());//供应商ID
							if(0 == s.getClearingtype()){
								fixDataMap.put("clearingTypeName", "预付结算");
							}else if(1 == s.getClearingtype()){
								fixDataMap.put("clearingTypeName", "周期结算");
							}
							fixDataMap.put("clearingType", s.getClearingtype());//结算模式（0预付 1周期结算）
							
							
							//判断结果是否为空
							if(dataList != null || dataList.size() > 0){
								for(Map<String, Object> tt:dataList){
									tempResultMap=new HashMap<>();
									tempResultMap.put("name", tt.get("studioName"));//商品名称---场馆名称
									tempResultMap.put("orderId", tt.get("orderId"));//订单表主键
									tempResultMap.put("orderNum", tt.get("orderNum"));//订单号
									tempResultMap.put("payStatus", tt.get("payStatus"));//订单状态
									
									tempResultMap.put("retreatDate", tt.get("retreatDate")==null?"":tt.get("retreatDate"));//订单结算日期
									
									tempResultMap.putAll(fixDataMap);//固定数据与动态数据结合
									
									resultList.add(tempResultMap);
								}
							 
								
							}//判断场馆订单是否为空结束
							
							
							
						}//循环场馆结束
						
						
					}//判断绑定资源结束
					
				}//------------------------------场馆数据结束
				
				
			}//结束循环供应商
			
			
		}//结束判断
		
		return resultList;
	}
	
	/**
	* Title: disPostCoachs
	* Description:  处理教练数据
	* @param suppliers  全部供应商
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	public List<Map<String, Object>> disPostCoachs(List<TSupplier> suppliers,ClearOrderSearchVo vo){
		List<Map<String, Object>> coachMaps=new ArrayList<>();
		if(suppliers == null){
			
			return null;
		}
		List<Map<String, Object>> tempList;
		//Map<String, Object> tempMap;
		Map<String, Object> tempResultMap;
		String coachStr;
		String [] coachIds;
		String coachMoneyStr;
		String [] coachMoneyArr;
		Map<String, Object> fixDataMap;
		for(TSupplier sp:suppliers){
			coachStr=sp.getLinkcoachid();
			coachMoneyStr=sp.getLikecoachcostprice();
			if(coachStr != null && !"".equals(coachStr)){
				coachIds = coachStr.split(",");
				coachMoneyArr = coachMoneyStr.split(",");
				if(coachIds !=null && coachIds.length > 0){
					for(int i=0;i<coachIds.length;i++){
						vo.setId(Integer.parseInt(coachIds[i]));//查询条件
						
						tempList =  orderMapper.findClearOrderList(vo);
						
						fixDataMap=new HashMap<>();
						fixDataMap.put("id", coachIds[i]);//教练 ID
						fixDataMap.put("price", coachMoneyArr[i]);//教练对应价格
						fixDataMap.put("orderTypeName", "私教");
						fixDataMap.put("orderTypeId", "2");
						fixDataMap.put("supplierName", sp.getSuppliername());//供应商名称
						fixDataMap.put("supplierId", sp.getRowid());//供应商ID
						if(0 == sp.getClearingtype()){
							fixDataMap.put("clearingTypeName", "预付结算");
						}else if(1 == sp.getClearingtype()){
							fixDataMap.put("clearingTypeName", "周期结算");
						}
						fixDataMap.put("clearingType", sp.getClearingtype());//结算模式（0预付 1周期结算）
						
						if(tempList != null && tempList.size() > 0){
							
							for(Map<String, Object> tempMap:tempList){
								tempResultMap=new HashMap<>();
								//tempResultMap.put("id", coachIds[i]);//教练ID
								//tempResultMap.put("price", coachMoneyArr[i]);//价格
								tempResultMap.put("name", tempMap.get("nickName"));//教练名称
								tempResultMap.put("orderId", tempMap.get("orderId"));//私教订单ID
								tempResultMap.put("orderNum", tempMap.get("orderNum"));//订单号
								tempResultMap.put("payStatus", tempMap.get("payStatus"));//支付状态
								//结算日期
								tempResultMap.put("retreatDate", tempMap.get("retreatDate")==null?"":tempMap.get("retreatDate"));
								
								tempResultMap.putAll(fixDataMap);//map交集
								
								coachMaps.add(tempResultMap);
							}
						
							
						}//判断查询数据
						
						
						
					}//循环绑定教练
					
				}
				
			} 
			
		}
		

		return coachMaps;
	}
	
	/**
	* Title: disPostGoods
	* Description: 处理商品信息
	* @param suppliers
	* @return
	* @author HuangJian
	* @date 2017年3月1日
	*/
	public List<Map<String, Object>> disPostGoods(List<TSupplier> suppliers,ClearOrderSearchVo vo){
		if(suppliers == null){
			return null;
		}
		String goodsStr;
		String [] goodsIds;
		String goodsMoneyStr;
		String [] goodsMoneys;
		List<Map<String, Object>> tempList;
		Map<String, Object> tempResultMap;
 		List<Map<String, Object>> goodsMap=new ArrayList<>();
		//Map<String, Object> tempMap;
		Map<String, Object> fixDataMap;
		for(TSupplier s:suppliers){
			goodsStr=s.getLinkgoodsid();
			goodsMoneyStr=s.getLikegoodscostprice();
			if(goodsStr!=null && !"".equals(goodsStr)){
				goodsIds = goodsStr.split(",");
				goodsMoneys = goodsMoneyStr.split(",");
				
				if(goodsIds !=null && goodsIds.length > 0){
					for(int i=0;i<goodsIds.length;i++){
						vo.setId(Integer.parseInt(goodsIds[i]));//商品id
						tempList = goodsOrderMapper.findClearGoodsOrderList(vo);
						fixDataMap=new HashMap<>();
						fixDataMap.put("id", goodsIds[i]);
						fixDataMap.put("price", goodsMoneys[i]);
						fixDataMap.put("orderTypeName", "商品");
						fixDataMap.put("orderTypeId", "0");
						fixDataMap.put("supplierName", s.getSuppliername());
						fixDataMap.put("supplierId", s.getRowid());
						if(0 == s.getClearingtype()){
							fixDataMap.put("clearingTypeName", "预付结算");
						}else if(1 == s.getClearingtype()){
							fixDataMap.put("clearingTypeName", "周期结算");
						}
						fixDataMap.put("clearingType", s.getClearingtype());//结算模式（0预付 1周期结算）
						if(tempList !=null && tempList.size() > 0){
							 
							for(Map<String, Object> tempMap:tempList){
								tempResultMap=new HashMap<>();
								//tempResultMap.put("id", goodsIds[i]);
								//tempResultMap.put("price", goodsMoneys[i]);
								tempResultMap.put("name", tempMap.get("gName"));
								tempResultMap.put("orderId", tempMap.get("orderId"));
								tempResultMap.put("orderNum", tempMap.get("orderNum"));
								tempResultMap.put("payStatus", tempMap.get("payStatus"));
								tempResultMap.put("retreatDate", tempMap.get("retreatDate")==null?"":tempMap.get("retreatDate"));
								
								tempResultMap.putAll(fixDataMap);
								
								goodsMap.add(tempResultMap);
								
							}
							
							
						}
						
						
						
					}//循环供应商绑定商品id结束
				}
				
				
				
				
				
			}
			
			
			
		}
		
		
		return goodsMap;
	}
	
	/**
	* Title: convertPayStatus
	* Description: 将支付状态DI 返回中文名
	* @param payStatusId
	* @return
	* @author HuangJian
	* @date 2017年3月1日
	*/
	/*public String convertPayStatus(Object payStatusId){
		Integer status = Integer.parseInt(String.valueOf(payStatusId));
		String orderStatusName="";
		switch (status) {
		case 0:
			orderStatusName = "待支付";
			break;
		case 1:
			orderStatusName = "已取消";
			break;
		case 2:
			//orderStatusName = "已支付";
			orderStatusName = "已结算";
			break;
		case 3:
			orderStatusName = "退订中";
			break;
		case 4:
			orderStatusName = "已退订";
			break;
		case 5:
			orderStatusName = "已完成";
			break;
		case 7:
			orderStatusName="已结算";
			break;
		case 8:
			orderStatusName="取消结算";
			break;
		case 9:
			orderStatusName="禁用";
			break;
		default:
			orderStatusName="--";
			break;
		}
		
		return orderStatusName;
	}*/



	@Override
	public Map<String, Object> getClearOrderByOrderId(Map<String, Object> param) {
		Map<String, Object> resultMap=new HashMap<>();
		List<Map<String, Object>> tempList;
		Map<String, Object> tempMap=new HashMap<>();
		
		Integer supplierId = Integer.parseInt(String.valueOf(param.get("supplierId")));//供应商ID
		Integer orderType = Integer.parseInt(String.valueOf(param.get("orderType")));//订单类型
		String studioId = String.valueOf(param.get("studioId"));//商品ID，教练ID，场馆ID
		Integer orderId = Integer.parseInt(String.valueOf(param.get("orderId")));//订单ID		
		
		TSupplier supplier =  supplierMapper.selectByPrimaryKey(supplierId);
		resultMap.put("supplierName", supplier.getSuppliername());//供应商名称
		resultMap.put("supplierId", supplier.getRowid());//供应商ID
		resultMap.put("orderTypeId", orderType);//订单类型
		resultMap.put("clearingType", supplier.getClearingtype());
		if(0 == supplier.getClearingtype()){
			resultMap.put("clearingTypeName", "预付结算");
		}else if(1 == supplier.getClearingtype()){
			resultMap.put("clearingTypeName", "周期结算");
		}
		resultMap.put("id", studioId);//商品，教练，场馆ID
		ClearOrderSearchVo vo=new ClearOrderSearchVo();
		vo.setOrderId(orderId);
		//订单类型 0商城 1场馆 2私课 3课程 4活动
		switch (orderType) {
		case 0:
			String goodsStr=supplier.getLinkgoodsid();
			String [] goodsIds=goodsStr.split(",");
			String goodsMoneyStr=supplier.getLikegoodscostprice();
			String [] goodsMoneys=goodsMoneyStr.split(",");
			
			if(goodsIds !=null && goodsIds.length > 0){
				for(int i=0;i<goodsIds.length;i++){
					if(studioId.equals(goodsIds[i])){
						
						resultMap.put("price", goodsMoneys[i]);
						
						break;
						
					}
				}
				
			}
			tempList = goodsOrderMapper.findClearGoodsOrderList(vo);
			if(tempList != null && tempList.size()>0){
				tempMap=tempList.get(0);
				
				resultMap.put("name", tempMap.get("gName"));//商品名称
				
			}
			
			break;
		case 1:
			String studioStr = supplier.getLinkstudioid();
			String [] studioArr=studioStr.split(",");
			String studioMoneyStr=supplier.getLikestudiocostprice();
			String [] studioMoneyArr = studioMoneyStr.split(",");
			for(int i=0;i<studioArr.length;i++){
				if(studioId.equals(studioArr[i])){
					resultMap.put("price", studioMoneyArr[i]);//场馆价格
					
					break;
				}
			}
			
			
			
			tempList  =  studioConsumeOrderRecordMapper.findClearOrderList(vo);
			if(tempList !=null && tempList.size()>0){
				tempMap=tempList.get(0);
				
				resultMap.put("name", tempMap.get("studioName"));//商品名称
				//resultMap.put("orderId", tempMap.get("orderId"));//订单ID
				//resultMap.put("orderNum", tempMap.get("orderNum"));	//订单号
				//resultMap.put("payStatus", tempMap.get("payStatus"));//支付状态
				//结算日期
				//resultMap.put("retreatDate", tempMap.get("retreatDate")==null?"":tempMap.get("retreatDate"));
				
				
			}
			
			break;
		case 2:
			String coachStr=supplier.getLinkcoachid();
			String [] coachIds = coachStr.split(",");
			String coachMoneyStr=supplier.getLikecoachcostprice();
			String [] coachMoneys=coachMoneyStr.split(",");
			
			if(coachIds !=null && coachIds.length>0){
				for(int i=0;i<coachIds.length;i++){
					if(studioId.equals(coachIds[i])){
						
						resultMap.put("price", coachMoneys[i]);
						break;
					}
				}
				
				
				
				tempList =  orderMapper.findClearOrderList(vo);
				if(tempList !=null && tempList.size()>0){
					//for(Map<String, Object> tt:tempList){
						tempMap=tempList.get(0);
						resultMap.put("name", tempMap.get("nickName"));
						
				}
				
			}
			
			break;
		case 3:
			
			break;
		case 4:

			break;
		}
		
		
		 
		resultMap.put("orderId", tempMap.get("orderId"));//订单ID
		resultMap.put("orderNum", tempMap.get("orderNum"));//订单号
		resultMap.put("payStatus", tempMap.get("payStatus"));//支付状体
		//结算日期
		resultMap.put("retreatDate", tempMap.get("retreatDate")==null?"":tempMap.get("retreatDate"));
	//}
		
		
		
		
		
		return resultMap;
	}



	@Override
	public Map<String, Object> selectClearOrderStatis() {
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		//待结算金额
		double djsOrderMoneyNumber=0.0;
		Integer djsOrderNumber=0;
		//已结算金额
		double yjsOrderMoneyNumber=0.0;
		
		String todayString="";
		Integer todayInteger=0;
		Map<String, Object> map = new HashMap<>();
		
		TSupplierExample example = new TSupplierExample();
		Criteria createCriteria = example.createCriteria();
		List<TSupplier> suppliers =  supplierMapper.selectByExample(example);
		TSupplier supplier;
		if(suppliers != null && suppliers.size()>0){
			//------------------------------------场馆声明变量
			String allSupplierMoney = "";
			String studioStrIds;
			String studioStrMoneys;
			String [] studioIds;
			String [] studioMoneys;
			Map<String, Object> param;
			String ywcStatus="5";
			String yjsStatus="7";
			String orderCount="";
			Integer orderCountInteger=0;//所有状态订单数
			
			Integer yjsCountInteger=0;//已结算订单数量
			
			double suppliersMoneyDouble=0.0;//所有供应商总额
			//----------------------------------------------------- 
			
			//---------------------------------教练声明变量
			String coachStrId="";
			String [] coachIds;
			String coachStrMoney="";
			String [] coachMoneys;
			
			//--------------------------------------
			
			//--------------------------商品声明变量
			String goodsStrId="";
			String [] goodsIds;
			String goodsStrMoney="";
			String [] goodsMoneys;
			
			//----------------------------
			
			//统计场馆ID订单个数 *　场馆报价　
			for(int i=0;i<suppliers.size();i++){
				param=new HashMap<>();
				supplier = suppliers.get(i);
				
				//---------------------------------------------------------场馆开始
				studioStrIds = supplier.getLinkstudioid();//场馆id
				studioStrMoneys = supplier.getLikestudiocostprice();//场馆价格
				
				if(studioStrIds !=null && !"".equals(studioStrIds)){
					studioIds = studioStrIds.split(",");//场馆DI数组
					studioMoneys = studioStrMoneys.split(",");//场馆价格数组
					
					for(int j=0;j<studioIds.length;j++){//循环所有的场馆
						param.put("today", null);
						param.put("studioId", studioIds[j]);//场馆ID
						param.put("payStatus", ywcStatus);//已完成状态
						orderCount = studioConsumeOrderRecordMapper.selectClearOrderCountByPayStatus(param);
						
						suppliersMoneyDouble = Double.parseDouble(studioMoneys[j]);//格式化场馆对应金额
						
						if(null != orderCount && !"".equals(orderCount)){
							orderCountInteger = Integer.parseInt(orderCount);//待结算订单数
							djsOrderNumber += orderCountInteger;//待结算订单数
							
							//总金额 待结算
							djsOrderMoneyNumber += (orderCountInteger * suppliersMoneyDouble);
					
						}
						
						//今日新增订单数
						param.put("today", new Date());
						todayString = studioConsumeOrderRecordMapper.selectClearOrderCountByPayStatus(param);
						if(todayString != null && !"".equals(todayString)){
							todayInteger += Integer.parseInt(todayString);
							
						}
						
						param.put("today", null);//把当天日期清空
						param.put("payStatus", yjsStatus);//已结算状态
						orderCount = studioConsumeOrderRecordMapper.selectClearOrderCountByPayStatus(param);
						if(orderCount !=null && !"".equals(orderCount)){
							yjsCountInteger = Integer.parseInt(orderCount);//已结算订单数量赋值遍历
							
							//已结算金额
							yjsOrderMoneyNumber += (yjsCountInteger * suppliersMoneyDouble);
						}
						
						
					}
					
					
				}//场馆ID数组判断结束
				
				
				
				//---------------------------------------------------------场馆结束
				
				
				
				//---------------------------------------------------------教练开始
				coachStrId = supplier.getLinkcoachid();
				coachStrMoney = supplier.getLikecoachcostprice();
				
				if(coachStrId != null && !"".equals(coachStrId)){
					coachIds = coachStrId.split(",");
					coachMoneys = coachStrMoney.split(",");
					//循环教练IDS
					if(coachIds != null && coachIds.length > 0){
						param.clear();//清除参数数据
						for(int j=0;j<coachIds.length;j++){
							param.put("today", null);
							param.put("coachId", coachIds[j]);//教练ID
							param.put("payStatus", ywcStatus);//已完成状态
							suppliersMoneyDouble = Double.parseDouble(coachMoneys[j]);
							orderCount =orderMapper.selectClearOrderCountByPayStatus(param);
							/**
							 * 统计  未结算次数和金额
							 */
							if(orderCount !=null && !"".equals(orderCount)){
								orderCountInteger = Integer.parseInt(orderCount);
								
								//待结算总次数
								djsOrderNumber += orderCountInteger;
								
								
								//待结算总金额
								djsOrderMoneyNumber += (orderCountInteger * suppliersMoneyDouble);
							}
							
							/**
							 * 统计  今日新增订单数
							 */
							param.put("today", new Date());
							todayString = orderMapper.selectClearOrderCountByPayStatus(param);
							if(todayString != null && !"".equals(todayString)){
								//今日订单数量
								todayInteger += Integer.parseInt(todayString);
								
								
							}
							
							/**
							 * 统计 已结算订单数和价格
							 */
							param.put("today", null);//清空当天日期
							param.put("payStatus", yjsStatus);//已结算
							
							orderCount = orderMapper.selectClearOrderCountByPayStatus(param);
							if(orderCount != null && !"".equals(orderCount)){
								
								yjsCountInteger = Integer.parseInt(orderCount);
								
								//已结算金额
								yjsOrderMoneyNumber += (yjsCountInteger * suppliersMoneyDouble);
								
							}
							
							
							
						}//循环教练数组IDS
						
						
						
					}//判断数组IDS结束
					
					
					
				}
				
				//---------------------------------------------------------教练结束
				
				
				
				//---------------------------------------------------------商品开始
				goodsStrId = supplier.getLinkgoodsid();
				goodsStrMoney = supplier.getLikegoodscostprice();
				if(goodsStrId !=null && !"".equals(goodsStrId)){
					goodsIds = goodsStrId.split(",");
					goodsMoneys = goodsStrMoney.split(",");
					if(goodsIds != null && goodsIds.length > 0){
						param.clear();//清空参数map
						//循环商品IDS
						for(int j=0;j<goodsIds.length;j++){
							
							//商品对应报价
							suppliersMoneyDouble = Double.parseDouble(goodsMoneys[j]);
							/**
							 * 统计 待结算订单数
							 */
							param.put("today", null);
							param.put("payStatus", ywcStatus);
							param.put("goodsId", goodsIds[j]);
							orderCount = goodsOrderMapper.selectClearOrderCountByPayStatus(param);
							if(orderCount != null && !"".equals(orderCount)){
								orderCountInteger = Integer.parseInt(orderCount);
								//需审批订单数
								djsOrderNumber += orderCountInteger;
								//待结算金额
								djsOrderMoneyNumber += (orderCountInteger * suppliersMoneyDouble);
							}
							
							
							/**
							 * 今日新增订单
							 */
							param.put("today", new Date());
							todayString = goodsOrderMapper.selectClearOrderCountByPayStatus(param);
							if(null != todayString && !"".equals(todayString)){
								
								todayInteger += Integer.parseInt(todayString);
								
							}
							
							/**
							 * 统计 已结算订单金额
							 */
							param.put("today", null);
							param.put("payStatus", yjsStatus);
							
							orderCount = goodsOrderMapper.selectClearOrderCountByPayStatus(param);
							
							if(orderCount != null && !"".equals(orderCount)){
								yjsCountInteger = Integer.parseInt(orderCount);
								
								//已结算金额  
								yjsOrderMoneyNumber += (yjsCountInteger * suppliersMoneyDouble);
							}
							
							
							
						}//循环商品ID
						
						
						
					}//商品IDS数组判断结束
					
				}//字符串商品IDS判断
				
				//---------------------------------------------------------商品结束
				
			}//----------------------循环供应商结束
			
			
			
		}
		
		
		//计算总金额  已结算+待结算
		map.put("sumOrderMoneyNumber", df.format( yjsOrderMoneyNumber+djsOrderMoneyNumber ));
		//已结算金额   状态--》已结算
		map.put("yjsOrderMoneyNumber", df.format(yjsOrderMoneyNumber));
		//待结算金额  状态--》已完成
		map.put("djsOrderMoneyNumber", df.format(djsOrderMoneyNumber));
		//需审批订单数  状态--》已完成
		map.put("djsOrderNumber", djsOrderNumber);
		//今日新增订单数 状态--》当天已完成
		map.put("todayInteger", todayInteger);
		return map;
	}



	@Override
	public Map<String, Object> updateUpAccount(Map<String, Object> map) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> mess=new HashMap<>();
		Map<String, Object> param=new HashMap<>();
		DecimalFormat    df   = new DecimalFormat("######0.00");
		String orderTypeName="--";
		try {
			//供应商id
			Integer supplierId=Integer.parseInt(String.valueOf( map.get("supplierId")));
			//订单ID
			Integer orderId = Integer.parseInt(String.valueOf(map.get("orderId")));
			//订单类型
			Integer orderTypeId = Integer.parseInt(String.valueOf(map.get("orderTypeId")));
			
			Integer status = Integer.parseInt(String.valueOf(map.get("status")));
			param.put("oId", orderId);//订单ID
			param.put("status", status);//订单状态
			param.put("orderTypeId", orderTypeId);//订单类型
			
			Object orderKeyId="";//订单中的商品id
			String strIds="";
			String [] ids;
			String strMoney="";
			String [] moneys;
			double eoffFormat=0.0;
			String endOfferMoney=null;//最终报价价格
			String endOfferId=null;//最终报价id
			TSupplier supplier = supplierMapper.selectByPrimaryKey(supplierId);
			if(supplier !=null ){
				//结算模式（0预付 1周期结算）
				Integer clearType =  supplier.getClearingtype();
				
				//订单结果
				Map<String, Object> orderResult =  orderMapper.selectOrderById(param);
				
				if(orderResult != null && !"".equals(orderResult)){
					//订单类型  0商城 1场馆 2私课 3课程 4活动 5 个人卡
					//根据不同的订单，获取商品ID
					
					switch(orderTypeId){
					case 0:
						orderKeyId=orderResult.get("gId");
						strIds = supplier.getLinkgoodsid();
						strMoney = supplier.getLikegoodscostprice();
						orderTypeName="商城";
						break;
					case 1:
						orderKeyId=orderResult.get("studioId");
						strIds = supplier.getLinkstudioid();
						strMoney = supplier.getLikestudiocostprice();
						orderTypeName="场馆";
						
						break;
					case 2:
						orderKeyId=orderResult.get("coachId");
						strIds = supplier.getLinkcoachid();
						strMoney = supplier.getLikecoachcostprice();
						
						orderTypeName="私教";
						break;
					case 3:
						orderKeyId=orderResult.get("");
						break;
					case 4:
						orderKeyId=orderResult.get("");
						break;
					case 5:
						orderKeyId=orderResult.get("");
						break;
					
					}
					
					if(strIds != null && !"".equals(strIds)){
						ids = strIds.split(",");
						moneys = strMoney.split(",");
						
						if(ids != null && ids.length > 0){
							
							for(int i=0;i<ids.length;i++){
								//如果确定结算中的商品id和供应商对应上了  就修改价格并修改订单状态
								if(ids[i].trim().equals(String.valueOf(orderKeyId).trim())){
									endOfferId = ids[i];
									endOfferMoney = moneys[i];
									break;
								}
							}
							
							/**
							 * 找到了  商品ID，商品价格
							 * 
							 * clearType 结算模式 （0预付 1周期结算）
							 * 预付:superSaveMoney 减金额
							 * 
							 * 周期:balance 加金额
							 */
							boolean isAccount=false;
							TSupplier record = new TSupplier();
							record.setRowid(supplier.getRowid());
							if(endOfferId !=null && endOfferMoney !=null){
								eoffFormat = Double.parseDouble(endOfferMoney);
								//预付
								if(0 == clearType){
									
									//判断预存日期是否过期  (过期会自动把预付金额改成0元)
									/*Date dateStart =  sdf.parse(supplier.getSavemoneyexpiredate());
									Date dateToday=sdf.parse(sdf.format(new Date()));
									System.out.println(dateStart +"---------"+dateToday);
									if(dateToday.getTime() > dateStart.getTime()){
										System.out.println("已过期");
									}else{
										System.out.println("有效期");
									}*/
							
									
										double superSaveMoney =  supplier.getSupersavemoney();
										if(superSaveMoney > 0 && superSaveMoney >= eoffFormat){
											
											double fix = superSaveMoney - eoffFormat;
											if(fix >= 0){
												isAccount=true;
												record.setSupersavemoney(fix);
											}else{
												
											}
										}else{
											mess.put("message", "预存金额不足,未能结算成功");
										}
									/*}else{
										mess.put("message", " 预存金额已过期 有效期至:"+date);
									}*/
									
									  
								//周期	
								}else if(1 == clearType){
									isAccount=true;
									double blanceOld = supplier.getBalance();
									double balance = blanceOld + eoffFormat;
									
									record.setBalance(balance);
									
								}//判断结算模式结束
								
								//如果可以结算
								try {
									if(isAccount){
										int result = supplierMapper.updateByPrimaryKeySelective(record);
										
										mess.put("result", String.valueOf(result));
										if(result > 0){
											
											
											
											mess.put("message", "结算成功");
											
											//修改订单状态
											int orderUpateResult = orderMapper.updateOrderStatusByClearOrder(param);
											//修改订单 日期(改为结算日期)
											TOrderDiscountExample example = new TOrderDiscountExample();
											example.createCriteria().andOrderidEqualTo(orderId).andStatusEqualTo(orderTypeId);
											
											List<TOrderDiscount> selectByExample = orderDiscountMapper.selectByExample(example);
											if(selectByExample != null && selectByExample.size() > 0){
												TOrderDiscount od=selectByExample.get(0);
												
												od.setRetreatdate(sdf.format(new Date()));//结算日期
												
												orderDiscountMapper.updateByPrimaryKeySelective(od);
											} 
											
											
											mess.put("orderResult", String.valueOf(orderUpateResult));
											if(orderUpateResult > 0){
												mess.put("orderMessage", "修改订单成功");
											}else{
												mess.put("orderMessage", "修改订单失败");
											}
											
										}else{
											mess.put("message", "结算失败");
										}
									}else{
										mess.put("result", "0");
										//mess.put("message", "没有结算模式未能结算");
									}
								} catch (Exception e) {
									mess.put("message", "异常");
									mess.put("result", "0");
								}
								
								
								
							}
							
							
						}
						
						
						
						
					}
					
	
				}
				
				
				
				
				
			}
			mess.put("supplierName", supplier.getSuppliername());//供应商名称
			mess.put("orderTypeName", orderTypeName);//订单类型名称
			mess.put("eoffFormat", eoffFormat);//结算金额
			
		} catch (NumberFormatException e) {
			
		}
		
		
		return mess;
	}

	
	
}

