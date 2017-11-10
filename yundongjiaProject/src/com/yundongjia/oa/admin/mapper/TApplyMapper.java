package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TApply;
import com.yundongjia.oa.admin.po.TApplyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TApplyMapper {
    int countByExample(TApplyExample example);

    int deleteByExample(TApplyExample example);

    int deleteByPrimaryKey(Integer rowid);

    int insert(TApply record);

    int insertSelective(TApply record);

    List<TApply> selectByExample(TApplyExample example);

    TApply selectByPrimaryKey(Integer rowid);

    int updateByExampleSelective(@Param("record") TApply record, @Param("example") TApplyExample example);

    int updateByExample(@Param("record") TApply record, @Param("example") TApplyExample example);

    int updateByPrimaryKeySelective(TApply record);

    int updateByPrimaryKey(TApply record);
    
    /**
    * Title: findApplyList
    * Description: 全查或条件
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年2月28日
    */
    List<Map<String, Object>> findApplyList(@Param("param") Map<String, Object> param);
    
    
    
    
    /**
    * Title: selectApplySumMoneyByApplyStatus
    * Description: 根据状态统计金额
    * @param aStatus   0:正在处理提现金额  1:已提现金额 2:已取消金额
    * @return
    * @author HuangJian
    * @date 2017年2月28日
    */
    String selectApplySumMoneyByApplyStatus(@Param("aStatus") Integer aStatus);
    
    /**
    * Title: selectApplyCount
    * Description: 根据状态总和
    * @param aStatus  0:需审批订单数    
    * @return
    * @author HuangJian
    * @date 2017年2月28日
    */
    String selectApplyCountNum(@Param("aStatus") Integer aStatus);
    
    /**
    * Title: selectTodayCountNum
    * Description: 统计  今日订单数
    * @return
    * @author HuangJian
    * @date 2017年2月28日
    */
    String selectTodayCountNum();
    
    /**
    * Title: selectStayApplyMoney
    * Description: 待提现金额
    * @return
    * @author HuangJian
    * @date 2017年2月28日
    */
    String selectStayApplyMoney();
}