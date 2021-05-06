package com.chendong.demo.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步线程池的配置类
 *
 * @author chendong
 * @date 2020/8/28 10:47 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Configuration
@EnableAsync
public class SyncThreadPoolConfig implements AsyncConfigurer {

    private static final Logger log = LoggerFactory.getLogger(SyncThreadPoolConfig.class);

    private static void handleUncaughtException(Throwable a, Method b, Object... c) {
        log.error(Thread.currentThread().getName() + "->线程出错了 a->{},b->{},c->{}",
                a.toString(),
                b.toString(),
                Arrays.toString(c));
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return SyncThreadPoolConfig::handleUncaughtException;
    }

    /**
     * 1.当任务数小于等于核心线程数+等待队列数量的总和时：只有两个核心线程在执行任务。
     * 2.当任务数大于核心线程数+等待队列数量的总和，但是小于等于最大线程数时：启动了最大线程来执行任务。
     * 3.当任务数大于最大线程数时：任务大于最大线程数，使用拒绝策略直接抛出异常。
     *
     * @return 线程池
     */
    @Bean("demoExecutor")
    public Executor demoExecutor() {

        //线程池的具体配置
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(10);
        //最大线程数
        executor.setMaxPoolSize(20);
        //阻塞队列的容量
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("demoExecutor-");
        //ThreadPoolExecutor.CallerRunsPolicy：当任务添加到线程池中被拒绝时，会调用当前线程池的所在的线程去执行被拒绝的任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }
}
