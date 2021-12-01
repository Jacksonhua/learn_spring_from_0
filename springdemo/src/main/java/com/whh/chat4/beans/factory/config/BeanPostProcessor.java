package com.whh.chat4.beans.factory.config;

import com.whh.exception.BeansException;

/**
 * @description:
 * @author: Artermus wang on 2021-12-01 17:16
 */
public interface BeanPostProcessor {

    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
    default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
