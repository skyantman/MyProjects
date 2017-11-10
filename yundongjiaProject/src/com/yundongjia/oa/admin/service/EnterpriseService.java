/*
* @author HuangJian
* @date 2017年1月11日
*/
package com.yundongjia.oa.admin.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TEnterprise;

public interface EnterpriseService {

	/*
	 * 
	* Title: saveEnterprise
	* Description: 保存企业信息 并返回增加的主键
	* @author HuangJian
	* @date 2017年1月11日
	 */
	int saveEnterprise(TEnterprise enterprise);
	/*
	 * 
	* Title: findEnterprise
	* Description: 企业卡全查
	* @author HuangJian
	* @date 2017年1月11日
	 */
	//List<TEnterprise> findEnterprise();
	/*
	 * 
	* Title: getEnterpriseById
	* Description: 根据企业id查询
	* @author HuangJian
	* @date 2017年1月12日
	 */
	Map<String, Object> getEnterpriseById(Integer id);
	
	/*
	 * 
	* Title: editEnterprise
	* Description: 修改企业数据
	* @author HuangJian
	* @date 2017年1月12日
	 */
	int updateEnterprise(TEnterprise enterprise);
	
	/*
	* Title: findEnterpriseAndCard
	* Description: 获取企业数据和统计运动次数
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
	List<Map<String, Object>> getEnterpriseByName(String name);
	/*
	 * 
	* Title: updateEnterpriseByStatus
	* Description: status:状态值   enterpriseId:企业id   启用，禁用
	* @author HuangJian
	* @date 2017年1月13日
	 */
	int updateEnterpriseByStatus(Integer status,Integer enterpriseId);
	
	
	/**
	* Title: getEnterpriseByStatisMessage
	* Description: 企业首页统计信息
	* @return
	* @author HuangJian
	* @date 2017年1月17日
	*/
	Map<String, Object> getEnterpriseByStatisMessage();
	
	
}

