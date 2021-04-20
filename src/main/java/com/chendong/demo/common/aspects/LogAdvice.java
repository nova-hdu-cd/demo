package com.chendong.demo.common.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAdvice.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void logAdvicePointCut() {
    }

    @Before("logAdvicePointCut()")
    public void logAdvice() {
        LOGGER.info("aop 切面触发了!");
    }

}
