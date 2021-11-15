package com.whh.chat2.factory;

import com.whh.chat2.BeanDefinition;
import com.whh.chat2.factory.support.DefaultDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 16:17
 */
@Slf4j
public abstract class AbstractBeanFactory extends DefaultDefinitionRegistry implements BeanFactory {



    protected abstract Object createBean(String name, BeanDefinition beanDefinition);



//    protected abstract BeanDefinition getBeanDefinition(String name);

}
