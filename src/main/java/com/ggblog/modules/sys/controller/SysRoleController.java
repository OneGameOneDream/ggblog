package com.ggblog.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggblog.common.annotation.Log;
import com.ggblog.common.domain.ApiModel;
import com.ggblog.common.domain.SysPage;
import com.ggblog.modules.sys.domain.SysRole;
import com.ggblog.modules.sys.domain.SysRoleMenu;
import com.ggblog.modules.sys.service.SysRoleMenuService;
import com.ggblog.modules.sys.service.SysRoleService;

import cn.hutool.core.util.StrUtil;

/**
 * 角色控制器
 * 
 * @author 44359
 *
 */
@Controller
@RequestMapping("sys/role")
public class SysRoleController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "sys/role/";

	@Autowired
	private SysRoleService roleService;
	@Autowired
	private SysRoleMenuService roleMenuService;

	/**
	 * 跳转list页面
	 * 
	 * @param model
	 * @return
	 */
	@Log("跳转角色list页面")
	@RequiresPermissions("sys:role:list") // 权限管理;
	@GetMapping("")
	public String list(Model model) {
		return prefix + "list";
	}

	@Log("添加角色")
	@GetMapping("/add")
	@RequiresPermissions("sys:role:add") // 权限管理;
	public String add(Model model) {
		return prefix + "add";
	}

	/**
	 * 编辑角色
	 * 
	 * @param id
	 * @param role
	 * @return
	 */
	@GetMapping("/edit/{id}")
	@Log("编辑角色")
	@RequiresPermissions("sys:role:edit")
	public String edit(@PathVariable String id, Model model) {
		SysRole role = roleService.get(id);
		model.addAttribute("role", role);
		return prefix + "edit";
	}

	/**
	 * 获取全部角色
	 * 
	 * @return
	 */
	@GetMapping("/list")
	@Log("获取全部角色列表")
	@RequiresPermissions("sys:role:list") // 权限管理;
	@ResponseBody
	public ApiModel list(SysRole role) {
		SysPage<SysRole> page = roleService.findPage(role);
		return ApiModel.success(page);
	}

	/**
	 * 新增角色
	 * 
	 * @param id
	 * @param role
	 * @return
	 */
	@PostMapping("/insert")
	@Log("新增角色")
	@RequiresPermissions("sys:role:add") // 权限管理;
	@ResponseBody
	public ApiModel insert(SysRole sysRole, @RequestParam("menuIds") String menuIds) {
		// 通过角色名获取角色，判断角色名是否已经存在
		SysRole role = roleService.getByRoleName(sysRole.getRoleName());
		if (role != null) {
			return ApiModel.fail("角色名已经存在");
		}
		// 通过角色标识获取角色，判断角色标识是否已经存在
		role = roleService.getByRoleSign(sysRole.getRoleSign());
		if (role != null) {
			return ApiModel.fail("角色标识已经存在");
		}
		int insertLines = roleService.insert(sysRole);
		if (!StrUtil.isEmpty(menuIds)) {
			String roleId = sysRole.getId();
			for (String menuId : menuIds.split(",")) {
				// 将最新菜单数据赋予角色
				SysRoleMenu roleMenu = new SysRoleMenu(roleId, menuId);
				roleMenuService.insert(roleMenu);
			}
		}
		if (insertLines > 0) {
			return ApiModel.success(insertLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 修改角色
	 * 
	 * @param id
	 * @param role
	 * @return
	 */
	@PostMapping("/update")
	@Log("修改角色")
	@RequiresPermissions("sys:role:edit") // 权限管理;
	@ResponseBody
	public ApiModel update(SysRole sysRole, @RequestParam("menuIds") String menuIds) {
		if (!StrUtil.isEmpty(menuIds)) {
			String roleId = sysRole.getId();
			// 获取菜单
			if (menuIds.indexOf(",") >= 1) {
				// 删除角色下所有菜单
				roleService.deleteAllByRoleId(roleId);
				for (String menuId : menuIds.split(",")) {
					// 将最新菜单数据赋予角色
					SysRoleMenu roleMenu = new SysRoleMenu(roleId, menuId);
					roleMenuService.insert(roleMenu);
				}
			}
		}
		int updateLines = roleService.update(sysRole);
		if (updateLines > 0) {
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 根据id删除角色
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/delete/{id}")
	@Log("根据id删除角色")
	@RequiresPermissions("sys:role:del") // 权限管理;
	@ResponseBody
	public ApiModel delete(@PathVariable String id) {
		int deleteLines = roleService.delete(id);
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 批量删除角色
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:role:del")
	@PostMapping("/batchDelete/{ids}")
	@Log("批量删除角色")
	@ResponseBody
	public ApiModel batchDelete(@PathVariable String ids) {
		int deleteLines = 0;
		for (String id : ids.split(",")) {
			// 删除角色
			deleteLines += roleService.delete(id);
		}
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

}
