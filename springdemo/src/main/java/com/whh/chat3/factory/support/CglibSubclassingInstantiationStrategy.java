package com.whh.chat3.factory.support;

import com.whh.chat3.factory.config.BeanDefinition;
import com.whh.exception.BeansException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @description:
 * @author: Artermus wang on 2021-11-22 16:00
 */
@Slf4j
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(beanDefinition.getTargetClass());
        //阅读 Spring 源码还会看到 CallbackFilter 等实现，不过我们目前的方式并不会影响创建。
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (null == ctor){
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
