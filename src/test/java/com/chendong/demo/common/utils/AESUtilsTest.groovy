package com.chendong.demo.common.utils


import spock.lang.Specification

class AESUtilsTest extends Specification {

    def "test encrypt"() {
        when:
        String result = AESUtils.encrypt("data", "secretKey")

        then:
        result == "replaceMeWithExpectedResult"
    }

    def "test decrypt"() {
        when:
        String result = AESUtils.decrypt("encryptedData", "secretKey")

        then:
        result == "replaceMeWithExpectedResult"
    }

    def "test main"() {
        when:
        AESUtils.main(["args"] as String[])

        then:
        false//todo - validate something
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme