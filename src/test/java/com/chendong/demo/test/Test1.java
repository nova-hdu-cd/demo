package com.chendong.demo.test;

import com.chendong.demo.common.utils.ProxyBuilder;

/**
 * @author dong.chen
 * @date 2021 09 03 9:25
 */
public class Test1 {

    public static void main(String[] args) {
        Person person = ProxyBuilder.of(Person::new).
                with(Person::setId, 1).
                with(Person::setName, "陈东").
                with(Person::setSpace, "unisoc.com").
                with(Person::add, "p1", "p2").
                build();
        System.out.println(person);
    }


}
