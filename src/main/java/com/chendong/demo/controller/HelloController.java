package com.chendong.demo.controller;

import com.chendong.demo.common.anotations.PermissionAnnotation;
import com.chendong.demo.request.BaseRequest;
import com.chendong.demo.response.Response;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.IndexRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api/1.0/test")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private IHelloService helloService;

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public Response returnName(@PathVariable String name) {

        //1.请求参数包装
        IndexRequest req = new IndexRequest();
        req.setUname(name);

        //2.业务过程
        String returnName = helloService.returnName(req);

        Assert.isNull(returnName, "returnName为空!!!");

        //3..返回参数封装
        Response response = new Response();
        response.setData(returnName);
        return response;
    }

    @PermissionAnnotation
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String hello(@RequestBody BaseRequest<String> request) {
        log.info("请求参数->{}", request);
        return "{\"message\":\"SUCCESS\",\"code\":200}";
    }

}
