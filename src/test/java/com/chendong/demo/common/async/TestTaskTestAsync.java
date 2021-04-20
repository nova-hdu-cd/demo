package com.chendong.demo.common.async;

import com.chendong.demo.common.scheduling.TimeScheduling;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class TestTaskTestAsync {

    @Resource
    private TestAsyncTask task;

    @Resource
    private TimeScheduling timeScheduling;

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
}