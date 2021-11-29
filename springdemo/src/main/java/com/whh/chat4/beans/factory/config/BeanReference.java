package com.whh.chat4.beans.factory.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @description: bean 依赖
 * @author: Artermus wang on 2021-11-29 15:39
 */
@Slf4j
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
