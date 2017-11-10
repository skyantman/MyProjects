package com.yundongjia.oa.admin.mapper;

import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.po.TUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

public interface TUserMapper {
    int countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    TUser selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    /**
    * Title: findTuserListByMobilePhone
    * Description: 根据卡查询用户，，或根据手机号码查询用户
    * @param param
    * @return
    * @author HuangJian
    * @date 2017年1月16日
    */
    List<Map<String, Object>> findTuserListByMobilePhone(@Param("param") Map<String, Object> param);
    
    /**
    * Title: getTuserById
    * Description: 根据Tuser用户id查询用户 详情
    * @param userId
    * @return
    * @author HuangJian
    * @date 2017年1月17日
    */
    List<Map<String, Object>> getTuserById(@Param("userId") Integer userId);
    
    /**
    * Title: getTuserMobilePhoneCount
    * Description: 查询手机号码是否存在
    * @param mobilePhone
    * @return
    * @author HuangJian
    * @date 2017年1月17日
    */
    Integer getTuserMobilePhoneCount(@Param("param") Map<String, Object> param);

	/**
	 * @param param 
	 * @return查询用户列表信息
	 */
	List<Map> findMemberList(Map param);
	
	/**
	* Title: selectUserEnterByPhone
	* Description: 查询改手机号码是否绑定企业卡
	* @param mobilePhone
	* @return
	* @author HuangJian
	* @date 2017年3月20日
	*/
	List<Map<String, Object>> selectUserEnterByPhone(String mobilePhone);
	
	/**
	* Title: selectUserMemberByPhone
	* Description: 查询用户与会员手机号码是否存在
	* @param mobilePhone
	* @return
	* @author HuangJian
	* @date 2017年3月20日
	*/
	List<Map<String, Object>> selectUserMemberByPhone(String mobilePhone);
	
	/**
	* Title: TUserMapper.java
	* Description: 企业端  全查或条件查询
	* @param param
	* @return
	* @author HuangJian
	* @date 2017年4月18日
	*/
	List<Map<String, Object>> findUserByMobilePhoneCards(@Param("param") Map<String, Object> param);
}