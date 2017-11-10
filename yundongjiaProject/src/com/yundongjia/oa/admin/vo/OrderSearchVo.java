/**
* @author HuangJian
* @date 2017年2月8日
*/
package com.yundongjia.oa.admin.vo;
/**
 * 
* Title: com.yundongjia.oa.admin.vo 
* Description: 订单查询条件类
* @author HuangJian
* @date 2017年2月8日
 */
public class OrderSearchVo {

	private String sourceContext;//订单内容
	
	private Integer orderType;//订单类型
	
	private Integer orderStatus;//订单状态
	
	private String startTime;//创建开始日期
	
	private String endTime;//创建结束日期
	
	private String mobilePhoneNum;//手机号
	
	private Integer memberId;//会员ID

	private Integer orderMenuType; //0：订单列表         1：退订列表
	
	
	
	public OrderSearchVo() {
		super();
	}

	public OrderSearchVo(String sourceContext, Integer orderType, Integer orderStatus, String startTime, String endTime,
			String mobilePhoneNum, Integer memberId) {
		super();
		this.sourceContext = sourceContext;
		this.orderType = orderType;
		this.orderStatus = orderStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.mobilePhoneNum = mobilePhoneNum;
		this.memberId = memberId;
	}
	
	

	public OrderSearchVo(String sourceContext, Integer orderType, Integer orderStatus, String startTime, String endTime,
			String mobilePhoneNum, Integer memberId, Integer orderMenuType) {
		super();
		this.sourceContext = sourceContext;
		this.orderType = orderType;
		this.orderStatus = orderStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.mobilePhoneNum = mobilePhoneNum;
		this.memberId = memberId;
		this.orderMenuType = orderMenuType;
	}

	public String getSourceContext() {
		return sourceContext;
	}

	public void setSourceContext(String sourceContext) {
		this.sourceContext = sourceContext==null?null:sourceContext.trim();
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime==null?null:startTime.trim();
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime==null?null:endTime.trim();
	}

	public String getMobilePhoneNum() {
		return mobilePhoneNum;
	}

	public void setMobilePhoneNum(String mobilePhoneNum) {
		this.mobilePhoneNum = mobilePhoneNum == null?null:mobilePhoneNum.trim();
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	
	public Integer getOrderMenuType() {
		return orderMenuType;
	}

	public void setOrderMenuType(Integer orderMenuType) {
		this.orderMenuType = orderMenuType;
	}

	
	
}

