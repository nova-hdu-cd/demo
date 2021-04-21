package com.chendong.demo.common.config;

import com.chendong.demo.common.intercepter.ResponseResultIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义mvc配置类接管springMVC
 */
@Configuration
//@EnableWebMvc //这个注解会使得springmvc的自动配置失效,注意配置的favicon失效了
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 添加自己的视图解析器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/chen").setViewName("index");
    }

    /**
     * 添加自己的拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册ResponseResultIntercepter拦截器
        registry.addInterceptor(new ResponseResultIntercepter())
                .addPathPatterns("/**")//拦截所有url
                .excludePathPatterns("/", "/error", "/static/**");//排除部分url

    }

    /**
     * 添加自己的格式化
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }
}
