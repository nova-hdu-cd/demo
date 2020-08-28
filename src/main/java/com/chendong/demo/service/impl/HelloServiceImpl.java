package com.chendong.demo.service.impl;

import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloReq;
import com.chendong.demo.service.request.IndexReq;
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
    public String index(IndexReq req) {
        return req.getName() + "\n" + " hello world !";
    }

    @Override
    public String hello(HelloReq req) {
        return null;
    }
}
