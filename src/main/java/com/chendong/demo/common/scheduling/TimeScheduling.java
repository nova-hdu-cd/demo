package com.chendong.demo.common.scheduling;

import com.chendong.demo.common.async.AsyncTask;
import com.chendong.demo.common.constants.DateFormatConstant;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * corn Spring 定时任务调度
 *
 * @author chendong
 * @date 2020/6/26 10:39 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Component
public class TimeScheduling {

    @Resource
    private AsyncTask asyncTask;

    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void reportCurTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatConstant.HH_MM_SS);
        String name = Thread.currentThread().getName();
        System.out.println(name + "现在的时间是：" + dateFormat.format(new Date()));
    }

    @Scheduled(initialDelay = 2000, fixedRate = 10000)
    public void showCurrentThread() {
        asyncTask.doTaskFour();
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 10000)
    public void waitingForOtherTask() throws InterruptedException {
        long start = System.currentTimeMillis();

        //三个任务异步执行
        Future<String> t1 = asyncTask.doTaskOne();
        Future<String> t2 = asyncTask.doTaskTwo();
        Future<String> t3 = asyncTask.doTaskThree();

        //等待执行完成后，再继续执行
        while (true) {
            if (t1.isDone() && t2.isDone() && t3.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "--->" + "所有的任务完成，耗时为：" + (end - start) + "毫秒");
    }

}
