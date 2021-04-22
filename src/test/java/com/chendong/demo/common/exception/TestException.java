package com.chendong.demo.common.exception;

import com.chendong.demo.common.enums.ResponseEnum;
import org.junit.Test;

/**
 * BusinessExceptionEnum的测试类
 *
 * @ClassName TestException
 * @Description: 测试类
 * @Author dong.chen
 * @Date 2021/4/22 13:46
 * @Version 1.0
 */
public class TestException {



    @Test
    public void test() {
        String str = "ok";
        ResponseEnum.BUSINESS_EXCEPTION.assertNotEmpty(str);
    }

    @Test
    public void test1(){
        Good good = new Good("huahua","111");
        good = null;

        ResponseEnum.BUSINESS_USER_EXCEPTION.assertNotNull(good);
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
