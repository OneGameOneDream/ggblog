package com.ggblog.modules.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.blog.domain.BlogVersion;
@Mapper
/**
 * 版本信息Dao
 * @author 44359
 *
 */
public interface BlogVersionDao extends CrudDao<BlogVersion> {
}
