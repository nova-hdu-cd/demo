package com.chendong.demo.common.config;

import lombok.extern.slf4j.Slf4j;
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
 * @author chendong
 * @date 2020/8/28 10:47 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Configuration
@EnableAsync
@Slf4j
public class AppConfig implements AsyncConfigurer {

    private static void handleUncaughtException(Throwable a, Method b, Object... c) {
        log.error("异步线程出错了 a->{},b->{},c->{}",
                a.toString(),
                b.toString(),
                Arrays.toString(c));
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        AsyncUncaughtExceptionHandler handler = AppConfig::handleUncaughtException;
        return handler;
    }

    @Bean("demoExecutor")
    public Executor demoExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("chendong-thread-");

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }
}
