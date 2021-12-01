package com.whh.chat4.context;

import com.whh.exception.BeansException;

/**
 * @description:
 * @author: Artermus wang on 2021-12-01 16:25
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     * @throws BeansException s
     */
    void refresh() throws BeansException;

}
