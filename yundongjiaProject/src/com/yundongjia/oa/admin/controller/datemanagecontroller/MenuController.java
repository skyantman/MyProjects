/*
* @author HuangJian
* @date 2017年1月6日
*/
package com.yundongjia.oa.admin.controller.datemanagecontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.google.gson.Gson;
import com.yundongjia.oa.admin.controller.homecontroller.BaseController;
import com.yundongjia.oa.admin.po.TMenu;
import com.yundongjia.oa.admin.po.TOpeartion;
import com.yundongjia.oa.admin.service.MenuService;
import com.yundongjia.oa.admin.service.OpeartionService;
import com.yundongjia.oa.admin.vo.ConstantVo;
import com.yundongjia.oa.admin.vo.MenuVo;
import com.yundongjia.oa.utils.TreeUtil;

/**
 * 
 * Title: com.yundongjia.oa.admin.controller.datemanagecontroller Description:
 * 菜单管理
 * 
 * @author HuangJian
 * @date 2017年1月6日
 */
@Controller
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;
	@Autowired
	private OpeartionService opeartionService;

	public Map<String, Object> param;

	/*
	 * 
	 * Title: list Description: 菜单全查
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月6日
	 */
	@RequestMapping("/datamanage/menuManage")
	public String list(Model model, @RequestParam(required = true, defaultValue = "1") Integer pageNum,
			@RequestParam(required = true, defaultValue = ConstantVo.PAGE_SIZE) Integer pageSize) {
		param = new HashMap<>();
		PageHelper.startPage(pageNum, pageSize);
		param.put("dis", true);
		List<MenuVo> menus = menuService.findTreeBulider(param);
		PageInfo<MenuVo> result = new PageInfo<>(menus);

		// 构建树形结构
		List<MenuVo> tResult = TreeUtil.treeBulider(result.getList());
		result.setList(tResult);
		model.addAttribute("menus", result);
		return "/systemmanage/menu/menuManage";
	}

	/*
	 * 
	 * Title: add Description: 去添加页面
	 * 
	 * @author HuangJian
	 * 
	 * @date 2017年1月6日
	 */
	@RequestMapping("/menu/add")
	public String add(Model model, Integer root, Integer id) {
		// 查询菜单
		if (-1 != id) {
			TMenu menu = menuService.selectBaseMenuById(id);
			model.addAttribute("menu", menu);
		} else {
			model.addAttribute("menu", null);
		}

		model.addAttribute("isRoot", root);
		return "/systemmanage/menu/add";
	}

	/*
	 * 
	* Title: saveOrUpdate
	* Description: 添加菜单
	* @author HuangJian
	* @date 2017年1月9日
	 */
	@RequestMapping("/menu/saveupdate")
	@ResponseBody
	public String saveOrUpdate(TMenu menu) {
		int result = 0;
		boolean r = true;// 是否根节点
		if (menu.getMenuIsroot() == 0) {
			r = false;
		}
		result = menuService.saveBaseMenu(menu, r);

		// 操作记录
		TOpeartion record = new TOpeartion();
		record.setOpeartionAdminId(this.getLogUserId());
		record.setOpeartionInfo("创建菜单");
		record.setOpeartionById(result);
		record.setOpeartionType(ConstantVo.TYPE_MENU);
		opeartionService.saveOpeartion(record);
		
		return new Gson().toJson(result);
	}

	/*
	 * 
	* Title: deleteMenu
	* Description: 删除菜单
	* @author HuangJian
	* @date 2017年1月9日
	 */
	@RequestMapping("/menu/deletebyid")
	@ResponseBody
	public String deleteMenu(Integer id) {
		int result = 0;
		result = menuService.deleteBaseMenuById(id);

		TOpeartion record = new TOpeartion();
		record.setOpeartionAdminId(this.getLogUserId());
		record.setOpeartionInfo("删除根菜单");
		record.setOpeartionType(ConstantVo.TYPE_MENU);
		record.setOpeartionById(id);
		opeartionService.saveOpeartion(record);

		return new Gson().toJson(result);
	}

	/*
	 * 
	* Title: checkMenuPowerid
	* Description: 检查标识是否存在
	* @author HuangJian
	* @date 2017年1月9日
	 */
	@RequestMapping("/menu/checkpowerid")
	@ResponseBody
	public String checkMenuPowerid(String powerid) {
		Integer count = 0;
		List<TMenu> list = menuService.selectBaseMenuByPowerid(powerid);
		count = list.size();
		return new Gson().toJson(count);
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

}
