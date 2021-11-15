package com.whh.chat1;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 14:58
 */
@Slf4j
public class BeanDefinition {

    private Object object;

    public BeanDefinition(Object bean){
        this.object = bean;
    }

    public Object getBean(){
        return object;
    }



}
