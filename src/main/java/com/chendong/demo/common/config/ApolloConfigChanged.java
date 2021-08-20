package com.chendong.demo.common.config;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author dong.chen
 */
@Component
public class ApolloConfigChanged implements ApplicationContextAware {

    private static final Logger log = LoggerFactory.getLogger(ApolloConfigChanged.class);

    private ApplicationContext applicationContext;

    /**
     * 刷新的namespace的名字：devGroup.coupon.application
     * apollo自定义的几个namespace：{@link com.ctrip.framework.apollo.core.ConfigConsts}
     * 已重写不需要配置value,默认所有的namespaces
     *
     * @param changeEvent
     */
    @ApolloConfigChangeListener("application")
    private void someChangeHandler(ConfigChangeEvent changeEvent) {
        log.info("================Apollo 自动刷新值 开始 ===========================");

        for (String changedKey : changeEvent.changedKeys()) {

            ConfigChange configChange = changeEvent.getChange(changedKey);
            String oldValue = configChange.getOldValue();
            String newValue = configChange.getNewValue();
            log.info("【changedKey:{},oldValue={}, newValue:{}】", changedKey, oldValue, newValue);
        }

        refreshProperties(changeEvent);

        log.info("================Apollo 自动刷新值 结束 ===========================");
    }

    private void refreshProperties(ConfigChangeEvent changeEvent) {
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}