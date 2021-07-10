package com.chendong.demo.common.scheduling;

import com.chendong.demo.common.scheduling.async.TestAsyncTask;
import com.chendong.demo.common.constants.DemoConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * 引入corn Spring 定时任务调度
 *
 * @author chendong
 * @date 2020/6/26 10:39 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Component
public class TimeScheduling {

    private static final Logger log = LoggerFactory.getLogger(TimeScheduling.class);

    @Resource
    private TestAsyncTask testAsyncTask;

    /**
     * 定时播报当前服务器的时间
     */
    @Scheduled(cron = "${time.cron}")
    public void reportCurTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DemoConstant.NOW_TIME_STR);
        String nowTime = dateFormat.format(new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("错误了");
        }
        String name = Thread.currentThread().getName();
        log.info("当前的线程为:" + name + ",现在的时间是：" + nowTime);
    }

    /**
     * 异步任务四
     */
    @Scheduled(initialDelay = 2000, fixedRate = 10000)
    public void showCurrentThread() {
        testAsyncTask.doTaskFour();
    }

    /**
     * 等待三个异步任务执行完
     */
    //@Scheduled(initialDelay = 3000, fixedDelay = 10000)
    public void waitingForOtherTask() {
        long start = System.currentTimeMillis();

        //三个任务异步执行
        Future<String> t1 = testAsyncTask.doTaskOne();
        Future<String> t2 = testAsyncTask.doTaskTwo();
        Future<String> t3 = testAsyncTask.doTaskThree();

        //等待执行完成后，再继续执行
        while (true) {
            if (t1.isDone() && t2.isDone() && t3.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        log.info(Thread.currentThread().getName() + "--->" + "所有的任务完成，耗时为：" + (end - start) + "毫秒");
    }

}
