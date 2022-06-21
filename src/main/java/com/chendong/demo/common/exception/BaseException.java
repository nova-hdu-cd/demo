package com.chendong.demo.common.exception;

import com.chendong.demo.common.constants.enums.global.IResponseEnum;

/**
 * 基础异常类，所有自定义异常类都需要继承本类
 *
 * @ClassName BaseException
 * @Description: 基本异常
 * @Author dong.chen
 * @Date 2021/4/22 11:12
 * @Version 1.0
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -5750000496238169199L;

    /**
     * 返回码
     */
    protected IResponseEnum responseEnum;

    /**
     * 异常消息参数
     */
    protected Object[] args;

    public BaseException(IResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.responseEnum = responseEnum;
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.responseEnum = new IResponseEnum() {
            @Override
            public int getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return msg;
            }
        };
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(message);
        this.responseEnum = responseEnum;
        this.args = args;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.responseEnum = responseEnum;
        this.args = args;
    }

}
