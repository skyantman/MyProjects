package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TAttach;
import com.yundongjia.oa.admin.service.AttachService;

/**
* Title: AttachController
* Description: 图片管理
* @author HuangJian
* @date 2017年4月24日
*
*/
@Controller
public class AttachController extends BaseController{

	@Autowired
	private AttachService attachService;
	@RequestMapping("/yundongjia/attachlist")
	public String list(Model model){
		
		return "/systemmanage/attach/list";
	}
	
	@RequestMapping("/yundongjia/findattach")
	@ResponseBody
	public String finAttach(Model model,String id,Integer type){
		Integer temp = -1;
		if(StringUtils.isEmpty(id)){
			
		}else{
			temp = Integer.parseInt(id);
		}
		
		List<TAttach> list =  attachService.getAttachByActivityId(temp, type);
		model.addAttribute("list", list);
		return new Gson().toJson(list);
	}
	@RequestMapping("/yundongjia/deleteattachbyid")
	@ResponseBody
	public String deleteAttachById(Integer attachId){
		int result = 0;
		result = attachService.deleteAttachById(attachId);
		return new Gson().toJson(result);
	}
}
