/**
* @author HuangJian
* @date 2017年2月6日
*/
package com.yundongjia.app.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppSkillService;
import com.yundongjia.oa.admin.mapper.TCoachSkillRefMapper;
import com.yundongjia.oa.admin.mapper.TSkillMapper;
import com.yundongjia.oa.admin.po.TSkill;
import com.yundongjia.oa.admin.po.TSkillExample;
@Service
public class AppSkillServiceImpl implements AppSkillService{

	@Autowired
	private TSkillMapper skillMapper;
	@Autowired
	private TCoachSkillRefMapper coachSkillRefMapper;
	
	@Override
	public List<TSkill> findSkill() {
		TSkillExample example = new TSkillExample();
		example.createCriteria();
		example.setOrderByClause("skillId desc");
		return skillMapper.selectByExample(example);
	}

	@Override
	public List<Map<String, Object>> getSkillByCoachId(Integer coachId) {
		 
		return coachSkillRefMapper.findSkillRefByCoachId(coachId);
	}

}

