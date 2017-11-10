package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TActivity;
import com.yundongjia.oa.admin.po.TActivityExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TActivityMapper {
    int countByExample(TActivityExample example);

    int deleteByExample(TActivityExample example);

    int deleteByPrimaryKey(Integer activeid);

    int insert(TActivity record);

    int insertSelective(TActivity record);

    List<TActivity> selectByExample(TActivityExample example);

    TActivity selectByPrimaryKey(Integer activeid);

    int updateByExampleSelective(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByExample(@Param("record") TActivity record, @Param("example") TActivityExample example);

    int updateByPrimaryKeySelective(TActivity record);

    int updateByPrimaryKey(TActivity record);
    
    /**
    * Title: findActivityList
    * Description: 全查
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年1月20日
    */
    List<Map<String, Object>> findActivityList(@Param("param") TActivity param);
    
    /**
    * Title: getActivityById
    * Description: 根据id查询活动
    * @param id
    * @return
    * @author HuangJian
    * @date 2017年1月20日
    */
    List<Map<String, Object>> getActivityById(@Param("param") Integer id);
    
    /**
    * Title: selectByActivity
    * Description: 条件查询
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月3日
    */
    List<Map<String, Object>> selectByActivity(TActivity param);
    
    /**
    * Title: updateActivityStatusById
    * Description: 修改活动状态
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月3日
    */
    Integer updateActivityStatusById(Map<String, Object> param);
    
    /**
    * Title: selectActivityStatisByStatus
    * Description: 根据状态统计活动
    * @param status
    * @return
    * @author HuangJian
    * @date 2017年2月3日
    */
    Integer selectActivityStatisByStatus(@Param("status") Integer status);
    
    /**
    * Title: selectTodayActivityStatis
    * Description: 统计今日活动数
    * @return
    * @author HuangJian
    * @date 2017年2月3日
    */
    Integer selectTodayActivityStatis();
    /**
	 * @param format
	 * @return根据日期查询活动列表
	 */
	List<Map<String, Object>> findListByDate(String date);
    
	
}