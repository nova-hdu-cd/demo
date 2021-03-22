package com.chendong.demo.service.request;

import com.chendong.demo.request.BaseRequest;

/**
 * @author chendong
 * @date 2020/6/19 5:01 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public class IndexRequest extends BaseRequest<String> {

    private String name;

    private String sex;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "IndexReq{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
