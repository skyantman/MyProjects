package com.yundongjia.app.wechatPay.domain;/** * @author  作者 Wangli: * @date 创建时间：2016年7月26日 上午9:35:46 * @version 1.0 * @parameter  * @since  * @return  */
public class WeixinNotifiy {
   private int wxId;
   private int status;
   private String createDate;
   private String outTradeNo;
	public int getWxId() {
		return wxId;
	}
	public void setWxId(int wxId) {
		this.wxId = wxId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
}
