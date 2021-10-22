package com.chendong.demo.controller;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.domain.pojo.Dog;
import com.chendong.demo.domain.pojo.Person;
import com.chendong.demo.domain.response.Result;
import com.chendong.demo.domain.response.ResultError;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloParamRequest;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * Mock注释模拟相关对象。
 * InjectMocks注释允许将Mock创建的不同(和相关)模拟注入到基础对象中。
 */
class HelloControllerTest {

    private static final Logger log = LoggerFactory.getLogger(HelloControllerTest.class);

    @Mock
    IHelloService helloService;
    @Mock
    Dog mockDog;
    @Spy
    Dog dog;
    @InjectMocks
    Person person;
    @InjectMocks
    HelloController helloController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetDog() {
        Dog dog = helloController.getDog("小狗");
        log.info("testGetDog.[dog]->{}", JSONUtil.toJsonStr(dog));
        log.info("testGetDog.[dog]->{}", JSONUtil.toJsonStr(mockDog));
        Assertions.assertNotNull(dog);
    }

    @Test
    void testMockSpy() {
        System.out.println(mockDog);
        System.out.println(dog);
    }

    @Test
    void testInjectMocks() {
        Dog dog = person.getDog();
        System.out.println(dog);
        System.out.println(mockDog);
        Assertions.assertNotNull(dog);
    }

    @Test
    void testIndex() {
        Dog result1 = helloController.index("value");
        Dog result2 = helloController.index("value");
        Assertions.assertNotNull(result1);
    }

    @Test
    void testErr() {
        ResultError<String> result = helloController.err();
        Assertions.assertEquals(new ResultError<String>(0, "message"), result);
    }

    @Test
    void testReturnName() {
        when(helloService.returnName(any())).thenReturn("returnNameResponse");

        Result<String> result = helloController.returnName("name");
        Assertions.assertEquals(new Result<>(0, "message", new T()), result);
    }

    @Test
    void testHello() {
        String result = helloController.hello(new HelloParamRequest("uuid", "projectId", "name"));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme