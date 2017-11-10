/**
* @author HuangJian
* @date 2017年6月9日
*/
package com.yundongjia.app.user.service;

import java.util.List;
import java.util.Map;

import com.yundongjia.oa.admin.po.TComment;

/**
* Title: com.yundongjia.app.user.service 
* Description: 评论
* @author HuangJian
* @date 2017年6月9日
*/
public interface AppCommentService {

	/**
	* Title: findCommentByTypeId
	* Description: 根据类型和ID查询评论
	* @param param
	* @return  
	* @author HuangJian
	* @date 2017年6月9日
	*/
	public List<TComment> findCommentByTypeId(Map<String, Object> param);
}

