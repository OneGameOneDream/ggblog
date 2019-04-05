package com.ggblog.modules.sys.controller;

import com.ggblog.common.annotation.Log;
import com.ggblog.common.domain.ApiModel;
import com.ggblog.modules.sys.domain.SysMenu;
import com.ggblog.modules.sys.service.SysMenuService;
import com.ggblog.modules.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 登录controller
 * 
 * @author 44359
 *
 */
@Controller
public class LoginController {
	/**
	 * html页面路径前缀
	 */
	private String prefix = "/";

	@Autowired
	private SysUserService userService;
	@Autowired
	private SysMenuService menuService;
	
	
	@GetMapping("demo")
	public String demo() {
		return prefix+"demo";
	}
	
	/**
	 * 欢迎页面
	 * @return
	 */
	@GetMapping("welcome")
	public String welcome(HttpServletRequest request,Model model) {
		// 获取当前登录用户信息
		model.addAttribute("user",userService.getUser());
		return prefix+"welcome";
	}

	/**
	 * 首页
	 * 
	 * @return
	 */
	@Log("用户登录")
	@RequestMapping({ "", "index" })
	public String index(Model model) {
		//获取所有菜单
		List<SysMenu> menus = menuService.findAllMenus();
		//获取第一个一级菜单的所有二级菜单
		model.addAttribute("user", userService.getUser());
		model.addAttribute("menus", menus);
		return prefix+"index";
	}

	/**
	 * 登录页面
	 * 
	 * @return
	 */
	@GetMapping("login")
	public String login() {
		// 如果已经认证通过，直接跳转到首页
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:" + prefix + "index";
		}

		return "login";
	}

	/**
	 * 处理登录请求(shiro自动处理，这里只处理信息)
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("ajaxLlogin")
	@ResponseBody
	public ApiModel ajaxLlogin(String username, String password,@RequestParam(required=false) Boolean rememberMe,HttpServletRequest request) {
		if(rememberMe==null) {
			rememberMe=false;
		}
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);
//		SysUser sysUser = userService.getByUsername(username);
//		sysUser.setLoginIp(request.getLocalAddr());
//		sysUser.setLoginDate(new Date());
//		sysUser.setLoginCount(sysUser.getLoginCount()+1);
//		userService.update(sysUser);
		try {
			// shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们在UserRealm里认证方法设置的来验证
			user.login(token);
			return ApiModel.success("登录成功");
		} catch (UnknownAccountException e) {
			// 账号不存在和下面密码错误一般都合并为一个账号或密码错误，这样可以增加暴力破解难度
			return ApiModel.fail("账号不存在！");
		} catch (DisabledAccountException e) {
			return ApiModel.fail("账号被禁用！");
		} catch (IncorrectCredentialsException e) {
			return ApiModel.fail("密码错误！");
		} catch (Throwable e) {
			return ApiModel.fail("未知错误！");
		}
	}

}
