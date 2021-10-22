package com.chendong.demo.test;

import java.util.HashMap;

public class Person {

    private Integer id;
    private String name;
    private String space;
    private final HashMap<String, String> gifts;

    public Person() {
        gifts = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public void add(String space1, String space2) {

        gifts.put(space1, space2);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", space='" + space + '\'' +
                ", gifts=" + gifts +
                '}';
    }
}