package com.whh.chat4.beans.factory;


import com.whh.exception.BeansException;

/**
 * @description:
 * @author: Artermus wang on 2021-11-29 15:30
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

    boolean containsBean(String name);

}
