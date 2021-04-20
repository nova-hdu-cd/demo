package com.chendong.demo.common.scheduling;

import com.chendong.demo.common.async.TestAsyncTask;
import com.chendong.demo.common.constants.DomeConstant;
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
     * 定时播报当前时间
     */
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void reportCurTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DomeConstant.HH_MM_SS);
        String nowTime = dateFormat.format(new Date());
        String name = Thread.currentThread().getName();
        log.info("线程:" + name + ",现在的时间是：" + nowTime);
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
    @Scheduled(initialDelay = 3000, fixedDelay = 10000)
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
