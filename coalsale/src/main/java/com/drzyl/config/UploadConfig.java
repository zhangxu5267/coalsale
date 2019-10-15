package com.drzyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 文件上传配置
 */
@Configuration
public class UploadConfig {
	/**
	 * 文件上传配置
	 * @return multipartResolver
	 */
	@Bean
	public CommonsMultipartResolver commonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(524288000);//500兆字节(mb)=524288000字节(b)
		multipartResolver.setDefaultEncoding("UTF-8");//默认字符
		return multipartResolver;
	}

}
