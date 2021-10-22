package com.chendong.demo.common.enums.operation


import spock.lang.Specification

class OperationTest extends Specification {
    //Field PLUS of type Operation - was not mocked since Mockito doesn't mock enums
    //Field MINUS of type Operation - was not mocked since Mockito doesn't mock enums
    //Field TIMES of type Operation - was not mocked since Mockito doesn't mock enums
    //Field DIVIDE of type Operation - was not mocked since Mockito doesn't mock enums
    Operation operation = Operation.PLUS

    def "test apply"() {
        when:
        double result = operation.apply(0d, 0d)

        then:
        result == 0d
    }

    def "test main"() {
        when:
        Operation.main(["args"] as String[])

        then:
        false//todo - validate something
    }

    def "test values"() {
        when:
        Operation[] result = Operation.values()

        then:
        result == [Operation.PLUS] as Operation[]
    }

    def "test value Of"() {
        when:
        Operation result = Operation.valueOf("name")

        then:
        result == Operation.PLUS
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme