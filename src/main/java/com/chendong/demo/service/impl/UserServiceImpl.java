package com.chendong.demo.service.impl;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.mapper.ContenttagMapper;
import com.chendong.demo.mapper.UserMapper;
import com.chendong.demo.mapper.entity.User;
import com.chendong.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUserById(Integer id) {
        User user = userMapper.selectById(id);

        log.info("user -> {}", JSONUtil.toJsonStr(user));

        return user;
    }
}
