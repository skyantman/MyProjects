package com.yundongjia.oa.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundongjia.oa.admin.po.TMenuAdminRef;
import com.yundongjia.oa.admin.po.TMenuAdminRefExample;

public interface TMenuAdminRefMapper {
    int countByExample(TMenuAdminRefExample example);

    int deleteByExample(TMenuAdminRefExample example);

    int deleteByPrimaryKey(Integer menuAdminId);

    int insert(TMenuAdminRef record);

    int insertSelective(TMenuAdminRef record);

    List<TMenuAdminRef> selectByExample(TMenuAdminRefExample example);

    TMenuAdminRef selectByPrimaryKey(Integer menuAdminId);

    int updateByExampleSelective(@Param("record") TMenuAdminRef record, @Param("example") TMenuAdminRefExample example);

    int updateByExample(@Param("record") TMenuAdminRef record, @Param("example") TMenuAdminRefExample example);

    int updateByPrimaryKeySelective(TMenuAdminRef record);

    int updateByPrimaryKey(TMenuAdminRef record);
    
    List<Map<String, Object>> selectMenuRoleRefMyRoleId(@Param("rId") Integer rId);
    
    int insertMenuRoleRefs(List<TMenuAdminRef> mrlist);
}