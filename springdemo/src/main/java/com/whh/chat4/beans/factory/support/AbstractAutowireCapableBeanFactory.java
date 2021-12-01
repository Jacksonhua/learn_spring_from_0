package com.whh.chat4.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.whh.chat4.beans.PropertyValue;
import com.whh.chat4.beans.factory.config.BeanReference;
import com.whh.chat4.beans.PropertyValues;
import com.whh.chat4.beans.factory.config.BeanDefinition;
import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 16:15
 */
@Slf4j
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private Map<String,Object> earlySingletonBeanMap = new HashMap<>();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) {
        Object o;
        log.info("创建实例");
        try {
            o = beanDefinition.getTargetClass().newInstance();
//           //前移，简单的解决循环依赖
            registerSingleton(name, o);
            applyPropertyValues(o, beanDefinition);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException(e.getMessage(), e);
        }
//        registerSingleton(name, o);
        return o;
    }

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition, Object[] args) {
        Object bean;
        //动态创建对象
        log.info("动态创建对象");
        bean = createBeanInstance(beanDefinition, args);
        applyPropertyValues(bean, beanDefinition);
        registerSingleton(name, bean);

        return bean;

    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) {

        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        List<PropertyValue> propertyValueList = propertyValues.getPropertyValueList();
        try {
            propertyValueList.forEach(propertyValue -> {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    value = getBean(((BeanReference) value).getBeanName());
                }
//                BeanUtil.setFieldValue(bean, name, value);
                Class<?> targetClass = beanDefinition.getTargetClass();
                try {
                    Field declaredField = targetClass.getDeclaredField(name);
                    setAccessible(declaredField);
                    declaredField.set(bean, value);
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new BeansException(e.getMessage(), e);
                }
            });
        } catch (BeansException e) {
            throw new BeansException(e);
        }

    }

    /**
     * 使用了jdk反射,可以使用cglib
     *
     * @param beanDefinition
     * @param args
     * @return
     */
    private Object createBeanInstance(BeanDefinition beanDefinition, Object[] args) {
        Class<?> targetClass = beanDefinition.getTargetClass();
        Constructor constructorUsed = null;
        Constructor<?>[] declaredConstructors = targetClass.getDeclaredConstructors();
        Object o;
        for (Constructor<?> constructor : declaredConstructors) {
            //需要循环比对出构造函数集合与入参信息 args 的匹配情况，这里我们对比的方式比较简单，只是一个数量对比，
            // 而实际 Spring 源码中还需要比对入参类型，否则相同数量不同入参类型的情况，就会抛异常了。
            if (null != args && constructor.getParameters().length == args.length) {
                constructorUsed = constructor;
                break;
            }
        }
        try {
            if (constructorUsed != null) {

//                o = constructorUsed.newInstance(args);
                Constructor<?> declaredConstructor = targetClass.getDeclaredConstructor(constructorUsed.getParameterTypes());
                o = declaredConstructor.newInstance(args);

            } else {
                return targetClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            throw new BeansException(e.getMessage(), e);
        }
        return o;
    }

    private Object cglibCreateBean(BeanDefinition beanDefinition, Constructor constructor, Object[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        enhancer.setSuperclass(beanDefinition.getTargetClass());
        return enhancer.create(constructor.getParameterTypes(), args);
    }
    public static <T extends AccessibleObject > T setAccessible(T accessibleObject) {
        if (null != accessibleObject && false == accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }
}
