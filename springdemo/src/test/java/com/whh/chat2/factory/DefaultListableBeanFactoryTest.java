package com.whh.chat2.factory;

import com.whh.chat2.BeanDefinition;
import com.whh.chat2.UserService;
import org.junit.Test;

public class DefaultListableBeanFactoryTest {

    @Test
    public void test_1(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //3. 第一次获取，需要创建实例
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryInfo();
        //4. 第二次获取，已经有缓存map不为null，可以直接获取
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryInfo();

    }

}
