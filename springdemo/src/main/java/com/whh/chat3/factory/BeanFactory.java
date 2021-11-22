package com.whh.chat3.factory;

import com.whh.exception.BeansException;

/**
 * @description:
 * @author: Artermus wang on 2021-11-15 15:04
 */

public interface BeanFactory {

    /**
     * 通过bean name 获取
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;
    /**
     * 通过bean name 获取，添加有参构造方法
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name,Object... args) throws BeansException;

}
