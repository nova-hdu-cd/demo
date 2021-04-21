package com.chendong.demo.request;

public class BaseRequest<T> {

    /**
     * 请求id
     */
    private String id;

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
    private T requestValue;

    public T getRequestValue() {
        return requestValue;
    }

    public void setRequestValue(T requestValue) {
        this.requestValue = requestValue;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String uname) {
        this.name = uname;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nameSpace='" + nameSpace + '\'' +
                ", requestValue=" + requestValue +
                '}';
    }
}
