package com.ggblog.common.domain;

import java.util.List;

public class ApiModel {
	private String code; // 响应码
	private String msg; // 返回信息
	private Integer count; // 返回时间戳
	private Object data;// 返回数据

	public ApiModel(String code, String msg, Integer count, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	
	public ApiModel(String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = 0;
		this.data = data;
	}
	
	
	public ApiModel() {
		super();
	}

	/**
	 * 响应成功
	 * 
	 * @param object
	 * @return
	 */
	public static ApiModel success(Integer count,Object object) {
		return new ApiModel("200", "success",count, object);
	}
	
	public static ApiModel success(Integer count) {
		return new ApiModel("200", "success",count, null);
	}
	
	public static ApiModel success(List<?> list) {
		return new ApiModel("200", "success",list.size(), list);
	}
	
	public static ApiModel success(Object object) {
		return new ApiModel("200", "success",0, object);
	}

	/**
	 * 响应失败
	 * 
	 * @return
	 */
	public static ApiModel fail(Object object) {
		return new ApiModel("500", "fail", 0, object);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
