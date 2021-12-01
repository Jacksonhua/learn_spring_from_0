package com.whh.chat4.beans.factory;

import com.whh.exception.BeansException;
import org.springframework.lang.Nullable;

import java.util.Map;

/**
 * @description:
 * @author: Artermus wang on 2021-12-01 17:13
 */

public interface ListableBeanFactory extends BeanFactory {
    boolean containsBeanDefinition(String beanName);

    <T> Map<String, T> getBeansOfType(@Nullable Class<T> type) throws BeansException;
}
