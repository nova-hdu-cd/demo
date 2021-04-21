package com.chendong.demo.common.intercepter;

import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 重写返回体
 *
 * @author dong.chen
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    private static final String RESPONSE_UNION_CODE = "RESPONSE_UNION_CODE";

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseResultHandler.class);

    /**
     * 是否重请求包含了注解标记，没有就直接返回，不需要重写返回体
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESPONSE_UNION_CODE);
        return responseResult != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        LOGGER.info("进入返回体 重写格式 处理中。。。。。。");

        if (body instanceof Exception) {
            LOGGER.info("返回值 异常 作包装 处理中。。。。。。");
            return Response.fail(body);
        }
        return Response.success(body);
    }
}
