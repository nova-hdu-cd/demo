package com.chendong.demo.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * demo应用的启动类和入口
 * @author dong.chen
 */
@SpringBootApplication(scanBasePackages = "com.chendong.demo")
@EnableAsync
@EnableScheduling
@EnableSwagger2
@MapperScan({"com.chendong.demo.dao", "com.chendong.demo.mapper"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
