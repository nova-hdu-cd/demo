package com.chendong.demo.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本VO
 *
 * @ClassName BaseVO
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/22 9:56
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVO {

    /**
     * 工程id
     */
    private String projectId;

    /**
     * 命名空间
     */
    private String namespace;

    /**
     * 服务id
     */
    private String clientEntryId;

    /**
     * 紫光id
     */
    private String unisocId;

}
