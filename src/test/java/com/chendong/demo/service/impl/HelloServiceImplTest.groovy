package com.chendong.demo.service.impl

import com.chendong.demo.service.request.HelloRequest
import com.chendong.demo.service.request.IndexRequest
import spock.lang.Specification

class HelloServiceImplTest extends Specification {
    HelloServiceImpl helloServiceImpl = new HelloServiceImpl()

    def "test index"() {
        given:
        IndexRequest req1 = new IndexRequest("chendong", "male", "13526267562")

        when:
        String result = helloServiceImpl.index(req1)

        then:
        result == "chendong-male-13526267562"
    }

    def "test hello"() {
        when:
        String result = helloServiceImpl.hello(new HelloRequest())

        then:
        result == "replaceMeWithExpectedResult"
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme