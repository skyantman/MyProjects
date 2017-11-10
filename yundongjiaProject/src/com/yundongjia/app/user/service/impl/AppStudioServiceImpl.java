/**
* @author HuangJian
* @date 2017年2月14日
*/
package com.yundongjia.app.user.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.log.Log;
import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;
import com.yundongjia.app.user.service.AppActivityService;
import com.yundongjia.app.user.service.AppStudioService;
import com.yundongjia.oa.admin.mapper.TCardTypeMapper;
import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.mapper.TMemberMapper;
import com.yundongjia.oa.admin.mapper.TMemberShowtimeMapper;
import com.yundongjia.oa.admin.mapper.TRegionsMapper;
import com.yundongjia.oa.admin.mapper.TStudioConsumeOrderRecordMapper;
import com.yundongjia.oa.admin.mapper.TStudioMapper;
import com.yundongjia.oa.admin.po.TConfigExample;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberShowtime;
import com.yundongjia.oa.admin.po.TMemberShowtimeExample;
import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.utils.MapDistance;
import com.yundongjia.oa.utils.UtilPage;

import sun.security.krb5.internal.PAData;

@Service
public class AppStudioServiceImpl implements AppStudioService{

	@Autowired
	private TStudioMapper tStudioMapper;
	@Autowired
	private  TConfigMapper baseConfigMapper;
	@Autowired
	private TStudioConsumeOrderRecordMapper studioConsumeOrderRecordMapper;
	@Autowired
	private TRegionsMapper regionsMapper;
	@Autowired
	private TConfigMapper tConfigMapper;
	@Autowired
	private TMemberMapper tMemberMapper;
	@Autowired
	private TMemberShowtimeMapper tMemberShowtimeMapper;
	@Autowired
	private TCardTypeMapper cardTypeMapper;
	@Autowired
	private AppActivityService appActivityService;
	
	Map<String, Object> temp;
	Map<String, Object> param;
	TRegions regions;
	@SuppressWarnings("null")
	@Override
	public List<Map<String, Object>> findStudioList(Map<String, Object> param) {
		List<Integer> areas= null;
		if(param.containsKey("city")){
			//有城市条件
			areas = regionsMapper.getAreaCodeByCityCode(String.valueOf(param.get("city")));
			if(areas != null && areas.size() == 0){
				areas=null;
			}
		}else{ 
			//没有城市
		}
		if(!param.containsKey("studioType") && "0".equals(param.get("studioType"))){
			param.put("studioType", null);
		}else{
			
		}
		param.put("areas", areas);
		List<Map<String, Object>> list=null;
		List<Map<String, Object>> list1=null;
	
		list = tStudioMapper.findStudioListApp(param);
		//数据处理
		List<Map<String, Object>> temp = this.studioListDataLogic(list, param);
		/*String userLng = String.valueOf(param.get("lng"));
		String userLat = String.valueOf(param.get("lat"));
		double memPrice=0.0;
			if(list != null){
				param=new HashMap<>();
				//会员价
				TConfigExample example = new TConfigExample();
			    Criteria cr =  example.createCriteria();
			    cr.andCnameEqualTo("STUDIO_MEMBER_PRICE").andStatEqualTo(1);
			    List<TConfig> cs = this.baseConfigMapper.selectByExample(example);
			    if(cs !=null){
			    	memPrice=Double.parseDouble(String.valueOf(cs.get(0).getCvalue()));
			    }
				//个人卡类型最低折扣
				double cardDis = cardTypeMapper.selectMinCardDiscount();
				memPrice = cardDis / 10;
			    DecimalFormat    df   = new DecimalFormat("######0.00");
			    temp=new HashMap<>();
			    Integer studioId = 0;
			    int activityCount = 0;
				for (int i = 0; i < list.size(); i++) {
					temp=list.get(i);
					//temp.put("memberDiscount", memPrice);
					memPrice=0.88;//默认8.8折扣
					temp.put("memberDiscount", "8.8");//会员折扣默认8.8
					Double consumeMoney = Double.parseDouble(String.valueOf(temp.get("consumeMoney")));
					String pro = df.format(memPrice * consumeMoney);
					int money = (int) Math.rint(Double.parseDouble(pro));//四舍五入取整
					//会员价 非会员价*折扣
					temp.put("memPrice", money);//会员价
					temp.put("consumeMoney", Math.rint(consumeMoney));
					String yzfCount="0";
					studioId = Integer.parseInt(String.valueOf(temp.get("studioId")));
					try {
						param.put("studioId", temp.get("studioId"));
						yzfCount = studioConsumeOrderRecordMapper.appSelectOrderCountByStudioId(param);
						if(yzfCount == null){
							yzfCount = "0";
						}
						temp.put("sellCount", yzfCount);//出售
					} catch (Exception e1) {
						temp.put("sellCount", yzfCount);
					}
					
					// 区id
					try {
						int regId = Integer.parseInt(String.valueOf(temp.get("regionsId")));
						regions = regionsMapper.getAreaByArea(regId);
						if(regions == null){
							temp.put("areaName", "暂无");//地区名称
						}else{
							temp.put("areaName", regions.getName());//地区名称
						}
					} catch (NumberFormatException e1) {
						temp.put("areaName", "暂无");
					}
					
					
					try {
						String lng=String.valueOf(temp.get("lng"));
						String lat=String.valueOf(temp.get("lat"));
						if(!"null".equals(userLat) || null != userLat || !"".equals(userLat) && !"null".equals(userLng) || null != userLng || !"".equals(userLng)){
							temp.put("distance", MapDistance.getDistance(userLat, userLng, lat, lng));
						}else{
							temp.put("distance","0");
						}
					} catch (Exception e) {
						temp.put("distance","0");
					}
					
					//当前场馆活动总数
					//activityCount = appActivityService.getActivityCountBySutdioId(studioId);
					activityCount = 1;
					temp.put("activityCount", activityCount);
					
					
					
					if(param.containsKey("userId")){
						
						//是否是会员
						List<Map<String, Object>> isMem = tMemberMapper.findIsMemberById(param.get("userId").toString());
						if(isMem != null && isMem.size() > 0){
							//会员价
							temp.put("isVip",true);
						}else{
							//非会员价
							temp.put("isVip", false);
						}
					}else{
						//非会员价
						temp.put("isVip", false);
					}
					
					
					
					
					
					list.set(i, temp);
				}
			}*/
	
		return temp;
	}
	@Override
	public Map<String, Object> selectStudioById(Map<String, Object> param) {
		//场馆ID
		Integer studioId = Integer.parseInt(String.valueOf(param.get("studioId")));
		Map<String, Object> data = tStudioMapper.selectStudioByIdApp(studioId);
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(data);
		//数据处理
		list = this.studioListDataLogic(list, param);
		/*if(data!=null){
		
		    double memPrice=0.0;
			// 会员价
			TConfigExample example = new TConfigExample();
			Criteria cr = example.createCriteria();
			cr.andCnameEqualTo("STUDIO_MEMBER_PRICE").andStatEqualTo(1);
			List<TConfig> cs = this.baseConfigMapper.selectByExample(example);
			if (cs != null) {
				memPrice = Double.parseDouble(String.valueOf(cs.get(0).getCvalue()));
			}
		    double cardDis = cardTypeMapper.selectMinCardDiscount();
		    memPrice = cardDis / 10;
			DecimalFormat df = new DecimalFormat("######0.00");
			Double consumeMoney = Double.parseDouble(String.valueOf(data.get("consumeMoney")));
			memPrice = 0.88; //默认8.8折扣
			String pro = df.format(memPrice * consumeMoney);
			
			int d=(int) Math.rint(Double.parseDouble(pro));
			//会员价 = 非会员价*折扣
			data.put("memPrice", d);
		    data.put("memberDiscount","8.8");//默认8.8折扣
			
		    if(param.containsKey("userId")){
				
				//是否是会员
				List<Map<String, Object>> isMem = tMemberMapper.findIsMemberById(param.get("userId").toString());
				if(isMem != null && isMem.size() > 0){
					//会员价
					data.put("isVip",true);
				}else{
					//非会员价
					data.put("isVip", false);
				}
			}else{
				//非会员价
				data.put("isVip", false);
			}
			
			
			
			
		}*/
		
		return list.get(0);
	}
	@Override
	public TStudio selectStudioInfo(Integer id) {
		TStudio studio = this.tStudioMapper.selectByPrimaryKey(id);
		return studio;
	}
	@Override
	public Map<String, Object> findOverSportShareInfo(Integer orderType, Integer memberId) {
		Map<String, Object> result = new HashMap<String , Object>();
		//查询会员信息
		TMember member = tMemberMapper.selectByPrimaryKey(memberId);
		//查询会员所有的运动时间数据
		TMemberShowtimeExample tMemberShowtimeExample = new TMemberShowtimeExample();
		tMemberShowtimeExample.createCriteria().andMemberidEqualTo(memberId).andIsshowoverEqualTo("0");
		tMemberShowtimeExample.setOrderByClause("showstarttime desc");
		List<TMemberShowtime> showTime = tMemberShowtimeMapper.selectByExample(tMemberShowtimeExample);
		//运动时间总时常分钟
		Long allSportTime = 0l;
		for (TMemberShowtime st : showTime) {
			allSportTime = allSportTime + (Long.parseLong(st.getMillisecond())/60000);
		}
		List<Map<String, Object>> showTimeAll = tMemberShowtimeMapper.findRank();
		int i = 1;
		for (Map<String, Object> map : showTimeAll) {
			if(memberId.equals(Integer.parseInt(map.get("memberId").toString()))){
				break;
			}
			i++;
		}
		if(i > 11){
			result.put("isHaveNum", false);
		}else{
			result.put("isHaveNum", true);
		}
		result.put("percent", percentCount(showTimeAll.size() , i));
		result.put("routeNum", i);
		result.put("memberImg", member.getImgpath());
		result.put("memberName", member.getNickname());
		result.put("allSportTime", allSportTime);
		result.put("thisSportTime", Long.parseLong(showTime.get(0).getMillisecond())/60000);
		Map<String, Object> shareInfo = new HashMap<>();
		TConfigExample tConfigExample = new TConfigExample();
		tConfigExample.createCriteria().andCnameEqualTo("SHARE_TITLE_SPORT");
		String title = tConfigMapper.selectByExample(tConfigExample).get(0).getCvalue();
		tConfigExample.clear();
		tConfigExample.createCriteria().andCnameEqualTo("SHARE_CONTENT_SPORT");
		String content = tConfigMapper.selectByExample(tConfigExample).get(0).getCvalue();
		tConfigExample.clear();
		tConfigExample.createCriteria().andCnameEqualTo("SHARE_LINK_SPORT");
		String url = tConfigMapper.selectByExample(tConfigExample).get(0).getCvalue() + "?orderType="+ orderType +"&memberId=" + memberId;
		shareInfo.put("title", title);
		shareInfo.put("content", content);
		shareInfo.put("url", url);
		result.put("shareInfo", shareInfo);
		switch (orderType) {
		case 4:
			result.put("type", "健身");
			TStudioConsumeOrderRecordExample tStudioConsumeOrderRecordExample = new TStudioConsumeOrderRecordExample();
			tStudioConsumeOrderRecordExample.createCriteria().andMemberidEqualTo(memberId).andPaystatusEqualTo(2);
			tStudioConsumeOrderRecordExample.setOrderByClause("createDate desc");
			List<TStudioConsumeOrderRecord> studioOrder = studioConsumeOrderRecordMapper.selectByExample(tStudioConsumeOrderRecordExample);
			TStudio studio = tStudioMapper.selectByPrimaryKey(studioOrder.get(0).getStudioid());
			result.put("name", studio.getStudioname());
			break;
		default:
			result.put("type", "健身");
			result.put("name", "");
			break;
		}
		
		return result;
	}
	
	
	
	private String percentCount(Integer allNum , Integer myNum){
		DecimalFormat df=new DecimalFormat("0.00");
		String percent = df.format(((double)(allNum - myNum) / (double)allNum)*100); 
		if(allNum == myNum){
			int max=25;
	        int min=18;
	        Random random = new Random();
	        int s = random.nextInt(max)%(max-min+1) + min;
			return s + "%";
		}else if(myNum == 1){
			return "100%";
		}else if(Double.parseDouble(percent) < 65d){
			percent = (Double.parseDouble(percent) + 20d) + "";
		}else if(Double.parseDouble(percent) < 80d){
			percent = (Double.parseDouble(percent) + 10d) + "";
		}else if(Double.parseDouble(percent) < 90d){
			percent = (Double.parseDouble(percent) + 6d) + "";
		}else if(Double.parseDouble(percent) < 93d){
			percent = (Double.parseDouble(percent) + 3d) + "";
		}
		return percent + "%";
	}
	// 场馆类型 0：全部 1：工作室  2：健身房 3:游泳 4：羽毛球 5：高尔夫 6：篮球 7：网球 8：足球 9：台球 10：保龄球  11: 瑜伽 12：舞蹈 13：马术 14：滑雪 15：滑冰 16:练习场
	public String[] typeNames= new String[]{"全部","工作室","健身","游泳","羽毛球","高尔夫","篮球","网球","足球","台球",
			"保龄球","瑜伽","舞蹈","马术","滑雪","滑冰","练习场"};
	//,"智能场馆" 是否是智能场馆
	@Override
	public List<Map<String, Object>> getStudioTypeCount(Map<String, Object> map) {
		List<Integer> areas = null;
		if(map.containsKey("city")){
			areas = regionsMapper.getAreaCodeByCityCode(map.get("city").toString());
			if(areas != null && areas.size() == 0){
				areas = null;
			}
		}else{
			
		}
		Map<String, Object> temp;
		String count = "0";
		
		List<Map<String, Object>> list = new ArrayList<>();
		 // String areaId,Integer typeId
		Map<String, Object> param;
		//param.put("areaId", areaId);
		
		for(int i=0;i < typeNames.length;i++){
			param = new HashMap<>();
			temp = new HashMap<>();
			
			param.put("typeId",i);
			//根据区统计
			if(map.containsKey("areaId")){
				
				count = tStudioMapper.getStudeioByAreaCount(param);
			//根据城市统计
			}else{
				param.put("areas", areas);//城市下的所有区
				count = tStudioMapper.getStudioTypeCount(param);
			}
			/*if("null".equals(areaId)){
				count = tStudioMapper.getStudioTypeCount(i);
				
			}else{
				param.put("typeId", i);
				count = tStudioMapper.getStudeioByAreaCount(param);
			}*/
			temp.put("count", count);
			temp.put("typeId", i);
			temp.put("typeName", typeNames[i]);
			
			list.add(temp);
		}
		
		
		return list;
	}
	public List<Map<String, Object>> list;
	@Override
	public List<Map<String, Object>> getStudeioByAreaCount() {
		
		return null;
	}
	@Override
	public List<Map<String, Object>> getStudioByTypeList(Map<String, Object> param) {
		List<Integer> areas = null;
		if (param.containsKey("city")) {
			areas = regionsMapper.getAreaCodeByCityCode(param.get("city").toString());
			if(areas != null && areas.size() == 0){
				areas = null;
			}
		}else{
			
		}
		param.put("areas", areas);//所有区
		list = tStudioMapper.findStudioBySearchs(param);
		return getCheckedData(list,param);
	}
	@Override
	public List<Map<String, Object>> getStudioByAreaTypeList(Map<String, Object> param) {
		list = tStudioMapper.findStudioBySearchs(param);
		return getCheckedData(list,param);
	}
	
	
	 
	/**
	* Title: getCheckedData
	* Description: 处理数据
	* @param list  全部数据
	* @param paramMap  页码，参数
	* @return
	* @author HuangJian
	* @date 2017年6月9日
	*/
	public List<Map<String, Object>> getCheckedData(List<Map<String, Object>> result,Map<String, Object> paramMap){
		List<Map<String, Object>> tt=new ArrayList<>();	//分页后的结果
		//数据处理
		List<Map<String, Object>> list=this.studioListDataLogic(result, paramMap);

		
		Integer pageNum = Integer.parseInt(String.valueOf(paramMap.get("pageNum")));
		
		UtilPage page =new UtilPage(ConstantVo.APP_PAGE_SIZE, list.size(), pageNum);
		if(list.size() >0 && pageNum <= page.getCurrentPage()){
			for(int i=page.getFromIndex();i<page.getToIndex();i++){
				tt.add(list.get(i));
			}
		} 
	
		return tt;
	}
	
	/**
	* Title: studioListDataLogic
	* Description: 场馆列表数据处理
	* @param result 场馆结果
	* @param param 参数集合
	* @return
	* @author HuangJian
	* @date 2017年6月15日
	*/
	public List<Map<String, Object>> studioListDataLogic(List<Map<String, Object>> list,Map<String, Object> param) {
		String userLng = "116.403820";
		String userLat = "39.915247";
		boolean isLatLng = true;
		double memPrice=0.0;
		if(!param.containsKey("lng") && !param.containsKey("lat")){
			isLatLng = false;
		}else{
			userLng = param.get("lng").toString();
			userLat = param.get("lat").toString();
		}
		Map<String, Object> paramMap=new HashMap<>();
		//会员价
		/*TConfigExample example = new TConfigExample();
	    Criteria cr =  example.createCriteria();
	    cr.andCnameEqualTo("STUDIO_MEMBER_PRICE").andStatEqualTo(1);
	    List<TConfig> cs = this.baseConfigMapper.selectByExample(example);
	    if(cs !=null){
	    	memPrice=Double.parseDouble(String.valueOf(cs.get(0).getCvalue()));
	    }*/
		//个人卡类型最低折扣
		double cardDis = cardTypeMapper.selectMinCardDiscount();
		memPrice = cardDis / 10;
	    DecimalFormat    df   = new DecimalFormat("######0.00");
	    temp=new HashMap<>();
	    Integer studioId = 0;
	    int activityCount = 0;
		for (int i = 0; i < list.size(); i++) {
			temp=list.get(i);
			memPrice = 0.88;//默认8.8折扣
			temp.put("memberDiscount", "8.8");
			Double consumeMoney = Double.parseDouble(String.valueOf(temp.get("consumeMoney")));
			String pro = df.format(memPrice * consumeMoney);
			int money = (int) Math.rint(Double.parseDouble(pro));//四舍五入取整
			//会员价 非会员价*折扣
			temp.put("memPrice", money);
			temp.put("consumeMoney", Math.rint(consumeMoney));
			String yzfCount="0";
			studioId = Integer.parseInt(String.valueOf(temp.get("studioId")));
			try {
				paramMap.put("studioId", temp.get("studioId"));
				yzfCount = studioConsumeOrderRecordMapper.appSelectOrderCountByStudioId(paramMap);
				if(yzfCount == null){
					yzfCount = "0";
				}
				temp.put("sellCount", yzfCount);//出售
			} catch (Exception e1) {
				temp.put("sellCount", yzfCount);
			}
			
			// 区id
			try {
				int regId = Integer.parseInt(String.valueOf(temp.get("regionsId")));
				regions = regionsMapper.getAreaByArea(regId);
				if(regions == null){
					temp.put("areaName", "暂无");//地区名称
				}else{
					temp.put("areaName", regions.getName());//地区名称
				}
			} catch (NumberFormatException e1) {
				temp.put("areaName", "暂无");
			}
			//计算经纬度
			if(isLatLng){
				try {
					String lng=String.valueOf(temp.get("lng"));
					String lat=String.valueOf(temp.get("lat"));
					if(!"null".equals(userLat) || null != userLat || !"".equals(userLat) && !"null".equals(userLng) || null != userLng || !"".equals(userLng)){
						temp.put("distance", MapDistance.getDistance(userLat, userLng, lat, lng));
					}else{
						temp.put("distance","0");
					}
				} catch (Exception e) {
					temp.put("distance","0");
				}
			}else{
				temp.put("distance","0");
			}
			
			//当前场馆活动总数
			//activityCount = appActivityService.getActivityCountBySutdioId(studioId);
			activityCount = 1;
			temp.put("activityCount", activityCount);
			
			if(param.containsKey("userId")){
				//是否是会员
				List<Map<String, Object>> isMem = tMemberMapper.findIsMemberById(param.get("userId").toString());
				if(isMem != null && isMem.size() > 0){
					//会员价
					temp.put("isVip",true);
				}else{
					//非会员价
					temp.put("isVip", false);
				}
			}else{
				//非会员价
				temp.put("isVip", false);
			}		
			list.set(i, temp);	
		}

		//是否需要排序  key存在就不需要排序
		if (param.containsKey("isOrder")) {
			//排序根据距离从近到远
			if(list != null && list.size() > 0){
				Collections.sort(list, new Comparator<Map<String, Object>>(){  
					  
		            public int compare(Map<String, Object> o1, Map<String, Object> o2) {  
		                try {
							if(o1.containsKey("distance") && o2.containsKey("distance")){
								if(Long.parseLong(o1.get("distance").toString()) > Long.parseLong(o2.get("distance").toString())){  
							        return 1;  
							    }  
							    if(Long.parseLong(o1.get("distance").toString()) == Long.parseLong(o2.get("distance").toString())){  
							        return 0;  
							    }  
							    return -1;  
							}else{
							}
						} catch (NumberFormatException e) {
							return 0;
						}
		                return 0;
		            	
		            }  
		        }); 
			}
		}
		
		//根据距离范围查询
		if(param.containsKey("distanceNum") && !"-1".equals(param.get("distanceNum"))){
			List<Map<String, Object>> disListMap=new ArrayList<>();
			if(list != null && list.size() > 0){
				for (Map<String, Object> map : list) {
					if(map.containsKey("distance") && param.containsKey("distanceNum")){
						if(Long.parseLong(map.get("distance").toString()) < Long.parseLong(param.get("distanceNum").toString())){
							disListMap.add(map);
						}
					}
					
				}
			}
			list = disListMap;
		}
		
		
		
		return list;
	}
	
	
	
	@Override
	public List<Map<String, Object>> findStudioByConsumeMoneyOrder(Map<String, Object> param) {
		List<Integer> areas = null;
		if(param.containsKey("city")){
			areas = regionsMapper.getAreaCodeByCityCode(param.get("city").toString());
			if(areas != null && areas.size() == 0){
				areas = null;
			}
		}else{
			
		}
		param.put("areas", areas);
		list = tStudioMapper.findStudioByConsumeMoneyOrder(param);
		param.put("isOrder", false);
		return getCheckedData(list,param);
	}
	@Override
	public List<Map<String, Object>> findStdioByMapModel(Map<String, Object> param) {
	// 
	/**
	 * key:pattern 0:分页返回场馆数据   1:不分页返回场馆
	 * lng,lat 经纬度
	 * studioType:
	 * 
	 */
		
		return null;
	}
	@Override
	public List<Map<String, Object>> findStudioNearbyData(Map<String, Object> param) {
		List<Map<String, Object>> areas = new ArrayList<>();
		if(param.containsKey("city")){
			//查询城市下所有的区
			areas = regionsMapper.findStudioNearbyData(param.get("city").toString());
			if(areas != null && areas.size() == 0){
				areas = null;
			}
		}
		/*String strCount = "0";
		Map<String, Object> typeMaps;
		Map<String, Object> result;
		List<Integer> areaCodeList= null;
		Map<String, Object> ps=new HashMap<>();
		List<Map<String, Object>> typesList;*/
		/*if(areas.size() > 0){
			for(int i =0;i<areas.size();i++){
				result = areas.get(i);
				areaCodeList = new ArrayList<Integer>();
				
				areaCodeList.add(Integer.parseInt(String.valueOf(result.get("code"))));
				typesList=new ArrayList<>();
				for(int j=0;j<typeNames.length;j++){
					typeMaps=new HashMap<>();
					//参数
					ps.put("typeId", j);
					ps.put("areas", areaCodeList);//区一个
					
					
					
					strCount = tStudioMapper.getStudioTypeCount(ps);
					typeMaps.put("typeId", j);
					typeMaps.put("typeName", typeNames[j]);
					typeMaps.put("count", strCount);
					typesList.add(typeMaps);
					
				}
				result.put("areaTypeCount", typesList);
				
			}
		}*/
		
		return areas;
	}
	@Override
	public List<Map<String, Object>> findStudioByPlatList(Map<String, Object> param) {
		List<Integer> areas= null;
		if(param.containsKey("city")){
			//有城市条件
			areas = regionsMapper.getAreaCodeByCityCode(String.valueOf(param.get("city")));
			if(areas != null && areas.size() == 0){
				areas=null;
			}
		}else{ 
			//没有城市
		}
		if(!param.containsKey("studioType") && "0".equals(param.get("studioType"))){
			param.put("studioType", null);
		}else{
			
		}
		String userLng = "116.403820";
		String userLat = "39.915247";
		param.put("areas", areas);
		List<Map<String, Object>> list=null;
		List<Map<String, Object>> list1=null;
	
		list = tStudioMapper.findStudioListApp(param);
		Map<String, Object> paramMap=new HashMap<>();
		boolean isLatLng = true;
		double memPrice=0.0;
		//个人卡类型最低折扣
		double cardDis = cardTypeMapper.selectMinCardDiscount();
		memPrice = cardDis / 10;
	    DecimalFormat    df   = new DecimalFormat("######0.00");
	    temp=new HashMap<>();
	    Integer studioId = 0;
	    int activityCount = 0;
		for (int i = 0; i < list.size(); i++) {
			temp=list.get(i);
			memPrice = 0.88;//默认8.8折扣
			temp.put("memberDiscount", "8.8");
			Double consumeMoney = Double.parseDouble(String.valueOf(temp.get("consumeMoney")));
			String pro = df.format(memPrice * consumeMoney);
			int money = (int) Math.rint(Double.parseDouble(pro));//四舍五入取整
			//会员价 非会员价*折扣
			temp.put("memPrice", money);
			temp.put("consumeMoney", Math.rint(consumeMoney));
			String yzfCount="0";
			studioId = Integer.parseInt(String.valueOf(temp.get("studioId")));
			//销售量
			temp.put("sellCount", "0");
			/*try {
				paramMap.put("studioId", temp.get("studioId"));
				yzfCount = studioConsumeOrderRecordMapper.appSelectOrderCountByStudioId(paramMap);
				if(yzfCount == null){
					yzfCount = "0";
				}
				temp.put("sellCount", yzfCount);//出售
			} catch (Exception e1) {
				temp.put("sellCount", yzfCount);
			}*/

			//计算经纬度
			if(isLatLng){
				try {
					String lng=String.valueOf(temp.get("lng"));
					String lat=String.valueOf(temp.get("lat"));
					if(!"null".equals(userLat) || null != userLat || !"".equals(userLat) && !"null".equals(userLng) || null != userLng || !"".equals(userLng)){
						temp.put("distance", MapDistance.getDistance(userLat, userLng, lat, lng));
					}else{
						temp.put("distance","0");
					}
				} catch (Exception e) {
					temp.put("distance","0");
				}
			}else{
				temp.put("distance","0");
			}
			
			//当前场馆活动总数
			//activityCount = appActivityService.getActivityCountBySutdioId(studioId);
			activityCount = 1;
			temp.put("activityCount", activityCount);
			
			if(param.containsKey("userId")){
				//是否是会员
				List<Map<String, Object>> isMem = tMemberMapper.findIsMemberById(param.get("userId").toString());
				if(isMem != null && isMem.size() > 0){
					//会员价
					temp.put("isVip",true);
				}else{
					//非会员价
					temp.put("isVip", false);
				}
			}else{
				//非会员价
				temp.put("isVip", false);
			}		
			list.set(i, temp);
			
			
			
			
		}
		
		
		return list;
	}
}

