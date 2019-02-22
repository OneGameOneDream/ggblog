package com.ggblog.modules.blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.blog.domain.BlogArticle;
@Mapper
/**
 * 文章Dao
 * @author 44359
 *
 */
public interface BlogArticleDao extends CrudDao<BlogArticle> {
	//查询文章标签
    List<String> findTags();
}
