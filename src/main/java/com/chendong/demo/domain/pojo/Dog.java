package com.chendong.demo.domain.pojo;

import java.io.Serializable;

/**
 * 注解
 * PropertySource(value = "classpath:application.properties") ： 配置文件导入
 * Validated ： jsr303校验
 *
 * @author dong.chen
 */
//@Component
//@PropertySource(value = "classpath:application.properties")
//@Validated
public class Dog implements Serializable {

    private static final long serialVersionUID = 2998022943617058329L;
    /**
     * 取值
     */
    // @Value("${dog.name}")
    //@NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
