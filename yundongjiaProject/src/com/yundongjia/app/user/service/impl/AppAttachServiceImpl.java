/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.app.user.service.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yundongjia.app.user.service.AppAttachService;
import com.yundongjia.oa.admin.mapper.TAttachMapper;
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TAttachExample;

@Service
public class AppAttachServiceImpl implements AppAttachService{

	@Autowired
	private TAttachMapper attachMapper;
	@Override
	public Integer insertAttach(TAttach attach) {
		return attachMapper.insertSelective(attach);
	}
	@Override
	public List<TAttach> getAttachByActivityId(Integer activity,Integer type) {
		TAttachExample example = new TAttachExample();
		example.createCriteria().andIsdelEqualTo(0).andProidEqualTo(activity).andAttachtypeEqualTo(type);
		example.setOrderByClause("imgOrderNum asc");
		return attachMapper.selectByExample(example);
	}
	@Override
	public Integer updateAttachByPosiId(Integer activityId, String path, Integer position,Integer type) {
		Map<String, Object> param=new HashMap<>();
		param.put("activityId", activityId);
		param.put("position", position);
		param.put("path", path);
		
		int result = 0;
		//先查询一遍  如果有就修改没有就保存
		TAttach attach =  attachMapper.selectAttachByPosAid(param);
		if(null == attach){
			TAttach t = new TAttach();
			t.setPath(path);
			t.setImgordernum(position);
			t.setProid(activityId);
			t.setAttachtype(type);
			result = attachMapper.insertSelective(t);
		}else{
			result = attachMapper.updateAttachByPosiAid(param);
		}
		return result;
	}
	@Override
	public Integer deleteAttachByPorIdAndAttachType(TAttach attach) {

		return attachMapper.deleteByAttachPorIdAndAttType(attach);
	}
	@Override
	public Integer insertAttach(TAttach attach, MultipartFile file) {
		if(file !=null){
			BufferedImage bufferedImage;
			try {
				bufferedImage = ImageIO.read(file.getInputStream());
				attach.setImgheight(String.valueOf(bufferedImage.getHeight()));//图片高
				attach.setImgwidth(String.valueOf(bufferedImage.getWidth())); //图片宽
			} catch (IOException e) {
				 
			}
			
		}
		
		
		
		return attachMapper.insertSelective(attach);
	}

}

