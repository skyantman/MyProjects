package com.yundongjia.app.user.service;

import java.util.List;

import com.yundongjia.oa.admin.po.TBodyfat;
import com.yundongjia.oa.admin.po.TBodyfatExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:49:12 * @version 1.0 * @parameter  * @since  * @return  */
public interface BodyFatService {
	
	public Integer insertBodyFatInfo(TBodyfat bodyfat);
	public List<TBodyfat> selectUserBodyFatInfo(TBodyfatExample example);
	
}
