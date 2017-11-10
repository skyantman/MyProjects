package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecord;
import com.yundongjia.oa.admin.po.TStudioConsumeOrderRecordExample;
import com.yundongjia.oa.admin.vo.ClearOrderSearchVo;
import com.yundongjia.oa.admin.vo.OrderSearchVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TStudioConsumeOrderRecordMapper {
    int countByExample(TStudioConsumeOrderRecordExample example);

    int deleteByExample(TStudioConsumeOrderRecordExample example);

    int deleteByPrimaryKey(Integer orderid);

    int insert(TStudioConsumeOrderRecord record);

    int insertSelective(TStudioConsumeOrderRecord record);

    List<TStudioConsumeOrderRecord> selectByExample(TStudioConsumeOrderRecordExample example);

    TStudioConsumeOrderRecord selectByPrimaryKey(Integer orderid);

    int updateByExampleSelective(@Param("record") TStudioConsumeOrderRecord record, @Param("example") TStudioConsumeOrderRecordExample example);

    int updateByExample(@Param("record") TStudioConsumeOrderRecord record, @Param("example") TStudioConsumeOrderRecordExample example);

    int updateByPrimaryKeySelective(TStudioConsumeOrderRecord record);

    int updateByPrimaryKey(TStudioConsumeOrderRecord record);
    
    /**
    * Title: findStudioOrder
    * Description: 查询场馆订单
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月7日
    */
    List<Map<String, Object>> findStudioOrder(OrderSearchVo vo);
    /**
	 * @param param
	 * @return根据日期筛选订单使用的红包金额总数
	 * @author lxy
    * @date 2017年2月9日
	 */
	Double employSum(Map param);
	
	/**
	* Title: appSelectOrderCountByStudioId
	* Description: 场馆 已支付状态总数
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年2月14日
	*/
	String appSelectOrderCountByStudioId(@Param("param") Map<String, Object> param);
	
	/**
	* Title: findClearOrderList
	* Description: 结算列表
	* @param vo
	* @return
	* @author HuangJian
	* @date 2017年2月28日
	*/
	List<Map<String, Object>> findClearOrderList(ClearOrderSearchVo vo);
	
	
	/**
	* Title: selectClearOrderCountByPayStatus
	* Description: 根据状态统计结算订单数
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年3月2日
	*/
	String selectClearOrderCountByPayStatus(@Param("param") Map<String, Object> param);
	
	/**
	* Title: TStudioConsumeOrderRecordMapper.java
	* Description: 根据meberid集合查询订单
	* @param members
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	List<Map<String, Object>> findStudioOrderByMembers(@Param("members") List<Integer> members);
	
	/**
	* Title: TStudioConsumeOrderRecordMapper.java
	* Description: 根据手机号码模糊查询订单
	* @param mobilePhoneNum
	* @return
	* @author HuangJian
	* @date 2017年4月20日
	*/
	List<Map<String, Object>> findStudioOrderByMobilePhoneNum(@Param("mobilePhoneNum") String mobilePhoneNum);
	
	/**
	* Title: TStudioConsumeOrderRecordMapper.java
	* Description: 统计会员已使用次数
	* @param members 会员集合
	* @return
	* @author HuangJian
	* @date 2017年4月21日
	*/
	public String findStatisUsedNumber(@Param("members") List<Integer> members);
	
}