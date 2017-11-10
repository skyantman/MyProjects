package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TSupplier;
import com.yundongjia.oa.admin.po.TSupplierExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TSupplierMapper {
    int countByExample(TSupplierExample example);

    int deleteByExample(TSupplierExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TSupplier record);

    int insertSelective(TSupplier record);

    List<TSupplier> selectByExample(TSupplierExample example);

    TSupplier selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TSupplier record, @Param("example") TSupplierExample example);

    int updateByExample(@Param("record") TSupplier record, @Param("example") TSupplierExample example);

    int updateByPrimaryKeySelective(TSupplier record);

    int updateByPrimaryKey(TSupplier record);
    
    
    /**
     * Title: selectMoneySumByType
     * Description: 统计金额
     * @param flag
     * @return
     * @author HuangJian
     * @date 2017年2月27日
     */
     String selectMoneySumByType(@Param("flag") Integer flag);
     
     /**
    * Title: getSupplierByApplyAccountId
    * Description: 根据提现账号 查询供应商
    * @param accountId
    * @return
    * @author HuangJian
    * @date 2017年3月6日
    */
    Map<String, Object> getSupplierByApplyAccountId(Integer accountId);
    
    
    
    /**
    * Title: findColumnByOrderId
    * Description: 查询对应订单的供应商
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年3月21日
    */
    List<Map<String, Object>> findColumnByOrderId(@Param("param") Map<String, Object> param);
    
}