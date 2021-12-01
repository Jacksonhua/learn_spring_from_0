package com.whh.chat4.beans.factory.config;

import com.whh.chat4.beans.factory.ListableBeanFactory;
import com.whh.exception.BeansException;

/**
 * @description:
 * @author: Artermus wang on 2021-12-01 17:33
 */
public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory, ListableBeanFactory {

    /**
     * Ensure that all non-lazy-init singletons are instantiated, also considering
     * {@link org.springframework.beans.factory.FactoryBean FactoryBeans}.
     * Typically invoked at the end of factory setup, if desired.
     * @throws BeansException if one of the singleton beans could not be created.
     * Note: This may have left the factory with some beans already initialized!
     * Call {@link #destroySingletons()} for full cleanup in this case.
     * @see #destroySingletons()
     */
    void preInstantiateSingletons() throws BeansException;
}
