package com.chendong.demo.test;

import com.chendong.demo.BaseTest;
import com.chendong.demo.common.convert.HelloMapper;
import com.chendong.demo.common.pojo.dto.TicketDTO;
import com.chendong.demo.common.pojo.dto.UserDTO;
import org.junit.Test;

import javax.annotation.Resource;

public class TestDemo extends BaseTest {

    @Resource
    private HelloMapper helloConvert;

    @Test
    public void textHelloConvert() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId("10010");
        TicketDTO ticketDTO = helloConvert.toTicketDTO(userDTO);
        System.out.println(ticketDTO);
    }
}
