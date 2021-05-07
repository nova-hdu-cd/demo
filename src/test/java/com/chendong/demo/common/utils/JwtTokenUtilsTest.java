package com.chendong.demo.common.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class JwtTokenUtilsTest {
    @InjectMocks
    JwtTokenUtils jwtTokenUtils;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreate() {
        String result = JwtTokenUtils.create("name", "value");
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testVerify() {
        boolean result = JwtTokenUtils.verify("token", "name");
        Assertions.assertEquals(true, result);
    }

    @Test
    void testMain() {
        JwtTokenUtils.main(new String[]{"args"});
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme