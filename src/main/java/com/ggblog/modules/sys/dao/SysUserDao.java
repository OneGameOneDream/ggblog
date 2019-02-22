package com.ggblog.modules.sys.dao;


import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.sys.domain.SysUser;
/**
 * 用户Dao
 * @author 44359
 *
 */
@Mapper
public interface SysUserDao extends CrudDao<SysUser>{
	/**
	 * 通过用户名获取用户
	 * @param username
	 * @return
	 */
	 SysUser getByUsername(String username);
}
