package com.yundongjia.oa.admin.controller.homecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;




/**
 * Created by ltlxy on 2016/9/18.
 */

@Controller
public class PageController extends BaseController{

    @RequestMapping(value = "/yundongjia/left")
    public String yundongjialeft(){
        return "layout/yundongjiaLeft";
    }
    
    @RequestMapping(value = "/yundongjia/top")
    public String yundongjiatop(){
        return "layout/yundongjiaTop";
    }
    
    @RequestMapping(value = "/yundongjia/home")
    public String yundongjiahome(WebRequest request){
    	if(super.session.getAttribute("userVo") == null){
    		return "login/login";
    	}
        return "layout/yundongjiahome";
    }
    

    @RequestMapping("/test/file")
    public String toFileTest(){
        return "test/filetest";
    }

    


}
