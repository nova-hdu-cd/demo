package com.chendong.demo.test;

import com.chendong.demo.BaseTest;
import com.chendong.demo.common.convert.HelloMapper;
import com.chendong.demo.common.pojo.dto.InfoDTO;
import com.chendong.demo.common.pojo.dto.TicketDTO;
import com.chendong.demo.common.pojo.dto.UserDTO;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class TestDemo extends BaseTest {

    @Resource
    private HelloMapper helloConvert;

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
