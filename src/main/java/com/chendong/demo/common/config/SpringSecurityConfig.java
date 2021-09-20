package com.chendong.demo.common.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringSecurity的配置类
 *
 * @author dong.chen
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //简单配置spring security的过滤器链
        http.authorizeRequests()
                //放行swagger的访问
                .antMatchers("/doc.html/*", "/swagger-ui.html/*").permitAll()
                .and()
                .cors().disable()
                .csrf().disable().httpBasic();
    }
}
