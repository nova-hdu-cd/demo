package com.chendong.demo.common.exception;

/**
 * 统一返回异常
 *
 * @author dong.chen
 */
public class ResponseError {

    private int code;
    private String message;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseError() {
    }

    public ResponseError(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
