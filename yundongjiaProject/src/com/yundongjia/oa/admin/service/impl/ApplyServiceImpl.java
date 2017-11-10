/**
* @author HuangJian
* @date 2017年2月28日
*/
package com.yundongjia.oa.admin.service.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TApplyAccountMapper;
import com.yundongjia.oa.admin.mapper.TApplyMapper;
import com.yundongjia.oa.admin.mapper.TSupplierMapper;
import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TSupplier;
import com.yundongjia.oa.admin.service.ApplyService;

@Service
public class ApplyServiceImpl implements ApplyService{

	@Autowired
	private TApplyMapper applyMapper;
	@Autowired
	private TApplyAccountMapper applyAccountMapper;
	@Autowired
	private TSupplierMapper supplierMapper;
	public List<Map<String, Object>> list; 
	
	@Override
	public List<Map<String, Object>> findApplyList(Map<String, Object> param) {
		
		return dataFormat(applyMapper.findApplyList(param));
	}

	public List<Map<String, Object>> dataFormat(List<Map<String, Object>> list){
		
		if(list != null && list.size()>0){
			String appStatisName="";
			String payStatusName="";
			for(Map<String, Object> temp:list){
				
				String appStatusId=String.valueOf(temp.get("applyStatus"));
				
				switch (appStatusId) {
				case "0":
					appStatisName="处理中";
					break;
				case "1":
					appStatisName="已提现";
					break;
				case "2":
					appStatisName="已取消";
					break;
				default:
					appStatisName="--";
					break;
				}
				
				temp.put("applyStatusName", appStatisName);
				
				
				String messId= String.valueOf(temp.get("messageStatus"));
				if("0".equals(messId)){
					temp.put("messageStatusName", "未发送");
				}else{
					temp.put("messageStatusName", "已发送");
				}
				
				
				String statusId=String.valueOf(temp.get("status"));
				if("0".equals(statusId)){
					temp.put("statusName", "生效");
				}else{
					temp.put("statusName", "禁用");
				}
				
				
				String payStatus = String.valueOf(temp.get("payStatus"));
				switch (payStatus) {
				case "00":
					payStatusName="支付宝";
					break;
				case "01":
					payStatusName="微信";
					break;
				case "02":
					payStatusName="银行卡";
					break;

				default:
					payStatusName="无";
					break;
				}
				
				temp.put("payStatusName", payStatusName);
				
			}
			
		}
		
		return list;
	}

	@Override
	public Map<String, Object> selectApplyStatis() {
		Map<String, Object> map =new HashMap<>();
		
		
		
		String ytxMoney = applyMapper.selectApplySumMoneyByApplyStatus(1);//已提现金额
		
		//待提现金额
		String stayMoney=applyMapper.selectStayApplyMoney();//供应商balance剩余提现余额
		
		
		String spNum=applyMapper.selectApplyCountNum(0);//需审批订单数，状态为0
		
		String todayNum = applyMapper.selectTodayCountNum();//今日订单数
		double ytxD = Double.parseDouble(ytxMoney==null?"0":ytxMoney);
		double stayD=Double.parseDouble(stayMoney==null?"0":stayMoney);
		//提现总金额
		double sum=ytxD+stayD;
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		map.put("totalMoney", df.format(sum));
		map.put("ytxMoney", ytxMoney==null?0:ytxMoney);
		map.put("stayMoney", stayMoney==null?0:stayMoney);
		map.put("spNum", spNum==null?0:spNum);
		map.put("todayNum", todayNum==null?0:todayNum);
		return map;
	}

	@Override
	public Map<String, Object> updateApplyById(TApply apply) {
		Map<String, Object> resultMap=new HashMap<>();
		//提现成功后，把该供应商可提现余额减少
		DecimalFormat df=new DecimalFormat("######0.00");
		/*TApplyAccount account = new TApplyAccount();
		account.setRowdid(apply.getAppaccountid());*/
		TApply apply2 = applyMapper.selectByPrimaryKey(apply.getRowid());
		double amount =0.0;		
		//得到提现的供应商
		try {
			
			//TApply apply2 = applyMapper.selectByPrimaryKey(apply.getRowid());//得到提现
			if( apply2 != null){
				Map<String, Object> supplierMap = supplierMapper.getSupplierByApplyAccountId(apply2.getAppaccountid());//得到供应商
				
				
				amount =  apply2.getAmount();//提现金额
				double balance = Double.parseDouble(String.valueOf(supplierMap.get("balance")));//剩余可提现金额
				double surlMoney = (balance - amount);
				if (balance >= amount && surlMoney >=0 ){
					
					Integer appUpdate = applyMapper.updateByPrimaryKeySelective(apply);//更改提现状态
					if(appUpdate > 0){
						TSupplier supplier = new TSupplier();
						supplier.setRowid(Integer.parseInt(String.valueOf(supplierMap.get("rowId"))));
						String mString = df.format(surlMoney);
						supplier.setBalance(Double.parseDouble(mString));//减去提现余额
						
						Integer supliUpdate = supplierMapper.updateByPrimaryKeySelective(supplier);
						resultMap.put("result", supliUpdate);
						if(supliUpdate > 0){
							resultMap.put("message", "提现成功");
						}else{
							resultMap.put("message", "提现失败");
						}
					}
					
					
				}else{
					
					resultMap.put("result", 0);
					resultMap.put("message", "余额不足-未能提现成功");
					
				}
				
			}
		} catch (Exception e) {
			resultMap.put("message", "提现异常");
			resultMap.put("result", 0);
		}
		
		resultMap.put("applyMoney", amount);
		
		return resultMap;
	}

	@Override
	public Integer updateApplyStatusById(TApply apply) {
		
		return applyMapper.updateByPrimaryKeySelective(apply);
	}
	
}

