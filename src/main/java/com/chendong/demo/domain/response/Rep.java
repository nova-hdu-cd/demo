package com.chendong.demo.domain.response;

import lombok.Data;

@Data
public class Rep<T> {
    private int status;
    private String msg;
    private T data;
}