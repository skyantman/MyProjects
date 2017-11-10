package com.yundongjia.app.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.MemberShowTimeService;
import com.yundongjia.oa.admin.mapper.TMemberShowtimeMapper;
import com.yundongjia.oa.admin.po.TMemberShowtime;
import com.yundongjia.oa.admin.po.TMemberShowtimeExample;



/**
 * 
* @ClassName: MemberShowTimeServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Wangli
* @date 2016年12月13日 下午1:18:43 
*
 */
@Service
public class MemberShowTimeServiceImpl implements MemberShowTimeService {

	@Autowired
	private TMemberShowtimeMapper memberShowtimeMapper;
	
	@Override
	public int countByExample(TMemberShowtimeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByExample(TMemberShowtimeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Integer cardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(TMemberShowtime record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertSelective(TMemberShowtime record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List selectByExample(TMemberShowtimeExample example) {
		
		return memberShowtimeMapper.selectByExample(example);
	}

	@Override
	public TMemberShowtime selectByPrimaryKey(Integer cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByExampleSelective(TMemberShowtime record, TMemberShowtimeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByExample(TMemberShowtime record, TMemberShowtimeExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(TMemberShowtime record) {
		
		return memberShowtimeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(TMemberShowtime record) {
		// TODO Auto-generated method stub
		return 0;
	}


    
}
