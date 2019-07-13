package com.ups.demo.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final static Log log = LogFactory.getLog(WebSecurityConfig.class);

    // 如果有一个Filter，来实现从cookie创建当前用户（或其他），需要确保这个filter在BasicAuthenticationFilter之前执行，可以用下面这句
    // httpSecurity.addFilterBefore( new JwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class);
    // 这样就不再需要在filter上增加@Component等类似注解了。如果增加了，可能会导致filter重复执行2次

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("configure httpSecurity...");
        }
        
        //默认的spring-security配置会让所有的请求都必须在已登录的状况下访问；下面这段代码禁止了这种操作。
        httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("user").hasAnyRole("reader","admin").anyRequest().permitAll();
        //普通用户和管理员都能修改个人信息
    }

}
