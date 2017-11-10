package com.yundongjia.app.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.MemberInfoService;
import com.yundongjia.oa.admin.mapper.TConsigneeAddressMapper;
import com.yundongjia.oa.admin.mapper.TJpushMapper;
import com.yundongjia.oa.admin.mapper.TMemberCouponRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TMemberSuggestionMapper;
import com.yundongjia.oa.admin.po.TConsigneeAddress;
import com.yundongjia.oa.admin.po.TConsigneeAddressExample;
import com.yundongjia.oa.admin.po.TJpush;
import com.yundongjia.oa.admin.po.TJpushExample;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberCouponRef;
import com.yundongjia.oa.admin.po.TMemberCouponRefExample;
import com.yundongjia.oa.admin.po.TMemberExample;
import com.yundongjia.oa.admin.po.TMemberSuggestion;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:49:31 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class MemberInfoServiceImpl implements MemberInfoService {
	@Autowired
	 private TMemberMapper memberMapper;
	@Autowired
	 private TConsigneeAddressMapper AddressMapper;
	@Autowired
	private TMemberSuggestionMapper suggestionMapper;
	@Autowired
	private TJpushMapper jpushMapper;
	@Autowired
	private TMemberCouponRefMapper memberCouponRefMapper;
	
	@Override
	public List<TMember> selectMemberInfo(TMemberExample memberExample) {
		List<TMember> list = memberMapper.selectByExample(memberExample);
		return list;
	}

	@Override
	public Integer updateMemberInfo(TMember member) {
		int result = memberMapper.updateByPrimaryKeySelective(member);
		return result;
	}

	@Override
	public Integer insertMemberInfo(TMember member) {
		int result = memberMapper.insertSelective(member);
		return result;
	}

	@Override
	public List<TConsigneeAddress> selectAddressList(TConsigneeAddressExample example) {
		List<TConsigneeAddress> list = AddressMapper.selectByExample(example);
		return list;
	}

	@Override
	public Integer insertMyAddress(TConsigneeAddress address) {
		int result = AddressMapper.insertSelective(address);
		return result;
	}

	@Override
	public Integer deleteMyAddress(Integer rowId) {
		int result = AddressMapper.deleteByPrimaryKey(rowId);
		return result;
	}

	@Override
	public Integer inserMemberSuggestion(TMemberSuggestion suggestion) {
		int result = suggestionMapper.insertSelective(suggestion);
		return result;
	}

	@Override
	public List<TJpush> selectPush(TJpushExample example) {
		List<TJpush> list = jpushMapper.selectByExample(example);
		return list;
	}

	@Override
	public TMember selectMemberInfo(Integer memberId) {
		TMember member = memberMapper.selectByPrimaryKey(memberId);
		return member;
	}

	@Override
	public List<TMemberCouponRef> selectMemberCouponInfo(TMemberCouponRefExample example) {
		List<TMemberCouponRef> list = memberCouponRefMapper.selectByExample(example);
		return list;
	}

	@Override
	public Integer updateMyAddress(TConsigneeAddress address) {
		int reslut = this.AddressMapper.updateByPrimaryKeySelective(address);
		return reslut;
	}
	
	@Override
	public Integer updateMyAddress(TConsigneeAddress address,TConsigneeAddressExample example ) {
		int reslut = this.AddressMapper.updateByExampleSelective(address, example);
		return reslut;
	}

}
