package com.chendong.demo.common.pojo;

import java.util.List;
import java.util.Map;

//@Component
//@ConfigurationProperties(prefix = "person")
public class Person {

    private String name;
    private Integer age;
    private List<Object> lists;
    private List<Object> lists1;
    private Map<String, Object> maps;
    private Dog dog;

    public Person() {
    }

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

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists1() {
        return lists1;
    }

    public void setLists1(List<Object> lists1) {
        this.lists1 = lists1;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lists=" + lists +
                ", lists1=" + lists1 +
                ", maps=" + maps +
                ", dog=" + dog +
                '}';
    }
}
