package com.chendong.demo.controller;

import com.alibaba.fastjson.JSON;
import com.chendong.demo.common.anotations.PermissionAnnotation;
import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.common.exception.ResponseError;
import com.chendong.demo.common.pojo.Dog;
import com.chendong.demo.request.Request;
import com.chendong.demo.response.Response;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.IndexRequest;
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
        return dog;
    }

    /**
     * 失败返回示例
     *
     * @return
     */
    @ResponseResult
    @GetMapping("/err")
    public ResponseError err() {
        ResponseError responseError = new ResponseError();
        responseError.setCode(-1);
        responseError.setMessage("失败了");
        return responseError;
    }

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
    @PostMapping("/request")
    public String hello(@RequestBody Request request) {
        log.info("HelloController.hello的request请求参数->{}", JSON.toJSON(request));
        return "{\"message\":\"SUCCESS\",\"code\":200}";
    }

}
