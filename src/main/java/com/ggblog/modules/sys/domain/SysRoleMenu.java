package com.ggblog.modules.sys.domain;

import com.ggblog.common.domain.BaseEntity;

public class SysRoleMenu extends BaseEntity<SysRoleMenu>{
	private String roleId;//角色id
	private String menuId;//菜单d
	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	public SysRoleMenu(String roleId, String menuId) {
		super();
		this.roleId = roleId;
		this.menuId = menuId;
	}
	public SysRoleMenu() {
		super();
	}
	
}
