package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TEnterpriseLogin;
import com.yundongjia.oa.admin.po.TEnterpriseLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TEnterpriseLoginMapper {
    int countByExample(TEnterpriseLoginExample example);

    int deleteByExample(TEnterpriseLoginExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TEnterpriseLogin record);

    int insertSelective(TEnterpriseLogin record);

    List<TEnterpriseLogin> selectByExample(TEnterpriseLoginExample example);

    TEnterpriseLogin selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TEnterpriseLogin record, @Param("example") TEnterpriseLoginExample example);

    int updateByExample(@Param("record") TEnterpriseLogin record, @Param("example") TEnterpriseLoginExample example);

    int updateByPrimaryKeySelective(TEnterpriseLogin record);

    int updateByPrimaryKey(TEnterpriseLogin record);
}