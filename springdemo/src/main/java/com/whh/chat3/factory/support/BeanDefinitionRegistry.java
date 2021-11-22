package com.whh.chat3.factory.support;


import com.whh.chat3.factory.config.BeanDefinition;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 16:03
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册 bean 定义
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);



}
