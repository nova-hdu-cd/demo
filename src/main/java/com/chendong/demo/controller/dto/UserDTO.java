package com.chendong.demo.controller.dto;

/**
 * @author chendong
 * @date 2020/6/5 9:47 上午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */

public class UserDTO extends BaseDTO {

    private String name;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
