package com.whh.chat4.beans.factory.support;

import com.whh.chat4.beans.factory.config.SingletonBeanRegistry;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 16:05
 */
@Slf4j
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    /** Cache of singleton objects created by FactoryBeans: FactoryBean name to object. */
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>(16);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        factoryBeanObjectCache.put(beanName,singletonObject);
    }

    @Override
    public Object getSingletonBean(String beanName) {
        return factoryBeanObjectCache.get(beanName);
    }
}
