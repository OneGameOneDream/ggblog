package com.ggblog.modules.blog.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.blog.domain.BlogUserInfo;
@Mapper
/**
 * 博主信息Dao
 * @author 44359
 *
 */
public interface BlogUserInfoDao extends CrudDao<BlogUserInfo> {
	
	
}
