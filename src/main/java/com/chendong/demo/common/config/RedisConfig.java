package com.chendong.demo.common.config;

import com.chendong.demo.common.utils.RedisUtil;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dong.chen
 */
@Configuration
@EnableApolloConfig
public class RedisConfig {

    @Value("${spring.redis.host:disabled}")
    private String host;

    @Value("${spring.redis.port:0}")
    private int port;

    @Value("${spring.redis.database:0}")
    private int database;

    @Value("${redis.password}")
    private String password;

    @Bean
    public RedisUtil getRedisUtil() {
        String key = "disabled";
        if (key.equals(host)) {
            return null;
        }
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.initPool(host, port, password,database);
        return redisUtil;
    }

}