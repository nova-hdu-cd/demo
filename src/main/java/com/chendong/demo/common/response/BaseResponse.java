package com.chendong.demo.common.response;

import com.chendong.demo.common.enums.global.IResponseEnum;

import java.io.Serializable;

/**
 * 返回抽象类
 *
 * @ClassName BaseResponse
 * @Description: 返回抽象类
 * @Author dong.chen
 * @Date 2021/4/25 9:07
 * @Version 1.0
 */
public abstract class BaseResponse implements Serializable {

    private static final long serialVersionUID = 3142183360164460257L;

    protected Integer code;

    protected String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BaseResponse() {
    }

    public BaseResponse(IResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage());
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
