package com.chendong.demo.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.chendong.demo.BaseTest;
import com.chendong.demo.domain.entity.User;
import com.chendong.demo.domain.pojo.Dog;
import com.chendong.demo.domain.pojo.Person;
import com.chendong.demo.domain.pojo.TestA;

/**
 * Dao类测试 BaseTest BaseApplication
 *
 * @author chendong
 * @date 2020/8/20 3:40 下午 To change this template use Appearance | Editor | File and Code Templates.
 */
@Transactional // 使用事务，防止测试代码污染数据库
public class TestSomeDao extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestSomeDao.class);

    @Resource
    private Person person;

    @Resource
    private Dog dog;

    @Resource
    private TestA testA;

    @Resource
    private UserDao userDao;

    @Test
    public void testUerDao() {
        User user = new User();
        user.setAge(11);
        user.setName("chendong");

        int insert = userDao.insert(user);

        Assert.assertEquals(insert, insert > 0);
    }

    @Test
    public void test() {
        log.info("打印出信息:{}", person);
    }

    @Test
    public void say() {
        String s = testA.say();
        log.info("===============测试:====================" + s);
    }
}
