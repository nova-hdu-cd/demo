package com.chendong.demo.common.convert;

import com.chendong.demo.common.pojo.dto.TicketDTO;
import com.chendong.demo.common.pojo.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author dong.chen
 */
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
