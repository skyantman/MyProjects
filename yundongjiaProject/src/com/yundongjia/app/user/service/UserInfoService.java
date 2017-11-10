package com.yundongjia.app.user.service;

import java.util.List;


import com.yundongjia.oa.admin.po.TUser;
import com.yundongjia.oa.admin.po.TUserExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:00:24 * @version 1.0 * @parameter  * @since  * @return  */

public interface UserInfoService {
    
	/**
	 * 
	* @Title: selectUserLoginInfo 
	* @Description: TODO(查询t_user信息) 
	* @param @param example
	* @param @return    设定文件 
	* @return List<TUser>    返回类型 
	* @throws
	 */
	public List<TUser> selectUserLoginInfo(TUserExample example);
	/**
	 * 
	* @Title: updateUserPwd 
	* @Description: TODO(根据条件修改t_user用户信息) 
	* @param @param user
	* @param @param example
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	public Integer updateUserPwd(TUser user,TUserExample example);
	public Integer updateUserPwd(TUser user);
	/**
	 * 
	* @Title: inserUser 
	* @Description: TODO(用户注册--插入信息到t_user表) 
	* @param @param user
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer insertUser(TUser user);
		
}
