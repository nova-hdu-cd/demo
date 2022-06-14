package com.chendong.demo.domain.pojo;

import java.io.Serializable;

/**
 * @ClassName People
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/29 13:04
 * @Version 1.0
 */
public class People implements Serializable {

    private static final long serialVersionUID = 5401108169063427514L;
    private String name;
    private Long age;
    private String location;
    private String carNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public People() {}

    public People(String name, Long age, String location, String carNum) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.carNum = carNum;
    }

    @Override
    public String toString() {
        return "People{" + "name='" + name + '\'' + ", age=" + age + ", location='" + location + '\'' + ", carNum='"
            + carNum + '\'' + '}';
    }
}
