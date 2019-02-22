package com.ggblog.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ggblog.common.dao.CrudDao;
import com.ggblog.modules.sys.domain.SysMenu;
/**
 * 菜单Dao
 * @author 44359
 *
 */
@Mapper
public interface SysMenuDao extends CrudDao<SysMenu> {
	//通过父菜单获取菜单
	List<SysMenu> findListByParent(SysMenu menu);
	
	//通过角色id获取菜单
	List<SysMenu> findListByRoleId(String roleId);
	
}
