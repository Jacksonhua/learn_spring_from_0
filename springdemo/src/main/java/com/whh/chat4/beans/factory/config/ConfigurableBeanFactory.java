package com.whh.chat4.beans.factory.config;

import com.whh.chat4.beans.factory.BeanFactory;
import com.whh.chat4.beans.factory.HierarchicalBeanFactory;
import com.whh.chat4.beans.factory.config.SingletonBeanRegistry;
import org.springframework.lang.Nullable;

/**
 * @description:
 * @author: Artermus wang on 2021-12-01 16:43
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    void setParentBeanFactory(BeanFactory parentBeanFactory) throws IllegalStateException;

    void setBeanClassLoader(@Nullable ClassLoader beanClassLoader);

    @Nullable
    ClassLoader getBeanClassLoader();

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
