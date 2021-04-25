package com.chendong.demo.common.config;

import com.chendong.demo.common.anotations.SwaggerIgnore;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

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
                .apiInfo(testApiInfo())
                //.groupName("internal-api")
                //.genericModelSubstitutes(DeferredResult.class)
                //.useDefaultResponseMessages(false)
                //.forCodeGeneration(true)
                // base，最终调用接口后会和paths拼接在一起
                .pathMapping("/")
                //选择那些路径和api会生成文档
                .select()
                //SwaggerIngore的注解的controller将会被忽略
                .apis(not(withClassAnnotation(SwaggerIgnore.class)))
                //.paths(or(regex("/api/.*")))
                //错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/erro.*")))
                //对根下所有的路径进行监控
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo testApiInfo() {
        return new ApiInfoBuilder().title("Demo项目接口文档")
                .contact(new Contact("chendong", "hello world！", "chendong_hdu@163.com"))
                .description("swagger动态生成的接口文档")
                .termsOfServiceUrl("no terms of service")
                .license("unisoc license")
                .version("1.0")
                .build();
    }
}
