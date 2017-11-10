package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TGoodsStandard;
import com.yundongjia.oa.admin.po.TGoodsStandardExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TGoodsStandardMapper {
    int countByExample(TGoodsStandardExample example);

    int deleteByExample(TGoodsStandardExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TGoodsStandard record);

    int insertSelective(TGoodsStandard record);

    List<TGoodsStandard> selectByExample(TGoodsStandardExample example);

    TGoodsStandard selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TGoodsStandard record, @Param("example") TGoodsStandardExample example);

    int updateByExample(@Param("record") TGoodsStandard record, @Param("example") TGoodsStandardExample example);

    int updateByPrimaryKeySelective(TGoodsStandard record);

    int updateByPrimaryKey(TGoodsStandard record);
    
    /**
    * Title: findGoodsStandard
    * Description: 查询goodsId =0 的规格
    * @return
    * @author HuangJian
    * @date 2017年2月11日
    */
    List<Map<String, Object>> findGoodsStandard();
    
     
    /**
    * Title: selectGoodsStandardByGoodsId
    * Description: 根据商品查询规格
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月11日
    */
    List<Map<String, Object>> selectGoodsStandardByGoodsId(@Param("param") Map<String, Object> param);
}