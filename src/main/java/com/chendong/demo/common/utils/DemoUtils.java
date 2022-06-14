package com.chendong.demo.common.utils;

/**
 * 构建者模式
 *
 * @author chendong
 * @date 2020/8/21 2:56 下午 To change this template use Appearance | Editor | File and Code Templates.
 */
public class DemoUtils {

    private String version;
    private String name;
    private String type;

    private DemoUtils() {}

    @Override
    public String toString() {
        return "DemoUtils{" + "version='" + version + '\'' + ", name='" + name + '\'' + ", type='" + type + '\'' + '}';
    }

    /**
     * 静态内部类Builder的属性与外部类一样,并提供一个build方法,对外 提供构造外部对象
     */
    public static class Builder {

        private String version;
        private String name;
        private String type;

        public Builder() {}

        public Builder withVersion(String version) {
            this.version = version;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public DemoUtils build() {
            DemoUtils utils = new DemoUtils();
            utils.name = this.name;
            utils.type = this.type;
            utils.version = this.version;
            return utils;
        }

    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        DemoUtils demoUtils = builder.withName("tool").withType("game").withVersion("1.00").build();
        System.out.println(demoUtils);

    }

}
