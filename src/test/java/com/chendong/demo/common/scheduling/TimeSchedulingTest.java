package com.chendong.demo.common.scheduling;

import com.chendong.demo.common.constants.DateFormatConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;

class TimeSchedulingTest {
    @Mock
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DateFormatConstant.HH_MM_SS);
    @InjectMocks
    TimeScheduling timeScheduling;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testReportCurTime() {
        timeScheduling.reportCurTime();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme