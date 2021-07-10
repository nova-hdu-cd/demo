package com.chendong.demo.test;


import ch.qos.logback.classic.LoggerContext;
import com.chendong.demo.mapper.entity.UserDO;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggerTest {

    private Logger logger;

    @Before
    public void init() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        logger = LoggerFactory.getLogger(LoggerTest.class);
    }


    @Test
    public void testLogger() {
        logger.info("info hello world!");
        logger.warn("warn hello world!");
        logger.error("error hello world!");
    }

    @Test
    public void testLombok() {
        UserDO userDO = new UserDO();
        userDO.setId("11111");
        System.out.println(userDO);
    }

}
