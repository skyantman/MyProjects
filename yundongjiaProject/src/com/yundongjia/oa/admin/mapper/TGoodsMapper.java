package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TGoods;
import com.yundongjia.oa.admin.po.TGoodsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TGoodsMapper {
    int countByExample(TGoodsExample example);

    int deleteByExample(TGoodsExample example);

    int deleteByPrimaryKey(Integer goodsid);

    int insert(TGoods record);

    int insertSelective(TGoods record);

    List<TGoods> selectByExample(TGoodsExample example);

    TGoods selectByPrimaryKey(Integer goodsid);

    int updateByExampleSelective(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByExample(@Param("record") TGoods record, @Param("example") TGoodsExample example);

    int updateByPrimaryKeySelective(TGoods record);

    int updateByPrimaryKey(TGoods record);
    
    /**
    * Title: findGoodsList
    * Description: 条件或全查
    * @param goods
    * @return
    * @author HuangJian
    * @date 2017年2月10日
    */
    List<Map<String, Object>> findGoodsList(TGoods goods);
    
    /**
    * Title: selectGoodsById
    * Description: 根据商品ID查询
    * @param gId
    * @return
    * @author HuangJian
    * @date 2017年2月10日
    */
    List<Map<String, Object>> selectGoodsById(@Param("gId") Integer gId);
    
    /**
    * Title: selectStatusCount
    * Description: 根据状态统计
    * @param status
    * @return
    * @author HuangJian
    * @date 2017年2月10日
    */
    Integer selectStatusCount(Integer status);
}