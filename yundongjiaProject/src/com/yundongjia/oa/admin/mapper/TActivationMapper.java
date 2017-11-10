package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TActivation;
import com.yundongjia.oa.admin.po.TActivationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TActivationMapper {
    int countByExample(TActivationExample example);

    int deleteByExample(TActivationExample example);

    int deleteByPrimaryKey(Integer activationid);

    int insert(TActivation record);

    int insertSelective(TActivation record);

    List<TActivation> selectByExample(TActivationExample example);

    TActivation selectByPrimaryKey(Integer activationid);

    int updateByExampleSelective(@Param("record") TActivation record, @Param("example") TActivationExample example);

    int updateByExample(@Param("record") TActivation record, @Param("example") TActivationExample example);

    int updateByPrimaryKeySelective(TActivation record);

    int updateByPrimaryKey(TActivation record);
}