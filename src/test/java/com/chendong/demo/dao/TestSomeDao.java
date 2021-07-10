package com.chendong.demo.dao;

import com.alibaba.fastjson.JSON;
import com.chendong.demo.BaseTest;
import com.chendong.demo.common.pojo.Dog;
import com.chendong.demo.common.pojo.Person;
import com.chendong.demo.common.pojo.TestA;
import com.chendong.demo.mapper.ContenttagMapper;
import com.chendong.demo.mapper.UserMapper;
import com.chendong.demo.mapper.XingUserMapper;
import com.chendong.demo.mapper.entity.User;
import com.chendong.demo.mapper.entity.XingUserDO;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    private XingUserMapper xingUserMapper;

    @Resource
    private TestA testA;

    @Resource
    private UserMapper userMapper;

    @Test
    public void testUerDao() {
        User user = new User();
        user.setAge(11);
        user.setName("chendong");

        int insert = userMapper.insert(user);

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

    @Test
    public void testInsert() {

        XingUserDO userDO = new XingUserDO();
        userDO.setUid("1");
        userDO.setUname("jjj");
        userDO.setMobile("12345678901");
        userDO.setNation("china");
        userDO.setCity("hangzhou");
        userDO.setSex(1);

        int insert = xingUserMapper.insert(userDO);
        assert insert > 0;
    }

    @Test
    public void testDelete() {

        int insert = xingUserMapper.deleteById(6);
        assert insert > 0;
    }

    @Test
    public void testUpdate() {
        XingUserDO userDO = new XingUserDO();
        userDO.setId(2L);
        userDO.setUid("1");
        userDO.setUname("lll");
        userDO.setMobile("12345678901");
        userDO.setNation("china");
        userDO.setCity("hangzhou");
        userDO.setSex(1);
        int update = xingUserMapper.update(userDO);
        assert update > 0;
    }

    @Test
    public void queryAllByLimit() {

        List<XingUserDO> xingUserDOS = xingUserMapper.queryAllByLimit(0, 10, "uid desc");
        log.info("[分页查询结果] ->{}", JSON.toJSONString(xingUserDOS));
    }

}
