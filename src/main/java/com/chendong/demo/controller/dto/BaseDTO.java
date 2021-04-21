package com.chendong.demo.controller.dto;

import lombok.Data;

@Data
public class BaseDTO {

    /**
     * 调用方
     **/
    private String caller;

    /**
     * 工程id
     **/
    private String projectId;

    /**
     * 权限空间
     **/
    private String namespace;

    /**
     * 基础id
     **/
    private String clientEntryId;


}
