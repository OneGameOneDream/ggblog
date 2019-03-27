package com.ggblog.modules.blog.domain;

import com.ggblog.common.domain.BaseEntity;

/**
 * 文章实体
 * @author 44359
 *
 */
public class BlogArticle extends BaseEntity<BlogArticle>{
	
	private String title;//标题
	private String content;//内容
	private String tags;//标签
	private Integer hits;//点击量
	private String author;//作者
	private String allowComment;//是否允许评论(0:允许1:不允许)
	private String link;//外部链接
	private String image;//图片
	private Integer sort; //权重排序
	private String isCarousel; //是否轮播图
	
	
	public String getIsCarousel() {
		return isCarousel;
	}
	public void setIsCarousel(String isCarousel) {
		this.isCarousel = isCarousel;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}
	/**
	 * @return the hits
	 */
	public Integer getHits() {
		return hits;
	}
	/**
	 * @param hits the hits to set
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAllowComment() {
		return allowComment;
	}
	public void setAllowComment(String allowComment) {
		this.allowComment = allowComment;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
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

	public BlogArticle(String title, String content, String tags, Integer hits, String author, String allowComment,
			String link, String image, Integer sort, String isCarousel) {
		super();
		this.title = title;
		this.content = content;
		this.tags = tags;
		this.hits = hits;
		this.author = author;
		this.allowComment = allowComment;
		this.link = link;
		this.image = image;
		this.sort = sort;
		this.isCarousel = isCarousel;
	}
	public BlogArticle() {
		super();
	}
	
}
