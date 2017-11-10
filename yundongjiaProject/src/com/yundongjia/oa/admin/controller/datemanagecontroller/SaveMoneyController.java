/**
* @author HuangJian
* @date 2017年2月27日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yundongjia.oa.admin.service.SaveMoneyService;
import com.yundongjia.oa.admin.vo.ConstantVo;

@Controller
public class SaveMoneyController {

	@Autowired
	private SaveMoneyService saveMoneyService;
	
	public PageInfo<Map<String, Object>> pageInfo;
	
	public List<Map<String, Object>> list;
	@RequestMapping("/yundongjia/savemoneylist")
	public String saveMoneyList(Model model,  @RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		list = saveMoneyService.findSaveMoneyList();
		pageInfo=new PageInfo<>(list);
		
		
		Map<String, Object> statis =  saveMoneyService.selectMoneyStatis();
		
		model.addAttribute("sm", pageInfo);
		model.addAttribute("statis", statis);
		return "/systemmanage/finance/storedlist";
	}
	
}

