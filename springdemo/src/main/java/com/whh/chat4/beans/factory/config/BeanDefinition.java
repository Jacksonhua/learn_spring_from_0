package com.whh.chat4.beans.factory.config;

import com.whh.chat4.beans.PropertyValues;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 简单的bean定义
 * @author: Artermus wang on 2021-11-29 15:17
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
