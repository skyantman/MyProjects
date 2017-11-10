package com.yundongjia.app.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.MemberCardInfoService;
import com.yundongjia.oa.admin.mapper.TCardTypeMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardEnterpriseRefMapper;
import com.yundongjia.oa.admin.mapper.TMemberCardOrderRefMapper;
import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCardTypeExample;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRef;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRefExample;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月6日 下午2:39:58 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class MemberCardInfoServiceImpl implements MemberCardInfoService {

	@Autowired
	private TMemberCardOrderRefMapper memberCardOrderRefMapper;
	@Autowired
	private TMemberCardEnterpriseRefMapper memberCardEnterpriseRefMapper;
	@Autowired
	private TCardTypeMapper cardTypeMapper;
	
	@Override
	public List<TMemberCardOrderRef> selectSelfMemberCardInfo(TMemberCardOrderRefExample example) {
		List<TMemberCardOrderRef> list = memberCardOrderRefMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Map<String,Object>> selectMemberCardInfoCardType(Map<String,Object> map) {
		List<Map<String,Object>> list = memberCardOrderRefMapper.selectmembercardInfocardType(map);
		return list;
	}

	@Override
	public List<TMemberCardEnterpriseRef> selectMemberCardEnterpriseRefInfo(
			TMemberCardEnterpriseRefExample enterpriseRefExample) {
		List<TMemberCardEnterpriseRef> list = memberCardEnterpriseRefMapper.selectByExample(enterpriseRefExample);
		return list;
	}

	@Override
	public TMemberCardOrderRef selectSelfMemberCardInfo(Integer id) {
		TMemberCardOrderRef orderRef = memberCardOrderRefMapper.selectByPrimaryKey(id);
		if(orderRef == null ||"2".equals(orderRef.getPaystatus()) && orderRef.getStatus() != 0){
			return null;
		}else{
			return orderRef;
		}
	}

	@Override
	public TCardType selectCardTypeInfo(Integer id) {
		TCardType cardType = cardTypeMapper.selectByPrimaryKey(id);
		return cardType;
	}

	@Override
	public List<TCardType> selectCardTypeInfo(TCardTypeExample example) {
		List<TCardType> list = cardTypeMapper.selectByExample(example);
		return list;
	}

	@Override
	public Integer insertMemberCardInfo(TMemberCardOrderRef orderRef) {
		int i = memberCardOrderRefMapper.insertSelective(orderRef);
		return i;
	}

}
