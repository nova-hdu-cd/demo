package com.chendong.demo.common.convert

import com.chendong.demo.domain.dto.InfoDTO
import com.chendong.demo.domain.dto.TicketDTO
import com.chendong.demo.domain.dto.UserDTO
import spock.lang.Specification

class HelloMapperImplTest extends Specification {
    HelloMapperImpl helloMapperImpl = new HelloMapperImpl()

    def "test build Ticket DTO"() {
        when:
        TicketDTO result = helloMapperImpl.buildTicketDTO(new UserDTO(sex: 0, name: "name", id: "id"))

        then:
        result == new TicketDTO("caller", "projectId", "namespace", "clientEntryId", "name", "id", 0)
    }

    def "test build Ticket DTOS"() {
        when:
        List<TicketDTO> result = helloMapperImpl.buildTicketDTOS([new UserDTO(sex: 0, name: "name", id: "id")])

        then:
        result == [new TicketDTO("caller", "projectId", "namespace", "clientEntryId", "name", "id", 0)]
    }

    def "test build Ticket DTO 2"() {
        when:
        TicketDTO result = helloMapperImpl.buildTicketDTO(new UserDTO(sex: 0, id: "id"), new InfoDTO("name", null))

        then:
        result == new TicketDTO("caller", "projectId", "namespace", "clientEntryId", "name", "id", 0)
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme