package com.chendong.demo.common.exception.asserts;

import java.text.MessageFormat;
import java.util.Objects;

import com.chendong.demo.common.enums.global.IResponseEnum;
import com.chendong.demo.common.exception.BaseException;
import com.chendong.demo.common.exception.BusinessException;

/**
 * 实现IAssert提供的可扩展方法newException(args)和newException(t,args)
 *
 * @ClassName BusinessExceptionAssert
 * @Description: BusinessException的Assert接口
 * @Author dong.chen
 * @Date 2021/4/22 12:19
 * @Version 1.0
 */
public interface BusinessExceptionAssert extends IResponseEnum, Assert {
    @Override
    default BaseException newException(Object... args) {
        String msg = this.getMessage();
        if (Objects.nonNull(args)) {
            msg = MessageFormat.format(this.getMessage(), args);
        }
        // 抛出自定义的业务异常
        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = this.getMessage();
        if (Objects.nonNull(args)) {
            msg = MessageFormat.format(this.getMessage(), args);
        }
        return new BusinessException(this, args, msg, t);
    }
}
