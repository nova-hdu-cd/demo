package com.chendong.demo.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dong.chen
 */
public class BaseRequest implements Serializable {

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

    @Override
    public String toString() {
        return "BaseRequest{" +
                "uuid='" + uuid + '\'' +
                ", projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
