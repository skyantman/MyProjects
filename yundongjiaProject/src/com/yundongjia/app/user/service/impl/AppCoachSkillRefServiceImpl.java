/**
* @author HuangJian
* @date 2017年6月7日
*/
package com.yundongjia.app.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppCoachSkillRefService;
import com.yundongjia.oa.admin.mapper.TCoachSkillRefMapper;

@Service
public class AppCoachSkillRefServiceImpl implements AppCoachSkillRefService{

	@Autowired
	private TCoachSkillRefMapper coachSkillRefMapper;
	@Override
	public List<Map<String, Object>> getCoachByStudioId(Integer studioId) {
		List<Map<String, Object>> list = coachSkillRefMapper.getCoachByStudioId(studioId);
		List<Map<String, Object>> newList=new ArrayList<>();
		
		Integer coachId=0;
		if(list.size() > 0){
			List<Map<String, Object>> skills;
			for (Map<String, Object> map : list) {
				coachId = Integer.parseInt(String.valueOf(map.get("coachId")));
				skills = coachSkillRefMapper.findSkillRefByCoachId(coachId);
				map.put("coachSkill", skills);
				newList.add(map);
			}
		}
		return newList;
	}

}

