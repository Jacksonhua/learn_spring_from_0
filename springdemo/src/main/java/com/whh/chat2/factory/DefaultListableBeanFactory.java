package com.whh.chat2.factory;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 16:43
 */
@Slf4j
public class DefaultListableBeanFactory extends  AbstractAutowireCapableBeanFactory {

    private Map<String,Object> objectMap = new ConcurrentHashMap<>();


    @Override
    public Object getBean(String name) {
        Object bean = objectMap.get(name);
        if (bean != null) {
            return bean;
        }
        bean = createBean(name, getBeanDefinition(name));
        log.info("添加到缓存");
        objectMap.put(name,bean);
        return bean;
    }
}
