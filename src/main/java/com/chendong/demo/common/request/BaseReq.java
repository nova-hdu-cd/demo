package com.chendong.demo.common.request;

import java.io.Serializable;

/**
 * 统一请求基类
 *
 * @author dong.chen
 */
public abstract class BaseReq implements Serializable {

    private static final long serialVersionUID = -981083822382133284L;

    /**
     * 请求uuid
     */
    private String uuid;

    /**
     * projectId
     */
    private String projectId;

    /**
     * 请求名字
     */
    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseReq() {
    }

    public BaseReq(String uuid, String projectId, String name) {
        this.uuid = uuid;
        this.projectId = projectId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "uuid='" + uuid + '\'' +
                ", projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
