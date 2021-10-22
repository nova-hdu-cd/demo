package com.chendong.demo.test;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockTarget {

    public void soSth() {
        System.out.println("do sth");
    }

    public String sayHello() {
        return "Hello";
    }

    public String sayHello(String greetings) {
        return "Hello " + greetings;
    }

    public String callMethod(Object p) {
        return "callMethod " + p.toString();
    }

    public String callMethodWait(long million) {
        try {
            TimeUnit.MILLISECONDS.sleep(million);
        } catch (InterruptedException ignored) {
        }
        return "callMethod sleep " + million;
    }

    public Object callMethodWithException(Object p) {
        throw new IllegalStateException("测试异常");
    }

    @Test
    public void testWhenAndThen() {
        MockTarget mock = Mockito.mock(MockTarget.class);
        when(mock.sayHello()).thenReturn("mock hello");
        assertEquals(mock.sayHello(), "mock hello");

//        doCallRealMethod().when(mock).sayHello();
//        assertEquals(mock.sayHello(), "Hello");
//
//        when(mock.sayHello(anyString())).thenAnswer(Answers.CALLS_REAL_METHODS);
//        assertEquals(mock.sayHello("testRun"), "Hello testrun");
    }

    @Test
    public void testSayHello() throws Exception {
        MockTarget mock = Mockito.mock(MockTarget.class);
        when(mock.sayHello("world!")).thenReturn("hello world!");
        // assertEquals(mock.sayHello("world!"),"hello world!");

    }

}
