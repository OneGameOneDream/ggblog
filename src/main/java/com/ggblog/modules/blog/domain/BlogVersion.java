package com.ggblog.modules.blog.domain;

import com.ggblog.common.domain.BaseEntity;

/**
 * 博客版本实体
 * @author 44359
 *
 */
public class BlogVersion extends BaseEntity<BlogVersion>{
		private String url; //博客域名
		private String logo; //博客Logo
		private String title; //博客主页标题
		private String banner; //博客主页图片
		private Integer hits; //博客点击量
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
		 * @return the logo
		 */
		public String getLogo() {
			return logo;
		}
		/**
		 * @param logo the logo to set
		 */
		public void setLogo(String logo) {
			this.logo = logo;
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
		 * @return the banner
		 */
		public String getBanner() {
			return banner;
		}
		/**
		 * @param banner the banner to set
		 */
		public void setBanner(String banner) {
			this.banner = banner;
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
		public BlogVersion(String url, String logo, String title, String banner, Integer hits) {
			super();
			this.url = url;
			this.logo = logo;
			this.title = title;
			this.banner = banner;
			this.hits = hits;
		}
		public BlogVersion() {
			super();
		}
		
		
}
