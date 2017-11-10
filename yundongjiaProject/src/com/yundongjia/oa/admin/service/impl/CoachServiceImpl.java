/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.oa.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.oa.admin.mapper.TCoachMapper;
import com.yundongjia.oa.admin.mapper.TCoachRewardMapper;
import com.yundongjia.oa.admin.mapper.TCoachSkillRefMapper;
import com.yundongjia.oa.admin.mapper.TCoachStudioRefMapper;
import com.yundongjia.oa.admin.mapper.TCoachUserMapper;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachExample;
import com.yundongjia.oa.admin.po.TCoachReward;
import com.yundongjia.oa.admin.po.TCoachRewardExample;
import com.yundongjia.oa.admin.po.TCoachSkillRef;
import com.yundongjia.oa.admin.po.TCoachSkillRefExample;
import com.yundongjia.oa.admin.po.TCoachStudioRef;
import com.yundongjia.oa.admin.po.TCoachStudioRefExample;
import com.yundongjia.oa.admin.po.TCoachUser;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.service.CoachService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.MD5Util;

@Service
public class CoachServiceImpl implements CoachService {

	@Autowired
	private TCoachMapper coachMapper;
	@Autowired
	private TCoachUserMapper coachUserMapper; //教练用户
	@Autowired
	private TCoachRewardMapper coachRewardMapper;  //奖项
	@Autowired
	private TCoachSkillRefMapper coachSkillRefMapper; //擅长课程
	@Autowired
	private TRegionsMapper regionsMapper;
	@Autowired
	private TStudioMapper studioMapper;
	@Autowired
	private TCoachStudioRefMapper coachStudioRefMapper;//教练与场馆关联表
	
	@Override
	public List<TCoach> findCoachList() {
		TCoachExample example = new TCoachExample();
		
		example.createCriteria();
		//example.setOrderByClause("desc coachId");

		return coachMapper.selectByExample(example);
	}
	@Override
	public Integer insertCoach(TCoach coach, TCoachUser coachUser,String [] rewardName,String [] rewardNum,Integer [] skills,Integer studioId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		
		//教练信息
		coach.setUserid(coachUser.getUserid());
		Integer result = coachMapper.insertSelective(coach);
		//教练用户
		coachUser.setUserid(coach.getCoachid());
		coachUser.setCreatedate(sdf.format(new Date()));
		coachUser.setPassword(MD5Util.md5(ConstantVo.COACH_PASSWORD));
		Integer cUserId = coachUserMapper.insertSelective(coachUser);
		
		//教练与场馆关联表
		TCoachStudioRef csRef = new TCoachStudioRef();
		csRef.setCoachid(coach.getCoachid());
		csRef.setStudioid(studioId);
		coachStudioRefMapper.insertSelective(csRef);
		
		
		//获得奖项
		if(rewardName != null && rewardName.length > 0){
			for (int i = 0; i < rewardName.length; i++) {
				TCoachReward tr = new TCoachReward();
				tr.setCoachid(coach.getCoachid());
				if(rewardName[i] !=null && rewardName[i] !="" && !"".equals(rewardName[i])){
					tr.setReward(rewardName[i]);
					tr.setOrdernum(Integer.parseInt(rewardNum[i]));
					coachRewardMapper.insertSelective(tr);
				}
			}
		}
		
		//擅长课程
		if(skills !=null && skills.length > 0){
			TCoachSkillRef csr = new TCoachSkillRef();
			csr.setCoachid(coach.getCoachid());
			for (int i = 0; i < skills.length; i++) {
				csr.setSkillid(skills[i]);
				coachSkillRefMapper.insertSelective(csr);
			}
		}
		
		return coach.getCoachid();
	}
	@Override
	public List<Map<String, Object>> findCoachListLMap(Map<String, Object> param) {
		
		 
		
		return dataFormat(coachMapper.findCoachListLMap(param));
	}

	/**
	* Title: dataFormat
	* Description: 格式化数据
	* @param list
	* @return
	* @author HuangJian
	* @date 2017年2月6日
	*/
	public List<Map<String, Object>> dataFormat(List<Map<String, Object>> list){
		
		if(list !=null && list.size() > 0){
			Map<String, Object> temp;
			TRegions regions;
			String statusName="";
			Integer statusId=0;
			String skillNames="";
			String skillId = "";
			for (int i = 0; i < list.size(); i++) {
				skillNames="";
				temp=list.get(i);
				
				// 区id
				int regId = Integer.parseInt(String.valueOf(temp.get("regionsId")));
				//的到区
				regions = regionsMapper.getAreaByArea(regId);
				temp.put("city", regions.getpCode());
				temp.put("areaName", regions.getName());
				// 得到市
				regions = regionsMapper.getCityByArea(regions.getpCode());
				temp.put("cityName", regions.getName());
				// 得到省
				regions = regionsMapper.getProvinceByCity(regions.getpCode());
				
				// 省名称 /  code
				temp.put("ProvinceId", regions.getCode());
				temp.put("provinceName", regions.getName());
				
				statusId = Integer.parseInt(String.valueOf(temp.get("status")));
				switch (statusId) {
				case 0:
					statusName="生效";
					break;
				case 1:
					statusName="禁用";
					break;
				case 2:
					statusName="未审核";
					break;
				default:
					break;
				}
				temp.put("statusName", statusName);
				
				
				//擅长课程
				Integer coachId = Integer.parseInt(String.valueOf(temp.get("coachId")));
				List<Map<String, Object>> skills =  coachSkillRefMapper.findSkillRefByCoachId(coachId);
				
				if(skills != null && skills.size() > 0){
					for (int j = 0; j <skills.size()-1; j++) {
						skillNames += skills.get(j).get("skillName")+",";
						skillId += skills.get(j).get("skillId")+",";
					}
					skillNames += skills.get(skills.size()-1).get("skillName")+"";
					skillId += skills.get(skills.size()-1).get("skillId")+"";
				}
				temp.put("skillNames", skillNames);
				temp.put("skillids", skillId);
				//场馆 多个
				List<Map<String, Object>> studios =  studioMapper.getStudioByCoachId(coachId);
				String studioName="";
				Integer studioId=0;
				String openTime="";
				if(studios !=null && studios.size() >0){
					studioId = Integer.parseInt(String.valueOf(studios.get(0).get("studioId")));
					studioName = String.valueOf(studios.get(0).get("studioName"));
					openTime=String.valueOf(studios.get(0).get("studioOpentime"));
				}
				temp.put("studioId", studioId);
				temp.put("studioName", studioName);
				temp.put("openTime", openTime);
				
				
				
				//奖项
				TCoachRewardExample example = new TCoachRewardExample();
				example.createCriteria().andCoachidEqualTo(coachId);
				example.setOrderByClause("rowId desc");
				List<TCoachReward> crs =  coachRewardMapper.selectByExample(example);
				String rewName="";
				if(crs != null && crs.size() >0){
					
					for (int j = 0; j < crs.size()-1; j++) {
						rewName += crs.get(j).getReward()+",";
					}
					rewName+=crs.get(crs.size()-1).getReward();
					
					temp.put("rewars", crs);
				}else{
					temp.put("rewars", "");
				}
				temp.put("skillArray", rewName);
				
				
				Integer lim = Integer.parseInt(String.valueOf(temp.get("cancleLimit")));
				String limName="不限制";
				switch (lim) {
				case 0:
					
					break;	
				case 1:
					limName="6小时";
					break;
				case 2:
					limName="12小时";
					break;
				case 3:
					limName="24小时";
					break;
				case 4:
					limName="36小时";
					break;		
				case 5:
					limName="72小时";
					break;			
				default:
					break;
				}
				temp.put("cancleLimitName", limName);
				
				
			}
		}
		
		
		return list;
	}
	@Override
	public Map<String, Object> getCoachById(Integer coachId) {
		
		List<Map<String, Object>> data=coachMapper.getCoachById(coachId);
		data=dataFormat(data);
		if(data!=null && data.size() > 0){
			
			return data.get(0);
		}
		return null;
	}
	@Override
	public Integer updateCoach(TCoach coach, TCoachUser coachUser, String[] rewardName, String[] rewardNum,
			Integer[] skills,Integer studioid) {
		coach.setStatus(2);//信息有变状态改成未审核
		//修改教练用户
		coachUserMapper.updateByPrimaryKeySelective(coachUser);
		
		//修改教练信息
		Integer result =  coachMapper.updateByPrimaryKeySelective(coach);
		
		//先删除教练场馆，再添加场馆
		TCoachStudioRefExample example = new TCoachStudioRefExample();
		example.createCriteria().andCoachidEqualTo(coach.getCoachid());
		coachStudioRefMapper.deleteByExample(example);
		//增加场馆与教练关联表
		TCoachStudioRef csRef = new TCoachStudioRef();
		csRef.setCoachid(coach.getCoachid());
		csRef.setStudioid(studioid);
		coachStudioRefMapper.insertSelective(csRef);
		/**
		 * 先删除 奖项，在添加奖项
		 */
		try {
			//---------删除奖项
			TCoachRewardExample rewExample=new TCoachRewardExample();
			rewExample.createCriteria().andCoachidEqualTo(coach.getCoachid());
			coachRewardMapper.deleteByExample(rewExample);
			//---------添加奖项
			//获得奖项
			if(rewardName != null && rewardName.length > 0){
				for (int i = 0; i < rewardName.length; i++) {
					TCoachReward tr = new TCoachReward();
					tr.setCoachid(coach.getCoachid());
					if(rewardName[i] !=null && rewardName[i] !="" && !"".equals(rewardName[i])){
						tr.setReward(rewardName[i]);
						tr.setOrdernum(Integer.parseInt(rewardNum[i]));
						coachRewardMapper.insertSelective(tr);
					}
				}
			}
			
		} catch (Exception e) {
		 
		}
		
		
		/**
		 * 擅长课程 先删除 再添加擅长课程
		 */
		try {
			//-----删除擅长课程
			TCoachSkillRefExample skillExample = new TCoachSkillRefExample();
			skillExample.createCriteria().andCoachidEqualTo(coach.getCoachid());
			coachSkillRefMapper.deleteByExample(skillExample);
			
			
			//-----添加擅长课程
			if(skills !=null && skills.length > 0){
				TCoachSkillRef csr = new TCoachSkillRef();
				csr.setCoachid(coach.getCoachid());
				for (int i = 0; i < skills.length; i++) {
					csr.setSkillid(skills[i]);
					coachSkillRefMapper.insertSelective(csr);
				}
			}
		} catch (Exception e) {
			 
		}
		
		
		
		return result;
	}
	@Override
	public Integer updateCoachStatusById(TCoach coach) {
		Integer result = coachMapper.updateByPrimaryKeySelective(coach);
		return result;
	}
	@Override
	public Map<String, Object> selectStatisByCoach() {
		Map<String, Object> map=new HashMap<>();
		//生效状态
 		Integer statusOK = coachMapper.selectStatisByCoach(0);
 		
 		//禁用状态
 		Integer statusDis = coachMapper.selectStatisByCoach(1);
 		
 		//未审核状态
 		Integer statusNoAudit = coachMapper.selectStatisByCoach(2);
 		
 		map.put("statusOK", statusOK);
 		map.put("statusDis", statusDis);
 		map.put("statusNoAudit", statusNoAudit);
		return map;
	}
}

