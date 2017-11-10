package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TOrder;
import com.yundongjia.oa.admin.po.TOrderExample;
import com.yundongjia.oa.admin.vo.ClearOrderSearchVo;
import com.yundongjia.oa.admin.vo.OrderSearchVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.web.bind.annotation.RequestParam;

public interface TOrderMapper {
    int countByExample(TOrderExample example);

    int deleteByExample(TOrderExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    List<TOrder> selectByExample(TOrderExample example);

    TOrder selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);

	/**
	* Title: findOrderList
	* Description: 多条件查询、全查
	* @param vo
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	List<Map<String, Object>> findOrderList(OrderSearchVo vo);
	
	
	/**
	* Title: getOrdersByOrderIdType
	* Description: 根据不同的类型查询订单
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月8日
	*/
	List<Map<String, Object>> getOrdersByOrderIdType(@Param("param") Map<String, Object> param);
	/**
	 * @param param
	 * @return根据日期筛选订单使用的红包金额总数
	 * @author lxy
    * @date 2017年2月9日
	 */
	Double employSum(Map param);
	
	/**
	* Title: updateOrderStatus
	* Description: 根据订单ID修改订单状态
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月9日
	*/
	Integer updateOrderStatus(@Param("param") Map<String, Object> param);
	
	/**
	* Title: selectStatisOrderTotalMoney
	* Description: 根据状态统计订单总金额  statusId:-1 全部状态统计
	* @return
	* @author HuangJian
	* @date 2017年2月9日
	*/
	String selectStatisOrderTotalMoney(@Param("param") Map<String, Object> param);
	
	/**
	* Title: seelctStatisOrderByStatus
	* Description: 根据状态统计订单总数
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月9日
	*/
	Integer selectStatisOrderByStatus(@Param("param") Map<String, Object> param);
	
	/**
	* Title: selectStatisOrderDay
	* Description: 今日订单数
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月9日
	*/
	Integer selectStatisOrderDay(@Param("param") Map<String, Object> param);
	
	/**
	* Title: getAppOrderById
	* Description: app 根据订单ID查询
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月16日
	*/
	Map<String, Object> getAppOrderById(@Param("param") Map<String, Object> param);
	
	/**
	* Title: findClearOrderList
	* Description: 私教 结算订单 或多条件查询
	* @param vo
	* @return
	* @author HuangJian
	* @date 2017年3月1日
	*/
	List<Map<String, Object>> findClearOrderList(ClearOrderSearchVo vo);
	
	/**
	* Title: selectClearOrderCountByPayStatus
	* Description: 教练结算统计
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年3月3日
	*/
	String selectClearOrderCountByPayStatus(@Param("param") Map<String, Object> param);
	
	
	/**
	* Title: updateOrderStatusByClearOrder
	* Description: 根据订单ID 类型修改不同的订单状态  (结算)
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年3月3日
	*/
	public Integer updateOrderStatusByClearOrder(@Param("param") Map<String, Object> param); 
	
	
	/**
	* Title: selectOrderById
	* Description: 根据订单类型，订单ID查询订单
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年3月3日
	*/
	Map<String, Object> selectOrderById(@Param("param") Map<String, Object> param);
	
	/**
	* Title: selectOrderByIdNoDeal
	* Description: 查询订单根据订单类型和订单ID 不做任何处理
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年3月21日
	*/
	Map<String, Object> selectOrderByIdNoDeal(@Param("param") Map<String, Object> param);
	
	/**
	* Title: updateOrderMessageStatusByOrderId
	* Description: 修改订单短信状态
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年3月21日
	*/
	Integer updateOrderMessageStatusByOrderId(@Param("param") Map<String, Object> param);
}