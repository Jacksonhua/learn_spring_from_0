package com.whh.chat3.factory.support;

import com.whh.chat3.factory.config.BeanDefinition;
import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: jdk 实例化
 * @author: Artermus wang on 2021-11-19 18:19
 */
@Slf4j
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args)
            throws BeansException {
        Class<?> targetClass = beanDefinition.getTargetClass();
        try {
            if (ctor != null) {
                return targetClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return targetClass.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new BeansException(e.getMessage(), e);
        }
    }
}
