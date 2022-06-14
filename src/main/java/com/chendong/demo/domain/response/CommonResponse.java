package com.chendong.demo.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 通用返回，建议使用new R<>();
 *
 * @ClassName CommonResponse
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/25 9:11
 * @Version 1.0
 */
@ApiModel(value = "返回包装类", description = "返回包装类")
public class CommonResponse<T> extends BaseResponse {

    @ApiModelProperty(value = "返回体", name = "data", example = "object", required = false)
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
