package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TPrivateLessonTime;
import com.yundongjia.oa.admin.po.TPrivateLessonTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPrivateLessonTimeMapper {
    int countByExample(TPrivateLessonTimeExample example);

    int deleteByExample(TPrivateLessonTimeExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TPrivateLessonTime record);

    int insertSelective(TPrivateLessonTime record);

    List<TPrivateLessonTime> selectByExample(TPrivateLessonTimeExample example);

    TPrivateLessonTime selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TPrivateLessonTime record, @Param("example") TPrivateLessonTimeExample example);

    int updateByExample(@Param("record") TPrivateLessonTime record, @Param("example") TPrivateLessonTimeExample example);

    int updateByPrimaryKeySelective(TPrivateLessonTime record);

    int updateByPrimaryKey(TPrivateLessonTime record);
}