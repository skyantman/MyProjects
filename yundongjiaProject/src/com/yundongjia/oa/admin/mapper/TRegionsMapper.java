package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TRegions;
import com.yundongjia.oa.admin.po.TRegionsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TRegionsMapper {
    int countByExample(TRegionsExample example);

    int deleteByExample(TRegionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRegions record);

    int insertSelective(TRegions record);

    List<TRegions> selectByExample(TRegionsExample example);

    TRegions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRegions record, @Param("example") TRegionsExample example);

    int updateByExample(@Param("record") TRegions record, @Param("example") TRegionsExample example);

    int updateByPrimaryKeySelective(TRegions record);

    int updateByPrimaryKey(TRegions record);
    /*
     * 
    * Title: geTRegionsByProvince
    * Description: 获取省
    * @author HuangJian
    * @date 2017年1月11日
     */
    List<TRegions> geTRegionsByProvince();
    /*
     * 
    * Title: getCityByProvince
    * Description: 根据省code获取市集合
    * @author HuangJian
    * @date 2017年1月11日
     */
    List<TRegions> getCityByProvince(@Param("proCode") Integer proCode);
    /*
     * 
    * Title: getAreaByCity
    * Description: 根据市code获取区
    * @author HuangJian
    * @date 2017年1月11日
     */
    List<TRegions> getAreaByCity(@Param("cityCode") Integer cityCode);
    
    
    /*
     * 逆向获取省市区
     */
    /*
     * 
    * Title: getAreaByArea
    * Description: 根据区id查询  为了获取pcode
    * @author HuangJian
    * @date 2017年1月12日
     */
    TRegions getAreaByArea(@Param("regionsId") Integer regionsId);
    
    /*
     * 
    * Title: getCityByArea
    * Description: 根据区获取市
    * @author HuangJian
    * @date 2017年1月12日
     */
    TRegions getCityByArea(@Param("areaCode") Integer areaCode);
    /*
     * 
    * Title: getProvinceByCity
    * Description: 根据市code查询省
    * @author HuangJian
    * @date 2017年1月12日
     */
    TRegions getProvinceByCity(@Param("cityCode") Integer cityCode);
    
    
    /**
    * Title: getAreaByCityCode
    * Description: 根据城市code查询所有区
    * @param cityCode
    * @return
    * @author HuangJian
    * @date 2017年6月9日
    */
    List<Integer> getAreaCodeByCityCode(@Param("cityCode") String cityCode);
    
    /**
    * Title: findStudioNearbyData
    * Description: 根据城市查询所有的区 编号和名称
    * @param cityCode
    * @return
    * @author HuangJian
    * @date 2017年6月12日
    */
    List<Map<String, Object>> findStudioNearbyData(@Param("cityCode") String cityCode);
    
    /**
    * Title: findCityByCityName
    * Description: 模糊查询城市名称
    * @param cityName
    * @return
    * @author HuangJian
    * @date 2017年6月13日
    */
    List<Map<String, Object>> findCityByCityName(String cityName);
}