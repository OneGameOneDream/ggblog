package com.ggblog.modules.sys.domain;

import java.util.List;

import com.ggblog.common.domain.BaseEntity;

/**
 * 菜单实体
 * 
 * @author 44359
 *
 */
public class SysMenu extends BaseEntity<SysMenu> {

	private String parentId; // 父级菜单
	private String name; // 名称
	private String href; // 链接
	private String target; // 目标（ mainFrame、_blank、_self、_parent、_top）
	private Integer type;// 类型 0：目录 1：菜单 2：按钮
	private String icon; // 图标
	private Integer sort; // 排序
	private String isShow; // 是否在菜单中显示（0：显示；1：不显示）
	private String permission; // 权限标识

	private List<SysMenu> childMenus;
	
	
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * @return the isShow
	 */
	public String getIsShow() {
		return isShow;
	}

	/**
	 * @param isShow the isShow to set
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	/**
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}
	

	/**
	 * @return the childMenus
	 */
	public List<SysMenu> getChildMenus() {
		return childMenus;
	}

	/**
	 * @param childMenus the childMenus to set
	 */
	public void setChildMenus(List<SysMenu> childMenus) {
		this.childMenus = childMenus;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}



	public SysMenu(String parentId, String name, String href, String target, Integer type, String icon, Integer sort,
			String isShow, String permission, List<SysMenu> childMenus) {
		super();
		this.parentId = parentId;
		this.name = name;
		this.href = href;
		this.target = target;
		this.type = type;
		this.icon = icon;
		this.sort = sort;
		this.isShow = isShow;
		this.permission = permission;
		this.childMenus = childMenus;
	}

	public SysMenu() {
		super();
	}


}
