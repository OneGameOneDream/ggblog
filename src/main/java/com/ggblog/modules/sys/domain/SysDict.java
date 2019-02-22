package com.ggblog.modules.sys.domain;

import java.util.Date;

import com.ggblog.common.domain.BaseEntity;

/**
 * 系统字典类
 * 
 * @author 44359
 *
 */
public class SysDict extends BaseEntity<SysDict> {
	private String label; // 标签名
	private String value; // 数据值
	private String type; // 类型
	private Integer sort; // 排序

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public SysDict(String label, String value, String type, Integer sort) {
		super();
		this.label = label;
		this.value = value;
		this.type = type;
		this.sort = sort;
	}

	public SysDict() {
		super();
	}


}
