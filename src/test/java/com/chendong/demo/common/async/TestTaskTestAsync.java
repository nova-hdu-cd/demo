package com.chendong.demo.common.async;

import cn.hutool.extra.spring.SpringUtil;
import com.chendong.demo.common.pojo.Dog;
import com.chendong.demo.common.scheduling.TimeScheduling;
import com.chendong.demo.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * junit 5
 */
@SpringBootTest
class TestTaskTestAsync {

    @Resource
    private TestAsyncTask task;

    @Resource
    private TimeScheduling timeScheduling;

    @Test
    void test4() throws InterruptedException {
        task.taskForThreadLocal();
    }

    @Test
    void test() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> t1 = task.doTaskOne();
        Future<String> t2 = task.doTaskTwo();
        Future<String> t3 = task.doTaskThree();
        while (true) {
            if (t1.isDone() && t2.isDone() && t3.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("所有的任务完成，耗时为：" + (end - start));
    }

    @Test
    void test1() {
        boolean flag1 = true;
        boolean flag2 = false;
        System.out.println(flag1 && flag2);
    }

    @Test
    void test2() {
//        TicketDTO ticketDTO = TicketDTO.builder().id("sx294").name("chendong").sex(1).build();
//        System.out.println(ticketDTO);
    }

    @Test
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    void test3() {
        System.out.println();
    }

    @Test
    void testApplicationContext() {
        //SpringUtil工具类使用
        SpringUtil.registerBean("bean1", "hello world1!");
        SpringUtil.registerBean("bean2", "hello world2!");
        ApplicationContext applicationContext = SpringUtil.getApplicationContext();
        System.out.println(applicationContext.getBean("bean1"));
        System.out.println(applicationContext.getBean("bean2"));
        System.out.println(applicationContext.getApplicationName());

        //获取IOC容器中的Controller
        HelloController helloController = (HelloController) applicationContext.getBean("helloController");
        Dog dog = helloController.index("op");
        System.out.println(dog);
    }
}