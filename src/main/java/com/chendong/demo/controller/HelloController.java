package com.chendong.demo.controller;

import com.alibaba.fastjson.JSON;
import com.chendong.demo.common.anotations.PermissionAnnotation;
import com.chendong.demo.common.anotations.ResponseResult;
import com.chendong.demo.common.pojo.Dog;
import com.chendong.demo.common.request.BaseReq;
import com.chendong.demo.common.response.Result;
import com.chendong.demo.common.response.ResultError;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.IndexBaseReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author dong.chen
 */
@RestController
@RequestMapping(value = "/hello/")
@Api(value = "测试接口", tags = {"测试接口"})
public class HelloController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private IHelloService helloService;

    /**
     * 成功返回示例
     *
     * @return
     */
    @ResponseResult
    @GetMapping("/index")
    @ApiOperation(value = "返回dog")
    public Dog index(@RequestAttribute("demo-index") String value) {

        log.info("request.value: -> {}", JSON.toJSONString(value));

        Dog dog = new Dog();
        dog.setName("xiaohuang111111");
        log.info("index.dog -> {}", JSON.toJSONString(dog));
        System.out.println("  " + dog + " ");
        return dog;
    }

    /**
     * 返回String,通过引入jackson的消息转换器解决
     *
     * @return
     */
    @ResponseResult
    @GetMapping("/helloWorld")
    @ApiOperation(value = "返回helloworld")
    public String helloWorld() {
        return "hello world!" + getIpAddress();
    }

    @ResponseResult
    @GetMapping("helloInt")
    @ApiOperation(value = "返回数字")
    public Integer helloInt() {
        return 40010;
    }


    /**
     * 失败返回示例
     *
     * @return
     */
    @GetMapping("/err")
    @ApiOperation(value = "失败返回接口")
    public ResultError<String> err() {
        ResultError<String> resultError = new ResultError<>();
        resultError.setErrorData("失败了");
        return resultError;
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "查找姓名")
    public Result<String> returnName(@PathVariable String name) {

        //1.请求参数包装
        IndexBaseReq req = new IndexBaseReq();
        req.setUname(name);

        //2.业务过程
        String returnName = helloService.returnName(req);

        Assert.isNull(returnName, "returnName为空!!!");

        //3..返回参数封装
        Result<String> response = new Result<>();
        response.setData(returnName);
        return response;
    }

    @PermissionAnnotation
    @PostMapping("/request")
    @ApiOperation(value = "需要权限的接口")
    public String hello(@RequestBody BaseReq baseReq) {
        log.info("HelloController.hello的request请求参数->{}", JSON.toJSON(baseReq));
        return "{\"message\":\"SUCCESS\",\"code\":200}";
    }

}
