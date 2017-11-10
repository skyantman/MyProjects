package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TWeixinNotifiyResult;
import com.yundongjia.oa.admin.po.TWeixinNotifiyResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWeixinNotifiyResultMapper {
    int countByExample(TWeixinNotifiyResultExample example);

    int deleteByExample(TWeixinNotifiyResultExample example);

    int deleteByPrimaryKey(Integer wxid);

    int insert(TWeixinNotifiyResult record);

    int insertSelective(TWeixinNotifiyResult record);

    List<TWeixinNotifiyResult> selectByExample(TWeixinNotifiyResultExample example);

    TWeixinNotifiyResult selectByPrimaryKey(Integer wxid);

    int updateByExampleSelective(@Param("record") TWeixinNotifiyResult record, @Param("example") TWeixinNotifiyResultExample example);

    int updateByExample(@Param("record") TWeixinNotifiyResult record, @Param("example") TWeixinNotifiyResultExample example);

    int updateByPrimaryKeySelective(TWeixinNotifiyResult record);

    int updateByPrimaryKey(TWeixinNotifiyResult record);
}