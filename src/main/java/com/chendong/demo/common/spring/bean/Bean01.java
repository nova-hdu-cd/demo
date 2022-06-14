package com.chendong.demo.common.spring.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.chendong.demo.common.spring.Utils;

/**
 * Bean01() -> setApplicationContext(applicationContext) -> postConstruct() -> afterPropertiesSet() ->
 * onApplicationEvent(event)
 */
@Component
public class Bean01 implements InitializingBean, ApplicationContextAware, ApplicationListener<ApplicationEvent> {

    public Bean01() {
        Utils.log("【%s】 construct", getClassName());
    }

    @PostConstruct
    public void postConstruct() {
        Utils.log("【%s】 @PostConstruct", getClassName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Utils.log("【%s】 InitializingBean.afterPropertiesSet", getClassName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Utils.log("【%s】 ApplicationContextAware.setApplicationContext: 【%s】", getClassName(), applicationContext);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        Utils.log("【%s】 ApplicationListener.onApplicationEvent: 【%s】", getClassName(), event);
    }

    private String getClassName() {
        return this.getClass().getSimpleName();
    }
}
