package com.chendong.demo.common.enums;

import com.chendong.demo.common.exception.asserts.BusinessExceptionAssert;

/**
 * 业务异常枚举
 *
 * @author dong.chen
 */
public enum ResponseEnum implements BusinessExceptionAssert {

    //异常的罗列
    BUSINESS_EXCEPTION(10001, "系统异常"),
    BUSINESS_USER_EXCEPTION(10002, "用户异常"),
    BUSINESS_ROLE_EXCEPTION(10003, "角色异常"),
    BUSINESS_DEPARTMENT_EXCEPTION(10004, "部门异常");


    /**
     * 异常码
     */
    private final int code;

    /**
     * 异常信息
     */
    private final String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    ResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
