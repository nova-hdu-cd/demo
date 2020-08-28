package com.chendong.demo.controller


import spock.lang.Specification

class HelloControllerTest extends Specification {
    HelloController helloController = new HelloController()

    def "test index"() {
        String name = "xiaoming"

        when:
        String result = helloController.index(name)

        then:
        result == "hello world xiaoming"
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme