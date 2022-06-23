package com.chendong.demo.core;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.chendong.demo.BaseTest;

@Transactional
class UserDaoTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(UserDaoTest.class);

    @Test
    void deleteByPrimaryKey() {}

    @Test
    void insert() {}

    @Test
    void insertSelective() {}

    @Test
    void updateByPrimaryKeySelective() {}

    @Test
    void updateByPrimaryKey() {}
}