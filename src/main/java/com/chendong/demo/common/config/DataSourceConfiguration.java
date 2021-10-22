package com.chendong.demo.common.config;

/**
 * @author dong.chen
 */

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.Set;

@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class DataSourceConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    private final static String DATASOURCE_TAG = "db";

    private static final String DATASOURCE_URL = "spring.datasource.url";

    private static final String DATASOURCE_USERNAME = "spring.datasource.username";

    private static final String DATASOURCE_PASSWORD = "spring.datasource.password";

    private static final String JDBC_DRIVER_NAME = "spring.datasource.driver-class-name";

    @Resource
    ApplicationContext context;

    @ApolloConfig
    Config config;

    @Bean("dataSource")
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource source = new DynamicDataSource();
        source.setTargetDataSources(Collections.singletonMap(DATASOURCE_TAG, dataSource()));
        return source;
    }

    @ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent changeEvent) {
        Set<String> changedKeys = changeEvent.changedKeys();
        if (changedKeys.contains(DATASOURCE_URL)) {
            DynamicDataSource source = context.getBean(DynamicDataSource.class);
            source.setTargetDataSources(Collections.singletonMap(DATASOURCE_TAG, dataSource()));
            source.afterPropertiesSet();
            logger.info("当前动态切换的数据源为 -> {}", config.getProperty(DATASOURCE_URL, ""));
        }
    }

    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(config.getProperty(DATASOURCE_URL, ""));
        dataSource.setUsername(config.getProperty(DATASOURCE_USERNAME, ""));
        dataSource.setPassword(config.getProperty(DATASOURCE_PASSWORD, ""));
        dataSource.setDriverClassName(config.getProperty(JDBC_DRIVER_NAME, ""));
        return dataSource;
    }

    static class DynamicDataSource extends AbstractRoutingDataSource {
        @Override
        protected Object determineCurrentLookupKey() {
            return DATASOURCE_TAG;
        }
    }
}