package com.ggblog.common.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.hutool.http.HttpUtil;

/**
 * 日志拦截器
 * 
 * @author 44359
 *
 */
@Aspect
@Component
public class WebLogAspect {

	/**
	 * 创建SLF4J实例
	 */
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	/**
	 * 声明一个切点
	 */
	@Pointcut("execution(* com.ggblog..controller.*.*(..))")
	private void logPointCut() {
	}

	/**
	 * 前置通知拦截
	 * 
	 * @param joinPoint
	 */
	@Before("logPointCut()")
	public void doBefore(JoinPoint joinPoint) {
		// 接受请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("请求地址：" + request.getRequestURL().toString());
		logger.info("请求方式： " + request.getMethod());
		// 获取真实的ip地址
		logger.info("IP地址：" + HttpUtil.getClientIP(request, ""));
		logger.info("方法路径： " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("请求参数：" + Arrays.toString(joinPoint.getArgs()));
//        loggger.info("参数 : " + joinPoint.getArgs());

	}

	/**
	 * 后置返回通知
	 * 
	 * @param ret
	 * @throws Throwable
	 */
	@AfterReturning(returning = "obj", pointcut = "logPointCut()") // returning的值和doAfterReturning的参数名一致
	public void doAfterReturning(Object obj) throws Throwable {
		// 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
		logger.debug("返回值：" + obj);
	}
	/**
	 * 环绕通知
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();// ob 为方法的返回值
        logger.info("耗时：" + (System.currentTimeMillis() - startTime)+"毫秒");
        return ob;
    }
	

}
