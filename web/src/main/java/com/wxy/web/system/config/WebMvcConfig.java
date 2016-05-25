package com.wxy.web.system.config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.wxy.web.system.interceptor.LoginInterceptor;


/**
 * Created by xinyu wei on 5/15/16.
 *
 * @author   <a href="564629989@qq.com">XinYu Wei</a>
 * @version  04/15/2016 03:33
 */
@Configuration public class WebMvcConfig extends WebMvcConfigurerAdapter {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
   */
  @Override public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginInterceptor());
  }
}
