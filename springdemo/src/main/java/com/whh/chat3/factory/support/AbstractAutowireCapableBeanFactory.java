package com.whh.chat3.factory.support;

import com.whh.chat3.factory.config.BeanDefinition;
import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 16:38
 */
@Slf4j
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

//    private InstantiationStrategy strategy;

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            log.info("创建实例");
            bean = beanDefinition.getTargetClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("error :{}",e.getMessage(),e.getCause());
            throw new BeansException(e.getMessage());
        }
        addSingleBean(name,bean);
        return bean;
    }

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object... args) throws BeansException {
        log.info("动态创建实例");
        Object bean;
        bean = createBeanInstance(beanDefinition,name,args);
        return bean;
    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String name, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getTargetClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        //需要循环比对出构造函数集合与入参信息 args 的匹配情况，这里我们对比的方式比较简单，只是一个数量对比，
        // 而实际 Spring 源码中还需要比对入参类型，否则相同数量不同入参类型的情况，就会抛异常了。
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, name, constructorToUse, args);
    }

    private InstantiationStrategy getInstantiationStrategy() {
        //先提供一个默认的
        return new CglibSubclassingInstantiationStrategy();
    }
}
