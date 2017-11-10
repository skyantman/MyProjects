/**
* @author HuangJian
* @date 2017年2月14日
*/
package com.yundongjia.app.user.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.MemberCouponRefService;
import com.yundongjia.oa.admin.mapper.TMemberCouponRefMapper;

@Service
public class MemberCouponRefServiceImpl implements MemberCouponRefService {

	@Autowired
	private TMemberCouponRefMapper memberCouponRefMapper;

	public List<Map<String, Object>> list;

	@Override
	public List<Map<String, Object>> findCouponListByMember(Map<String, Object> param) {
		list = memberCouponRefMapper.findCouponListByMember(param);
		if (list != null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			for (Map<String, Object> temp : list) {
				
				try {
					temp.put("expirtionDate", sdf.format(sdf.parse(temp.get("expirtionDate").toString())));
				} catch (ParseException e) {
					 
				}
				
				String[] couType = String.valueOf(temp.get("couponType")).split(",");

				if (couType != null && couType.length > 0) {
					if (0 == Integer.parseInt(String.valueOf(couType[0]))) {
						temp.put("couponTypeName", "通用");
					} else {
						String couTypesStr = "限";

						for (int i = 0; i < couType.length - 1; i++) {
							couTypesStr += getCouponTypeName(couType[i])+ ",";
						}
						couTypesStr += getCouponTypeName(couType[couType.length - 1] ) + "使用";

						temp.put("couponTypeName", couTypesStr);
					}
				}

				/*Integer statusId= Integer.parseInt(String.valueOf(temp.get("status")));
				switch(statusId){
				case 0:
					statusName="未使用";
					break;
				case 1:
					statusName="禁用";
					break;
				case 2:
					statusName="已使用";
					break;
				case 3:
					statusName="已过期";
					break;
				}		
				temp.put("statusName", statusName);*/
				
				/*String couponMethod = String.valueOf(temp.get("couponMethod"));
				if("0".equals(couponMethod)){
					temp.put("couponMethodName", "代金券");
				}else{
					temp.put("couponMethodName", "折扣券");
				}*/
				
				
				
			}
		}
		return list;
	}

	public String getCouponTypeName(String coutType) {
		String tempStr="";
		switch (coutType) {
		case "1":
			tempStr="场馆";
			break;
		case "2":
			tempStr="教练";
			break;
		case "3":
			tempStr="团课";
			break;
		case "4":
			tempStr="充值卡";
			break;
		case "5":
			tempStr="活动";
			break;
		case "6":
			tempStr="私课";
			break;
			
		}

		return tempStr;
	}
}
