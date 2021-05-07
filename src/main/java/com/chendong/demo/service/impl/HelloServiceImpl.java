package com.chendong.demo.service.impl;

import com.chendong.demo.core.XingUserDao;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloBaseReq;
import com.chendong.demo.service.request.IndexBaseReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chendong
 * @date 2020/6/19 4:25 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Resource
    private XingUserDao xingUserDao;

    @Override
    public String returnName(IndexBaseReq req) {
        return req.getUname() + "\n" + " hello world !";
    }

    @Override
    public String hello(HelloBaseReq req) {
        return null;
    }
}
