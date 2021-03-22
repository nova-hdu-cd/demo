package com.chendong.demo.test;

import com.chendong.demo.BaseTest;
import com.chendong.demo.controller.dto.UserDTO;
import com.chendong.demo.core.XinyangUserDao;
import com.chendong.demo.core.entity.XinyangUser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
public class DemoApplicationTests extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Resource
    private XinyangUserDao xinyangUserDao;

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
        XinyangUser xinyangUser = new XinyangUser();
        xinyangUser.setUid("181040070");
        xinyangUser.setUname("lihong");
        xinyangUser.setSex(0);
        xinyangUser.setMobile("15151515151");
        xinyangUser.setNation("henna");
        xinyangUser.setCity("shanghai");

        int num = xinyangUserDao.insert(xinyangUser);
        assert num > 0;
    }

    @Test
    public void selectAll() {
        XinyangUser xinyangUser = xinyangUserDao.queryById(2);
        log.info("=====================\n" + xinyangUser + "\n-=================");
    }

}
