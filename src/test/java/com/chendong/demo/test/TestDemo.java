package com.chendong.demo.test;

import com.chendong.demo.BaseTest;
import com.chendong.demo.common.convert.HelloMapper;
import com.chendong.demo.common.pojo.dto.InfoDTO;
import com.chendong.demo.common.pojo.dto.TicketDTO;
import com.chendong.demo.common.pojo.dto.UserDTO;
import com.chendong.demo.mapper.DemoUserMapper;
import com.chendong.demo.mapper.entity.User;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestDemo extends BaseTest {

    @Resource
    private DemoUserMapper demoUserMapper;

    @Resource
    private HelloMapper helloConvert;

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
        List<User> users = demoUserMapper.selectList(null);
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
