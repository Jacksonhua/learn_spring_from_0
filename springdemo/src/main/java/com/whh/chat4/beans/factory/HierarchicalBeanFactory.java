package com.whh.chat4.beans.factory;

import com.whh.chat4.beans.factory.BeanFactory;
import org.springframework.lang.Nullable;

/**
 * @description: 工厂分层。
 * @author: Artermus wang on 2021-12-01 16:37
 */
public interface HierarchicalBeanFactory extends BeanFactory {
    /**
     * Return the parent bean factory, or {@code null} if there is none.
     */
    @Nullable
    BeanFactory getParentBeanFactory();

    /**
     * Return whether the local bean factory contains a bean of the given name,
     * ignoring beans defined in ancestor contexts.
     * <p>This is an alternative to {@code containsBean}, ignoring a bean
     * of the given name from an ancestor bean factory.
     * @param name the name of the bean to query
     * @return whether a bean with the given name is defined in the local factory
     * @see BeanFactory#containsBean
     */
    boolean containsLocalBean(String name);
}
