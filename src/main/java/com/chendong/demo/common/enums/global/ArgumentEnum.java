package com.chendong.demo.common.enums.global;

import com.chendong.demo.common.exception.asserts.ArgumentExceptionAssert;

/**
 * 参数异常枚举
 *
 * @ClassName ArgumentEnum
 * @Description: 参数异常枚举
 * @Author dong.chen
 * @Date 2021/4/22 15:57
 * @Version 1.0
 */
public enum ArgumentEnum implements ArgumentExceptionAssert {

    PARAMETER_FAILURE(-10, "参数错误"),
    PARAMETER_MISSING(-11, "参数缺失"),
    ;

    private Integer code;
    private String msg;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.msg;
    }

    ArgumentEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
