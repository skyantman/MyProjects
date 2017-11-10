/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.app.user.service;

import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yundongjia.oa.admin.po.TAttach;

public interface AppAttachService {

	/**
	* Title: insertAttach
	* Description: 保存图片
	* @param attach
	* @return
	* @author HuangJian
	* @date 2017年1月19日
	*/
	public Integer insertAttach(TAttach attach);
	
	 
	/**
	* Title: insertAttach
	* Description: 保存图片
	* @param attach
	* @param file
	* @return
	* @author HuangJian
	* @date 2017年2月11日
	*/
	public Integer insertAttach(TAttach attach,MultipartFile file);
	/**
	* Title: getAttachByActivityId
	* Description: 根据活动id查询图片信息
	* @param activity
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	public List<TAttach> getAttachByActivityId(Integer activity,Integer type);
	
	 
	/**
	* Title: updateAttachByPosiId
	* Description: 根据排序位置和活动id 修改图片路径
	* @param attachId
	* @param path
	* @param position
	* @return
	* @author HuangJian
	* @date 2017年1月20日
	*/
	public Integer updateAttachByPosiId(Integer activityId,String path,Integer position,Integer type);
	
	 
	/**
	* Title: deleteAttachByPorIdAndAttachType
	* Description: 删除图片
	* @param attach
	* @return
	* @author HuangJian
	* @date 2017年2月11日
	*/
	public Integer deleteAttachByPorIdAndAttachType(TAttach attach);
}

