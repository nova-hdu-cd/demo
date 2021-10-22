package com.chendong.demo.common.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.chendong.demo.common.spring.bean")
public class Demo004 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Demo004.class);
    }

}