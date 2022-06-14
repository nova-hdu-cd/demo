package com.chendong.demo.domain.pojo;

/**
 * 手机实体类
 *
 * @ClassName Phone
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/22 9:55
 * @Version 1.0
 */
public class Phone {
    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Phone() {}

    public Phone(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Phone{" + "dog=" + dog + '}';
    }
}
