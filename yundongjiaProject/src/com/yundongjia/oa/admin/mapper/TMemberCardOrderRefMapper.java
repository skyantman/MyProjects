package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;
import com.yundongjia.oa.admin.vo.OrderSearchVo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TMemberCardOrderRefMapper {
    int countByExample(TMemberCardOrderRefExample example);

    int deleteByExample(TMemberCardOrderRefExample example);

    int deleteByPrimaryKey(Integer cardid);

    int insert(TMemberCardOrderRef record);

    int insertSelective(TMemberCardOrderRef record);

    List<TMemberCardOrderRef> selectByExample(TMemberCardOrderRefExample example);
    
    TMemberCardOrderRef selectByPrimaryKey(Integer cardid);

    int updateByExampleSelective(@Param("record") TMemberCardOrderRef record, @Param("example") TMemberCardOrderRefExample example);

    int updateByExample(@Param("record") TMemberCardOrderRef record, @Param("example") TMemberCardOrderRefExample example);

    int updateByPrimaryKeySelective(TMemberCardOrderRef record);

    int updateByPrimaryKey(TMemberCardOrderRef record);

	/**
	 * @param param
	 * @return查询会员卡订单信息根据会员卡类型ID / 企业模糊查询
	 */
	List<Map> findListByCardTypeId(Map param);
    /*
     * 
    * Title: getCardOrderById
    * Description: 根据卡id查询信息
    * @author HuangJian
    * @date 2017年1月11日
     */
	Map<String, Object> getCardOrderById(@Param("cardId") Integer cardId);
    
    
    /*
     * 
    * Title: getCardOrderStatisByEnterpriseId
    * Description: 根据企业id统计  运动次数，已使用次数    卡有效期大于当前日期，并且剩余次数大于等于0
    * @author HuangJian
    * @date 2017年1月12日
     */
    Map<String, Object> getCardOrderStatisByEnterpriseId(@Param("enterId") Integer id);
    /**
	 * @param cardid
	 * @return查询个人卡列表详情
	 */
	List<Map> findListSelfByCardTypeId(Map param);
    
    /**
    * Title: getCardOrderByEnterId
    * Description: 根据企业id查询企业卡
    * @param enterId
    * @return
    * @author HuangJian
    * @date 2017年1月16日
    */
    List<Map<String, Object>> getCardOrderByEnterId(@Param("enterId") Integer enterId);
    
    List<Map<String,Object>> selectmembercardInfocardType(Map<String,Object> map);
    
    /**
    * Title: findMemberCardOrderList
    * Description: 全查跟人卡订单或条件查询
    * @param orderSearchVo
    * @return
    * @author HuangJian
    * @date 2017年2月22日
    */
    List<Map<String, Object>> findMemberCardOrderList(OrderSearchVo orderSearchVo);
    
}