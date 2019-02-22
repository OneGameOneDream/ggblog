package com.ggblog.common.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ggblog.common.annotation.Log;
import com.ggblog.common.domain.SysLog;
import com.ggblog.common.service.SysLogService;
import com.ggblog.common.utils.LoggerUtils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

@Aspect
@Component
public class LoggerAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

	@Autowired
	private SysLogService logService;

	@Pointcut("@annotation(com.ggblog.common.annotation.Log)")
	public void logPointCut() {
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		// 执行方法
		Object result = point.proceed();
		// 执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;
		// 异步保存日志
		saveLog(point, beginTime, System.currentTimeMillis(), time);
		return result;
	}

	/**
	 * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息
	 * 
	 * 注意：执行顺序在Around Advice之后
	 * 
	 * @author lyl
	 * @param joinPoint
	 * @param e
	 * @throws ClassNotFoundException
	 * @throws InterruptedException
	 */
	@AfterThrowing(value = "logPointCut()", throwing = "e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) throws ClassNotFoundException, InterruptedException {
		logger.error("异常名称：" + e.getClass().toString().replace("class", "").trim());
		// 保存异常日志
		saveErrorLog(joinPoint, e.getClass().toString().replace("class", "").trim());
	}

	/**
	 * 保存常规日志
	 * 
	 * @param joinPoint
	 * @param startTime
	 * @param endTime
	 * @param time
	 * @throws InterruptedException
	 */
	void saveLog(ProceedingJoinPoint joinPoint, long startTime, long endTime, long time) throws InterruptedException {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLog sysLog = new SysLog();
		Log syslog = method.getAnnotation(Log.class);
		if (syslog != null) {
			// 注解上的描述
			sysLog.setRemarks(syslog.value());
		}
		// 请求的参数
		String params = Arrays.toString(joinPoint.getArgs());
		sysLog.setParamData(params);
		// 获取request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获取response
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		// 设置url
		sysLog.setUrl(request.getRequestURI());
		// 设置请求类型
		sysLog.setMethod(request.getMethod());
		// 设置请求具体方法名
		sysLog.setClassMethod(
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		// 设置请求类型(是否为ajax请求)
		sysLog.setType(LoggerUtils.getRequestType(request));
		// 设置请求返回状态值
		sysLog.setHttpStatusCode(StrUtil.toString(response.getStatus()));
		// 设置IP地址
		sysLog.setClientIp(HttpUtil.getClientIP(request, ""));
		// 设置总耗时
		sysLog.setTimeConsuming((int) time);
		// 设置开始时间
		sysLog.setStartTime(startTime);
		// 设置结束时间
		sysLog.setEndTime(endTime);
		// 保存错误类型
		sysLog.setType("success");
		// 保存系统日志
		logService.insert(sysLog);
	}

	/**
	 * 保存异常日志
	 * 
	 * @param joinPoint
	 * @param startTime
	 * @param endTime
	 * @param time
	 * @throws InterruptedException
	 */
	void saveErrorLog(JoinPoint joinPoint, String errorMes) throws InterruptedException {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLog sysLog = new SysLog();
		Log syslog = method.getAnnotation(Log.class);
		if (syslog != null) {
			// 注解上的描述
			sysLog.setRemarks(syslog.value());
		}
		// 请求的参数
		String params = Arrays.toString(joinPoint.getArgs());
		sysLog.setParamData(params);
		// 获取request
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 设置url
		sysLog.setUrl(request.getRequestURI());
		// 设置请求类型
		sysLog.setMethod(request.getMethod());
		// 设置请求具体方法名
		sysLog.setClassMethod(
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		// 设置请求类型(是否为ajax请求)
		sysLog.setType(LoggerUtils.getRequestType(request));
		// 设置请求返回状态值
		sysLog.setHttpStatusCode(StrUtil.toString(500));
		// 设置IP地址
		sysLog.setClientIp(HttpUtil.getClientIP(request, ""));
		// 设置报错信息
		sysLog.setExceptionMessage(errorMes);
		// 保存错误类型
		sysLog.setType("error");
		// 保存系统日志
		logService.insert(sysLog);
	}

}
