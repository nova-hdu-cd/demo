package com.chendong.demo.common.aspects;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chendong.demo.common.constants.DemoConstant;
import com.chendong.demo.common.utils.LocalDateUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 自定义注解PermissionAnnotation+切面实现权限管理
 *
 * @author dong.chen
 */
@Aspect
@Component
@Order(1)
public class PermissionFirstAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionFirstAdvice.class);

    public static final String ILLEGAL_STR = "{\"message\":\"illegal uuid\",\"code\":403}";

    /**
     * 定义一个切面，括号内写入第1步中自定义注解的路径
     */
    @Pointcut("execution(public * com.chendong.demo.controller.HelloController.hello*(..)) && @annotation(com.chendong.demo.common.anotations.PermissionAnnotation)")
    private void permissionCheck() {
    }

    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("正在获取带注解@PermissionAnnotation的方法的参数中：" + LocalDateUtils.getLocalDateStr() + DemoConstant.BLANK_STRING + LocalDateUtils.getLocalTimeStr());
        //获取请求参数数组，详见接口类
        Object[] args = joinPoint.getArgs();
        LOGGER.info("请求参数args -> {}", JSON.toJSON(args));

        LOGGER.info("获取带注解@PermissionAnnotation的方法的参数结束：" + LocalDateUtils.getLocalDateStr() + DemoConstant.BLANK_STRING + LocalDateUtils.getLocalTimeStr());

        String uuid = ((JSONObject) JSON.toJSON(args[0])).getString("uuid");
        LOGGER.info("uuid->{}", uuid);

        //业务逻辑
        if (Long.parseLong(uuid) < 1000) {
            return ILLEGAL_STR;
        }
        return joinPoint.proceed();
    }
}
