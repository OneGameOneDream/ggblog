package com.ggblog.modules.blog.service;

import org.springframework.stereotype.Service;

import com.ggblog.common.service.CrudService;
import com.ggblog.modules.blog.dao.BlogUserInfoDao;
import com.ggblog.modules.blog.domain.BlogUserInfo;
/**
 * 博主信息Service
 * @author 44359
 *
 */
@Service
public class BlogUserInfoService extends CrudService<BlogUserInfoDao, BlogUserInfo> {
}
