package com.chendong.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chendong.demo.domain.entity.User;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloParamRequest;
import com.chendong.demo.service.request.IndexBaseRequest;

/**
 * @author chendong
 * @date 2020/6/19 4:25 下午 To change this template use Appearance | Editor | File and Code Templates.
 */
@Service
public class HelloServiceImpl implements IHelloService {

    private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String returnName(IndexBaseRequest req) {
        return req.getUname() + "\n" + " hello world !";
    }

    @Override
    public String hello(HelloParamRequest req) {
        return null;
    }

    @Override
    public User selectUserById(Integer id) {
        return null;
    }

}
