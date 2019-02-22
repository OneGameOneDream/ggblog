package com.ggblog.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggblog.common.domain.SysTree;
import com.ggblog.common.service.CrudService;
import com.ggblog.modules.sys.dao.SysMenuDao;
import com.ggblog.modules.sys.domain.SysMenu;
import com.ggblog.modules.sys.domain.SysRoleMenu;
import com.ggblog.modules.sys.domain.SysUser;

/**
 * 菜单Service
 * 
 * @author 44359
 *
 */
@Service
public class SysMenuService extends CrudService<SysMenuDao, SysMenu> {

	
	@Autowired
	private SysRoleMenuService roleMenuService;
	@Autowired
	private SysUserService userService;

	/**
	 * 获取对象集合
	 * 
	 * @return
	 */
	public List<SysMenu> findList(SysMenu entity) {
		List<SysMenu> menuList = super.findList(entity);
		for (SysMenu sysMenu : menuList) {
			if(sysMenu.getDelFlag().equals("1")||!sysMenu.getIsShow().equals("0")) {
				menuList.remove(sysMenu);
			}
		}
		return menuList;
	}
	
	/**
	 * 获取当前用户的一级菜单
	 * @param role
	 * @return
	 */
	public List<SysMenu> findParentMenus(){
		// 获取当前登录用户信息
		SysUser user = userService.getUser();
		SysRoleMenu roleMenu = new SysRoleMenu();
		roleMenu.setRoleId(user.getRole().getId());
		List<SysRoleMenu> roleMenuList = roleMenuService.findList(roleMenu);
		List<SysMenu> menuList = new ArrayList<SysMenu>();
		for (SysRoleMenu sysRoleMenu : roleMenuList) {
			SysMenu menu = get(sysRoleMenu.getMenuId());
			if (menu != null && menu.getDelFlag().equals("0") && menu.getIsShow().equals("0") && menu.getParentId().equals("1")) {
				menuList.add(menu);
			}
		}
		return menuList;
	}
	
	
	/**
	 * 获取二级菜单
	 * @param role
	 * @return
	 */
	public List<SysMenu> findChildMenus(SysMenu parentMenu){
		// 所有一级菜单
		List<SysMenu> menuList = dao.findListByParent(parentMenu);
		for (SysMenu menu : menuList) {
				menu.setChildMenus(dao.findListByParent(menu));
		}
		return menuList;
	}
	
	
	/**
	 * 获取当前用户的所有菜单
	 * @param role
	 * @return
	 */
	public List<SysMenu> findAllMenus(){
		// 获取当前登录用户信息
		SysUser user = userService.getUser();
		List<SysMenu> menuList =  findListByRoleId(user.getRole().getId());
		return menuList;
	}
	
	
	
	/**
	 * 通过角色id获取菜单
	 * @param roleId
	 * @return
	 */
	public List<SysMenu> findListByRoleId(String roleId){
		return dao.findListByRoleId(roleId);
	}
	/**
	 * 获取树菜单
	 * @return
	 */
	public List<SysTree> getTree(){
		//获取所有菜单
		List<SysTree> treeList = new ArrayList<SysTree>();
		List<SysMenu> menuList = findList(new SysMenu());
		for (SysMenu sysMenu : menuList) {
				treeList.add(menuToTree(sysMenu));
		}
		return treeList;
	}
	
	/**
	 * 根据角色获取树菜单
	 * @return
	 */
	public List<SysTree> getTree(String roleId){
		//获取所有菜单
		List<SysTree> treeList = new ArrayList<SysTree>();
		
		List<SysMenu> menuList = findList(new SysMenu());
		List<SysMenu> roleMenuList = findListByRoleId(roleId);
		for (SysMenu sysMenu : menuList) {
			treeList.add(menuToTree(sysMenu));
		}
		
		for (SysTree tree : treeList) {
			for (SysMenu sysMenu2 : roleMenuList) {
				if(sysMenu2.getId().equals(tree.getId())) {
					tree.setChecked(true);
				}
			}
		}
		
		return treeList;
	}
	
	/**
	 * 菜单转树
	 * @param menu
	 * @return
	 */
	public SysTree menuToTree(SysMenu menu) {
		if(menu.getType()==0||menu.getType()==1) {
			return new SysTree(menu.getId(), menu.getParentId(), menu.getName(), true, true);
		}else {
			return new SysTree(menu.getId(), menu.getParentId(), menu.getName());
		}
	}
	
	
}
