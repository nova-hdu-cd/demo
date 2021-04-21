package com.chendong.demo.response;

import com.chendong.demo.common.enums.ResultCode;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 基础返回类
 *
 * @author dong.chen
 */
public class Response implements Serializable {

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

    /**
     * 返回条数
     */
    private int totalNum;

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

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public Response() {
    }

    /**
     * @param resultCode 结果返回码
     * @param data       数据
     */
    public Response(ResultCode resultCode, Object data) {
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
     * @param data
     * @return
     */
    public static Response success(Object data) {
        Response response = new Response();
        response.setCodeAndMessage(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message());
        response.setData(data);
        return response;
    }

    public static Response success() {
        Response response = new Response();
        response.setCodeAndMessage(ResultCode.SUCCESS.code(), ResultCode.SUCCESS.message());
        return response;
    }

    /**
     * 失败返回
     *
     * @param data
     * @return
     */
    public static Response fail(Object data) {
        Response response = new Response();
        response.setCodeAndMessage(ResultCode.FAIL.code(), ResultCode.FAIL.message());
        response.setData(data);
        return response;
    }

    public static Response fail() {
        Response response = new Response();
        response.setCodeAndMessage(ResultCode.FAIL.code(), ResultCode.FAIL.message());
        return response;
    }

}
