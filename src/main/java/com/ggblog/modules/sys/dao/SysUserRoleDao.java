package com.ggblog.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.sys.domain.SysUserRole;

/**
 * 用户角色Dao
 * @author 44359
 *
 */
@Mapper
public interface SysUserRoleDao extends CrudDao<SysUserRole> {
	
	SysUserRole getByUserId(String userId);
	
}
