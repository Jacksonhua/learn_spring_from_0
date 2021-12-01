package com.whh.chat4.beans.factory.support;

import com.whh.chat4.core.io.DefaultResourceLoader;
import com.whh.chat4.core.io.Resource;
import com.whh.chat4.core.io.ResourceLoader;
import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * @description:
 * @author: Artermus wang on 2021-11-30 17:55
 */
@Slf4j
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.resourceLoader = new DefaultResourceLoader();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public int loadBeanDefinitions(Resource... resources) throws BeansException {
        Assert.notNull(resources, "Resource array must not be null");
        int count = 0;
        for (Resource resource : resources) {
            count += loadBeanDefinitions(resource);
        }
        return count;
    }

    @Override
    public int loadBeanDefinitions(String location) throws BeansException {
        Assert.notNull(location, "location must not be null");
        Resource resource = resourceLoader.getResource(location);
        return loadBeanDefinitions(resource);
    }
    @Override
    public int loadBeanDefinitions(String... location) throws BeansException {
        Assert.notNull(location, "location must not be null");
        int count = 0;
        for (String s : location) {
            Resource resource = resourceLoader.getResource(s);
            count = loadBeanDefinitions(resource);
        }

        return count;
    }
}
