package com.chendong.demo.common.exception;

import com.chendong.demo.common.enums.global.IResponseEnum;

/**
 * 参数异常
 *
 * @ClassName ArgumentException
 * @Description: 参数异常
 * @Author dong.chen
 * @Date 2021/4/22 15:47
 * @Version 1.0
 */
public class ArgumentException extends BaseException {
    public ArgumentException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    public ArgumentException(int code, String msg) {
        super(code, msg);
    }

    public ArgumentException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public ArgumentException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
