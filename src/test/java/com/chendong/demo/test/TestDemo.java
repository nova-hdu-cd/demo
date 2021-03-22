package com.chendong.demo.test;

import com.chendong.demo.common.utils.DemoUtils;

public class TestDemo {
    public static void main(String[] args) {
        DemoUtils demoUtils = new DemoUtils.Builder()
                .withName("chendong")
                .withVersion("1.0")
                .withType("game")
                .build();
        System.out.println(demoUtils);
    }
}
