package com.chendong.demo.domain.response;

import com.chendong.demo.common.enums.global.ResultCode;

/**
 * 统一错误返回包装
 *
 * @author dong.chen
 */
public class ResultError<T> extends BaseResponse {

    private T errorData;

    public T getErrorData() {
        return errorData;
    }

    public void setErrorData(T errorData) {
        this.errorData = errorData;
    }

    public ResultError() {
        super();
    }

    public ResultError(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public ResultError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultError{" + "code=" + code + ", message='" + message + '\'' + ", errorData=" + errorData + '}';
    }
}
