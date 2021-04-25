package com.chendong.demo.common.enums.global;

/**
 * 异常返回码枚举接口
 *
 * @author dong.chen
 */
public interface IResponseEnum {
    /**
     * 获取返回码
     *
     * @return 返回码
     */
    int getCode();

    /**
     * 获取返回信息
     *
     * @return 返回信息
     */
    String getMessage();
}