package com.chendong.demo.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.chendong.demo.BaseTest;
import com.chendong.demo.dao.UserDao;
import com.chendong.demo.domain.entity.User;

import cn.hutool.json.JSONUtil;

@Transactional
class UserDaoTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(UserDaoTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    void deleteByPrimaryKey() {}

    @Test
    void insert() {}

    @Test
    void insertSelective() {}

    @Test
    void selectByPrimaryKey() {
        User user = userDao.selectByPrimaryKey(1);
        log.info("================================");
        log.info("=========user======->{}", JSONUtil.toJsonStr(user));
        log.info("================================");
        Assertions.assertNotNull(user);
    }

    @Test
    void updateByPrimaryKeySelective() {}

    @Test
    void updateByPrimaryKey() {}
}