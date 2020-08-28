package com.chendong.demo.service.impl

import com.chendong.demo.service.request.HelloReq
import com.chendong.demo.service.request.IndexReq
import spock.lang.Specification

class HelloServiceImplTest extends Specification {
    HelloServiceImpl helloServiceImpl = new HelloServiceImpl()

    def "test index"() {
        given:
        IndexReq req1 = new IndexReq("chendong", "male", "13526267562")

        when:
        String result = helloServiceImpl.index(req1)

        then:
        result == "chendong-male-13526267562"
    }

    def "test hello"() {
        when:
        String result = helloServiceImpl.hello(new HelloReq())

        then:
        result == "replaceMeWithExpectedResult"
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme