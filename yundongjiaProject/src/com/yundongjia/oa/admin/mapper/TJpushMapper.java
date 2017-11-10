package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TJpush;
import com.yundongjia.oa.admin.po.TJpushExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TJpushMapper {
    int countByExample(TJpushExample example);

    int deleteByExample(TJpushExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TJpush record);

    int insertSelective(TJpush record);

    List<TJpush> selectByExample(TJpushExample example);

    TJpush selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TJpush record, @Param("example") TJpushExample example);

    int updateByExample(@Param("record") TJpush record, @Param("example") TJpushExample example);

    int updateByPrimaryKeySelective(TJpush record);

    int updateByPrimaryKey(TJpush record);
}