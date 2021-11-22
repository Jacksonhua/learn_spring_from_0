package com.whh.chat3.factory.support;

import com.whh.chat3.factory.config.BeanDefinition;
import com.whh.exception.BeansException;

import java.lang.reflect.Constructor;

/**
 * @description: 实例化bean策略接口
 * @author: Artermus wang on 2021-11-19 18:17
 */
public interface InstantiationStrategy {
    /**
     * 实例化
     * @param beanDefinition
     * @param beanName
     * @param ctor
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
