package com.drzyl.config;

import com.drzyl.sign.interceptors.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.LinkedList;

@Configuration
@ConditionalOnProperty(prefix = "proconfig", name = "authorization-interceptor", havingValue = "true")
public class AuthorizationInterceptorWebMvcConfig implements WebMvcConfigurer {

  @Autowired
  private AuthorizationInterceptor authorizationInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    LinkedList<String> excludeUrl = new LinkedList<>();
    excludeUrl.add("/login");
    registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**").excludePathPatterns(excludeUrl);
  }

}
