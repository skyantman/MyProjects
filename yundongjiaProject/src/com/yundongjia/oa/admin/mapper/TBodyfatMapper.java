package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TBodyfat;
import com.yundongjia.oa.admin.po.TBodyfatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBodyfatMapper {
    int countByExample(TBodyfatExample example);

    int deleteByExample(TBodyfatExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TBodyfat record);

    int insertSelective(TBodyfat record);

    List<TBodyfat> selectByExample(TBodyfatExample example);

    TBodyfat selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TBodyfat record, @Param("example") TBodyfatExample example);

    int updateByExample(@Param("record") TBodyfat record, @Param("example") TBodyfatExample example);

    int updateByPrimaryKeySelective(TBodyfat record);

    int updateByPrimaryKey(TBodyfat record);
}