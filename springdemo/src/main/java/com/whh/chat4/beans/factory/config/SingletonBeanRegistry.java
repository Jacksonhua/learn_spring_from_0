package com.whh.chat4.beans.factory.config;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 15:44
 */
public interface SingletonBeanRegistry {

    void registerSingleton(String beanName, Object singletonObject);

    Object getSingletonBean(String beanName);

//    void preInstantiateSingletons(String beanName);
}
