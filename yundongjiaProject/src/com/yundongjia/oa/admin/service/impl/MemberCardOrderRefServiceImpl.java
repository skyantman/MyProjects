/*
* @author HuangJian
* @date 2017年1月11日
*/
package com.yundongjia.oa.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.service.MemberCardOrderRefService;
@Service
public class MemberCardOrderRefServiceImpl implements MemberCardOrderRefService {

	@Autowired
	private TMemberCardOrderRefMapper memberCardOrderRefMapper;

	@Override
	public int saveMemberCardOrderRef(TMemberCardOrderRef cardOrder) {
	
		int result = memberCardOrderRefMapper.insertSelective(cardOrder);
		
		return cardOrder.getOrderid();
	}

	@Override
	public Map<String, Object> getCardOrderById(Integer cardId) {
		
		return memberCardOrderRefMapper.getCardOrderById(cardId);
	}

	@Override
	public List<Map<String, Object>> getCardOrderByEnterId(Integer enterId) {
		
		return memberCardOrderRefMapper.getCardOrderByEnterId(enterId);
	}

}

