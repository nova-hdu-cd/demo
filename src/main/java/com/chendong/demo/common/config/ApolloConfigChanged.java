package com.chendong.demo.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

/**
 * ApolloConfigChanged实现了ApplicationContextAware接口，注入了ApplicationContext上下文对象
 *
 * @author dong.chen
 */
@Component
public class ApolloConfigChanged implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(ApolloConfigChanged.class);

    private ApplicationContext applicationContext;

    /**
     * 刷新的namespace的名字：devGroup.coupon.application
     * apollo自定义的几个namespace：{@link com.ctrip.framework.apollo.core.ConfigConsts} 已重写不需要配置value,默认所有的namespaces
     *
     * @param changeEvent
     */
    @ApolloConfigChangeListener("application")
    private void someChangeHandler(ConfigChangeEvent changeEvent) {
        log.info("【namespace】 -> {}", changeEvent.getNamespace());
        for (String changedKey : changeEvent.changedKeys()) {
            ConfigChange configChange = changeEvent.getChange(changedKey);
            String oldValue = configChange.getOldValue();
            String newValue = configChange.getNewValue();
            log.info("【changedKey】 -> {},【oldValue】 -> {}, 【newValue】 -> {}", changedKey, oldValue, newValue);
        }
        refreshProperties(changeEvent);
    }

    private void refreshProperties(ConfigChangeEvent changeEvent) {
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}