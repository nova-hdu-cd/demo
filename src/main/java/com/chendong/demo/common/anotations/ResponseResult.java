package com.chendong.demo.common.anotations;

import java.lang.annotation.*;

/**
 * 统一返回体装饰注解@ResponseResult
 *
 * @author dong.chen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface ResponseResult {
}
