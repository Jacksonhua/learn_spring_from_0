package com.whh.chat3.factory.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 14:58
 */
@Slf4j
public class BeanDefinition {



    private Class<?> targetClass;

    public BeanDefinition(Class<?> bean){
        this.targetClass = bean;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

}
