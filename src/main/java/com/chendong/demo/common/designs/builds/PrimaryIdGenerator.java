package com.chendong.demo.common.designs.builds;

import cn.hutool.core.lang.generator.SnowflakeGenerator;

/**
 * @author dong.chen
 */
public final class PrimaryIdGenerator {

    private static final SnowflakeGenerator SNOWFLAKE_GENERATOR = new SnowflakeGenerator();

    private PrimaryIdGenerator() {
    }


    /**
     * 生成long型id
     *
     * @return
     */
    public static long generateLong() {
        return SNOWFLAKE_GENERATOR.next();
    }

    public static void main(String[] args) {
        System.out.println(generateLong());
    }

}
