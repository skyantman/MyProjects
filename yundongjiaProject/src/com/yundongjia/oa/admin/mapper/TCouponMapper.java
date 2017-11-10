package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TCoupon;
import com.yundongjia.oa.admin.po.TCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCouponMapper {
    int countByExample(TCouponExample example);

    int deleteByExample(TCouponExample example);

    int deleteByPrimaryKey(Integer couponid);

    int insert(TCoupon record);

    int insertSelective(TCoupon record);

    List<TCoupon> selectByExample(TCouponExample example);

    TCoupon selectByPrimaryKey(Integer couponid);

    int updateByExampleSelective(@Param("record") TCoupon record, @Param("example") TCouponExample example);

    int updateByExample(@Param("record") TCoupon record, @Param("example") TCouponExample example);

    int updateByPrimaryKeySelective(TCoupon record);

    int updateByPrimaryKey(TCoupon record);
}