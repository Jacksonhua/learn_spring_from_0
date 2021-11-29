package com.whh.chat3.factory;

import com.whh.beans.UserServiceV1;
import com.whh.chat3.factory.config.BeanDefinition;
import com.whh.chat3.factory.support.DefaultListableBeanFactory;
import com.whh.exception.BeansException;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DefaultListableBeanFactoryTest {

    @Test
    public void test() {
        // 1.初始化 BeanFactory
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserServiceV1.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 没有午餐构造函数，所以要报错
//        assertThatThrownBy(() -> beanFactory.getBean("userService")).isInstanceOf(BeansException.class)
//                .hasMessage("com.whh.beans.UserServiceV1");
    }


}
