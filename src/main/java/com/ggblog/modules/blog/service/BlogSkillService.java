package com.ggblog.modules.blog.service;

import org.springframework.stereotype.Service;

import com.ggblog.common.service.CrudService;
import com.ggblog.modules.blog.dao.BlogSkillDao;
import com.ggblog.modules.blog.domain.BlogSkill;
/**
 *技能Service
 * @author 44359
 *
 */
@Service
public class BlogSkillService extends CrudService<BlogSkillDao, BlogSkill> {
}
