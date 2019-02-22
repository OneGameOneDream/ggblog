package com.ggblog.modules.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ggblog.modules.blog.domain.BlogVersion;
import com.ggblog.modules.blog.service.BlogVersionService;

import cn.hutool.core.util.StrUtil;

/**
 * 版本控制器
 * 
 * @author 44359
 *
 */
@Controller
@RequestMapping("/blog/version")
public class BlogVersionController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "blog/version/";

	@Autowired
	private BlogVersionService versionService;
	@Autowired
	private GGblogConfig ggblogConfig;


	/**
	 * 编辑版本
	 * 
	 * @param id
	 * @param version
	 * @return
	 */
	@GetMapping("/edit/{id}")
	@Log("编辑版本")
	public String edit(@PathVariable String id, Model model) {
		BlogVersion version = versionService.get(id);
		model.addAttribute("version", version);
		return prefix + "edit";
	}


	/**
	 * 修改版本
	 * 
	 * @param id
	 * @param version
	 * @return
	 */
	@PostMapping("/update")
	@Log("修改版本")
	@ResponseBody
	public ApiModel update(BlogVersion BlogVersion) {
		int updateLines = versionService.update(BlogVersion);
		if (updateLines > 0) {
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}


	/**
	 * 上传图片
	 * @param file
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@PostMapping("/uploadImage")
	@ResponseBody
	public ApiModel uploadImage(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		Map<Object,Object> map = new HashMap<>();
		String uploadPath = ggblogConfig.getUploadPath()+"version/pics";
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
			map.put("src",  ggblogConfig.getUploadPath().substring(2)+"version/pics"+"/"+uuid+"."+imageType);
			map.put("title", newFile.getName());
		}
		return new ApiModel("0", "", map);
	}
}
