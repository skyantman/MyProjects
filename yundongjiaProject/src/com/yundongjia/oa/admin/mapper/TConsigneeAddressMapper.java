package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TConsigneeAddress;
import com.yundongjia.oa.admin.po.TConsigneeAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TConsigneeAddressMapper {
    int countByExample(TConsigneeAddressExample example);

    int deleteByExample(TConsigneeAddressExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TConsigneeAddress record);

    int insertSelective(TConsigneeAddress record);

    List<TConsigneeAddress> selectByExample(TConsigneeAddressExample example);

    TConsigneeAddress selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TConsigneeAddress record, @Param("example") TConsigneeAddressExample example);

    int updateByExample(@Param("record") TConsigneeAddress record, @Param("example") TConsigneeAddressExample example);

    int updateByPrimaryKeySelective(TConsigneeAddress record);

    int updateByPrimaryKey(TConsigneeAddress record);
}