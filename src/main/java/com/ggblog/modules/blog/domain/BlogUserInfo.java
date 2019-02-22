package com.ggblog.modules.blog.domain;

import com.ggblog.common.domain.BaseEntity;


/**
 * 博主信息
 * @author 44359
 *
 */
public class BlogUserInfo extends BaseEntity<BlogUserInfo>{
	private String name;	//姓名
	private String qrcode;	//二维码
	private String wechat;	//微信
	private String phone;	//电话
	private String email;	//email
	private Integer age;	//年龄
	private String job;		//职业
	private String hobby;	//爱好
	private String head;	//头像
	
	
	
	/**
	 * @return the head
	 */
	public String getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	public void setHead(String head) {
		this.head = head;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the qrcode
	 */
	public String getQrcode() {
		return qrcode;
	}
	/**
	 * @param qrcode the qrcode to set
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	/**
	 * @return the wechat
	 */
	public String getWechat() {
		return wechat;
	}
	/**
	 * @param wechat the wechat to set
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}
	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public BlogUserInfo() {
		super();
	}
	public BlogUserInfo(String name, String qrcode, String wechat, String phone, String email, Integer age, String job,
			String hobby, String head) {
		super();
		this.name = name;
		this.qrcode = qrcode;
		this.wechat = wechat;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.job = job;
		this.hobby = hobby;
		this.head = head;
	}
	
	
	
	
}
