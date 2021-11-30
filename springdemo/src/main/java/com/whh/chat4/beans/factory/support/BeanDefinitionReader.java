package com.whh.chat4.beans.factory.support;

import com.whh.chat4.core.io.Resource;
import com.whh.chat4.core.io.ResourceLoader;
import com.whh.exception.BeansException;

/**
 * @description:
 * @author: Artermus wang on 2021-11-30 17:49
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    int loadBeanDefinitions(Resource resource) throws BeansException;

    int loadBeanDefinitions(Resource... resources) throws BeansException;

    int loadBeanDefinitions(String location) throws BeansException;

}
