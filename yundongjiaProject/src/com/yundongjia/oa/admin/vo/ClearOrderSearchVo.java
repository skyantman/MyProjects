/**
* @author HuangJian
* @date 2017年2月28日
*/
package com.yundongjia.oa.admin.vo;

/**
* Title: com.yundongjia.oa.admin.vo 
* Description: 结算条件查询 实体类
* @author HuangJian
* @date 2017年2月28日
*/
public class ClearOrderSearchVo {

	private String startTime;//结算开始日期
	
	private String endTime;//结算结束日期
	
	private String supplierName;//供应商名称
	
	private String contextName;//商品名称  场馆，教练，商品
	
	private Integer orderStatus;//订单状态 已结算，未结算，已取消
	
	
	private Integer orderId;//订单ID
	
	private Integer id;//教练，商品，场馆id
	
	public ClearOrderSearchVo() {
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getContextName() {
		return contextName;
	}

	public void setContextName(String contextName) {
		this.contextName = contextName;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	 

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}

