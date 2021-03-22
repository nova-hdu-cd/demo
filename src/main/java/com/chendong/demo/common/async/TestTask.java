package com.chendong.demo.common.async;

import com.chendong.demo.common.utils.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 异步的方法和任务
 *
 * @author chendong
 * @date 2020/6/26 10:07 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Component
public class TestTask {

    private static NumberUtil numberUtil = null;

    private static final Logger log = LoggerFactory.getLogger(TestTask.class);

    static {
        numberUtil = new NumberUtil();
    }

    @Async("demoExecutor")
    public void doTaskFour() {
        //int a = 1 / 0;
        log.info(Thread.currentThread().getName() + "----->" + "didi !");
    }

    @Async("demoExecutor")
    public Future<String> doTaskOne() throws InterruptedException {
        String name = Thread.currentThread().getName();
        log.info(name + "--->" + "开始做任务1");

        long start = System.currentTimeMillis();
        Thread.sleep(numberUtil.getRandomNumber(1000));
        long end = System.currentTimeMillis();

        log.info(name + "--->" + "完成任务1，需要的时间：" + (end - start) + "毫秒");

        return new AsyncResult<>(name + "任务1完成");
    }

    @Async("demoExecutor")
    public Future<String> doTaskTwo() throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name + "--->" + "开始做任务2");
        long start = System.currentTimeMillis();
        Thread.sleep(numberUtil.getRandomNumber(1000));
        long end = System.currentTimeMillis();
        System.out.println(name + "--->" + "完成任务2，需要的时间：" + (end - start) + "毫秒");
        return new AsyncResult<>(name + "任务2完成");
    }

    @Async("demoExecutor")
    public Future<String> doTaskThree() throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name + "--->" + "开始做任务3");
        long start = System.currentTimeMillis();
        Thread.sleep(numberUtil.getRandomNumber(1000));
        long end = System.currentTimeMillis();
        System.out.println(name + "--->" + "完成任务3，需要的时间：" + (end - start) + "毫秒");
        return new AsyncResult<>(name + "任务3完成");
    }

}
