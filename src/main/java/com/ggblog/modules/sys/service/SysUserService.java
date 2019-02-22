package com.ggblog.modules.sys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggblog.common.aspect.WebLogAspect;
import com.ggblog.common.domain.SysPage;
import com.ggblog.common.service.CrudService;
import com.ggblog.modules.sys.dao.SysUserDao;
import com.ggblog.modules.sys.domain.SysRole;
import com.ggblog.modules.sys.domain.SysUser;
import com.ggblog.modules.sys.domain.SysUserRole;
import com.ggblog.modules.sys.util.UserUtils;

/**
 * 用戶Service
 * 
 * @author 44359
 *
 */
@Service
public class SysUserService extends CrudService<SysUserDao, SysUser> {
	
	/**
	 * 创建SLF4J实例
	 */
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
	
	
	@Autowired
	private SysUserRoleService userRoleService;
	@Autowired
	private SysRoleService roleService;

	

	/**
	 * 获取对象集合
	 * 
	 * @return
	 */
	public List<SysUser> findList(SysUser entity) {
		List<SysUser> list = super.findList(entity);
		// 暂时单个角色
		for (SysUser sysUser : list) {
			SysUserRole userRole = userRoleService.getByUserid(sysUser.getId());
			SysRole role = roleService.get(userRole.getRoleId());
			if (role != null) {
				sysUser.setRole(role);
			}
		}
		return list;
	}

	/**
	 * 查询分页数据
	 * @param entity
	 * @return
	 */
	public SysPage<SysUser> findPage(SysUser entity) {
		 SysPage<SysUser> page= super.findPage(entity);
		// 暂时单个角色
				for (SysUser sysUser : page.getList()) {
					SysUserRole userRole = userRoleService.getByUserid(sysUser.getId());
					SysRole role = roleService.get(userRole.getRoleId());
					if (role != null) {
						sysUser.setRole(role);
					}
				}
		return page;
	}
	
	/**
	 * 插入单条数据
	 * 
	 * @param t
	 */
	public int insert(SysUser entity) {
		entity.setStats("0");
		return super.insert(entity);
	}


	/**
	 * 删除单条数据
	 * 
	 * @param entity
	 */
	public int delete(String id) {
		// 删除用户
		int deleteLines = delete(id);
				// 删除用户角色关系
		deleteLines += userRoleService.delete(userRoleService.getByUserid(id));
		return deleteLines;
	}
	/**
	 * 通过用户名获取用户
	 * @param username
	 * @return
	 */
	public SysUser getByUsername(String username) {
		return dao.getByUsername(username);
	}
	
	/**
	 * 获取用户角色
	 * @return
	 */
	public SysRole getRoleByUser(SysUser user) {
		SysUserRole userRole = userRoleService.getByUserid(user.getId());
		SysRole role = roleService.get(userRole.getRoleId());
		if(role==null) {
			logger.error("shiro获取角色失败");
		}
		return role;
	}
	/**
	 * 获取数据条数
	 * @param entity
	 * @return
	 */
	public int count(SysUser entity) {
		return dao.count(entity);
	}
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public SysUser getUser() {
		SysUser user = getByUsername(UserUtils.getUsername());
		SysUserRole userRole = userRoleService.getByUserid(user.getId());
		SysRole role = roleService.get(userRole.getRoleId());
		user.setRole(role);
		return user;
	}

}