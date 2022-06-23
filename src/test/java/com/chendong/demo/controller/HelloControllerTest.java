package com.chendong.demo.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.chendong.demo.domain.response.Result;
import com.chendong.demo.domain.response.ResultError;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloParamRequest;

/**
 * Mock注释模拟相关对象。 InjectMocks注释允许将Mock创建的不同(和相关)模拟注入到基础对象中。
 */
@SpringBootTest
class HelloControllerTest {

    private static final Logger log = LoggerFactory.getLogger(HelloControllerTest.class);

    @Mock
    IHelloService helloService;

    @InjectMocks
    HelloController helloController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
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

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void testArticleService() throws ExecutionException, InterruptedException {
        System.out.println("start");
        long l = System.currentTimeMillis();

        List<CompletableFuture<Void>> res = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {

                testApi();

            });
            res.add(future);
        }

        CompletableFuture.allOf(res.toArray(new CompletableFuture[res.size()])).join();

        System.out.println("end: " + (System.currentTimeMillis() - l) / 1000);
    }

    private void testApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "bearer e3f0f929-878b-4224-8b55-2af09fdff3fb");

        Map<String, Object> param = new HashMap<>();
        param.put("month", 12);
        param.put("page", 100000);
        param.put("size", 100000);
        HttpEntity httpEntity = new HttpEntity(headers);

        ResponseEntity<String> response =
            restTemplate.exchange("http://qa-api.unisoc.com/api/v1/statistic/perfect?month=12&page=1&size=10000",
                HttpMethod.GET, httpEntity, String.class);
        System.out.println(response.getStatusCode() + ": " + response.getStatusCodeValue());
        System.out.println(response.getBody());
    }
}

// Generated with love by TestMe :) Please report issues and submit feature requests at:
// http://weirddev.com/forum#!/testme