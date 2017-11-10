package com.yundongjia.app.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.CoachInfoService;
import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TCoachStudioRefMapper;
import com.yundongjia.oa.admin.mapper.TPrivateLessonTimeMapper;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachStudioRef;
import com.yundongjia.oa.admin.po.TCoachStudioRefExample;
import com.yundongjia.oa.admin.po.TPrivateLessonTime;
import com.yundongjia.oa.admin.po.TPrivateLessonTimeExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月15日 上午10:25:38 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class CoachInfoServiceImpl implements CoachInfoService {

	@Autowired
	private TCoachMapper coachMapper;
	@Autowired
	private TCoachStudioRefMapper coachStudioRefMapper;
	@Autowired
	private TPrivateLessonTimeMapper privateLessonTimeMapper;
	
	
	@Override
	public TCoach selectCoachInfobyId(Integer id) {
		TCoach coach = this.coachMapper.selectByPrimaryKey(id);
		return coach;
	}
	@Override
	public List<TCoachStudioRef> selectCoachStudioRefInfo(TCoachStudioRefExample example) {
		List<TCoachStudioRef> list = this.coachStudioRefMapper.selectByExample(example);
		return list;
	}
 
	public List<TPrivateLessonTime> selectCoachworktime(TPrivateLessonTimeExample example){
		List<TPrivateLessonTime> list = this.privateLessonTimeMapper.selectByExample(example);
		return list;
		
	}
	@Override
	public Integer insertCoachworktime(TPrivateLessonTime privateLessonTime) {
		int i = this.privateLessonTimeMapper.insertSelective(privateLessonTime);
		return i;
	}
	
	
	
}
