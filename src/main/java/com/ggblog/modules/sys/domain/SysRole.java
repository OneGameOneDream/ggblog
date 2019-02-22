package com.ggblog.modules.sys.domain;

import com.ggblog.common.domain.BaseEntity;

/**
 * 角色实体
 * @author 44359
 *
 */
public class SysRole extends BaseEntity<SysRole>{
	private String roleName; //角色名称
	private String roleSign; //角色标识
	private String isAvailable; //是否可用
	
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleSign
	 */
	public String getRoleSign() {
		return roleSign;
	}
	/**
	 * @param roleSign the roleSign to set
	 */
	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}
	
	
	
	
	/**
	 * @return the isAvailable
	 */
	public String getIsAvailable() {
		return isAvailable;
	}
	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	public SysRole(String roleName, String roleSign, String isAvailable) {
		super();
		this.roleName = roleName;
		this.roleSign = roleSign;
		this.isAvailable = isAvailable;
	}
	public SysRole() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysRole [roleName=" + roleName + ", roleSign=" + roleSign + "]";
	}
	
	
}
