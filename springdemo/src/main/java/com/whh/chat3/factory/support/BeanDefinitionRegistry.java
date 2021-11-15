package com.whh.chat3.factory.support;


import com.whh.chat3.BeanDefinition;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 16:03
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName);

//    Object getSingleton(String beanName);

}
