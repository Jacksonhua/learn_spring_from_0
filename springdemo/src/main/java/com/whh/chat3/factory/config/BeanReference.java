package com.whh.chat3.factory.config;

/**
 * @description:
 * @author: Artermus wang on 2021-11-26 14:10
 */
public class BeanReference {
    private String beanName;


    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
