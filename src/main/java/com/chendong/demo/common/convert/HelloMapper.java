package com.chendong.demo.common.convert;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chendong.demo.domain.dto.InfoDTO;
import com.chendong.demo.domain.dto.TicketDTO;
import com.chendong.demo.domain.dto.UserDTO;

/**
 * MapStruct简化对象之间的转换
 *
 * @author dong.chen
 */
@Mapper(componentModel = "spring")
public interface HelloMapper {

    // 使用spring集成就不需要
    // HelloMapper INSTANCE = Mappers.getMapper(HelloMapper.class);

    /**
     * 构建TicketDTO
     *
     * @param dto 用户dto
     * @return
     */
    TicketDTO buildTicketDTO(UserDTO dto);

    List<TicketDTO> buildTicketDTOS(List<UserDTO> dtos);

    /**
     * 构建TicketDTO
     *
     * @param userDTO
     * @param infoDTO
     * @return
     */
    @Mapping(source = "userDTO.id", target = "id")
    @Mapping(source = "infoDTO.name", target = "name")
    TicketDTO buildTicketDTO(UserDTO userDTO, InfoDTO infoDTO);
}
