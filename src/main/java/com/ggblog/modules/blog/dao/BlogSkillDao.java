package com.ggblog.modules.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.blog.domain.BlogSkill;
@Mapper
/**
 * 技能Dao
 * @author 44359
 *
 */
public interface BlogSkillDao extends CrudDao<BlogSkill> {
	
}
