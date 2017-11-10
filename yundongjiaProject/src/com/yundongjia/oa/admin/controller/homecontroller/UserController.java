package com.yundongjia.oa.admin.controller.homecontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.po.TAdmin;
import com.yundongjia.oa.admin.service.MenuService;
import com.yundongjia.oa.admin.service.UserService;
import com.yundongjia.oa.admin.vo.UserVo;
import com.yundongjia.oa.realm.userRealm;
import com.yundongjia.oa.utils.BuliderCodeUtil;
import com.yundongjia.oa.utils.IdentifyCodeUtil;
import com.yundongjia.oa.utils.SendMessage;


/**
 * Created by ltlxy on 2016/9/18.
 */

@Controller
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;
    //健身房realm
    @Autowired
    private userRealm gymRealm;
    /**
     * @param msString
     * @param userPassword
     * @param userMobilephoneno
     * @param request
     * @return首次登录重置密码
     */
    @RequestMapping(value = "/gh/configPassword")
    public String configPassword(String msg , String userPassword , String userMobilephoneno ,WebRequest request){
    	Integer result = userService.configPassword(userPassword , userMobilephoneno , msg);
    	if(result != 0){
    		request.setAttribute("message", "密码设置成功", request.SCOPE_REQUEST);
    	}else{
    		request.setAttribute("message", "密码设置失败", request.SCOPE_REQUEST);
    	}
        return "login/login";
    }
    
  
    @RequestMapping("/gh/checkCode")
    @ResponseBody
    public String checkC(String authCode , String phone){
    	Integer id = userService.checkCode(authCode , phone);
    	if(id == null || id == 0 ){
    		return new Gson().toJson(false);
    	}else{
    		return new Gson().toJson(true);
    	}
    }
    
    @RequestMapping(value = "/yundongjia")
    public String gymLoginPage(){
        return "login/login";
    }

    @RequestMapping(value = "/yundongjialogin",method = RequestMethod.GET)
    public String gymloginGet( TAdmin tAdmin, Model model)  {
    	return "redirect:/yundongjia";
    }
    /**
     * 
    * Title: yundongjialogin
    * Description:健身房登录，并将权限存入缓存
    * @author HuangJian
    * @date 2016年12月29日
     */
    @RequestMapping(value = "/yundongjialogin",method = RequestMethod.POST)
    public String gymlogin( TAdmin tAdmin, Model model)  {
    	Subject subject = SecurityUtils.getSubject();
    	try {
			UsernamePasswordToken token=new UsernamePasswordToken(tAdmin.getBackusermobliephone(), tAdmin.getBackuserpwd());
			subject.login(token);
			//登录成功放入缓存
			if(subject.isAuthenticated()){
				PrincipalCollection principals =  subject.getPrincipals();
				AuthorizationInfo info =  gymRealm.getAuthorizationCache().get(principals);
				if(info == null){
					gymRealm.getAuthorizationCache().put(subject.getPrincipals(), gymRealm.manualDoGetAuthorizationInfo(principals));
					
				}else{
					
				}
				return "redirect:/yundongjia/home";
			}
			
		} catch (AuthenticationException e) {
			
			//认证失败
			model.addAttribute("errInfo","输入的用户名或密码有误！");
		}
        model.addAttribute("backusername",tAdmin.getBackusername());
        
       /* int result = userService.gymlogin(baseUser);
        String errInfo = "";
        switch (result){
            case UserVo.USER_VAIL_RESULT_NULL:
                errInfo ="账号不存在";
                break;
            case UserVo.USER_VAIL_RESULT_JIAN:
                return "redirect:/gym/mygym";
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
        model.addAttribute("userName",baseUser.getUserName());
        
        */
        return "forward:/yundongjia";
    }

    
    @RequestMapping("/yundongjia/logout")
    public String gymLogout(){
    	Subject subject = SecurityUtils.getSubject();
    	try {
			subject.logout();
			 this.userService.gymlogout();
		} catch (Exception e) {
			 
		}
       
        return "redirect:/yundongjia";
    }


    @RequestMapping("/yundongjia/getmenu")
    public void getMenu(PrintWriter out){
        System.out.println(this.getLogUserId());

    }

    /**
     * @param phonenum
     * @return发送验证码
     * 2016.11.14 
     */
    @RequestMapping("/gh/sendCode")
    @ResponseBody
    public String sendCode(WebRequest request , String phonenum , String validateCode , HttpServletRequest req){
    	Map info = new HashMap();
    	/*String sessionCode = (String)request.getAttribute("validateCode", request.SCOPE_SESSION);
    	if(validateCode == null || !validateCode.toLowerCase().equals(sessionCode.toLowerCase())){
    		info.put("result", false);
			info.put("message", "图形验证码验证失败！");
			return new Gson().toJson(info);
    	}*/
    	String authCode = IdentifyCodeUtil.createIndentifyCode(true, 6);
    	String ip = req.getHeader("x-forwarded-for");
		if (!checkIP(ip)) {
			ip = req.getHeader("Proxy-Client-IP");
		}
		if (!checkIP(ip)) {
			ip = req.getHeader("WL-Proxy-Client-IP");
		}
		if (!checkIP(ip)) {
			ip = req.getRemoteAddr();
		}
    	Integer result = userService.insetBaseMsg(phonenum , authCode , ip);
    	if (result == -1) {
			info.put("result", false);
			info.put("message", "手机号("+ phonenum +")请求次数过于频繁，请在15分钟后重试！");
			return new Gson().toJson(info);
		}else if(result == -2){
			info.put("result", false);
			info.put("message", "手机号("+ phonenum +")与 IP("+ ip +")请求次数过于频繁，请在15分钟后重试！");
			return new Gson().toJson(info);
		}
    	String data = SendMessage.sendMessage(phonenum, authCode,3);
    	//验证是否发送成功
    	String aa = data;
		String[] am = aa.split(",");
		String a0 = am[0];
		if (!"03".equals(a0)) {
			info.put("result", false);
			info.put("message", "服务器内部错误，请联系管理员！");
		}else if(result == 0){
			info.put("result", false);
			info.put("message", "验证码发送失败！");
		}else{
			info.put("result", true);
			info.put("message", "验证码发送成功！");
		}
        return new Gson().toJson(info);
    }
    
    @RequestMapping("/gh/selectBUByPhone")
	@ResponseBody
	public String selecPhone(String phone){
		Integer result = userService.selectByPhone(phone);
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
     * 响应验证码页面 
     * @return 
     * @throws IOException 
     */  
    @RequestMapping(value="/gh/validateCode")  
    public String validateCode(WebRequest request,HttpServletResponse response) throws IOException{  
        // 设置响应的类型格式为图片格式  
        response.setContentType("image/jpeg");  
        //禁止图像缓存。  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
      
        BuliderCodeUtil vCode = new BuliderCodeUtil(120,40,5,100);
        request.removeAttribute("validateCode", request.SCOPE_SESSION);
        request.setAttribute("validateCode", vCode.getCode() , request.SCOPE_SESSION);  
        vCode.write(response.getOutputStream());  
        return null;  
    }  

    public UserService getUserService() {
        return userService;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    //验证IP
    private boolean checkIP(String ip) {
		if (ip == null || ip.length() == 0 || "unkown".equalsIgnoreCase(ip)
				|| ip.split(".").length != 4) {
			return false;
		}
		return true;
	}
    
    /**
     * @return
     * 系统设置----修改密码 进入页面
     */
    @RequestMapping("/yundongjia/passwd")
    public String toChangePWDPage(){ 
        return "systemmanage/changepasswd/changepasswd";
    }
    
    @RequestMapping("/gym/changepwd")
    public String pymChangePasswd(@RequestParam(value = "oldPasswd") String oldPasswd,@RequestParam(value = "newPasswd" ) String newPasswd,Model model){

        int res = this.userService.updateGymPasswordByOldPassword(this.getLogUserId(), oldPasswd, newPasswd);
        String msg = "";
        if (res == -1){
            msg = "系统故障";
        }else if (res == 0){
            msg = "原密码不正确";
        }else{
            msg = "修改成功";
        }
        model.addAttribute("msg",msg);
        return "systemmanage/changepasswd/changepasswd";
    }
    
    /**
	 * @return 跳转到工作人员页面并获取相关信息 Li XiaoYang 2016.11.4
	 */
	@RequestMapping("/yundongjia/worker")
	public String worker(WebRequest request) {
		PageHelper.startPage(1,super.PAGE_ROW);
		//查询所有工作人员信息
		List<TAdmin> workers = userService.selectBUByUserType();
		//pageNum 当前页 , total 总条数 , pages 总页数 , list 数据
		PageInfo<Map> pi = new PageInfo(workers);
		request.setAttribute("workers", pi, request.SCOPE_REQUEST);
		return "systemmanage/worker/worker";
	}
	
	/**
	 * @return 下一页请求ajax Li XiaoYang 2016.11.6
	 */
	@RequestMapping("/yundongjia/workerNext")
	@ResponseBody
	public String pageNext(Integer page) {
		PageHelper.startPage(page, super.PAGE_ROW);
		List<TAdmin> workers = userService.selectBUByUserType();
		//pageNum 当前页 , total 总条数 , pages 总页数 , list 数据
		PageInfo<Map> pi = new PageInfo(workers);
		return new Gson().toJson(pi);
	}
	
	/**
	 * @return 根据工作人员手机号或工作人员姓名 查询工作人员信息Li XiaoYang 2016.11.5
	 */
	@RequestMapping("/yundongjia/selectBUByphoneOrName")
	@ResponseBody
	public String selectBUByphoneOrName(String searchInfo,Integer page) {
		PageHelper.startPage(page, super.PAGE_ROW);
		List<TAdmin> workers = userService.selectBUByphoneOrName(searchInfo);
		PageInfo<Map> pi = new PageInfo(workers);
		return new Gson().toJson(pi);
	}
	
	/**
	 * @return 跳转到新增工作人员页面 Li XiaoYang 2016.11.4
	 */
	@RequestMapping("/yundongjia/addWorker")
	public String addWorker() {
		return "systemmanage/worker/addWorker";
	}
	
	/**
	 * @return 插入工作人员信息以及操作记录 Li XiaoYang 2016.11.4
	 */
	@RequestMapping("/yundongjia/insertWorker")
	@ResponseBody
	public String insertWorker(WebRequest request , TAdmin baseUser) {
		UserVo userVo = (UserVo) request.getAttribute("userVo", request.SCOPE_SESSION);
		Integer result = userService.insertWorker(baseUser , userVo);
		Map info = new HashMap();
		if (result == 1) {
			info.put("result", true);
			info.put("message", "工作人员添加成功！");
		}else{
			info.put("result", false);
			info.put("message", "工作人员添加失败！");
		}
		return new Gson().toJson(info);
	}
	
	/**
	 * @return逻辑删除工作人员信息 Li XiaoYang 2016.11.4
	 */
	@RequestMapping("/yundongjia/deleteWorker")
	@ResponseBody
	public String deleteWorker(WebRequest request , Integer userId) {
		UserVo userVo = (UserVo) request.getAttribute("userVo", request.SCOPE_SESSION);
		Integer result = userService.deleteWorker(userId , userVo.getUser().getBackuserid());
		Map info = new HashMap();
		if (result == 1) {
			info.put("result", true);
			info.put("message", "工作人员删除成功！");
		}else{
			info.put("result", false);
			info.put("message", "工作人员删除失败！");
		}
		return new Gson().toJson(info);
	}
	
	/**
	 * @return跳转到修改工作人员信息 Li XiaoYang 2016.11.4
	 */
	@RequestMapping("/yundongjia/workerUpdate")
	public String workerUpdate(WebRequest request , Integer userId) {
		TAdmin worker = userService.selectBUById(userId);
		request.setAttribute("worker", worker, request.SCOPE_REQUEST);
		return "systemmanage/worker/workerUpdate";
	}
	
	/**
	 * @return更新工作人员信息 Li XiaoYang 2016.11.4
	 */
	@RequestMapping("/yundongjia/updateWorkerInfo")
	@ResponseBody
	public String updateWorkerInfo(WebRequest request , TAdmin baseUser) {
		UserVo userVo = (UserVo) request.getAttribute("userVo", request.SCOPE_SESSION);
		Integer result = userService.updateWorkerInfo(baseUser , userVo);
		Map info = new HashMap();
		if (result == 1) {
			info.put("result", true);
			info.put("message", "工作人员信息更新成功！");
		}else{
			info.put("result", false);
			info.put("message", "工作人员信息更新失败！");
		}
		return new Gson().toJson(info);
	}
}
