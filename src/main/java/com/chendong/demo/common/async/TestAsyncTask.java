package com.chendong.demo.common.async;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * 异步任务
 *
 * @author chendong
 * @date 2020/6/26 10:07 上午 To change this template use Appearance | Editor | File and Code Templates.
 */
@Component
public class TestAsyncTask {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static {
        threadLocal.set("k1");
    }

    private static final Logger log = LoggerFactory.getLogger(TestAsyncTask.class);

    @Async("demoExecutor")
    public void taskForThreadLocal() {
        String s = threadLocal.get();
        log.info(" threadLocal.item ->{}", JSON.toJSONString(s));
    }

    @Async("demoExecutor")
    public void doTaskFour() {
        log.info(Thread.currentThread().getName() + "-->" + "任务四 running !");
    }

    @Async("demoExecutor")
    public Future<List<String>> doTaskOne() {
        String name = Thread.currentThread().getName();
        log.info("[线程]：{} 开始做任务1", name);
        long start = System.currentTimeMillis(), end = System.currentTimeMillis();
        log.info("[线程]：{} 完成任务1，需要的时间：{}毫秒", name, end - start);

        List<String> list = Arrays.asList("hello world", " this is");

        return new AsyncResult<>(list);
    }

    @Async("demoExecutor")
    public Future<String> doTaskTwo() {
        String name = Thread.currentThread().getName();
        log.info(name + "-->" + "开始做任务2");
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        log.info(name + "-->" + "完成任务2，需要的时间：" + (end - start) + "毫秒");
        return new AsyncResult<>(name + "任务2完成");
    }

    @Async("demoExecutor")
    public Future<String> doTaskThree() {
        String name = Thread.currentThread().getName();
        log.info(name + "--->" + "开始做任务3");
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        log.info(name + "--->" + "完成任务3，需要的时间：" + (end - start) + "毫秒");
        return new AsyncResult<>(name + "任务3完成");
    }

    @Async("timeSchedulingExecutor")
    public void doTaskFive() {
        log.info("[线程：]->{}", Thread.currentThread().getName());
    }

}
