package com.whh.chat4.beans.factory.config;

import com.whh.exception.BeansException;

/**
 * @description:
 * @author: Artermus wang on 2021-12-01 16:33
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *Modify the application context's internal bean factory after its standard initialization.
     *
     *All bean definitions will have been loaded, but no beans will have been instantiated yet.
     *  This allows for overriding or adding properties even to eager-initializing beans.
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
