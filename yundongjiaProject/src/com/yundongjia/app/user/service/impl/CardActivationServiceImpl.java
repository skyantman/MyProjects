package com.yundongjia.app.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.CardActivationService;
import com.yundongjia.oa.admin.mapper.TActivationMapper;
import com.yundongjia.oa.admin.po.TActivation;
import com.yundongjia.oa.admin.po.TActivationExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月20日 下午1:49:55 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class CardActivationServiceImpl implements CardActivationService {

	@Autowired
	private TActivationMapper activationMapper;
	@Override
	public List<TActivation> selectActivationCode(TActivationExample example) {
		List<TActivation> list = this.activationMapper.selectByExample(example);
		
		
		return list;
	}
	@Override
	public Integer updateActivationInfobyId(TActivation activation) {
		
		int i = this.activationMapper.updateByPrimaryKeySelective(activation);
		
		return i;
	}

}
