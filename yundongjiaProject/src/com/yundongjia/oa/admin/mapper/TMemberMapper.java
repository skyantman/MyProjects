package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TMember;
import com.yundongjia.oa.admin.po.TMemberExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMemberMapper {
    int countByExample(TMemberExample example);

    int deleteByExample(TMemberExample example);

    int deleteByPrimaryKey(Integer memberid);

    int insert(TMember record);

    int insertSelective(TMember record);

    List<TMember> selectByExample(TMemberExample example);

    TMember selectByPrimaryKey(Integer memberid);

    int updateByExampleSelective(@Param("record") TMember record, @Param("example") TMemberExample example);

    int updateByExample(@Param("record") TMember record, @Param("example") TMemberExample example);

    int updateByPrimaryKeySelective(TMember record);

    int updateByPrimaryKey(TMember record);
    
    /**
    * Title: findIsMemberById
    * Description: 根据用户ID查询是否是会员
    * @param userId
    * @return
    * @author HuangJian
    * @date 2017年6月12日
    */
    List<Map<String, Object>> findIsMemberById(String userId);
}