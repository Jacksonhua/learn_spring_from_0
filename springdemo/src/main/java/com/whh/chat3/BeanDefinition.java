package com.whh.chat3;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 14:58
 */
@Slf4j
public class BeanDefinition {



    private Class<?> aClass;

    public BeanDefinition(Class<?> bean){
        this.aClass = bean;
    }

    public Class<?> getaClass() {
        return aClass;
    }

    public void setaClass(Class<?> aClass) {
        this.aClass = aClass;
    }
}
