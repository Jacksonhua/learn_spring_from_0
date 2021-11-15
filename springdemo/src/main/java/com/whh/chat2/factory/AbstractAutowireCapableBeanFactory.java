package com.whh.chat2.factory;

import com.whh.chat2.BeanDefinition;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 16:38
 */
@Slf4j
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            //创建实例
            log.info("创建实例");
            bean = beanDefinition.getaClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("error :{}",e.getMessage());
        }
        return bean;
    }


}
