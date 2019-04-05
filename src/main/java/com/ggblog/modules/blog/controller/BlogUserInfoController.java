package com.ggblog.modules.blog.controller;

import cn.hutool.core.util.StrUtil;
import com.ggblog.common.annotation.Log;
import com.ggblog.common.domain.ApiModel;
import com.ggblog.common.domain.GGblogConfig;
import com.ggblog.modules.blog.domain.BlogUserInfo;
import com.ggblog.modules.blog.service.BlogUserInfoService;
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
 * 博主信息控制器
 *
 * @author 44359
 *
 */
@Controller
@RequestMapping("/blog/userInfo")
public class BlogUserInfoController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "blog/userInfo/";

	@Autowired
	private BlogUserInfoService userInfoService;
	@Autowired
	private GGblogConfig ggblogConfig;

	/**
	 * 编辑博主信息
	 *
	 * @param id
	 * @param userInfo
	 * @return
	 */
	@GetMapping("/edit/{id}")
	@Log("编辑博主信息")
	public String edit(@PathVariable String id, Model model) {
		BlogUserInfo userInfo = userInfoService.get(id);
		model.addAttribute("userInfo", userInfo);
		return prefix + "edit";
	}


	/**
	 * 修改博主信息
	 *
	 * @param id
	 * @param userInfo
	 * @return
	 */
	@PostMapping("/update")
	@Log("修改博主信息")
	@ResponseBody
	public ApiModel update(BlogUserInfo BlogUserInfo) {
		int updateLines = userInfoService.update(BlogUserInfo);
		if (updateLines > 0) {
			return ApiModel.success(updateLines);
		} else {
			return ApiModel.fail(null);
		}
	}


	/**
	 * 上传二维码
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
		String uploadPath = ggblogConfig.getUploadPath()+"userInfo/pics";
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
			map.put("src",  ggblogConfig.getUploadPath().substring(2)+"userInfo/pics"+"/"+uuid+"."+imageType);
			map.put("title", newFile.getName());
		}
		return new ApiModel("0", "", map);
	}
}
