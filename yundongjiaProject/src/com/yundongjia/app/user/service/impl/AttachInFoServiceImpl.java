package com.yundongjia.app.user.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AttachInFoService;
import com.yundongjia.app.user.service.BodyFatService;
import com.yundongjia.oa.admin.mapper.TAttachMapper;
import com.yundongjia.oa.admin.mapper.TBodyfatMapper;
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TAttachExample;
import com.yundongjia.oa.admin.po.TBodyfat;
import com.yundongjia.oa.admin.po.TBodyfatExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:49:31 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class AttachInFoServiceImpl implements AttachInFoService {

	@Autowired
	private TAttachMapper attachMapper;

	@Override
	public List<TAttach> selecAttach(TAttachExample example) {
		List<TAttach> list = this.attachMapper.selectByExample(example);
		return list;
	}
	
	

}
