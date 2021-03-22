package com.chendong.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void logAdvicePointCut(){}

    @Before("logAdvicePointCut()")
    public void logAdvice(){
        System.out.println("aop 切面触发了!");
    }

}
