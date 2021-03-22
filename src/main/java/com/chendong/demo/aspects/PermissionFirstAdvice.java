package com.chendong.demo.aspects;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class PermissionFirstAdvice {

    public static final String illegalStr = "{\"message\":\"illegal id\",\"code\":403}";

    // 定义一个切面，括号内写入第1步中自定义注解的路径
    @Pointcut("@annotation(com.chendong.demo.common.anotations.PermissionAnnotation)")
    private void permissionCheck() {
    }

    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("===================第一个切面===================：" + System.currentTimeMillis());

        //获取请求参数，详见接口类
        Object[] objects = joinPoint.getArgs();
        Long id = ((JSONObject) objects[0]).getLong("id");
        String name = ((JSONObject) objects[0]).getString("name");
        System.out.println("id ->>>>>>>>>>>>>>>>>>>>>> " + id);
        System.out.println("name ->>>>>>>>>>>>>>>>>>>>>> " + name);

        // id小于0则抛出非法id的异常
        if (id < 0) {
            return JSONObject.parseObject(illegalStr);
        }

        return joinPoint.proceed();
    }
}
