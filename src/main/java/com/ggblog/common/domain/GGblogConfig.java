package com.ggblog.common.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ggblog")
public class GGblogConfig {
	// 上传路径
	private String uploadPath;

	/**
	 * @param uploadPath the uploadPath to set
	 */
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	/**
	 * 获取上传路径
	 * @return the uploadPath
	 */
	public String getUploadPath() {
		return uploadPath;
	}

}
