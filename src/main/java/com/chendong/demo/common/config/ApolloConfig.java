package com.chendong.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * @author dong.chen
 * @date 2021 07 22 19:49
 */
@EnableApolloConfig
@Configuration
public class ApolloConfig {

    @Value("${demo-test-key}")
    private String key;

    public String getkey() {
        return this.key;
    }

}
