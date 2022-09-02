package com.chendong.demo.common.config;

import com.chendong.demo.common.intercepter.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * 自定义mvc配置类扩展springMVC
 *
 * @author dong.chen
 */
@Configuration
// @EnableWebMvc //这个注解会使得springmvc的自动配置失效,注意配置的favicon失效了
public class LocalMvcConfig implements WebMvcConfigurer {

    /**
     * 添加自己的视图解析器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/chen").setViewName("index");
    }

    /**
     * 静态资源映射配置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadFile/**").addResourceLocations("file:D:/uploadFile/");
    }

    /**
     * 添加自己的拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册统一返回拦截器
        registry.addInterceptor(new ResponseResultInterceptor())
                // 拦截所有url
                .addPathPatterns("/**")
                // 排除部分url
                .excludePathPatterns("/", "/static/**");
    }

    /**
     * 添加自己的格式化处理器
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
    }

    /**
     * 注册自己的消息转换
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        // 采用Jackson处理返回String的情况
        converters.add(0, new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*")
                .maxAge(3600 * 24);
    }
}
