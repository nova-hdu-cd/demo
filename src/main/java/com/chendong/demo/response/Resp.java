package com.chendong.demo.response;

import com.chendong.demo.common.enums.global.ResultCode;

import java.io.Serializable;

/**
 * 基础返回类
 *
 * @author dong.chen
 */
public class Resp implements Serializable {

    private static final long serialVersionUID = 8814405497036160685L;

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回信息描述
     */
    private String message;

    /**
     * 返回内容
     */
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

    public Resp() {
    }

    /**
     * @param resultCode 结果返回码
     * @param data       数据
     */
    public Resp(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public void setCodeAndMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功返回
     *
     * @param data 数据
     * @return
     */
    public static Resp success(Object data) {
        Resp response = new Resp();
        response.setCodeAndMessage(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message());
        response.setData(data);
        return response;
    }

    public static Resp success() {
        Resp response = new Resp();
        response.setCodeAndMessage(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message());
        return response;
    }

    /**
     * 失败返回
     *
     * @param data 数据
     * @return
     */
    public static Resp fail(Object data) {
        Resp response = new Resp();
        response.setCodeAndMessage(ResultCode.FAIL.code(), ResultCode.FAIL.message());
        response.setData(data);
        return response;
    }

    public static Resp fail() {
        Resp response = new Resp();
        response.setCodeAndMessage(ResultCode.FAIL.code(), ResultCode.FAIL.message());
        return response;
    }

}
