package com.ggblog.modules.sys.service;

import org.springframework.stereotype.Service;

import com.ggblog.common.service.CrudService;
import com.ggblog.modules.sys.dao.SysUserRoleDao;
import com.ggblog.modules.sys.domain.SysUserRole;

/**
 * 用户角色Service
 * 
 * @author 44359
 *
 */
@Service
public class SysUserRoleService extends CrudService<SysUserRoleDao, SysUserRole> {
	/**
	 * 通过用户id获取对象
	 * 
	 * @param userId
	 * @return
	 */
	public SysUserRole getByUserid(String userId) {
		return dao.getByUserId(userId);
	}


}
