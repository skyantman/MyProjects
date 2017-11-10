package com.yundongjia.oa.admin.controller.datemanagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yundongjia.oa.admin.controller.homecontroller.BaseController;

@Controller
public class Test extends BaseController{

	@RequestMapping("/yundongjia/wordtest ")
	public String test(){
		System.out.println("okkkkkkkkkkk");
		return "/systemmanage/test/layers";
	}
}
