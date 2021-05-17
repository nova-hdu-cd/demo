package com.chendong.demo.service.impl;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.core.DemoUserDao;
import com.chendong.demo.core.XingUserDao;
import com.chendong.demo.core.entity.User;
import com.chendong.demo.service.IHelloService;
import com.chendong.demo.service.request.HelloBaseReq;
import com.chendong.demo.service.request.IndexBaseReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Resource
    private DemoUserDao demoUserDao;
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

    @Override
    public User selectUserById(Integer id) {
        User user = demoUserDao.selectById(id);
        log.info("HelloServiceImpl.selectUserById: user -> [{}]", JSONUtil.toJsonStr(user));
        return user;

    }


}
