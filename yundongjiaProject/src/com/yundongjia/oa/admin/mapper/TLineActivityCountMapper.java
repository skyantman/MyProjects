package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TLineActivityCount;
import com.yundongjia.oa.admin.po.TLineActivityCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLineActivityCountMapper {
    int countByExample(TLineActivityCountExample example);

    int deleteByExample(TLineActivityCountExample example);

    int deleteByPrimaryKey(Integer lineid);

    int insert(TLineActivityCount record);

    int insertSelective(TLineActivityCount record);

    List<TLineActivityCount> selectByExample(TLineActivityCountExample example);

    TLineActivityCount selectByPrimaryKey(Integer lineid);

    int updateByExampleSelective(@Param("record") TLineActivityCount record, @Param("example") TLineActivityCountExample example);

    int updateByExample(@Param("record") TLineActivityCount record, @Param("example") TLineActivityCountExample example);

    int updateByPrimaryKeySelective(TLineActivityCount record);

    int updateByPrimaryKey(TLineActivityCount record);
}