package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TLeagueOrder;
import com.yundongjia.oa.admin.po.TLeagueOrderExample;
import com.yundongjia.oa.admin.vo.OrderSearchVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TLeagueOrderMapper {
    int countByExample(TLeagueOrderExample example);

    int deleteByExample(TLeagueOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(TLeagueOrder record);

    int insertSelective(TLeagueOrder record);

    List<TLeagueOrder> selectByExample(TLeagueOrderExample example);

    TLeagueOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") TLeagueOrder record, @Param("example") TLeagueOrderExample example);

    int updateByExample(@Param("record") TLeagueOrder record, @Param("example") TLeagueOrderExample example);

    int updateByPrimaryKeySelective(TLeagueOrder record);

    int updateByPrimaryKey(TLeagueOrder record);
    
    /**
    * Title: findLeagueOrders
    * Description: 团课课程订单  多条件查询，全查
    * @param vo
    * @return
    * @author HuangJian
    * @date 2017年2月8日
    */
    List<Map<String, Object>> findLeagueOrders(OrderSearchVo vo);
    /**
	 * @param param
	 * @return根据日期筛选订单使用的红包金额总数
	 * @author lxy
    * @date 2017年2月9日
	 */
	Double employSum(Map param);
}