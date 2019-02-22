package com.ggblog.modules.sys.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
/**
 * 用户工具类
 * @author 44359
 *
 */
public class UserUtils {

	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}

	public static String getUsername() {
		String username= (String) getSubjct().getPrincipal();
		return username;
	}

	public static void logout() {
		getSubjct().logout();
	}

}
