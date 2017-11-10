package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TEnterprise;
import com.yundongjia.oa.admin.po.TEnterpriseExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TEnterpriseMapper {
    int countByExample(TEnterpriseExample example);

    int deleteByExample(TEnterpriseExample example);

    int deleteByPrimaryKey(Integer enterpriseid);

    int insert(TEnterprise record);

    int insertSelective(TEnterprise record);

    List<TEnterprise> selectByExample(TEnterpriseExample example);

    TEnterprise selectByPrimaryKey(Integer enterpriseid);

    int updateByExampleSelective(@Param("record") TEnterprise record, @Param("example") TEnterpriseExample example);

    int updateByExample(@Param("record") TEnterprise record, @Param("example") TEnterpriseExample example);

    int updateByPrimaryKeySelective(TEnterprise record);

    int updateByPrimaryKey(TEnterprise record);
    
    /*
     * 
    * Title: getEnterpriseById
    * Description: 根据企业id查询   -1全查
    * @author HuangJian
    * @date 2017年1月12日
     */
    List<Map<String, Object>> getEnterpriseById(@Param("id") Integer id);
    /*
     * 
    * Title: findEnterpriseAndCard
    * Description: 查询全部企业
    * @author HuangJian
    * @date 2017年1月12日
     */
    List<Map<String, Object>> findEnterpriseAndCard();
    /*
     * 
    * Title: getEnterpriseByName
    * Description: 根据企业名称模糊查询
    * @author HuangJian
    * @date 2017年1月12日
     */
    List<Map<String, Object>> getEnterpriseByName(@Param("name") String name);
    /*
     * 
    * Title: updateEnterpriseStatusById
    * Description: 设置企业禁用，启用状态
    * @author HuangJian
    * @date 2017年1月13日
     */
    int updateEnterpriseStatusById(@Param("param") Map<String, Object> param);
    
    /**
    * Title: getEnterpriseByStatisMessage
    * Description: 企业   首页统计
    * @return
    * @author HuangJian
    * @date 2017年1月17日
    */
    Map<String, Object> getEnterpriseByStatisMessage();
}