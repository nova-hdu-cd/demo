package com.chendong.demo.common.spring


import spock.lang.Specification

class UtilsTest extends Specification {

    def "test log"() {
        when:
        Utils.log("format", "args")

        then:
        true//todo - validate something
    }

    def "test sleep"() {
        when:
        Utils.sleep(0)

        then:
        false//todo - validate something
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme