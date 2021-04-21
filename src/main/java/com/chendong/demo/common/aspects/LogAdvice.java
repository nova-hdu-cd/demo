package com.chendong.demo.common.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        LOGGER.info("===============aop切面,开始触发了!=====================");
        LOGGER.info("===============aop切面,结束触发了!=====================");
    }

}
