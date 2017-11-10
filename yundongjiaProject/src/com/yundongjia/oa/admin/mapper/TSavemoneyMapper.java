package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TSavemoney;
import com.yundongjia.oa.admin.po.TSavemoneyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TSavemoneyMapper {
    int countByExample(TSavemoneyExample example);

    int deleteByExample(TSavemoneyExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TSavemoney record);

    int insertSelective(TSavemoney record);

    List<TSavemoney> selectByExample(TSavemoneyExample example);

    TSavemoney selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TSavemoney record, @Param("example") TSavemoneyExample example);

    int updateByExample(@Param("record") TSavemoney record, @Param("example") TSavemoneyExample example);

    int updateByPrimaryKeySelective(TSavemoney record);

    int updateByPrimaryKey(TSavemoney record);
    
    /**
    * Title: findSaveMoneyList
    * Description: 全查
    * @return
    * @author HuangJian
    * @date 2017年2月27日
    */
    List<Map<String, Object>> findSaveMoneyList();
    
    
    
}