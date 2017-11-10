package com.yundongjia.oa.utils;

import java.util.ArrayList;
import java.util.List;

import com.yundongjia.oa.admin.vo.MenuVo;

/**
 * 
* Title:com.yundongjia.oa.utils 
* Description:得到数据组装成树
* @author HuangJian
* @date 2016年10月27日
 */
public class TreeUtil {

	public static List<MenuVo> nodes = new ArrayList<MenuVo>();
	
	public TreeUtil(List<MenuVo> list) {
		TreeUtil.nodes=list;
	}
	
	/** 组装树开始 */
	/**
	 * 
	* Title: 
	* Description:构建树形  (入口)
	* @author HuangJian
	* @date 2016年10月22日
	 */
	public static List<MenuVo> treeBulider(List<MenuVo> list) {
		TreeUtil.nodes=list;
		List<MenuVo> treeNodes = new ArrayList<MenuVo>();

		List<MenuVo> rootNodes = getRootNodes();

		for (MenuVo rootNode : rootNodes) {

			buildChildNodes(rootNode);

			treeNodes.add(rootNode);

		}

		return treeNodes;
	}
	/**
	 * 
	* Title: 
	* Description:递归子节点
	* @author HuangJian
	* @date 2016年10月22日
	 */
	public static void buildChildNodes(MenuVo node) {

		List<MenuVo> children = getChildNodes(node);

		if (!children.isEmpty()) {

			for (MenuVo child : children) {

				buildChildNodes(child);

			}

			node.setMenuVoList(children);

		}

	}
	/**
	 * 
	* Title: 
	* Description:获得根节点下的所有子节点
	* @author HuangJian
	* @date 2016年10月22日
	 */
	public static List<MenuVo> getChildNodes(MenuVo pnode) {

		List<MenuVo> childNodes = new ArrayList<MenuVo>();

		for (MenuVo n : nodes) {
			// 规定0是子节点
			if (pnode.getMenuId().intValue() == Integer.parseInt(n.getMenuPid()) && n.getMenuIsroot() == 0) {
				
				childNodes.add(n);

			}

		}

		return childNodes;

	}
	/**
	 * 
	* Title: 
	* Description:获得集合中的所有根节点
	* @author HuangJian
	* @date 2016年10月22日
	 */
	public static List<MenuVo> getRootNodes() {

		List<MenuVo> rootNodes = new ArrayList<MenuVo>();

		for (MenuVo n : nodes) {
			if (rootNode(n)) {

				rootNodes.add(n);

			}

		}

		return rootNodes;

	}

	/**
	 * 
	 * Title: Description:判断是否是根节点
	 * 
	 * @author HuangJian
	 * @date 2016年10月22日
	 */
	public static boolean rootNode(MenuVo node) {

		boolean isRootNode = true;

		for (MenuVo n : nodes) {
			// 规定0是子节点 ，1是根节点
			if (Integer.parseInt(node.getMenuPid()) == n.getMenuId().intValue() && node.getMenuIsroot() == 0) {

				isRootNode = false;

				break;

			}

		}

		return isRootNode;

	}

	/** 组装树结束 */
	
	
	
}
