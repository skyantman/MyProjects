package com.yundongjia.oa.admin.controller.homecontroller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.yundongjia.oa.admin.po.TRole;
import com.yundongjia.oa.admin.service.AuthService;
import com.yundongjia.oa.admin.service.MenuService;
import com.yundongjia.oa.admin.service.UserService;
import com.yundongjia.oa.admin.vo.MenuVo;
import com.yundongjia.oa.admin.vo.UserVo;
import com.yundongjia.oa.realm.userRealm;

import net.sf.json.JSONObject;
import sun.text.SupplementaryCharacterData;

/**
 * Created by ltlxy on 2016/9/29.
 */
@Controller
public class AuthController extends BaseController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;
    @Autowired
    private userRealm gymRealm;

    /**
     * 权限管理页面
     * @param model
     * @return
     */
    @RequestMapping("/yundongjia/role")
    public String rolemanage(Model model , Integer page , Integer rows){
    	if(page == null || page == 0){
    		page = 1;
    	}
    	if(rows == null || rows == 0){
    		rows  = super.PAGE_ROW;
    	}
    	PageHelper.startPage(page, rows);
        List<TRole> roles = this.authService.selectRoleByStudioId();
        PageInfo<Map> pi = new PageInfo(roles);
        List<MenuVo> menuVos = this.menuService.selectGYMTree();
        List<Map> userAll = this.authService.searchBUByType();
        List<Map> noAuth = new ArrayList();
        for (Map a : userAll) {
 			if((Integer)a.get("backuserRoleId") == 0){
 				noAuth.add(a);
 			}
 		}
        model.addAttribute("noAuth",noAuth);
        model.addAttribute("menuVos",menuVos);
        model.addAttribute("roles",pi);
        return "systemmanage/auth/authManage";
    }

    /**
     * 查询角色下的菜单和权限id集合
     * @param roleId
     */
    @RequestMapping("/yundongjia/selectWorkerAuth/{roleId}")
    public void selectWorkerAuth(@PathVariable(value = "roleId") Integer roleId) throws IOException {
    	 List<Map> userAll = this.authService.searchBUByTypeARole(roleId);
         List<Map> haveAuth = new ArrayList();
         for (Map a : userAll) {
 			if((Integer)a.get("backuserRoleId") != 0){
 				haveAuth.add(a);
 			}
 		}
        JSONObject json = new JSONObject();
        json.put("haveAuth",haveAuth);
        this.writeJSONStr(json.toString());
    }
    
    /**
     * 添加角色
     * @param role
     * @param authStr
     * @param menuStr
     * @return
     * @throws Exception
     */
    @RequestMapping("/yundongjia/saverole")
    @ResponseBody
    public String saveRole(TRole role,@RequestParam(value = "authStr",required = false) String[] authStr,@RequestParam(value = "menuStr",required = false) String[] menuStr) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	role.setRoleCreatedate(simpleDateFormat.format(new Date()));
        role.setRoleOperatorid(this.getLogUserId());
        role.setRoleIsdel("0");
        int result = this.authService.insertRole(role,authStr,menuStr);
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
			info.put("message", "角色保存成功!");
		} else {
			info.put("result", false);
			info.put("message", "角色保存失败！");
		}
        return new Gson().toJson(info);
    }

    @RequestMapping("/yundongjia/delrole/{roleId}")
    @ResponseBody
    public String delRole(@PathVariable(value = "roleId") Integer roleId){
    	Map<String, Object> param=new HashMap<>();
    	param.put("roleId", roleId);
    	param.put("operation", this.getLogUserId());
        int result = this.authService.delectRoleById(param);
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
			info.put("message", "角色删除成功!");
		} else {
			info.put("result", false);
			info.put("message", "角色删除失败！");
		}
        return new Gson().toJson(info);
    }

    /**
     * 查询角色下的菜单和权限id集合
     * @param roleId
     */
    @RequestMapping("/yundongjia/getroleinfo/{roleId}")
    public void getRoleInfo(@PathVariable(value = "roleId") Integer roleId) throws IOException {
        List<Integer> authIds = this.authService.selectAutoIdsByRoleId(roleId);
        List<Integer> menuIds = this.authService.selectMenuIdsByRoleId(roleId);
        JSONObject json = new JSONObject();
        json.put("authIds",authIds);
        json.put("menuIds",menuIds);
        this.writeJSONStr(json.toString());
    }

    @RequestMapping("/yundongjia/updaterole")
    @ResponseBody
    public String updateRole(TRole role,@RequestParam(value = "authStr",required = false) String[] authStr,@RequestParam(value = "menuStr",required = false) String[] menuStr) throws Exception{
        int result = this.authService.updateRole(role,authStr,menuStr,this.getLogUserId());
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
			info.put("message", "角色更新成功!");
			//重新存入权限标识
			try {
				UserVo user = (UserVo) this.request.getSession().getAttribute("userVo");
				Subject subject = SecurityUtils.getSubject(); 
				 
				SimplePrincipalCollection principalCollection = new SimplePrincipalCollection(user.getUser().getBackusername(), userRealm.GYM_REAML_NAME);
				subject.runAs(principalCollection);
				gymRealm.getAuthorizationCache().remove(subject.getPrincipals());
				subject.releaseRunAs();
			} catch (Exception e) {
				 
			}
		} else {
			info.put("result", false);
			info.put("message", "角色更新失败！");
		}
        return new Gson().toJson(info);
    }

    @RequestMapping("/yundongjia/selectRoleName")
    @ResponseBody
    public String  selectRoleName(String roleName){
    	Integer result = this.authService.selectRoleName(roleName);
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
		} else {
			info.put("result", false);
		}
        return new Gson().toJson(info);
    }
    
    @RequestMapping("/yundongjia/updateAuthRole")
    @ResponseBody
    public String updateAuthRole(String oldUserId , String newUserId , Integer roleId){
    	Integer result = authService.updateAuthRole(oldUserId , newUserId , roleId);
        Map info = new HashMap();
		if (result != 0) {
			info.put("result", true);
			info.put("message", "权限分配成功!");
		} else {
			info.put("result", false);
			info.put("message", "权限分配失败！");
		}
        return new Gson().toJson(info);
    }

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
}
