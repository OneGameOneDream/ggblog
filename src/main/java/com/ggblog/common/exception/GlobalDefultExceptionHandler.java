package com.ggblog.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggblog.common.domain.ApiModel;

/**
 * 全局异常处理类
 * 
 * @author 44359
 *
 */
@ControllerAdvice // @ControllerAdvice注解：控制器增强，一个被@Component注册的组件。
public class GlobalDefultExceptionHandler {
	// 声明要捕获的异常,@ExceptionHandler(Exception.class)
	// 用来捕获@requestMapping的方法中所有抛出的exception
	//UnauthorizedException无权限错误
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseBody
	public ApiModel defultUnauthorizedExceptionHandler(HttpServletRequest request, Exception e) {
		return ApiModel.fail("操作没有权限");
	}
}
