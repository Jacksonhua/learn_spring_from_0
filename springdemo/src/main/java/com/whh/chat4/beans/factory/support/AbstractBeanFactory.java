package com.whh.chat4.beans.factory.support;

import com.whh.chat4.beans.factory.BeanFactory;
import com.whh.chat4.beans.factory.config.BeanDefinition;
import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 15:47
 */
@Slf4j
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        Object singletonBean = getSingletonBean(name);
        if(singletonBean != null) {
            return singletonBean;
        }
        log.info("缓存中没有，需要创建bean {}",name);
        return createBean(name,getBeanDefinition(name));
    }

    /**
     *
     * @param name
     * @param beanDefinition
     * @return
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String name);

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        Object singletonBean = getSingletonBean(name);
        if(singletonBean != null) {
            return singletonBean;
        }
        log.info("缓存中没有，需要创建bean {}",name);
        return createBean(name,getBeanDefinition(name),args);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args);

}
