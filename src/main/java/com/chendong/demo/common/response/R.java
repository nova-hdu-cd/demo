package com.chendong.demo.common.response;

import com.chendong.demo.common.enums.global.ResultCode;

/**
 * 统一正常返回包装类
 *
 * @author dong.chen
 */
public class R<T> extends CommonResponse<T> {

    public R() {
    }

    public R(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public void setCodeAndMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> R success(T data) {
        R<T> r = new R<>();
        r.setCodeAndMessage(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message());
        r.setData(data);
        return r;
    }

    public static <T> R success() {
        R<T> response = new R<>();
        response.setCodeAndMessage(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message());
        return response;
    }

    public static <T> R fail(T data) {
        R<T> response = new R<>();
        response.setCodeAndMessage(ResultCode.FAIL.code(), ResultCode.FAIL.message());
        response.setData(data);
        return response;
    }

    public static <T> R fail() {
        R<T> response = new R<>();
        response.setCodeAndMessage(ResultCode.FAIL.code(), ResultCode.FAIL.message());
        return response;
    }

}
