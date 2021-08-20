package com.chendong.demo.test;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.chendong.demo.BaseTest;
import com.chendong.demo.common.config.ApolloConfig;
import com.chendong.demo.common.convert.HelloMapper;
import com.chendong.demo.common.pojo.dto.InfoDTO;
import com.chendong.demo.common.pojo.dto.TicketDTO;
import com.chendong.demo.common.pojo.dto.UserDTO;
import com.chendong.demo.dao.DemoUserDao;
import com.chendong.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.*;

public class TestDemo extends BaseTest {

    @Resource
    private DemoUserDao demoUserDao;

    @Resource
    private HelloMapper helloConvert;

    @Resource
    private ApolloConfig apolloConfig;


    @Test
    public void testApollo() {
        String getkey = apolloConfig.getkey();
        System.out.println(getkey);
        String s = HttpUtil.get("https://bugzilla.unisoc.com/bugzilla/rest/bug?id=1,2,3&api_key=cwkyFK2tk0HtSxowELlCskxl7sDGVDWpQ4H40ajj");
        System.out.println(s);
    }

    @Test
    public void testHutools() {

        //将数组转换成json字符串，使用parseArray
        String[] str = {"hello", "world!"};
        JSONArray objects = JSONUtil.parseArray(str);
        System.out.println(objects);

        //parseObj不能转换list
        JSONObject jsonObject1 = JSONUtil.parseObj(Arrays.asList("hello", "world!"));
        System.out.println(jsonObject1);

        //将List转换成json字符串，使用parse
        JSON parse = JSONUtil.parse(Arrays.asList("hello", "world"));
        System.out.println(parse.toString());

        //将List转换成json字符串，也可以使用parseArray
        JSONArray objects1 = JSONUtil.parseArray(Arrays.asList("hello", "world"));
        System.out.println(objects1);

        //map和bean转换成json字符串，使用parseObj
        HashMap<Object, Object> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        JSONObject jsonObject = JSONUtil.parseObj(map);
        System.out.println(jsonObject);

    }

    @Test
    public void testOptional() {
        //1.返回一个空的Optional实例
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        System.out.println(empty == null);
        System.out.println(empty.isPresent());

        //2.返回特定的非空值Optional
        String name = "java";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt);

        //3.返回描述指定值的Optional，如果非空，则返回空值
        Optional<String> optional = Optional.ofNullable(null);
        System.out.println("optional -> " + optional);

        //4.如果存在值，则使用该值调用指定的使用者；否则，什么都不做
        Optional<String> javaDone = Optional.of("java done");
        javaDone.ifPresent(System.out::println);

        Optional<String> javaDone1 = Optional.ofNullable(null);
        javaDone1.ifPresent(System.out::println);

        //5.获取optional中的值
        Optional<String> s = Optional.ofNullable("hello world!!");
        String s1 = s.get();
        System.out.println(s1);

        //6.返回值（如果存在）；反之，返回其他
        System.out.println(Optional.ofNullable(null).orElse("default name"));
        System.out.println(Optional.ofNullable("hello world !!").orElse("default name"));

        //7.返回值（如果存在）；否则，调用other并返回该调用的结果。
        System.out.println(Optional.ofNullable(null).orElseGet(() -> "join"));
        System.out.println(Optional.ofNullable("hello world orElseGet!").orElseGet(() -> "join"));

        //8.map转换
        Optional<Student> student = Optional.ofNullable(queryById(11));
        String res = student.filter(student1 -> student1.getName().equals("chendong"))
                .map(Student::getName)
                .map(String::toUpperCase)
                .orElse("default");
        System.out.println("res -> " + res);


    }

    private Student queryById(Integer id) {
        Student student = new Student();
        student.setId("1176465654654");
        student.setName("chendong");
        student.setLocation("上海");
        return student;
    }

    private static class Student {
        private String id;
        private String name;
        private String location;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }

    @Test
    public void testUserMapper() {
        List<User> users = demoUserDao.selectList(null);
        System.out.println(users);
        Assert.assertEquals(5, users.size());
    }

    @Test
    public void textHelloConvert() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("10010");
        userDTO.setName("小红");
        TicketDTO ticketDTO = helloConvert.buildTicketDTO(userDTO);
        System.out.println(ticketDTO);

        InfoDTO infoDTO = new InfoDTO();
        infoDTO.setId(100010L);
        infoDTO.setName("小刚");
        TicketDTO ticketDTO1 = helloConvert.buildTicketDTO(userDTO, infoDTO);
        System.out.println(ticketDTO1);

        List<UserDTO> userDTOS = new ArrayList<>();
        userDTOS.add(userDTO);

        List<TicketDTO> ticketDTOS = helloConvert.buildTicketDTOS(userDTOS);
        System.out.println(ticketDTOS);

    }


}
