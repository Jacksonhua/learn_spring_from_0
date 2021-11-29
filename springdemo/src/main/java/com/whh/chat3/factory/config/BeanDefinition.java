package com.whh.chat3.factory.config;


import com.whh.chat3.factory.PropertyValues;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 14:58
 */
@Slf4j
public class BeanDefinition {


    private PropertyValues propertyValues;

    private Class<?> targetClass;

    public BeanDefinition(Class<?> bean) {
        this.targetClass = bean;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> bean, PropertyValues propertyValues) {
        this.targetClass = bean;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

}
