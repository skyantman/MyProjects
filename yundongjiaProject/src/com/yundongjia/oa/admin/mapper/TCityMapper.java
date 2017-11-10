package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TCity;
import com.yundongjia.oa.admin.po.TCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCityMapper {
    int countByExample(TCityExample example);

    int deleteByExample(TCityExample example);

    int deleteByPrimaryKey(Integer cityid);

    int insert(TCity record);

    int insertSelective(TCity record);

    List<TCity> selectByExample(TCityExample example);

    TCity selectByPrimaryKey(Integer cityid);

    int updateByExampleSelective(@Param("record") TCity record, @Param("example") TCityExample example);

    int updateByExample(@Param("record") TCity record, @Param("example") TCityExample example);

    int updateByPrimaryKeySelective(TCity record);

    int updateByPrimaryKey(TCity record);
}