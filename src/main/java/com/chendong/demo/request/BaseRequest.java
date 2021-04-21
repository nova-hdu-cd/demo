package com.chendong.demo.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseRequest<T> {

    /**
     * 请求uuid
     */
    private String uuid;

    /**
     * projectId
     */
    private String projectId;

    /**
     * 业务id
     */
    private String clientEntryId;

    /**
     * unisocId
     */
    private String unisocId;

    /**
     * 请求名字
     */
    private String name;

    /**
     * 请求权限
     */
    private String nameSpace;

    /**
     * 自定义请求参数
     */
    private T reqParams;


}
