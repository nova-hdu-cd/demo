package com.chendong.demo.common.anotations;

import java.lang.annotation.*;

/**
 * 权限注解
 *
 * @author dong.chen
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionAnnotation {
}

