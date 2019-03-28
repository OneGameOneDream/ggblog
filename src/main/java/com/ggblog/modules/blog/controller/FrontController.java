package com.ggblog.modules.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggblog.modules.blog.domain.BlogArticle;
import com.ggblog.modules.blog.domain.BlogSkill;
import com.ggblog.modules.blog.domain.BlogUserInfo;
import com.ggblog.modules.blog.domain.BlogVersion;
import com.ggblog.modules.blog.service.BlogArticleService;
import com.ggblog.modules.blog.service.BlogSkillService;
import com.ggblog.modules.blog.service.BlogUserInfoService;
import com.ggblog.modules.blog.service.BlogVersionService;

@Controller
@RequestMapping("/f")
public class FrontController {
	
	@Autowired
	private BlogArticleService articleService;
	@Autowired
	private BlogVersionService versionService;
	@Autowired
	private BlogUserInfoService userInfoService;
	@Autowired
	private BlogSkillService skillService;
	/**
	 * html页面路径前缀
	 */
	private String prefix = "front/";
	
	@ModelAttribute
	public void versionInfo(Model model) {
		BlogVersion version = versionService.get("1");
		//访问量+1
		version.setHits(version.getHits()+1);
		versionService.update(version);
		//获取版本信息
		model.addAttribute("version",version);
		//获取博主信息
		BlogUserInfo userInfo = userInfoService.get("1");
		model.addAttribute("userInfo",userInfo);
	}
	
	
	/**
	 * 博客首页
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String index(Model model) {
		//获取轮播图
		model.addAttribute("carousel",articleService.findCarouselArticle());
		//查询文章标签
		model.addAttribute("tags",articleService.findTags());
		return prefix+"index";
	}
	
	/**
	 * 文章详情页
	 * @return
	 */
	@RequestMapping("/article/{id}")
	public String articleDetails(@PathVariable String id,Model model) {
		//获取文章
		BlogArticle article = articleService.get(id);
		model.addAttribute("article",article);
		return prefix+"details";
	}
	
	/**
	 * 关于我
	 * @return
	 */
	@RequestMapping("/about")
	public String about(Model model) {
		//获取技能信息
		List<BlogSkill> list= skillService.findList(new BlogSkill());
		model.addAttribute("list",list);
		return prefix+"about";
	}
	
	
}
