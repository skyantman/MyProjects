package com.yundongjia.app.user.service;

import java.util.List;

import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TAttachExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:49:12 * @version 1.0 * @parameter  * @since  * @return  */
public interface AttachInFoService {
	
	public List<TAttach> selecAttach(TAttachExample example);
	
}
