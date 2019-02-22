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
import com.ggblog.modules.sys.domain.SysDict;
import com.ggblog.modules.sys.service.SysDictService;

/**
 * 字典控制器
 * 
 * @author 44359
 *
 */
@Controller
@RequestMapping("/sys/dict")
public class SysDictController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "sys/dict/";

	@Autowired
	private SysDictService dictService;

	/**
	 * 跳转list页面
	 * 
	 * @param model
	 * @return
	 */
	@Log("跳转字典list页面")
	@RequiresPermissions("sys:dict:list") // 权限管理;
	@GetMapping("")
	public String list(Model model) {
		return prefix + "list";
	}

	@Log("添加字典")
	@GetMapping("/add")
	@RequiresPermissions("sys:dict:add") // 权限管理;
	public String add(Model model) {
		model.addAttribute("dict", new SysDict());
		return prefix + "add";
	}

	@Log("添加字典")
	@GetMapping("/add/{id}")
	@RequiresPermissions("sys:dict:add") // 权限管理;
	public String add(@PathVariable String id, Model model) {
		SysDict dict = dictService.get(id);
		dict.setSort(dict.getSort() + 10);
		model.addAttribute("dict", dict);
		return prefix + "add";
	}

	/**
	 * 编辑字典
	 * 
	 * @param id
	 * @param dict
	 * @return
	 */
	@GetMapping("/edit/{id}")
	@Log("编辑字典")
	@RequiresPermissions("sys:dict:edit")
	public String edit(@PathVariable String id, Model model) {
		SysDict dict = dictService.get(id);
		model.addAttribute("dict", dict);
		return prefix + "edit";
	}

	/**
	 * 获取全部字典
	 * 
	 * @return
	 */
	@GetMapping("/list")
	@Log("获取全部字典列表")
	@RequiresPermissions("sys:dict:list") // 权限管理;
	@ResponseBody
	public ApiModel list(SysDict dict) {
		SysPage<SysDict> page = dictService.findPage(dict);
		return ApiModel.success(page);
	}
	
	/**
	 * 新增字典
	 * 
	 * @param id
	 * @param dict
	 * @return
	 */
	@PostMapping("/insert")
	@Log("新增字典")
	@RequiresPermissions("sys:dict:add") // 权限管理;
	@ResponseBody
	public ApiModel insert(SysDict SysDict) {
		int insertLines = dictService.insert(SysDict);
		if (insertLines > 0) {
			return ApiModel.success(insertLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 修改字典
	 * 
	 * @param id
	 * @param dict
	 * @return
	 */
	@PostMapping("/update")
	@Log("修改字典")
	@RequiresPermissions("sys:dict:edit") // 权限管理;
	@ResponseBody
	public ApiModel update(SysDict SysDict) {
		int updateLines = dictService.update(SysDict);
		if (updateLines > 0) {
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 根据id删除字典
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/delete/{id}")
	@Log("根据id删除字典")
	@RequiresPermissions("sys:dict:del") // 权限管理;
	@ResponseBody
	public ApiModel delete(@PathVariable String id) {
		int deleteLines = dictService.delete(id);
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 批量删除字典
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:role:del")
	@PostMapping("/batchDelete/{ids}")
	@Log("批量删除字典")
	@ResponseBody
	public ApiModel batchDelete(@PathVariable String ids) {
		int deleteLines = 0;
		for (String id : ids.split(",")) {
			// 删除字典
			deleteLines += dictService.delete(id);
		}
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}
}
