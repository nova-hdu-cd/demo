package com.chendong.demo.common.utils;

import lombok.Data;

/**
 * @author chendong
 * @date 2020/8/21 2:56 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
@Data
public class DemoUtils {

    private String version;
    private String name;
    private String type;


    private DemoUtils() {
    }

    public boolean checkNumber() {
        return false;
    }

    public static final class DemoUtilsBuilder {

        private static DemoUtils demoUtils = new DemoUtils();

        public DemoUtilsBuilder withVersion(String version) {
            demoUtils.setVersion(version);
            return this;
        }

        public DemoUtilsBuilder withName(String name) {
            demoUtils.setVersion(name);
            return this;
        }

        public DemoUtilsBuilder withType(String type) {
            demoUtils.setVersion(type);
            return this;
        }
        
    }

    public static void main(String[] args) {
    }

}
