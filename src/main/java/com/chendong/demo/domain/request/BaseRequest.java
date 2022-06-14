package com.chendong.demo.domain.request;

import java.io.Serializable;

/**
 * 统一请求的基类
 *
 * @author dong.chen
 */
public abstract class BaseRequest implements Serializable {

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
    private String reqName;

    /**
     * 请求时间
     */
    private Long reqTime;

    public BaseRequest(String uuid, String projectId, String reqName) {
        this.uuid = uuid;
        this.projectId = projectId;
        this.reqName = reqName;
    }

    public Long getReqTime() {
        return reqTime;
    }

    public void setReqTime(Long reqTime) {
        this.reqTime = reqTime;
    }

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

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public BaseRequest() {}

    public BaseRequest(String uuid, String projectId, String reqName, Long reqTime) {
        this.uuid = uuid;
        this.projectId = projectId;
        this.reqName = reqName;
        this.reqTime = reqTime;
    }

    @Override
    public String toString() {
        return "BaseRequest{" + "uuid='" + uuid + '\'' + ", projectId='" + projectId + '\'' + ", name='" + reqName
            + '\'' + ", reqTime=" + reqTime + '}';
    }
}
