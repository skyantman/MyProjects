package com.yundongjia.app.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.accessibility.internal.resources.accessibility;
import com.yundongjia.app.user.service.LoginUserService;
import com.yundongjia.oa.admin.mapper.TActivationMapper;
import com.yundongjia.oa.admin.mapper.TMsgMapper;
import com.yundongjia.oa.admin.po.TActivation;
import com.yundongjia.oa.admin.po.TMsg;
import com.yundongjia.oa.admin.po.TMsgExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午9:42:43 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class LoginUserServiceImpl implements LoginUserService {
	
	@Autowired
	private TMsgMapper msgMapper;
	@Autowired
	private TActivationMapper activationMapper;
	
	@Override
	public Integer insertVerifyCode(TMsg msg) {
		Integer result =  msgMapper.insertSelective(msg);
		return result;
	}

	@Override
	public List<TMsg> selectVerifyCode(TMsgExample msgExample) {
		List<TMsg> list = msgMapper.selectByExample(msgExample);
		return list;
	}

	@Override
	public Integer updateVerifyCodeStatus(TMsg msg) {
		int result = msgMapper.updateByPrimaryKeySelective(msg);
		return result;
	}

	@Override
	public Integer insertActivation(TActivation activation) {
		int i = this.activationMapper.insert(activation);
		return i;
	}
    
	
}
