package com.ggblog.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggblog.common.service.CrudService;
import com.ggblog.modules.sys.dao.SysRoleDao;
import com.ggblog.modules.sys.domain.SysRole;
import com.ggblog.modules.sys.domain.SysRoleMenu;
import com.ggblog.modules.sys.domain.SysUserRole;
/**
 * 角色Service
 * @author 44359
 *
 */
@Service
public class SysRoleService extends CrudService<SysRoleDao, SysRole> {
	@Autowired
	private SysUserRoleService userRoleService;
	
	@Autowired
	private SysRoleMenuService roleMenuService;
	/**
	 * 删除单条数据
	 * 
	 * @param entity
	 */
	public int delete(SysRole entity) {
		int delLines = 0;
		//删除角色对应的用户角色表信息
		SysUserRole userRole = new SysUserRole();
		userRole.setRoleId(entity.getId());
		List<SysUserRole> list = userRoleService.findList(userRole);
		for (SysUserRole sysUserRole : list) {
			delLines+=userRoleService.delete(sysUserRole.getId());
		}
		//删除角色对应角色菜单表信息
		delLines+=deleteAllByRoleId(entity.getId());
		return  delLines;
	}
	/**
	 * 通过角色名获取角色
	 * @param roleName
	 * @return
	 */
	public SysRole getByRoleName(String roleName) {
		return dao.getByRoleName(roleName);
	}
	/**
	 * 通过角色标识获取角色
	 * @param roleSign
	 * @return
	 */
	public SysRole getByRoleSign(String roleSign) {
		return dao.getByRoleSign(roleSign);
	}
	
	/**
	 * 删除角色所有菜单
	 * @param roleId
	 */
	public int deleteAllByRoleId(String roleId) {
		SysRoleMenu roleMenu = new SysRoleMenu();
		roleMenu.setRoleId(roleId);
		List<SysRoleMenu> list = roleMenuService.findList(roleMenu);
		//删除该角色所有菜单
		int delLines = 0;
		if(list!=null&&list.size()>0) {
			for (SysRoleMenu sysRoleMenu : list) {
				delLines +=  roleMenuService.delete(sysRoleMenu.getId());
			}
		}
		return delLines;
	}
	
}
