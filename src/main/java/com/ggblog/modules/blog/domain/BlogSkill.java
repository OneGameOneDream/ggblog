package com.ggblog.modules.blog.domain;

import com.ggblog.common.domain.BaseEntity;

public class BlogSkill extends BaseEntity<BlogSkill>{
	private String image;//技能图片
	private String name;	//技能名
	private Integer sort; //权重
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
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

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public BlogSkill() {
		super();
	}
	public BlogSkill(String image) {
		super();
		this.image = image;
	}

	
}
