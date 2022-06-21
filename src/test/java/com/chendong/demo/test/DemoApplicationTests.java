package com.chendong.demo.test;

import java.math.BigDecimal;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.chendong.demo.BaseTest;
import com.chendong.demo.common.utils.RedisUtil;
import com.chendong.demo.domain.dto.UserDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cn.hutool.json.JSONUtil;
import redis.clients.jedis.Jedis;

@Transactional
public class DemoApplicationTests extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("uid", "1176213349");
        jsonObject.addProperty("name", "chendong");
        jsonObject.addProperty("sex", "male");
        System.out.println(jsonObject);

        // json数组转字符串数组
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
        // User user = new User();
        // user.setName("陈东");
        // user.setId("1122");
        // System.out.println(user);
        //
        // User user1 = new User("张3", "1122");
        // System.out.println(user1);
        //
        // user1.test();

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setSex(706);
        userDTO2.setName("TUzbCZ");
        userDTO2.setId("hMTAKR");
        userDTO2.setCaller("AtYIXE");
        userDTO2.setProjectId("lsaqHW");
        userDTO2.setNamespace("nMsqZW");
        userDTO2.setClientEntryId("zCZBbK");

        System.out.println(userDTO2);

    }

    @Test
    public void testBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("0");
        BigDecimal bigDecimal1 = new BigDecimal("1000");
        bigDecimal = bigDecimal1;
        System.out.println(bigDecimal);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                break;
            }
            System.out.println(100);
        }
    }

    @Test
    public void testRedis() {
        Jedis jedis = redisUtil.getJedis();
        String ping = jedis.ping();
        log.info("[ping] -> {}", ping);

        Set<String> keys = jedis.keys("*");
        log.info("所有的keys:[]->{}", JSONUtil.toJsonStr(keys));
    }

}
