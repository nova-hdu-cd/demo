package com.chendong.demo.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义mvc配置类接管springMVC
 */
@Configuration
//@EnableWebMvc //这个注解会使得springmvc的自动配置失效,注意配置的favicon失效了
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/chen").setViewName("index");
    }
}
