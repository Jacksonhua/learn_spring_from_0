package com.whh.chat3.factory.config;

/**
 * @description:
 * @author: Artermus wang on 2021-11-19 17:13
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例bean
     * @param beanName beanName
     * @return bean
     */
    Object getSingleBean(String beanName);

}
