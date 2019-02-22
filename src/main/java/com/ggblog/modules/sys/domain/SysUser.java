package com.ggblog.modules.sys.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ggblog.common.domain.BaseEntity;

/**
 * 用户实体
 * 
 * @author 44359
 *
 */
public class SysUser extends BaseEntity<SysUser> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;// 用户名
	private String password;// 密码
	private String email;// 电子邮件
	private String name;// 昵称
	private String deptId;// 部门id
	private String mobile;// 手机号码
	private String stats;// 状态 0:正常1:禁用
	private String sex;// 性别
	private String hobby; // 爱好
	private String loginIp;//最后登陆IP
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginDate;//最后登陆时间
	private Integer loginCount;//登录次数
	
	private SysRole role; //角色
	private String oldPassword;//原密码
	
	
	
	
	
	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the loginCount
	 */
	public Integer getLoginCount() {
		return loginCount;
	}

	/**
	 * @param loginCount the loginCount to set
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * @return the loginIp
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * @param loginIp the loginIp to set
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}



	/**
	 * @return the loginDate
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getLoginDate() { 
		return loginDate;
	}

	/**
	 * @param loginDate the loginDate to set
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * @return the role
	 */
	public SysRole getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(SysRole role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public SysUser(String username, String password, String email, String name, String deptId, String mobile,
			String stats, String sex, String hobby) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.deptId = deptId;
		this.mobile = mobile;
		this.stats = stats;
		this.sex = sex;
		this.hobby = hobby;
	}

	public SysUser() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysUser [username=" + username + ", password=" + password + ", email=" + email + ", name=" + name
				+ ", deptId=" + deptId + ", mobile=" + mobile + ", stats=" + stats + ", sex=" + sex + ", hobby=" + hobby
				+ "]";
	}

}
