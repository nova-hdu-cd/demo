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

    @Bean("demoExecutor")
    public Executor demoExecutor() {

        //线程池的具体配置
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("demoExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }
}
