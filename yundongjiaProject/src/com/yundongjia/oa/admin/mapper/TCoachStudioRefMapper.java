package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TCoachStudioRef;
import com.yundongjia.oa.admin.po.TCoachStudioRefExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCoachStudioRefMapper {
    int countByExample(TCoachStudioRefExample example);

    int deleteByExample(TCoachStudioRefExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TCoachStudioRef record);

    int insertSelective(TCoachStudioRef record);

    List<TCoachStudioRef> selectByExample(TCoachStudioRefExample example);

    TCoachStudioRef selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TCoachStudioRef record, @Param("example") TCoachStudioRefExample example);

    int updateByExample(@Param("record") TCoachStudioRef record, @Param("example") TCoachStudioRefExample example);

    int updateByPrimaryKeySelective(TCoachStudioRef record);

    int updateByPrimaryKey(TCoachStudioRef record);
}