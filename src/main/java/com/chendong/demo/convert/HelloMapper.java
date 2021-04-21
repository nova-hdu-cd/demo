package com.chendong.demo.convert;

import com.chendong.demo.controller.dto.TicketDTO;
import com.chendong.demo.controller.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HelloMapper {

    HelloMapper INSTANCE = Mappers.getMapper(HelloMapper.class);

    /**
     * 构建TicketDTO
     *
     * @param dto 用户dto
     * @return
     */
    TicketDTO toTicketDTO(UserDTO dto);
}
