package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TSupplierLogin;
import com.yundongjia.oa.admin.po.TSupplierLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSupplierLoginMapper {
    int countByExample(TSupplierLoginExample example);

    int deleteByExample(TSupplierLoginExample example);

    int deleteByPrimaryKey(Integer supplierloginid);

    int insert(TSupplierLogin record);

    int insertSelective(TSupplierLogin record);

    List<TSupplierLogin> selectByExample(TSupplierLoginExample example);

    TSupplierLogin selectByPrimaryKey(Integer supplierloginid);

    int updateByExampleSelective(@Param("record") TSupplierLogin record, @Param("example") TSupplierLoginExample example);

    int updateByExample(@Param("record") TSupplierLogin record, @Param("example") TSupplierLoginExample example);

    int updateByPrimaryKeySelective(TSupplierLogin record);

    int updateByPrimaryKey(TSupplierLogin record);
}