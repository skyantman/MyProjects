package com.yundongjia.app.user.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yundongjia.app.user.service.BodyFatService;
import com.yundongjia.oa.admin.mapper.TBodyfatMapper;
import com.yundongjia.oa.admin.po.TBodyfat;
import com.yundongjia.oa.admin.po.TBodyfatExample;

/** * @author  作者WangLi: * @date 创建时间：2017年2月4日 上午10:49:31 * @version 1.0 * @parameter  * @since  * @return  */
@Service
public class BodyFatServiceImpl implements BodyFatService {

	@Autowired
	private TBodyfatMapper bodyfatMapper;
	
	
	@Override
	public Integer insertBodyFatInfo(TBodyfat bodyfat) {
		int i = this.bodyfatMapper.insert(bodyfat);
		return i;
	}


	@Override
	public List<TBodyfat> selectUserBodyFatInfo(TBodyfatExample example) {
		List<TBodyfat> list = this.bodyfatMapper.selectByExample(example);
		return list;
	}

}
