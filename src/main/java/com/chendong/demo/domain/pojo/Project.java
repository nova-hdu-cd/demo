package com.chendong.demo.domain.pojo;


public class Project {
    /**
     * 工程id
     */
    private String projectId;

    /**
     * 领域空间
     */
    private String nameSpace;

    /**
     * 业务id
     */
    private String clientEntryId;

    /**
     * unisocId
     */
    private String unisocId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
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

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", nameSpace='" + nameSpace + '\'' +
                ", clientEntryId='" + clientEntryId + '\'' +
                ", unisocId='" + unisocId + '\'' +
                '}';
    }
}
