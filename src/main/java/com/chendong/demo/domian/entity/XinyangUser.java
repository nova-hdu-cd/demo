package com.chendong.demo.domian.entity;

import java.io.Serializable;

/**
 * (XinyangUser)实体类
 *
 * @author chendong
 * @since 2020-08-20 17:16:50
 */
public class XinyangUser implements Serializable {
    private static final long serialVersionUID = -33024825038346176L;

    private Long id;
    /**
     * 业务主键id
     */
    private String uid;
    /**
     * 用户姓名
     */
    private String uname;
    /**
     * 用户性别 1:男 2:女
     */
    private Object sex;
    /**
     * 用户手机号
     */
    private String mobile;
    /**
     * 用户国家
     */
    private String nation;
    /**
     * 用户城市
     */
    private String city;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}