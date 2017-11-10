/**
* @author HuangJian
* @date 2017年6月9日
*/
package com.yundongjia.app.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yundongjia.app.user.service.AppCommentService;
import com.yundongjia.oa.admin.mapper.TCommentMapper;
import com.yundongjia.oa.admin.po.TComment;
import com.yundongjia.oa.admin.po.TCommentExample;


@Service
public class AppCommentServiceImpl implements AppCommentService{

	@Autowired
	private TCommentMapper appCommentMapper;
	
	@Override
	public List<TComment> findCommentByTypeId(Map<String, Object> param) {
		Integer type = Integer.parseInt(String.valueOf(param.get("typeId")));
		Integer id = Integer.parseInt(String.valueOf(param.get("dataId")));
		TCommentExample example = new TCommentExample();
		example.createCriteria().andStatusEqualTo(1).andDataidEqualTo(id)
		.andTypeEqualTo(type);
		example.setOrderByClause("createDate desc");
		return appCommentMapper.selectByExample(example);
	}

	
	 

}

