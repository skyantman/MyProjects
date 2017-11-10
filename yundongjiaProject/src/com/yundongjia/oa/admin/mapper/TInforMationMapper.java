package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TInforMation;
import com.yundongjia.oa.admin.po.TInforMationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TInforMationMapper {
    int countByExample(TInforMationExample example);

    int deleteByExample(TInforMationExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TInforMation record);

    int insertSelective(TInforMation record);

    List<TInforMation> selectByExample(TInforMationExample example);

    TInforMation selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TInforMation record, @Param("example") TInforMationExample example);

    int updateByExample(@Param("record") TInforMation record, @Param("example") TInforMationExample example);

    int updateByPrimaryKeySelective(TInforMation record);

    int updateByPrimaryKey(TInforMation record);
    
    /**
    * Title: findInforMationList
    * Description: 资讯全查 或 条件查询
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月20日
    */
    List<Map<String, Object>> findInforMationList(@Param("param") Map<String, Object> param);
}