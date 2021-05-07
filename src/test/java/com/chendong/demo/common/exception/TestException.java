package com.chendong.demo.common.exception;

import com.chendong.demo.common.enums.global.ArgumentEnum;
import com.chendong.demo.common.enums.global.ResponseEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * BusinessExceptionEnum的测试类
 *
 * @ClassName TestException
 * @Description: juint4测试类
 * @Author dong.chen
 * @Date 2021/4/22 13:46
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestException {

    @Test
    public void test1() {
        Good good = new Good("huahua", "111");
        good = null;

        ResponseEnum.BUSINESS_USER_EXCEPTION.assertNotNull(good);
    }

    @Test
    public void test2() {
        String str1 = "{code:1,msg:2}";
        String str2 = "{code:1,msg:2}";

        ArgumentEnum.PARAMETER_FAILURE.assertEquals(str1, str2);
    }


    public static class Good {
        private String name;
        private String height;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public Good(String name, String height) {
            this.name = name;
            this.height = height;
        }
    }
}
