package com.chendong.demo.test;

import com.chendong.demo.BaseTest;
import com.chendong.demo.common.pojo.dto.UserDTO;
import com.chendong.demo.dao.XingUserDao;
import com.chendong.demo.entity.XingUserDO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
public class DemoApplicationTests extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Resource
    private XingUserDao xingUserDao;

    @Test
    public void contextLoads() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uid", "1176213349");
        jsonObject.addProperty("name", "chendong");
        jsonObject.addProperty("sex", "male");
        System.out.println(jsonObject);

        //json数组转字符串数组
        Gson gson = new Gson();
        String jsonArray =
                "[\"https://github.com/leavesC\",\"https://www.jianshu.com/u/9df45b87cfdf\",\"Java\",\"Kotlin\",\"Git\",\"GitHub\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void testJackJson() {
//        User user = new User();
//        user.setName("陈东");
//        user.setId("1122");
//        System.out.println(user);
//
//        User user1 = new User("张3", "1122");
//        System.out.println(user1);
//
//        user1.test();

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId("213");
        System.out.println(userDTO2);

    }


    @Test
    public void testXinyangUserDemo() {
        XingUserDO xingUserDO = new XingUserDO();
        xingUserDO.setUid("181040070");
        xingUserDO.setUname("lihong");
        xingUserDO.setSex(0);
        xingUserDO.setMobile("15151515151");
        xingUserDO.setNation("henna");
        xingUserDO.setCity("shanghai");

        int num = xingUserDao.insert(xingUserDO);
        System.out.println(num);
        Assert.assertEquals(1, num);
    }

    @Test
    public void selectAll() {
        XingUserDO xingUserDO = xingUserDao.queryById(1);
        log.info("XingUserDO -> {}", xingUserDO);
    }

}
