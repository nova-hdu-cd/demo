package com.chendong.demo.common.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基本VO
 *
 * @ClassName BaseVO
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/22 9:56
 * @Version 1.0
 */
@ApiModel(value = "基础视图类", description = "基础视图对象")
public class BaseVO {

    @ApiModelProperty(value = "工程id", name = "projectId", example = "10008611", required = true)
    private String projectId;

    @ApiModelProperty(value = "命名空间", name = "namespace", example = "rdrm", required = true)
    private String namespace;

    @ApiModelProperty(value = "服务id", name = "clientEntryId", example = "263566", required = true)
    private String clientEntryId;

    @ApiModelProperty(value = "紫光id", name = "unisocId", example = "12125", required = true)
    private String unisocId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getClientEntryId() {
        return clientEntryId;
    }

    public void setClientEntryId(String clientEntryId) {
        this.clientEntryId = clientEntryId;
    }

    public String getUnisocId() {
        return unisocId;
    }

    public void setUnisocId(String unisocId) {
        this.unisocId = unisocId;
    }

    public BaseVO() {
    }

    public BaseVO(String projectId, String namespace, String clientEntryId, String unisocId) {
        this.projectId = projectId;
        this.namespace = namespace;
        this.clientEntryId = clientEntryId;
        this.unisocId = unisocId;
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "projectId='" + projectId + '\'' +
                ", namespace='" + namespace + '\'' +
                ", clientEntryId='" + clientEntryId + '\'' +
                ", unisocId='" + unisocId + '\'' +
                '}';
    }
}
