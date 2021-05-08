package com.chendong.demo.common.convert;

import com.chendong.demo.common.pojo.dto.InfoDTO;
import com.chendong.demo.common.pojo.dto.TicketDTO;
import com.chendong.demo.common.pojo.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * MapStruct简化对象之间的转换
 *
 * @author dong.chen
 */
@Mapper(componentModel = "spring")
public interface HelloMapper {

    //使用spring集成就不需要
    //HelloMapper INSTANCE = Mappers.getMapper(HelloMapper.class);

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
