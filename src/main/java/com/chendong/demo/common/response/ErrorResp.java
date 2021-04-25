package com.chendong.demo.common.response;

/**
 * 统一错误返回包装
 *
 * @author dong.chen
 */
public class ErrorResp extends BaseResponse {

    public ErrorResp() {
        super();
    }

    public ErrorResp(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "RespError{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
