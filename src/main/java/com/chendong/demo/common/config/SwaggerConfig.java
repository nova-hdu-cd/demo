package com.chendong.demo.common.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger接口文档的配置类
 *
 * @author chendong
 * @date 2020/7/22 8:06 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.port}")
    private String localHostPort;

    @Bean
    public Docket merchantStoreApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.host("localhost:8080")
                .apiInfo(apiInfo())
                //.groupName("internal-api")
                //.genericModelSubstitutes(DeferredResult.class)
                //.useDefaultResponseMessages(false)
                //.forCodeGeneration(true)
                // base，最终调用接口后会和paths拼接在一起
                .pathMapping("/")
                //选择那些路径和api会生成文档
                .select()
                //只对api注解的controller进行展示
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //.paths(or(regex("/api/.*")))
                //错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/erro.*")))
                //对根下所有的路径进行监控
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Demo项目接口文档")
                .contact(new Contact("chendong", "hello world！", "chendong_hdu@163.com"))
                .description("swagger动态生成的接口文档")
                .termsOfServiceUrl("no terms of service")
                .license("unisoc license")
                .version("1.0")
                .build();
    }
}
