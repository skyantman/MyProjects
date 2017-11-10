package com.yundongjia.other.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.mapper.TSupplierMapper;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample.Criteria;
import com.yundongjia.oa.admin.po.TStudioExample;
import com.yundongjia.oa.admin.po.TSupplier;
import com.yundongjia.oa.admin.po.TSupplierExample;
import com.yundongjia.other.service.EnterpriseTerminalService;

@Service
public class EnterpriseTerminalServiceImpl implements EnterpriseTerminalService{
	@Autowired
	private TStudioMapper tStudioMapper;
	@Autowired
	private TStudioConsumeOrderRecordMapper tStudioConsumeOrderRecordMapper;
	@Autowired
	private TMemberMapper tMemberMapper;
	@Autowired
	private TSupplierMapper tSupplierMapper;
	
	@Override
	public List<TStudio> findStudioList() {
		TStudioExample tStudioExample = new TStudioExample();
		tStudioExample.createCriteria().andStatusEqualTo(0);
		List<TStudio> studios = tStudioMapper.selectByExample(tStudioExample);
		List<TSupplier> suppliers = tSupplierMapper.selectByExample(new TSupplierExample());
		List<TStudio> result  = new ArrayList<TStudio>();
		for (TStudio ts : studios) {
			for (TSupplier tSupplier : suppliers) {
				String[] sId = tSupplier.getLinkstudioid().split(",");
				for (int i = 0; i < sId.length; i++) {
					if(ts.getStudioid().equals(Integer.parseInt(sId[i]))){
						result.add(ts);
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public String selectStudioPhone(Integer studioId) {
		List<TSupplier> suppliers = tSupplierMapper.selectByExample(new TSupplierExample());
		String phone = "";
		for (TSupplier ts : suppliers) {
			String[] sId = ts.getLinkstudioid().split(",");
			for (int i = 0; i < sId.length; i++) {
				if(studioId.equals(Integer.parseInt(sId[i]))){
					phone = ts.getMobilephonenum();
				}
			}
		}
		return tStudioMapper.selectByPrimaryKey(studioId).getSupertel();
	}
	
	@Override
	public List<Map<String, Object>> findStudioOrder(Integer studioId, String startDate, String endDate,
			String mobile) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample(); 
		tStudioConsumeOrderRecordExample.createCriteria().andStudioidEqualTo(studioId);
		List<TStudioConsumeOrderRecord> list = tStudioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
		List<Map<String, Object>> result = new ArrayList<Map<String , Object>>();
		for (TStudioConsumeOrderRecord ts : list) {
			String nickName = "";
			TMember member = tMemberMapper.selectByPrimaryKey(ts.getMemberid());
			if(member != null){
				nickName = member.getNickname();
			}else{
				continue;
			}
			String mobilephonenum = ts.getMobilephonenum().substring(ts.getMobilephonenum().length() - 4 , ts.getMobilephonenum().length());
			Map<String , Object> map = new HashMap<String , Object>();
			if(startDate != null && !"".equals(startDate) && startDate != null && !"".equals(startDate) && mobile != null && !"".equals(mobile)){
				Long create = 0l;
				Long start = 0l;
				Long end = 0l;
				try {
					create = simpleDateFormat.parse(ts.getCreatedate()).getTime();
					start = date.parse(startDate).getTime();
					end = date.parse(endDate).getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(start < create && create < end && mobile.equals(mobilephonenum)){
					map.put("nickName", nickName);
					map.put("mobilePhone", mobilephonenum);
					map.put("createDate", ts.getCreatedate());
					result.add(map);
				}
			}else if(startDate != null && !"".equals(startDate) && startDate != null && !"".equals(startDate) && (mobile == null || "".equals(mobile))){
				Long create = 0l;
				Long start = 0l;
				Long end = 0l;
				try {
					create = simpleDateFormat.parse(ts.getCreatedate()).getTime();
					start = date.parse(startDate).getTime();
					end = date.parse(endDate).getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(start < create && create < end){
					map.put("nickName", nickName);
					map.put("mobilePhone", mobilephonenum);
					map.put("createDate", ts.getCreatedate());
					result.add(map);
				}
			}else if((mobile != null && !"".equals(mobile)) && (startDate == null || "".equals(startDate)) && (startDate == null || "".equals(startDate))){
				if(mobile.equals(mobilephonenum)){
					map.put("nickName", nickName);
					map.put("mobilePhone", mobilephonenum);
					map.put("createDate", ts.getCreatedate());
					result.add(map);
				}
			}else if(startDate == null || "".equals(startDate) || startDate == null || "".equals(startDate) || mobile == null || "".equals(mobile)){
				map.put("nickName", nickName);
				map.put("mobilePhone", mobilephonenum.substring(mobilephonenum.length() - 4 , mobilephonenum.length()));
				map.put("createDate", ts.getCreatedate());
				result.add(map);
			}
		}
		return result;
	}

}
