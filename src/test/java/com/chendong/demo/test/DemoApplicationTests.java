package com.chendong.demo.test;

import com.chendong.demo.BaseTest;
import com.chendong.demo.domian.entity.dto.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

class DemoApplicationTests extends BaseTest {

    @Test
    void contextLoads() {
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
    void testJackJson() {
//        User user = new User();
//        user.setName("陈东");
//        user.setId("1122");
//        System.out.println(user);
//
//        User user1 = new User("张3", "1122");
//        System.out.println(user1);
//
//        user1.test();

        User user2 = new User();
        user2.setId("213");
        System.out.println(user2);

    }

}
