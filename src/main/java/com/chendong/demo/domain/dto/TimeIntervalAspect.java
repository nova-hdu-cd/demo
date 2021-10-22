package com.chendong.demo.domain.dto;

import cn.hutool.aop.aspects.SimpleAspect;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;

import java.lang.reflect.Method;

/**
 * 计时切面
 *
 * @author dong.chen
 */
public class TimeIntervalAspect extends SimpleAspect {

    /**
     * TimeInterval为Hutool实现的一个计时器
     **/
    private final TimeInterval interval = new TimeInterval();

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        interval.start();
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args, Object returnVal) {
        Console.log("Method [{}.{}] execute spend [{}]ms",
                target.getClass().getName(), method.getName(), interval.intervalMs());
        return true;
    }
}