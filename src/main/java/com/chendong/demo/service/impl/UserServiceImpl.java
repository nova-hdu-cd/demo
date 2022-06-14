package com.chendong.demo.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.chendong.demo.dao.UserDao;
import com.chendong.demo.domain.entity.User;
import com.chendong.demo.service.IUserService;

import cn.hutool.json.JSONUtil;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public User selectUserById(Integer id) {
        User user = userDao.selectByPrimaryKey(id);

        log.info("user -> {}", JSONUtil.toJsonStr(user));

        return user;
    }
}
