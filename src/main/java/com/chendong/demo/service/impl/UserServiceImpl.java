package com.chendong.demo.service.impl;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.dao.UserDao;
import com.chendong.demo.entity.User;
import com.chendong.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(Integer id) {
        User user = userDao.selectByPrimaryKey(id);

        log.info("user -> {}", JSONUtil.toJsonStr(user));

        return user;
    }
}
