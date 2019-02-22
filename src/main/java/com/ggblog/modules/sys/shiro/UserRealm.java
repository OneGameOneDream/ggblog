
package com.ggblog.modules.sys.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.ggblog.modules.sys.domain.SysMenu;
import com.ggblog.modules.sys.domain.SysUser;
import com.ggblog.modules.sys.service.SysMenuService;
import com.ggblog.modules.sys.service.SysUserService;

import cn.hutool.core.util.StrUtil;

public class UserRealm extends AuthorizingRealm {
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysMenuService menuService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole(userService.getUser().getRole().getRoleSign());
		for (SysMenu menu : menuService.findAllMenus()) {
			if(!StrUtil.isEmpty(menu.getPermission())) {
				authorizationInfo.addStringPermission(menu.getPermission());
			}
		}
		return authorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 获取用户输入的用户名
		String username = (String) authenticationToken.getPrincipal();
		SysUser user = userService.getByUsername(username);
		if (user == null) {
			return null;
		}
		// 账户禁用
		if (user.getStats().equals("1")) {
			throw new DisabledAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getUsername()), // 加盐
				getName() // realm name
		);
		return authenticationInfo;
	}

}
