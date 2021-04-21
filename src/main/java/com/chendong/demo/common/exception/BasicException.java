package com.chendong.demo.common.exception;

/**
 * 业务异常
 *
 * @author dong.chen
 */
public enum BasicException {

    BUSINESS_EXCEPTION(10001, "系统异常"),
    BUSINESS_USER_EXCEPTION(10002, "用户异常"),
    BUSINESS_ROLE_EXCEPTION(10003, "角色异常"),
    BUSINESS_DEPARTMENT_EXCEPTION(10004, "部门异常");
    /**
     * 异常码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;

    BasicException(String message) {
        this.message = message;
    }

    BasicException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
