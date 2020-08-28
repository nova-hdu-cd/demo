package com.chendong.demo.dao;

import com.chendong.demo.BaseTest;
import com.chendong.demo.entity.XinyangUser;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author chendong
 * @date 2020/8/20 3:40 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Transactional
public class TESTUserDao extends BaseTest {

    @Resource
    private XinyangUserDao xinyangUserDao;

    @Test
    public void testInsert() {

        XinyangUser userDO = new XinyangUser();
        userDO.setUid("1");
        userDO.setUname("jjj");
        userDO.setMobile("12345678901");
        userDO.setNation("china");
        userDO.setCity("hangzhou");
        userDO.setSex(1);

        int insert = xinyangUserDao.insert(userDO);
        assert insert > 0;
    }

    @Test
    public void testDelete() {

        int insert = xinyangUserDao.deleteById(6);
        assert insert > 0;
    }

    @Test
    public void testUpdate() {
        XinyangUser userDO = new XinyangUser();
        userDO.setId(8l);
        userDO.setUid("1");
        userDO.setUname("lll");
        userDO.setMobile("12345678901");
        userDO.setNation("china");
        userDO.setCity("hangzhou");
        userDO.setSex(1);
        int update = xinyangUserDao.update(userDO);
        assert update > 0;
    }

}
