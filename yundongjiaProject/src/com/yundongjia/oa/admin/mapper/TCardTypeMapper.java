package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCardTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCardTypeMapper {
    int countByExample(TCardTypeExample example);

    int deleteByExample(TCardTypeExample example);

    int deleteByPrimaryKey(Integer cardid);

    int insert(TCardType record);

    int insertSelective(TCardType record);

    List<TCardType> selectByExample(TCardTypeExample example);

    TCardType selectByPrimaryKey(Integer cardid);

    int updateByExampleSelective(@Param("record") TCardType record, @Param("example") TCardTypeExample example);

    int updateByExample(@Param("record") TCardType record, @Param("example") TCardTypeExample example);

    int updateByPrimaryKeySelective(TCardType record);

    int updateByPrimaryKey(TCardType record);
    
    
    /**
    * Title: findCardTypeByEnterType
    * Description: 获取企业卡类型
    * @return
    * @author HuangJian
    * @date 2017年1月17日
    */
    List<TCardType> findCardTypeByEnterType(@Param("cId") Integer cId);
    
    /**
    * Title: TCardTypeMapper.java
    * Description: 查询个人卡最低折扣
    * @return
    * @author HuangJian
    * @date 2017年5月15日
    */
    double selectMinCardDiscount();
}