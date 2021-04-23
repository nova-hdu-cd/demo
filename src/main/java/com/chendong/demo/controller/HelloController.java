package com.chendong.demo.controller;

import com.alibaba.fastjson.JSON;
import com.chendong.demo.common.anotations.PermissionAnnotation;
import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.common.pojo.Dog;
import com.chendong.demo.request.Req;
import com.chendong.demo.response.Resp;
import com.chendong.demo.response.RespError;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.IndexReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 基本的controller
 *
 * @author dong.chen
 */
@RestController
@RequestMapping(value = "/api/1.0/test")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private IHelloService helloService;

    /**
     * 成功返回示例
     *
     * @return
     */
    @ResponseResult//注意返回String的大坑，返回不能是String
    @GetMapping("/index")
    public Dog index() {
        Dog dog = new Dog();
        dog.setName("xiaohuang");
        log.info("index.dog -> {}", JSON.toJSONString(dog));
        return dog;
    }

    /**
     * 失败返回示例
     *
     * @return
     */
    @ResponseResult
    @GetMapping("/err")
    public RespError err() {
        RespError respError = new RespError();
        respError.setCode(-1);
        respError.setMessage("失败了");
        return respError;
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public Resp returnName(@PathVariable String name) {

        //1.请求参数包装
        IndexReq req = new IndexReq();
        req.setUname(name);

        //2.业务过程
        String returnName = helloService.returnName(req);

        Assert.isNull(returnName, "returnName为空!!!");

        //3..返回参数封装
        Resp response = new Resp();
        response.setData(returnName);
        return response;
    }

    @PermissionAnnotation
    @PostMapping("/request")
    public String hello(@RequestBody Req req) {
        log.info("HelloController.hello的request请求参数->{}", JSON.toJSON(req));
        return "{\"message\":\"SUCCESS\",\"code\":200}";
    }

}
