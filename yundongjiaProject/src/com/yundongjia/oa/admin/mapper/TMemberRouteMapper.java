package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TMemberRoute;
import com.yundongjia.oa.admin.po.TMemberRouteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMemberRouteMapper {
    int countByExample(TMemberRouteExample example);

    int deleteByExample(TMemberRouteExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TMemberRoute record);

    int insertSelective(TMemberRoute record);

    List<TMemberRoute> selectByExample(TMemberRouteExample example);

    TMemberRoute selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TMemberRoute record, @Param("example") TMemberRouteExample example);

    int updateByExample(@Param("record") TMemberRoute record, @Param("example") TMemberRouteExample example);

    int updateByPrimaryKeySelective(TMemberRoute record);

    int updateByPrimaryKey(TMemberRoute record);
}