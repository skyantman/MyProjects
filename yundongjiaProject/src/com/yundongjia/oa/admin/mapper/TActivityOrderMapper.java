package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TActivityOrder;
import com.yundongjia.oa.admin.po.TActivityOrderExample;
import com.yundongjia.oa.admin.vo.OrderSearchVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TActivityOrderMapper {
    int countByExample(TActivityOrderExample example);

    int deleteByExample(TActivityOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(TActivityOrder record);

    int insertSelective(TActivityOrder record);

    List<TActivityOrder> selectByExample(TActivityOrderExample example);

    TActivityOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") TActivityOrder record, @Param("example") TActivityOrderExample example);

    int updateByExample(@Param("record") TActivityOrder record, @Param("example") TActivityOrderExample example);

    int updateByPrimaryKeySelective(TActivityOrder record);

    int updateByPrimaryKey(TActivityOrder record);
    /**
    * Title: findActivityOrders
    * Description: 活动订单
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月8日
    */
    public List<Map<String, Object>> findActivityOrders(@Param("param") Map<String, Object> param);
    
    /**
    * Title: selectActivityOrderStatisByPayStatus
    * Description: 根据不同的订单状态统计   如有日期统计日期的订单数
    * @param status
    * @return
    * @author HuangJian
    * @date 2017年2月8日
    */
    public Integer selectActivityOrderStatisByPayStatus(@Param("param") Map<String, Object> param);
    
    /**
    * Title: sselectActivityOrderTotalMoney
    * Description: 活动总收入,或单个活动收入
    * @return
    * @author HuangJian
    * @date 2017年2月8日
    */
    public String selectActivityOrderTotalMoney(@Param("param") Map<String, Object> param);  
    
    
    /**
    * Title: findActivityOrds
    * Description: 活动查询
    * @param vo
    * @return
    * @author HuangJian
    * @date 2017年2月8日
    */
    public List<Map<String, Object>> findActivityOrds(OrderSearchVo vo);

	/**
	 * @param param
	 * @return根据日期筛选订单使用的红包金额总数
	 * @author lxy
    * @date 2017年2月9日
	 */
	Double employSum(Map param);

	/**
	 * @param activeId
	 * @return根据订单ID查询已报名的会员
	 */
	List<Map<String, Object>> findeMember(Integer activeId);

}