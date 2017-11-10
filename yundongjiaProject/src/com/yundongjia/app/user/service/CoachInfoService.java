package com.yundongjia.app.user.service;


import java.util.List;

import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachStudioRef;
import com.yundongjia.oa.admin.po.TCoachStudioRefExample;
import com.yundongjia.oa.admin.po.TPrivateLessonTime;
import com.yundongjia.oa.admin.po.TPrivateLessonTimeExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:00:24 * @version 1.0 * @parameter  * @since  * @return  */

public interface CoachInfoService {
    
	public TCoach selectCoachInfobyId(Integer id);	
	public List<TPrivateLessonTime> selectCoachworktime(TPrivateLessonTimeExample example);
	public List<TCoachStudioRef> selectCoachStudioRefInfo(TCoachStudioRefExample example);
	public Integer insertCoachworktime(TPrivateLessonTime privateLessonTime);
}
