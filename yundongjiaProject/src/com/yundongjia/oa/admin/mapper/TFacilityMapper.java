package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TFacility;
import com.yundongjia.oa.admin.po.TFacilityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFacilityMapper {
    int countByExample(TFacilityExample example);

    int deleteByExample(TFacilityExample example);

    int deleteByPrimaryKey(Integer facilityid);

    int insert(TFacility record);

    int insertSelective(TFacility record);

    List<TFacility> selectByExample(TFacilityExample example);

    TFacility selectByPrimaryKey(Integer facilityid);

    int updateByExampleSelective(@Param("record") TFacility record, @Param("example") TFacilityExample example);

    int updateByExample(@Param("record") TFacility record, @Param("example") TFacilityExample example);

    int updateByPrimaryKeySelective(TFacility record);

    int updateByPrimaryKey(TFacility record);
}