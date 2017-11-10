package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TStudio;
import com.yundongjia.oa.admin.po.TStudioExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TStudioMapper {
	int countByExample(TStudioExample example);

	int deleteByExample(TStudioExample example);

	int deleteByPrimaryKey(Integer studioid);

	int insert(TStudio record);

	int insertSelective(TStudio record);

	List<TStudio> selectByExample(TStudioExample example);

	TStudio selectByPrimaryKey(Integer studioid);

	int updateByExampleSelective(@Param("record") TStudio record, @Param("example") TStudioExample example);

	int updateByExample(@Param("record") TStudio record, @Param("example") TStudioExample example);

	int updateByPrimaryKeySelective(TStudio record);

	int updateByPrimaryKey(TStudio record);

	/**
	 * Title: findStudioList Description: 全查，或条件查询
	 * 
	 * @param param
	 * @return
	 * @author HuangJian
	 * @date 2017年2月4日
	 */
	List<Map<String, Object>> findStudioList(TStudio studio);

	/**
	 * Title: selectStudioById Description: 详情
	 * 
	 * @param studioId
	 * @return
	 * @author HuangJian
	 * @date 2017年2月4日
	 */
	List<Map<String, Object>> selectStudioById(@Param("studioId") Integer studioId);

	/**
	 * Title: selectStatisByStudioStatus Description: 根据不同的状态统计
	 * 
	 * @param status
	 * @return
	 * @author HuangJian
	 * @date 2017年2月4日
	 */
	public Integer selectStatisByStudioStatus(@Param("status") Integer status);

	/**
	 * Title: getStudioByCoachId Description: 根据教练查询场馆
	 * 
	 * @param coachId
	 * @return
	 * @author HuangJian
	 * @date 2017年2月6日
	 */
	public List<Map<String, Object>> getStudioByCoachId(@Param("coachId") Integer coachId);

	/**
	 * Title: appFindStudioList Description: 加载场馆和首页图
	 * 
	 * @param param
	 * @return
	 * @author HuangJian
	 * @date 2017年2月14日
	 */
	List<Map<String, Object>> findStudioListApp(@Param("param") Map<String, Object> param);
	
	/**
	* Title: selectStudioByIdApp
	* Description:  根据场馆ID查询
	* @param studioId 场馆ID
	* @return
	* @author HuangJian
	* @date 2017年2月15日
	*/
	Map<String, Object> selectStudioByIdApp(Integer studioId);
	
	/**
	* Title: getStudentTypeCount
	* Description: 根据场馆类型统计
	* @param typeId
	* @return
	* @author HuangJian
	* @date 2017年6月8日
	*/
	String getStudioTypeCount(@Param("param") Map<String, Object> param);
	
	/**
	* Title: getStudeioByAreaCount
	* Description: 根据区统计类型个数
	* @param areaId
	* @return
	* @author HuangJian
	* @date 2017年6月8日
	*/
	String getStudeioByAreaCount(@Param("param") Map<String, Object> param);
	
	/**
	* Title: findStudioBySearchs
	* Description: 多条件查询  
	* 1：根据场馆类型查询
	* 
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年6月8日
	*/
	List<Map<String, Object>> findStudioBySearchs(@Param("param") Map<String, Object> param);
	
	/**
	* Title: findStudioByConsumeMoneyOrder
	* Description: 根据场馆原价价格排序
	* @param order:asc , desc
	* @return
	* @author HuangJian
	* @date 2017年6月9日
	*/
	List<Map<String, Object>> findStudioByConsumeMoneyOrder(@Param("param") Map<String, Object> param);
}