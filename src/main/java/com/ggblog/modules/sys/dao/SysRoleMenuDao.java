package com.ggblog.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.sys.domain.SysRoleMenu;

/**
 * 角色菜单Dao
 * @author 44359
 *
 */
@Mapper
public interface SysRoleMenuDao extends CrudDao<SysRoleMenu> {

}
