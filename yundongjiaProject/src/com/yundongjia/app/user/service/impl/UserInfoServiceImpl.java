package com.yundongjia.app.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.UserInfoService;
import com.yundongjia.oa.admin.mapper.TUserMapper;
import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.po.TUserExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:01:09 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    
	@Autowired
	private TUserMapper userMapper;
	@Override
	public List<TUser> selectUserLoginInfo(TUserExample example) {
		List<TUser> list = userMapper.selectByExample(example);
		return list;
	}
	@Override
	public Integer updateUserPwd(TUser user,TUserExample example) {
		int result = userMapper.updateByExampleSelective(user, example);
		return result;
	}
	@Override
	public Integer insertUser(TUser user) {
		int result = userMapper.insertSelective(user);
		return result;
	}
	@Override
	public Integer updateUserPwd(TUser user) {
		int result = userMapper.updateByPrimaryKeySelective(user);
		return result;
	}

}
