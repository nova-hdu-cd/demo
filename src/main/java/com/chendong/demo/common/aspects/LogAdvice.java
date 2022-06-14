package com.chendong.demo.common.aspects;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 日志切面增强类
 *
 * @author dong.chen
 */
@Aspect
@Component
public class LogAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAdvice.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void logAdvicePointCut() {
    }

    @Before("logAdvicePointCut()")
    public void logAdvice() {
        ApplicationContext applicationContext = SpringUtil.getApplicationContext();
        String applicationContextId = applicationContext.getId();
        String applicationName = applicationContext.getApplicationName();

        Thread mainThread = ThreadUtil.getMainThread();

        LOGGER.info("start: 应用名称：{}，应用id： {}，线程名:{}", applicationName, applicationContextId, mainThread.getName());
    }

    @After("logAdvicePointCut()")
    public void logAfter() {
        ApplicationContext applicationContext = SpringUtil.getApplicationContext();
        String applicationContextId = applicationContext.getId();
        String applicationName = applicationContext.getApplicationName();

        LOGGER.info("end: 应用名称：{}，应用id： {}", applicationName, applicationContextId);
    }

}
