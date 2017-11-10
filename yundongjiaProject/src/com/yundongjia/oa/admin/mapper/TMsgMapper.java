package com.yundongjia.oa.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yundongjia.oa.admin.po.TMsg;
import com.yundongjia.oa.admin.po.TMsgExample;

public interface TMsgMapper {
    int countByExample(TMsgExample example);

    int deleteByExample(TMsgExample example);

    int deleteByPrimaryKey(Integer verifyid);

    int insert(TMsg record);

    int insertSelective(TMsg record);

    List<TMsg> selectByExample(TMsgExample example);

    TMsg selectByPrimaryKey(Integer verifyid);

    int updateByExampleSelective(@Param("record") TMsg record, @Param("example") TMsgExample example);

    int updateByExample(@Param("record") TMsg record, @Param("example") TMsgExample example);

    int updateByPrimaryKeySelective(TMsg record);

    int updateByPrimaryKey(TMsg record);
    /**
  	 * @param param
  	 * @return根据手机号与验证码查询验证码是否正确，返回ID
  	 */
  	Integer selectBMByphoneAndCode(Map param);

  	/**
  	 * @param userMobilephoneno
  	 * @return更新验证码状态
  	 */
  	Integer updateStatuByPhone(String userMobilephoneno);
}