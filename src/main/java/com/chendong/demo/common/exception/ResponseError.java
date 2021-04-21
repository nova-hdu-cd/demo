package com.chendong.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回异常
 *
 * @author dong.chen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {

    private int code;
    private String message;
    private Object data;

}
