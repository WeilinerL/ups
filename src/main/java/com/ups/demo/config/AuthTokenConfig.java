package com.ups.demo.config;

import com.ups.demo.filter.AuthenticationTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthTokenConfig {
    /**
     * 拦截器注册
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean myOncePerRequestFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationTokenFilter());
        registration.addUrlPatterns("/device_list");// 拦截路径
        registration.setName("MyOncePerRequestFilter");// 拦截器名称
        registration.setOrder(1);// 顺序
        return registration;
    }

}
