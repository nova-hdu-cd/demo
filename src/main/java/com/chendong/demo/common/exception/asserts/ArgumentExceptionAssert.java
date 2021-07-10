package com.chendong.demo.common.exception.asserts;

import com.chendong.demo.common.constants.enums.global.IResponseEnum;
import com.chendong.demo.common.exception.ArgumentException;
import com.chendong.demo.common.exception.BaseException;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * 参数异常类Assert
 *
 * @ClassName ArgumentExceptionAssert
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/22 15:50
 * @Version 1.0
 */
public interface ArgumentExceptionAssert extends IResponseEnum, Assert {
    @Override
    default BaseException newException(Object... args) {
        String message = this.getMessage();
        if (Objects.nonNull(args)) {
            message = MessageFormat.format(this.getMessage(), args);
        }
        return new ArgumentException(this, args, message);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String message = this.getMessage();
        if (Objects.nonNull(args)) {
            message = MessageFormat.format(this.getMessage(), args);
        }
        return new ArgumentException(this, args, message, t);
    }
}
