package com.chendong.demo.service.impl;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.BaseTest;
import com.chendong.demo.core.XingUserDao;
import com.chendong.demo.core.entity.User;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloBaseReq;
import com.chendong.demo.service.request.IndexBaseReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

class HelloServiceImplTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(HelloServiceImplTest.class);

    @Mock
    XingUserDao xingUserDao;

    @InjectMocks
    HelloServiceImpl helloServiceImpl;

    @Autowired
    private IHelloService helloService;

    @Test
    void testSelectUserById() {
        User user = helloService.selectUserById(1);
        log.info("user -> [{}]", JSONUtil.toJsonStr(user));
        Assertions.assertNotNull(user);
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testXingUserDao() {
        int id = xingUserDao.deleteById(1);
        System.out.println(xingUserDao);
        Assertions.assertNotEquals(id, 1);
    }

    @Test
    void testReturnName() {
        String result = helloServiceImpl.returnName(new IndexBaseReq("uuid", "projectId", "name"));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testHello() {
        String result = helloServiceImpl.hello(new HelloBaseReq("uuid", "projectId", "name"));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme