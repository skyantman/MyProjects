package com.yundongjia.app.user.service;

import java.util.List;

import com.yundongjia.oa.admin.po.TActivation;
import com.yundongjia.oa.admin.po.TMsg;
import com.yundongjia.oa.admin.po.TMsgExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午9:41:25 * @version 1.0 * @parameter  * @since  * @return  */
public interface LoginUserService {
    /**
     * 
    * @Title: insertVerifyCode 
    * @Description: TODO(插入验证码到数据库) 
    * @param @param msg
    * @param @return    设定文件 
    * @return Integer    返回类型 
    * @throws
     */
	public Integer insertVerifyCode(TMsg msg);
	/**
	 * 
	* @Title: selectVerifyCode 
	* @Description: TODO(根据手机号和验证码查询验证码是否有效) 
	* @param @param msgExample
	* @param @return    设定文件 
	* @return List    返回类型 
	* @throws
	 */
	public List<TMsg> selectVerifyCode(TMsgExample msgExample);
	/**
	 * 
	* @Title: updateVerifyCodeStatus 
	* @Description: TODO(根据主键Id修改验证码状态) 
	* @param @param id
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer updateVerifyCodeStatus(TMsg msg);
	
	public Integer insertActivation(TActivation activation);
	
}
