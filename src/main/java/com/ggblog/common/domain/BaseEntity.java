package com.ggblog.common.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 模板实体类
 * 
 * @author 44359
 *
 */
public abstract class BaseEntity<T> {
	private String id; // 编号
	private String createBy; // 创建人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate; // 创建日期
	private String updateBy; // 更新人
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate; // 更新日期
	private String remarks; // 描述
	private String delFlag; // 删除标识
	
	
	private Integer page;//页数
	private Integer limit;//每页显示的记录数

	private SysPage<T> sysPage;//当前实体分页对象
	
	
	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * @return the sysPage
	 */
	public SysPage<T> getSysPage() {
		return sysPage;
	}

	/**
	 * @param sysPage the sysPage to set
	 */
	public void setSysPage(SysPage<T> sysPage) {
		this.sysPage = sysPage;
	}

	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {

		this.delFlag = delFlag;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the createBy
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the createDate
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateBy
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @return the updateDate
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public BaseEntity(String id, String createBy, Date createDate, String updateBy, Date updateDate, String remarks,
			String delFlag) {
		super();
		this.id = id;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
		this.remarks = remarks;
		this.delFlag = "0";
	}

	public BaseEntity() {
		super();
	}

}
