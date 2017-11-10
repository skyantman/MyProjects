package com.yundongjia.oa.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundongjia.oa.admin.po.TOrderDiscount;
import com.yundongjia.oa.admin.po.TOrderDiscountExample;

public interface TOrderDiscountMapper {
    int countByExample(TOrderDiscountExample example);

    int deleteByExample(TOrderDiscountExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TOrderDiscount record);

    int insertSelective(TOrderDiscount record);

    List<TOrderDiscount> selectByExample(TOrderDiscountExample example);

    TOrderDiscount selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TOrderDiscount record, @Param("example") TOrderDiscountExample example);

    int updateByExample(@Param("record") TOrderDiscount record, @Param("example") TOrderDiscountExample example);

    int updateByPrimaryKeySelective(TOrderDiscount record);

    int updateByPrimaryKey(TOrderDiscount record);
    
    /**
	 * @param param 
	 * @return查询订单中使用的红包总金额
	 */
	Double employSum(Map param);
	
	/**
	* Title: updateDisCountByOrderIdAndStatus
	* Description: 
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年3月7日
	*/
	Integer updateDisCountByOrderIdAndStatus(@Param("param") Map<String, Object> param);
	
	
}