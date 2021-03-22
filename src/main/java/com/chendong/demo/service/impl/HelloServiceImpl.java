package com.chendong.demo.service.impl;

import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloRequest;
import com.chendong.demo.service.request.IndexRequest;
import org.springframework.stereotype.Service;

/**
 * @author chendong
 * @date 2020/6/19 4:25 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Service
public class HelloServiceImpl implements IHelloService {


    @Override
    public String returnName(IndexRequest req) {
        return req.getName() + "\n" + " hello world !";
    }

    @Override
    public String hello(HelloRequest req) {
        return null;
    }
}
