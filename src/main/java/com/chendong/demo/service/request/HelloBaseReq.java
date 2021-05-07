package com.chendong.demo.service.request;

import com.chendong.demo.common.request.BaseReq;

/**
 * @author chendong
 * @date 2020/6/19 5:04 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public class HelloBaseReq extends BaseReq {

    private String name;

    public String getUname() {
        return name;
    }

    public void setUname(String uname) {
        this.name = uname;
    }

    public HelloBaseReq() {
        super();
    }

    public HelloBaseReq(String uuid, String projectId, String name) {
        super(uuid, projectId, name);
    }

    public HelloBaseReq(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloReq{" +
                "name='" + name + '\'' +
                '}';
    }
}
