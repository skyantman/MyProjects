package com.yundongjia.app.user.service;

import java.util.List;

import com.yundongjia.oa.admin.po.TActivation;
import com.yundongjia.oa.admin.po.TActivationExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:49:12 * @version 1.0 * @parameter  * @since  * @return  */
public interface CardActivationService {
	
	public List<TActivation> selectActivationCode(TActivationExample example );
	
	public Integer updateActivationInfobyId(TActivation activation);
	
}
