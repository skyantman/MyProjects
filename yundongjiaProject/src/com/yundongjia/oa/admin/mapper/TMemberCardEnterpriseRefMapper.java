package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRef;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRefExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMemberCardEnterpriseRefMapper {
    int countByExample(TMemberCardEnterpriseRefExample example);

    int deleteByExample(TMemberCardEnterpriseRefExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TMemberCardEnterpriseRef record);

    int insertSelective(TMemberCardEnterpriseRef record);

    List<TMemberCardEnterpriseRef> selectByExample(TMemberCardEnterpriseRefExample example);

    TMemberCardEnterpriseRef selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TMemberCardEnterpriseRef record, @Param("example") TMemberCardEnterpriseRefExample example);

    int updateByExample(@Param("record") TMemberCardEnterpriseRef record, @Param("example") TMemberCardEnterpriseRefExample example);

    int updateByPrimaryKeySelective(TMemberCardEnterpriseRef record);

    int updateByPrimaryKey(TMemberCardEnterpriseRef record);
    
    /**
    * Title: TMemberCardEnterpriseRefMapper.java
    * Description: 根据企业卡查询企业用户
    * @param cards
    * @return
    * @author HuangJian
    * @date 2017年4月20日
    */
    List<Map<String, Object>> findUserByCards(@Param("cards") List<Integer> cards);
}