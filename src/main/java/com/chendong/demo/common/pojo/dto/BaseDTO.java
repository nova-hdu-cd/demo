package com.chendong.demo.common.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基本DTO
 */
@ApiModel(value = "基本DTO")
public class BaseDTO {

    @ApiModelProperty("调用方")
    private String caller;

    @ApiModelProperty("工程id")
    private String projectId;

    @ApiModelProperty("权限空间")
    private String namespace;

    @ApiModelProperty("基础id")
    private String clientEntryId;

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

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

    public BaseDTO() {
    }

    public BaseDTO(String caller, String projectId, String namespace, String clientEntryId) {
        this.caller = caller;
        this.projectId = projectId;
        this.namespace = namespace;
        this.clientEntryId = clientEntryId;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "caller='" + caller + '\'' +
                ", projectId='" + projectId + '\'' +
                ", namespace='" + namespace + '\'' +
                ", clientEntryId='" + clientEntryId + '\'' +
                '}';
    }
}
