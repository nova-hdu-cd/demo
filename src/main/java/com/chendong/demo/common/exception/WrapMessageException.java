package com.chendong.demo.common.exception;

/**
 * 包装消息异常
 *
 * @ClassName WrapMessageException
 * @Description: 包装消息异常
 * @Author dong.chen
 * @Date 2021/4/22 11:20
 * @Version 1.0
 */
public class WrapMessageException extends RuntimeException {

    public WrapMessageException(String message) {
        super(message);
    }

    public WrapMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
