package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TCoachSkillRef;
import com.yundongjia.oa.admin.po.TCoachSkillRefExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TCoachSkillRefMapper {
    int countByExample(TCoachSkillRefExample example);

    int deleteByExample(TCoachSkillRefExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TCoachSkillRef record);

    int insertSelective(TCoachSkillRef record);

    List<TCoachSkillRef> selectByExample(TCoachSkillRefExample example);

    TCoachSkillRef selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TCoachSkillRef record, @Param("example") TCoachSkillRefExample example);

    int updateByExample(@Param("record") TCoachSkillRef record, @Param("example") TCoachSkillRefExample example);

    int updateByPrimaryKeySelective(TCoachSkillRef record);

    int updateByPrimaryKey(TCoachSkillRef record);
    
    /**
    * Title: findSkillRefByCoachId
    * Description: 根据教练ID查询擅长课程
    * @param coachId
    * @return
    * @author HuangJian
    * @date 2017年2月6日
    */
    List<Map<String, Object>> findSkillRefByCoachId(@Param("coachId") Integer coachId);
    
    /**
    * Title: getCoachByStudioId
    * Description: 根据场馆Id查询教练
    * @param studioId
    * @return
    * @author HuangJian
    * @date 2017年6月7日
    */
    List<Map<String, Object>> getCoachByStudioId(Integer studioId);
}