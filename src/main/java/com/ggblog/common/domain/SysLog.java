package com.ggblog.common.domain;

import java.io.Serializable;

/**
 * 日志信息实体
 * 
 * @author 44359
 *
 */
public class SysLog extends BaseEntity<SysLog> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 客户端请求ip
	private String clientIp;
	// 客户端请求路径
	private String url;
	// 请求类型
	private String type;
	// 请求方式method,post,get等
	private String method;
	// 请求的类及方法
	private String classMethod;
	// 请求参数内容,json
	private String paramData;
	// 请求时httpStatusCode代码，如：200,400,404等
	private String httpStatusCode;
	// 请求耗时秒单位
	private int timeConsuming;
	// 异常描述
	private String exceptionMessage;
	// 请求开始时间
	private long startTime;
	// 请求结束时间
	private long endTime;
	
	
	
	
	/**
	 * @return the clientIp
	 */
	public String getClientIp() {
		return clientIp;
	}
	/**
	 * @param clientIp the clientIp to set
	 */
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @return the classMethod
	 */
	public String getClassMethod() {
		return classMethod;
	}
	/**
	 * @param classMethod the classMethod to set
	 */
	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}
	/**
	 * @return the paramData
	 */
	public String getParamData() {
		return paramData;
	}
	/**
	 * @param paramData the paramData to set
	 */
	public void setParamData(String paramData) {
		this.paramData = paramData;
	}
	/**
	 * @return the httpStatusCode
	 */
	public String getHttpStatusCode() {
		return httpStatusCode;
	}
	/**
	 * @param httpStatusCode the httpStatusCode to set
	 */
	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	/**
	 * @return the timeConsuming
	 */
	public int getTimeConsuming() {
		return timeConsuming;
	}
	/**
	 * @param timeConsuming the timeConsuming to set
	 */
	public void setTimeConsuming(int timeConsuming) {
		this.timeConsuming = timeConsuming;
	}
	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	/**
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public SysLog(String clientIp, String url, String type, String method, String classMethod,
			String paramData, String httpStatusCode, int timeConsuming, String exceptionMessage, long startTime,
			long endTime) {
		super();
		this.clientIp = clientIp;
		this.url = url;
		this.type = type;
		this.method = method;
		this.classMethod = classMethod;
		this.paramData = paramData;
		this.httpStatusCode = httpStatusCode;
		this.timeConsuming = timeConsuming;
		this.exceptionMessage = exceptionMessage;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public SysLog() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SysLog [clientIp=" + clientIp + ", url=" + url + ", type=" + type + ", method=" + method
				+ ", classMethod=" + classMethod + ", paramData=" + paramData + ", httpStatusCode=" + httpStatusCode
				+ ", timeConsuming=" + timeConsuming + ", exceptionMessage=" + exceptionMessage + ", startTime="
				+ startTime + ", endTime=" + endTime + "]";
	}
	
	
	
}
