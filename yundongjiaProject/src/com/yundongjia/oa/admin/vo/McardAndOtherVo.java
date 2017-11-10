package com.yundongjia.oa.admin.vo;

import java.util.Date;

public class McardAndOtherVo {
	private Integer mcardSpecTypeId;
	private Integer[]cardMemberMemberId;
	private Integer mcardSpecId;
	private Integer mcardSellerId;
	private String mcardCardnum;
	private String mcardComm;
	private Integer rechargePayType;
	private Integer rechargeRealMoney;
	private Integer mcardCardBalance;
	private Integer mcardSpecValidityDays;
	private String  mcardEnddate;
	private String  mcardStartdate;
	private Integer mcardAutostart;
	private Integer mcardDate;
	private Integer cardType;
	
	
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public Integer getMcardDate() {
		return mcardDate;
	}
	public void setMcardDate(Integer mcardDate) {
		this.mcardDate = mcardDate;
	}
	public Integer getMcardSpecTypeId() {
		return mcardSpecTypeId;
	}
	public void setMcardSpecTypeId(Integer mcardSpecTypeId) {
		this.mcardSpecTypeId = mcardSpecTypeId;
	}
	public Integer[] getCardMemberMemberId() {
		return cardMemberMemberId;
	}
	public void setCardMemberMemberId(Integer[] cardMemberMemberId) {
		this.cardMemberMemberId = cardMemberMemberId;
	}
	public Integer getMcardSpecId() {
		return mcardSpecId;
	}
	public void setMcardSpecId(Integer mcardSpecId) {
		this.mcardSpecId = mcardSpecId;
	}
	public Integer getMcardSellerId() {
		return mcardSellerId;
	}
	public void setMcardSellerId(Integer mcardSellerId) {
		this.mcardSellerId = mcardSellerId;
	}
	public String getMcardCardnum() {
		return mcardCardnum;
	}
	public void setMcardCardnum(String mcardCardnum) {
		this.mcardCardnum = mcardCardnum;
	}
	public String getMcardComm() {
		return mcardComm;
	}
	public void setMcardComm(String mcardComm) {
		this.mcardComm = mcardComm;
	}
	public Integer getRechargePayType() {
		return rechargePayType;
	}
	public void setRechargePayType(Integer rechargePayType) {
		this.rechargePayType = rechargePayType;
	}
	public Integer getRechargeRealMoney() {
		return rechargeRealMoney;
	}
	public void setRechargeRealMoney(Integer rechargeRealMoney) {
		this.rechargeRealMoney = rechargeRealMoney;
	}
	public Integer getMcardCardBalance() {
		return mcardCardBalance;
	}
	public void setMcardCardBalance(Integer mcardCardBalance) {
		this.mcardCardBalance = mcardCardBalance;
	}
	public Integer getMcardSpecValidityDays() {
		return mcardSpecValidityDays;
	}
	public void setMcardSpecValidityDays(Integer mcardSpecValidityDays) {
		this.mcardSpecValidityDays = mcardSpecValidityDays;
	}
	
	
	public String getMcardEnddate() {
		return mcardEnddate;
	}
	public void setMcardEnddate(String mcardEnddate) {
		this.mcardEnddate = mcardEnddate;
	}
	public String getMcardStartdate() {
		return mcardStartdate;
	}
	public void setMcardStartdate(String mcardStartdate) {
		this.mcardStartdate = mcardStartdate;
	}
	public Integer getMcardAutostart() {
		return mcardAutostart;
	}
	public void setMcardAutostart(Integer mcardAutostart) {
		this.mcardAutostart = mcardAutostart;
	}
	
}
