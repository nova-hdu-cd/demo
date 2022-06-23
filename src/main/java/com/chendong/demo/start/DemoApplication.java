package com.chendong.demo.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * demo应用的启动类和入口
 *
 * @author dong.chen
 */
@SpringBootApplication(scanBasePackages = "com.chendong.demo")
@EnableAsync
@EnableScheduling
@MapperScan("com.chendong.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
