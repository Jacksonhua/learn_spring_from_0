package com.whh.exception;

import com.whh.chat4.beans.factory.config.BeanDefinition;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Artermus wang on 2021-11-19 17:21
 */
@Slf4j
public class BeansException extends RuntimeException {
    public BeansException(String message){
        super(message);
    }
    public BeansException(BeansException message){
        super(message);
    }
    public BeansException(String message,Throwable e){
        super(message,e);
    }
}
