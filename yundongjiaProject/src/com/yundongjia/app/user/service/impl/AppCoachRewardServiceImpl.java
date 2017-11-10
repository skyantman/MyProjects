/**
* @author HuangJian
* @date 2017年2月15日
*/
package com.yundongjia.app.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppCoachRewardService;
import com.yundongjia.oa.admin.mapper.TCoachRewardMapper;
import com.yundongjia.oa.admin.po.TCoachReward;
import com.yundongjia.oa.admin.po.TCoachRewardExample;
@Service
public class AppCoachRewardServiceImpl implements AppCoachRewardService{

	@Autowired
	private TCoachRewardMapper coachRewardMapper;

	@Override
	public List<TCoachReward> getCoachRewardByCoachId(Integer coachId) {
		TCoachRewardExample example = new TCoachRewardExample();
		example.createCriteria().andCoachidEqualTo(coachId);
		return coachRewardMapper.selectByExample(example);
	}
	 

	
}

