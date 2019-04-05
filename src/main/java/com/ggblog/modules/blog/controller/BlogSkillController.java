package com.ggblog.modules.blog.controller;

import cn.hutool.core.util.StrUtil;
import com.ggblog.common.annotation.Log;
import com.ggblog.common.domain.ApiModel;
import com.ggblog.common.domain.GGblogConfig;
import com.ggblog.common.domain.SysPage;
import com.ggblog.modules.blog.domain.BlogSkill;
import com.ggblog.modules.blog.service.BlogSkillService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 技能控制器
 *
 * @author 44359
 */
@Controller
@RequestMapping("/blog/skill")
public class BlogSkillController {
    /**
     * html页面路径前缀
     */
    private String prefix = "blog/skill/";

    @Autowired
    private BlogSkillService skillService;
    @Autowired
    private GGblogConfig ggblogConfig;

    /**
     * 跳转list页面
     *
     * @param model
     * @return
     */
    @Log("跳转技能list页面")
    @RequiresPermissions("blog:skill:list") // 权限管理;
    @GetMapping("")
    public String list(Model model) {
        return prefix + "list";
    }

    @Log("添加技能")
    @GetMapping("/add")
    @RequiresPermissions("blog:skill:add") // 权限管理;
    public String add(Model model) {
        return prefix + "add";
    }

    /**
     * 编辑技能
     *
     * @param id
     * @param skill
     * @return
     */
    @GetMapping("/edit/{id}")
    @Log("编辑技能")
    @RequiresPermissions("blog:skill:edit")
    public String edit(@PathVariable String id, Model model) {
        BlogSkill skill = skillService.get(id);
        model.addAttribute("skill", skill);
        return prefix + "edit";
    }

    /**
     * 获取全部技能
     *
     * @return
     */
    @GetMapping("/list")
    @Log("获取全部技能列表")
    @ResponseBody
    public ApiModel list(BlogSkill skill) {
        SysPage<BlogSkill> page = skillService.findPage(skill);
        return ApiModel.success(page);
    }

    /**
     * 获取技能数目
     *
     * @return
     */
    @GetMapping("/count")
    @Log("获取技能数目")
    @ResponseBody
    public ApiModel count(BlogSkill skill) {
        int count = skillService.count(skill);
        return ApiModel.success(count);
    }


    /**
     * 新增技能
     *
     * @param id
     * @param skill
     * @return
     */
    @PostMapping("/insert")
    @Log("新增技能")
    @RequiresPermissions("blog:skill:add") // 权限管理;
    @ResponseBody
    public ApiModel insert(BlogSkill BlogSkill) {
        int insertLines = skillService.insert(BlogSkill);
        if (insertLines > 0) {
            return ApiModel.success(insertLines);
        } else {
            return ApiModel.fail(null);
        }
    }

    /**
     * 修改技能
     *
     * @param id
     * @param skill
     * @return
     */
    @PostMapping("/update")
    @Log("修改技能")
    @RequiresPermissions("blog:skill:edit") // 权限管理;
    @ResponseBody
    public ApiModel update(BlogSkill BlogSkill) {
        int updateLines = skillService.update(BlogSkill);
        if (updateLines > 0) {
            return ApiModel.success(updateLines);
        } else {
            return ApiModel.fail(null);
        }
    }

    /**
     * 根据id删除技能
     *
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    @Log("根据id删除技能")
    @RequiresPermissions("blog:skill:del") // 权限管理;
    @ResponseBody
    public ApiModel delete(@PathVariable String id) {
        int deleteLines = skillService.delete(id);
        if (deleteLines > 0) {
            return ApiModel.success(deleteLines);
        } else {
            return ApiModel.fail(null);
        }
    }

    /**
     * 批量删除技能
     *
     * @param id
     * @return
     */
    @RequiresPermissions("blog:skill:del")
    @PostMapping("/batchDelete/{ids}")
    @Log("批量删除技能")
    @ResponseBody
    public ApiModel batchDelete(@PathVariable String ids) {
        int deleteLines = 0;
        for (String id : ids.split(",")) {
            // 删除技能
            deleteLines += skillService.delete(id);
        }
        if (deleteLines > 0) {
            return ApiModel.success(deleteLines);
        } else {
            return ApiModel.fail(null);
        }
    }

    @PostMapping("/uploadImage")
    @ResponseBody
    public ApiModel uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
        Map<Object, Object> map = new HashMap<>();
        String uploadPath = ggblogConfig.getUploadPath() + "skill/pics";
        File file2 = new File(uploadPath);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (!file.isEmpty()) {
            //生成uuid作为文件名字
            String uuid = StrUtil.uuid();
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = file.getContentType();
            //获得文件后缀名称
            String imageType = contentType.substring(contentType.indexOf("/") + 1);
            File newFile = new File(uploadPath + "/" + uuid + "." + imageType);
            file.transferTo(newFile);
            map.put("src", ggblogConfig.getUploadPath().substring(2) + "skill/pics" + "/" + uuid + "." + imageType);
            map.put("title", newFile.getName());
        }
        return new ApiModel("0", "", map);
    }



}


