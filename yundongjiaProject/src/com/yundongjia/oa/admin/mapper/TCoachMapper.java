package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TCoach;
import com.yundongjia.oa.admin.po.TCoachExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TCoachMapper {
    int countByExample(TCoachExample example);

    int deleteByExample(TCoachExample example);

    int deleteByPrimaryKey(Integer coachid);

    int insert(TCoach record);

    int insertSelective(TCoach record);

    List<TCoach> selectByExample(TCoachExample example);

    TCoach selectByPrimaryKey(Integer coachid);

    int updateByExampleSelective(@Param("record") TCoach record, @Param("example") TCoachExample example);

    int updateByExample(@Param("record") TCoach record, @Param("example") TCoachExample example);

    int updateByPrimaryKeySelective(TCoach record);

    int updateByPrimaryKey(TCoach record);
    
    /**
    * Title: findCoachListLMap
    * Description: 全查或条件查询
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月6日
    */
    List<Map<String, Object>> findCoachListLMap(@Param("param") Map<String, Object> param);
    
    /**
    * Title: getCoachById
    * Description: 详情
    * @param coachId
    * @return
    * @author HuangJian
    * @date 2017年2月6日
    */
    List<Map<String, Object>> getCoachById(@Param("coachId") Integer coachId);
    
    /**
    * Title: selectStatisByCoach
    * Description: 根据状态统计
    * @param status
    * @return
    * @author HuangJian
    * @date 2017年2月6日
    */
    Integer selectStatisByCoach(@Param("status") Integer status);
    
    /**
    * Title: findAppCoachList
    * Description: APP   教练列表
    * @return
    * @author HuangJian
    * @date 2017年2月15日
    */
    List<Map<String, Object>> findAppCoachList(@Param("param") Map<String, Object> param);
    
    /**
    * Title: selectAppCoachById
    * Description: 根据教练ID查询
    * @param coachId
    * @return
    * @author HuangJian
    * @date 2017年2月15日
    */
    Map<String, Object> selectAppCoachById(Integer coachId);
}