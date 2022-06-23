package com.chendong.demo.common.async;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import com.chendong.demo.common.scheduling.TimeScheduling;
import com.chendong.demo.controller.HelloController;

import cn.hutool.extra.spring.SpringUtil;

/**
 * junit 5
 */
@SpringBootTest
class TestTaskTestAsync {

    @Resource
    private TimeScheduling timeScheduling;

    @Test
    void test1() {
        boolean flag1 = true;
        boolean flag2 = false;
        System.out.println(flag1 && flag2);
    }

    @Test
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    void test3() {
        System.out.println();
    }

    @Test
    void testApplicationContext() {
        // SpringUtil工具类使用
        SpringUtil.registerBean("bean1", "hello world1!");
        SpringUtil.registerBean("bean2", "hello world2!");
        ApplicationContext applicationContext = SpringUtil.getApplicationContext();
        System.out.println(applicationContext.getBean("bean1"));
        System.out.println(applicationContext.getBean("bean2"));
        System.out.println(applicationContext.getApplicationName());

        // 获取IOC容器中的Controller
        HelloController helloController = (HelloController)applicationContext.getBean("helloController");
    }
}