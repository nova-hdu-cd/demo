package com.chendong.demo.domain.response;

import com.chendong.demo.common.constants.enums.global.ResultCode;

/**
 * 统一正常返回包装类
 *
 * @author dong.chen
 */
public class Result<T> extends CommonResponse<T> {

    public Result() {}

    public Result(Integer code, String message, T data) {
        super(code, message, data);
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public void setCodeAndMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCodeAndMessage(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success() {
        Result<T> response = new Result<>();
        response.setCodeAndMessage(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message());
        return response;
    }

    public static <T> Result<T> fail(T data) {
        Result<T> response = new Result<>();
        response.setCodeAndMessage(ResultCode.FAIL.code(), ResultCode.FAIL.message());
        response.setData(data);
        return response;
    }

    public static <T> Result<T> fail() {
        Result<T> response = new Result<>();
        response.setCodeAndMessage(ResultCode.FAIL.code(), ResultCode.FAIL.message());
        return response;
    }

}
