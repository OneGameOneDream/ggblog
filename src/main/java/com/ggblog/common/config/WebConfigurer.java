package com.ggblog.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ggblog.common.domain.GGblogConfig;


@Component
public class WebConfigurer extends WebMvcConfigurerAdapter {
	@Autowired
	private GGblogConfig ggblogConfig;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//实现图片地址转发
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///"+ggblogConfig.getUploadPath());//转发到本地
		
	}

}