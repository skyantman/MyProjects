package com.yundongjia.oa.admin.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface EnterpriseLoginService {

	/**
	 * @param phone
	 * @return查询账号是否注册企业信息
	 */
	Integer selectByPhone(String phone);

	/**
	 * @param backusermobliephone
	 * @param backuserpwd
	 * @param session 
	 * @return查询企业登录结果
	 */
	int enterpriseLogin(String backusermobliephone, String backuserpwd, HttpSession session);

	/**
	 * @param userPassword
	 * @param userMobilephoneno
	 * @param msg
	 * @return首次登陆重置密码
	 */
	Integer configPassword(String userPassword, String userMobilephoneno, String msg);

	/**
	 * @param enterpriseid
	 * @return查询登陆企业的企业卡信息
	 */
	Map<String, Object> findenterpriseCardInfo(Integer enterpriseid);

	/**
	 * @param logUserId
	 * @param oldPasswd
	 * @param newPasswd
	 * @return更新会员密码
	 */
	int updateGymPasswordByOldPassword(Integer logUserId, String oldPasswd, String newPasswd);


}
