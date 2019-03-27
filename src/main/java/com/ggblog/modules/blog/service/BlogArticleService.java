package com.ggblog.modules.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ggblog.common.service.CrudService;
import com.ggblog.modules.blog.dao.BlogArticleDao;
import com.ggblog.modules.blog.domain.BlogArticle;
/**
 * 文章Service
 * @author 44359
 *
 */
@Service
public class BlogArticleService extends CrudService<BlogArticleDao, BlogArticle> {
	//查询文章标签 
	public List<String> findTags(){
		return dao.findTags();
	}
	//查询轮播图
	public List<BlogArticle> findCarouselArticle(){
		return dao.findCarouselArticle();
	}
}
