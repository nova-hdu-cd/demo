package com.chendong.demo.common.enums.global;

import com.chendong.demo.common.exception.asserts.BusinessExceptionAssert;

/**
 * 业务异常枚举
 *
 * @author dong.chen
 */
public enum ResponseEnum implements BusinessExceptionAssert {

    /**
     * 业务异常：10001-19999
     */
    BUSINESS_EXCEPTION(10001, "系统异常"),
    BUSINESS_USER_EXCEPTION(10002, "用户异常"),
    BUSINESS_ROLE_EXCEPTION(10003, "角色异常"),
    BUSINESS_DEPARTMENT_EXCEPTION(10004, "部门异常"),

    /**
     * 参数错误：1001-1999
     */
    PARAM_IS_INVALID(1001, "参数错误"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /**
     * 用户错误：2001-2999
     */
    USER_NOT_LOGGED_IN(2001, "用户未登录"),
    USER_LOGIN_Error(2002, "用户未登录"),
    USER_ACCOUNT_FORBIDDEN(2003, "用户被禁用"),
    USER_NOT_EXIST(2004, "用户不存在"),
    USER_HAS_EXISTED(2005, "用户已存在");;

    private final int code;

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
