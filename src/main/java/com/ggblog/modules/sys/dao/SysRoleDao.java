package com.ggblog.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.sys.domain.SysRole;

/**
 * 角色Dao
 * 
 * @author 44359
 *
 */
@Mapper
public interface SysRoleDao extends CrudDao<SysRole> {

	/**
	 * 通过角色名称获取角色
	 * 
	 * @param roleName
	 * @return
	 */
	SysRole getByRoleName(String roleName);

	/**
	 * 通过角色标识获取角色
	 * 
	 * @param roleName
	 * @return
	 */
	SysRole getByRoleSign(String roleSign);
}
