package com.chendong.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
