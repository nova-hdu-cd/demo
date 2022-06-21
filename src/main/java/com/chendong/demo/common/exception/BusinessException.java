package com.chendong.demo.common.exception;

import com.chendong.demo.common.constants.enums.global.IResponseEnum;

/**
 * 业务异常
 *
 * @ClassName BusinessException
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/22 12:22
 * @Version 1.0
 */
public class BusinessException extends BaseException {

    /**
     * 业务异常码
     *
     * @param responseEnum 业务异常码枚举
     */
    public BusinessException(IResponseEnum responseEnum) {
        super(responseEnum);
    }

    public BusinessException(int code, String msg) {
        super(code, msg);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public BusinessException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
