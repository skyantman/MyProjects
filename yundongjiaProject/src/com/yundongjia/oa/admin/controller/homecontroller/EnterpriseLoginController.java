package com.yundongjia.oa.admin.controller.homecontroller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;
import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.service.EnterpriseLoginService;
import com.yundongjia.oa.admin.vo.UserVo;

@Controller
public class EnterpriseLoginController extends BaseController{
	@Autowired
	private EnterpriseLoginService enterpriseLoginService;

	@RequestMapping("/enterprise")
	public String enterprise(){
		return "/enterprise/login/login";
	}

    @RequestMapping(value = "/enterprise/login",method = RequestMethod.GET)
    public String gymloginGet( TAdmin tAdmin, Model model)  {
    	return "redirect:/enterprise";
    }
	
	@RequestMapping(value = "/enterprise/login" ,method = RequestMethod.POST)
	public String login(String backusermobliephone ,String backuserpwd , Model model){
		int result = enterpriseLoginService.enterpriseLogin(backusermobliephone , backuserpwd ,super.session);
        String errInfo = "";
        switch (result){
            case UserVo.USER_VAIL_RESULT_NULL:
                errInfo ="账号不存在";
                break;
            case UserVo.USER_VAIL_RESULT_JIAN:
            	
                return "redirect:/enterprise/home";
            case UserVo.USER_VAIL_RESULT_PSERR:
                errInfo = "密码错误";
                break;
            case UserVo.USER_VAIL_RESULT_TING:
                errInfo = "账号已经停用";
                break;
            case UserVo.USER_VAIL_RESULT_YC:
                errInfo = "账号异常,请联系管理员";
                break;
        }
        model.addAttribute("errInfo",errInfo);
        model.addAttribute("userName","");
		return "/enterprise/login/login";
	}
	
	@RequestMapping(value = "/gh/selectPhone")
	@ResponseBody
	public String selectBUByPhone(String phone){
		Integer result = enterpriseLoginService.selectByPhone(phone);
		Map info = new HashMap();
		if(result == null){
			info.put("result", true);
		}else{
			info.put("result", false);
			info.put("message", "该手机号未注册");
		}
		return new Gson().toJson(info);
	}
	
	
	/**
	 * @param request
	 * @return验证是否登陆成功
	 */
	@RequestMapping(value = "/enterprise/home")
    public String yundongjiahome(WebRequest request){
		UserVo userVo = (UserVo) super.session.getAttribute("userVo");
    	if(userVo == null){
    		return "/enterprise/login/login";
    	}
    	Map<String , Object> result = enterpriseLoginService.findenterpriseCardInfo(userVo.getEnterpriseUser().getEnterpriseid());
        request.setAttribute("cardInfo", result, request.SCOPE_REQUEST);
    	return "/enterprise/layout/enterprisehome";
    }
	
	 /**
     * @param msString
     * @param userPassword
     * @param userMobilephoneno
     * @param request
     * @return首次登录重置密码
     */
    @RequestMapping(value = "/gh/enterpriseconfigPassword")
    public String enterpriseconfigPassword(String msg , String userPassword , String userMobilephoneno ,WebRequest request){
    	Integer result = enterpriseLoginService.configPassword(userPassword , userMobilephoneno , msg);
    	if(result != 0){
    		request.setAttribute("message", "密码设置成功", request.SCOPE_REQUEST);
    	}else{
    		request.setAttribute("message", "密码设置失败", request.SCOPE_REQUEST);
    	}
        return "/enterprise/login/login";
    }
    
    @RequestMapping("/enterprise/logout")
    public String gymLogout(){
    	super.session.removeAttribute("userVo");
        return "redirect:/enterprise";
    }
    
    @RequestMapping("/enterprise/configPwdPage")
    public String configPwdPage(){
        return "/enterprise/configPwd/configPwd";
    }
    
    @RequestMapping("/enterprise/changepwd")
    public String pymChangePasswd(@RequestParam(value = "oldPasswd") String oldPasswd,@RequestParam(value = "newPasswd" ) String newPasswd,Model model){
    	UserVo userVo = (UserVo) this.session.getAttribute("userVo");
        int res = this.enterpriseLoginService.updateGymPasswordByOldPassword(userVo.getEnterpriseUser().getRowid(), oldPasswd, newPasswd);
        String msg = "";
        if (res == -1){
            msg = "系统故障";
        }else if (res == 0){
            msg = "原密码不正确";
        }else{
            msg = "修改成功";
        }
        model.addAttribute("msg",msg);
        return "/enterprise/configPwd/configPwd";
    }
}
