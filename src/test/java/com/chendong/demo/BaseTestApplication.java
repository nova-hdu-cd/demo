package com.chendong.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @author chendong
 * @date 2020/8/20 4:57 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@SpringBootApplication(scanBasePackages = "com.chendong.demo")
@PropertySource("classpath:application.properties")
public class BaseTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseTestApplication.class, args);
    }

}
