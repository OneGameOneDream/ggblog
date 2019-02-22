package com.ggblog.modules.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ggblog.common.annotation.Log;
import com.ggblog.common.domain.ApiModel;
import com.ggblog.common.domain.GGblogConfig;
import com.ggblog.common.domain.SysPage;
import com.ggblog.modules.blog.domain.BlogArticle;
import com.ggblog.modules.blog.service.BlogArticleService;
import com.ggblog.modules.sys.util.HttpHelper;

import cn.hutool.core.util.StrUtil;

/**
 * 文章控制器
 * 
 * @author 44359
 *
 */
@Controller
@RequestMapping("/blog/article")
public class BlogArticleController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "blog/article/";

	@Autowired
	private BlogArticleService articleService;
	@Autowired
	private GGblogConfig ggblogConfig;

	/**
	 * 跳转list页面
	 * 
	 * @param model
	 * @return
	 */
	@Log("跳转文章list页面")
	@RequiresPermissions("blog:article:list") // 权限管理;
	@GetMapping("")
	public String list(Model model) {
		return prefix + "list";
	}

	@Log("添加文章")
	@GetMapping("/add")
	@RequiresPermissions("blog:article:add") // 权限管理;
	public String add(Model model) {
		return prefix + "add";
	}

	/**
	 * 编辑文章
	 * 
	 * @param id
	 * @param article
	 * @return
	 */
	@GetMapping("/edit/{id}")
	@Log("编辑文章")
	@RequiresPermissions("blog:article:edit")
	public String edit(@PathVariable String id, Model model) {
		BlogArticle article = articleService.get(id);
		model.addAttribute("article", article);
		return prefix + "edit";
	}

	/**
	 * 获取全部文章
	 * 
	 * @return
	 */
	@GetMapping("/list")
	@Log("获取全部文章列表")
	@ResponseBody
	public ApiModel list(BlogArticle article) {
		SysPage<BlogArticle> page = articleService.findPage(article);
		return ApiModel.success(page);
	}
	/**
	 * 获取文章数目
	 * 
	 * @return
	 */
	@GetMapping("/count")
	@Log("获取文章数目")
	@ResponseBody
	public ApiModel count(BlogArticle article) {
		int count = articleService.count(article);
		return ApiModel.success(count);
	}
	
	
	/**
	 * 跨域图片转换
	 * @param path
	 * @return
	 */
	@RequestMapping(value = "/crosImg",produces =MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
	public byte[] bilibiliImg(String path) {
		return HttpHelper.doGetRequestForFile(path);
	}
	
	/**
	 * 加载哔哩哔哩文章
	 * @param page
	 * @return
	 */
	@RequestMapping("/bilibili")
	@ResponseBody
	public String bilibili(String page) {
		String s=HttpHelper.sendGet("https://api.bilibili.com/archive_rank/getarchiverankbypartion","?jsonp=jsonp&tid=95&pn="+page);
		return s;
	}
	
	
	/**
	 * 加载必应每日壁纸
	 * @return
	 */
	@RequestMapping("/bing")
	@ResponseBody
	public String bing() {
		String s=HttpHelper.sendGet("https://cn.bing.com/HPImageArchive.aspx","format=js&idx=0&n=8");
		return s;
	}
	
	/**
	 * 新增文章
	 * 
	 * @param id
	 * @param article
	 * @return
	 */
	@PostMapping("/insert")
	@Log("新增文章")
	@RequiresPermissions("blog:article:add") // 权限管理;
	@ResponseBody
	public ApiModel insert(BlogArticle BlogArticle) {
		int insertLines = articleService.insert(BlogArticle);
		if (insertLines > 0) {
			return ApiModel.success(insertLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 修改文章
	 * 
	 * @param id
	 * @param article
	 * @return
	 */
	@PostMapping("/update")
	@Log("修改文章")
	@RequiresPermissions("blog:article:edit") // 权限管理;
	@ResponseBody
	public ApiModel update(BlogArticle BlogArticle) {
		int updateLines = articleService.update(BlogArticle);
		if (updateLines > 0) {
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 根据id删除文章
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/delete/{id}")
	@Log("根据id删除文章")
	@RequiresPermissions("blog:article:del") // 权限管理;
	@ResponseBody
	public ApiModel delete(@PathVariable String id) {
		int deleteLines = articleService.delete(id);
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	/**
	 * 批量删除文章
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("blog:article:del")
	@PostMapping("/batchDelete/{ids}")
	@Log("批量删除文章")
	@ResponseBody
	public ApiModel batchDelete(@PathVariable String ids) {
		int deleteLines = 0;
		for (String id : ids.split(",")) {
			// 删除文章
			deleteLines += articleService.delete(id);
		}
		if (deleteLines > 0) {
			return ApiModel.success(deleteLines);
		} else {
			return ApiModel.fail(null);
		}
	}

	@PostMapping("/uploadImage")
	@ResponseBody
	public ApiModel uploadImage(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		Map<Object,Object> map = new HashMap<>();
		String uploadPath = ggblogConfig.getUploadPath()+"article/pics";
		File file2 = new File(uploadPath);
		if(!file2.exists()) {
			file2.mkdirs(); 
		}
		if(!file.isEmpty()) {
			//生成uuid作为文件名字
			String uuid = StrUtil.uuid();
			//获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType=file.getContentType();
			//获得文件后缀名称
			String imageType=contentType.substring(contentType.indexOf("/")+1);
			File newFile = new File(uploadPath+"/"+uuid+"."+imageType);
			file.transferTo(newFile);
			map.put("src",  ggblogConfig.getUploadPath().substring(2)+"article/pics"+"/"+uuid+"."+imageType);
			map.put("title", newFile.getName());
		}
		return new ApiModel("0", "", map);
	}
}
