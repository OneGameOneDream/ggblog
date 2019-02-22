package com.ggblog.modules.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
import com.ggblog.modules.sys.domain.SysRole;
import com.ggblog.modules.sys.domain.SysUser;
import com.ggblog.modules.sys.domain.SysUserRole;
import com.ggblog.modules.sys.service.SysRoleService;
import com.ggblog.modules.sys.service.SysUserRoleService;
import com.ggblog.modules.sys.service.SysUserService;

/**
 * 用户控制器
 * 
 * @author 44359
 *
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "sys/user/";

	@Autowired
	private SysUserService userService;
	@Autowired
	private SysRoleService roleService;
	@Autowired
	private SysUserRoleService userRoleService;

	
	
	/**
	 * 用户列表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:user:list")
	@Log("访问用户列表")
	@GetMapping("")
	public String user(Model model, SysUser user) {
		return prefix + "list";
	}

	/**
	 * 添加用户页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:user:add")
	@Log("添加用户")
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("roleList", roleService.findList(new SysRole()));
		SysUser user = new SysUser();
		user.setRole(roleService.get("2"));
		model.addAttribute("user", new SysUser());
		return prefix + "add";
	}

	/**
	 * 编辑用户页面
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequiresPermissions("sys:user:edit")
	@Log("编辑用户")
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		SysUser user = userService.get(id);
		SysUserRole userRole = userRoleService.getByUserid(user.getId());
		SysRole role = roleService.get(userRole.getRoleId());
		user.setRole(role);
		model.addAttribute("roleList", roleService.findList(new SysRole()));
		model.addAttribute("user", user);
		return prefix + "edit";
	}
	
	/**
	 *基本资料页面
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@Log("基本资料")
	@GetMapping("/info/{id}")
	public String info(@PathVariable String id, Model model) {
		SysUser user = userService.get(id);
		SysUserRole userRole = userRoleService.getByUserid(user.getId());
		SysRole role = roleService.get(userRole.getRoleId());
		user.setRole(role);
		model.addAttribute("roleList", roleService.findList(new SysRole()));
		model.addAttribute("user", user);
		return prefix + "info";
	}
	
	/**
	 * 更改密码
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@Log("更改密码")
	@GetMapping("/updatePassword/{id}")
	public String updatePassword(@PathVariable String id, Model model) {
		SysUser user = userService.get(id);
		model.addAttribute("user", user);
		return prefix + "updatePassword";
	}
	
	
	/**
	 * 获取用户列表数据
	 * @param user
	 * @return
	 */
	@RequiresPermissions("sys:user:list")
	@Log("获取用户列表数据")
	@GetMapping("/list")
	@ResponseBody
	public ApiModel findList(SysUser user){
		SysPage<SysUser> page = userService.findPage(user);
		return ApiModel.success(page);
	}
	
	

	/**
	 * 插入用户
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequiresPermissions("sys:user:add")
	@Log("插入用户")
	@PostMapping("/insert")
	@ResponseBody
	public ApiModel insert(SysUser user) {
		// 通过用户名获取用户，判断用户名是否已经存在
		SysUser sysUser = userService.getByUsername(user.getUsername());
		if (sysUser != null) {
			return ApiModel.fail("用户名已经存在");
		}
		//加盐加密
		user.setPassword((new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes(user.getUsername()), 1024)).toString());
		user.setLoginCount(0);
		int insertLines = userService.insert(user);
		if (insertLines > 0) {
			if (user != null && user.getRole() != null) {
				SysUserRole userRole = new SysUserRole(user.getId(), user.getRole().getId());
				userRoleService.insert(userRole);
			}
			return ApiModel.success(insertLines);
		} else {
			return ApiModel.fail(null);
		}
	}
	

	/**
	 * 更新用户
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequiresPermissions("sys:user:edit") // 权限管理;
	@Log("更新用户")
	@PostMapping("/update")
	@ResponseBody
	public ApiModel update(SysUser user) {
		int updateLines = userService.update(user);
		if (updateLines > 0) {
			if (user != null && user.getRole() != null) {
				SysUserRole userRole = userRoleService.getByUserid(user.getId());
				userRole.setRoleId(user.getRole().getId());
				userRoleService.update(userRole);
			}
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}
	
	/**
	 * 更新个人信息
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@Log("更新个人信息")
	@PostMapping("/updateInfo")
	@ResponseBody
	public ApiModel updateInfo(SysUser user) {
		int updateLines = userService.update(user);
		if (updateLines > 0) {
			if (user != null && user.getRole() != null) {
				SysUserRole userRole = userRoleService.getByUserid(user.getId());
				userRole.setRoleId(user.getRole().getId());
				userRoleService.update(userRole);
			}
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}
	/**
	 * 提交更改密码
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@Log("提交更改密码")
	@PostMapping("/updatePassword")
	@ResponseBody
	public ApiModel updatePassword(SysUser user) {
		//加盐加密
		//user.setPassword();
		SysUser sysUser = userService.get(user.getId());
		String pwd = (new SimpleHash("MD5", user.getOldPassword(), ByteSource.Util.bytes(sysUser.getUsername()), 1024)).toString();
		if(sysUser==null||!sysUser.getPassword().equals(pwd)) {
			return ApiModel.fail("原密码错误");
		}
		sysUser.setPassword((new SimpleHash("MD5", user.getPassword(), ByteSource.Util.bytes(sysUser.getUsername()), 1024)).toString());
		int updateLines = userService.update(sysUser);
		if (updateLines > 0) {
			if (sysUser != null && sysUser.getRole() != null) {
				SysUserRole userRole = userRoleService.getByUserid(sysUser.getId());
				userRole.setRoleId(sysUser.getRole().getId());
				userRoleService.update(userRole);
			}
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}
	

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:user:del")
	@PostMapping("/delete/{id}")
	@Log("删除用户")
	@ResponseBody
	public ApiModel delete(@PathVariable String id) {
		int deleteLines = userService.delete(id);
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 批量删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:user:del")
	@PostMapping("/batchDelete/{ids}")
	@Log("批量删除用户")
	@ResponseBody
	public ApiModel batchDelete(@PathVariable String ids) {
		int deleteLines = 0;
		for (String id : ids.split(",")) {
			deleteLines = userService.delete(id);
		}
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 停用用户
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:user:edit")
	@Log("停用用户")
	@PostMapping("/stop/{id}")
	@ResponseBody
	public ApiModel stop(@PathVariable String id) {
		SysUser user = userService.get(id);
		if (user != null) {
			user.setStats("1");
			int updateLines = userService.update(user);
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 启用用户
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:user:edit")
	@Log("启用用户")
	@PostMapping("/start/{id}")
	@ResponseBody
	public ApiModel start(@PathVariable String id) {
		SysUser user = userService.get(id);
		if (user != null) {
			user.setStats("0");
			int updateLines = userService.update(user);
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}
	
}
