package com.ggblog.modules.sys.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggblog.common.annotation.Log;
import com.ggblog.common.domain.ApiModel;
import com.ggblog.common.domain.SysPage;
import com.ggblog.modules.sys.domain.SysMenu;
import com.ggblog.modules.sys.service.SysMenuService;

/**
 * 菜单控制器
 * 
 * @author 44359
 *
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "sys/menu/";

	@Autowired
	private SysMenuService menuService;


	/**
	 * 跳转list页面
	 * 
	 * @param model
	 * @return
	 */
	@Log("跳转菜单list页面")
	@RequiresPermissions("sys:menu:list") // 权限管理;
	@GetMapping("")
	public String list(Model model) {
		return prefix + "list";
	}

	@Log("添加菜单")
	@GetMapping("/add/{id}")
	@RequiresPermissions("sys:menu:add") // 权限管理;
	public String add(@PathVariable String id,Model model) {
		SysMenu menu = menuService.get(id);
		if(menu.getType()==1) {
			menu.setType(2);
		}
		model.addAttribute("menu", menu);
		return prefix + "add";
	}

	/**
	 * 编辑菜单
	 * 
	 * @param id
	 * @param menu
	 * @return
	 */
	@GetMapping("/edit/{id}")
	@Log("编辑菜单")
	@RequiresPermissions("sys:menu:edit")
	public String edit(@PathVariable String id, Model model) {
		SysMenu menu = menuService.get(id);
		SysMenu parentMenu = menuService.get(menu.getParentId());
		model.addAttribute("parentMenu", parentMenu);
		model.addAttribute("menu", menu);
		return prefix + "edit";
	}

	/**
	 * 获取全部菜单
	 * 
	 * @return
	 */
	@GetMapping("/list")
	@Log("获取全部菜单列表")
	@RequiresPermissions("sys:menu:list") // 权限管理;
	@ResponseBody
	public ApiModel list(SysMenu menu) {
		SysPage<SysMenu> page = menuService.findPage(menu);
		return ApiModel.success(page);
	}

	/**
	 * 新增菜单
	 * 
	 * @param id
	 * @param menu
	 * @return
	 */
	@PostMapping("/insert")
	@Log("新增菜单")
	@RequiresPermissions("sys:menu:add") // 权限管理;
	@ResponseBody
	public ApiModel insert(SysMenu sysMenu) {
		int insertLines = menuService.insert(sysMenu);
		if (insertLines > 0) {
			return ApiModel.success(insertLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 修改菜单
	 * 
	 * @param id
	 * @param menu
	 * @return
	 */
	@PostMapping("/update")
	@Log("修改菜单")
	@RequiresPermissions("sys:menu:edit") // 权限管理;
	@ResponseBody
	public ApiModel update(SysMenu sysMenu) {
		int updateLines = menuService.update(sysMenu);
		if (updateLines > 0) {
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 根据id删除菜单
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/delete/{id}")
	@Log("根据id删除菜单")
	@RequiresPermissions("sys:menu:del") // 权限管理;
	@ResponseBody
	public ApiModel delete(@PathVariable String id) {
		int deleteLines = menuService.delete(id);
		SysMenu menu = new SysMenu();
		menu.setParentId(id);
		//查询该菜单的所有子菜单
		List<SysMenu> menuList = menuService.findList(menu);
		//循环删除
		if(menuList!=null&&menuList.size()>0) {
			for (SysMenu sysMenu : menuList) {
				deleteLines+=menuService.delete(sysMenu);
			}
		}
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 获取菜单树
	 * 
	 * @param id
	 * @return
	 */
	//@RequiresPermissions("sys:menu:del")
	@GetMapping("/tree")
	@Log("获取全部菜单树")
	@ResponseBody
	public ApiModel tree() {
		List<SysMenu> menuList = menuService.findList(new SysMenu());
		return   new ApiModel("0", "ok",menuList.size(), menuList);
	}
	
	
	
	/**
	 * 获取角色菜单树
	 * 
	 * @param id
	 * @return
	 */
	//@RequiresPermissions("sys:menu:del")
	@GetMapping("/tree/{roleId}")
	@Log("获取菜单树")
	@ResponseBody
	public ApiModel tree(@PathVariable String roleId) {
		return ApiModel.success(menuService.getTree().size(), menuService.getTree(roleId));
	}
}
