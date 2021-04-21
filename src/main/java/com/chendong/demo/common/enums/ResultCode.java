package com.chendong.demo.common.enums;

public enum ResultCode {

    /**
     * 成功状态码
     */
    SUCCESS(1, "请求成功"),

    /***
     * 失败状态码
     */
    FAIL(-1, "请求失败"),

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

    USER_HAS_EXISTED(2005, "用户已存在");

    private int code;
    private String message;

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
