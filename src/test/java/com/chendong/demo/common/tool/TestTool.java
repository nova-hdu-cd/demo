package com.chendong.demo.common.tool;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.chendong.demo.common.pojo.Dog;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @ClassName TestTool
 * @Description: TODO
 * @Author dong.chen
 * @Date 2021/4/23 11:18
 * @Version 1.0
 */
@SuppressWarnings("all")
public class TestTool {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestTool.class);

    private static final Map<String, Object> store = new HashMap<>();

    //md5加密和解密测试
    @Test
    void testHutool() {
        String sercet = "yuiyuyuoiuououououoddd";
        //md5工具加密
        String md5_sercet = SecureUtil.md5(sercet);

        LOGGER.info("md5_sercet -> {}", md5_sercet);
        //模拟放入数据库中
        store.put("chendong", md5_sercet);

        //模拟验证用户登录
        String result = checkUserInfo("chendong", md5_sercet);

        LOGGER.info("登录的状态 ->{}", result);

    }

    private String checkUserInfo(String username, String md5_password) {
        return store.get(username) == md5_password ? "ok" : "false";
    }

    @Test
    void testHutoolUUID() {
        //uuid使用工具类
        String uuid = IdUtil.simpleUUID();
        LOGGER.info("uuid -> {}", uuid);
    }

    @Test
    void testJSONUtils() {
        List<String> emp1 = Arrays.asList("chendong", "xiaoming");
        List<String> emp2 = Arrays.asList("zhangmeng", "xiaohong");
        List<List<String>> emps = new ArrayList<>();
        emps.add(emp1);
        emps.add(emp2);
        LOGGER.info("emps -> {}", emps);

        String jsonStr1 = JSONUtil.toJsonStr(emps);
        LOGGER.info("jsonStr1 ->{}", jsonStr1);

        String jsonStr = JSONUtil.toJsonStr(new Dog("xiao_huang"));
        LOGGER.info("jsonStr -> {}", jsonStr);

        //把一个json字符串转换成一个java对象，jsonStr->jsonObject->dog
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        LOGGER.info("jsonObject -> {}", jsonObject);
        Dog dog = JSONUtil.toBean(jsonObject, Dog.class);
        LOGGER.info("dog -> {}", dog);
        Dog dog1 = JSONUtil.toBean(jsonStr, Dog.class);
        LOGGER.info("dog1 -> {}", dog1);
        String json = new JSONObject().set("id", "chendong").toString();
        LOGGER.info("json -> {}", json);

        //将任意一个Java对象转化成json
        Object wrap = JSONUtil.wrap(dog, new JSONConfig());
        LOGGER.info("wrap -> {}", wrap);

        //对map进行排序
        Map<String, String> map = new HashMap<>();
        map.put("a", "chendong");
        map.put("b", "zhangming");
        TreeMap<String, String> sortedMap = MapUtil.sort(map);
        LOGGER.info(" sortedMap -> {}", sortedMap);

    }

}
