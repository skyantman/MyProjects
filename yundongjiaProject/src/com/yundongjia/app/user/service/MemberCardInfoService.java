package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TCardType;
import com.yundongjia.oa.admin.po.TCardTypeExample;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRef;
import com.yundongjia.oa.admin.po.TMemberCardEnterpriseRefExample;
import com.yundongjia.oa.admin.po.TMemberCardOrderRef;
import com.yundongjia.oa.admin.po.TMemberCardOrderRefExample;

/**
 * 
* @ClassName: MemberCardInfoService 
* @Description: TODO(会员卡信息service) 
* @author Wangli
* @date 2017年2月6日 下午2:38:29 
*
 */
public interface MemberCardInfoService {
    
	/**
	 * 
	* @Title: selectSelfMemberCardInfo 
	* @Description: TODO(查询单卡信息) 
	* @param @param example
	* @param @return    设定文件 
	* @return List<TMemberCardOrderRef>    返回类型 
	* @throws
	 */
	public List<TMemberCardOrderRef> selectSelfMemberCardInfo(TMemberCardOrderRefExample example);
	public TMemberCardOrderRef selectSelfMemberCardInfo(Integer id);
	/**
	 * 
	* @Title: selectMemberCardInfoCardType 
	* @Description: TODO(连表查询卡信息卡类型信息) 
	* @param @param example
	* @param @return    设定文件 
	* @return List<TMemberCardOrderRef>    返回类型 
	* @throws
	 */
	public List<Map<String,Object>> selectMemberCardInfoCardType(Map<String,Object>map);
	/**
	 * 
	* @Title: selectMemberCardEnterpriseRefInfo 
	* @Description: TODO(查询企业用户卡关联关系信息) 
	* @param @param enterpriseRefExample
	* @param @return    设定文件 
	* @return List<TMemberCardEnterpriseRef>    返回类型 
	* @throws
	 */
	public List<TMemberCardEnterpriseRef> selectMemberCardEnterpriseRefInfo(TMemberCardEnterpriseRefExample enterpriseRefExample);
	/**
	 * 
	* @Title: selectCardTypeInfo 
	* @Description: TODO(查询卡类型信息根据主键) 
	* @param @param id
	* @param @return    设定文件 
	* @return TCardType    返回类型 
	* @throws
	 */
	public TCardType selectCardTypeInfo(Integer id);
	/**
	 * 
	* @Title: selectCardTypeInfo 
	* @Description: TODO(查询卡类型信息根据条件) 
	* @param @param id
	* @param @return    设定文件 
	* @return TCardType    返回类型 
	* @throws
	 */
	public List<TCardType> selectCardTypeInfo(TCardTypeExample example);
	
	public Integer insertMemberCardInfo(TMemberCardOrderRef orderRef);
	
}
