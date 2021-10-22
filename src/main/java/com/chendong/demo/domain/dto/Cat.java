package com.chendong.demo.domain.dto;

import cn.hutool.aop.ProxyUtil;

/**
 * @author dong.chen
 * @date 2021 10 22 11:12
 */
public class Cat implements AnimalAction {

    @Override
    public String say() {
        return "miao miao miao";
    }

    public static void main(String[] args) {
        AnimalAction cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
        cat.say();
    }

}
