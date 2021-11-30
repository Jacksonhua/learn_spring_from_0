package com.whh.chat4.beans.factory.support;


import com.whh.chat4.beans.factory.config.BeanDefinition;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 16:42
 */

public interface BeanDefinitionRegistry {
    /**
     * 注册 bean 定义
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

    int getBeanDefinitionCount();
}
