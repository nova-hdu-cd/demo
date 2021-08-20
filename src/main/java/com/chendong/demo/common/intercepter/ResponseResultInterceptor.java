package com.chendong.demo.common.intercepter;

import com.chendong.demo.common.anotations.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 自定义拦截器
 * 当类或方法上有注解@ResponseResult时，向请求域中添加标识
 *
 * @author dong.chen
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultInterceptor.class);

    private static final String RESPONSE_UNION_CODE = "RESPONSE_UNION_CODE";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> type = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            LOGGER.info("=====增强方法执行之前=====");
            //向request中写入标识 todo
            request.setAttribute("demo-index", "sky-demo-sky-demo");
            LOGGER.info("=====增强方法执行之后=====");
            //标识类和方法
            if (type.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_UNION_CODE, type.getAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESPONSE_UNION_CODE, method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
