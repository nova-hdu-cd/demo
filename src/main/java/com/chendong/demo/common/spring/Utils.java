package com.chendong.demo.common.spring;

import java.time.LocalTime;

public class Utils {

    public static void log(String format, Object... args) {
        // 当前线程名称@线程id
        String threadName = Thread.currentThread().getName() + "@" + Thread.currentThread().getId();
        // 为了方便打印结果的查看，若线程名长度不足16，则补空格
        while (threadName.length() < 16) {
            threadName = threadName + " ";
        }
        // 当前时间 （时-分-秒）
        LocalTime now = LocalTime.now();
        String realFormat = String.format("[%s][%s] %s\n", threadName, now, format);
        System.out.printf(realFormat, args);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("sleep 中断异常: %s", e.getMessage());
        }
    }

}