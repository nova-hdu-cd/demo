package com.chendong.demo.common.response;

/**
 * 通用返回，建议使用new R<>();
 *
 * @ClassName CommonResponse
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/25 9:11
 * @Version 1.0
 */
public class CommonResponse<T> extends BaseResponse {

    protected T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResponse() {
        super();
    }

    public CommonResponse(Integer code, String message, T data) {
        super(code, message);
        this.data = data;
    }
}

