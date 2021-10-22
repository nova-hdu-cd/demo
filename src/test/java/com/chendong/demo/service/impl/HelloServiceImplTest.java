package com.chendong.demo.service.impl;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.BaseTest;
import com.chendong.demo.common.async.TestAsyncTask;
import com.chendong.demo.dao.XingUserDao;
import com.chendong.demo.domain.entity.User;
import com.chendong.demo.domain.entity.XingUserDO;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloParamRequest;
import com.chendong.demo.service.request.IndexBaseRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class HelloServiceImplTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(HelloServiceImplTest.class);

    @Mock
    XingUserDao xingUserDao;

    @InjectMocks
    HelloServiceImpl helloServiceImpl;

    @Autowired
    private IHelloService helloService;

    @Autowired
    private TestAsyncTask asyncTask;

    @Test
    void testAsync1() throws ExecutionException, InterruptedException {
        Future<List<String>> future = asyncTask.doTaskOne();
        asyncTask.doTaskFive();
        while (true) {
            if (future.isDone()) break;
        }
        log.info("[]->{}", future.get());
    }

    @Test
    void testAsync() {
        method1();
        method2();
        method3();
        //上述写法异步任务不生效
    }

    private void method3() {
        log.info("3333333333");
    }

    @Async("timeSchedulingExecutor")
    public void method2() {
        log.info("222222222222");
    }

    @Async("demoExecutor")
    public void method1() {
        log.info("111111111111111");
    }

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
        List<XingUserDO> xingUserDOS = xingUserDao.queryAll(null);
        log.info("[xingUserDOS]->{}", JSONUtil.toJsonStr(xingUserDOS));
        Assertions.assertNotNull(xingUserDOS);
    }

    @Test
    void testReturnName() {
        String result = helloServiceImpl.returnName(new IndexBaseRequest("uuid", "projectId", "name"));
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testHello() {
        String result = helloServiceImpl.hello(new HelloParamRequest("uuid", "projectId", "name"));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme