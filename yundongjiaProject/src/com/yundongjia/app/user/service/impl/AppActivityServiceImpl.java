package com.yundongjia.app.user.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppActivityService;
import com.yundongjia.oa.admin.mapper.TActivityMapper;
import com.yundongjia.oa.admin.mapper.TActivityOrderMapper;
import com.yundongjia.oa.admin.mapper.TAttachMapper;
import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TRedpackageMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityExample;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TStudio;


/**
 * 
* @ClassName: ActivityServiceImpl 
* @Description: TODO(运动+活动（团课）服务器) 
* @author LiXiaoYang
* @date 2017年2月14日 17:21:26 
*
 */
@Service
public class AppActivityServiceImpl implements AppActivityService{
	@Autowired
	private TActivityMapper tActivityMapper;
	@Autowired
	private TActivityOrderMapper tActivityOrderMapper;
	@Autowired
	private TCoachMapper tCoachMapper;
	@Autowired
	private TStudioMapper tStudioMapper;
	@Autowired
	private TAttachMapper tAttachMapper;
	@Autowired
	private TMemberMapper tMemberMapper;
	@Autowired
	private TRedpackageMapper tRedpackageMapper;
	
	/**
	 * @param format
	 * @return根据日期查询活动列表
	 */
	@Override
	public List<Map<String,Object>> findListByDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<Map<String,Object>> list = tActivityMapper.findListByDate(date);
		for (Map<String,Object> map : list) {
			try {
				if(Integer.parseInt(map.get("alreadyMan").toString()) == Integer.parseInt(map.get("activeNum").toString())){
						map.put("avtiveStatus", "已满");
				} else if(dateFormat.parse(map.get("activeEndTime").toString()).getTime() < new Date().getTime()){
					map.put("avtiveStatus", "已结束");	
				}else if(dateFormat.parse(map.get("activeStartTime").toString()).getTime() < new Date().getTime()){
						map.put("avtiveStatus", "已开始");	
				}else{
					map.put("avtiveStatus", "未开始");	
				}
					String  activeStartTime = map.get("activeStartTime").toString().split(" ")[1];		
					String  activeEndTime = map.get("activeEndTime").toString().split(" ")[1];
					map.put("activeStartTime", activeStartTime);
					map.put("activeEndTime", activeEndTime);
				}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * @param map activeId 活动ID
	 */
	@Override
	public Map<String, Object> finListById(Integer activeId) {
		Map<String, Object> result = new HashMap<String, Object>();
		TActivity activity = tActivityMapper.selectByPrimaryKey(activeId);
		TStudio studio = tStudioMapper.selectByPrimaryKey(activity.getStudioid());
		result.put("studioName", studio.getStudioname());
		result.put("studioId", activity.getStudioid());
		result.put("lng", studio.getLng());
		result.put("lat", studio.getLat());
		String[] start = activity.getActivestarttime().split(" ");
		String[] end = activity.getActiveendtime().split(" ");
		String activeEndTime = end[1];
		String activeDate = start[0];
		String activeStartTime = start[1];
		result.put("activeDate", activeDate);
		result.put("activeStartTime", activeStartTime);
		result.put("activeEndTime", activeEndTime);
		result.put("activeId", activity.getActiveid());
		result.put("activePrice", activity.getActiveprice());
		result.put("activeSubNum", activity.getActivesubnum());
		result.put("activeNum", activity.getActivenum());
		result.put("alreadyMan", activity.getAlreadyman());
		result.put("activeName", activity.getActivename());
		result.put("activeAddres", activity.getActiveaddres());
		result.put("activeIntroduce", activity.getActiveintroduce());
		result.put("activeComm", activity.getActivecomm());
		String coachids = activity.getCoachids();
		String[] sc = coachids.split(",");
		int coachId = Integer.parseInt(sc[0]);
		TCoach coach = tCoachMapper.selectByPrimaryKey(coachId);
		result.put("coachName", coach.getNickname());
		result.put("coachId", coach.getCoachid());
		result.put("introduce", coach.getIntroduce());
		if(coach.getImgstat() != null && coach.getImgstat() == 2){
			result.put("imgpath", coach.getImgpath());
		}else{
			result.put("imgpath", "");
		}
		Map< String, Object> param = new HashMap();
		param.put("activityId", activeId);
		param.put("type", 1);
		List<Map<String, Object>> imgs = tAttachMapper.findImgs(param);	
		result.put("imgs", imgs);
		List<Map<String, Object>> activeMember =  tActivityOrderMapper.findeMember(activeId);
		result.put("member", activeMember);
		result.put("status", "0");
		result.put("message", "请求成功");
		return result;
	}

	@Override
	public int getActivityCountBySutdioId(Integer studioId) {
		TActivityExample example = new TActivityExample();
		
		example.createCriteria().andStudioidEqualTo(studioId);
		
		
		return tActivityMapper.countByExample(example);
	}
	
}
