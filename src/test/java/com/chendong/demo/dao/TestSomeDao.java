package com.chendong.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.chendong.demo.BaseTest;

/**
 * Dao类测试 BaseTest BaseApplication
 *
 * @author chendong
 * @date 2020/8/20 3:40 下午 To change this template use Appearance | Editor | File and Code Templates.
 */
@Transactional // 使用事务，防止测试代码污染数据库
public class TestSomeDao extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestSomeDao.class);

}
