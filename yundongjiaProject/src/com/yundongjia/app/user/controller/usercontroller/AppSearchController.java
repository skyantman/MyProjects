/**
* @author HuangJian
* @date 2017年6月8日
*/
package com.yundongjia.app.user.controller.usercontroller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yundongjia.app.user.service.AppRegionsService;
import com.yundongjia.app.user.service.AppStudioService;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.utils.UtilPage;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
* Title: com.yundongjia.app.user.controller.usercontroller 
* Description: 搜索接口
* @author HuangJian
* @date 2017年6月9日
*/
@Controller
public class AppSearchController extends BaseController{

	@Autowired
	private AppStudioService appStudioService;
	@Autowired
	private AppRegionsService appRegionsService;
	/**
	* Title: searchPage
	* Description: 搜索接口
	* @param str
	* @throws Exception
	* @author HuangJian
	* @date 2017年6月8日
	*/
	@RequestMapping(value = "ydj/user/search")
	public void searchPage(String str) throws Exception {
		String pageNum = "1";
		String studioType="1";
		String areaCode = "110102";
		Map<String, Object> map = this.RSAprivatedecode(str);
		Integer type = Integer.parseInt(map.get("type").toString());
		
		List<Map<String, Object>> list;
		Map<String, Object> param;
		switch (type) {
		case 0://搜索 全部 列出所有类型及总数
			jsonclear();
			list = new ArrayList<>();
			//String areaId = map.get("areaId").toString();
			//if(map.containsKey("city") && )
			list =  appStudioService.getStudioTypeCount(map);
			
			try {
				for (Map<String, Object> map2 : list) {
					jsonObject2.put("typeId", map2.get("typeId"));
					jsonObject2.put("typeName", map2.get("typeName"));
					jsonObject2.put("count", map2.get("count"));
					jsonArray.add(jsonObject2);
				}
				jsonObject.put("types", jsonArray);
				jsonObject.put("status", "0");
				jsonObject.put("message", "查询成功");
			} catch (Exception e) {
				jsonObject.put("status", "1");
				jsonObject.put("message", "查询失败");
			}finally{
				this.RSAprivateencode(jsonObject.toString());
			}
			break;
		case 1://附近数据，每个区和每个区的总数 
			try {
				jsonclear();
				list = appStudioService.findStudioNearbyData(map);
				JSONObject jsonObject3 = new JSONObject();
				JSONArray jsonArray3=new JSONArray();
				//附近数据
				JSONObject nearbyObj = new JSONObject();
				nearbyObj.put("areaCode", "-1");
				nearbyObj.put("areaName", "附近");
				JSONArray disArray=new JSONArray();
				
				JSONObject disObj_n4=new JSONObject();
				disObj_n4.put("typeId", "-1");
				disObj_n4.put("typeName", "附近(智能排序)");
				//disObj_n4.put("count", "0");
				disArray.add(disObj_n4);
				
				JSONObject disObj=new JSONObject();
				disObj.put("typeId", "500");
				disObj.put("typeName", "500米");
				//disObj.put("count", "0");
				disArray.add(disObj);
				
				JSONObject disObj_d1=new JSONObject();
				disObj_d1.put("typeId", "1000");
				disObj_d1.put("typeName", "1000米");
				//disObj_d1.put("count", "0");
				disArray.add(disObj_d1);
				
				JSONObject disObj_d2=new JSONObject();
				disObj_d2.put("typeId", "2000");
				disObj_d2.put("typeName", "2000米");
				//disObj_d2.put("count", "0");
				disArray.add(disObj_d2);
				
				JSONObject disObj_d3=new JSONObject();
				disObj_d3.put("typeId", "5000");
				disObj_d3.put("typeName", "5000米");
				//disObj_d3.put("count", "0");
				disArray.add(disObj_d3);
				
				nearbyObj.put("typeCounts", disArray);
				jsonArray.add(nearbyObj);
				for (Map<String, Object> map2 : list) {
					jsonObject.put("areaCode", map2.get("code"));
					jsonObject.put("areaName", map2.get("name"));
					/*jsonArray3.clear();
					List<Map<String, Object>> list2 =  (List<Map<String, Object>>) map2.get("areaTypeCount");
					for (Map<String, Object> map3 : list2) {
						jsonObject3.clear();
						
						jsonObject3.put("typeId",map3.get("typeId"));
						jsonObject3.put("typeName",map3.get("typeName"));
						jsonObject3.put("count",map3.get("count"));
						jsonArray3.add(jsonObject3);
					}*/
					jsonObject.put("typeCounts", jsonArray3);
					jsonArray.add(jsonObject);
				}
				jsonObject2.put("dic", jsonArray);
				jsonObject2.put("status", "0");
				jsonObject2.put("message", "查询成功");
			} catch (Exception e) {
				jsonObject2.put("status", "1");
				jsonObject2.put("message", "查询失败");
			}finally {
				this.RSAprivateencode(jsonObject2.toString());
			}
			break;
		case 2://全部-根据类型查询  //城市查询                    暂时和 3 不一样
			jsonclear();
			//param = new HashMap<>();
			//页码 
			//pageNum  = map.get("pageNum").toString();
			//场馆类型
			//studioType = map.get("studioType").toString();
			
			/*param.put("studioType", studioType);
			param.put("pageNum", pageNum);
			param.put("flag", 1);
			if(map.containsKey("city")){
				param.put("city", map.get("city"));
			}*/
			map.put("flag",1);
			list = appStudioService.getStudioByTypeList(map);
			this.getJsonObjStudioSearchList(list,map);

			break;
		case 3://附近-根据地区和类型查询
			jsonclear();
			//param = new HashMap<>();
			//页码 
			//pageNum  = map.get("pageNum").toString();
			//地区
			//areaCode = map.get("areaId").toString();
			//场馆类型
			//studioType = map.get("studioType").toString();
			
			/*param.put("studioType", studioType);
			param.put("pageNum", pageNum);
			param.put("areaId", areaCode);
			param.put("flag", 2);
			if(map.containsKey("city")){
				param.put("city", map.get("city"));
			}*/

			
			//需要按距离排序 map.containsKey("distanceNum") && !"-1".equals(map.get("distanceNum"))   || 
			if(map.containsKey("orderType") && "5".equals(map.get("orderType")) || "-1".equals(map.get("orderType"))){
				map.put("isOrder",true);//排序
			}else{
				//不需要排序
			}
			
			
			list = appStudioService.getStudioByTypeList(map);
			this.getJsonObjStudioSearchList(list,map);
			
			break;
		case 4://智能排序
			//标识符 2价格最低，3价格最高，4好评优先，5离我最近
			String orderType = map.get("orderType").toString();
			//页码 
			pageNum  = map.get("pageNum").toString();
			switch (orderType) {
			case "1":
				
				break;
			case "2"://价格最低
				//param = new HashMap<>();
				map.put("orderFlag", 0);
				//map.put("pageNum", pageNum);
				map.put("typeColumn", 0);//价格排序
				list = appStudioService.findStudioByConsumeMoneyOrder(map);
				this.getJsonObjStudioSearchList(list,map);
				break;
			case "3"://价格最高
				//param = new HashMap<>();
				map.put("orderFlag", 1);
				//param.put("pageNum", pageNum);
				map.put("typeColumn", 0);//价格排序
				list = appStudioService.findStudioByConsumeMoneyOrder(map);
				this.getJsonObjStudioSearchList(list,map);
				break;
			case "4"://好评优先
				//param = new HashMap<>();
				//param.put("pageNum", pageNum);
				map.put("typeColumn", 1);//评分排序
				list = appStudioService.findStudioByConsumeMoneyOrder(map);
				this.getJsonObjStudioSearchList(list,map);
				break;				
			case "5"://离我最近
					List<Map<String, Object>> pageMap=new ArrayList<>();
					//param = new HashMap<>();
					//param.put("pageNum", pageNum);
					map.put("isOrder", true);//排序
					list = appStudioService.findStudioList(map);
					
					/*if(list != null && list.size() > 0){
						//排序根据距离从近到远
						if(list != null && list.size() > 0){
							Collections.sort(list, new Comparator<Map<String, Object>>(){  
								  
					            public int compare(Map<String, Object> o1, Map<String, Object> o2) {  
					            	
					                if(Long.parseLong(o1.get("distance").toString()) > Long.parseLong(o2.get("distance").toString())){  
					                    return 1;  
					                }  
					                if(Long.parseLong(o1.get("distance").toString()) == Long.parseLong(o2.get("distance").toString())){  
					                    return 0;  
					                }  
					                return -1;  
					            }  
					        }); 
						}
					}*/
					
					
					Integer intPageNum=Integer.parseInt(pageNum);
					UtilPage page =new UtilPage(ConstantVo.APP_PAGE_SIZE, list.size(), Integer.parseInt(pageNum));
					if(list.size() >0 && intPageNum <= page.getCurrentPage()){
						for(int i=page.getFromIndex();i<page.getToIndex();i++){
							pageMap.add(list.get(i));
						}
					}
					this.getJsonObjStudioSearchList(pageMap,map);
				 
				
			default:
				break;
			}
			
			break;
			
		case 5:// 地图模式加载场馆
			String pattern = map.get("pattern").toString();//0 分页，1不分页
			List<Map<String, Object>> mapList=new ArrayList<>();
			//map.put("isOrder", true);
			//mapList = appStudioService.findStudioList(map);
			double longitude = Double.parseDouble(map.get("lng").toString());
			double latitude = Double.parseDouble(map.get("lat").toString());
			double distance = 1.5;
			Map<String, double[]> posi =  returnLLSquarePoint(longitude, latitude, distance);
			map.put("position", posi);
			mapList = appStudioService.findStudioByPlatList(map);
			if("0".equals(pattern.trim())){
				/*List<Map<String, Object>> pageResultMap=new ArrayList<>();
				Integer intPageNum = 1;
				//分页
				UtilPage page =new UtilPage(ConstantVo.APP_MAP_MODEL_PAGE_SIZE, mapList.size(), intPageNum);
				if(mapList.size() >0 && intPageNum <= page.getCurrentPage()){
					for(int i=page.getFromIndex();i<page.getToIndex();i++){
						pageResultMap.add(mapList.get(i));
					}
				}*/
				this.getJsonObjStudioSearchList(mapList,map);
			}else{
				//一次性返回所有数据
				this.getJsonObjStudioSearchList(mapList,map);
			}
				
			/*try {
				for (Map<String, Object> map2 : mapList) {
					jsonObject.put("studioId", map2.get("studioId"));
					jsonObject.put("lng", map2.get("lng"));
					jsonObject.put("lat", map2.get("lat"));
					
					jsonArray.add(jsonObject);
				}
				jsonObject2.put("studios", jsonArray);
				jsonObject2.put("status", "0");
				jsonObject2.put("message", "查询成功");
			} catch (Exception e1) {
				jsonObject2.put("status", "1");
				jsonObject2.put("message", "查询失败");
				jsonObject2.put("studios", new JSONArray());
			}finally {
				this.RSAprivateencode(jsonObject2.toString());
			}*/
			
			
			break;
		case 6://模糊查询城市名称，返回code,name
			 try {
				 jsonclear();
				 String cityName =  map.get("cityName").toString();
				 list = appRegionsService.findCityByCityName(cityName);
				 if(list != null && list.size() > 0){
					 for (Map<String, Object> map2 : list) {
						 jsonObject.put("code", map2.get("code"));
						 jsonObject.put("city", map2.get("name"));
						 jsonArray.add(jsonObject);
					 }  
					 jsonObject2.put("citys", jsonArray);
					 jsonObject2.put("status", "0");
					 jsonObject2.put("message", "查询成功");
				 }else{
					 jsonObject2.put("status", "1");
					 jsonObject2.put("message", "没有查询到结果");
					 jsonObject2.put("citys", jsonArray);
				 }
				 
			} catch (Exception e) {
				jsonObject2.put("status", "1");
				jsonObject2.put("message", "查询失败");
			}finally {
				this.RSAprivateencode(jsonObject2.toString());
			}
			break;
		default:
			break;
		}
		
	}
	
	
	public void getJsonObjStudioSearchList(List<Map<String, Object>> list,Map<String, Object> paramMap){
		jsonclear();
		
		try {
			if(paramMap.containsKey("city") && "-1".equals(paramMap.get("city"))){
				jsonObject2.put("status", "1");
				jsonObject2.put("message", "城市暂未开通");
				jsonObject2.put("studios", new JSONArray());
			}else{
				try {
					JSONObject jsonObject3 = new JSONObject();
					DecimalFormat    df   = new DecimalFormat("######0.0");   
					for (Map<String, Object> temp : list) {
						if(StringUtils.isEmpty(temp.get("lng")+"") || StringUtils.isEmpty(temp.get("lat")+"")){
							continue;
						}
						jsonArray2.clear();
						jsonObject3.clear();
						jsonObject.clear();
						
						jsonObject.put("studioId", temp.get("studioId"));
						jsonObject.put("studioName", temp.get("studioName"));
						jsonObject.put("sellCount", temp.get("sellCount")==null?0:temp.get("sellCount"));// 销售人数
						jsonObject.put("areaName", temp.get("areaName"));
						jsonObject.put("path", temp.get("path"));
						jsonObject.put("consumeMoney", temp.get("consumeMoney"));// 非会员价
						jsonObject.put("memPrice", temp.get("memPrice"));// 会员价
						jsonObject.put("distance", temp.get("distance"));
						jsonObject.put("activityCount", temp.get("activityCount"));//场馆活动总数
						jsonObject.put("memberDiscount", temp.get("memberDiscount"));//会员折扣默认8.8折
						
						jsonObject.put("gradeScore", df.format(Double.parseDouble(temp.get("gradeScore").toString())));//评分
						jsonObject.put("lng", temp.get("lng"));
						jsonObject.put("lat", temp.get("lat"));
						jsonObject.put("type", Integer.parseInt(String.valueOf(temp.get("type"))));
						jsonObject.put("studioAddr", temp.get("studioAddr"));//地址
						jsonObject.put("isVip", temp.get("isVip"));
						jsonObject3.put("iconPath", "/images/studioIcon/v@3x.png");
						jsonObject3.put("iconValue", "会员卡"+temp.get("memberDiscount")+"折");
						jsonArray2.add(jsonObject3);
						jsonObject.put("icon", jsonArray2);
						
						
						jsonArray.add(jsonObject);
					}
					jsonObject2.put("studios", jsonArray);
					jsonObject2.put("status", "0");
					jsonObject2.put("message", "查询成功");
				} catch (Exception e) {
					jsonObject2.put("status", "1");
					jsonObject2.put("message", "查询失败");
					jsonObject2.put("studios", new JSONArray());
				}finally{
					
				}
				
				
			}
		} catch (Exception e) {
			
		}finally{
			this.RSAprivateencode(jsonObject2.toString());
		}

		
		
		
	}
	
	 /**
     * 默认地球半径
     */
    private static double EARTH_RADIUS = 6371;

    /**
     *计算某个经纬度的周围某段距离的正方形的四个点
     *
     *@param lng float 经度
     *@param lat float 纬度
     *@param distance float 该点所在圆的半径，该圆与此正方形内切，默认值为0.5千米
     *@return array 正方形的四个点的经纬度坐标
     */
    public static Map<String, double[]> returnLLSquarePoint(double longitude,
            double latitude, double distance) {
        Map<String, double[]> squareMap = new HashMap<String, double[]>();
        // 计算经度弧度,从弧度转换为角度
        double dLongitude = 2 * (Math.asin(Math.sin(distance
                / (2 * EARTH_RADIUS))
                / Math.cos(Math.toRadians(latitude))));
        dLongitude = Math.toDegrees(dLongitude);
        // 计算纬度角度
        double dLatitude = distance / EARTH_RADIUS;
        dLatitude = Math.toDegrees(dLatitude);
        // 正方形
        double[] leftTopPoint = { latitude + dLatitude, longitude - dLongitude };
        double[] rightTopPoint = { latitude + dLatitude, longitude + dLongitude };
        double[] leftBottomPoint = { latitude - dLatitude,
                longitude - dLongitude };
        double[] rightBottomPoint = { latitude - dLatitude,
                longitude + dLongitude };
        squareMap.put("leftTopPoint", leftTopPoint);
        squareMap.put("rightTopPoint", rightTopPoint);
        squareMap.put("leftBottomPoint", leftBottomPoint);
        squareMap.put("rightBottomPoint", rightBottomPoint);
        return squareMap;
    }
	
	
}

