package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TGoodsOrder;
import com.yundongjia.oa.admin.po.TGoodsOrderExample;
import com.yundongjia.oa.admin.vo.ClearOrderSearchVo;
import com.yundongjia.oa.admin.vo.OrderSearchVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TGoodsOrderMapper {
    int countByExample(TGoodsOrderExample example);

    int deleteByExample(TGoodsOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(TGoodsOrder record);

    int insertSelective(TGoodsOrder record);

    List<TGoodsOrder> selectByExample(TGoodsOrderExample example);

    TGoodsOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") TGoodsOrder record, @Param("example") TGoodsOrderExample example);

    int updateByExample(@Param("record") TGoodsOrder record, @Param("example") TGoodsOrderExample example);

    int updateByPrimaryKeySelective(TGoodsOrder record);

    int updateByPrimaryKey(TGoodsOrder record);
    
   
    /**
    * Title: findGoodsOrderList
    * Description: 商城订单查询
    * @param vo  查询条件
    * @return
    * @author HuangJian
    * @date 2017年2月8日
    */
    List<Map<String, Object>> findGoodsOrderList(OrderSearchVo vo);
    /**
	 * @param param
	 * @return根据日期筛选订单使用的红包金额总数
	 * @author lxy
    * @date 2017年2月9日
	 */
	Double employSum(Map param);
	
	/**
	* Title: findClearGoodsOrderList
	* Description: 商品订单结算列表，或条件查询
	* @param vo
	* @return
	* @author HuangJian
	* @date 2017年3月1日
	*/
	List<Map<String, Object>> findClearGoodsOrderList(ClearOrderSearchVo vo);
	
	
	/**
	* Title: selectClearOrderCountByPayStatus
	* Description: 统计 商品订单根据状态
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年3月3日
	*/
	String selectClearOrderCountByPayStatus(@Param("param") Map<String, Object> param);
}