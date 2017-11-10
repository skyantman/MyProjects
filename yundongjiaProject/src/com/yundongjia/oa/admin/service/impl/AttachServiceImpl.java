/**
* @author HuangJian
* @date 2017年1月19日
*/
package com.yundongjia.oa.admin.service.impl;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Field;
import com.yundongjia.app.user.service.AppConfigService;
import com.yundongjia.oa.admin.mapper.TAttachMapper;
import com.yundongjia.oa.admin.mapper.TConfigMapper;
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.po.TAttachExample;
import com.yundongjia.oa.admin.po.TAttachExample.Criteria;
import com.yundongjia.oa.admin.po.TConfig;
import com.yundongjia.oa.admin.po.TConfigExample;
import com.yundongjia.oa.admin.service.AttachService;
import com.yundongjia.oa.utils.FtpUtil;

@Service
public class AttachServiceImpl implements AttachService{

	@Autowired
	private TAttachMapper attachMapper;
	@Autowired
	private TConfigMapper configMapper;
	
	@Override
	public Integer insertAttach(TAttach attach) {
		return attachMapper.insertSelective(attach);
	}
	@Override
	public List<TAttach> getAttachByActivityId(Integer activity,Integer type) {
		TAttachExample example = new TAttachExample();
		
		//example.createCriteria().andIsdelEqualTo(0).andProidEqualTo(activity).andAttachtypeEqualTo(type);
		
		Criteria criteria =  example.createCriteria();
		criteria.andIsdelEqualTo(0);
		if(-1 != activity){
			criteria.andProidEqualTo(activity);
		}
		if(-1 != type){
			criteria.andAttachtypeEqualTo(type);
		}
		example.setOrderByClause("imgOrderNum asc");
		
		List<TAttach> attachs =   attachMapper.selectByExample(example);
		TConfigExample example2 = new TConfigExample();
		example2.createCriteria().andCnameEqualTo("IMAGE_VIEW_URL_BEFORE");
		if(attachs != null && attachs.size()>0){
			for(TAttach aa :attachs){
				String path = aa.getPath();
				if(null !=path || !"".equals(path)){
					 
					List<TConfig> list =  configMapper.selectByExample(example2);
					if(list != null && list.size()>0){
						aa.setPath(list.get(0).getCvalue()+"/"+aa.getPath());
					}
				}
			}
		}
		return attachs;
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
		TAttachExample example = new TAttachExample();
		example.createCriteria()
		.andProidEqualTo(attach.getProid())
		.andAttachtypeEqualTo(attach.getAttachtype());
		List<TAttach> list = this.attachMapper.selectByExample(example);
		for(TAttach i:list){
			boolean b = FtpUtil.removeFile(i.getPath());
		}
		
		return attachMapper.deleteByAttachPorIdAndAttType(attach);
	}
	@Override
	public Integer insertAttach(TAttach attach, MultipartFile file) {
		if(file !=null){
			//System.out.println(file.getContentType()+"----------------image/png---");
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
	@Override
	public Integer deleteAttachByPorIdAndAttachType(TAttach attach, List<Integer> indexs) {
		TAttachExample example = new TAttachExample();
		example.createCriteria()
		.andProidEqualTo(attach.getProid())
		.andAttachtypeEqualTo(attach.getAttachtype())
		.andImgordernumIn(indexs);
		List<TAttach> list = this.attachMapper.selectByExample(example);
		for(TAttach i:list){
			boolean b = FtpUtil.removeFile(i.getPath());
		}
		
		return attachMapper.deleteByExample(example);
	}
	@Override
	public Integer deleteAttachById(Integer attachId) {
		TAttach attach = attachMapper.selectByPrimaryKey(attachId);
		boolean b = FtpUtil.removeFile(attach.getPath());
		return attachMapper.deleteByPrimaryKey(attachId);
	}

}

