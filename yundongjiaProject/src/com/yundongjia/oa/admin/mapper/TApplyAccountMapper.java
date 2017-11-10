package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TApplyAccount;
import com.yundongjia.oa.admin.po.TApplyAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TApplyAccountMapper {
    int countByExample(TApplyAccountExample example);

    int deleteByExample(TApplyAccountExample example);

    int deleteByPrimaryKey(Integer rowdid);

    int insert(TApplyAccount record);

    int insertSelective(TApplyAccount record);

    List<TApplyAccount> selectByExample(TApplyAccountExample example);

    TApplyAccount selectByPrimaryKey(Integer rowdid);

    int updateByExampleSelective(@Param("record") TApplyAccount record, @Param("example") TApplyAccountExample example);

    int updateByExample(@Param("record") TApplyAccount record, @Param("example") TApplyAccountExample example);

    int updateByPrimaryKeySelective(TApplyAccount record);

    int updateByPrimaryKey(TApplyAccount record);
}