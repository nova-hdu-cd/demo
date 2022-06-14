package com.chendong.demo.service.request;

import com.chendong.demo.domain.request.BaseRequest;

/**
 * @author chendong
 * @date 2020/6/19 5:01 下午 To change this template use Appearance | Editor | File and Code Templates.
 */
public class IndexBaseRequest extends BaseRequest {

    private String uname;

    private String sex;

    private String phone;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public IndexBaseRequest() {}

    public IndexBaseRequest(String uname, String sex, String phone) {
        this.uname = uname;
        this.sex = sex;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "IndexRequest{" + "uName='" + uname + '\'' + ", sex='" + sex + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
