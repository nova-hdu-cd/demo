package com.chendong.demo.core;

import cn.hutool.json.JSONUtil;
import com.chendong.demo.BaseTest;
import com.chendong.demo.mapper.ContenttagMapper;
import com.chendong.demo.mapper.UserMapper;
import com.chendong.demo.mapper.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class UserMapperTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;


    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByPrimaryKey() {
        User user = userMapper.selectById(1);
        log.info("================================");
        log.info("=========user======->{}", JSONUtil.toJsonStr(user));
        log.info("================================");
        Assertions.assertNotNull(user);
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }
}