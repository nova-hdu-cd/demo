package com.chendong.demo.controller.vo;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName EmpVO
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/25 15:50
 * @Version 1.0
 */
public class EmpVO extends BaseVO {

    @NotEmpty
    private String name;

    @NotBlank
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EmpVO() {
        super();
    }

    public EmpVO(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public EmpVO(String projectId, String namespace, String clientEntryId, String unisocId, String name, Integer age) {
        super(projectId, namespace, clientEntryId, unisocId);
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmpVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
