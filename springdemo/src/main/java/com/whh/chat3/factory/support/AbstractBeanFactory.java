package com.whh.chat3.factory.support;


import com.whh.chat3.factory.BeanFactory;
import com.whh.chat3.factory.config.BeanDefinition;
import com.whh.chat3.factory.support.DefaultSingletonBeanRegistry;
import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 16:17
 */
@Slf4j
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        Object singleBean = getSingleBean(beanName);
        if(singleBean != null){
            return singleBean;
        }
        return createBean(beanName,getBeanDefinition(beanName));
    }
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        Object singleBean = getSingleBean(name);
        if(singleBean != null){
            return singleBean;
        }
        return createBean(name,getBeanDefinition(name),args);
    }
    /**
     * 根据 beanDefinition 创建bean
     * @param name
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition) throws BeansException;
    /**
     * 根据 beanDefinition 创建bean,有参构造函数
     * @param name
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String name, BeanDefinition beanDefinition,Object... args) throws BeansException;


    /**
     * 根据name获取bean 定义
     * @param name
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

}
