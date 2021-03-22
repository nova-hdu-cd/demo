package com.chendong.demo.service.request;

import com.chendong.demo.request.BaseRequest;

/**
 * @author chendong
 * @date 2020/6/19 5:04 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public class HelloRequest extends BaseRequest<String> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HelloReq{" +
                "name='" + name + '\'' +
                '}';
    }
}
