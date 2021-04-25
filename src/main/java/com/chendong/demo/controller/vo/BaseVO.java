package com.chendong.demo.controller.vo;

/**
 * 基本VO
 *
 * @ClassName BaseVO
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/22 9:56
 * @Version 1.0
 */
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
