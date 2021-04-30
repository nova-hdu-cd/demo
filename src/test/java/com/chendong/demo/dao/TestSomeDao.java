package com.chendong.demo.dao;

import com.chendong.demo.BaseTest;
import com.chendong.demo.common.pojo.Dog;
import com.chendong.demo.common.pojo.Person;
import com.chendong.demo.common.pojo.TestA;
import com.chendong.demo.core.XingUserDao;
import com.chendong.demo.core.entity.XingUserDO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Dao类测试 BaseTest BaseApplication
 *
 * @author chendong
 * @date 2020/8/20 3:40 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Transactional//使用事务，防止测试代码污染数据库
public class TestSomeDao extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestSomeDao.class);

    @Resource
    private Person person;

    @Resource
    private Dog dog;

    @Resource
    private XingUserDao xingUserDao;

    @Resource
    private TestA testA;

    @Test
    public void test() {
        log.info("打印出信息:{}", person);
    }

    @Test
    public void say() {
        String s = testA.say();
        log.info("===============测试:====================" + s);
    }

    @Test
    public void testInsert() {

        XingUserDO userDO = new XingUserDO();
        userDO.setUid("1");
        userDO.setUname("jjj");
        userDO.setMobile("12345678901");
        userDO.setNation("china");
        userDO.setCity("hangzhou");
        userDO.setSex(1);

        int insert = xingUserDao.insert(userDO);
        assert insert > 0;
    }

    @Test
    public void testDelete() {

        int insert = xingUserDao.deleteById(6);
        assert insert > 0;
    }

    @Test
    public void testUpdate() {
        XingUserDO userDO = new XingUserDO();
        userDO.setId(8L);
        userDO.setUid("1");
        userDO.setUname("lll");
        userDO.setMobile("12345678901");
        userDO.setNation("china");
        userDO.setCity("hangzhou");
        userDO.setSex(1);
        int update = xingUserDao.update(userDO);
        assert update > 0;
    }

}
