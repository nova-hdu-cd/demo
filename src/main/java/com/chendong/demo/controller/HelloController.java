package com.chendong.demo.controller;

import com.chendong.demo.common.anotations.PermissionAnnotation;
import com.chendong.demo.request.BaseRequest;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.IndexRequest;
import com.chendong.demo.service.responce.IndexResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/1.0")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private IHelloService helloService;

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public IndexResponse returnName(@PathVariable String name) {

        //1.请求参数包装
        IndexRequest req = new IndexRequest();
        req.setName(name);

        //2.业务过程
        String returnName = helloService.returnName(req);

        //3..返回参数封装
        IndexResponse response = new IndexResponse();
        response.setResp(returnName);
        return response;
    }

    @PermissionAnnotation
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestBody BaseRequest<String> request) {
        log.info("请求参数->{}", request);
        return "{\"message\":\"SUCCESS\",\"code\":200}";
    }

}
