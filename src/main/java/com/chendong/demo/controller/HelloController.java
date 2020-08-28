package com.chendong.demo.controller;

import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloReq;
import com.chendong.demo.service.request.IndexReq;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/")
public class HelloController {

    @Resource
    IHelloService helloService;

    @RequestMapping("/user/{name}")
    public String index(@PathVariable String name) {
        IndexReq req = new IndexReq();
        req.setName(name);
        return helloService.index(req);
    }

    @RequestMapping("/hello")
    public String hello(String name) {
        HelloReq req = new HelloReq();
        req.setName(name);
        return helloService.hello(req);
    }

}
