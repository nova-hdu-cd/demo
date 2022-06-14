package com.chendong.demo.service.request;

import com.chendong.demo.domain.request.BaseRequest;

/**
 * @author chendong
 * @date 2020/6/19 5:04 下午 To change this template use Appearance | Editor | File and Code Templates.
 */
public class HelloParamRequest extends BaseRequest {

    private String name;

    public String getUname() {
        return name;
    }

    public void setUname(String uname) {
        this.name = uname;
    }

    public HelloParamRequest() {
        super();
    }

    public HelloParamRequest(String uuid, String projectId, String name) {
        super(uuid, projectId, name);
    }

    public HelloParamRequest(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloReq{" + "name='" + name + '\'' + '}';
    }
}
