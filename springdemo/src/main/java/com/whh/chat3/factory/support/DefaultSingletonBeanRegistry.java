package com.whh.chat3.factory.support;

import com.whh.chat3.factory.config.SingletonBeanRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Artermus wang on 2021-11-19 17:16
 */
@Slf4j
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singletonBeanMap = new HashMap<>();

    @Override
    public Object getSingleBean(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    public void addSingleBean(String beanName,Object bean){
        singletonBeanMap.put(beanName,bean);
    }
}
