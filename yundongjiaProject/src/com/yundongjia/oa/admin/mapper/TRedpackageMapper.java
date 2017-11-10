package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TRedpackage;
import com.yundongjia.oa.admin.po.TRedpackageExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TRedpackageMapper {
    int countByExample(TRedpackageExample example);

    int deleteByExample(TRedpackageExample example);

    int deleteByPrimaryKey(Integer redid);

    int insert(TRedpackage record);

    int insertSelective(TRedpackage record);

    List<TRedpackage> selectByExample(TRedpackageExample example);

    TRedpackage selectByPrimaryKey(Integer redid);

    int updateByExampleSelective(@Param("record") TRedpackage record, @Param("example") TRedpackageExample example);

    int updateByExample(@Param("record") TRedpackage record, @Param("example") TRedpackageExample example);

    int updateByPrimaryKeySelective(TRedpackage record);

    int updateByPrimaryKey(TRedpackage record);

	/**
	 * @return统计红包总金额  过期红包金额
	 */
	Double allSum(Map param);

	/**
	 * @param info 
	 * @return查询过期红包列表
	 */
	List<Map> pastList(Map param);
}