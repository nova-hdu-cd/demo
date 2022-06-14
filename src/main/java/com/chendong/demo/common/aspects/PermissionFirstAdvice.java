package com.chendong.demo.common.aspects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 自定义注解PermissionAnnotation+切面实现权限管理
 *
 * @author dong.chen
 */
@Aspect
@Component
@Order(1)
public class PermissionFirstAdvice {

    private static final Set<String> UUID_SET = new HashSet<>();

    static {
        UUID_SET.addAll(Arrays.asList("11111", "10001"));
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionFirstAdvice.class);

    public static final String ILLEGAL_STR = "{\"message\":\"illegal uuid\",\"code\":403}";

    /**
     * 定义一个切面，括号内写入第1步中自定义注解的路径
     */
    @Pointcut("execution(public * com.chendong.demo.controller.HelloController.hello*(..)) && @annotation(com.chendong.demo.common.anotations.PermissionAnnotation)")
    private void permissionCheck() {}

    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("开始权限校验逻辑！");
        // 获取请求参数数组，详见接口类
        Object[] args = joinPoint.getArgs();
        LOGGER.info("请求参数args -> {}", JSON.toJSON(args));
        String uuid = ((JSONObject)JSON.toJSON(args[0])).getString("uuid");
        LOGGER.info("uuid->{}", uuid);

        boolean pass = UUID_SET.contains(uuid);

        // 业务逻辑
        if (Long.parseLong(uuid) < 1000 && pass) {
            return ILLEGAL_STR;
        }
        LOGGER.info("权限校验逻辑结束！");
        return joinPoint.proceed();
    }
}
