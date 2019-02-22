package com.ggblog.modules.sys.domain;

import java.util.Date;

import com.ggblog.common.domain.BaseEntity;

public class SysUserRole extends BaseEntity<SysUserRole>{
	
	private String userId;//用户id
	private String roleId;//角色id

	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
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


	
	public SysUserRole(String userId, String roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}
	
	
	
	public SysUserRole() {
		super();
	}
}
