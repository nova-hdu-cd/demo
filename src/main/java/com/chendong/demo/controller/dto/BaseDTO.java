package com.chendong.demo.controller.dto;

public abstract class BaseDTO {

    /** 调用方 **/
    private String caller;

    /** 工程id **/
    private String projectId;

    /** 权限空间 **/
    private String namespace;

    /** 基础id **/
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
