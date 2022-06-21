package com.chendong.demo.common.constants.enums.global;

public enum ResultCode {

    /**
     * 成功状态码
     */
    SUCCESS(1, "请求成功"),

    /***
     * 失败状态码
     */
    FAIL(-1, "请求失败"),;

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
