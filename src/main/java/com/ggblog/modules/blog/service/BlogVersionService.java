package com.ggblog.modules.blog.service;

import org.springframework.stereotype.Service;

import com.ggblog.common.service.CrudService;
import com.ggblog.modules.blog.dao.BlogVersionDao;
import com.ggblog.modules.blog.domain.BlogVersion;
/**
 * 版本信息Service
 * @author 44359
 *
 */
@Service
public class BlogVersionService  extends CrudService<BlogVersionDao, BlogVersion>{
	
}
