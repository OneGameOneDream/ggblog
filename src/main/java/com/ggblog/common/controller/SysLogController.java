package com.ggblog.common.controller;

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
import com.ggblog.common.domain.SysLog;
import com.ggblog.common.domain.SysPage;
import com.ggblog.common.service.SysLogService;
import com.ggblog.modules.sys.domain.SysUser;
import com.ggblog.modules.sys.service.SysUserService;

/**
 * 日志控制器
 * 
 * @author 44359
 *
 */
@Controller
@RequestMapping("common/log")
public class SysLogController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "common/log/";

	@Autowired
	private SysLogService logService;
	@Autowired
	private SysUserService userService;
	/**
	 * 日志列表页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:log:list")
	@Log("访问日志列表页面")
	@GetMapping("")
	public String log(Model model,SysLog log) {
		//查询所有用户
		List<SysUser> userList = userService.findList(new SysUser());
		model.addAttribute("userList",userList);
		return prefix + "list";
	}

	
	/**
	 * 日志详情页面
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequiresPermissions("sys:log:details")
	@Log("访问日志详情页面")
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		SysLog log = logService.get(id);
		model.addAttribute("log", log);
		return prefix + "details";
	}
	
	/**
	 * 获取日志列表数据
	 * @param log
	 * @return
	 */
	@RequiresPermissions("sys:log:list")
	@GetMapping("/list")
	@ResponseBody
	public ApiModel findList(SysLog log){
		SysPage<SysLog> page = logService.findPage(log);
//		List<SysLog> page = logService.findList(log);
		return ApiModel.success(page);
	}

	/**
	 * 根据id删除日志
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:log:del")
	@PostMapping("/delete/{id}")
	@Log("删除日志")
	@ResponseBody
	public ApiModel delete(@PathVariable String id) {
		// 删除日志
		int deleteLines = logService.delete(id);
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 批量删除日志
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:log:del")
	@PostMapping("/batchDelete/{ids}")
	@Log("批量删除日志")
	@ResponseBody
	public ApiModel batchDelete(@PathVariable String ids) {
		int deleteLines = 0;
		for (String id : ids.split(",")) {
			// 删除日志
			deleteLines += logService.delete(id);
		}
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}
	
	/**
	 * 清空日志
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:log:del")
	@PostMapping("/empty")
	@Log("清空日志")
	@ResponseBody
	public ApiModel empty() {
		logService.empty();
		return ApiModel.success("success");
	}
}
