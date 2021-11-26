package com.whh.chat3.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.whh.chat3.factory.PropertyValue;
import com.whh.chat3.factory.config.BeanDefinition;
import com.whh.chat3.factory.config.BeanReference;
import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 16:38
 */
@Slf4j
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy;

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            log.info("创建实例");
            bean = beanDefinition.getTargetClass().newInstance();
            applyPropertyValues(name,bean,beanDefinition);
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
        applyPropertyValues(name,bean,beanDefinition);
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
        //先提供一个默认的

        return getInstantiationStrategy().instantiate(beanDefinition, name, constructorToUse, args);
    }

    /**
     * 填充属性
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            List<PropertyValue> propertyValues = beanDefinition.getPropertyValues().getPropertyValueList();
            for (PropertyValue propertyValue : propertyValues) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    //有依赖关系
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }
        }catch (Exception e){
            throw new BeansException("Error setting property values：" + beanName,e);
        }


    }
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
